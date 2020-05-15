package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Uint64;
import com.platon.rlp.datatypes.Uint8;
import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.WasmFunctionEncoder;
import org.web3j.abi.datatypes.WasmFunction;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.WasmContract;
import org.web3j.tx.gas.GasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the org.web3j.codegen.WasmFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with platon-web3j version 0.9.1.2-SNAPSHOT.
 */
public class ReferenceDataTypeSetContract extends WasmContract {
    private static String BINARY_0 = "0x0061736d01000000014d0e60027f7f0060017f017f60017f0060037f7f7f017f60000060037f7f7f0060047f7f7f7f0060027f7f017f60047f7f7f7f017f60027f7e006000017f60027f7e017f60017e017f60017f017e02a9010703656e760c706c61746f6e5f70616e6963000403656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000a03656e7610706c61746f6e5f6765745f696e707574000203656e7617706c61746f6e5f6765745f73746174655f6c656e677468000703656e7610706c61746f6e5f6765745f7374617465000803656e7610706c61746f6e5f7365745f7374617465000603656e760d706c61746f6e5f72657475726e0000034c4b04040202020101030605000201010700010202020101040103050201000d020001010c000902000200090b04080101030703000003000002000001030100030802030501040401010600000405017001090905030100020608017f0141a08b040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300070f5f5f66756e63735f6f6e5f65786974003206696e766f6b65001d090e010041010b0809090b1112161a090a8a634b08001008104b104c0b3801017f41e008420037020041e808410036020041742100034020000440200041ec086a4100360200200041046a21000c010b0b4101100a0b0300010b940101027f41ec08410136020041f008280200220145044041f00841f80836020041f80821010b024041f40828020022024120460440418402101e2201450d012001104a220141f00828020036020041f008200136020041f4084100360200410021020b41f408200241016a360200200120024102746a22014184016a4100360200200141046a20003602000b41ec0841003602000bdb0101057f230041106b22022400200241850c3b000620024181848c20360002200041186a21030240200041206a280200450440200241026a21000c010b2003100c210103400240200241026a20046a21002001452004410646720d00200120002d00003a000d2001100d2003200241086a2001410d6a100e22052802004504402003200228020820052001100f0b200441016a210421010c010b0b2001450d000340200128020822010d000b0b200241086a210103402000200146450440200241086a200320001010200041016a21000c010b0b200241106a24000b3901027f200028020021012000200041046a36020020004100360208200028020420004100360204410036020820012802042200200120001b0b4c01027f2000280208220145044041000f0b02402000200128020022024604402001410036020020012802042200450d012000101c0f0b200141003602042002450d002002101c21010b20010b8d0101027f200041046a2103024020002802042200044020022d000021040240034002400240200420002d000d2202490440200028020022020d012001200036020020000f0b200220044f0d03200041046a210320002802042202450d01200321000b20002103200221000c010b0b2001200036020020030f0b200120003602000c010b200120033602000b20030ba40201027f20032001360208200342003702002002200336020020002802002802002201044020002001360200200228020021030b2003200320002802042205463a000c03400240024020032005460d00200328020822012d000c0d002001200128020822022802002204460440024020022802042204450d0020042d000c0d000c030b20032001280200470440200110182001280208220128020821020b200141013a000c200241003a000c200210190c010b02402004450d0020042d000c0d000c020b20032001280200460440200110192001280208220128020821020b200141013a000c200241003a000c200210180b2000200028020841016a3602080f0b2004410c6a200141013a000c200220022005463a000c41013a0000200221030c000b000b5501037f230041106b22032400200020012003410c6a2002100e22052802002204047f4100054110101b220420022d00003a000d2001200328020c20052004100f41010b3a000420002004360200200341106a24000b2201017f230041106b22022400200241086a200041186a20011010200241106a24000b2501017f2000411c6a2101200028021821000340200020014704402000101321000c010b0b0b2d01017f02402000280204220104402001101721000c010b0340200020002802082200280200470d000b0b20000b2601017f027f4100200041186a4103101522012000411c6a460d001a20012d000d0b41ff01710b6401057f200141ff01712105200041046a22032104200321000340200428020022020440200241046a200220022d000d20054922061b21042000200220061b21000c010b0b02402000200347044020002d000d200141ff01714d0d010b200321000b20000bbe0601057f0240200041186a220320012d0000101522022000411c6a460d00200220032802004604402003200210133602000b200041206a22012001280200417f6a3602002000411c6a2802002103027f0240024020022802002205450440200221010c010b20022802042200450440200221010c020b20001017220128020022050d010b200128020422050d004100210541000c010b2005200128020836020841010b02402001200128020822042802002200460440200420053602002001200346044041002100200521030c020b200428020421000c010b200420053602040b20012d000c4520012002470440200120022802082204360208200420022802082802002002474102746a20013602002002280200220420013602082001200436020020012002280204220436020420040440200420013602080b200120022d000c3a000c2001200320022003461b21030b200345720d00450440034020002d000c21020240200020002802082201280200470440024002402002450440200041013a000c200141003a000c2001101820002003200320002802002200461b2103200028020421000b20002802002202044020022d000c450d010b20002802042201044020012d000c450d020b200041003a000c0240200320002802082200460440200321000c010b20002d000c0d040b200041013a000c0f0b20002802042201044020012d000c450d010b200241013a000c200041003a000c200010192000280208220028020421010b2000200028020822002d000c3a000c200041013a000c200141013a000c200010180f0b02402002450440200041013a000c200141003a000c2001101920002003200320002802042200461b2103200028020021000b20002802002201044020012d000c450d010b024020002802042202044020022d000c450d010b200041003a000c20032000280208220047044020002d000c0d030b200041013a000c0f0b2001044020012d000c450d010b200241013a000c200041003a000c200010182000280208220028020021010b2000200028020822002d000c3a000c200041013a000c200141013a000c200010190f0b2000280208220120012802002000464102746a28020021000c000b000b200541013a000c0b0b1401017f03402000220128020022000d000b20010b5101027f200020002802042201280200220236020420020440200220003602080b200120002802083602082000280208220220022802002000474102746a200136020020002001360208200120003602000b5101027f200020002802002201280204220236020020020440200220003602080b200120002802083602082000280208220220022802002000474102746a200136020020002001360208200120003602040b150020002000411c6a2200360218200042003702000b0b002000410120001b101e0b1d01017f03402000220128020022000d00200128020422000d000b20010be60502057f017e23004180016b22002400100710012201101e22021002200041d8006a200041086a20022001101f220341001020200041d8006a102102400240200041d8006a1022450d00200028025c450d0020002802582d000041c001490d010b10000b200041386a200041d8006a1023200028023c220141094f044010000b200028023821020340200104402001417f6a210120023100002005420886842105200241016a21020c010b0b024002402005500d0041800810242005510440410210250c020b41850810242005510440410310250c020b418e08102420055104402003410410260c020b41990810242005510440200041d8006a1027200041f8006a3502002105200041386a1028220120051029102a20012005102b200128020c200141106a28020047044010000b200128020020012802041006200128020c22030440200120033602100b102c0c020b41a60810242005510440410510250c020b41b30810242005510440200041d8006a1027200041d8006a10142102200041206a10282101200041d0006a4100360200200041c8006a4200370300200041406b420037030020004200370338200041386a2002102d20002802382104200041386a410472102e20012004102a20012002102f200128020c200141106a28020047044010000b200128020020012802041006200128020c22020440200120023602100b102c0c020b41bc08102420055104402003410610260c020b41c60810242005510440200041d8006a1027200041f8006a2802002103200041206a10282101200041d0006a4100360200200041c8006a4200370300200041406b420037030020004200370338200041386a200345ad2205103020002802382103200041386a410472102e20012003102a200120051031220128020c200141106a28020047044010000b200128020020012802041006200128020c22030440200120033602100b102c0c020b41d40810242005520d00410710250c010b10000b103220004180016a24000b970101047f230041106b220124002001200036020c2000047f41900b200041086a2202411076220041900b2802006a2203360200418c0b2002418c0b28020022026a41076a417871220436020002400240200341107420044d044041900b200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20022001410c6a4104103b41086a0541000b200141106a24000b0c00200020012002411c10330bc90202077f017e230041106b220324002001280208220520024b0440200341086a2001105020012003280208200328020c103736020c200320011050410021052001027f410020032802002206450d001a410020032802042208200128020c2207490d001a200820072007417f461b210420060b360210200141146a2004360200200141003602080b200141106a210903402001280214210402402005200249044020040d01410021040b200020092802002004411410331a200341106a24000f0b20032001105041002104027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820066b2104200620076a0b21052001200436021420012005360210200320094100200520041037104f20012003290300220a3702102001200128020c200a422088a76a36020c2001200128020841016a22053602080c000b000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0b980101037f200028020445044041000f0b20001021200028020022022c0000220141004e044020014100470f0b027f4101200141807f460d001a200141ff0171220341b7014d0440200028020441014d047f100020002802000520020b2d00014100470f0b4100200341bf014b0d001a2000280204200141ff017141ca7e6a22014d047f100020002802000520020b20016a2d00004100470b0bd40101047f200110342204200128020422024b04401000200128020421020b200128020021052000027f02400240200204404100210120052c00002203417f4a0d01027f200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a21010c010b4101210120050d000c010b410021032002200149200120046a20024b720d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b2701027f230041306b22012400200141086a1027200141086a2000110200102c200141306a24000b3b01027f230041306b22022400200220004101102020021035210020021027200220003a002f20022002412f6a2001110000102c200241306a24000bdb05010b7f230041f0006b2205240020004200370204200042c2c285f3c4ee90c6e4003703102000411c6a220342003702002000200041046a220a36020020002003360218200541186a102822062000290310102b200628020c200641106a28020047044010000b200041186a210702400240200628020022042006280204220910032203450d002003101b21020340200120026a41003a00002003200141016a2201470d000b20042009200220011004417f460d0002402005200241016a200120026a2002417f736a101f2201280204450d0020012802002d000041c001490d00200541e0006a2001410110362102200541d0006a200141001036210920022802042101034020092802042001464100200228020822042009280208461b0d032005200541386a20012004411c1033103522013a00372007200541ec006a200541376a100e22042802004504404110101b220820013a000d2007200528026c20042008100f0b20022002280204220120022802086a410020011b22013602042002280200220404402002200436020820012004103721012002027f200228020422084504404100210441000c010b4100210441002002280208220b2001490d001a200b20012001417f461b210420080b2201ad2004ad42208684370204200241002002280200220820046b2204200420084b1b36020005200241003602080b0c000b000b10000c010b410021030b200628020c22020440200620023602100b024020030d002000280200210102402000280220450d002007100c210303402003450d012001200a470440200320012d000d3a000d2003100d2007200541386a2003410d6a103821062007200528023820062003100f20011013210121030c010b0b0340200328020822030d000b200a21010b03402001200a460d014110101b220320012d000d3a000d2007200541386a2003410d6a103821022007200528023820022003100f2001101321010c000b000b200541f0006a240020000b29002000410036020820004200370200200041001039200041146a41003602002000420037020c20000b4b01027f230041206b22012400200141186a4100360200200141106a4200370300200141086a42003703002001420037030020012000103020012802002001410472102e200141206a24000b1300200028020820014904402000200110390b0b09002000200110311a0bee05010b7f230041d0006b22032400200341186a1028220720002903101029102a20072000290310102b200728020c200741106a28020047044010000b2007280204210a2007280200200310282101200341c8006a4100360200200341406b4200370300200341386a420037030020034200370330027f200041206a2802004504402003410136023041010c010b200341306a4100103a2000411c6a210420002802182102037f2002200446047f200341306a4101103a200328023005200341306a20022d000d102d2002101321020c010b0b0b2104200341306a410472102e4101101b220241fe013a0000200128020c200141106a28020047044010000b2001280204220541016a220620012802084b047f20012006103920012802040520050b20012802006a20024101103b1a2001200128020441016a3602042001200241016a200420026b6a102a02402000280220220204402001280204210420012802102205200141146a280200220649044020052002ad2004ad422086843702002001200128021041086a3602100c020b027f41002005200128020c22056b410375220841016a2209200620056b2205410275220620062009491b41ffffffff01200541037541ffffffff00491b2205450d001a2005410374101b0b2106200620084103746a22082002ad2004ad4220868437020020082001280210200128020c22096b22026b2104200241014e0440200420092002103b1a0b2001200620054103746a3602142001200841086a3602102001200436020c0c010b200141c001103c20014100103d200128020020012802046a41004100103b1a2001103e0b2000411c6a210420002802182102034020022004470440200120022d000d102f2002101321020c010b0b0240200128020c2001280210460440200128020021020c010b100020012802002102200128020c2001280210460d0010000b200a200220012802041005200128020c22000440200120003602100b200728020c22000440200720003602100b200341d0006a24000b090020002001ad10300bea0101047f230041106b22042400200028020422012000280210220341087641fcffff07716a2102027f410020012000280208460d001a2002280200200341ff07714102746a0b2101200441086a2000103f200428020c210303400240200120034604402000410036021420002802082102200028020421010340200220016b41027522034103490d022000200141046a22013602040c000b000b200141046a220120022802006b418020470d0120022802042101200241046a21020c010b0b2003417f6a220241014d04402000418004418008200241016b1b3602100b200020011040200441106a24000b0a0020002001ad10311a0b840102027f017e4101210320014280015a0440034020012004845045044020044238862001420888842101200241016a2102200442088821040c010b0b200241384f047f2002104120026a0520020b41016a21030b200041186a28020022020440200041086a280200200041146a2802002002104221000b2000200028020020036a3602000bba0202037f037e024020015004402000418001103c0c010b20014280015a044020012107034020062007845045044020064238862007420888842107200241016a2102200642088821060c010b0b0240200241384f04402002210303402003044020034108762103200441016a21040c010b0b200441c9004f044010000b2000200441b77f6a41ff0171103c2000200028020420046a1051200028020420002802006a417f6a21042002210303402003450d02200420033a0000200341087621032004417f6a21040c000b000b200020024180017341ff0171103c0b2000200028020420026a1051200028020420002802006a417f6a210203402001200584500d02200220013c0000200542388620014208888421012002417f6a2102200542088821050c000b000b20002001a741ff0171103c0b2000103e20000b880101037f41ec08410136020041f0082802002100034020000440034041f40841f4082802002201417f6a2202360200200141014845044041ec084100360200200020024102746a22004184016a280200200041046a28020011020041ec08410136020041f00828020021000c010b0b41f408412036020041f008200028020022003602000c010b0b0b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000104d20024f0d002003410471044010000c010b200042003702000b02402003411071450d002000104d20024d0d0020034104710440100020000f0b200042003702000b20000bff0201037f200028020445044041000f0b2000102141012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b7d01037f230041106b22012400200010210240024020001022450d002000280204450d0020002802002d000041c001490d010b10000b200141086a20001023200128020c220041024f044010000b200128020821020340200004402000417f6a210020022d00002103200241016a21020c010b0b200141106a240020030be70101037f230041106b2204240020004200370200200041086a410036020020012802042103024002402002450440200321020c010b410021022003450d002003210220012802002d000041c001490d00200441086a2001105020004100200428020c2201200428020822022001103722032003417f461b20024520012003497222031b220536020820004100200220031b3602042000200120056b3602000c010b20012802002103200128020421012000410036020020004100200220016b20034520022001497222021b36020820004100200120036a20021b3602040b200441106a240020000b2301017f230041206b22022400200241086a2000200141141033104d200241206a24000b6201017f024020002802042203044020022d0000210203400240200220032d000d49044020032802002200450d040c010b200328020422000d0020012003360200200341046a0f0b200021030c000b000b200041046a21030b2001200336020020030b2f01017f200028020820014904402001101e20002802002000280204103b210220002001360208200020023602000b0bbd0c02077f027e230041306b22052400200041046a2107024020014101460440200041086a280200200041146a280200200041186a220228020022041042280200210120022004417f6a360200200710434180104f044020072000410c6a280200417c6a10400b200141384f047f2001104120016a0520010b41016a2101200041186a2802002202450d01200041086a280200200041146a2802002002104221000c010b0240200710430d00200041146a28020022014180084f0440200020014180786a360214200041086a2201280200220228020021042001200241046a360200200520043602182007200541186a10440c010b2000410c6a2802002202200041086a2802006b4102752204200041106a2203280200220620002802046b2201410275490440418020101b2104200220064704400240200028020c220120002802102206470d0020002802082202200028020422034b04402000200220012002200220036b41027541016a417e6d41027422036a1045220136020c2000200028020820036a3602080c010b200541186a200620036b2201410175410120011b22012001410276200041106a10462102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c2002200937020820021047200028020c21010b200120043602002000200028020c41046a36020c0c020b02402000280208220120002802042206470d00200028020c2202200028021022034904402000200120022002200320026b41027541016a41026d41027422036a104822013602082000200028020c20036a36020c0c010b200541186a200320066b2201410175410120011b2201200141036a410276200041106a10462102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c2002200937020820021047200028020821010b2001417c6a2004360200200020002802082201417c6a22023602082002280200210220002001360208200520023602182007200541186a10440c010b20052001410175410120011b2004200310462102418020101b2106024020022802082201200228020c2208470d0020022802042204200228020022034b04402002200420012004200420036b41027541016a417e6d41027422036a104522013602082002200228020420036a3602040c010b200541186a200820036b2201410175410120011b22012001410276200241106a280200104621042002280208210320022802042101034020012003470440200428020820012802003602002004200428020841046a360208200141046a21010c010b0b20022902002109200220042902003702002004200937020020022902082109200220042902083702082004200937020820041047200228020821010b200120063602002002200228020841046a360208200028020c2104034020002802082004460440200028020421012000200228020036020420022001360200200228020421012002200436020420002001360208200029020c21092000200229020837020c2002200937020820021047052004417c6a210402402002280204220120022802002208470d0020022802082203200228020c22064904402002200120032003200620036b41027541016a41026d41027422066a104822013602042002200228020820066a3602080c010b200541186a200620086b2201410175410120011b2201200141036a410276200228021010462002280208210620022802042101034020012006470440200528022020012802003602002005200528022041046a360220200141046a21010c010b0b20022902002109200220052903183702002002290208210a20022005290320370208200520093703182005200a3703201047200228020421010b2001417c6a200428020036020020022002280204417c6a3602040c010b0b0b200541186a2007103f200528021c4100360200200041186a2100410121010b2000200028020020016a360200200541306a24000bf80801067f0340200020046a2105200120046a220341037145200220044672450440200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220845044003402006411049450440200020046a2202200120046a2203290200370200200241086a200341086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2202200120046a2201290200370200200141086a2103200241086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002008417f6a220841024b0d00024002400240024002400240200841016b0e020102000b2005200120046a220628020022033a0000200541016a200641016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2202200120046a220541046a2802002207410874200341187672360200200241046a200541086a2802002203410874200741187672360200200241086a2005410c6a28020022074108742003411876723602002002410c6a200541106a2802002203410874200741187672360200200441106a2104200641706a21060c000b000b2005200120046a220628020022033a0000200541016a200641016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2202200120046a220541046a2802002207411074200341107672360200200241046a200541086a2802002203411074200741107672360200200241086a2005410c6a28020022074110742003411076723602002002410c6a200541106a2802002203411074200741107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022033a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2202200120046a220541046a2802002207411874200341087672360200200241046a200541086a2802002203411874200741087672360200200241086a2005410c6a28020022074118742003410876723602002002410c6a200541106a2802002203411874200741087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000b250020004101103d200028020020002802046a20013a00002000200028020441016a3602040b1b00200028020420016a220120002802084b04402000200110390b0bf50101057f0340024020002802102201200028020c460d00200141786a2802004504401000200028021021010b200141786a22022002280200417f6a220436020020040d002000200236021020004101200028020422032001417c6a28020022026b22011041220441016a20014138491b220520036a1051200220002802006a220320056a200320011049200141374d0440200028020020026a200141406a3a00000c020b200441f7016a220341ff014d0440200028020020026a20033a00002000280200200220046a6a210203402001450d03200220013a0000200141087621012002417f6a21020c000b000510000c020b000b0b0b4f01037f20012802042203200128021020012802146a220441087641fcffff07716a21022000027f410020032001280208460d001a2002280200200441ff07714102746a0b360204200020023602000b2501017f200028020821020340200120024645044020002002417c6a22023602080c010b0b0b1e01017f03402000044020004108762100200141016a21010c010b0b20010b25002000200120026a417f6a220141087641fcffff07716a280200200141ff07714102746a0b2801017f200028020820002802046b2201410874417f6a410020011b200028021420002802106a6b0ba10202057f017e230041206b22052400024020002802082202200028020c2206470d0020002802042203200028020022044b04402000200320022003200320046b41027541016a417e6d41027422046a104522023602082000200028020420046a3602040c010b200541086a200620046b2202410175410120021b220220024102762000410c6a10462103200028020821042000280204210203402002200446450440200328020820022802003602002003200328020841046a360208200241046a21020c010b0b20002902002107200020032902003702002003200737020020002902082107200020032902083702082003200737020820031047200028020821020b200220012802003602002000200028020841046a360208200541206a24000b2501017f200120006b220141027521032001044020022000200110490b200220034102746a0b4f01017f2000410036020c200041106a2003360200200104402001410274101b21040b200020043602002000200420024102746a22023602082000200420014102746a36020c2000200236020420000b2b01027f200028020821012000280204210203402001200247044020002001417c6a22013602080c010b0b0b1b00200120006b22010440200220016b22022000200110490b20020b8d0301037f024020002001460d00200120006b20026b410020024101746b4d0440200020012002103b1a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2104200020036a2205410371450440200220036b210241002103034020024104490d04200320056a200320046a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200520042d00003a0000200341016a21030c000b000b024020030d002001417f6a21030340200020026a22044103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042004417f6a200220036a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320046a2101200320056a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0bc90201037f200041003a000020004184026a2201417f6a41003a0000200041003a0002200041003a00012001417d6a41003a00002001417e6a41003a0000200041003a00032001417c6a41003a00002000410020006b41037122026a22014100360200200141840220026b417c7122036a2202417c6a4100360200024020034109490d002001410036020820014100360204200241786a4100360200200241746a410036020020034119490d002001410036021820014100360214200141003602102001410036020c200241706a41003602002002416c6a4100360200200241686a4100360200200241646a41003602002003200141047141187222036b2102200120036a2101034020024120490d0120014200370300200141186a4200370300200141106a4200370300200141086a4200370300200141206a2101200241606a21020c000b000b20000b3501017f230041106b220041a08b0436020c41880b200028020c41076a4178712200360200418c0b200036020041900b3f003602000b3801017f41fc0a420037020041840b410036020041742100034020000440200041880b6a4100360200200041046a21000c010b0b4108100a0b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f2000104e200010346a0541010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5a01027f2000027f0240200128020022054504400c010b200220036a200128020422014b2001200249720d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b2101017f20011034220220012802044b044010000b200020012001104e2002104f0b0f00200020011039200020013602040b0b6401004180080b5d696e697400696e69745f73657400696e736572745f736574006765745f7365745f73697a65006974657261746f725f7365740066696e645f7365740065726173655f736574006765745f7365745f656d70747900636c6561725f736574";

