package two_param.com_name;

/**
 * Created by ${LiuShuo} on 2016/7/1.
 */
public class ComName {

    public static Object getM(Object value, Object key){

//判断参数是否为null、"null"、"" ,为true时不做处理
        if (value==null||value.equals("null")||value.equals("")) return value;
        String str = value+"";
        if(str.contains("·")&& str.replace(" ", "").length()<3){
            return value;
        }
        //去掉前后空格长度小于等于1的直接返回
        if (str.trim().length()<2) return value;
        String salt = key + "";
        String saltok = salt.replace(" ", "");
        //盐值hash
        int hashSalt = 0;

        if (salt.length()<1){
            //没有盐值
        }else {
            hashSalt=Math.abs(saltok.hashCode());
        }

        //复姓的数组
        String[] contain = {"万俟", "司马", "上官", "欧阳", "夏侯", "诸葛", "闻人", "东方", "赫连", "皇甫", "羊舌", "尉迟", "公羊", "澹台", "公冶", "宗正",
                "濮阳", "淳于", "单于", "太叔", "申屠", "公孙", "仲孙", "轩辕", "令狐", "钟离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空", "兀官", "司寇",
                "南门", "呼延", "子车", "颛孙", "端木", "巫马", "公西", "漆雕", "车正", "壤驷", "公良", "拓跋", "夹谷", "宰父", "谷梁", "段干", "百里", "东郭", "微生",
                "梁丘", "左丘", "东门", "西门", "南宫", "第五", "公仪", "公乘", "太史", "仲长", "叔孙", "屈突", "尔朱", "东乡", "相里", "胡母", "司城", "张廖", "雍门",
                "毋丘", "贺兰", "綦毋", "屋庐", "独孤", "南郭", "北宫", "王孙"};
        //598 百家姓
        String[] laName= {"赵","钱","孙","李","周","吴","郑","王","冯","陈","褚","卫","蒋","沈","韩","杨","朱","秦","尤","许",
                "何","吕","施","张","孔","曹","严","华","金","魏","陶","姜","戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚","范","彭","郎",
                "鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","鲍","史","唐","费","薛","雷","贺","倪","汤","滕","殷",
                "罗","毕","郝","安","常","乐","于","卞","齐","伍","余","元","卜","顾","孟","平","黄","和",
                "穆","萧","尹","姚","邵","汪","毛","狄","米","贝","明","臧","成","戴","宋","茅","庞","熊","纪","舒",
                "项","祝","董","梁","杜","阮","蓝","闵","席","季","麻","强","贾","路","娄","江","童","颜","郭","梅","盛","林","钟",
                "徐","邱","骆","高","夏","蔡","田","樊","胡","凌","霍","万","支","柯","管","卢","莫","房","缪","解",
                "丁","宣","贲","邓","郁","单","杭","洪","包","诸","左","石","崔","吉","龚","程","邢","裴","陆","荣","翁","荀",
                "于","惠","甄","曲","封","芮","井","段","焦",
                "谷","车","侯","蓬","全","班","仰","秋","仲","伊","宫","宁","仇","栾","甘","戎","祖","武","符","刘","景",
                "詹","束","龙","叶","幸","司","白","怀","蒲","邰","蔺", "蒙","池","乔","阴","郁","闻","党","翟","谭","申",
                "桂","濮","牛","寿","通","边","扈","燕","冀","浦","尚","农","温","庄","柴","阎","习",
                "艾","向","古","易","廖","步","都","耿","满","国","文","广", "东","巩","聂","晁","那", "曾","沙","关","荆","盖","桓",
                "岳","帅","海","楚","闫","法","牟","佘","伯","墨", "佟","南","冼","展", "高","门","风","木"};

        //名字库
        String[] fiName= {"修","宵","晨","施","顺","祥","才","聪","银","戈","喻","声","生","铁","如","胜","挚","靖","齐",
                "锦","少","舟","任","载","翱","青","迁","钧","钟","金","慈","昌","紫","砂","仁","祖","韶","绍","锐","峻","裕","镇","壮","商",
                "翼","织","释","诚","常","净","秀","节","刊","信","崇","春","铭","秋","刚","诗","神","星","石","识","肃","瑞","新","鑫",
                "盛","帅","馨","惜","散","慎","世","书","千","善","镜","然","资","笑","疏","西","捷","超","川","锋","实","聚","尊","承","钦",
                "仕","众","思","茂","贤","棕","树","蓝","卷","谷","君","古","原","廉","建","庆","桦","统","若","攀","栋","荒","何","久","侠",
                "奇","朴","鸽","东","嘉","冠","松","啸","祺","琪","雁","宜","琦","枝","坚","昂","毅","歌","标","固","吉","高","康","尧","果",
                "杭","语","曲","肖","荷","芹","乾","义","杰","皓","凯","本","勤","彬","景","月","兼","柏","荣","观","笃","恭",
                "柯","言","菲","萧","乔","群","谦","国","极","轻","玉","业","材","相","苑","倚","岳","柳","贵","悟","健","彦","棋","楷","桐",
                "气","颜","苛","池","闻","流","霜","福","泉","宏","弘","浅","熙","济","涛","震","和","霖","向","波","渊","博","游","雨",
                "润","湛","凡","奔","夫","潮","深","岸","辉","浚","复","封","飞","朋","江","奉","晖","绘","浪","鸣","百","鹤","沙","漾",
                "雪","孝","万","望","瀚","缈","淡","保","阔","洪","恒","云","伯","玄","风","淘","合","文","莫","享","满","溪","妙","邦",
                "华","冰","方","寒","鹏","陌","奋","秉","泽","豪","布","明","民","虎","帆","洋","名","海","潭","清","勉","源","平",
                "沧","霄","熊","论","彤","烟","阳","耀","励","晋","临","伦","日","传","炎","彰","全","丰","晓","瞻","拓","展","绩","炫","尘",
                "征","昙","道","飘","鼎","龙","昊","腾","至","宝","驰","易","耿","昆","振","知","光","灿","智","畅","晴","迪","绿","扬","来",
                "志","煊","遥","宁","衷","太","凌","天","璋","瑾","俊","里","韬","量","致","烨","忠","厉","理","路","年","昭","达","都",
                "蝶","章","照","积","良","泰","烈","庭","进","晟","德","际","琢","利","哲","质","隆","田","煜","南","乐","翎","冬","图",
                "暖","壤","佑","翔","伟","磊","欧","运","豫","维","坤","恩","永","意","野","幽","远","圣","山","城","音","韵","依","余","圆",
                "勋","忆","叶","亦","卫","傲","融","勇","逸","育","唯","基","容","温","安","奥","引","影","羽","均","誉","越","辰","轩","延",
                "境","宇","悠","益","岩","玮","威","硕","庸","懿","统","柏","彤","兼","昊","肖","杰","含","凯","振","秉","沧","享","朋","轻",
                "俊","材","宇","松","依","池","钦","桦","芹","孝","炫","极","洋","舟","际","荒","衷","亦","狂","闻","幽","曲","耿","勇","奇",
                "城","冰","柯","浦","林","和","明","名","建","尧","胜","朴","存","顺","昌","西","昙","砂","语","泰","伦","烈","杭","育","折",
                "达","顷","忠","延","坤","佑","修","闲","坚","泉","劲","勋","枝","年","迁","致","治","健","羽","晓","卷","如","宸","荷","物",
                "合","复","晖","易","灿","浅","悟","壮","临","荣","桦","乔","承","明","顺","物","原","统","哲","庭","运","修","远","峰","兼",
                "杉","莫","均","幽","高","闲","宝","拓","若","材","玮","余","苛","欢","凌","函","享","陌","亦","旷","全","君","思","秀","威",
                "海","烨","尧","声","展","秋","标","羽","昭","合","建","坤","南","利","华","伦","挚","宵","壮","众","晋","松","恩","阳","泉",
                "恭","树","钟","致","苑","封","诗","晓","戏","荣","里","拂","至","奋","初","图","烈","金","如","钦","俊","贵","宸","狂","益",
                "耿","积","复","勋","佑","肃","光","轻","施","任","巧","功","玄","白","田","由","甲","申","用","目","旦","玉","丘","生","主","加","占",
                "可","石","弘","台","叮",
                "包","卉","古","尼","召","巨","司","句","幼","禾","札","本","丙","戊","布","卯","未","末","必","平","市","冬","永","立",
                "央","出","北","甘","刊","扎","母","瓜","正","外","瓦","充","丕",
                "六","光","先","圭","戌","艮","羊","地","至","向","各","吉","名","后","舌","合","回","同","咤","臣","考","多","仲","伉","来",
                "企","伊","全","伍","仰","任","伙","休","价","伏","份","在","行","汀","州","丞","年","存","舟","兆","寺","竹","卉","圳","朱","朴","米",
                "朽","打","汁","次","冰","交","件","列","匠","宅","尖","老","宇","守","安","字","如","亦","聿","因","夷","有","衣","羽","而","危",
                "耳","印","西","先","旭","早","百","自","旨","曲","收","乒","乓","色","此","虫","肉","妃","好","帆","亥","充","再","共","住","佃","但",
                "你","伴","佛","布","伶","夹","利","佣","余","位","伸","宋","彷","畲","七","妞","努","妆","妘","妤","汝","妍",
                "妙","妨","妣","克","谷","告","估","君","吕","兑","束","豆","占","言","佑","佐","吴","吾","呈","杏","串","吹","吟","冶",
                "亨","伯","伺","何","含","别","灶","杜","町","牡","赤","成","弄","坊","更","男","良","里","均",
                "壮","辰","坎","床","杆","杖","李","孚","孝","材","村","杉","杞","秀","池","汐","汕","汗","廷","江","忍","志","删","形",
                "免","车","身","甫","贝","旱","步","判","私","角","改","攻","即","弟","系","忙","兵","冷","宏","完","我","希","序","酉","辛","助",
                "彤","八","佶","供","佰","仑","佬","佛","岱","佩","夜","欣","例","来","侏","佳","征","依","彼","侑","并","往","府","侍","使","姑",
                "姗","姒","始","妹","姓","妮","委","姐","姊","姆","妳","舍","和","咖","刮","咕","固","岩","冾",
                "奇","知","居","林","周","店","味","京","尚","享","昔","卓","明","朋","昏","昊","服","昆","的","帛","昌","坦","昂","旺","者","易","升",
                "昕","松","析","杵","虎","枋","杷","枇","板","林","采","果","兔","枕","柑","杭","枚","东","析","采","青","炒","炊","快","忱","忽",
                "忠","念","忭","忿","杰","炎","定","宙","空","宕","穹","官","宗","宜","宛","雨","沈","沙","沁","冲","沌","汲","沐","承","汽","乳","沛",
                "函","汾","汴","沅","沃","汶","沂","季","孟","坪","物","卦","坤","幸","社","到","坡","坻","硅","坨","岳","岸","玖","抖","扶",
                "乖","沉","孤","盂","氛","版","牧","盲","门","非","庚","冈","奉","争","决","弦",
                "艾","武","协","所","抄","投","抓","抒","折","事","些","卷","劻","届","底","忝","状","竺","亚","券","刷","卸","取",
                "并","奔","劾","其","儿","狄","典","直","延","于","卧","具","金","长","奈","刻","制","祀","祁","秉","弧","房","放",
                "斧","爬","九","勇","面","冠","军","厚","罕","俊","很","俐","侵","促","俗","系","待","信","衍","便","俘","俄","俏","律","后","侯","保",
                "亭","俬","徊","韦","侣","室","客","穿","姨","姻","娃","姜","姝","姚","计","哄","哈","订","却","咨","哉","咱","咻","品",
                "亮","宦","科","秒","柄","柳","柏","枷","拐","柔","香","柿","染","柱","架","查","柯","柚","枯","柑","柒","皇","冒","昴","昧","昱",
                "音","映","宣","星","春","肖","削","前","皆","思","怙","急","怡","怕","炫","南","炯","炬","炭","炳",
                "政","耐","泌","况","沸","癸","泡","沫","沽","泯","泳","油","沿","泉","泣","泄","泗","河","波","法","泓","泛","治","泊","注","泥","沾",
                "沼","垮","型","垂","奎","封","重","致","垣","拆","拐","狗","剎","页","克","垮","拌","拂","抹","叛","披","拔","抛","拓","招","拇","拍",
                "抱","拉","拄","拒","抽","抵","拘","押","拖","抬","芊","芃","芍","芒","玟","玫","珏","玩","毒","屋","幽","禺","竽","耶","食","昶","姿",
                "咸","省","则","相","秋","契","奏","巷","甚","孩","衫","酋","故","牯","皈","杯","看","竿","轨","泰","度","拓",
                "劲","红","表","美","屏","虹","勉","勃","为","弈","狐","盆","革","扁","奕","叛","拜","建","帅","负","赴","砒","帝","界","段","研","纪",
                "既","肚","狙","剌","彦","盈","禹","约","威","羿","施","俞","眉","首","盼","贞","风","奂","飞","竑","爰","十","厝","原",
                "准","凌","凄","座","俱","值","倪","伦","倘","倞","俩","修","倡","倩","倦","徐","径","借","倒","俶","倔","们","俾","徒","俺","倭","倚",
                "个","幸","候","倍","俸","俯","刚","祟","留","峪","峮","城","岛","埔","埋","高","哥","记","唇","炮","唔","唐","讯",
                "哲","讨","托","站","讪","讫","训","员","讦","仓","哦","唈","哺","讧","宫","窈","家","案","窄","容","宬","宸","宴","宰","宵","害",
                "贡","娱","娜","姬","娘","娓","娥","娩","娣","娌","娉","娟","拾","拭","持","按","拱","拷","拮","括","挖","拿","挑","指","拯","按","耘",
                "桂","秧","栩","耕","桉","秘","租","粉","根","框","桌","栘","桑","格","桃","株","秤","秩","梳","冻","校","柴","栽","栓","料","殊","耗",
                "桔","栗","桐","秦","核","洋","洹","洸","恭","洗","洛","洪","洲","流","津","酒","洞","庭","孙","洽","汹","洵","洳","泄","娑","派",
                "洧","恒","耿","烙","恒","恐","烤","恬","烈","晋","晃","烔","肱","恃","息","耻","烘","恰","恕","恢","恩","恤","羔","书","肩","肴","朕",
                "肥","时","肯","殉","骨","股","屑","朔","肢","剔","晁","育","晏","殷","桓","晌","峻","埂","城","峭","峨","峰","峡","崁","芹","芬","芮",
                "芙","芭","芝","芛","芳","芽","芯","芸","花","芥","芫","芷","纹","纱","级","纯","索","纺","纽","纷","纳","纸","秘","神","祠","祖",
                "佑","祝","珈","珀","珊","珍","玻","玳","玲","珅","差","弱","拳","臭","刍","虔","航","配","般","亳","马",
                "圃","亩","迅","躬","库","展","砥","兼","钉","针","耽","只","斗","翁","袁",
                "釜","狩","奚","真","蚓","夏","益","轩","旅","财","素","扇","乘","气","畜","笑","缺","翅","效","起","巡","席","卿","师",
                "奘","疾","矩","砧","衷","闪","旁","停","假","侦","偃","偌","伟","御","悠","偲","术","偶","健","偕","得","爽","偎","伪",
                "修","徘","徙","徜","做","从","侧","偏","康","庸","庾","庶","痕","匿","屠","麻","执","斩","副",
                "软","务","野","邪","阡","邠","邦","那","浩","教","浪","涒","浙","涓","浚","浸","海","涕","泾","浣","涅","浦","消","浦","雪","浴","浮",
                "昆","密","崩","毕","岗","堆","培","埤","基","堂","笛","仑","羚","坚","略","崖","崇","埴","崎","崧","崔","梓","梁",
                "粒","救","梯","桶","条","梨","梵","梆","斜","梧","梢","梭","彪","犁","彬","梅","粗","彩","挺",
                "振","捉","挽","挨","挟","挫","捐","捕","捍","晢","够","胖","干","恿","勖","章","顶","专","将","竟","您","胄","鸟","胎",
                "悌","昼","皎","烹","眺","袒","豚","曼","尉","望","鱼","悁","胤","焉","晚","晤","悟","焊","胃","习","晟","患","晨","胥","冕","晦","曹",
                "悉","敏","悍","奢","国","甜","念","朱","袈","诀","区","欲","问","唯",
                "启","毫","设","常","商","船","许","唱","讼","孰","访","啡","婕","娄","婀","婉",
                "婆","珠","珞","佩","珙","珪","琉","敖","珣","晌","班","寄","寇","窒","窕","寀","寂","宿","寅","扎","累","终","统","绊","绍","组",
                "细","绅","茁","笠","英","苑","茄","若","范","茉","茂","笨","苓","苕","苙","苞","茅","苗","苦","苹","苾","苟","荏","苔","笙","符","祥",
                "强","旋","雀","处","顷","产","族","袖","牵","率","瓷","蛇","疏","参","巢","狭","匙","戚","羞","舷","蛆","蚯","赦","酗","袪","麦","凰",
                "闭","觅","货","被","票","败","悔","背","瓶","瓠","舶","袍","馗","勘","钵","釱","钓","钏","钗","翎","张","蛋","袋","鹿","第","贪","伧",
                "傒","徨","备","博","街","傅","傍","贷","家","循","婿","婼","媒","婷","媚","媞","媛","堪","凯","岚","崴","尧","场","堡","嵋","啼",
                "喃","喻","喝","喉","证","距","注","喜","善","喨","舒","创","诉","词","单","唤","彭","跑","喧","评","诃","结",
                "喇","就","邵","卷","采","捧","排","舍","挂","捷",
                "棕","棵","植","杰","棠","栋","集","栈","椅","程","稀","窗","栖"};

         /*  公司名 */
        String[] Surname= {"修","宵","晨","戏","施","顺","祥","才","聪","银","戈","喻","声","生","铁","如","宸","誓","胜","挚","靖","齐",
                "锦","少","舟","任","载","翱","青","迁","钧","钟","金","慈","昌","紫","砂","仁","祖","韶","绍","锐","峻","裕","镇","壮","商",
                "翼","织","释","诚","常","净","秀","节","刊","信","崇","春","铭","秋","刚","诗","神","星","鉴","石","识","肃","瑞","新","鑫",
                "盛","帅","馨","惜","散","慎","世","书","千","善","镜","然","资","笑","疏","西","捷","超","川","锋","实","聚","尊","承","钦",
                "仕","众","思","茂","贤","棕","树","蓝","卷","谷","君","古","原","廉","建","庆","桦","统","若","攀","栋","荒","何","久","侠",
                "奇","朴","鸽","东","嘉","冠","松","啸","祺","琪","雁","宜","琦","枝","坚","昂","毅","歌","标","固","吉","高","康","尧","果",
                "杭","语","曲","肖","荷","芹","乾","义","杰","皓","凯","狂","本","勤","彬","景","月","兼","顷","柏","擎","荣","观","笃","恭",
                "柯","言","菲","萧","乔","群","谦","国","极","轻","玉","业","材","相","苑","倚","岳","柳","贵","悟","健","彦","棋","楷","桐",
                "气","颜","苛","池","闻","流","霜","福","泉","宏","弘","浅","熙","济","涛","震","和","闲","霖","向","波","渊","博","游","雨",
                "润","湛","凡","奔","夫","潮","深","岸","辉","浚","复","封","飞","朋","江","奉","晖","绘","浪","鸣","百","鹤","沙","漾","泥",
                "雪","孝","万","望","瀚","缈","淡","阜","保","阔","洪","恒","云","伯","玄","风","淘","合","文","莫","享","满","溪","妙","邦",
                "华","冰","方","寒","鹏","陌","奋","秉","泽","豪","布","明","民","虎","帆","洋","名","拂","海","潭","清","勉","源","平","物",
                "沧","霄","熊","论","彤","烟","阳","耀","励","晋","临","伦","日","传","炎","彰","全","丰","晓","瞻","拓","展","绩","炫","尘",
                "征","昙","道","飘","鼎","龙","昊","腾","至","宝","驰","易","耿","昆","振","知","光","灿","智","畅","晴","迪","绿","扬","来",
                "志","煊","遥","宁","衷","太","凌","天","璋","瑾","俊","里","韬","量","致","烨","忠","厉","理","路","年","循","昭","达","都",
                "蝶","章","照","积","良","泰","烈","庭","折","进","晟","德","际","琢","利","哲","质","隆","田","煜","南","乐","翎","冬","图",
                "暖","壤","佑","翔","伟","磊","欧","运","豫","维","坤","恩","永","意","野","幽","远","圣","山","城","音","韵","依","余","圆",
                "勋","忆","叶","亦","卫","傲","融","勇","逸","育","唯","基","容","温","安","奥","引","影","羽","均","誉","越","辰","轩","延",
                "境","宇","悠","益","岩","玮","威","硕","庸","懿","统","柏","彤","兼","昊","肖","杰","含","凯","振","秉","沧","享","朋","轻",
                "俊","材","宇","松","依","池","钦","桦","芹","孝","炫","极","洋","舟","际","荒","衷","亦","狂","闻","幽","曲","耿","勇","奇",
                "城","冰","柯","浦","林","和","明","名","建","尧","胜","朴","存","顺","昌","西","昙","砂","语","泰","伦","烈","杭","育","折",
                "达","顷","忠","延","坤","佑","修","闲","坚","泉","劲","勋","枝","年","迁","致","治","健","羽","晓","卷","如","宸","荷","物",
                "合","复","晖","易","灿","浅","悟","壮","临","荣","桦","乔","承","明","顺","物","原","统","哲","庭","运","修","远","峰","兼",
                "杉","莫","均","幽","高","闲","宝","拓","若","材","玮","余","苛","欢","凌","函","享","陌","亦","旷","全","君","思","秀","威",
                "海","烨","尧","声","展","秋","标","羽","昭","合","建","坤","南","利","华","伦","挚","宵","壮","众","晋","松","恩","阳","泉",
                "恭","树","钟","致","苑","封","诗","晓","戏","荣","里","拂","至","奋","初","图","烈","金","如","钦","俊","贵","宸","狂","益",
                "耿","积","复","勋","佑","肃","光","轻","施","任"};
        //行政区域
        String[] xingZheng = {"北京","天津","河北","山西","辽宁","吉林","黑龙江","上海","江苏","浙江","安徽","福建","江西","山东","河南","湖北","湖南","广东","海南","重庆","四川","贵州","云南","陕西","甘肃","青海","宁夏"};


        if (str.contains("公司")){

            String temp = "";
            String newName="";
            int nameHashCode=0;
            //公司截取转换后名
            String newCName1 ="";
            String newCName2 ="";
            //验证是否为公司
            int company = 0;

            if (str.contains("有限")){
                company =1;
            }else if (str.contains("公司")){
                company =2;
            }

            if (company == 0) return value;
            if (company == 1) {

                String regex = "有限";
                String strAry[] = str.split(regex);
                if (strAry.length<2)return value;
                str = strAry[0];
                newCName2 = "有限" + strAry[1];
            }
            if (company == 2) {
                String regex = "公司";
                String strAry[] = str.split(regex);
                if (strAry.length==0)return value;
                str = strAry[0];
                newCName2 = "公司";
            }

            //转换成数组
            String[] nameArray = new String [str.length()];
            for (int i=0;i<str.length();i++){
                nameArray[i] = str.substring(i,i+1);
                temp=nameArray[i];
                nameHashCode = Math.abs(temp.hashCode()+hashSalt);
                newCName1 += Surname[nameHashCode%(Surname.length-1)];
            }
            if (newCName1.length()>3){
                String s = xingZheng[nameHashCode%(xingZheng.length-1)];
                newCName1=s+newCName1.substring(2,newCName1.length());
            }
            return newCName1+newCName2;
        }else {
            //特殊字符
            boolean isSpecial = false;
            //复姓
            boolean isTwoName = false;
            //少数民族
            boolean isRareName = false;

            String lastName = "";
            String firstName = "";
            String newName = "";

            int lastNameHashCode = 0;
            int firstNameHashCode = 0;

            //判断是否含有特殊字符
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[0-9]*[A-Za-z]*[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]*");
            for (int i = 0; i < str.length(); i++) {
                java.util.regex.Matcher matcher = pattern.matcher(str.substring(i, i + 1));
                boolean matches = matcher.matches();
                if (matches) {
                    isSpecial = matches;
                    break;
                }
            }
            //判断是否是复姓
            for (int i = 0; i < contain.length; i++) {
                if (str.contains(contain[i])) {
                    isTwoName = true;
                }
            }
            //判断是否是少数民族“·”
            if (str.contains("·")) {
                isRareName = true;
            }
            //正常名字
            //复姓名字
            //少数民族名字
            if (!isSpecial) {
                lastName = str.substring(0, 1);
                firstName = str.substring(1, str.length());
                if (isTwoName) {
                    lastName = str.substring(0, 2);
                    firstName = str.substring(2, str.length());
                }
                if (isRareName) {
                    String regex = "·";
                    String strAry[] = str.split(regex);
                    if (strAry.length == 2) {
                        lastName = strAry[0];
                        firstName = strAry[1];
                    } else {
                        return value;
                    }
                }

                //少数民族拼新名字
                if (isRareName) {
                    for (int i = 0; i < lastName.length(); i++) {
                        firstNameHashCode = Math.abs(lastName.substring(i, i + 1).hashCode() + hashSalt);
                        newName += fiName[firstNameHashCode % (fiName.length - 1)];
                    }
                    newName += "·";
                    for (int i = 0; i < firstName.length(); i++) {
                        firstNameHashCode = Math.abs(firstName.substring(i, i + 1).hashCode() + hashSalt);
                        newName += fiName[firstNameHashCode % (fiName.length - 1)];
                    }
                } else {
                    lastNameHashCode = Math.abs(lastName.hashCode() + hashSalt);//姓取正数
                    newName = laName[lastNameHashCode % (laName.length - 1)]; //获得一个固定的姓氏
                    if (isTwoName) {
                        newName = contain[lastNameHashCode % (contain.length - 1)]; //获得一个固定的姓氏
                    }
                    for (int i = 0; i < firstName.length(); i++) {
                        firstNameHashCode = Math.abs(firstName.substring(i, i + 1).hashCode() + hashSalt);
                        newName += fiName[firstNameHashCode % (fiName.length - 1)];
                    }
                }
            }
            //正常名字带特殊字符
            //复姓名字带特殊字符
            //少数民族名字带特殊字符
            //判断汉字
            java.util.regex.Pattern pattern1 = java.util.regex.Pattern.compile("[\\u4e00-\\u9fa5]");

            if (isSpecial) {
                int temp = 0;
                //根据以上判断截取每个字符放入数组
                String[] nameArray = new String[str.length()];
                for (int i = 0; i < str.length(); i++) {
                    nameArray[i] = str.substring(i, i + 1);
                }
                if (isTwoName) {
                    for (int i = 0; i < nameArray.length; i++) {
                        java.util.regex.Matcher matcher1 = pattern1.matcher(nameArray[i]);
                        boolean matches1 = matcher1.matches();

                        if (matches1 && temp == 1) {
                            firstName = nameArray[i];
                            firstNameHashCode = Math.abs(firstName.hashCode() + hashSalt);//名取正数
                            newName = fiName[firstNameHashCode % (fiName.length - 1)]; //获得一个固定的姓名字
                            nameArray[i] = newName.substring(0);
                        }

                        if (matches1 && temp == 0) {
                            lastName = nameArray[i] + nameArray[i + 1];
                            lastNameHashCode = Math.abs(lastName.hashCode() + hashSalt);//姓取正数
                            newName = contain[lastNameHashCode % (contain.length - 1)]; //获得一个固定的姓氏
                            nameArray[i] = newName.substring(0, 1);
                            nameArray[i + 1] = newName.substring(1, 2);
                            i += 1;
                            temp += 1;
                        }
                    }
                }

                if (isRareName) {

                    for (int i = 0; i < nameArray.length; i++) {
                        java.util.regex.Matcher matcher1 = pattern1.matcher(nameArray[i]);
                        boolean matches1 = matcher1.matches();

                        if (matches1) {
                            firstName = nameArray[i];
                            firstNameHashCode = Math.abs(firstName.hashCode() + hashSalt);//名取正数
                            nameArray[i] = fiName[firstNameHashCode % (fiName.length - 1)]; //获得一个固定的姓名字
                        }
                    }
                }

                for (int i = 0; i < nameArray.length; i++) {
                    java.util.regex.Matcher matcher1 = pattern1.matcher(nameArray[i]);
                    boolean matches1 = matcher1.matches();

                    if (matches1 && temp == 1) {
                        firstName = nameArray[i];
                        firstNameHashCode = Math.abs(firstName.hashCode() + hashSalt);//名取正数
                        newName = fiName[firstNameHashCode % (fiName.length - 1)]; //获得一个固定的姓名字
                        nameArray[i] = newName.substring(0);
                    }

                    if (matches1 && temp == 0) {
                        lastName = nameArray[i];
                        lastNameHashCode = Math.abs(lastName.hashCode() + hashSalt);//姓取正数
                        newName = laName[lastNameHashCode % (laName.length - 1)]; //获得一个固定的姓氏
                        nameArray[i] = newName.substring(0, 1);
                        temp += 1;
                    }

                }
                //生成String类型新名字
                newName = "";
                for (int i = 0; i < nameArray.length; i++) {
                    newName += nameArray[i];
                }
            }
            return newName;
        }
    }

}
