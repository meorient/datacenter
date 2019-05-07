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
public class TaskAdd3{
	static String[] companyId = {"2105904","3023812","1136108","672229","3065837","2997132","1612063","2978553","2383129","617716","2877096","3052972","2712557","2660254","3042836","2775264","2947838","2041199","3070874","1038141","1945869","2601845","2728791","398221","2844672","2191324","312025","3061167","1994864","1669493","3072409","3039261","3055255","1665412","851215","2465341","1998438","2758134","1856190","2927182","2820765","869127","3044446","3062665","1727187","3052727","264457","2268722","3022727","2793361","3007928","2288051","1031127","2821403","2599467","2605201","781450","2820582","2651961","739550","1655733","2436773","1640126","1661458","1867263","2534747","1677874","3073549","2891431","2688930","3023909","3053719","3056954","3059718","3046089","1469254","3055083","3044842","3071509","2512295","2046423","1062003","3068471","3062321","2288101","2064868","1888270","3023696","3040555","3048599","3045983","3062499","3059758","2907214","2427537","3060253","1554424","219224","2517488","3004131","3002901","2280715","2816923","2752994","1992478","2886547","2769970","1758468","1531923","2634139","2158301","2813469","1524762","1918267","3007633","3004153","1804669","1553660","3003753","1116034","2009493","2779951","918699","1479379","2915605","1039970","2817297","912396","2033159","2804058","2267343","1986678","2259795","1755319","921545","2816591","2013516","2768787","2010162","1871487","1687076","1977720","3023574","1984501","2790485","2151362","3003691","2877914","1714931","1536226","2144177","3022899","659181","2924252","1562131","2756143","2359945","2874202","3050283","2884030","3004358","2426868","256116","1814560","2749668","147263","1530845","932093","2255962","2636925","2375600","3070262","2335350","3044489","61534","2265025","2576995","659214","2353783","2384672","3002647","1668115","1440857","1059614","3024430","945572","2228531","2952150","2555237","2745645","2203778","1455367","1934869","1038081","2241983","558238","3057920","1613633","3024483","2192976","2790776","2815215","2837739","3001436","1722160","2142783","2189482","1918853","2648859","2399867","1033108","2411321","2788099","2875937","3051219","1819275","2646647","2354828","1031772","3001253","3001159","2147707","2891442","1749515","2825418","2234829","3001021","3000700","1895159","3001886","1557761","3023191","3040508","2763904","3059753","3022585","1238839","341286","3001966","3001706","1396003","3001431","484087","1945085","3022722","736368","2600057","2432253","3051762","3044516","525681","3052117","2213786","3036945","1032206","1559579","2647460","2520978","2528481","1354773","2709855","1601628","3023813","1717397","2903495","2738389","3024196","3052369","1731915","2932143","3071161","1817573","2825211","1305104","2374731","1988440","2690194","1058359","1703783","1943530","1468763","1633384","2709076","715767","1650740","1356369","1934747","3052132","2274620","1052478","1913399","2790378","2445802","2970308","2514033","2733496","1064015","3106290","183154","3073434","2711320","1953152","2847748","2290772","3023881","3072240","1034111","2634659","1461688","2535259","887403","2881774","2159996","1048723","2351918","3068016","1443586","2610602","3062952","1864085","2687564","1044516","3041410","822830","3042105","1966017","1584831","3060993","3037856","1451158","2643374","3075722","1457785","2786301","3041203","2393887","1725524","2399860","1954403","2512660","2055830","3043444","3051980","2433766","3060973","3008386","1566040","1206947","1872728","3119252"};
	static String[] companyName = {"浙江家合服饰股份有限公司","苍南县嘉丰复合材料有限公司","丰华科技发展有限公司","巨一集团有限公司","乐清市麒麟摩配有限公司","瑞安市赛维进出口贸易有限公司","台州市国际贸易有限公司","温州成功集团有限公司","温州大津进出口有限公司","温州大西洋进出口有限公司","温州东博贸易有限公司","温州奋起服饰有限公司","温州富捷科技股份有限公司","温州歌珊进出口有限公司","温州和合拉链有限公司","温州宏瑞文具有限公司","温州鸿海国际贸易有限公司","温州捷程国际贸易有限公司","温州金麟对外贸易有限公司","温州金马文具用品制造有限公司","温州晋华国际贸易有限公司","温州卡曼国际贸易有限公司","温州凯文文体用品制造有限公司","温州隆亨乳胶制品有限公司","温州隆源国际贸易有限公司","温州陆港国际贸易有限公司","温州瓯信外贸有限公司","温州奇越工艺品有限公司","温州侨瑞皮业有限公司","温州圣蓝工贸有限公司","温州盛丰笔业有限公司","温州市博联进出口有限公司","温州市豪维顿服饰有限公司","温州市弘邮纸品有限公司","温州市锦宇贸易有限公司","温州市利豪贸易有限公司","温州市绿景进出口有限公司","温州市慕沙进出口有限公司","温州市信毅国际贸易有限公司","温州拓欧进出口有限公司","温州新利宝文具有限公司","温州置臻实业有限公司","浙江宏顺鞋业有限公司","浙江华旭实业有限公司","浙江雷马鞋业有限公司","浙江森林实业有限公司","浙江天龙集团有限公司","浙江威斯乔雅制衣有限公司","浙江沃趣工贸有限公司","杭州康洁无纺制品有限公司","建德市艾维纺织制品有限公司","建德市豪运家纺制品厂","建德市凯荣纺织品有限公司","建德市万鹏家纺有限公司","建德市新帛家纺有限公司","金华美丝柯纺织工艺品有限公司","金华市澳美家地毯有限公司","金华市巨鑫机械制造有限公司","金华市信润服饰有限公司","金华兴华皮件有限公司","浦江迪欧家纺有限公司","永康市晨奥燃具有限公司","浙江金华爱德织物有限公司","浙江圣雪休闲用品有限公司","浙江一果进出口有限公司","浙江真爱时尚家居有限公司","浙江真爱毯业科技有限公司","佰和控股有限公司","泰马鞋业有限公司","温州宝威贸易有限公司","温州朝阳进出口有限公司","温州港鑫纺织品有限公司","温州国宏包装有限公司","温州国际经济技术合作有限公司","温州国际贸易集团有限公司","温州汇川科技有限公司","温州捷利达鞋业有限公司","温州金给利供应链管理服务有限公司","温州锦华国际贸易有限公司","温州乐腾皮件有限公司","温州恰索博贸易有限公司","温州市大通国际贸易有限公司","温州市瓯海凯士箱包厂","温州市尚威进出口贸易有限公司","温州市硕海进出口有限公司","温州市贞观国际贸易有限公司","温州雨泽无纺布有限公司","浙江豪中豪健康产品有限公司","浙江和丰鞋业有限公司","浙江鸿一箱包皮件有限公司","浙江金仕达工贸有限公司","浙江立昌健康产品科技有限公司","浙江璐瑶电子科技有限公司","浙江荣威鞋业有限公司","浙江省文成县对外贸易公司","浙江温州包装进出口公司","浙江亚洲人鞋业有限公司","杭州市桐庐远成制笔有限公司","温州天骄笔业有限责任公司","顶康科技有限公司","东阳市海外贸易有限公司","东阳市家博家居有限公司","东阳市金运服饰有限公司","东阳市螺山休闲用品有限公司","东阳市祥浩箱包有限公司","东阳市星晖皮具有限公司","东阳市秀之美针织服饰有限公司","东阳市宇鹏制衣有限公司","东阳市卓旅箱包有限公司","杭州伊斯特服装有限公司","建德市博乐纺织品有限公司","建德市晋源纺织品有限公司","建德市舒尼家纺有限公司","建德市永盛家纺有限公司","建德市中源家纺有限公司","永康市东龙进出口有限公司","浙江恒乐休闲用品有限公司","浙江宏力工具有限公司","浙江金拓机电有限公司","浙江上德工贸有限公司","浙江省东阳市祥丰实业有限公司","浙江盛铭工贸有限公司","浙江万鹏实业有限公司","浙江银光反光材料制造有限公司","安徽瀚洋国贸发展有限公司","东阳市吉荣塑料实业有限公司","杭州贝贝家科技有限公司","杭州福斯特包装制品有限公司","杭州露依尔纺织有限公司","杭州胜奇纺塑有限公司","杭州越华服装有限公司","杭州镇涵运动器材有限公司","建德龙马家纺有限公司","建德市红叶家纺有限公司","金华佰仕得体育用品有限公司","兰溪金威国际贸易有限公司","兰溪乾源工贸有限公司","兰溪市迈诺进出口有限公司","兰溪市神雕对外贸易有限公司","兰溪市圣宇毛巾有限责任公司","兰溪市伊德纺织品有限公司","兰溪市永新织造有限公司","永康市赛尔进出口有限公司","永康市升飞休闲用品有限公司","浙江博爱家纺有限公司","浙江大小姐家纺有限公司","浙江好视佳反光材料有限公司","浙江宏都寝具有限公司","浙江金兆纺织有限公司","浙江凯俐画材有限公司","浙江蓝之梦纺织有限公司","浙江立久佳运动器材有限公司","浙江领航工贸有限公司","浙江赛兰明道进出口有限公司","浙江三森纺织有限公司","浙江腾马纺织有限公司","浙江万来旅游工艺品有限公司","浙江万羽针织有限公司","浙江鑫兰纺织有限公司","浙江星空休闲用品有限公司","东阳市海派亚太进出口有限公司","杭州临安锦峰进出口有限公司","金华奥洋国际经贸有限公司","龙游天时旅游用品有限公司","牧高笛户外用品股份有限公司","浦江莱迪恩斯服饰有限公司","浦江瑞森服饰有限公司","浦江馨艺服饰有限公司","仙鹤股份有限公司","永康市一凡休闲用品有限公司","永康市宇翔铝业有限公司","浙江格林豪斯户外用品有限公司","浙江华意拉链有限公司","浙江四方进出口有限公司","诸暨梦丽特针纺织品有限公司","贝因美集团有限公司","淳安千岛湖恒搏纺织有限公司","淳安县千岛湖云宵贸易有限责任公司","杭州柏诚毛纺服饰有限公司","杭州超义实业有限公司","杭州方大贸易有限公司","杭州飞泰服饰有限公司","杭州富春江进出口有限公司","杭州富阳宝文鞋业有限公司","杭州富阳博卡体育用品有限公司","杭州富阳诚友贸易有限公司","杭州富阳春城进出口有限公司","杭州富阳福特威鞋业有限公司","杭州富阳黑石体育用品有限公司","杭州富阳龙腾鞋业有限公司","杭州富阳三江文体用品有限公司","杭州富阳亿源实业有限公司","杭州富阳中富贸易有限公司","杭州海利服饰有限公司","杭州瀚林生贸易有限公司","杭州恒通实业有限公司","杭州红畅进出口有限公司","杭州宏达文体用品有限公司","杭州宏欧家居有限公司","杭州杰灵体育用品有限公司","杭州金南工量具有限公司","杭州久积科技实业有限公司","杭州钜佳贸易有限公司","杭州凯莱领带服装有限公司","杭州苛美服饰有限公司","杭州来业进出口有限公司","杭州琅旭服饰有限公司","杭州罗龙科技实业有限公司","杭州美季服饰有限公司","杭州纽恩进出口有限公司","杭州启诚贸易有限公司","杭州千岛湖华丽饰品有限公司","杭州千岛湖啤酒有限公司","杭州瑞景包装有限公司","杭州桑普贸易有限公司","杭州商辂丝绸有限公司","杭州盛宏进出口有限公司","杭州帅克轻纺进出口有限公司","杭州双顺进出口有限公司","杭州思创贸易有限公司","杭州速普商用机器有限公司","杭州泰富纺织化纤有限公司","杭州同普贸易有限公司","杭州伟华进出口有限公司","杭州湘隽阻燃科技有限公司","杭州鑫尼克体育用品有限公司","杭州绚颖贸易有限公司","杭州湛恩进出口有限公司","杭州张氏通和鞋业有限公司","杭州正通贸易有限公司","杭州智迈贸易有限公司","杭州智拓窗饰有限公司","杭州中骄进出口有限公司","杭州中隽贸易有限公司","新大生(杭州)工艺品有限公司","浙江东方集团轻工业品进出口有限公司","浙江金富春实业有限公司","浙江凌久进出口有限公司","浙江省纺织品进出口集团有限公司","浙江省粮油食品进出口股份有限公司","浙江省轻纺集团进出口有限公司","浙江顺达进出口贸易有限公司","浙江新大集团有限公司","浙江中南建设集团进出口有限公司","浙农控股集团浙江金海湾进出口有限公司","大连金晟源家居用品有限公司","迪安派登洋服(杭州)有限公司","杭州艾博森进出口有限公司","杭州艾格机械有限公司","杭州百如泰进出口有限公司","杭州缤纷布艺有限公司","杭州布三司纺织有限公司","杭州昌翔化纤新材料有限公司","杭州城锋五金制品有限公司","杭州窗之盛五金有限公司","杭州丹仪箱包有限公司","杭州迪凡进出口有限公司","杭州鼎泰服饰有限公司","杭州鼎之越贸易有限公司","杭州东煌家纺包装有限公司","杭州多韵家纺有限公司","杭州泛亚休闲用品有限公司","杭州泛越贸易有限公司","杭州丰联纺织工艺品有限公司","杭州凤凰针织有限公司","杭州嘎嘎家纺有限公司","杭州谷优进出口有限公司","杭州固得体育用品有限公司","杭州瀚扬纺织有限公司","杭州恒丰进出口有限公司","杭州宏峰纺织集团有限公司","杭州宏鹏实业有限公司","杭州华诚车业有限公司","杭州华艺文具有限公司","杭州华英新塘羽绒制品有限公司","杭州汇尔帘进出口贸易有限公司","杭州加濠进出口有限公司","杭州佳磊进出口有限公司","杭州嘉丰羽绒制品有限公司","杭州建宇制衣有限公司","杭州金蟒贸易有限公司","杭州金荣针纺绣品有限公司","杭州凯立隆进出口有限公司","杭州凯斯工具有限公司","杭州康帛羽绒制品有限公司","杭州康佳乐旅游用品有限公司","杭州宽航贸易有限公司","杭州蓝达工艺制品有限公司","杭州蕾丽帛纺织有限公司","杭州联翔贸易有限公司","杭州隆泰服饰有限公司","杭州美客居家纺有限公司","杭州蒙赞家纺有限公司","杭州品杭寝具有限公司","杭州奇剑纺织有限公司","杭州钱塘江纺织有限公司","杭州乔艾思家用纺织品有限公司","杭州荣达羽绒寝具有限公司","杭州瑞晁纺织有限公司","杭州瑞丰汉艺纺织品有限公司","杭州赛途进出口有限公司","杭州三和羽绒制品有限公司","杭州圣仪纺织有限公司","杭州施诺轩进出口有限公司","杭州世佳电子有限公司","杭州市萧山进出口贸易有限公司","杭州泰浦进出口有限公司","杭州天时进出口有限公司","杭州天泰实业有限公司","杭州通用家纺有限公司","杭州维美家用纺织品有限公司","杭州沃可威纺织服装有限公司","杭州向日葵家纺有限公司","杭州萧然进出口有限公司","杭州萧山凤凰实业有限公司","杭州萧山国际经济技术合作有限公司","杭州萧山华树纺织有限公司","杭州萧山金贝家用纺织品有限公司","杭州萧山荣达羽绒制品有限公司","杭州乙上纺织有限公司","杭州益泰翔贸易有限公司","杭州英帛尔贸易有限公司","杭州英华工艺品有限公司","杭州盈洲进出口有限公司","杭州永丰羽绒制品有限公司","杭州永前进出口有限公司","杭州佑特进出口有限公司","杭州源坊纺织有限公司","杭州悦龙进出口有限公司","杭州中丽化纤有限公司","建德市朝美日化有限公司","江苏省粮油食品进出口集团股份有限公司","临安晨逸纺织涂层有限公司","南充银海丝绸有限公司","陕西际云纺织科技有限公司","上海丝绸集团股份有限公司","永宁尔集团股份有限公司","浙江华欣新材料股份有限公司","浙江凯达文具用品有限公司","浙江凯喜雅国际股份有限公司","浙江美威进出口贸易有限公司","浙江赛纺纺织科技有限公司","浙江省纺织品进出口江南有限公司","浙江万翔寝具制品有限公司","浙江中友进出口有限公司","杭州钱王服饰有限公司","金华市鸿泰进出口有限公司","武义申华工贸有限公司","浙江翰鑫科技有限公司","桐庐雁达文具有限公司"};
	
