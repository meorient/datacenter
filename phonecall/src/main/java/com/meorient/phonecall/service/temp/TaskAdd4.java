package com.meorient.phonecall.service.temp;

import java.util.HashMap;
import java.util.Map;

import com.meorient.common.util.HttpClientTool;
import com.meorient.common.util.JsonTool;

/**
 * @功能:
 * @项目名:phonecall
 * @作者:chuxu
 * @日期:2019年4月30日上午10:55:33
 */
public class TaskAdd4{
	static String[] companyId = {"137335","433408","1069405","1167597","1346182","1451771","1518214","1552228","1587628","1628988","1699688","1726038","1770588","2013887","2070586","2164123","2183351","2299683","2300416","2373565","2435939","2470607","2508701","2524059","2662994","2679934","2734083","2759862","2761922","2786575","2803343","2818074","2897990","2909930","3022905","3024133","3024642","3037243","3042402","3042413","3047571","3048295","3053805","3056193","3058400","3058665","3058937","3063091","3063518","3064595","3072727","3075988","1567130","1624844","2208951","3077165","772878","1035823","1038148","1044508","1080630","1253974","1367565","1386826","1462512","1520714","1684915","1733595","1766629","1819462","1827539","1887123","1922469","1979716","2100379","2118172","2166518","2190373","2216287","2229748","2267670","2310980","2315539","2375707","2383169","2541714","2776984","2789987","2821809","2832234","2969572","2977081","3023656","3023670","3024845","3039444","3039757","3042060","3046728","3051751","3055561","3056816","3060459","3060658","3067291","3069532","3072847","3073271","124279","1037828","1052099","1315612","1353833","1355104","1445277","1510243","1566762","1579287","1635277","1697734","1712877","1725872","1947174","1949902","2038390","2043951","2044404","2094503","2118991","2120250","2132617","2358919","2387602","2414506","2417670","2511522","2533274","2774908","2784573","2799450","2806405","2826754","2888809","2924954","2978418","3022566","3024414","3037508","3044494","3045387","3048646","3053734","3054627","3054646","3055208","3059839","3064908","3072033","3072925","3075382","58312","114256","250560","270243","1033056","1042464","1045668","1172840","1322519","1380138","1460705","1517260","1613188","1627093","1680183","1757604","1896389","2124866","2127398","2138781","2362294","2384308","2407379","2421547","2739613","2740396","2793001","2794014","2809572","2870182","2870523","2871906","2953472","2971074","2981264","2981273","3022370","3023704","3040546","3049389","3053694","3056344","3056926","3058608","3060683","3061156","3064225","3065817","3067501","3071483","3073149","3073687","3074349","236423","329863","513974","943374","1039710","1349508","1455596","1463091","1469269","1483025","1498150","1500975","1715885","1734436","1777774","1982601","2024728","2202370","2301319","2405149","2484145","2517459","2608754","2616919","2690034","2743308","2796276","2898981","2969040","2973964","2977733","2988268","3024418","3024932","3037654","3038043","3041897","3046852","3049746","3050764","3050902","3051157","3055456","3055993","3060766","3061296","3064987","3066390","3069207","3071431","3073235","3099434","3099708","111708","169321","683525","749202","913676","1039749","1040089","1055042","1059604","1461192","1537885","1669792","1797772","1844286","2026772","2100751","2160874","2160937","2216398","2300941","2316510","2328257","2403864","2432259","2448119","2473907","2529698","2534722","2651764","2659037","2687935","2794712","2804573","2861896","2948891","3022568","3023640","3023847","3024633","3024980","3038127","3040250","3046882","3052329","3059935","3060895","3063137","3066676","3068374","3069054","3074672","3076160","82347","241261","250552","389749","527541","542465","649293","862936","1041320","1048266","1052076","1463093","1482419","1529730","1530429","1550992","1569303","1827545","2158511","2258820","2278246","2439199","2493831","2528815","2557552","2688896","2745622","2758148","2773952","2797315","2800590","2806400","2808873","2952190","2975482","2978228","2982905","3023554","3023962","3037571","3041904","3046597","3051167","3053224","3053263","3054981","3055785","3056629","3063656","3064062","3070647","3073195","3073906","3076859","2860077","1379411","1715719","2801534","2318437","1054389","2119072","1544888","2685628","3023850","3048012","1633811","2775238","3045270","2381443","151320","3060079","1755382","3072679","2318222","2145199","1707172","3049874","1690235","3059119","184931","1615526","2539131","841750","3059724","2798898","2817783","2074881","3023857","1899438","2514188","3050940","3047874","2616868","3052641","2530704","3048546","3022544","3024688","1316391","2778185","1475368"};
	static String[] companyName = {"宁波彼德纺织品有限公司","余姚市贝拉电器有限公司","宁波瑞迪艾特户外用品有限公司","宁波亚达电器有限公司","慈溪宇洋国际贸易有限公司","宁波市北仑富斯达进出口有限公司","宁波格芮特进出口有限公司","宁波百辉日用品有限公司","宁波邦胜进出口有限公司","宁波北仑艾科思进出口公司","宁波荣昌祥服饰股份有限公司","宁波雅励进出口有限公司","慈溪海帝国际贸易有限公司","宁波春晖文具有限公司","宁波三A集团有限公司","宁波京辉进出口有限公司","宁波众融服饰有限公司","浙江厚金贸易有限公司","宁波天林塑胶有限公司","宁波市北仑富斯特旅游用品有限公司","宁波利铭金属制品有限公司","宁波市甬陵轻工实业有限公司","宁波辛克进出口有限公司","宁波策和休闲用品有限公司","宁波中蔺对外贸易有限公司","宁波福达旅游帐篷有限公司","宁波步来特电器有限公司","宁波甬南时代制衣有限公司","宁波市家电日用品进出口公司","宁波格兰德礼品文具有限公司","慈溪市都佳电器有限公司","宁波瑞格文具有限公司","宁波永发进出口有限公司","宁波普鲁司旅游用品有限公司","宁海县百特户外用品有限责任公司","宁波创青恒达金属制品有限公司","宁波狮丹努集团有限公司","宁海县凯盛文具有限公司","宁波甬南针织有限公司","宁波市禾源纺织品有限公司","宁波百瑞制衣有限公司","宁波众邦国际贸易有限公司","宁波中包进出口有限公司","宁波鼎华实业有限公司","宁波新禾控股集团有限公司","宁波甬泰平进出口有限公司","宁波博闻进出口有限公司","宁波弘生利泰进出口有限公司","宁波简妮进出口有限公司","浙江新景进出口有限公司","宁波瑞尔高分子科技有限公司","宁波贝宏进出口有限公司","宁波高新区森帕贸易有限公司","宁波高新区克里西国际贸易有限公司","宁波森夏服饰有限公司","奉化市金海制衣有限公司","宁波美博进出口有限公司","慈溪市颖光制衣有限公司","宁波云峰文具有限公司","余姚市成功文具制造有限公司","宁波慧虹时装设计有限公司","宁波豪雅进出口集团有限公司","宁波美乐奇日用品有限公司","宁波永润国际贸易有限公司","宁波易派诺文具有限公司","宁波高品文具有限公司","宁波中基进出口有限公司","宁波市瀚洋进出口有限公司","宁波宝林达进出口有限公司","宁波友和对外贸易有限公司","浙江兴达文具有限公司","慈溪市长城制笔有限公司","宁波布利杰澳兰波针织有限公司","宁波金博文具有限公司","慈溪市鑫明进出口有限公司","浙江布利杰集团有限公司","宁波市宁海县国际贸易公司","宁波市鄞州优迪文具有限公司","广博集团股份有限公司","宁波长隆进出口有限公司","宁波伟书文具有限公司","宁海千彩文教用品有限公司","宁波恒威进出口有限公司","宁波永信进出口有限公司","宁波榆林金属制品有限公司","宁波越洲文教用品有限公司","宁波镇海承迪文具有限公司","宁波赛龙进出口有限公司","宁波星登进出口有限公司","宁波神乐科教器材有限公司","宁波弘烨进出口有限公司","宁海辉辉文具有限公司","宁波英特赛电子安全设备有限公司","中基宁波集团股份有限公司","爱文易成文具有限公司","恩凯控股有限公司","宁波中基惠通集团股份有限公司","宁波雅唐日用品有限公司","宁波中工美进出口有限责任公司","宁波市文魁控股集团有限公司","宁波美风进出口有限公司","宁波钟声服饰实业有限公司","宁波蓓蕾文具制造有限公司","贝发集团股份有限公司","宁波杰丽斯文具有限公司","宁波兆生文具有限公司","青华科教仪器有限公司","宁波海田控股集团有限公司","宁波禾采医疗器械有限公司","宁波美迪克进出口有限公司","宁波松立文具礼品制造有限公司","宁波超时文具制造有限公司","宁波禾博保健品实业有限公司","余姚市曙光文具制造有限公司","慈溪以琳文具制造有限公司","宁波神宇医疗器械有限公司","宁波中冠工贸有限公司","宁波泰育文具有限公司","宁波巨翔文具有限公司","慈溪市金盛进出口有限公司","宁波金丰文具礼品制造有限公司","宁波富时进出口有限公司","余姚市金狼制笔有限公司","宁波锦宇电器有限公司","宁波博达联合进出口有限公司","宁波百仕高联合工业有限公司","宁波戴维医疗器械股份有限公司","宁波雯帆国际贸易有限公司","宁波恒明联合进出口有限公司","宁波振达文具有限公司","宁波百乐文具制造有限公司","宁海县远铭文具有限公司","宁波市北仑雁雁文具有限公司","余姚市亚世亚文具制造有限公司","余姚市江文笔业有限公司","宁波亚虎进出口有限公司","宁波贝予文具有限公司","宁波华丰文具有限公司","宁波新思格进出口有限公司","宁波天荣进出口有限公司","宁波市镇海区深蓝文具制造有限公司","宁波格林笔业有限公司","宁波义文堂文具有限公司","宁波市金苑进出口有限公司","宁波凯尔登进出口有限公司","宁波胜富龙贸易有限公司","宁波英锐维格贸易有限公司","宁波博柯莱电子科技有限公司","宁波兴伟刀具科技有限公司","宁海县震洋文教用品有限公司","宁波联合集团进出口股份有限公司","宁波君安物产有限公司","宁波新豪仪进出口有限公司","宁波海森联合进出口有限公司","宁波森源进出口有限公司","宁波康佑达进出口有限公司","浙江帅孚安全科技股份有限公司","宁波维尼国际贸易有限公司","余姚市亿利达文体用品有限公司","宁波天虹文具有限公司","宁波镇海百纳工艺品有限公司","宁波名亿德进出口有限公司","宁波市鄞州斯蒂科家纺有限公司","宁波快乐风对外贸易有限公司","宁波得通进出口有限公司","宁波市群安进出口有限公司","宁波晨东运动保健用品有限公司","宁波志汇服饰有限公司","余姚市中元塑业电器有限公司","慈溪市精忠畜产品有限公司","宁波赛孚汀服饰工贸有限公司","宁波欧迈服饰有限公司","宁波金山文体用品有限公司","宁波友和体育用品有限公司","宁波维克波体育用品有限公司","宁波爱尔妮服饰有限公司","宁波黎宝进出口有限公司","余姚市平安不锈钢制品有限公司","宁波丹盈服饰有限公司","宁波市海曙永达针织制衣有限公司","宁波易洲进出口有限公司","宁波隆凯进出口有限公司","宁波海斯曼科技发展有限公司","慈溪赛洁日用品有限公司","宁波汉高国际贸易有限公司","宁波敦煌进出口有限公司","宁波新贵族运动用品有限公司","宁波鄞州钢盈服饰有限公司","宁波金峰文体器材有限公司","宁波市鄞州天燕国际贸易有限公司","宁波威骏休闲用品有限公司","宁波经济技术开发区汇星贸易有限公司","宁波兴中雅国际贸易有限公司","宁波天鹅体育用品制造有限公司","宁波晟容进出口有限公司","宁波华中进出口有限公司","宁波伟楷进出口有限公司","宁波中基人和国际贸易有限公司","宁波海曙帕蒂诺工贸有限公司","宁波维科工贸有限公司","宁波汇泽体育用品有限公司","余姚义荣工艺旅游用品有限公司","宁波赛尔国际贸易有限公司","宁波桑泰制衣有限公司","宁波中瑞进出口有限公司","宁波酷尔皮划艇有限公司","宁波市曼林对外贸易有限公司","爱伊美集团有限公司","宁波宁电进出口有限公司","宁波银瑞有机硅科技发展有限公司","宁波天辉进出口有限公司","宁波赛特运动器材有限公司","宁波荣正进出口有限公司","宁波铜钱桥食品开发有限公司","宁波普菲克纺织品有限公司","宁波珂弘贸易有限公司","宁波启翔工艺品有限公司","宁波维欣家纺工业有限公司","宁波阿拉酿酒有限公司","宁波益民酒业有限公司","宁波新成鞋业有限公司","余姚市澳通日用品有限公司","浙江中世进出口有限公司","宁波大洲进出口有限公司","宁波雅文国际贸易有限公司","宁波市老虎鱼地毯有限公司","宁波舒尔美鞋业有限公司","宁波馨利家居用品有限公司","宁波引发绿色食品有限公司","余姚圣笛雅家居用品有限公司","宁波恒康食品有限公司","宁波百迪进出口有限公司","宁波市得文进出口有限公司","宁波金步国际贸易有限公司","宁波国盛食品有限公司","宁波轩尼国际贸易有限公司","余姚南翔工艺服饰有限公司","宁波通邦家居用品有限公司","宁波界界乐国际贸易有限公司","宁波奥森健身器材科技有限公司","宁波海洋纺织品有限公司","宁波佳必可食品有限公司","宁波瑞翔久信进出口有限公司","宁波市源重进出口有限公司","宁波金茂进出口有限公司","宁波金鱼电器有限公司","宁波世贸通国际贸易有限公司","宁波市豪情进出口有限公司","宁波富茂进出口有限公司","宁波汇豪纺织品有限公司","宁波万时集团有限公司","宁波市恒翔进出口有限公司","宁波市信利达贸易有限公司","宁波秉航电子科技有限公司","宁波海曙凯亘鞋业有限公司","宁波爱太家纺有限公司","宁波市江东辉宏进出口贸易有限公司","宁波彬彬进出口有限公司","宁波中天家居用品有限公司","宁波今日食品有限公司","宁波丛林进出口有限公司","宁波晶圆贸易有限公司","宁波埃丽塔国际贸易有限公司","宁波锦灏进出口有限公司","宁波陆尊国际贸易有限公司","宁波宁泰酿酒有限公司","洛兹集团有限公司","宁波萌恒工贸有限公司","宁波华孚进出口有限公司","象山盛发电子装饰有限公司","宁波普瑞供应链服务有限公司","宁波振利纺织品有限公司","宁海县创进国际贸易有限公司","宁波三邦线业有限公司","宁波绿色纺织品有限公司","宁波新腾针业有限公司","宁波维力斯国际贸易有限公司","宁波香悦龙立进出口有限公司","宁波兰冠工贸有限公司","宁波市海曙开元织造厂","宁波市东盛纺织有限公司","宁波瑞达国际经贸有限公司","宁波博瀚工艺品有限公司","宁波汇点家纺服饰有限公司","宁波凯邦外贸服务有限公司","宁波工艺国际贸易有限公司","宁波志兴工贸有限公司","宁波美成工贸发展有限公司","宁波宏慧纺织品有限公司","宁波盛丰纺织有限公司","宁波幸园植绒有限公司","宁波新金丰纺织工艺品工贸有限公司","宁波舒佳国际贸易有限公司","宁波弘祥工艺包装制品有限公司","余姚佳顺进出口有限公司","宁波志达纺织品有限公司","宁波高歌国际贸易有限公司","宁波致和对外贸易有限公司","宁波天一纺织线业有限公司","宁波三邦日用品有限公司","宁波市鄞州东林家纺制品厂","宁波佰莱克斯纺织品有限公司","宁波圣德隆进出口有限公司","宁波市弘灵国际贸易有限公司","宁波经济技术开发区黑安娜联合国际贸易有限公司","宁波江北优科家居用品有限公司","宁波市雅饰家进出口有限公司","宁波大发化纤有限公司","宁波萌恒进出口有限公司","宁波田丰进出口有限公司","余姚联合纺织进出口有限公司","宁波万合进出口有限公司","宁波明辉寝具有限公司","宁波十方进出口有限公司","宁波市同一国际贸易有限公司","宁波一翔进出口有限公司","宁波春秋进出口有限公司","慈溪市亚太化纤线业有限公司","宁波高登泰进出口有限公司","宁波美联外贸服务有限公司","宁波合羽国际物流有限公司","宁波凯越国际贸易有限公司","宁波恒远制衣有限公司","象山海阳科教仪器有限公司","宁波市镇海美联国际贸易服务有限公司","浙江久而久化学有限公司","宁波市镇海佳盛文具有限公司","宁波夏风框业有限公司","宁波康楠服饰有限公司","宁波利博文具有限公司","宁波汇隆文具有限公司","余姚市对外贸易有限公司","宁波海雯文具有限公司","宁波升纺制衣有限公司","宁波新丽联合进出口有限公司","宁波鸿雁包装材料有限公司","宁波五云笔业有限公司","宁波海曙杰欧进出口有限公司","宁波凡风服饰有限公司","宁波明日文体进出口有限公司","宁波诺布尔制衣实业有限公司","宁波乐事达文具有限公司","宁波祥丰进出口有限公司","宁波正阳针织有限公司","宁波奥菲斯莱恩国际贸易有限公司","宁波市诚邦办公设备有限公司","宁波旭日对外贸易有限公司","宁波安迪凯文进出口有限公司","宁波市太可印刷有限公司","宁波大通制衣有限公司","宁海县紫南对外贸易有限公司","宁波嘉禾教学仪器有限公司","宁波合羽国际贸易有限公司","宁波康大美术用品集团有限公司","宁波市翔皇进出口有限公司","宁波宁澳服饰有限公司","宁波合益制衣有限公司","宁波雪人日用品有限公司","宁波嘉士博文具有限公司","宁波林佳塑业有限公司","宁海友达文具有限公司","宁波宁兴恒骐国际贸易有限公司","宁波四象进出口有限公司","香溢融通控股集团股份有限公司","宁波市纺织品进出口有限公司","宁波优智达国际贸易有限公司","宁波高度进出口有限公司","宁波市联合爱华进出口有限公司","宁波宁兴贸易集团有限公司","宁波华艺服饰有限公司","宁波瑞宝百事达文具有限公司","宁波贝通进出口有限公司","慈溪市登州工艺品厂","慈溪市蓝天帽业有限公司","慈溪市天工帽业公司","慈溪市长河镇乡下佬帽厂","宁波阿拉秀产品设计有限公司","宁波百纳针织制衣有限公司","宁波贝来旅游用品有限公司","宁波博洋控股集团有限公司","宁波布莱莲特国际贸易有限公司","宁波戴宗仁德工贸实业有限公司","宁波东平服饰有限公司","宁波合富国际贸易有限公司","宁波恒良国际经贸合作有限公司","宁波恒润进出口有限公司","宁波华天进出口有限公司","宁波华鑫手袋制品有限公司","宁波佶云福户外用品有限公司","宁波佳达进出口有限公司","宁波嘉顿国际贸易有限公司","宁波巾冠帽业有限公司","宁波金尔马电子有限公司","宁波凯澜进出口有限公司","宁波凯洋国际贸易有限公司","宁波雷克对外贸易有限公司","宁波联派进出口有限公司","宁波恰恰环龙服饰有限公司","宁波恰恰帽业有限公司","宁波锐拓进出口有限公司","宁波盛纳国际贸易有限公司","宁波市柏丽凯日用工艺品有限公司","宁波市奉化翔丰贸易有限公司","宁波市恒生帽业有限公司","宁波市江北喜福来服饰有限公司","宁波市开利户外用品制造有限公司","宁波斯威提进出口有限公司","宁波天久进出口有限公司","宁波维多利亚工艺品有限公司","宁波维拓服饰有限公司","宁波香溢进出口有限公司","宁波新海威进出口有限公司","宁波雅品进出口有限公司","宁波伊加嘉针织厂","宁波亿泰控股集团股份有限公司","宁波英利贸易有限公司","宁波中科进出口有限公司","宁波宗华塑料制品有限公司","余姚市嘉森圣诞饰品有限公司"};
	
