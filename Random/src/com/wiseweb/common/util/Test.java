package com.wiseweb.common.util;

/**
 * Created by admin on 2016/6/13.
 */
public class Test {
    public static void main(String[] args) {
//        com.wiseweb.common.util.MakeUpMethodUtil makeUp = new MakeUpMethodUtil();
        //随机名生成姓名测试
//        Object randomName = MakeUpMethodUtil.getRandomName();
//        System.out.println(randomName);

        //唯一名生成姓名测试
//        Object modelName = MakeUpName.getModelName("刘硕");
//        Object modelName = MakeUpName.getModelName("刘硕1aA");
//        Object modelName = MakeUpName.getModelName("司马硕");
//        Object modelName = MakeUpName.getModelName("芭芭拉·——）（*硕");
//        Object modelName = MakeUpName.getModelName("西门~！@#￥%……&*（）111   啥");

//        Object modelName = MakeUpName.getRandomName("刘硕");
//        Object modelName = MakeUpName.getRandomName("刘硕1aA");
//        Object modelName = MakeUpName.getRandomName("司马硕");
//        Object modelName = MakeUpName.getRandomName("芭芭拉·——）（*硕");
//        Object modelName = MakeUpName.getRandomName("西门~！@#￥%……&*（）111   啥");
//        System.out.println(modelName+"---");


//        Object name = MakeUpCompany.getModelCompanyName("联想公司");
//        Object name = MakeUpCompany.getModelCompanyName("刘硕去去去器公司");
//        Object name = MakeUpCompany.getRandomCompanyName("刘硕公司");
//        Object name = MakeUpCompany.getRandomCompanyName("刘硕去去去器公司");

//        System.out.println(name+"---");


//        String str = "123456789";
//        System.out.println(str.substring(7,8));

//        String[] str18 = {"230623195209070433","360722196101081280","430200200604200597","440507200807126270","43072119540703760X","320202198101213406","370214196710126610","230182196409059711","140824198608062827","360429197802278951","450521198711054021","522631196411215179","141028200308200012","220102198305087940","61082719740129939X","130823198711019124","350600199902117085","231225197601027780","330203196510118898","610124197812201994","361125195309207869","150725199510193295","532531197404307965","623001198211245894","61033019600122976X","371725195404132097","411422196908222426","620123196703028214","230521199703302420","53250219890627975X","320100196407109874","510113196903048051","140826196906144381","440882196212063992","510181197205186925"};
//        String[] str15 = {"230623195209070","360722196101081","430200200604200","440507200807126","430721195407037","320202198101213","370214196710126","230182196409059","140824198608062","360429197802278","450521198711054","522631196411215","14102820030820","220102198305087","610827197401299","130823198711019","350600199902117","231225197601027","330203196510118","610124197812201","361125195309207","150725199510193","532531197404307","623001198211245","610330196001229","371725195404132","411422196908222","620123196703028","230521199703302","532502198906279","320100196407109","510113196903048","140826196906144","440882196212063","510181197205186"};
        String[] str18and15 = {"230623195209070433","360722196101081280","430200200604200597","440507200807126270","43072119540703760X","320202198101213406","370214196710126610","230182196409059711","140824198608062827","360429197802278951","450521198711054021","522631196411215179","141028200308200012","220102198305087940","61082719740129939X","130823198711019124","350600199902117085","231225197601027780","330203196510118898","610124197812201994","361125195309207869","150725199510193295","532531197404307965","623001198211245894","61033019600122976X","371725195404132097","411422196908222426","620123196703028214","230521199703302420","53250219890627975X","320100196407109874","510113196903048051","140826196906144381","440882196212063992","510181197205186925","230623195209070","360722196101081","430200200604200","440507200807126","430721195407037","320202198101213","370214196710126","230182196409059","140824198608062","360429197802278","450521198711054","522631196411215","14102820030820","220102198305087","610827197401299","130823198711019","350600199902117","231225197601027","330203196510118","610124197812201","361125195309207","150725199510193","532531197404307","623001198211245","610330196001229","371725195404132","411422196908222","620123196703028","230521199703302","532502198906279","320100196407109","510113196903048","140826196906144","440882196212063","510181197205186"};

        for (int i=0;i<str18and15.length;i++){
            String s = str18and15[i] + (int) (Math.random() * 10);
            System.out.print("\""+s+"\",");


        }



//        for (int i=0;i<str18and15.length;i++){
//            System.out.println("现在执行的是第 "+(i+1));
//            Object modelIDNumber = MakeUpIDNum.getModelIDNumber(str18and15[i]);
//
//            System.out.println(modelIDNumber);
//        }
//        Object modelIDNumber = MakeUpIDNum.getModelIDNumber("141028200308201");
//        System.out.println(modelIDNumber);

//        for (int i = 0; i < 13; i++) {
//            System.out.print("\""+i+"\",");
//        }


//        for (int i=0;i<str18and15.length;i++){
//            System.out.println("现在执行的是第 "+(i+1));
//            Object modelIDNumber = MakeUpIDNum.getDandomIDNumber(str18and15[i]);
//
//            System.out.println(modelIDNumber);
//        }

//        Object modelIDNumber = MakeUpIDNum.getDandomIDNumber("141028200308201");
//        System.out.println(modelIDNumber);
//        String[] num1to3 = {
//                "130","131","132","155","156","186","185","186","185","145","134","135","136","137","138","139","150","151","152","157","158","159","182","183","188","187","133","153","180","181","189"
//        };
//        for (int i = 0; i <num1to3.length ; i++) {
//            Object phone = MakeUpPhone.getModelPhone(num1to3[i]);
//
//        }
//        String tempStr1="";
//        String tempStr2="";
//        String newStr3="";
//        for (int i = 0; i <100 ; i++) {
//
//            //随机产生三位数
//            int code1 = (int) (Math.random() * 1000);
//            if (code1 < 10) {
//                newStr3= "00" + code1;
//            } else if (code1 < 100) {
//                newStr3=  "0" + code1;
//            } else {
//                newStr3=  "" + code1;
//            }
//            int code = (int) (Math.random() * 10000);
//            if (code < 10) {
//                tempStr1= "000" + code;
//            } else if (code < 100) {
//                tempStr1=  "00" + code;
//            } else if(code < 1000){
//                tempStr1=  "0" + code;
//            }else {
//                tempStr1=  "" + code;
//            }
//            int code2 = (int) (Math.random() * 10000);
//            if (code < 10) {
//                tempStr2= "000" + code;
//            } else if (code < 100) {
//                tempStr2=  "00" + code;
//            } else if(code < 1000){
//                tempStr2=  "0" + code;
//            }else {
//                tempStr2=  "" + code;
//            }
//            String s = newStr3+(tempStr1+"")+ (tempStr2+"");
//            System.out.print("\""+s+"\",");
//        }
//String[] str ={"22716651665","91390209020","28755715571","73526092609","99863216321","99900610061","65820812081","58194979497","48380728072","65895989598","44450595059","26461666166","71722792279","81732443244","85123492349","26315541554","47698269826","64350635063","61301910191","32514321432","06564886488","84135373537","99094979497","03666456645","29783388338","66408700870","81192929292","40779037903","11151855185","52786288628","10781638163","82779007900","96885968596","63406530653","13090279027","03105290529","21878407840","28168166816","77241284128","20757255725","24760356035","48684938493","55659715971","07568496849","23199239923","27586488648","57558775877","71356325632","84400350035","37160886088","82150415041","01974717471","26435183518","15948554855","48233113311","10073697369","24396099609","65757455745","81284698469","43439163916","94076237623","77877457745","23435403540","45756165616","62294049404","46525782578","30815431543","27203510351","15424762476","27956905690","18462546254","37150125012","56165536553","74718271827","07738273827","76482408240","72147324732","22028592859","22235953595","56648034803","51515161516","14596709670","61470727072","97554265426","48428382838","55288528852","70620232023","71708690869","26784488448","13084598459","03735163516","34636783678","72444354435","60753745374","52561186118","34854195419","82432193219","17297479747","93508030803","75912141214"};
//
//        for (int i = 0; i <str.length ; i++) {
//            Object modelPhone = MakeUpPhone.getModelPhone(str[i]);
//            System.out.println(modelPhone);
//
//
//        }



//        String[] q = { "石家庄市0311", "邯郸市0310", "邢台市0319", "保定市0312", "张家口市0313", "承德市0314", "唐山市0315", "秦皇岛市0335", "沧州市0317", "廊坊市0316", "衡水市0318", "福州市0591", "厦门市0592", "三明市0598", "莆田市0594", "泉州市0595", "漳州市0596", "南平市0599", "宁德市0593", "龙岩市0597", "南昌市0791", "景德镇市0798", "新余市0790", "九江市0792", "鹰潭市0701", "上饶市0793", "宜春市0795", "临川市0794", "吉安市0796", "赣州市0797", "济南市0531", "青岛市0532", "淄博市0533", "潍坊市0536", "烟台市0535", "威海市0631", "兖州市0537", "日照市0633", "德州市0534", "郓城县0530", "太原市0351", "大同市0352", "阳泉市0353", "长治市0355", "朔州市0349", "榆次市0354", "孝义市0358", "临汾市0357", "运城市0359", "呼和浩特0471", "包头市0472", "巴林左旗0476", "二连浩特市0479", "满洲里市0470", "通辽市0475", "准格尔旗0477", "乌兰浩特市0482", "郑州市0371", "开封市0378", "洛阳市0379", "新乡市0373", "濮阳市0393", "商丘市0370", "南阳市0377", "周口市0394", "汝南县0396", "沈阳市024", "大连市0411", "鞍山市0412", "抚顺市0413", "本溪市0414", "丹东市0415", "锦州市0416", "营口市0417", "阜新市0418", "辽阳市0419", "铁岭市0410", "武汉市027", "黄石市0714", "襄樊市0710", "十堰市0719", "宜昌市0717", "荆门市0714", "孝感市0712", "黄冈市0713", "恩施市0718", "荆沙0716", "长春市0431", "吉林市0423", "四平市0434", "辽源市0437", "通化市0435", "临江市0439", "大安市0436", "敦化市0433", "珲春市0440", "长沙市0731", "株州市0733", "湘潭市0732", "衡阳市0734", "岳阳市0730", "常德市0736", "郴州市0735", "益阳市0737", "冷水滩0746", "怀化市0745", "张家界0744", "哈尔滨市0451", "齐齐哈尔市0452", "大庆市0459", "伊春市0458", "牡丹江市0453", "佳木斯市0454", "缓化市0455", "漠河县0457", "黑河市0456", "广州市020", "深圳市0755", "珠海市0756", "汕头市0754", "韶关市0751", "惠州市0752", "东莞市0769", "中山市0760", "佛山市0757", "湛江市0759", "南京市025", "徐州市0516", "连云港市0518", "淮安市0517", "宿迁市0527", "盐城市0515", "扬州市0514", "南通市0513", "镇江市0511", "常州市0519", "无锡市0510", "苏州市0512", "常熟市0520", "南宁市0771", "柳州市0772", "桂林市0773", "梧州市0774", "北海市0779", "钦州市0777", "海口市0898", "三亚市0899", "儋州市0890", "成都市028", "攀枝花市0812", "德阳市0838", "绵阳市0816", "自贡市0813", "内江市0832", "乐山市0833", "泸州市0830", "宜宾市0831", "杭州市0571", "宁波市0574", "嘉兴市0573", "湖州市0572", "绍兴市0575", "金华市0579", "衢州市0570", "舟山市0580", "温州市0577", "台州市0576", "贵阳市0851", "遵义市0852", "安顺市0853", "六盘水市0858", "合肥市0551", "淮南市0554", "蚌埠市0552", "马鞍山市0555", "安庆市0556", "黄山市0559", "滁州市0550", "宿州市0557", "巢湖市0565", "宣州市0563", "昆明市0871", "昭通市0870", "曲靖市0874", "江川市0877", "思茅市0879", "丽江县0888", "开远市0873", "楚雄市0878", "西安市029", "铜川市0919", "宝鸡市0917", "渭南市0913", "商州市0914", "拉萨市0891", "日喀则市0892", "仁布县08018", "丁青县08059", "阿里地区0897", "兰州市0931", "金昌市0935", "天水市0938", "平凉市0933", "玉门市0937", "敦煌市0937", "西宁市0971", "平安县0972", "格尔木市0979", "玛沁县0975", "银川市0951", "石嘴山市0952", "青铜峡市0953", "海原县0954", "乌鲁木齐市0991", "克拉玛依市0990", "吐鲁番市0995", "喀什市0998", "阿图什市0908", "库尔勒市0996"};
//
//
//        for (int i = 0; i <q.length ; i++) {
//            String s = q[i].substring(q[i].length() - 4, q[i].length());
//            System.out.print("\""+s+"\",");
//
//
////        }
//        Object modelPhone = MakeUpPhone.getRandomPhone("01040000000");
//
//        System.out.println(modelPhone);











    }

}