	public static void main(String[] args) throws Exception {
		String[] custId = {"56467","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56601","56713","56713","56713","56713","56713","56713","56713","56713","56713","56713","56713","56713","56713","56713","56713","56713","56713","56713","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56471","56491","56530","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56616","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56673","56436","56436","56436","56436","56436","56436","56436","56436","56436","56436","56436","56436","56436","56436","56436","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56445","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56448","56466","56466","56466","56466","56499"};
		String[] custName = {"董冬春","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","汤浩","王静","王静","王静","王静","王静","王静","王静","王静","王静","王静","王静","王静","王静","王静","王静","王静","王静","王静","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","黄仁灵","叶伟","黄小艳","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","马俊杰","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","李坤","郑雪林","郑雪林","郑雪林","郑雪林","郑雪林","郑雪林","郑雪林","郑雪林","郑雪林","郑雪林","郑雪林","郑雪林","郑雪林","郑雪林","郑雪林","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","张琴芳","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","谭燕","肖玲玲","肖玲玲","肖玲玲","肖玲玲","许杭妹"};
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
		t.setDate("2019-05-01");
		
		t2.setCustomerId(String.valueOf(companyId[i]));
		t2.setVisitCustomer(String.valueOf(companyName[i]));
		t2.setPersonOfBusinessTrip(String.valueOf(custName[i]));
		
		t2.setDateOfBusinessTrip("2019-05-01");
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
		Thread.sleep(250L);
		}
		System.out.println("全部完成");
	}
}
