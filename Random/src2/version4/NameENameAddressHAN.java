package version4;

/**
 * 姓名、公司名、地址混合脱敏
 * Created by ${LiuShuo} on 8/23/2016.
 */
public class NameENameAddressHAN {

    public static Object getModelNameAddr(Object value, Object key) throws Exception {

        if (value == null || value.equals("null") || value.equals("")) return "";
        String str = value + "";
        str = str.replaceAll("\\s*", "");
        str = str.replaceAll("\\u3000", "");
        int isSuangYin = 0;// 0:没有双引号
        if (str.endsWith("\"") && str.startsWith("\"")) {
            str = str.substring(1, str.length() - 1);
            isSuangYin = 1;
        }
        if (str.length() < 2) return value;//一个字什么也不是
        String salt = key + "";
        String saltok = salt.replaceAll("\\s*", "");
        int hashSalt = 0;
        if (salt == null || salt.equals("null") || salt.equals("")) {
        } else {
            hashSalt = Math.abs(saltok.hashCode());
        }

//正则数字
        java.util.regex.Pattern pattern1 = java.util.regex.Pattern.compile("[0-9]");
        java.util.regex.Pattern pattern2 = java.util.regex.Pattern.compile("[a-eg-z]");
        java.util.regex.Pattern pattern3 = java.util.regex.Pattern.compile("[A-EG-Z]");

//复姓的数组
        String[] fuxing = {"万俟", "司马", "上官", "欧阳", "夏侯", "诸葛", "闻人", "东方", "赫连", "皇甫", "羊舌", "尉迟", "公羊", "澹台", "公冶", "宗正", "濮阳", "淳于", "单于", "太叔", "申屠", "公孙", "仲孙", "轩辕", "令狐", "钟离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空", "兀官", "司寇", "南门", "呼延", "子车", "颛孙", "端木", "巫马", "公西", "漆雕", "车正", "壤驷", "公良", "拓跋", "夹谷", "宰父", "谷梁", "段干", "百里", "东郭", "微生", "梁丘", "左丘", "东门", "西门", "南宫", "第五", "公仪", "公乘", "太史", "仲长", "叔孙", "屈突", "尔朱", "东乡", "相里", "胡母", "司城", "张廖", "雍门", "毋丘", "贺兰", "綦毋", "屋庐", "独孤", "南郭", "北宫", "王孙"};
        String[] isName = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
                "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",
                "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",
                "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",
                "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
                "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭", "梅", "盛", "林", "刁", "钟",
                "徐", "邱", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝", "管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应",
                "宗", "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸", "左", "石", "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀",
                "羊", "于", "惠", "甄", "曲", "家", "封", "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山",
                "谷", "车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁", "仇", "栾", "暴", "甘", "钭", "厉", "戎", "祖", "武", "符", "刘", "景",
                "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "溥", "印", "宿", "白", "怀", "蒲", "邰", "从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠",
                "蒙", "池", "乔", "阴", "郁", "胥", "能", "苍", "双", "闻", "莘", "党", "翟", "谭", "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍", "却",
                "璩", "桑", "桂", "濮", "牛", "寿", "通", "边", "扈", "燕", "冀", "浦", "尚", "农", "温", "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习",
                "宦", "艾", "鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居", "衡", "步", "都", "耿", "满", "弘", "匡", "国", "文", "寇", "广", "禄",
                "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩", "厍", "聂", "晁", "勾", "敖", "融", "冷", "訾", "辛", "阚", "那", "简", "饶", "空",
                "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关", "蒯", "相", "查", "后", "荆", "红", "游", "郏", "竺", "权", "逯", "盖", "益", "桓", "公", "仉",
                "督", "岳", "帅", "缑", "亢", "况", "郈", "有", "琴", "归", "海", "晋", "楚", "闫", "法", "汝", "鄢", "涂", "钦", "商", "牟", "佘", "佴", "伯", "赏", "墨",
                "哈", "谯", "篁", "年", "爱", "阳", "佟", "言", "福", "南", "火", "铁", "迟", "漆", "官", "冼", "真", "展", "繁", "檀", "祭", "密", "敬", "揭", "舜", "楼",
                "疏", "冒", "浑", "挚", "胶", "随", "高", "皋", "原", "种", "练", "弥", "仓", "眭", "蹇", "覃", "阿", "门", "恽", "来", "綦", "召", "仪", "风", "介", "巨",
                "木", "京", "狐", "郇", "虎", "枚", "抗", "达", "杞", "苌", "折", "麦", "庆", "过", "竹", "端", "鲜", "皇", "亓", "老", "是", "秘", "畅", "邝", "还", "宾",
                "闾", "辜", "纵", "侴"};
//单姓（删除不常见姓氏 PS:删了好多）
        String[] laName = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "蒋", "沈", "韩", "杨", "朱", "秦", "许", "张", "孔", "曹", "严", "华", "金", "魏", "姜", "彭", "鲁", "马", "袁", "柳", "史", "唐", "薛", "罗", "齐", "元", "孟", "黄", "尹", "邵", "毛", "宋", "庞", "熊", "纪", "董", "梁", "杜", "阮", "贾", "江", "郭", "林", "钟", "徐", "高", "夏", "蔡", "田", "胡", "霍", "卢", "丁", "邓", "洪", "包", "石", "崔", "程", "陆", "焦", "刘", "叶", "申", "牛", "习", "关", "岳", "楚", "佟", "高"};
