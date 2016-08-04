package ShanDong;

/**
 * 物理地址过滤算法
 * Created by ${LiuShuo} on 8/4/2016.
 * 山东--河北；日照--衡水
 */
public class AddressFilterAlgorithm {

    public static Object getModelAddress(Object value, Object key) throws Exception {
        if (value == null || value.equals("null") || value.equals("")) return "";
        String str = value + "";
        str = str.replace(" ", "");
        int isSuangYin = 0;
        if (str.endsWith("\"") && str.startsWith("\"")) {
            str = str.substring(1, str.length() - 1);
            isSuangYin = 1;
        }
        if (str.length() < 4) return value;
        String salt = key + "";
        String saltok = salt.replace(" ", "");
//盐值hash
        int hashSalt = 0;
        if (salt.length() < 1) {
//没有盐值
        } else {
            hashSalt = Math.abs(saltok.hashCode());
        }
//正则数字
        java.util.regex.Pattern pattern1 = java.util.regex.Pattern.compile("[0-9]");
        java.util.regex.Pattern pattern2 = java.util.regex.Pattern.compile("[a-eg-z]");
        java.util.regex.Pattern pattern3 = java.util.regex.Pattern.compile("[A-EG-Z]");
//村名
        String[] randomName = {"缈", "游", "温", "逸", "嵋", "瞻", "颜", "缺", "渊", "暖", "清", "觅", "观", "崧", "遥", "喻", "更", "喧", "曲", "崴", "曼", "罕", "曹", "崎", "腾", "湛", "石", "崇", "喜", "飞", "飘", "善", "知", "崖", "风", "矩", "道", "啸", "巡", "邦", "昭", "真", "巧", "映", "巨", "春", "美", "邵", "省", "昱", "羚", "溪", "昴", "羞", "昶", "眺", "昊", "源", "明", "昏", "昌", "群", "昂", "昆", "昙", "星", "易", "羿", "商", "州", "川", "羽", "昕", "昔", "景", "晨", "顺", "翁", "晤", "顶", "翎", "页", "唱", "翔", "唯", "满", "智", "唤", "晴", "都", "致", "晋", "至", "晃", "唐", "晟", "西", "臣", "晖", "翼", "晓", "自", "皆", "而", "皇", "袖", "耀", "馨", "山", "考", "皎", "袁", "皓", "耘", "哲", "枯", "品", "林", "哈", "屑", "哉", "枚", "果", "展", "枝", "极", "屋", "届", "耿", "首", "耽", "屏", "枇", "香", "枋", "居", "耶", "尼", "潭", "柳", "柱", "益", "盈", "咨", "查", "咱", "聚", "尧", "柯", "盛", "柔", "尘", "聪", "柒", "尚", "和", "目", "尖", "酒", "少", "柚", "柄", "直", "咖", "酋", "尊", "盼", "柏", "将", "封", "相", "肃", "峰", "周", "朽", "峻", "朱", "朴", "未", "末", "峡", "术", "肖", "本", "峪", "峨", "峭", "纱", "呈", "纳", "望", "纷", "纹", "纸", "肩", "纺", "纽", "朔", "员", "月", "有", "红", "朋", "服", "肴", "约", "级", "纪", "纯", "启", "板", "松", "结", "岳", "含", "统", "绘", "岸", "杰", "细", "行", "织", "组", "绅", "杭", "胜", "吴", "来", "绍", "绊", "终", "条", "岩", "名", "维", "同", "杜", "胥", "岗", "束", "后", "杞", "吉", "合", "金", "衷", "各", "绿", "釜", "材", "岛", "岚", "白", "采", "百", "李", "杏", "癸", "衫", "杉", "表", "君", "野", "量", "吕", "里", "重", "释", "绩", "向", "衣", "累", "乾", "埔", "计", "紫", "氛", "订", "训", "疾", "讯", "气", "索", "民", "素", "书", "城", "设", "访", "许", "习", "论", "彭", "九", "埴", "彬", "彩", "乘", "永", "彪", "彤", "乔", "彦", "乖", "培", "乐", "乓", "基", "乒", "义", "茉", "久", "茄", "茅", "疏", "彷", "彰", "茂", "范", "影", "茁", "主", "为", "弈", "江", "高", "串", "丰", "语", "荷", "临", "垂", "弘", "型", "汀", "荣", "丙", "丘", "证", "诀", "业", "汽", "识", "东", "评", "丞", "汾", "汴", "词", "弧", "世", "弦", "强", "垣", "诗", "诚", "池", "七", "万", "忆", "价", "必", "坚", "仲", "町", "仰", "沐", "甲", "任", "申", "沛", "田", "沙", "志", "沅", "沃", "坊", "沂", "沁", "均", "莫", "沈", "甜", "仕", "生", "忠", "甘", "仑", "甚", "仓", "河", "沼", "沽", "沾", "沿", "沸", "油", "念", "沧", "仁", "坪", "忽", "坤", "从", "坦", "坡", "沫", "亳", "泓", "菲", "征", "泗", "径", "法", "泛", "律", "徒", "徐", "产", "得", "亦", "圃", "享", "泊", "徙", "亩", "泉", "徘", "亨", "亮", "圆", "略", "亭", "徜", "京", "泰", "御", "留", "云", "场", "泳", "徨", "地", "驰", "亚", "圳", "泽", "波", "泥", "圭", "界", "德", "马", "争", "注", "圣", "事", "畅", "于", "般", "斗", "航", "佩", "洋", "料", "文", "使", "船", "洛", "舷", "舶", "洗", "回", "佳", "住", "舍", "幼", "幽", "位", "洪", "新", "因", "幸", "并", "年", "津", "施", "璋", "平", "方", "斧", "派", "洽", "舟", "佛", "余", "图", "洵", "何", "国", "誉", "洲", "固", "斩", "佑", "舒", "佐", "帛", "帝", "良", "济", "瓦", "伯", "传", "流", "米", "浅", "伦", "伧", "浙", "师", "浚", "伺", "旅", "希", "艾", "旋", "布", "市", "帅", "伴", "族", "帆", "浪", "伊", "常", "浩", "时", "旷", "伏", "伍", "旺", "浣", "企", "浦", "既", "伟", "旦", "席", "日", "早", "旨", "海", "众", "旭", "涅", "信", "琪", "芯", "芮", "芭", "俯", "芬", "修", "琦", "芫", "琢", "芷", "芳", "俱", "涓", "花", "芽", "攀", "廉", "芸", "涛", "芹", "粗", "政", "润", "延", "放", "粒", "琉", "节", "芍", "俏", "理", "收", "俊", "建", "芊", "俗", "芒", "俐", "俞", "芝", "保", "言", "芙", "粉", "嘉", "若", "庚", "府", "侯", "敖", "效", "英", "瑾", "庆", "敏", "淘", "床", "苹", "故", "便", "淡", "康", "庶", "庸", "庾", "侍", "苑", "苓", "深", "苔", "度", "瑞", "座", "苗", "庭", "依", "央", "冶", "天", "鑫", "冰", "太", "冲", "冬", "珍", "珏", "珈", "珊", "珀", "冠", "拳", "备", "路", "军", "拉", "夏", "复", "冒", "拂", "多", "拓", "珠", "越", "笃", "奢", "出", "奥", "函", "凰", "超", "玖", "笑", "玉", "凯", "笙", "抱", "凡", "笛", "玄", "好", "率", "玻", "奂", "笠", "奇", "奋", "玫", "凌", "奔", "奕", "净", "准", "资", "执", "铭", "扬", "鱼", "银", "承", "赤", "扇", "才", "如", "铁", "妙", "共", "姬", "兵", "其", "具", "典", "钦", "兼", "姿", "全", "六", "贝", "贡", "财", "贤", "成", "贵", "兆", "钟", "克", "光", "先", "钗", "武", "步", "正", "长", "堡", "傲", "歌", "镜", "穹", "空", "镇", "堆", "堂", "欢", "欣", "次", "欧", "犁", "锦", "程", "锐", "萧", "锋", "竟", "捷", "毫", "站", "闻", "倩", "闲", "蓝", "问", "豆", "门", "立", "闪", "值", "竿", "牧", "竹", "牡", "竺", "倍", "毅", "物", "章", "豪", "豫", "倚", "境", "健", "壮", "振", "壤", "偃", "殊", "谷", "挚", "谦", "桓", "厚", "桑", "迪", "桐", "际", "原", "祥", "桔", "蝶", "桂", "桃", "祺", "迁", "迅", "进", "祖", "桦", "远", "运", "神", "祟", "栗", "悉", "树", "阔", "标", "悟", "字", "达", "社", "孟", "孝", "参", "辰", "栋", "熙", "阡", "辉", "季", "栽", "格", "叶", "悠", "台", "召", "叮", "可", "孰", "校", "阳", "熊", "麦", "古", "栩", "宋", "守", "秩", "安", "积", "宏", "北", "雀", "雁", "轩", "匙", "宁", "秦", "宇", "棕", "棋", "宛", "恒", "定", "宙", "照", "实", "宝", "宜", "轻", "宗", "鹏", "雪", "秉", "雨", "宫", "秋", "秀", "恩", "客", "宣", "煜", "鹿", "恭", "息", "容", "恰", "鹤", "科", "棠", "家", "南", "卓", "隆", "寂", "博", "梓", "升", "禾", "千", "十", "禹", "华", "梅", "思", "寒", "梁", "卉", "福", "卷", "印", "怡", "梵", "卿", "鸽", "卸", "梳", "梭", "梯", "融", "卦", "鸣", "梨", "寺", "梧", "卫", "烨", "青", "靖", "威", "娄", "功", "虹", "努", "烈", "娱", "懿", "硕", "加", "务", "虎", "虔", "硅", "革", "劲", "励", "炬", "霖", "炯", "勉", "炫", "勋", "霜", "勇", "霄", "龙", "炎", "婷", "研", "勤", "齐", "列", "慈", "则", "刚", "创", "初", "慎", "灿", "蛋", "别", "利", "音", "韵", "韶", "磊", "韬", "制", "韦", "前", "鼎", "意", "瀚"};
//省
        String[] provinces = {"吉林", "广东", "山东", "河南", "河北", "四川"};
//省下面的市
        String[] jilin = {"吉林市", "长春市", "白山市", "延边州", "白城市", "松原市", "辽源市", "通化市", "四平市"};
        String[] guangdong = {"东莞市", "广州市", "深圳市", "惠州市", "江门市", "珠海市", "汕头市", "佛山市", "湛江市", "河源市", "肇庆市", "清远市", "潮州市", "韶关市", "揭阳市", "阳江市", "梅州市", "云浮市", "茂名市", "汕尾市"};
        String[] shandong = {"济南市", "青岛市", "临沂市", "济宁市", "菏泽市", "烟台市", "淄博市", "泰安市", "潍坊市", "日照市", "威海市", "滨州市", "东营市", "聊城市", "德州市", "莱芜市", "枣庄市"};
        String[] henan = {"郑州市", "南阳市", "新乡市", "安阳市", "洛阳市", "信阳市", "平顶山市", "周口市", "商丘市", "开封市", "焦作市", "驻马店市", "濮阳市", "三门峡市", "漯河市", "许昌市", "鹤壁市"};
        String[] hebei = {"石家庄市", "唐山市", "保定市", "邯郸市", "邢台市", "沧州市", "秦皇岛市", "张家口市", "衡水市", "廊坊市", "承德市"};
        String[] sichuan = {"成都市", "绵阳市", "广元市", "达州市", "南充市", "德阳市", "广安市", "阿坝州", "巴中市", "遂宁市", "内江市", "凉山州", "攀枝花市", "自贡市", "泸州市", "雅安市", "宜宾市", "资阳市", "眉山市", "甘孜州"};
//没用上
        String[][] shi = {jilin, guangdong, shandong, henan, hebei, sichuan};

//市下面的区和县
        String[] beijing = {"朝阳区", "海淀区", "通州区", "房山区", "丰台区", "昌平区", "大兴区", "顺义区", "西城区", "延庆县", "石景山区", "宣武区", "怀柔区", "崇文区", "密云县", "东城区", "平谷区", "门头沟区"};
//吉林
        String[] changchun = {"南关区", "宽城区", "朝阳区", "二道区", "绿园区", "双阳区", "九台区", "榆树市", "德惠市", "农安县"};
        String[] jilins = {"船营区", "龙潭区", "昌邑区", "丰满区", "永吉县", "磐石市", "桦甸市", "蛟河市", "舒兰市"};
        String[] baishan = {"长白朝鲜族自治县", "抚松县", "靖宇县", "临江市", "浑江区"};
        String[] yanbian = {"延吉市", "图们市", "龙井市", "和龙市", "汪清县", "安图县"};
        String[] baicheng = {"大安市", "洮北区", "洮南区", "通榆县", "镇赉县"};
        String[] songyuan = {"扶余县", "宁江区", "前郭尔罗斯蒙古族自治县", "乾安县", "长岭县"};
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
        String[] qingyuan = {"清城区", "清新区", "佛冈县", "阳山县", "连南瑶族自治县", "连山壮族瑶族自治县", "英德市", "连州市"};
        String[] chaozhou = {"湘桥区", "潮安区", "枫溪区", "饶平县"};
        String[] meizhou = {"兴宁市", "梅江区", "梅县区", "大埔县", "丰顺县", "五华县", "平远县", "蕉岭县"};
        String[] shaoguan = {"浈江区", "武江区", "曲江区", "乐昌市", "南雄市", "始兴县", "仁化县", "翁源县", "新丰县", "乳源瑶族自治县"};
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
        String[] yantai = {"烟台高新技术产业开发区", "烟台经济技术开发区", "芝罘区", "福山区", "牟平区", "莱山区", "长岛县", "龙口市", "莱阳市", "莱州市", "蓬莱市", "招远市", "栖霞市", "海阳市"};
        String[] zibo = {"张店区", "淄川区", "博山区", "周村区", "临淄区", "桓台县", "高青县", "沂源县"};
        String[] taian = {"泰山区", "岱岳区", "新泰市", "肥城市", "宁阳县", "东平县"};
        String[] weifang = {"潍城区", "奎文区", "坊子区", "寒亭区", "青州市", "诸城市", "寿光市", "安丘市", "高密市", "昌邑市", "昌乐县", "临朐县"};
        String[] rizhao = {"东港区", "岚山区", "莒县", "五莲县", "日照经济技术开发区", "山海天旅游度假区", "日照高新技术产业开发区", "日照国际海洋城"};
        String[] weihai = {"地级威海市包括环翠区", "文登区", "经济技术开发区", "火炬高技术产业开发区", "进出口加工保税区", "临港经济技术开发区", "南海新区", "荣成市", "乳山市"};
        String[] bingzhou = {"滨城区", "沾化区", "邹平县", "博兴县", "惠民县", "阳信县", "无棣县"};
        String[] dongying = {"东营区", "河口区", "广饶县", "垦利县", "利津县"};
        String[] liaocheng = {"东昌府区", "开发区", "临清市", "茌平", "东阿", "高唐", "阳谷", "冠县", "莘县", "莱州市", "蓬莱市", "招远市", "栖霞市", "海阳市"};
        String[] dezhou = {"德州市辖德城区", "陵城区", "禹城市", "乐陵市", "临邑县", "平原县", "夏津县", "武城县", "庆云县", "宁津县", "齐河县"};
        String[] laiwu = {"莱城区", "钢城区"};
        String[] zaozhuang = {"薛城区", "市中区", "峄城区", "山亭区", "台儿庄区", "滕州市"};
//河南
        String[] zhengzhou = {"中原区", "二七区", "管城回族区", "金水区", "上街区", "惠济区", "中牟县", "巩义市", "荥阳市", "新密市", "新郑市", "登封市"};
        String[] nanyang = {"宛城区", "卧龙区", "南召县", "镇平县", "内乡县", "淅川县", "新野县", "唐河县", "桐柏县", "方城县", "西峡县", "社旗县"};
        String[] xinxiang = {"平原示范区", "卫滨区", "红旗区", "凤泉区", "牧野区", "卫辉市", "辉县市", "新乡县", "获嘉县", "原阳县", "延津县", "封丘县"};
        String[] anyang = {"文峰区", "北关区", "殷都区", "龙安区", "安阳县", "汤阴县", "内黄县", "林州市"};
        String[] luoyang = {"涧西区", "西工区", "老城区", "瀍河回族区", "洛龙区", "吉利区", "偃师市", "孟津县", "新安县", "宜阳县", "伊川县", "洛宁县", "嵩县", "栾川县", "汝阳县"};
        String[] xinyang = {"浉河区", "平桥区", "息县", "新县", "罗山县", "潢川县", "光山县", "商城县", "固始县", "淮滨县"};
        String[] pingdingshan = {"辖新华区", "卫东区", "湛河区", "石龙区", "舞钢市", "叶县", "鲁山", "宝丰", "郏县"};
        String[] zhoukou = {"川汇区", "扶沟县", "西华县", "商水县", "沈丘县", "郸城县", "淮阳县", "太康县", "鹿邑县", "项城市"};
        String[] shangqiu = {"永城市", "睢阳区", "梁园区", "商丘新区", "虞城县", "柘城县", "夏邑县", "民权县", "睢县", "宁陵县"};
        String[] kaifeng = {"鼓楼区", "龙亭区", "禹王台区", "顺河回族区", "祥符区和尉氏县", "兰考县", "杞县", "通许县"};
        String[] jiaozuo = {"解放区", "中站区", "马村区", "山阳区", "修武县", "博爱县", "武陟县", "温县", "沁阳市", "孟州市"};
        String[] zhumadian = {"驿城区", "确山县", "泌阳县", "遂平县", "西平县", "上蔡县", "汝南县", "平舆县", "正阳县", "经济开发区", "工业集聚区", "装备产业集聚区"};
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
        String[] cangzhou = {"运河区", "新华区", "泊头市", "任丘市", "黄骅市", "河间市", "沧县", "青县", "东光县", "海兴县", "盐山县", "肃宁县", "南皮县", "吴桥县", "献县", "孟村回族自治县"};
        String[] qinhuangdao = {"海港区", "山海关区", "抚宁区", "北戴河区", "青龙县", "昌黎县", "卢龙县"};
        String[] zhangjiakou = {"桥西区", "桥东区", "下花园区", "宣化区", "万全区", "崇礼区", "张北县", "康保县", "沽源县", "尚义县", "蔚县", "阳原县", "怀安县", "怀来县", "涿鹿县", "赤城县"};
        String[] hengshui = {"桃城区", "滨湖新区", "工业新区", "冀州", "深州", "枣强县", "武邑县", "武强县", "饶阳县", "安平县", "故城县", "阜城县", "景县"};
        String[] langfang = {"三河市", "霸州市", "香河县", "固安县", "永清县", "文安县", "大城县", "大厂回族自治县"};
        String[] chengde = {"承德县", "隆化县", "围场县", "丰宁县", "滦平县", "兴隆县", "青龙县", "平泉县"};
//四川
        String[] chengdu = {"武侯区", "锦江区", "青羊区", "金牛区", "成华区", "龙泉驿区", "温江区", "新都区", "青白江区", "双流区", "郫县", "蒲江县", "大邑县", "金堂县", "新津县", "都江堰市", "彭州市", "邛崃市", "崇州市", "简阳市"};
        String[] mianyang = {"涪城区", "游仙区", "安州区", "三台县", "盐亭县", "梓潼县", "平武县", "北川羌族自治县", "江油市"};
        String[] guangyuan = {"利州区", "昭化区", "朝天区", "旺苍县", "青川县", "剑阁县", "苍溪县"};
        String[] dazhou = {"通川区", "达川区", "宣汉县", "开江县", "大竹县", "渠县", "万源市"};
        String[] nanyun = {"顺庆区", "高坪区", "嘉陵区", "西充县", "南部县", "蓬安县", "营山县", "仪陇县", "阆中市"};
        String[] deyang = {"旌阳区", "什邡市", "广汉市", "绵竹市", "罗江县", "中江县"};
        String[] guangan = {"广安区", "前锋区", "岳池县", "武胜县", "邻水县", "华蓥市"};
        String[] aba = {"马尔康市", "九寨沟县", "小金县", "阿坝县", "若尔盖县", "红原县", "壤塘县", "汶川县", "理县", "茂县", "松潘县", "金川县", "黑水县"};
        String[] bazhong = {"巴州区", "恩阳区", "通江县", "南江县", "平昌县"};
        String[] suining = {"船山区", "安居区", "射洪县", "蓬溪县", "大英县"};
        String[] neijiang = {"市中区", "东兴区", "资中县", "威远县", "隆昌县"};
        String[] liangshan = {"西昌市", "盐源县", "德昌县", "会理县", "会东县", "宁南县", "普格县", "布拖县", "金阳县", "昭觉县", "喜德县", "冕宁县", "越西县", "甘洛县", "美姑县", "雷波县", "木里藏族自治县"};
        String[] panzhihua = {"东区", "西区", "仁和区", "米易县", "盐边县"};
        String[] zigong = {"自流井区", "贡井区", "大安区", "沿滩区", "荣县", "富顺县"};
        String[] luzhou = {"江阳区", "龙马潭区", "纳溪区", "纳溪区", "泸县", "合江县", "叙永县", "古蔺县"};
        String[] yaan = {"雨城区", "名山区", "县荥经县", "汉源县", "石棉县", "天全县", "芦山县", "宝兴县"};
        ;
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

//不做清洗的字符串
        String[] change2 = {"山东","日照"};//山东--河北；日照--衡水

        String[] noChange1 = {"古", "江", "街", "款", "初", "班", "饭", "期", "分", "大", "附", "北", "站", "左", "屯", "坊", "巷", "城", "省", "厂", "四", "乡", "九", "院", "路", "县", "区", "园", "室", "镇", "面", "桥", "堍", "层", "内", "幢", "洲", "州", "厦", "家", "楼", "南", "侧", "店", "前", "部", "弄", "旁", "组", "庄", "浜", "十", "户", "中", "社", "荡", "八", "市", "队", "六", "栋", "后", "五", "东", "号", "村", "右", "第", "苑", "三", "西", "小", "座", "环", "寺", "一", "七", "二", "口", "委", "道", "F", "~", "！", "@", "#", "￥", "%", "…", "^", "……", "&", "*", "（", "）", "—", "—", "+", "}", "{", "：", "“", "》", "《", "？", "-", "(", ")", ".", "、", ","

        };
        String[] noChange2 = {"河北", "衡水","中学", "小学", "学校", "高中", "大学", "增补", "个人", "代发", "电声", "浙江", "针织", "童装", "旅游", "塑料", "回收", "宾馆", "装饰", "工资", "技校", "勘察", "地质", "保险", "物业", "安装", "实验", "纺织", "景观", "超市", "宾馆", "商城", "电视", "建设", "宁夏", "核算", "汽车", "流通", "木业", "餐饮", "家私", "农民", "酒店", "水果", "化工", "支行", "银川", "维修", "交通", "发展", "银行", "器材", "市场", "实业", "机械", "工贸", "二手", "批发", "食堂", "车行", "集中", "机电", "宿舍", "小额", "大街", "电器", "制造", "固原", "工程", "专业", "幼儿", "农场", "集团", "综合", "社区", "科技", "瓜果", "清真", "码头", "园区", "休闲", "粮油", "商行", "管理", "股份", "商业", "文化", "传播", "中卫", "广播", "酒楼", "单元", "中心", "印刷", "开发", "防水", "吴忠", "电子", "资金", "大修", "责任", "建材", "幕墙", "印务", "医疗", "嘉兴", "农村", "有限", "物资", "器械", "珠宝", "电力", "资产", "贷款", "苗木", "办公", "服装", "服务", "花园", "村级", "种植", "公司", "行政", "咨询", "养殖", "保洁", "小区", "设备", "天窗", "街道", "园林", "公路", "节能", "销售", "贸易", "商贸", "连锁", "胶粘", "制品", "路桥", "矿业", "南寺", "工业", "陶瓷", "农业", "果蔬"

        };
//留着以后有可能出现3个字的判断
//        String[] noChange3 = {
//        };

//没有”省“字导致清洗结果失真
        String[] chengeSheng = {"北京", "天津", "上海", "重庆", "河北", "山西", "辽宁", "吉林", "黑龙", "江苏", "浙江", "安徽", "福建", "江西", "河南", "湖北", "湖南", "广东", "海南", "四川", "贵州", "云南", "陕西", "甘肃", "青海", "台湾", "内蒙", "广西", "西藏", "宁夏", "新疆", "香港", "澳门"};


        String newStrSheng = "";
        String newStrShi = "";
        String newStrXian = "";
        String newStrQu = "";
        String newCun = "";

//默认hash是盐
        int hash1 = hashSalt;
//type= :1 只有省没有市 2 有省有市 3 没省有市
        int type = 0;
//获取省
        if (str.contains("省")) {
            String[] arrStr1 = str.split("省");
            if (arrStr1.length < 2) return value;
            hash1 = Math.abs(arrStr1[0].hashCode() + hashSalt);
            if (arrStr1[0].equals("山东")) {
                newStrSheng = "河北";
            } else {
                newStrSheng = provinces[hash1 % (provinces.length - 1)];
            }
            str = arrStr1[1];
            type = 1;
        }
//获取市
        if (str.contains("市")) {
            String[] arrStr1 = str.split("市");
            if (arrStr1.length < 2) return value;
            hash1 = Math.abs(arrStr1[0].hashCode() + hashSalt);
            if (type == 1) {
                if (arrStr1[0].equals("日照")) {
                    newStrShi = "衡水市";
                } else {
                    newStrShi = ((String[]) shengTOshi.get(newStrSheng))[hash1 % (((String[]) shengTOshi.get(newStrSheng)).length - 1)];
                }
                type = 2;
            } else {
                String[] arryTemp = shi[hash1 % (shi.length - 1)];
                if (arrStr1[0].equals("山东日照")){
                    newStrSheng = "河北";
                    newStrShi = "衡水市";
                }else if (arrStr1[0].equals("日照")) {
                    newStrShi = "衡水市";
                } else {
                    newStrShi = arryTemp[hash1 % (arryTemp.length - 1)];
                }
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
                try {
                    String[] arrStr1xiaoqu = str.split("小区");
                    String tem = "";
                    if (arrStr1xiaoqu[0].contains("区")) {
                        String[] arrStr1 = str.split("区");
                        tem = arrStr1[1];
                        if (arrStr1.length < 2) return value;
                        hash1 = Math.abs(arrStr1[0].hashCode() + hashSalt);

                        if (type == 0) {
                            newStrShi = ((String[]) shengTOshi.get(provinces[hash1 % provinces.length]))[hash1 % (((String[]) shengTOshi.get(provinces[hash1 % provinces.length])).length - 1)];
                            newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                            newStrShi = "";
                            if (arrStr1[0].contains("山东")){
                                newStrSheng = "河北";
                            }
                            if (arrStr1[0].contains("日照")){
                                newStrShi = "衡水";
                            }

                        }
                        if (type == 1) {
                            newStrShi = ((String[]) shengTOshi.get(newStrSheng))[hash1 % (((String[]) shengTOshi.get(newStrSheng)).length - 1)];
                            newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                            newStrShi = "";
                            if (arrStr1[0].contains("山东")){
                                newStrSheng = "河北";
                            }
                            if (arrStr1[0].contains("日照")){
                                newStrShi = "衡水";
                            }
                        }
                        if (type == 2) {
                            newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                        }
                        if (type == 3) {
                            newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                        }

                    }else {
                        if (arrStr1xiaoqu[0].contains("山东日照")){
                            tem = arrStr1xiaoqu[0].replace("山东日照","河北衡水");
                        }else if (arrStr1xiaoqu[0].contains("山东")){
                            tem =  arrStr1xiaoqu[0].replace("山东","河北");
                        }else if (arrStr1xiaoqu[0].contains("日照")){
                            tem =  arrStr1xiaoqu[0].replace("日照","衡水");
                        }

                    }
                    if (arrStr1xiaoqu.length >= 2) {
                        str = tem + "小区" + arrStr1xiaoqu[1];
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    return value;
                }
            } else {
                try {
                    String[] arrStr1 = str.split("区");
                    hash1 = Math.abs(arrStr1[0].hashCode() + hashSalt);
                    if (type == 0) {
                        newStrShi = ((String[]) shengTOshi.get(provinces[hash1 % provinces.length]))[hash1 % (((String[]) shengTOshi.get(provinces[hash1 % provinces.length])).length - 1)];
                        newStrQu = ((String[]) shiTOqu.get(newStrShi))[hash1 % (((String[]) shiTOqu.get(newStrShi)).length - 1)];
                        newStrShi = "";
                        if (arrStr1[0].contains("山东")){
                           newStrSheng = "河北";
                        }
                        if (arrStr1[0].contains("日照")){
                            newStrShi = "衡水";
                        }

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
//            try {
//                for (int j = 0; j < noChange3.length; j++) {
//                    if (arrStr[i].contains(noChange3[j].substring(0,1)) && arrStr[i + 1].contains(noChange3[j].substring(1,2)) && arrStr[i + 2].contains(noChange3[j].substring(2,3))){
//                        i+=2;
//                        temp = 1;
//                        break;
//                    }
//                }
//            }catch (ArrayIndexOutOfBoundsException e){
//                i+=2;
//                continue;
//            }

            try {

                for (int j = 0; j < change2.length; j++) {
                    if (arrStr[i].contains(change2[j].substring(0, 1)) && arrStr[i + 1].contains(change2[j].substring(1, 2))) {
                        if (arrStr[i].equals("山")) {
                            arrStr[i] = "河";
                            arrStr[i + 1] = "北";
                        }
                        if (arrStr[i].equals("日")) {
                            arrStr[i] = "衡";
                            arrStr[i + 1] = "水";
                        }
                        i += 1;
                        temp = 1;
                        break;
                    }
                }

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
                arrStr[i] = randomName[hashTemp % (randomName.length - 1)];
            }
        }

        for (int i = 0; i < arrStr.length; i++) {
            newCun += arrStr[i];
        }
        if ((value+"").contains("省")) {
            newStrSheng += "省";
        }
        String s = newStrSheng + newStrShi + newStrXian + newStrQu + newCun;

        if (isSuangYin == 1) {
            s = "\"" + s + "\"";
        }
        String vLenth = value + "";
        s = new String(s.getBytes("GBK"), "GBK");

        if (s.length() > vLenth.length()) {
            s = s.substring(0, vLenth.length());
        }

        return s;
    }


}

