// Copyright 2018 The go-ethereum Authors
// This file is part of the go-ethereum library.
//
// The go-ethereum library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// The go-ethereum library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with the go-ethereum library. If not, see <http://www.gnu.org/licenses/>.

package enode

import (
	"crypto/ecdsa"
	"crypto/elliptic"
	"encoding/hex"
	"errors"
	"fmt"
	"math/big"
	"math/bits"
	"math/rand"
	"net"
	"strings"

	"github.com/AlayaNetwork/Alaya-Go/common/math"

	"github.com/AlayaNetwork/Alaya-Go/crypto"

	"github.com/AlayaNetwork/Alaya-Go/log"

	"github.com/AlayaNetwork/Alaya-Go/p2p/enr"
)

// Node represents a host on the network.
type Node struct {
	r  enr.Record
	id ID
}

// New wraps a node record. The record must be valid according to the given
// identity scheme.
func New(validSchemes enr.IdentityScheme, r *enr.Record) (*Node, error) {
	if err := r.VerifySignature(validSchemes); err != nil {
		return nil, err
	}
	node := &Node{r: *r}
	if n := copy(node.id[:], validSchemes.NodeAddr(&node.r)); n != len(ID{}) {
		return nil, fmt.Errorf("invalid node ID length %d, need %d", n, len(ID{}))
	}
	return node, nil
}

// ID returns the node identifier.
func (n *Node) ID() ID {
	return n.id
}

// Seq returns the sequence number of the underlying record.
func (n *Node) Seq() uint64 {
	return n.r.Seq()
}

// Incomplete returns true for nodes with no IP address.
func (n *Node) Incomplete() bool {
	return n.IP() == nil
}

// Load retrieves an entry from the underlying record.
func (n *Node) Load(k enr.Entry) error {
	return n.r.Load(k)
}

// IP returns the IP address of the node.
func (n *Node) IP() net.IP {
	var ip net.IP
	n.Load((*enr.IP)(&ip))
	return ip
}

// UDP returns the UDP port of the node.
func (n *Node) UDP() int {
	var port enr.UDP
	n.Load(&port)
	return int(port)
}

// UDP returns the TCP port of the node.
func (n *Node) TCP() int {
	var port enr.TCP
	n.Load(&port)
	return int(port)
}

// Pubkey returns the secp256k1 public key of the node, if present.
func (n *Node) Pubkey() *ecdsa.PublicKey {
	var key ecdsa.PublicKey
	if n.Load((*Secp256k1)(&key)) != nil {
		return nil
	}
	return &key
}

// IDv0 returns the node byte of the Pubkey.
func (n *Node) IDv0() IDv0 {
	var id IDv0
	pub := n.Pubkey()
	if pub == nil {
		log.Debug("this pub key is empty")
		return id
	}
	return PublicKeyToIDv0(pub)
}

// checks whether n is a valid complete node.
func (n *Node) ValidateComplete() error {
	if n.Incomplete() {
		return errors.New("incomplete node")
	}
	if n.UDP() == 0 {
		return errors.New("missing UDP port")
	}
	ip := n.IP()
	if ip.IsMulticast() || ip.IsUnspecified() {
		return errors.New("invalid IP (multicast/unspecified)")
	}
	// Validate the node key (on curve, etc.).
	var key Secp256k1
	return n.Load(&key)
}

// The string representation of a Node is a URL.
// Please see ParseNode for a description of the format.
func (n *Node) String() string {
	return n.v4URL()
}

// MarshalText implements encoding.TextMarshaler.
func (n *Node) MarshalText() ([]byte, error) {
	return []byte(n.v4URL()), nil
}

// UnmarshalText implements encoding.TextUnmarshaler.
func (n *Node) UnmarshalText(text []byte) error {
	dec, err := ParseV4(string(text))
	if err == nil {
		*n = *dec
	}
	return err
}

// ID is a unique identifier for each node.
type ID [32]byte

// Bytes returns a byte slice representation of the ID
func (n ID) Bytes() []byte {
	return n[:]
}

// ID prints as a long hexadecimal number.
func (n ID) String() string {
	return fmt.Sprintf("%x", n[:])
}

// The Go syntax representation of a ID is a call to HexID.
func (n ID) GoString() string {
	return fmt.Sprintf("enode.HexID(\"%x\")", n[:])
}

// TerminalString returns a shortened hex string for terminal logging.
func (n ID) TerminalString() string {
	return hex.EncodeToString(n[:8])
}

// MarshalText implements the encoding.TextMarshaler interface.
func (n ID) MarshalText() ([]byte, error) {
	return []byte(hex.EncodeToString(n[:])), nil
}

// UnmarshalText implements the encoding.TextUnmarshaler interface.
func (n *ID) UnmarshalText(text []byte) error {
	id, err := parseID(string(text))
	if err != nil {
		return err
	}
	*n = id
	return nil
}

// HexID converts a hex string to an ID.
// The string may be prefixed with 0x.
// It panics if the string is not a valid ID.
func HexID(in string) ID {
	id, err := parseID(in)
	if err != nil {
		panic(err)
	}
	return id
}

func parseID(in string) (ID, error) {
	var id ID
	b, err := hex.DecodeString(strings.TrimPrefix(in, "0x"))
	if err != nil {
		return id, err
	} else if len(b) != len(id) {
		return id, fmt.Errorf("wrong length, want %d hex chars", len(id)*2)
	}
	copy(id[:], b)
	return id, nil
}