//名库
        String[] fiName = {"缈", "逸", "瞻", "渊", "暖", "清", "观", "崧", "遥", "崴", "崎", "腾", "崇", "飞", "喜", "飘", "善", "知", "啸", "邦", "昭", "巧", "真", "春", "美", "溪", "昶", "昊", "源", "明", "昌", "昆", "昙", "星", "易", "羿", "商", "州", "川", "羽", "昕", "景", "晨", "顺", "翎", "翔", "唯", "满", "智", "晴", "唤", "晋", "唐", "晟", "晖", "翼", "晓", "自", "皇", "袖", "馨", "耀", "山", "皎", "皓", "哲", "耘", "林", "果", "极", "耿", "耽", "枋", "香", "柳", "益", "盈", "聚", "柯", "盛", "柔", "聪", "尘", "尚", "柚", "咖", "尊", "盼", "柏", "相", "肃", "周", "峰", "朽", "峻", "朱", "峪", "朔", "月", "红", "朋", "纪", "纯", "启", "松", "岳", "绘", "杰", "织", "胜", "岩", "维", "吉", "金", "岚", "白", "百", "李", "杏", "癸", "君", "重", "释", "绩", "向", "衣", "累", "乾", "埔", "计", "紫", "氛", "订", "训", "疾", "讯", "气", "索", "民", "素", "书", "城", "设", "访", "许", "习", "论", "彭", "九", "埴", "彬", "彩", "乘", "永", "彪", "彤", "乔", "彦", "乖", "培", "乐", "乓", "基", "乒", "义", "茉", "久", "茄", "茅", "疏", "彷", "彰", "茂", "范", "影", "茁", "主", "为", "弈", "江", "高", "串", "丰", "语", "荷", "临", "垂", "弘", "型", "汀", "荣", "丙", "丘", "证", "业", "诀", "汽", "东", "识", "汾", "丞", "评", "汴", "弧", "词", "弦", "世", "强", "垣", "诗", "池", "诚", "七", "万", "忆", "价", "必", "町", "仲", "坚", "沐", "仰", "甲", "沛", "申", "任", "田", "沙", "志", "沅", "沃", "沂", "坊", "沁", "均", "莫", "沈", "甜", "仕", "生", "甘", "忠", "仑", "甚", "河", "仓", "沼", "沽", "沾", "沿", "沸", "念", "沧", "仁", "坪", "忽", "坤", "泓", "亳", "菲", "征", "亦", "享", "圃", "泊", "泉", "亩", "徙", "亨", "徘", "圆", "亮", "亭", "略", "京", "徜", "泰", "云", "留", "御", "场", "泳", "地", "徨", "亚", "驰", "圳", "泽", "波", "圭", "泥", "界", "德", "马", "争", "注", "事", "圣", "畅", "于", "般", "斗", "航", "佩", "洋", "料", "使", "文", "洛", "船", "舷", "舶", "洗", "回", "佳", "舍", "住", "幼", "位", "幽", "洪", "幸", "因", "新", "并", "年", "施", "津", "平", "璋", "方", "斧", "派", "舟", "洽", "佛", "余", "图", "国", "何", "洵", "誉", "固", "洲", "佑", "斩", "佐", "舒", "帛", "良", "帝", "瓦", "济", "伯", "传", "流", "米", "浅", "伦", "伧", "浙", "师", "伺", "浚", "旅", "艾", "希", "布", "旋", "市", "帅", "伴", "族", "帆", "浪", "伊", "常", "浩", "时", "旷", "伏", "伍", "旺", "浣", "企", "浦", "既", "伟", "旦", "席", "日", "早", "旨", "海", "众", "旭", "涅", "信", "琪", "芯", "芮", "芭", "俯", "芬", "修", "琦", "芫", "琢", "芷", "芳", "俱", "涓", "花", "芽", "攀", "廉", "芸", "涛", "芹", "粗", "政", "润", "延", "放", "粒", "琉", "节", "芍", "俏", "理", "收", "俊", "建", "芊", "俗", "芒", "俐", "俞", "芝", "保", "言", "芙", "粉", "嘉", "若", "庚", "府", "侯", "敖", "效", "英", "瑾", "庆", "敏", "淘", "床", "苹", "故", "便", "淡", "康", "庶", "庸", "庾", "侍", "苑", "苓", "深", "苔", "度", "瑞", "座", "苗", "庭", "依", "央", "冶", "天", "鑫", "冰", "太", "冲", "冬", "珍", "珏", "珈", "珊", "珀", "冠", "拳", "备", "路", "军", "拉", "夏", "复", "冒", "拂", "多", "拓", "珠", "越", "笃", "奢", "出", "奥", "函", "凰", "超", "玖", "笑", "玉", "凯", "笙", "抱", "凡", "笛", "玄", "好", "率", "玻", "奂", "笠", "奇", "奋", "玫", "凌", "奔", "奕", "净", "准", "资", "执", "铭", "扬", "鱼", "银", "承", "赤", "扇", "才", "如", "铁", "妙", "共", "姬", "兵", "其", "具", "典", "钦", "兼", "姿", "全", "六", "贝", "贡", "财", "贤", "成", "贵", "兆", "钟", "克", "光", "武", "步", "正", "长", "傲", "歌", "镜", "穹", "空", "镇", "堆", "堂", "欢", "欣", "欧", "犁", "锦", "程", "锐", "萧", "锋", "竟", "捷", "毫", "站", "闻", "倩", "闲", "蓝", "问", "豆", "门", "立", "闪", "值", "竿", "牧", "竹", "牡", "竺", "倍", "毅", "物", "章", "豪", "豫", "倚", "境", "健", "壮", "振", "谷", "挚", "谦", "桓", "厚", "桑", "迪", "桐", "际", "祥", "桔", "蝶", "桂", "桃", "祺", "迁", "迅", "桦", "远", "运", "神", "祟", "栗", "悉", "树", "阔", "标", "悟", "字", "达", "社", "孟", "孝", "参", "辰", "熙", "阡", "辉", "季", "叶", "悠", "阳", "熊", "麦", "古", "栩", "宋", "安", "积", "宏", "北", "雀", "雁", "轩", "宁", "秦", "宇", "恒", "宙", "照", "实", "宝", "宜", "轻", "宗", "鹏", "雪", "秉", "雨", "宫", "秋", "秀", "恩", "客", "宣", "煜", "鹿", "鹤", "科", "棠", "南", "卓", "隆", "寂", "博", "梓", "升", "禾", "千", "禹", "华", "梅", "思", "寒", "梁", "卉", "福", "卷", "怡", "鸽", "梧", "卫", "青", "烨", "靖", "威", "功", "虹", "烈", "娱", "懿", "硕", "加", "虎", "劲", "励", "霖", "炬", "炯", "勉", "勋", "炫", "霜", "勇", "霄", "龙", "炎", "婷", "研", "勤", "齐", "列", "慈", "刚", "初", "灿", "音", "利", "韵", "韶", "磊", "韬", "鼎", "瀚"};