    public static String BINARY = BINARY_0;

    public static final String FUNC_FIND_SET = "find_set";

    public static final String FUNC_ITERATOR_SET = "iterator_set";

    public static final String FUNC_INSERT_SET = "insert_set";

    public static final String FUNC_INIT_SET = "init_set";

    public static final String FUNC_ERASE_SET = "erase_set";

    public static final String FUNC_GET_SET_EMPTY = "get_set_empty";

    public static final String FUNC_CLEAR_SET = "clear_set";

    public static final String FUNC_GET_SET_SIZE = "get_set_size";

    protected ReferenceDataTypeSetContract(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected ReferenceDataTypeSetContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Uint8> find_set() {
        final WasmFunction function = new WasmFunction(FUNC_FIND_SET, Arrays.asList(), Uint8.class);
        return executeRemoteCall(function, Uint8.class);
    }

    public RemoteCall<TransactionReceipt> iterator_set() {
        final WasmFunction function = new WasmFunction(FUNC_ITERATOR_SET, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> iterator_set(BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_ITERATOR_SET, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<TransactionReceipt> insert_set(Uint8 value) {
        final WasmFunction function = new WasmFunction(FUNC_INSERT_SET, Arrays.asList(value), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> insert_set(Uint8 value, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_INSERT_SET, Arrays.asList(value), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public static RemoteCall<ReferenceDataTypeSetContract> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ReferenceDataTypeSetContract.class, web3j, credentials, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<ReferenceDataTypeSetContract> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ReferenceDataTypeSetContract.class, web3j, transactionManager, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<ReferenceDataTypeSetContract> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ReferenceDataTypeSetContract.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public static RemoteCall<ReferenceDataTypeSetContract> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ReferenceDataTypeSetContract.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public RemoteCall<TransactionReceipt> init_set() {
        final WasmFunction function = new WasmFunction(FUNC_INIT_SET, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> init_set(BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_INIT_SET, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<TransactionReceipt> erase_set(Uint8 value) {
        final WasmFunction function = new WasmFunction(FUNC_ERASE_SET, Arrays.asList(value), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> erase_set(Uint8 value, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_ERASE_SET, Arrays.asList(value), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<Boolean> get_set_empty() {
        final WasmFunction function = new WasmFunction(FUNC_GET_SET_EMPTY, Arrays.asList(), Boolean.class);
        return executeRemoteCall(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> clear_set() {
        final WasmFunction function = new WasmFunction(FUNC_CLEAR_SET, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> clear_set(BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_CLEAR_SET, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<Uint64> get_set_size() {
        final WasmFunction function = new WasmFunction(FUNC_GET_SET_SIZE, Arrays.asList(), Uint64.class);
        return executeRemoteCall(function, Uint64.class);
    }

    public static ReferenceDataTypeSetContract load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new ReferenceDataTypeSetContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ReferenceDataTypeSetContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new ReferenceDataTypeSetContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