	public static void main(String[] args) throws Exception {
		System.out.println(companyId.length);
		String[] custId ={"56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56553","56572","56572","56572","56572","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56580","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56582","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56615","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56647","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56748","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56768","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572","56572"};
		String[] custName ={"周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","周昕媛","曹琼留","曹琼留","曹琼留","曹琼留","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","钱城","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","闫路路","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","洪京康","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","杨凯","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","闫迎利","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","王梦婷","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留","曹琼留"};
		if(custId.length!=custName.length || companyId.length!=companyId.length||custName.length!=companyName.length) {
			System.out.println("数量不一致");
			return;
		}
		
		int count = 0;
		
		Map<String,String> params = new HashMap<String,String>();
		temp t = new temp();
		temp2 t2 = new temp2();
		t.setAddress("-");
		// 必填
		for(int i=count;i<custId.length;i++) {
			t.setSalesmanCode(String.valueOf(custId[i]));
			t2.setVisitPerson(String.valueOf(custId[i]));
			t2.setActualParticipant(String.valueOf(custId[i]));
		t.setCompanyName(String.valueOf(companyName[i]));
		t.setCustomerCode(String.valueOf(companyId[i]));
		t.setSalesmanName(String.valueOf(custName[i]));
		t.setDate("2019-05-04");
		
		t2.setCustomerId(String.valueOf(companyId[i]));
		t2.setVisitCustomer(String.valueOf(companyName[i]));
		t2.setPersonOfBusinessTrip(String.valueOf(custName[i]));
		
		t2.setDateOfBusinessTrip("2019-05-04");
		params.put("maltCrmVisit", JsonTool.getString(t));
		params.put("maltCrmVisitInfo", JsonTool.getString(t2));
		
		Map<String, String> headers = new HashMap<String,String>();
		System.out.println(params);
		headers.put("cookie", "JSESSIONID="+Config.JSESSIONID+"; Hm_lvt_6abcc5eeee320072f7a9ed10e79be5c1=1555658542; gr_user_id=a375d114-a352-464d-93bf-a1064e54d348; Hm_lpvt_6abcc5eeee320072f7a9ed10e79be5c1=1555658542");
		
		String result = "";
		try {
			result = HttpClientTool.postParames(HttpClientTool.getSSLContext(), "https://40.73.105.15/wxqyh-web/visit/visitPlan!addVisitPlan.action?dqdp_csrf_token="+Config.TOKEN, headers,params);
		} catch (Exception e) {
			Thread.sleep(20000L);
			i--;
			continue;
		}
		System.out.println(result);
		System.out.println("已完成：" + ++count);
		
		Thread.currentThread();
		Thread.sleep(1000L);
		}
		System.out.println("全部完成");
	}
}