//省
        String[] provinces = {"吉林", "广东", "山东", "河南", "河北", "四川"};
//省下面的市
        String[] jilin = {"吉林市", "长春市", "白山市", "延边州", "白城市", "松原市", "辽源市", "通化市", "四平市"};
        String[] guangdong = {"东莞市", "广州市", "深圳市", "惠州市", "江门市", "珠海市", "汕头市", "佛山市", "湛江市", "河源市", "肇庆市", "清远市", "潮州市", "韶关市", "揭阳市", "阳江市", "梅州市", "云浮市", "茂名市", "汕尾市"};
        String[] shandong = {"济南市", "青岛市", "临沂市", "济宁市", "菏泽市", "烟台市", "淄博市", "泰安市", "潍坊市", "日照市", "威海市", "滨州市", "东营市", "聊城市", "德州市", "莱芜市", "枣庄市"};
        String[] henan = {"郑州市", "南阳市", "新乡市", "安阳市", "洛阳市", "信阳市", "平顶山市", "周口市", "商丘市", "开封市", "焦作市", "驻马店市", "濮阳市", "三门峡市", "漯河市", "许昌市", "鹤壁市"};
        String[] hebei = {"石家庄市", "唐山市", "保定市", "邯郸市", "邢台市", "沧州市", "秦皇岛市", "张家口市", "衡水市", "廊坊市", "承德市"};
        String[] sichuan = {"成都市", "绵阳市", "广元市", "达州市", "南充市", "德阳市", "广安市", "阿坝州", "巴中市", "遂宁市", "内江市", "凉山州", "攀枝花市", "自贡市", "泸州市", "雅安市", "宜宾市", "资阳市", "眉山市", "甘孜州"};
//市下面的区和县
        String[] beijing = {"朝阳区", "海淀区", "通州区", "房山区", "丰台区", "昌平区", "大兴区", "顺义区", "西城区", "延庆县", "石景山区", "宣武区", "怀柔区", "崇文区", "密云县", "东城区", "平谷区", "门头沟区"};
//吉林
        String[] changchun = {"南关区", "宽城区", "朝阳区", "二道区", "绿园区", "双阳区", "九台区", "榆树市", "德惠市", "农安县"};
        String[] jilins = {"船营区", "龙潭区", "昌邑区", "丰满区", "永吉县", "磐石市", "桦甸市", "蛟河市", "舒兰市"};
        String[] baishan = {"抚松县", "靖宇县", "临江市", "浑江区"};
        String[] yanbian = {"延吉市", "图们市", "龙井市", "和龙市", "汪清县", "安图县"};
        String[] baicheng = {"大安市", "洮北区", "洮南区", "通榆县", "镇赉县"};
        String[] songyuan = {"扶余县", "宁江区", "乾安县", "长岭县"};
        String[] liaoyuan = {"龙山区", "西安区", "东丰县", "东辽县"};
        String[] tonghua = {"东昌区", "二道江区", "通化县", "柳河县", "辉南县"};
        String[] siping = {"铁西区", "铁东区", "双辽市", "梨树县", "伊通满族自治县", "公主岭市"};
//广东
        String[] dongguan = {"莞城区", "东城区", "南城区", "万江区"};
        String[] guangzhou = {"越秀区", "荔湾区", "海珠区", "天河区", "白云区", "黄埔区", "萝岗区", "番禺区", "花都区", "南沙区", "萝岗区", "增城市", "从化市"};
        String[] shenzhen = {"宝安区", "福田区", "龙岗区", "罗湖区", "南山区", "盐田区"};
        String[] huizhou = {"惠城区", "惠阳区", "惠东县", "博罗县", "龙门县"};
        String[] jiangmen = {"蓬江区", "江海区", "新会区", "台山市", "开平市", "鹤山市", "恩平市"};
        String[] zhuahi = {"斗门区", "金湾区", "香洲区"};
        String[] shantou = {"金平区", "龙湖区", "澄海区", "濠江区", "潮南区", "潮阳区", "南澳县"};
        String[] foshan = {"禅城区", "南海区", "顺德区", "高明区", "三水区"};
        String[] zhanjiang = {"赤坎区", "雷州市", "廉江市", "麻章区", "坡头区", "遂溪县", "吴川市", "霞山区", "徐闻县"};
        String[] heyuan = {"源城区", "和平县", "龙川县", "东源县", "紫金县", "连平县"};
        String[] zhaoqing = {"端州区", "鼎湖区", "高要区", "广宁县", "怀集县", "封开县", "德庆县", "四会区"};
        String[] qingyuan = {"清城区", "清新区", "佛冈县", "阳山县", "英德市", "连州市"};
        String[] chaozhou = {"湘桥区", "潮安区", "枫溪区", "饶平县"};
        String[] meizhou = {"兴宁市", "梅江区", "梅县区", "大埔县", "丰顺县", "五华县", "平远县", "蕉岭县"};
        String[] shaoguan = {"浈江区", "武江区", "曲江区", "乐昌市", "南雄市", "始兴县", "仁化县", "翁源县", "新丰县"};
        String[] jieyang = {"榕城区", "揭东区", "揭西县", "惠来县", "普宁市"};
        String[] yangjiang = {"江城区", "阳东区", "阳西县", "阳春市"};
        String[] yunfu = {"云城区", "罗定市", "云安区", "新兴县", "郁南县"};
        String[] maoming = {"茂南区", "电白区", "高州市", "化州市", "信宜市"};
        String[] shanwei = {"城区", "陆丰市", "海丰县", "陆河县"};
