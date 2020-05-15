package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Uint64;
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
public class RecursionCall extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001470d60017f017f60000060017f0060027f7f0060037f7f7f0060047f7f7f7f0060027f7f017f60037f7f7f017f60047f7f7f7f017f60017f017e60027f7e006000017f60017e017f02a9010703656e760c706c61746f6e5f70616e6963000103656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000b03656e7610706c61746f6e5f6765745f696e707574000203656e7617706c61746f6e5f6765745f73746174655f6c656e677468000603656e7610706c61746f6e5f6765745f7374617465000803656e7610706c61746f6e5f7365745f7374617465000503656e760d706c61746f6e5f72657475726e0003032322010102020100070409090002000c030a0108020000030703030400010100000506030405017001030305030100020608017f0141d08a040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300070f5f5f66756e63735f6f6e5f65786974001706696e766f6b65000b0908010041010b0209090a8b2e2208001008102210230b3801017f4194084200370200419c08410036020041742100034020000440200041a0086a4100360200200041046a21000c010b0b4101100a0b0300010b940101027f41a008410136020041a408280200220145044041a40841ac0836020041ac0821010b024041a80828020022024120460440418402100c2201450d0120011021220141a40828020036020041a408200136020041a8084100360200410021020b41a808200241016a360200200120024102746a22014184016a4100360200200141046a20003602000b41a00841003602000b960202047f027e230041d0006b22012400100710012200100c22021002200141386a200141086a20022000100d22004100100e02400240200141386a100f2204500d0041800810102004510440200141386a101110120c020b41850810102004510440200141386a20004101100e200141386a100f2105200141386a1011220029031021040340200420055a4504402000200442017c22043703100c010b0b200010120c020b418a0810102004520d00200141206a101122022903102104200141386a10132200200410141015200020041016200028020c200041106a28020047044010000b200028020020002802041006200028020c22030440200020033602100b200210120c010b10000b1017200141d0006a24000b970101047f230041106b220124002001200036020c2000047f41c40a200041086a2202411076220041c40a2802006a220336020041c00a200241c00a28020022026a41076a417871220436020002400240200341107420044d044041c40a200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20022001410c6a4104101d41086a0541000b200141106a24000b0c00200020012002411c10180bc90202077f017e230041106b220324002001280208220520024b0440200341086a2001102820012003280208200328020c102736020c200320011028410021052001027f410020032802002206450d001a410020032802042208200128020c2207490d001a200820072007417f461b210420060b360210200141146a2004360200200141003602080b200141106a210903402001280214210402402005200249044020040d01410021040b200020092802002004411410181a200341106a24000f0b20032001102841002104027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820066b2104200620076a0b21052001200436021420012005360210200320094100200520041027102620012003290300220a3702102001200128020c200a422088a76a36020c2001200128020841016a22053602080c000b000bac0302057f017e20001019024002402000280204450d00200010190240200028020022012c0000220241004e044020020d010c020b200241807f460d00200241ff0171220341b7014d0440200028020441014d04401000200028020021010b20012d00010d010c020b200341bf014b0d012000280204200241ff017141ca7e6a22024d04401000200028020021010b200120026a2d0000450d010b2000280204450d0020012d000041c001490d010b10000b2000101a2204200028020422014b04401000200028020421010b20002802002105024002400240200104404100210320052c00002200417f4a0d01027f200041ff0171220341bf014d04404100200041ff017141b801490d011a200341c97e6a0c010b4100200041ff017141f801490d001a200341897e6a0b41016a21030c010b4101210320050d00410021000c010b410021002001200449200320046a20014b720d004100210220012003490d01200320056a2102200120036b20042004417f461b22004109490d0110000c010b410021020b0340200004402000417f6a210020023100002006420886842106200241016a21020c010b0b20060b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010bdb0101077f230041306b22052400200042e9feb2fee9efcf848c7f37030820004200370300200541186a1013220220002903081016200228020c200241106a28020047044010000b02400240200228020022062002280204220710032204450d002004101b21010340200120036a41003a00002004200341016a2203470d000b20062007200120031004417f460d0020002005200141016a200120036a2001417f736a100d100f3703100c010b410021040b200228020c22010440200220013602100b2004450440200020002903003703100b200541306a240020000bb00201097f230041306b22032400200341186a10132202200029030810141015200220002903081016200228020c200241106a28020047044010000b2002280204210520022802002003101321012000290310101421074101101b220441fe013a0000200128020c200141106a28020047044010000b2001280204220841016a220920012802084b047f20012009101c20012802040520080b20012802006a20044101101d1a2001200128020441016a3602042001200441016a200720046b6a10152001200029031010160240200128020c2001280210460440200128020021000c010b100020012802002100200128020c2001280210460d0010000b2005200020012802041005200128020c22000440200120003602100b200228020c22000440200220003602100b200341306a24000b2900200041003602082000420037020020004100101c200041146a41003602002000420037020c20000b7002027f017e4101210120004280015a047f41002101034020002003845045044020034238862000420888842100200141016a2101200342088821030c010b0b024020014138490d002001210203402002450d01200141016a2101200241087621020c000b000b200141016a0541010b0b13002000280208200149044020002001101c0b0bc10402057f027e024020015004402000418001101e0c010b20014280015a044020012108034020072008845045044020074238862008420888842108200241016a2102200742088821070c010b0b0240200241384f04402002210403402004044020044108762104200341016a21030c010b0b200341c9004f044010000b2000200341b77f6a41ff0171101e2000200028020420036a101f200028020420002802006a417f6a21032002210403402004450d02200320043a0000200441087621042003417f6a21030c000b000b200020024180017341ff0171101e0b2000200028020420026a101f200028020420002802006a417f6a21024200210703402001200784500d02200220013c0000200742388620014208888421012002417f6a2102200742088821070c000b000b20002001a741ff0171101e0b0340024020002802102202200028020c460d00200241786a2802004504401000200028021021020b200241786a22052005280200417f6a220436020020040d002000200536021041002104200028020422052002417c6a28020022066b2203210203402002044020024108762102200441016a21040c010b0b20004101200441016a20034138491b220220056a101f2002200028020020066a22026a200220031020200341374d0440200028020020066a200341406a3a00000c020b200441084d0440200028020020066a200441776a3a0000200028020020066a20046a210203402003450d03200220033a0000200341087621032002417f6a21020c000b000510000c020b000b0b0b880101037f41a008410136020041a4082802002100034020000440034041a80841a8082802002201417f6a2202360200200141014845044041a0084100360200200020024102746a22004184016a280200200041046a28020011020041a008410136020041a40828020021000c010b0b41a808412036020041a408200028020022003602000c010b0b0b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000102420024f0d002003410471044010000c010b200042003702000b02402003411071450d002000102420024d0d0020034104710440100020000f0b200042003702000b20000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0bff0201037f200028020445044041000f0b2000101941012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b0b002000410120001b100c0b2f01017f200028020820014904402001100c20002802002000280204101d210220002001360208200020023602000b0bf80801067f0340200020046a2105200120046a220341037145200220044672450440200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220845044003402006411049450440200020046a2202200120046a2203290200370200200241086a200341086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2202200120046a2201290200370200200141086a2103200241086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002008417f6a220841024b0d00024002400240024002400240200841016b0e020102000b2005200120046a220628020022033a0000200541016a200641016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2202200120046a220541046a2802002207410874200341187672360200200241046a200541086a2802002203410874200741187672360200200241086a2005410c6a28020022074108742003411876723602002002410c6a200541106a2802002203410874200741187672360200200441106a2104200641706a21060c000b000b2005200120046a220628020022033a0000200541016a200641016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2202200120046a220541046a2802002207411074200341107672360200200241046a200541086a2802002203411074200741107672360200200241086a2005410c6a28020022074110742003411076723602002002410c6a200541106a2802002203411074200741107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022033a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2202200120046a220541046a2802002207411874200341087672360200200241046a200541086a2802002203411874200741087672360200200241086a2005410c6a28020022074118742003410876723602002002410c6a200541106a2802002203411874200741087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000b3f01027f2000280204220241016a220320002802084b047f20002003101c20002802040520020b20002802006a20013a00002000200028020441016a3602040b0f0020002001101c200020013602040b8d0301037f024020002001460d00200120006b20026b410020024101746b4d0440200020012002101d1a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2104200020036a2205410371450440200220036b210241002103034020024104490d04200320056a200320046a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200520042d00003a0000200341016a21030c000b000b024020030d002001417f6a21030340200020026a22044103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042004417f6a200220036a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320046a2101200320056a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0bc90201037f200041003a000020004184026a2201417f6a41003a0000200041003a0002200041003a00012001417d6a41003a00002001417e6a41003a0000200041003a00032001417c6a41003a00002000410020006b41037122026a22014100360200200141840220026b417c7122036a2202417c6a4100360200024020034109490d002001410036020820014100360204200241786a4100360200200241746a410036020020034119490d002001410036021820014100360214200141003602102001410036020c200241706a41003602002002416c6a4100360200200241686a4100360200200241646a41003602002003200141047141187222036b2102200120036a2101034020024120490d0120014200370300200141186a4200370300200141106a4200370300200141086a4200370300200141206a2101200241606a21020c000b000b20000b3501017f230041106b220041d08a0436020c41bc0a200028020c41076a417871220036020041c00a200036020041c40a3f003602000b3801017f41b00a420037020041b80a410036020041742100034020000440200041bc0a6a4100360200200041046a21000c010b0b4102100a0b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f200010252000101a6a0541010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5a01027f2000027f0240200128020022054504400c010b200220036a200128020422014b2001200249720d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b2301017f230041206b22022400200241086a20002001411410181024200241206a24000b2101017f2001101a220220012802044b044010000b2000200120011025200210260b0b1801004180080b11696e69740063616c6c006765745f73756d";

    public static String BINARY = BINARY_0;

    public static final String FUNC_CALL = "call";

    public static final String FUNC_GET_SUM = "get_sum";

    protected RecursionCall(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected RecursionCall(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> call(Uint64 n) {
        final WasmFunction function = new WasmFunction(FUNC_CALL, Arrays.asList(n), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> call(Uint64 n, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_CALL, Arrays.asList(n), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public static RemoteCall<RecursionCall> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(RecursionCall.class, web3j, credentials, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<RecursionCall> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(RecursionCall.class, web3j, transactionManager, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<RecursionCall> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(RecursionCall.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public static RemoteCall<RecursionCall> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(RecursionCall.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public RemoteCall<Uint64> get_sum() {
        final WasmFunction function = new WasmFunction(FUNC_GET_SUM, Arrays.asList(), Uint64.class);
        return executeRemoteCall(function, Uint64.class);
    }

    public static RecursionCall load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new RecursionCall(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RecursionCall load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new RecursionCall(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
