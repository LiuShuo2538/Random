package version3.Name;

import java.util.Arrays;
import java.util.List;

/**
 * 本方法为屏蔽方法个人客户保留姓名用*屏蔽
 * 公司客户保留地域商号用*屏蔽
 * 本方法不需要因子
 * Created by ${LiuShuo} on 2016/9/1.
 */
public class Name {
    public static Object getModelComName(Object value, Object key) {
        if (value == null || value.equals("null") || value.equals("")) return "";
        String str = value + "";
        str = str.replaceAll("\\s*", "");
        str = str.replaceAll("\\u3000", "");
        int isSuangYin = 0;// 0:\u6CA1\u6709\u53CC\u5F15\u53F7
        if (str.endsWith("\"") && str.startsWith("\"")) {
            str = str.substring(1, str.length() - 1);
            isSuangYin = 1;
        }
        if (str.length() < 2) return value;//\u4E00\u4E2A\u5B57\u4EC0\u4E48\u4E5F\u4E0D\u662F

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
        String[] noChange = {"财政", "黑龙江", "北京", "天津", "上海", "重庆", "河北", "山西", "辽宁", "吉林", "江苏", "浙江", "安徽", "福建", "江西", "河南", "湖北", "湖南", "广东", "海南", "四川", "贵州", "云南", "陕西", "甘肃", "青海", "台湾", "内蒙", "广西", "西藏", "宁夏", "新疆", "香港", "澳门", "中学", "磁", "厂", "经营部", "农资店", "青铜峡", "自治县", "内蒙古", "石嘴山", "加盟店", "蒙古族", "土特产", "副食品", "合作社", "清真寺", "互助社", "竹纤维", "批发部", "经销部", "电动车", "中学", "小学", "学校", "高中", "大学", "增补", "个人", "代发", "电声", "浙江", "针织", "童装", "旅游", "塑料", "回收", "宾馆", "装饰", "工资", "技校", "勘察", "地质", "保险", "物业", "安装", "实验", "纺织", "景观", "超市", "宾馆", "商城", "电视", "建设", "宁夏", "核算", "汽车", "流通", "木业", "餐饮", "家私", "农民", "酒店", "水果", "化工", "支行", "银川", "维修", "交通", "发展", "银行", "器材", "市场", "实业", "机械", "工贸", "二手", "批发", "食堂", "车行", "集中", "机电", "宿舍", "小额", "大街", "电器", "制造", "固原", "工程", "专业", "幼儿", "农场", "集团", "综合", "社区", "科技", "瓜果", "清真", "码头", "园区", "休闲", "粮油", "商行", "管理", "股份", "商业", "文化", "传播", "中卫", "广播", "酒楼", "单元", "中心", "印刷", "开发", "防水", "吴忠", "电子", "资金", "大修", "责任", "建材", "幕墙", "印务", "医疗", "嘉兴", "农村", "有限", "物资", "器械", "珠宝", "电力", "资产", "贷款", "苗木", "办公", "服装", "服务", "花园", "村级", "种植", "公司", "行政", "咨询", "养殖", "保洁", "小区", "设备", "天窗", "街道", "园林", "公路", "节能", "销售", "贸易", "商贸", "连锁", "胶粘", "制品", "路桥", "矿业", "南寺", "工业", "陶瓷", "农业", "果蔬"

        };
        String[] noChange1 = {"工", "业", "局", "种", "大", "附", "北", "站", "左", "屯", "坊", "巷", "城", "省", "厂", "四", "乡", "九", "院", "路", "县", "区", "园", "室", "镇", "面", "桥", "堍", "层", "内", "幢", "洲", "州", "厦", "家", "楼", "南", "侧", "店", "前", "部", "弄", "旁", "组", "庄", "浜", "十", "户", "中", "社", "荡", "八", "市", "队", "六", "栋", "后", "五", "东", "号", "村", "右", "第", "苑", "三", "西", "座", "环", "寺", "一", "七", "二", "口", "委", "道", "F", "~", "！", "@", "#", "￥", "%", "…", "^", "……", "&", "*", "（", "）", "—", "—", "+", "}", "{", "：", "“", "》", "《", "？", "-", "(", ")"

        };
        String[] noChange2 = {"农垦", "水稻", "配肥", "联合", "商会", "财政", "家电", "投资", "富民", "田园", "五常", "乐山", "自贡", "泸州", "雅安", "宜宾", "资阳", "眉山", "贵港", "玉林", "北海", "漳州", "衡水", "廊坊", "承德", "温州", "宁波", "杭州", "台州", "嘉兴", "金华", "湖州", "绍兴", "舟山", "丽水", "衢州", "西安", "咸阳", "宝鸡", "汉中", "渭南", "安康", "榆林", "商洛", "延安", "铜川", "濮阳", "沧州", "唐山", "保定", "邯郸", "邢台", "漯河", "许昌", "鹤壁", "济源", "长沙", "邵阳", "常德", "衡阳", "株洲", "湘潭", "永州", "岳阳", "怀化", "郴州", "娄底", "益阳", "厦门", "泉州", "福州", "莆田", "宁德", "三明", "南平", "龙岩", "南宁", "周口", "商丘", "开封", "焦作", "曲靖", "保山", "玉溪", "昭通", "巴中", "遂宁", "内江", "柳州", "桂林", "梧州", "钦州", "来宾", "河池", "百色", "贺州", "崇左", "芜湖", "合肥", "六安", "宿州", "阜阳", "安庆", "三亚", "海口", "琼海", "文昌", "东方", "成都", "绵阳", "广元", "达州", "南充", "德阳", "广安", "齐齐", "哈尔", "蚌埠", "淮北", "淮南", "宣城", "黄山", "铜陵", "亳州", "池州", "巢湖", "滁州", "南昌", "赣州", "上饶", "吉安", "九江", "新余", "抚州", "宜春", "黄冈", "孝感", "十堰", "咸宁", "黄石", "仙桃", "天门", "随州", "荆门", "潜江", "鄂州", "太原", "大同", "运城", "长治", "晋城", "忻州", "临汾", "吕梁", "晋中", "阳泉", "朔州", "大连", "沈阳", "丹东", "辽阳", "大庆", "锦州", "朝阳", "营口", "鞍山", "抚顺", "阜新", "盘锦", "本溪", "萍乡", "鹰潭", "武汉", "宜昌", "襄樊", "荆州", "铁岭", "台北", "高雄", "台中", "新竹", "基隆", "台南", "嘉义", "南通", "常州", "镇江", "扬州", "淮安", "泰州", "宿迁", "郑州", "南阳", "新乡", "安阳", "洛阳", "信阳", "鸡西", "黑河", "绥化", "鹤岗", "伊春", "贵阳", "遵义", "安顺", "兰州", "天水", "庆阳", "武威", "酒泉", "张掖", "白银", "平凉", "金昌", "吉林", "长春", "白山", "白城", "松原", "辽源", "通化", "四平", "银川", "吴忠", "中卫", "固原", "阳江", "梅州", "云浮", "茂名", "汕尾", "济南", "青岛", "临沂", "济宁", "菏泽", "烟台", "淄博", "泰安", "潍坊", "日照", "威海", "滨州", "东营", "聊城", "德州", "莱芜", "枣庄", "苏州", "徐州", "盐城", "无锡", "南京", "东莞", "广州", "中山", "深圳", "惠州", "江门", "珠海", "汕头", "佛山", "湛江", "河源", "肇庆", "清远", "潮州", "韶关", "揭阳", "财富", "担保", "北京", "天津", "上海", "重庆", "河北", "山西", "辽宁", "吉林", "江苏", "浙江", "安徽", "福建", "江西", "河南", "湖北", "湖南", "广东", "海南", "四川", "贵州", "云南", "陕西", "甘肃", "青海", "台湾", "内蒙", "广西", "西藏", "宁夏", "新疆", "香港", "澳门", "中学", "小学", "学校", "高中", "大学", "增补", "个人", "代发", "电声", "浙江", "针织", "童装", "旅游", "塑料", "回收", "宾馆", "装饰", "工资", "技校", "勘察", "地质", "保险", "物业", "安装", "实验", "纺织", "景观", "超市", "宾馆", "商城", "电视", "建设", "宁夏", "核算", "汽车", "流通", "木业", "餐饮", "家私", "农民", "酒店", "水果", "化工", "支行", "银川", "维修", "交通", "发展", "银行", "器材", "市场", "实业", "机械", "工贸", "二手", "批发", "食堂", "车行", "集中", "机电", "宿舍", "小额", "大街", "电器", "制造", "固原", "工程", "专业", "幼儿", "农场", "集团", "综合", "社区", "科技", "瓜果", "清真", "码头", "园区", "休闲", "粮油", "商行", "管理", "股份", "商业", "文化", "传播", "中卫", "广播", "酒楼", "单元", "中心", "印刷", "开发", "防水", "吴忠", "电子", "资金", "大修", "责任", "建材", "幕墙", "印务", "医疗", "嘉兴", "农村", "有限", "物资", "器械", "珠宝", "电力", "资产", "贷款", "苗木", "办公", "服装", "服务", "花园", "村级", "种植", "公司", "行政", "咨询", "养殖", "保洁", "小区", "设备", "天窗", "街道", "园林", "公路", "节能", "销售", "贸易", "商贸", "连锁", "胶粘", "制品", "路桥", "矿业", "南寺", "工业", "陶瓷", "农业", "果蔬"

        };
        String[] noChange3 = {"平顶山", "驻马店", "三门峡", "石家庄", "河北区", "秦皇岛", "张家口", "马鞍山", "葫芦岛", "哈尔滨", "佳木斯", "双鸭山", "牡丹江", "配肥站", "黑龙江", "经营部", "农资店", "青铜峡", "自治县", "内蒙古", "石嘴山", "连云港", "加盟店", "蒙古族", "延边州", "石嘴山", "甘南州", "土特产", "副食品", "合作社", "清真寺", "互助社", "竹纤维", "批发部", "经销部", "电动车"};


        String s = "";
        boolean isTwoName = false;
        boolean isOneName = false;
        boolean isCompany = false;
        String stars = "*";
        if (str.length() < 5) {
            for (int i = 0; i < fuxing.length; i++) {
                if (str.startsWith(fuxing[i])) {
                    isTwoName = true;
                    break;
                }
            }
            if (isTwoName == false) {
                isOneName = true;
            }
        } else {
            for (int i = 0; i < noChange.length; i++) {
                if (str.contains(noChange[i]) && str.length() > 3) {
                    isCompany = true;
                    break;
                }else {
                    if (isSuangYin == 1) {
                        s = "\"中国**\"";
                    }
                    return s;
                }
            }
        }
//-------------------------------------------
        String[] nameArray = new String[str.length()];
        if (isOneName || isTwoName) {
            if (isOneName) {
                for (int i = 0; i < str.length(); i++) {
                    if (i == 0) {
                        nameArray[i] = str.substring(0, 1);
                    } else {
                        nameArray[i] = stars;
                    }
                }
            }
            if (isTwoName) {
                for (int i = 0; i < str.length(); i++) {
                    if (i == 0) {
                        nameArray[i] = str.substring(0, 1);
                        nameArray[i + 1] = str.substring(1, 2);
                        i++;
                    } else {
                        nameArray[i] = stars;
                    }
                }
            }
            for (int i = 0; i < nameArray.length; i++) {
                s += nameArray[i];
            }
        }
//----------------------------------------------------------
        if (isCompany == true) {
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
                } catch (ArrayIndexOutOfBoundsException e) {
                    i += 1;
                    continue;
                }
                for (int j = 0; j < noChange1.length; j++) {
                    if (arrStr[i].contains(noChange1[j])) {
                        temp = 1;
                        break;
                    }
                }
                if (temp == 0) {
                    arrStr[i] = stars;
                }
            }
            for (int i = 0; i < arrStr.length; i++) {
                s += arrStr[i];
            }
        }
        if (isSuangYin == 1) {
            s = "\"" + s + "\"";
        }
        return s;
    }
}