//山东
        String[] jinan = {"历下区", "市中区", "槐荫区", "天桥区", "历城区", "长清区", "平阴县", "济阳县", "商河县", "章丘市"};
        String[] qingdao = {"市南区", "市北区", "黄岛区", "崂山区", "李沧区", "胶州市", "即墨市", "平度市", "莱西市"};
        String[] liyi = {"兰山区", "罗庄区", "河东区", "郯城县", "兰陵县", "莒南县", "沂水县", "蒙阴县", "平邑县", "费县", "沂南县", "临沭县"};
        String[] jining = {"任城区", "兖州区", "微山县", "鱼台县", "金乡县", "嘉祥县", "汶上县", "泗水县", "梁山县"};
        String[] heze = {"牡丹区", "开发区", "定陶区", "巨野县", "曹县", "成武县", "单县", "郓城县", "鄄城县", "东明县"};
        String[] yantai = {"芝罘区", "福山区", "牟平区", "莱山区", "长岛县", "龙口市", "莱阳市", "莱州市", "蓬莱市", "招远市", "栖霞市", "海阳市"};
        String[] zibo = {"张店区", "淄川区", "博山区", "周村区", "临淄区", "桓台县", "高青县", "沂源县"};
        String[] taian = {"泰山区", "岱岳区", "新泰市", "肥城市", "宁阳县", "东平县"};
        String[] weifang = {"潍城区", "奎文区", "坊子区", "寒亭区", "青州市", "诸城市", "寿光市", "安丘市", "高密市", "昌邑市", "昌乐县", "临朐县"};
        String[] rizhao = {"东港区", "岚山区", "莒县", "五莲县"};
        String[] weihai = {"文登区", "南海新区", "荣成市", "乳山市"};
        String[] bingzhou = {"滨城区", "沾化区", "邹平县", "博兴县", "惠民县", "阳信县", "无棣县"};
        String[] dongying = {"东营区", "河口区", "广饶县", "垦利县", "利津县"};
        String[] liaocheng = {"东昌府区", "开发区", "临清市", "茌平", "东阿", "高唐", "阳谷", "冠县", "莘县", "莱州市", "蓬莱市", "招远市", "栖霞市", "海阳市"};
        String[] dezhou = {"陵城区", "禹城市", "乐陵市", "临邑县", "平原县", "夏津县", "武城县", "庆云县", "宁津县", "齐河县"};
        String[] laiwu = {"莱城区", "钢城区"};
        String[] zaozhuang = {"薛城区", "市中区", "峄城区", "山亭区", "台儿庄区", "滕州市"};
//河南
        String[] zhengzhou = {"中原区", "二七区", "管城回族区", "金水区", "上街区", "惠济区", "中牟县", "巩义市", "荥阳市", "新密市", "新郑市", "登封市"};
        String[] nanyang = {"宛城区", "卧龙区", "南召县", "镇平县", "内乡县", "淅川县", "新野县", "唐河县", "桐柏县", "方城县", "西峡县", "社旗县"};
        String[] xinxiang = {"卫滨区", "红旗区", "凤泉区", "牧野区", "卫辉市", "辉县市", "新乡县", "获嘉县", "原阳县", "延津县", "封丘县"};
        String[] anyang = {"文峰区", "北关区", "殷都区", "龙安区", "安阳县", "汤阴县", "内黄县", "林州市"};
        String[] luoyang = {"涧西区", "西工区", "老城区", "洛龙区", "吉利区", "偃师市", "孟津县", "新安县", "宜阳县", "伊川县", "洛宁县", "嵩县", "栾川县", "汝阳县"};
        String[] xinyang = {"浉河区", "平桥区", "息县", "新县", "罗山县", "潢川县", "光山县", "商城县", "固始县", "淮滨县"};
        String[] pingdingshan = {"辖新华区", "卫东区", "湛河区", "石龙区", "舞钢市", "叶县", "鲁山", "宝丰", "郏县"};
        String[] zhoukou = {"川汇区", "扶沟县", "西华县", "商水县", "沈丘县", "郸城县", "淮阳县", "太康县", "鹿邑县", "项城市"};
        String[] shangqiu = {"永城市", "睢阳区", "梁园区", "商丘新区", "虞城县", "柘城县", "夏邑县", "民权县", "睢县", "宁陵县"};
        String[] kaifeng = {"鼓楼区", "龙亭区", "禹王台区", "兰考县", "杞县", "通许县"};
        String[] jiaozuo = {"解放区", "中站区", "马村区", "山阳区", "修武县", "博爱县", "武陟县", "温县", "沁阳市", "孟州市"};
        String[] zhumadian = {"驿城区", "确山县", "泌阳县", "遂平县", "西平县", "上蔡县", "汝南县", "平舆县", "正阳县"};
        String[] puyang = {"华龙区", "开发区", "濮阳县", "清丰县", "南乐县", "范县", "台前县"};
        String[] sanxiamen = {"湖滨区", "渑池县", "陕州区", "卢氏县", "义马市", "灵宝市"};
        String[] luohe = {"临颍县", "舞阳县", "郾城区", "源汇区", "召陵区"};
        String[] xuchang = {"魏都区", "许昌县", "鄢陵县", "襄城县", "禹州市", "长葛市"};
        String[] hebi = {"淇滨区", "山城区", "鹤山区", "淇县", "浚县"};
