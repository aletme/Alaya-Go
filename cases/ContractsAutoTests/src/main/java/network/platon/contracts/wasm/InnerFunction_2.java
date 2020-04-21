package network.platon.contracts.wasm;

import com.platon.rlp.datatypes.Int64;
import com.platon.rlp.datatypes.Uint64;
import com.platon.rlp.datatypes.WasmAddress;
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
public class InnerFunction_2 extends WasmContract {
    private static String BINARY_0 = "0x0061736d01000000014a0d60027f7f0060017f0060017f017f60000060037f7f7f0060037f7f7f017f60047f7f7f7f0060027f7f017f60037f7e7e0060017f017e60077f7f7f7f7f7f7f0060027f7e006000017f02da010a03656e760c706c61746f6e5f70616e6963000303656e760f706c61746f6e5f7472616e73666572000503656e7611706c61746f6e5f63616c6c5f76616c7565000203656e760b706c61746f6e5f73686133000603656e760d706c61746f6e5f72657475726e000003656e760d706c61746f6e5f726576657274000303656e760e706c61746f6e5f64657374726f79000203656e760d706c61746f6e5f6f726967696e000103656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000c03656e7610706c61746f6e5f6765745f696e707574000103545303050503020202050303070404010a040601000706000102080808030101050202020206000402010204000002000000000400010001020001000b0100070703010201000101000003090901000000000000010405017001050505030100020615037f0141d08b040b7f0041d08b040b7f0041cf0b0b075406066d656d6f72790200115f5f7761736d5f63616c6c5f63746f7273000a0b5f5f686561705f6261736503010a5f5f646174615f656e6403020f5f5f66756e63735f6f6e5f65786974002506696e766f6b650052090a010041010b042751503d0a8565531800100d41a40a10211a4101102641b00a10211a410410260ba20a010d7f2002410f6a210f410020026b21072002410e6a210a410120026b210e2002410d6a210d410220026b210c0340200020056a2103200120056a220441037145200220054672450440200320042d00003a0000200f417f6a210f200741016a2107200a417f6a210a200e41016a210e200d417f6a210d200c41016a210c200541016a21050c010b0b200220056b210602400240024002402003410371220b044020064120490d03200b4101460d01200b4102460d02200b4103470d032003200120056a280200220a3a0000200041016a210b200220056b417f6a210c200521030340200c4113494504402003200b6a2208200120036a220941046a2802002206411874200a41087672360200200841046a200941086a2802002204411874200641087672360200200841086a2009410c6a28020022064118742004410876723602002008410c6a200941106a280200220a411874200641087672360200200341106a2103200c41706a210c0c010b0b2002417f6a2007416d2007416d4b1b200f6a4170716b20056b2106200120036a41016a2104200020036a41016a21030c030b2006210403402004411049450440200020056a2203200120056a2202290200370200200341086a200241086a290200370200200541106a2105200441706a21040c010b0b027f2006410871450440200120056a2104200020056a0c010b200020056a2202200120056a2201290200370200200141086a2104200241086a0b21052006410471044020052004280200360200200441046a2104200541046a21050b20064102710440200520042f00003b0000200441026a2104200541026a21050b2006410171450d03200520042d00003a000020000f0b2003200120056a2206280200220a3a0000200341016a200641016a2f00003b0000200041036a210b200220056b417d6a210720052103034020074111494504402003200b6a2208200120036a220941046a2802002206410874200a41187672360200200841046a200941086a2802002204410874200641187672360200200841086a2009410c6a28020022064108742004411876723602002008410c6a200941106a280200220a410874200641187672360200200341106a2103200741706a21070c010b0b2002417d6a200c416f200c416f4b1b200d6a4170716b20056b2106200120036a41036a2104200020036a41036a21030c010b2003200120056a2206280200220d3a0000200341016a200641016a2d00003a0000200041026a210b200220056b417e6a210720052103034020074112494504402003200b6a2208200120036a220941046a2802002206411074200d41107672360200200841046a200941086a2802002204411074200641107672360200200841086a2009410c6a28020022064110742004411076723602002008410c6a200941106a280200220d411074200641107672360200200341106a2103200741706a21070c010b0b2002417e6a200e416e200e416e4b1b200a6a4170716b20056b2106200120036a41026a2104200020036a41026a21030b20064110710440200320042d00003a00002003200428000136000120032004290005370005200320042f000d3b000d200320042d000f3a000f200441106a2104200341106a21030b2006410871044020032004290000370000200441086a2104200341086a21030b2006410471044020032004280000360000200441046a2104200341046a21030b20064102710440200320042f00003b0000200441026a2104200341026a21030b2006410171450d00200320042d00003a00000b20000bfc0202027f017e02402002450d00200020013a0000200020026a2203417f6a20013a000020024103490d00200020013a0002200020013a00012003417d6a20013a00002003417e6a20013a000020024107490d00200020013a00032003417c6a20013a000020024109490d002000410020006b41037122046a2203200141ff017141818284086c22013602002003200220046b417c7122046a2202417c6a200136020020044109490d002003200136020820032001360204200241786a2001360200200241746a200136020020044119490d002003200136021820032001360214200320013602102003200136020c200241706a20013602002002416c6a2001360200200241686a2001360200200241646a20013602002001ad220542208620058421052004200341047141187222016b2102200120036a2101034020024120490d0120012005370300200141186a2005370300200141106a2005370300200141086a2005370300200141206a2101200241606a21020c000b000b20000b3501017f230041106b220041d08b0436020c418408200028020c41076a41787122003602004180082000360200418c083f003602000b9f0101047f230041106b220224002002200036020c027f02400240024020000440418c08200041086a22014110762200418c082802006a2203360200418408200141840828020022016a41076a4178712204360200200341107420044d0d0120000d020c030b41000c030b418c08200341016a360200200041016a21000b200040000d0010000b20012002410c6a4104100b1a200141086a0b200241106a24000b2f01027f2000410120001b2100034002402000100e22010d004190082802002202450d0020021103000c010b0b20010b7801027f20002101024003402001410371044020012d0000450d02200141016a21010c010b0b2001417c6a21010340200141046a22012802002202417f73200241fffdfb776a7141808182847871450d000b0340200241ff0171450d01200141016a2d00002102200141016a21010c000b000b200120006b0bc10301067f024020002001460d00027f02400240200120006b20026b410020024101746b4b044020002001734103712103200020014f0d012003450d0220000c030b200020012002100b0f0b024020030d002001417f6a21030340200020026a220441037104402002450d052004417f6a200220036a2d00003a00002002417f6a21020c010b0b2000417c6a21032001417c6a2104034020024104490d01200220036a200220046a2802003602002002417c6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200241046a21062002417f73210503400240200120046a2107200020046a2208410371450d0020022004460d03200820072d00003a00002006417f6a2106200541016a2105200441016a21040c010b0b200220046b21014100210303402001410449450440200320086a200320076a280200360200200341046a21032001417c6a21010c010b0b200320076a210120022005417c2005417c4b1b20066a417c716b20046b2102200320086a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b20000b0a0041940841013602000b0a0041940841003602000b4d01017f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b200020012802082001280204101520000b6401027f2002417049044002402002410a4d0440200020024101743a0000200041016a21030c010b200241106a4170712204100f21032000200236020420002004410172360200200020033602080b2003200120021016200220036a41003a00000f0b000b13002002047f200020012002100b0520000b1a0b130020002d0000410171044020002802081a0b0bb70101027f416e20016b20024f0440027f200041016a20002d0000410171450d001a20002802080b2108027f416f200141e6ffffff074b0d001a410b20014101742207200120026a220220022007491b2202410b490d001a200241106a4170710b2207100f21022005044020022006200510160b200320046b220322060440200220056a200420086a200610160b200020023602082000200320056a220136020420002007410172360200200120026a41003a00000f0b000b13002002047f20002001200210110520000b1a0b9f0101027f416f20016b41014f0440027f200041016a20002d0000410171450d001a20002802080b2105027f416f200141e6ffffff074b0d001a410b20014101742204200141016a220120012004491b2204410b490d001a200441106a4170710b2201100f21042003044020042005200310160b200220036b22020440200320046a200320056a200210160b20002004360208200020014101723602000f0b000bfc0101067f027f410a21010240027f20002d0000220241017145044020024101762103410a0c010b2000280204210320002802002202417e71417f6a0b220520034128200341284b1b2204410b4f0440200441106a417071417f6a21010b20014704402001410a460440200041016a210420002802080c030b200141016a100f2204200120054b720d010b0f0b20002d0000220241017145044041012106200041016a0c010b4101210620002802080b2105200420052002410171047f200028020405200241fe01714101760b41016a10162006044020002004360208200020033602042000200141016a4101723602000f0b200020034101743a00000b950101037f027f20002d0000220241017122040440200028020421032000280200417e71417f6a0c010b20024101762103410a0b2102027f02400240200220034604402000200220022002101a20002d0000410171450d010c020b20040d010b2000200341017441026a3a0000200041016a0c010b2000200341016a36020420002802080b20036a220041003a0001200020013a00000bf40101037f027f20002d00002203410171220445044020034101760c010b20002802040b220341004f0440410a2102027f02400240200404402000280200417e71417f6a21020b200220036b200149044020002002200120036a20026b20034100200141ba0b10180c010b2001450d0020040d01200041016a0c020b20000f0b20002802080b22022003047f200120026a200220031019200141ba0b6a41ba0b200220036a41ba0b4b1b41ba0b200241ba0b4d1b0541ba0b0b20011019200120036a2101024020002d0000410171450440200020014101743a00000c010b200020013602040b200120026a41003a000020000f0b000be30201057f027f20002d00002205410171220445044020054101760c010b20002802040b220641004f04402006200120062001491b2101410a2105200404402000280200417e71417f6a21050b200120066b20056a200349044020002005200320066a20016b20056b200620012003200210180f0b2004047f200028020805200041016a0b21040240024020012003460440200321010c010b200620016b2207450d00200120034b04402004200220031019200320046a200120046a200710190c020b0240200420066a20024d200420024f720d00200120046a20024b04402004200220011019200320016b200220036a2102200121084100210121030c010b2002200320016b6a21020b200420086a220520036a200120056a200710190b200420086a2002200310190b200320016b20066a2101024020002d0000410171450440200020014101743a00000c010b200020013602040b200120046a41003a00000f0b000b6d01027f2001417049044002402001410a4d0440200020014101743a0000200041016a21020c010b200141106a4170712203100f21022000200136020420002003410172360200200020023602080b2001047f200241302001100c0520020b1a200120026a41003a00000f0b000b2301017f03402001410c46450440200020016a4100360200200141046a21010c010b0b0b190020004200370200200041086a41003602002000102020000bd00202027f047e027e027e02400240027e024020025004400c010b41fd00200279a76b220341c000470d0220010c010b2001420a800c030b21072002210541c00021030c010b2003413f4d0440200241c00020036bad22078620012003ad2206888421052002200688210820012007862107420021060c010b200241800120036bad2206862001200341406aad22058884210720022005882105200120068621060b03402003044020084201862005423f8884220220054201862007423f88842201427f852205420a7c200554ad2002427f8542007c7c423f8722024200837d20012002420a83220554ad7d2108200120057d210520074201862006423f888421072003417f6a21032004ad20064201868421062002a741017121040c010b0b2004ad2006420186427e8384210120074201862006423f88840c010b210142000b210220002001370300200020023703080b3701017f230041106b220324002003200120021022200329030021012000200341086a29030037030820002001370300200341106a24000b7701017e20002001427f7e200242767e7c2001422088220242ffffffff0f7e7c200242f6ffffff0f7e200142ffffffff0f83220142f6ffffff0f7e22024220887c22034220887c200142ffffffff0f7e200342ffffffff0f837c22014220887c3703082000200242ffffffff0f832001422086843703000b7601037f101241980828020021000340200004400340419c08419c082802002201417f6a22023602002001410148450440200020024102746a22004184016a280200200041046a2802001013110100101241980828020021000c010b0b419c084120360200419808200028020022003602000c010b0b0b960101027f1012419808280200220145044041980841a00836020041a00821010b0240419c0828020022024120460440418402100e2201044020014100418402100c1a0b2001450d0120014198082802003602004198082001360200419c084100360200410021020b419c08200241016a360200200120024102746a22014184016a4100360200200141046a200036020010130f0b10130b070041a40a10170b780020004200370210200042ffffffff0f3702082000200129020037020002402002410871450d002000102920012802044f0d002002410471450440200042003702000c010b10000b024002402002411071450d002000102920012802044d0d0020024104710d01200042003702000b20000f0b100020000b290002402000280204044020002802002c0000417f4c0d0141010f0b41000f0b2000102a2000102b6a0b240002402000280204450d0020002802002c0000417f4c0d0041000f0b2000103041016a0b8a0301047f0240024020002802040440200010314101210220002802002c00002201417f4c0d010c020b41000f0b200141ff0171220241b7014d0440200241807f6a0f0b02400240200141ff0171220141bf014d04400240200041046a22042802002201200241c97e6a22034d047f100020042802000520010b4102490d0020002802002d00010d0010000b200341054f044010000b20002802002d000145044010000b410021024100210103402001200346450440200028020020016a41016a2d00002002410874722102200141016a21010c010b0b200241384f0d010c020b200141f7014d0440200241c07e6a0f0b0240200041046a22042802002201200241897e6a22034d047f100020042802000520010b4102490d0020002802002d00010d0010000b200341054f044010000b20002802002d000145044010000b410021024100210103402001200346450440200028020020016a41016a2d00002002410874722102200141016a21010c010b0b20024138490d010b200241ff7d490d010b100020020f0b20020b3902017f017e230041306b2201240020012000290200220237031020012002370308200141186a200141086a411410281029200141306a24000b5e01027f2000027f027f2001280200220504404100200220036a200128020422014b2001200249720d011a410020012003490d021a200220056a2104200120026b20032003417f461b0c020b41000b210441000b360204200020043602000b2101017f2001102b220220012802044b044010000b200020012001102a2002102d0b900302097f017e230041406a220324002001280208220520024b0440200341386a2001102e200320032903383703182001200341186a102c36020c200341306a2001102e410021052001027f410020032802302206450d001a410020032802342208200128020c2207490d001a200820072007417f461b210420060b360210200141146a2004360200200141086a41003602000b200141106a2109200141146a21072001410c6a2106200141086a210803400240200520024f0d002007280200450d00200341306a2001102e41002105027f2003280230220a044041002003280234220b20062802002204490d011a200b20046b21052004200a6a0c010b41000b210420072005360200200920043602002003200536022c2003200436022820032003290328370310200341306a20094100200341106a102c102d20092003290330220c37020020062006280200200c422088a76a3602002008200828020041016a22053602000c010b0b20032009290200220c3703202003200c3703082000200341086a411410281a200341406b24000b4101017f02402000280204450d0020002802002d0000220041bf014d0440200041b801490d01200041c97e6a0f0b200041f801490d00200041897e6a21010b20010b4401017f200028020445044010000b0240200028020022012d0000418101470d00200041046a28020041014d047f100020002802000520010b2c00014100480d0010000b0b9f0101037f02402000280204044020001031200028020022022c000022014100480d0120014100470f0b41000f0b027f4101200141807f460d001a200141ff0171220341b7014d0440200041046a28020041014d047f100020002802000520020b2d00014100470f0b4100200341bf014b0d001a200041046a280200200141ff017141ca7e6a22014d047f100020002802000520020b20016a2d00004100470b0b2c002000200220016b22021035200028020020002802046a20012002100b1a2000200028020420026a3602040b9e0201077f02402001450d002000410c6a2107200041106a2105200041046a21060340200528020022022007280200460d01200241786a28020020014904401000200528020021020b200241786a2203200328020020016b220136020020010d01200520033602002000410120062802002002417c6a28020022016b22021036220341016a20024138491b2204200628020022086a10372004200120002802006a22046a2004200820016b10111a0240200241374d0440200028020020016a200241406a3a00000c010b200341f7016a220441ff014d0440200028020020016a20043a00002000280200200120036a6a210103402002450d02200120023a0000200241087621022001417f6a21010c000b000b10000b410121010c000b000b0b1b00200028020420016a220120002802084b04402000200110380b0b1e01017f03402000044020004108762100200141016a21010c010b0b20010b0f00200020011038200020013602040b3901017f200028020820014904402001100e220220002802002000280204100b1a20002802001a200041086a2001360200200020023602000b0b2500200041011035200028020020002802046a20013a00002000200028020441016a3602040b2b01027f20011036220241b7016a22034180024e044010000b2000200341ff01711039200020012002103b0b3d002000200028020420026a1037200028020020002802046a417f6a2100034020010440200020013a0000200141087621012000417f6a21000c010b0b0ba00101037f230041106b2202240020012802002103024002400240024020012802042201410146044020032c000022044100480d012000200441ff017110390c040b200141374b0d010b200020014180017341ff017110390c010b20002001103a0b2002200136020c2002200336020820022002290308370300200020022802002201200120022802046a10332000410010340b200041011034200241106a24000b070041b00a10170be20401077f230041306b22022400027f41002001280204220620012d000022034101762207200341017122041b22054102490d001a41002001280208200141016a20041b22032d00004130470d001a20032d000141f800464101740b21032002410036021020024200370308200541016a20036b41017622050440200241286a200241106a36020020022005100f22043602082002200436020c20024200370320200242003703182002200420056a360210200241186a103f20012d000022044101762107200141046a2802002106200441017121040b0240027f02402006200720041b41017104402001280208200141016a20041b20036a2c000010402204417f460d01200220043a0018200241086a200241186a1041200341017221030b200141016a2104200141046a2106200141086a2107024003402003200628020020012d00002205410176200541017122051b4904402007280200200420051b20036a22052c000010402208417f46200541016a2c000010402205417f46720d022002200520084104746a3a0018200341026a2103200241086a200241186a10410c010b0b2002200228020822043602182002200228020c220636021c2002200241106a2802003602202002420037020c200241086a21010c030b20024200370318200241206a0c010b20024200370318200241206a0b210141002106410021040b4100210320014100360200200241086a1042200241003a00082000200241086a1043200620046b210103402001200346200341134b72450440200020036a200320046a2d00003a0000200341016a21030c010b0b200241186a1042200241306a24000b3801037f2000280208210120002802042102200041086a210303402001200247044020032001417f6a22013602000c010b0b20002802001a0b4901017f415021010240200041506a41ff0171410a4f044041a97f21012000419f7f6a41ff017141064f0d010b200020016a0f0b200041496a417f200041bf7f6a41ff01714106491b0bcd0101047f230041206b220324000240200028020422022000280208490440200220012d00003a0000200041046a2200200028020041016a3602000c010b2000200241016a20002802006b10472104200341186a200041086a3602004100210220034100360214200041046a28020020002802006b2105200404402004100f21020b20032002360208200341146a200220046a360200200220056a220220012d00003a00002003200236020c2003200241016a3602102000200341086a1058200341086a103f0b200341206a24000b1501017f200028020022010440200020013602040b0b080020002001105a0b890302057f017e230041406a2202240020015045044020022000103e2002410036022020024200370318200241386a200241206a36020020024120100f2200360230200220003602282002200036022c2002200041206a360234416021030340200041003a0000200241306a2200200028020041016a2200360200200341016a22030d000b2002200228022c200228021c2204200228021822036b22056b220636022c200541004a0440200620032005100b1a200228021c210420022802182103200228022c2106200241306a28020021000b200241306a2004360200200241206a220428020021052004200241346a2204280200360200200420053602002002200336022c200220063602182002200036021c20022003360228200241286a103f200228021c417f6a20022802186b210003402000417f470440200228021820006a20013c0000200742388620014208888421012000417f6a2100200742088821070c010b0b200220022802182200200228021c20006b10011a200241186a10420b200241406b24000b9c0202057f047e230041306b22032400200341206a2101200341206a10022102034020020440200742088620064238888421072002417f6a210220013100002006420886842106200141016a21010c010b0b200010212200101b200341186a21010340200341106a2006200710232003200329031022082001290300220910242000200329030020067ca741bc0a6a2c0000101c2006420956200742005220075020082106200921071b0d000b0240200028020420002d00002201410176200141017122011b2204450d0020042000280208200041016a20011b22026a417f6a21010340200220014f0d0120022d00002100200220012d00003a0000200120003a00002001417f6a2101200241016a21020c000b000b200341306a24000bcb0601077f230041e0006b220224002002410036022820024200370320027f200128020420012d00002203410176200341017122061b220341014e04402001280208200241206a200310472104200241406b200241286a3602002002410036023c410020022802206b2108200141016a20061b2101200404402004100f21050b200220053602302002413c6a200420056a3602002002200520086a220536023820022005360234200241386a2104034020030440200520012d00003a00002004200428020041016a22053602002003417f6a2103200141016a21010c010b0b20022002280220220120022802346a2203360234410020016b220441014e0440200320012004100b1a0b200241386a2002280224220141014e047f200241386a200541002001100b20016a220536020020022802240520010b360200200241286a2201280200210420012002413c6a220128020036020020012004360200200220022802202201360234200220033602202002200536022420022001360230200241306a103f2002280220210320022802240c010b4100210341000b21012003200120036b200241306a4120100341002103034020034120470440200220036a41003a0000200341016a21030c010b0b200241086a2002290338370300200241186a200241c8006a290300370300200241106a200241406b29030037030020022002290330370300200241306a41bd0b10482105200241d8006a410036020020024200370350200241d0006a200528020420022d0030220141017620014101711b220141406b101f027f20022d00302203410171450440200541016a210420034101760c010b20052802082104200541046a2802000b210641002103200241d0006a200120042006101e200241d0006a4101722104200241d8006a21060340200341204704402006280200200420022d00504101711b20016a200220036a2d0000220741047641be0b6a2d00003a00002006280200200420022d00504101711b20016a41016a2007410f7141be0b6a2d00003a0000200341016a2103200141026a21010c010b0b200510172000200241d0006a41ba0b1010101d2201290200370200200041086a200141086a28020036020020011020200241d0006a1017200241206a1042200241e0006a24000b39002001417f4a0440200028020820002802006b220041feffffff034d047f20012000410174220020002001491b0541ffffffff070b0f0b000b1f0020004200370200200041086a41003602002000200120011010101520000b2301027f230041106b22002400200041c70a10482201104a20011017200041106a24000bd10201067f230041e0006b22012400200141186a104b2104200141d8006a4100360200200141d0006a4200370300200141c8006a420037030020014200370340410121030240200141306a20001014220528020420012d00302202410176200241017122061b2202450d0002400240200241014604402005280208200541016a20061b2c0000417f4a0d030c010b200241384f0d010b200241016a21030c010b200241016a210303402002450d01200341016a2103200241087621020c000b000b2001200336024020051017200141406b410472104c20042003104d2001200141086a200010142200280208200041016a20002d0000220341017122021b36024020012000280204200341017620021b3602442001200129034037030020042001103c20001017200428020c200441106a28020047044010000b2004280200200428020410042004104e200141e0006a24000b2900200041003602082000420037020020004100105b200041146a41003602002000420037020c20000bdc0201067f200028020422012000280210220241087641fcffff07716a2103027f2001200028020822054704402001200028021420026a220441087641fcffff07716a280200200441ff07714102746a2106200041146a21042003280200200241ff07714102746a0c010b200041146a210441000b2102034020022006470440200241046a220220032802006b418020470d0120032802042102200341046a21030c010b0b20044100360200200041086a21020340200520016b410275220341034f044020012802001a200041046a2201200128020041046a2201360200200228020021050c010b0b0240200041106a027f2003410147044020034102470d024180080c010b4180040b3602000b03402001200547044020012802001a200141046a21010c010b0b200041086a22032802002101200041046a280200210203402001200247044020032001417c6a22013602000c010b0b20002802001a0b13002000280208200149044020002001105b0b0b1c01017f200028020c22010440200041106a20013602000b2000105c0b2501017f230041206b22012400200141086a2000103e200141086a10061a200141206a24000b2600230041106b22012400200141003a000f20002001410f6a104320001007200141106a24000b2300230041106b220124002000200141cd0a10482200103e20001017200141106a24000bac0402037f017e23004190016b22002400100a10082201100e220210092000200136027c2000200236027820002000290378370318200041f8006a200041306a200041186a411c102822014100102f02400240200041f8006a10532203500d0041f80a10542003510d0141fd0a105420035104402000410036022c2000410236022820002000290328370308200041086a10550c020b41820b10542003510440200041c8006a1021210220004200370358200041f8006a20014101102f200041f8006a20021056200041f8006a20014102102f2000200041f8006a1053370358200041f8006a2002101422012000290358104420011017200210170c020b418b0b10542003510440200041f8006a1045200041f8006a104a200041f8006a10170c020b41910b10542003510440200041e8006a102121022001200041e8006a1057200041f8006a200041c8006a2002101422011046200041f8006a104a200041f8006a101720011017200210170c020b41960b1054200351044010490c020b419e0b10542003510d0041a40b10542003510440200041f8006a20014101102f200041f8006a10532203420188420020034201837d854201520d0210050c020b41ab0b10542003510440200041c8006a102121022001200041c8006a1057200041f8006a200210142201104f20011017200210170c020b41b30b10542003520d00200041003602242000410336022020002000290320370310200041106a10550c010b10000b20004190016a24000b850102027f017e230041106b22012400200010310240024020001032450d002000280204450d0020002802002d000041c001490d010b10000b200141086a20001059200128020c220041094f044010000b200128020821020340200004402000417f6a210020023100002003420886842103200241016a21020c010b0b200141106a240020030b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010bc90201047f23004180016b2201240041012103200141186a200141106a20002802044101756a2000280200110000200141306a104b210241002100200141e0006a4100360200200141d8006a4200370300200141d0006a420037030020014200370348200141f8006a200141286a280200360200200141f0006a200141206a290300370300200120012903183703680240034020004114460d01200141e8006a20006a200041016a21002d0000450d000b411521030b20012003360248200141c8006a410472104c20022003104d200141d8006a200141286a280200360200200141d0006a200141206a2903003703002001411436026c200120012903183703482001200141c8006a360268200120012903683703082002200141086a103c200228020c200241106a28020047044010000b2002280200200228020410042002104e20014180016a24000b890301057f230041206b22022400024002400240024002402000280204450d0020002802002d000041c0014f0d00200241186a200010592000102b2103200228021822000440200228021c220420034f0d020b41002100200241106a410036020020024200370308410021030c020b200241086a10211a0c030b200241106a410036020020024200370308200420032003417f461b22034170490440200020036a21052003410a4d0d01200341106a4170712206100f21042002200336020c20022006410172360208200220043602100c020b000b200220034101743a0008200241086a41017221040b034020002005470440200420002d00003a0000200441016a2104200041016a21000c010b0b200441003a00000b024020012d0000410171450440200141003b01000c010b200128020841003a00002001410036020420012d0000410171450d00200141086a2802001a200141003602000b20012002290308370200200141086a200241106a280200360200200241086a1020200241086a1017200241206a24000b2801017f230041206b22022400200241086a20004101102f200241086a20011056200241206a24000b940101037f200120012802042000280204200028020022046b22026b2203360204200241004a0440200320042002100b1a200141046a28020021030b2000280200210220002003360200200141046a22032002360200200041046a220228020021042002200128020836020020012004360208200028020821022000200128020c3602082001200236020c200120032802003602000be60101047f2001102b2204200128020422024b04401000200141046a28020021020b200128020021052000027f024002400240027f0240200204404100210120052c00002203417f4c0d012005450d030c040b41000c010b200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a210120050d010b410021030c010b410021032002200149200120046a20024b720d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b2a01017f41142102034020020440200020012d00003a00002002417f6a2102200041016a21000c010b0b0b3601017f200028020820014904402001100e20002802002000280204100b21022000105c200041086a2001360200200020023602000b0b080020002802001a0b0b9a01010041bc0a0b9201303132333435363738390068656c6c6f0030783439333330313731323637314164613530366261364361373839314634333644323931383538323100696e69740061646472007472616e736665720076616c75650073686133007272657475726e0070616e6963007265766572740064657374726f79006f726967696e003078000030313233343536373839616263646566";