// DistCmp compares the distances a->target and b->target.
// Returns -1 if a is closer to target, 1 if b is closer to target
// and 0 if they are equal.
func DistCmp(target, a, b ID) int {
	for i := range target {
		da := a[i] ^ target[i]
		db := b[i] ^ target[i]
		if da > db {
			return 1
		} else if da < db {
			return -1
		}
	}
	return 0
}

// LogDist returns the logarithmic distance between a and b, log2(a ^ b).
func LogDist(a, b ID) int {
	lz := 0
	for i := range a {
		x := a[i] ^ b[i]
		if x == 0 {
			lz += 8
		} else {
			lz += bits.LeadingZeros8(x)
			break
		}
	}
	return len(a)*8 - lz
}

// RandomID returns a random ID b such that logdist(a, b) == n.
func RandomID(a ID, n int) (b ID) {
	if n == 0 {
		return a
	}
	// flip bit at position n, fill the rest with random bits
	b = a
	pos := len(a) - n/8 - 1
	bit := byte(0x01) << (byte(n%8) - 1)
	if bit == 0 {
		pos++
		bit = 0x80
	}
	b[pos] = a[pos]&^bit | ^a[pos]&bit // TODO: randomize end bits
	for i := pos + 1; i < len(a); i++ {
		b[i] = byte(rand.Intn(255))
	}
	return b
}

var (
	ZeroIDv0 = MustHexIDv0(IDv0{}.String())
)

type IDv0 crypto.PubkeyBytes

// Bytes returns a byte slice representation of the NodeID
func (n IDv0) Bytes() []byte {
	return n[:]
}

// Pubkey returns the public key represented by the node ID.
// It returns an error if the ID is not a point on the curve.
func (n IDv0) Pubkey() (*ecdsa.PublicKey, error) {
	p := &ecdsa.PublicKey{Curve: crypto.S256(), X: new(big.Int), Y: new(big.Int)}
	half := len(n) / 2
	p.X.SetBytes(n[:half])
	p.Y.SetBytes(n[half:])
	if !p.Curve.IsOnCurve(p.X, p.Y) {
		return nil, errors.New("id is invalid secp256k1 curve point")
	}
	return p, nil
}

// TerminalString returns a shortened hex string for terminal logging.
func (n IDv0) TerminalString() string {
	return hex.EncodeToString(n[:8])
}

// PubkeyBytes prints as a long hexadecimal number.
func (n IDv0) String() string {
	return fmt.Sprintf("%x", n[:])
}

// MarshalText implements the encoding.TextMarshaler interface.
func (n IDv0) MarshalText() ([]byte, error) {
	return []byte(hex.EncodeToString(n[:])), nil
}

// UnmarshalText implements the encoding.TextUnmarshaler interface.
func (n *IDv0) UnmarshalText(text []byte) error {
	id, err := HexIDv0(string(text))
	if err != nil {
		return err
	}
	*n = id
	return nil
}

func (n *IDv0) ID() ID {
	pubkey, err := n.Pubkey()
	if err != nil {
		panic(err)
	}
	buf := make([]byte, 64)
	math.ReadBits(pubkey.X, buf[:32])
	math.ReadBits(pubkey.Y, buf[32:])
	var id ID
	copy(id[:], crypto.Keccak256(buf))
	return id
}

// MustBytesToIDv0 converts a byte slice to a PubkeyBytes.
// It panics if the byte slice is not a valid PubkeyBytes.
func MustBytesToIDv0(b []byte) IDv0 {
	id, err := BytesToIDv0(b)
	if err != nil {
		panic(err)
	}
	return id
}

// BytesToIDv0 converts a byte slice to a PubkeyBytes
func BytesToIDv0(b []byte) (IDv0, error) {
	var id IDv0
	if len(b) != len(id) {
		return id, fmt.Errorf("wrong length, want %d bytes", len(id))
	}
	copy(id[:], b)
	return id, nil
}

// PublicKeyToIDv0 returns a marshaled representation of the given public key.
func PublicKeyToIDv0(pub *ecdsa.PublicKey) IDv0 {
	var id IDv0
	pbytes := elliptic.Marshal(pub.Curve, pub.X, pub.Y)
	if len(pbytes)-1 != len(id) {
		panic(fmt.Errorf("need %d bit pubkey, got %d bits", (len(id)+1)*8, len(pbytes)))
	}
	copy(id[:], pbytes[1:])
	return id
}

// MustHexIDv0 converts a hex string to a NodeID.
// It panics if the string is not a valid NodeID.
func MustHexIDv0(in string) IDv0 {
	id, err := HexIDv0(in)
	if err != nil {
		panic(err)
	}
	return id
}

// HexID converts a hex string to a NodeID.
// The string may be prefixed with 0x.
func HexIDv0(in string) (IDv0, error) {
	var id IDv0
	b, err := hex.DecodeString(strings.TrimPrefix(in, "0x"))
	if err != nil {
		return id, err
	} else if len(b) != len(id) {
		return id, fmt.Errorf("wrong length, want %d hex chars", len(id)*2)
	}
	copy(id[:], b)
	return id, nil
}