//河北
        String[] shijiazhuang = {"新华区", "桥西区", "长安区", "裕华区", "矿区", "藁城区", "鹿泉区", "栾城区", "辛集市", "晋州市", "新乐市", "正定县", "深泽县", "无极县", "赵县", "高邑县", "元氏县", "赞皇县", "井陉县", "平山县", "灵寿县", "行唐县"};
        String[] tangshan = {"路南区", "路北区", "古冶区", "开平区", "丰南区", "丰润区", "曹妃甸区", "滦县", "滦南县", "乐亭县", "迁西县", "玉田县", "遵化市", "迁安市"};
        String[] baoding = {"定州市", "竞秀区", "莲池区", "满城区", "清苑区", "徐水区", "高碑店市", "安国市", "涞水县", "唐县", "易县", "涞源县", "定兴县", "顺平县", "望都县", "高阳县", "安新县", "雄县", "容城县", "曲阳县", "阜平县", "博野县", "蠡县"};
        String[] handan = {"邯山区", "丛台区", "复兴区", "峰峰矿区", "邯郸县", "临漳县", "成安县", "大名县", "涉县", "磁县", "肥乡县", "永年县", "邱县", "鸡泽县", "广平县", "馆陶县", "魏县", "曲周县", "武安市"};
        String[] xingtai = {"桥东区", "桥西区", "南宫市", "沙河市", "邢台县", "柏乡县", "柏乡县", "宁晋县", "隆尧县", "临城县", "广宗县", "临西县", "内丘县", "平乡县", "巨鹿县", "新河县", "南和县"};
        String[] cangzhou = {"运河区", "新华区", "泊头市", "任丘市", "黄骅市", "河间市", "沧县", "青县", "东光县", "海兴县", "盐山县", "肃宁县", "南皮县", "吴桥县", "献县"};
        String[] qinhuangdao = {"海港区", "山海关区", "抚宁区", "北戴河区", "青龙县", "昌黎县", "卢龙县"};
        String[] zhangjiakou = {"桥西区", "桥东区", "下花园区", "宣化区", "万全区", "崇礼区", "张北县", "康保县", "沽源县", "尚义县", "蔚县", "阳原县", "怀安县", "怀来县", "涿鹿县", "赤城县"};
        String[] hengshui = {"桃城区", "滨湖新区", "工业新区", "冀州", "深州", "枣强县", "武邑县", "武强县", "饶阳县", "安平县", "故城县", "阜城县", "景县"};
        String[] langfang = {"三河市", "霸州市", "香河县", "固安县", "永清县", "文安县", "大城县", "大厂回族自治县"};
        String[] chengde = {"承德县", "隆化县", "围场县", "丰宁县", "滦平县", "兴隆县", "青龙县", "平泉县"};
//四川
        String[] chengdu = {"武侯区", "锦江区", "青羊区", "金牛区", "成华区", "龙泉驿区", "温江区", "新都区", "青白江区", "双流区", "郫县", "蒲江县", "大邑县", "金堂县", "新津县", "都江堰市", "彭州市", "邛崃市", "崇州市", "简阳市"};
        String[] mianyang = {"涪城区", "游仙区", "安州区", "三台县", "盐亭县", "梓潼县", "平武县", "江油市"};
        String[] guangyuan = {"利州区", "昭化区", "朝天区", "旺苍县", "青川县", "剑阁县", "苍溪县"};
        String[] dazhou = {"通川区", "达川区", "宣汉县", "开江县", "大竹县", "渠县", "万源市"};
        String[] nanyun = {"顺庆区", "高坪区", "嘉陵区", "西充县", "南部县", "蓬安县", "营山县", "仪陇县", "阆中市"};
        String[] deyang = {"旌阳区", "什邡市", "广汉市", "绵竹市", "罗江县", "中江县"};
        String[] guangan = {"广安区", "前锋区", "岳池县", "武胜县", "邻水县", "华蓥市"};
        String[] aba = {"马尔康市", "九寨沟县", "小金县", "阿坝县", "若尔盖县", "红原县", "壤塘县", "汶川县", "理县", "茂县", "松潘县", "金川县", "黑水县"};
        String[] bazhong = {"巴州区", "恩阳区", "通江县", "南江县", "平昌县"};
        String[] suining = {"船山区", "安居区", "射洪县", "蓬溪县", "大英县"};
        String[] neijiang = {"市中区", "东兴区", "资中县", "威远县", "隆昌县"};
        String[] liangshan = {"西昌市", "盐源县", "德昌县", "会理县", "会东县", "宁南县", "普格县", "布拖县", "金阳县", "昭觉县", "喜德县", "冕宁县", "越西县", "甘洛县", "美姑县", "雷波县"};
        String[] panzhihua = {"东区", "西区", "仁和区", "米易县", "盐边县"};
        String[] zigong = {"自流井区", "贡井区", "大安区", "沿滩区", "荣县", "富顺县"};
        String[] luzhou = {"江阳区", "龙马潭区", "纳溪区", "纳溪区", "泸县", "合江县", "叙永县", "古蔺县"};
        String[] yaan = {"雨城区", "名山区", "县荥经县", "汉源县", "石棉县", "天全县", "芦山县", "宝兴县"};

        String[] yibin = {"翠屏区", "南溪区", "宜宾县", "江安县", "长宁县", "高县", "筠连县", "珙县", "兴文县", "屏山县"};
        String[] ziyang = {"雁江区", "安岳县", "乐至县"};
        String[] meishan = {"东坡区", "彭山区", "仁寿县", "丹棱县", "青神县", "洪雅县"};
        String[] ganzi = {"康定市", "泸定县", "丹巴县", "九龙县", "雅江县", "道孚县", "炉霍县", "甘孜县", "新龙县", "德格县", "白玉县", "石渠县", "色达县", "理塘县", "巴塘县", "乡城县", "稻城县", "得荣县"};

        java.util.HashMap shengTOshi = new java.util.HashMap();
        shengTOshi.put("吉林", jilin);
        shengTOshi.put("广东", guangdong);
        shengTOshi.put("山东", shandong);
        shengTOshi.put("河南", henan);
        shengTOshi.put("河北", hebei);
        shengTOshi.put("四川", sichuan);

        java.util.HashMap shiTOqu = new java.util.HashMap();
        shiTOqu.put("北京", beijing);
//吉林
        shiTOqu.put("吉林市", jilins);
        shiTOqu.put("长春市", changchun);
        shiTOqu.put("白山市", baishan);
        shiTOqu.put("延边州", yanbian);
        shiTOqu.put("白城市", baicheng);
        shiTOqu.put("松原市", songyuan);
        shiTOqu.put("辽源市", liaoyuan);
        shiTOqu.put("通化市", tonghua);
        shiTOqu.put("四平市", siping);