    public static String BINARY = BINARY_0;

    public static final String FUNC_SHA3 = "sha3";

    public static final String FUNC_VALUE = "value";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_RRETURN = "rreturn";

    public static final String FUNC_PANIC = "panic";

    public static final String FUNC_REVERT = "revert";

    public static final String FUNC_DESTROY = "destroy";

    public static final String FUNC_ORIGIN = "origin";

    public static final String FUNC_ADDR = "addr";

    protected InnerFunction_2(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected InnerFunction_2(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<InnerFunction_2> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(InnerFunction_2.class, web3j, credentials, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<InnerFunction_2> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(InnerFunction_2.class, web3j, transactionManager, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<InnerFunction_2> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(InnerFunction_2.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public static RemoteCall<InnerFunction_2> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(InnerFunction_2.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue);
    }

    public RemoteCall<String> sha3(String str) {
        final WasmFunction function = new WasmFunction(FUNC_SHA3, Arrays.asList(str), String.class);
        return executeRemoteCall(function, String.class);
    }

    public RemoteCall<String> value() {
        final WasmFunction function = new WasmFunction(FUNC_VALUE, Arrays.asList(), String.class);
        return executeRemoteCall(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transfer(String addr, Uint64 amount) {
        final WasmFunction function = new WasmFunction(FUNC_TRANSFER, Arrays.asList(addr,amount), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transfer(String addr, Uint64 amount, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_TRANSFER, Arrays.asList(addr,amount), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public void rreturn() {
        throw new RuntimeException("cannot call constant function with void return type");
    }

    public RemoteCall<TransactionReceipt> panic() {
        final WasmFunction function = new WasmFunction(FUNC_PANIC, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> panic(BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_PANIC, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<TransactionReceipt> revert(Int64 flag) {
        final WasmFunction function = new WasmFunction(FUNC_REVERT, Arrays.asList(flag), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> revert(Int64 flag, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_REVERT, Arrays.asList(flag), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<TransactionReceipt> destroy(String addr) {
        final WasmFunction function = new WasmFunction(FUNC_DESTROY, Arrays.asList(addr), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> destroy(String addr, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_DESTROY, Arrays.asList(addr), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<WasmAddress> origin() {
        final WasmFunction function = new WasmFunction(FUNC_ORIGIN, Arrays.asList(), WasmAddress.class);
        return executeRemoteCall(function, WasmAddress.class);
    }

    public RemoteCall<WasmAddress> addr() {
        final WasmFunction function = new WasmFunction(FUNC_ADDR, Arrays.asList(), WasmAddress.class);
        return executeRemoteCall(function, WasmAddress.class);
    }

    public static InnerFunction_2 load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new InnerFunction_2(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static InnerFunction_2 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new InnerFunction_2(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