//广东
        shiTOqu.put("东莞市", dongguan);
        shiTOqu.put("广州市", guangzhou);
        shiTOqu.put("深圳市", shenzhen);
        shiTOqu.put("惠州市", huizhou);
        shiTOqu.put("江门市", jiangmen);
        shiTOqu.put("珠海市", zhuahi);
        shiTOqu.put("汕头市", shantou);
        shiTOqu.put("佛山市", foshan);
        shiTOqu.put("湛江市", zhanjiang);
        shiTOqu.put("河源市", heyuan);
        shiTOqu.put("肇庆市", zhaoqing);
        shiTOqu.put("清远市", qingyuan);
        shiTOqu.put("潮州市", chaozhou);
        shiTOqu.put("梅州市", meizhou);
        shiTOqu.put("韶关市", shaoguan);
        shiTOqu.put("揭阳市", jieyang);
        shiTOqu.put("阳江市", yangjiang);
        shiTOqu.put("云浮市", yunfu);
        shiTOqu.put("茂名市", maoming);
        shiTOqu.put("汕尾市", shanwei);
//山东
        shiTOqu.put("济南市", jinan);
        shiTOqu.put("青岛市", qingdao);
        shiTOqu.put("临沂市", liyi);
        shiTOqu.put("济宁市", jining);
        shiTOqu.put("菏泽市", heze);
        shiTOqu.put("烟台市", yantai);
        shiTOqu.put("淄博市", zibo);
        shiTOqu.put("泰安市", taian);
        shiTOqu.put("潍坊市", weifang);
        shiTOqu.put("日照市", rizhao);
        shiTOqu.put("威海市", weihai);
        shiTOqu.put("滨州市", bingzhou);
        shiTOqu.put("东营市", dongying);
        shiTOqu.put("聊城市", liaocheng);
        shiTOqu.put("德州市", dezhou);
        shiTOqu.put("莱芜市", laiwu);
        shiTOqu.put("枣庄市", zaozhuang);
//河南
        shiTOqu.put("郑州市", zhengzhou);
        shiTOqu.put("南阳市", nanyang);
        shiTOqu.put("新乡市", xinxiang);
        shiTOqu.put("安阳市", anyang);
        shiTOqu.put("洛阳市", luoyang);
        shiTOqu.put("信阳市", xinyang);
        shiTOqu.put("平顶山市", pingdingshan);
        shiTOqu.put("周口市", zhoukou);
        shiTOqu.put("商丘市", shangqiu);
        shiTOqu.put("开封市", kaifeng);
        shiTOqu.put("焦作市", jiaozuo);
        shiTOqu.put("驻马店市", zhumadian);
        shiTOqu.put("濮阳市", puyang);
        shiTOqu.put("三门峡市", sanxiamen);
        shiTOqu.put("漯河市", luohe);
        shiTOqu.put("许昌市", xuchang);
        shiTOqu.put("鹤壁市", hebi);
//河北
        shiTOqu.put("石家庄市", shijiazhuang);
        shiTOqu.put("唐山市", tangshan);
        shiTOqu.put("保定市", baoding);
        shiTOqu.put("邯郸市", handan);
        shiTOqu.put("邢台市", xingtai);
        shiTOqu.put("沧州市", cangzhou);
        shiTOqu.put("秦皇岛市", qinhuangdao);
        shiTOqu.put("张家口市", zhangjiakou);
        shiTOqu.put("衡水市", hengshui);
        shiTOqu.put("廊坊市", langfang);
        shiTOqu.put("承德市", chengde);
//四川
        shiTOqu.put("成都市", chengdu);
        shiTOqu.put("绵阳市", mianyang);
        shiTOqu.put("广元市", guangyuan);
        shiTOqu.put("达州市", dazhou);
        shiTOqu.put("南充市", nanyun);
        shiTOqu.put("德阳市", deyang);
        shiTOqu.put("广安市", guangan);
        shiTOqu.put("阿坝州", aba);
        shiTOqu.put("巴中市", bazhong);
        shiTOqu.put("遂宁市", suining);
        shiTOqu.put("内江市", neijiang);
        shiTOqu.put("凉山州", liangshan);
        shiTOqu.put("攀枝花市", panzhihua);
        shiTOqu.put("自贡市", zigong);
        shiTOqu.put("泸州市", luzhou);
        shiTOqu.put("雅安市", yaan);
        shiTOqu.put("宜宾市", yibin);
        shiTOqu.put("资阳市", ziyang);
        shiTOqu.put("眉山市", meishan);
        shiTOqu.put("甘孜州", ganzi);
//没有省
        String[][] shi = {jilin, guangdong, shandong, henan, hebei, sichuan};

//不做清洗的字符串
        String[] noChange1 = {"新", "氏", "古", "江", "街", "款", "初", "班", "饭", "期", "分", "大", "附", "北", "站", "左", "屯", "坊", "巷", "城", "省", "厂", "四", "乡", "九", "院", "路", "县", "区", "园", "室", "镇", "面", "桥", "堍", "层", "内", "幢", "洲", "州", "厦", "家", "楼", "南", "侧", "店", "前", "部", "弄", "旁", "组", "庄", "浜", "十", "户", "中", "社", "荡", "八", "市", "队", "六", "栋", "后", "五", "东", "号", "村", "右", "第", "苑", "三", "西", "小", "座", "环", "寺", "一", "七", "二", "口", "委", "道", "F", "~", "！", "@", "#", "￥", "%", "…", "^", "……", "&", "*", "（", "）", "—", "—", "+", "}", "{", "：", "“", "》", "《", "？", "-", "(", ")", "."
        };
        String[] noChange2 = {"家纺", "复合", "材料", "蒜业", "高新", "纤维", "生物", "冷藏", "加工", "技术", "服饰", "原野", "矿山", "家具", "橡塑", "包装", "挂车", "配件", "管业", "煤业", "玻璃", "果品", "制衣", "链条", "木艺", "农药", "手套", "地毯", "食品", "货运", "代理", "轮胎", "焊割", "塑胶", "地板", "索具", "企业", "农贸", "煤化", "化学", "纸业", "水产", "中国", "童装", "商城", "党校", "代发", "交易", "建设", "房间", "网络", "汽车", "木业", "家私", "酒店", "水果", "勘察", "工资", "保险", "银川", "维修", "交通", "国资", "工贸", "实业", "二手", "分行", "批发", "安装", "保护", "食堂", "生育", "旅游", "宿舍", "小额", "电器", "组织", "计划", "工程", "监督", "实验", "农场", "孵化", "卫生", "综合", "科技", "执法", "运营", "清真", "码头", "财政", "粮油", "管理", "分局", "商业", "文化", "广播", "单元", "印刷", "开发", "示范", "吴忠", "塑料", "装饰", "大修", "个人", "小学", "建材", "医疗", "联合", "技校", "嘉兴", "人民", "学校", "车队", "资产", "贷款", "政府", "服务", "种植", "中学", "行政", "工委", "城管", "地质", "支队", "监测", "小区", "设备", "天窗", "街道", "公路", "物业", "胶粘", "南寺", "财务", "精神", "果蔬", "机构", "景观", "地籍", "超市", "浙江", "宾馆", "电声", "电视", "宁夏", "核算", "流通", "海洋", "餐饮", "农民", "编制", "化工", "支行", "促进", "国土", "发展", "河北", "器材", "银行", "市场", "机械", "疾病", "车行", "集中", "外事", "政协", "机电", "环境", "大街", "监察", "固原", "制造", "针织", "专业", "控制", "幼儿", "集团", "社区", "第一", "瓜果", "环保", "纺织", "运动", "园区", "休闲", "商行", "中共", "股份", "传播", "中卫", "酒楼", "中心", "国际", "防水", "增补", "广电", "林业", "高中", "电子", "资金", "责任", "幕墙", "印务", "大学", "农村", "有限", "物资", "器械", "检测", "珠宝", "电力", "苗木", "办公", "供水", "保卫", "服装", "畜牧", "经济", "花园", "村级", "公司", "咨询", "回收", "动物", "衡水", "养殖", "保洁", "宣传", "园林", "节能", "销售", "贸易", "商贸", "连锁", "制品", "挖潜", "路桥", "矿业", "预防", "工业", "陶瓷", "营业", "农业"
        };
        String[] noChange3 = {"农产品", "新能源", "工艺品", "太阳能", "进出口", "土特产", "副食品", "合作社", "清真寺", "互助社", "竹纤维", "批发部", "经销部", "电动车"
        };
        String[] noChangeStart = {"中国人民银行", "中国"
        };
//没有”省“字导致清洗结果失真
        String[] chengeSheng = {"曲阜", "济宁", "泗水", "鱼台", "梁山", "正阳", "滕州", "菏泽", "北京", "天津", "上海", "重庆", "河北", "山西", "辽宁", "吉林", "黑龙", "江苏", "浙江", "安徽", "福建", "江西", "山东", "河南", "湖北", "湖南", "广东", "海南", "四川", "贵州", "云南", "陕西", "甘肃", "青海", "台湾", "内蒙", "广西", "西藏", "宁夏", "新疆", "香港", "澳门"};

        String newStrSheng = "";
        String newStrShi = "";
        String newStrXian = "";
        String newStrQu = "";
        String newCun = "";
        String noChangeStartStr = "";
//复姓
        boolean isTwoName = false;
        boolean isOneName = false;

        int nameHashCode = 0;
        String s = "";
//默认hash是盐
        int hash1 = hashSalt;
//type= :1 只有省没有市 2 有省有市 3 没省有市
        int type = 0;
//小于5作姓名判断
        if (str.length() < 5) {
//开始处理姓名
//判断是否是复姓
            for (int i = 0; i < fuxing.length; i++) {
                if (str.startsWith(fuxing[i])) {
                    isTwoName = true;
                    break;
                }
            }
//判断是否是单姓
            for (int i = 0; i < isName.length; i++) {
                if (str.startsWith(isName[i])) {
                    isOneName = true;
                    break;
                }
            }
        }
        String[] nameArray = new String[str.length()];
        if (isOneName || isTwoName) {
            if (isOneName) {
                for (int i = 0; i < str.length(); i++) {
                    nameHashCode = Math.abs(str.substring(i, i + 1).hashCode() + hashSalt);
                    if (i == 0) {
                        nameArray[i] = laName[nameHashCode % (laName.length - 1)];//姓
                    } else {
                        nameArray[i] = fiName[nameHashCode % (fiName.length - 1)];//名
                    }
                }
            }
            if (isTwoName) {
                for (int i = 0; i < str.length(); i++) {
                    nameHashCode = Math.abs(str.substring(i, i + 1).hashCode() + hashSalt);
                    if (i == 0) {
                        nameArray[i] = fuxing[nameHashCode % (fuxing.length - 1)];//姓
                        i++;
                    } else {
                        nameArray[i] = fiName[nameHashCode % (fiName.length - 1)];//名
                    }
                }
            }
            for (int i = 0; i < nameArray.length; i++) {
                s += nameArray[i];
            }
        } else {
//开始处理公司名、地址
            for (int i = 0; i < noChangeStart.length; i++) {
                if (str.startsWith(noChangeStart[i])) {
                    noChangeStartStr = noChangeStart[i];
                }
            }
//获取省
            if (str.contains("省")) {
                String[] arrStr1 = str.split("省");
                if (arrStr1.length < 2) return value;
                hash1 = Math.abs(arrStr1[0].hashCode() + hashSalt);
                newStrSheng = provinces[hash1 % (provinces.length - 1)];
                str = arrStr1[1];
                type = 1;
            }
//获取市
            if (str.contains("市")) {
                String[] arrStr1 = str.split("市");
                if (arrStr1.length < 2) return value;
                hash1 = Math.abs(arrStr1[0].hashCode() + hashSalt);
                if (type == 1) {
                    newStrShi = ((String[]) shengTOshi.get(newStrSheng))[hash1 % (((String[]) shengTOshi.get(newStrSheng)).length - 1)];
                    type = 2;
                } else {
                    String[] arryTemp = shi[hash1 % (shi.length - 1)];
                    newStrShi = arryTemp[hash1 % (arryTemp.length - 1)];
                    type = 3;
                }
                str = "";
                for (int i = 1; i < arrStr1.length; i++) {
                    str += arrStr1[i] + "市";
                }
                str = str.substring(0, str.length() - 1);
            }
//-------------------------------------------------------------
            if (str.contains("县")) {
                String[] arrStr1 = str.split("县");
                if (arrStr1.length < 2) return value;
                hash1 = Math.abs(arrStr1[0].hashCode() + hashSalt);
                if (type == 0) {
                    newStrShi = ((String[]) shengTOshi.get(provinces[hash1 % provinces.length]))[hash1 % (((String[]) shengTOshi.get(provinces[hash1 % provinces.length])).length - 1)];
                    newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                    newStrShi = "";
                }
                if (type == 1) {
                    newStrShi = ((String[]) shengTOshi.get(newStrSheng))[hash1 % (((String[]) shengTOshi.get(newStrSheng)).length - 1)];
                    newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                    newStrShi = "";
                }
                if (type == 2) {
                    newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                }
                if (type == 3) {
                    newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                }
                str = arrStr1[1];
            } else if (str.contains("区")) {
                if (str.contains("小区")) {
                    String[] arrStr1xiaoqu = str.split("小区");
                    String tem = "";
                    if (arrStr1xiaoqu[0].contains("区")) {
                        String[] arrStr1 = str.split("区");
                        tem = arrStr1[1];
                        if (arrStr1.length < 2) return value;
                        hash1 = Math.abs(arrStr1[0].hashCode() + hashSalt);
                        if (type == 1) {
                            newStrShi = ((String[]) shengTOshi.get(newStrSheng))[hash1 % (((String[]) shengTOshi.get(newStrSheng)).length - 1)];
                            newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                            newStrShi = "";
                        }
                        if (type == 2) {
                            newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                        }
                        if (type == 3) {
                            newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                        }
                    }
                    if (arrStr1xiaoqu.length >= 2) {
                        str = tem + "小区" + arrStr1xiaoqu[1];
                    }
                } else {
                    try {
                        String[] arrStr1 = str.split("区");
                        hash1 = Math.abs(arrStr1[0].hashCode() + hashSalt);
                        if (type == 0) {
                            newStrShi = ((String[]) shengTOshi.get(provinces[hash1 % provinces.length]))[hash1 % (((String[]) shengTOshi.get(provinces[hash1 % provinces.length])).length - 1)];
                            newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                            newStrShi = "";
                        }
                        if (type == 1) {
                            newStrShi = ((String[]) shengTOshi.get(newStrSheng))[hash1 % (((String[]) shengTOshi.get(newStrSheng)).length - 1)];
                            newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                            newStrShi = "";
                        }
                        if (type == 2) {
                            newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                        }
                        if (type == 3) {
                            newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                        }

                        if (arrStr1.length > 1) {
                            str = "";
                            for (int i = 1; i < arrStr1.length; i++) {
                                str += arrStr1[i] + "区";
                            }
                            str = str.substring(0, str.length() - 1);
                        } else {
                            str = arrStr1[0];
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return value;
                    }
                }
            }
            String[] arrStr = new String[str.length()];
            for (int i = 0; i < arrStr.length; i++) {
                arrStr[i] = str.substring(i, i + 1);
            }
            for (int i = 0; i < arrStr.length; i++) {

                int temp = 0;
                try {
                    for (int j = 0; j < noChange3.length; j++) {
                        if (arrStr[i].contains(noChange3[j].substring(0, 1)) && arrStr[i + 1].contains(noChange3[j].substring(1, 2)) && arrStr[i + 2].contains(noChange3[j].substring(2, 3))) {
                            i += 2;
                            temp = 1;
                            break;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    i += 2;
                    continue;
                }
                try {
                    for (int j = 0; j < noChange2.length; j++) {
                        if (arrStr[i].contains(noChange2[j].substring(0, 1)) && arrStr[i + 1].contains(noChange2[j].substring(1, 2))) {
                            i += 1;
                            temp = 1;
                            break;
                        }
                    }
                    for (int j = 0; j < chengeSheng.length; j++) {
                        if (arrStr[i].contains(chengeSheng[j].substring(0, 1)) && arrStr[i + 1].contains(chengeSheng[j].substring(1, 2))) {
                            arrStr[i] = chengeSheng[j].substring(0, 1);
                            arrStr[i + 1] = chengeSheng[j].substring(1, 2);
                            i += 1;
                            temp = 1;
                            break;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    i += 1;
                    continue;
                }
                for (int j = 0; j < noChange1.length; j++) {
                    if (arrStr[i].equals(noChange1[j])) {
                        temp = 1;
                        break;
                    }
                }
                if (arrStr[i].contains("市")) {
                    arrStr[i] = "街";
                    continue;
                }
                if (pattern1.matcher(arrStr[i]).matches()) {
                    String s1 = Math.abs(arrStr[i].hashCode() + hashSalt) + "";
                    arrStr[i] = s1.substring(s1.length() - 1, s1.length());
                    continue;
                }
                if (pattern2.matcher(arrStr[i]).matches()) {
                    String chars = "abcdeghijklmnopqrstuvwxyz";
                    arrStr[i] = chars.charAt((Math.abs(arrStr[i].hashCode() + hashSalt)) % 25) + "";
                    continue;
                }
                if (pattern3.matcher(arrStr[i]).matches()) {
                    String chars = "ABCDEGHIJKLMNOPQRSTUVWXYZ";
                    arrStr[i] = chars.charAt((Math.abs(arrStr[i].hashCode() + hashSalt)) % 25) + "";
                    continue;
                }
                if (temp == 0) {
                    int hashTemp = Math.abs(arrStr[i].hashCode() + hashSalt);
                    arrStr[i] = fiName[hashTemp % (fiName.length - 1)];
                }
            }
            for (int i = 0; i < arrStr.length; i++) {
                newCun += arrStr[i];
            }
            if (!newStrSheng.equals("")) {
                newStrSheng += "省";
            }
            s = noChangeStartStr + newStrSheng + newStrShi + newStrXian + newStrQu + newCun;
        }
        if (isSuangYin == 1) {
            s = "\"" + s + "\"";
        }
        return s;
    }

}
