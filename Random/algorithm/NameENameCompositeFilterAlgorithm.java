package com.wiseweb.algorithm;

/**
 * 个人公司混合名过滤算法
 * Created by zhengbing on 2016/6/21.
 * 08/16丰富词库
 */
public class NameENameCompositeFilterAlgorithm {

    public static Object getModelComName(Object value , Object key) throws Exception{

        if (value==null||value.equals("null")||value.equals("")) return "";
        String str = value+"";
        str = str.replaceAll("\\s*", "");
        str = str.replaceAll("\\u3000", "");
        int isSuangYin = 0;
        if (str.endsWith("\"")&&str.startsWith("\"")){
            str = str.substring(1, str.length() - 1);
            isSuangYin = 1;
        }
        if (str.length()<2)return value;
        String salt = key + "";
        String saltok = salt.replaceAll("\\s*", "");
        int hashSalt = 0;
        if (salt==null||salt.equals("null")||salt.equals("")){
        }else {
            hashSalt=Math.abs(saltok.hashCode());
        }

        if(str.contains("·")&& str.replace(" ", "").length()<3){
            return value;
        }

//\u590D\u59D3\u7684\u6570\u7EC4
        String[] contain = {"\u4E07\u4FDF", "\u53F8\u9A6C", "\u4E0A\u5B98", "\u6B27\u9633", "\u590F\u4FAF", "\u8BF8\u845B", "\u95FB\u4EBA", "\u4E1C\u65B9", "\u8D6B\u8FDE", "\u7687\u752B", "\u7F8A\u820C", "\u5C09\u8FDF", "\u516C\u7F8A", "\u6FB9\u53F0", "\u516C\u51B6", "\u5B97\u6B63",
                "\u6FEE\u9633", "\u6DF3\u4E8E", "\u5355\u4E8E", "\u592A\u53D4", "\u7533\u5C60", "\u516C\u5B59", "\u4EF2\u5B59", "\u8F69\u8F95", "\u4EE4\u72D0", "\u949F\u79BB", "\u5B87\u6587", "\u957F\u5B59", "\u6155\u5BB9", "\u9C9C\u4E8E", "\u95FE\u4E18", "\u53F8\u5F92", "\u53F8\u7A7A", "\u5140\u5B98", "\u53F8\u5BC7",
                "\u5357\u95E8", "\u547C\u5EF6", "\u5B50\u8F66", "\u989B\u5B59", "\u7AEF\u6728", "\u5DEB\u9A6C", "\u516C\u897F", "\u6F06\u96D5", "\u8F66\u6B63", "\u58E4\u9A77", "\u516C\u826F", "\u62D3\u8DCB", "\u5939\u8C37", "\u5BB0\u7236", "\u8C37\u6881", "\u6BB5\u5E72", "\u767E\u91CC", "\u4E1C\u90ED", "\u5FAE\u751F",
                "\u6881\u4E18", "\u5DE6\u4E18", "\u4E1C\u95E8", "\u897F\u95E8", "\u5357\u5BAB", "\u7B2C\u4E94", "\u516C\u4EEA", "\u516C\u4E58", "\u592A\u53F2", "\u4EF2\u957F", "\u53D4\u5B59", "\u5C48\u7A81", "\u5C14\u6731", "\u4E1C\u4E61", "\u76F8\u91CC", "\u80E1\u6BCD", "\u53F8\u57CE", "\u5F20\u5ED6", "\u96CD\u95E8",
                "\u6BCB\u4E18", "\u8D3A\u5170", "\u7DA6\u6BCB", "\u5C4B\u5E90", "\u72EC\u5B64", "\u5357\u90ED", "\u5317\u5BAB", "\u738B\u5B59"};
//598 \u767E\u5BB6\u59D3
        String[] laName= {"\u8D75","\u94B1","\u5B59","\u674E","\u5468","\u5434","\u90D1","\u738B","\u51AF","\u9648","\u848B","\u6C88","\u97E9","\u6768","\u6731","\u79E6","\u8BB8","\u4F55","\u5415","\u65BD","\u5F20","\u5B54","\u66F9","\u4E25","\u534E","\u91D1","\u9B4F","\u59DC","\u8C22","\u90B9","\u55BB","\u82CF","\u6F58","\u845B","\u8303","\u5F6D","\u9C81","\u97E6","\u9A6C","\u65B9","\u4EFB","\u8881","\u67F3","\u53F2","\u5510","\u8D39","\u859B","\u96F7","\u502A","\u6C64","\u7F57","\u5B89","\u5E38","\u4E50","\u4E8E","\u535E","\u9F50","\u4F0D","\u4F59","\u5143","\u987E","\u5B5F","\u5E73","\u9EC4","\u548C","\u7A46","\u8427","\u5C39","\u59DA","\u90B5","\u6C6A","\u6BDB","\u72C4","\u7C73","\u8D1D","\u660E","\u81E7","\u6210","\u6234","\u5B8B","\u8305","\u5E9E","\u718A","\u7EAA","\u8212","\u9879","\u795D","\u8463","\u6881","\u675C","\u962E","\u8D3E","\u6C5F","\u90ED","\u6797","\u949F","\u5F90","\u90B1","\u9AD8","\u590F","\u8521","\u7530","\u80E1","\u970D","\u5362","\u83AB","\u623F","\u7F2A","\u89E3","\u4E01","\u5BA3","\u9093","\u90C1","\u5355","\u676D","\u6D2A","\u5305","\u77F3","\u5D14","\u7A0B","\u9646","\u4E8E","\u66F2","\u5C01","\u7126","\u8C37","\u8F66","\u683E","\u7518","\u5218","\u53F6","\u5E78","\u53F8","\u767D","\u4E54","\u8C2D","\u7533","\u725B","\u5C1A","\u519C","\u6E29","\u5E84","\u67F4","\u960E","\u4E60","\u5411","\u53E4","\u5ED6","\u803F","\u6EE1","\u5DE9","\u66FE","\u5173","\u5CB3","\u695A","\u4F5F","\u9AD8","\u95E8"};

//\u540D\u5B57\u5E93
        String[] fiName= {"\u7F08","\u6E38","\u6E29","\u9038","\u5D4B","\u77BB","\u989C","\u7F3A","\u6E0A","\u6696","\u6E05","\u89C5","\u89C2","\u5D27","\u9065","\u55BB","\u66F4","\u55A7","\u66F2","\u5D34","\u66FC","\u7F55","\u66F9","\u5D0E","\u817E","\u6E5B","\u77F3","\u5D07","\u559C","\u98DE","\u98D8","\u5584","\u77E5",
                "\u5D16","\u98CE","\u77E9","\u9053","\u5578","\u5DE1","\u90A6","\u662D","\u771F","\u5DE7","\u6620","\u5DE8","\u6625","\u7F8E","\u90B5","\u7701","\u6631","\u7F9A","\u6EAA","\u6634","\u7F9E","\u6636","\u773A","\u660A","\u6E90","\u660E","\u660F","\u660C","\u7FA4","\u6602","\u6606","\u6619","\u661F",
                "\u6613","\u7FBF","\u5546","\u5DDE","\u5DDD","\u7FBD","\u6615","\u6614","\u666F","\u6668","\u987A","\u7FC1","\u6664","\u9876","\u7FCE","\u9875","\u5531","\u7FD4","\u552F","\u6EE1","\u667A","\u5524","\u6674","\u90FD","\u81F4","\u664B","\u81F3","\u6643","\u5510","\u665F","\u897F","\u81E3","\u6656",
                "\u7FFC","\u6653","\u81EA","\u7686","\u800C","\u7687","\u8896","\u8000","\u99A8","\u5C71","\u8003","\u768E","\u8881","\u7693","\u8018","\u54F2","\u67AF","\u54C1","\u6797","\u54C8","\u5C51","\u54C9","\u679A","\u679C","\u5C55","\u679D","\u6781","\u5C4B","\u5C4A","\u803F","\u9996","\u803D","\u5C4F",
                "\u6787","\u9999","\u678B","\u5C45","\u8036","\u5C3C","\u6F6D","\u67F3","\u67F1","\u76CA","\u76C8","\u54A8","\u67E5","\u54B1","\u805A","\u5C27","\u67EF","\u76DB","\u67D4","\u5C18","\u806A","\u67D2","\u5C1A","\u548C","\u76EE","\u5C16","\u9152","\u5C11","\u67DA","\u67C4","\u76F4","\u5496","\u914B",
                "\u5C0A","\u76FC","\u67CF","\u5C06","\u5C01","\u76F8","\u8083","\u5CF0","\u5468","\u673D","\u5CFB","\u6731","\u6734","\u672A","\u672B","\u5CE1","\u672F","\u8096","\u672C","\u5CEA","\u5CE8","\u5CED","\u7EB1","\u5448","\u7EB3","\u671B","\u7EB7","\u7EB9","\u7EB8","\u80A9","\u7EBA","\u7EBD","\u6714",
                "\u5458","\u6708","\u6709","\u7EA2","\u670B","\u670D","\u80B4","\u7EA6","\u7EA7","\u7EAA","\u7EAF","\u542F","\u677F","\u677E","\u7ED3","\u5CB3","\u542B","\u7EDF","\u7ED8","\u5CB8","\u6770","\u7EC6","\u884C","\u7EC7","\u7EC4","\u7EC5","\u676D","\u80DC","\u5434","\u6765","\u7ECD","\u7ECA","\u7EC8",
                "\u6761","\u5CA9","\u540D","\u7EF4","\u540C","\u675C","\u80E5","\u5C97","\u675F","\u540E","\u675E","\u5409","\u5408","\u91D1","\u8877","\u5404","\u7EFF","\u91DC","\u6750","\u5C9B","\u5C9A","\u767D","\u91C7","\u767E","\u674E","\u674F","\u7678","\u886B","\u6749","\u8868","\u541B","\u91CE","\u91CF",
                "\u5415","\u91CC","\u91CD","\u91CA","\u7EE9","\u5411","\u8863","\u7D2F","\u4E7E","\u57D4","\u8BA1","\u7D2B","\u6C1B","\u8BA2","\u8BAD","\u75BE","\u8BAF","\u6C14","\u7D22","\u6C11","\u7D20","\u4E66","\u57CE","\u8BBE","\u8BBF","\u8BB8","\u4E60","\u8BBA","\u5F6D","\u4E5D","\u57F4","\u5F6C","\u5F69",
                "\u4E58","\u6C38","\u5F6A","\u5F64","\u4E54","\u5F66","\u4E56","\u57F9","\u4E50","\u4E53","\u57FA","\u4E52","\u4E49","\u8309","\u4E45","\u8304","\u8305","\u758F","\u5F77","\u5F70","\u8302","\u8303","\u5F71","\u8301","\u4E3B","\u4E3A","\u5F08","\u6C5F","\u9AD8","\u4E32","\u4E30","\u8BED","\u8377",
                "\u4E34","\u5782","\u5F18","\u578B","\u6C40","\u8363","\u4E19","\u4E18","\u8BC1","\u8BC0","\u4E1A","\u6C7D","\u8BC6","\u4E1C","\u8BC4","\u4E1E","\u6C7E","\u6C74","\u8BCD","\u5F27","\u4E16","\u5F26","\u5F3A","\u57A3","\u8BD7","\u8BDA","\u6C60","\u4E03","\u4E07","\u5FC6","\u4EF7","\u5FC5","\u575A",
                "\u4EF2","\u753A","\u4EF0","\u6C90","\u7532","\u4EFB","\u7533","\u6C9B","\u7530","\u6C99","\u5FD7","\u6C85","\u6C83","\u574A","\u6C82","\u6C81","\u5747","\u83AB","\u6C88","\u751C","\u4ED5","\u751F","\u5FE0","\u7518","\u4ED1","\u751A","\u4ED3","\u6CB3","\u6CBC","\u6CBD","\u6CBE","\u6CBF","\u6CB8",
                "\u6CB9","\u5FF5","\u6CA7","\u4EC1","\u576A","\u5FFD","\u5764","\u4ECE","\u5766","\u5761","\u6CAB","\u4EB3","\u6CD3","\u83F2","\u5F81","\u6CD7","\u5F84","\u6CD5","\u6CDB","\u5F8B","\u5F92","\u5F90","\u4EA7","\u5F97","\u4EA6","\u5703","\u4EAB","\u6CCA","\u5F99","\u4EA9","\u6CC9","\u5F98","\u4EA8",
                "\u4EAE","\u5706","\u7565","\u4EAD","\u5F9C","\u4EAC","\u6CF0","\u5FA1","\u7559","\u4E91","\u573A","\u6CF3","\u5FA8","\u5730","\u9A70","\u4E9A","\u5733","\u6CFD","\u6CE2","\u6CE5","\u572D","\u754C","\u5FB7","\u9A6C","\u4E89","\u6CE8","\u5723","\u4E8B","\u7545","\u4E8E","\u822C","\u6597","\u822A",
                "\u4F69","\u6D0B","\u6599","\u6587","\u4F7F","\u8239","\u6D1B","\u8237","\u8236","\u6D17","\u56DE","\u4F73","\u4F4F","\u820D","\u5E7C","\u5E7D","\u4F4D","\u6D2A","\u65B0","\u56E0","\u5E78","\u5E76","\u5E74","\u6D25","\u65BD","\u748B","\u5E73","\u65B9","\u65A7","\u6D3E","\u6D3D","\u821F","\u4F5B",
                "\u4F59","\u56FE","\u6D35","\u4F55","\u56FD","\u8A89","\u6D32","\u56FA","\u65A9","\u4F51","\u8212","\u4F50","\u5E1B","\u5E1D","\u826F","\u6D4E","\u74E6","\u4F2F","\u4F20","\u6D41","\u7C73","\u6D45","\u4F26","\u4F27","\u6D59","\u5E08","\u6D5A","\u4F3A","\u65C5","\u5E0C","\u827E","\u65CB","\u5E03",
                "\u5E02","\u5E05","\u4F34","\u65CF","\u5E06","\u6D6A","\u4F0A","\u5E38","\u6D69","\u65F6","\u65F7","\u4F0F","\u4F0D","\u65FA","\u6D63","\u4F01","\u6D66","\u65E2","\u4F1F","\u65E6","\u5E2D","\u65E5","\u65E9","\u65E8","\u6D77","\u4F17","\u65ED","\u6D85","\u4FE1","\u742A","\u82AF","\u82AE","\u82AD",
                "\u4FEF","\u82AC","\u4FEE","\u7426","\u82AB","\u7422","\u82B7","\u82B3","\u4FF1","\u6D93","\u82B1","\u82BD","\u6500","\u5EC9","\u82B8","\u6D9B","\u82B9","\u7C97","\u653F","\u6DA6","\u5EF6","\u653E","\u7C92","\u7409","\u8282","\u828D","\u4FCF","\u7406","\u6536","\u4FCA","\u5EFA","\u828A","\u4FD7",
                "\u8292","\u4FD0","\u4FDE","\u829D","\u4FDD","\u8A00","\u8299","\u7C89","\u5609","\u82E5","\u5E9A","\u5E9C","\u4FAF","\u6556","\u6548","\u82F1","\u747E","\u5E86","\u654F","\u6DD8","\u5E8A","\u82F9","\u6545","\u4FBF","\u6DE1","\u5EB7","\u5EB6","\u5EB8","\u5EBE","\u4F8D","\u82D1","\u82D3","\u6DF1",
                "\u82D4","\u5EA6","\u745E","\u5EA7","\u82D7","\u5EAD","\u4F9D","\u592E","\u51B6","\u5929","\u946B","\u51B0","\u592A","\u51B2","\u51AC","\u73CD","\u73CF","\u73C8","\u73CA","\u73C0","\u51A0","\u62F3","\u5907","\u8DEF","\u519B","\u62C9","\u590F","\u590D","\u5192","\u62C2","\u591A","\u62D3","\u73E0",
                "\u8D8A","\u7B03","\u5962","\u51FA","\u5965","\u51FD","\u51F0","\u8D85","\u7396","\u7B11","\u7389","\u51EF","\u7B19","\u62B1","\u51E1","\u7B1B","\u7384","\u597D","\u7387","\u73BB","\u5942","\u7B20","\u5947","\u594B","\u73AB","\u51CC","\u5954","\u5955","\u51C0","\u51C6","\u8D44","\u6267","\u94ED",
                "\u626C","\u9C7C","\u94F6","\u627F","\u8D64","\u6247","\u624D","\u5982","\u94C1","\u5999","\u5171","\u59EC","\u5175","\u5176","\u5177","\u5178","\u94A6","\u517C","\u59FF","\u5168","\u516D","\u8D1D","\u8D21","\u8D22","\u8D24","\u6210","\u8D35","\u5146","\u949F","\u514B","\u5149","\u5148","\u9497",
                "\u6B66","\u6B65","\u6B63","\u957F","\u5821","\u50B2","\u6B4C","\u955C","\u7A79","\u7A7A","\u9547","\u5806","\u5802","\u6B22","\u6B23","\u6B21","\u6B27","\u7281","\u9526","\u7A0B","\u9510","\u8427","\u950B","\u7ADF","\u6377","\u6BEB","\u7AD9","\u95FB","\u5029","\u95F2","\u84DD","\u95EE","\u8C46",
                "\u95E8","\u7ACB","\u95EA","\u503C","\u7AFF","\u7267","\u7AF9","\u7261","\u7AFA","\u500D","\u6BC5","\u7269","\u7AE0","\u8C6A","\u8C6B","\u501A","\u5883","\u5065","\u58EE","\u632F","\u58E4","\u5043","\u6B8A","\u8C37","\u631A","\u8C26","\u6853","\u539A","\u6851","\u8FEA","\u6850","\u9645","\u539F",
                "\u7965","\u6854","\u8776","\u6842","\u6843","\u797A","\u8FC1","\u8FC5","\u8FDB","\u7956","\u6866","\u8FDC","\u8FD0","\u795E","\u795F","\u6817","\u6089","\u6811","\u9614","\u6807","\u609F","\u5B57","\u8FBE","\u793E","\u5B5F","\u5B5D","\u53C2","\u8FB0","\u680B","\u7199","\u9621","\u8F89","\u5B63",
                "\u683D","\u683C","\u53F6","\u60A0","\u53F0","\u53EC","\u53EE","\u53EF","\u5B70","\u6821","\u9633","\u718A","\u9EA6","\u53E4","\u6829","\u5B8B","\u5B88","\u79E9","\u5B89","\u79EF","\u5B8F","\u5317","\u96C0","\u96C1","\u8F69","\u5319","\u5B81","\u79E6","\u5B87","\u68D5","\u68CB","\u5B9B","\u6052",
                "\u5B9A","\u5B99","\u7167","\u5B9E","\u5B9D","\u5B9C","\u8F7B","\u5B97","\u9E4F","\u96EA","\u79C9","\u96E8","\u5BAB","\u79CB","\u79C0","\u6069","\u5BA2","\u5BA3","\u715C","\u9E7F","\u606D","\u606F","\u5BB9","\u6070","\u9E64","\u79D1","\u68E0","\u5BB6","\u5357","\u5353","\u9686","\u5BC2","\u535A",
                "\u6893","\u5347","\u79BE","\u5343","\u5341","\u79B9","\u534E","\u6885","\u601D","\u5BD2","\u6881","\u5349","\u798F","\u5377","\u5370","\u6021","\u68B5","\u537F","\u9E3D","\u5378","\u68B3","\u68AD","\u68AF","\u878D","\u5366","\u9E23","\u68A8","\u5BFA","\u68A7","\u536B","\u70E8","\u9752","\u9756",
                "\u5A01","\u5A04","\u529F","\u8679","\u52AA","\u70C8","\u5A31","\u61FF","\u7855","\u52A0","\u52A1","\u864E","\u8654","\u7845","\u9769","\u52B2","\u52B1","\u70AC","\u9716","\u70AF","\u52C9","\u70AB","\u52CB","\u971C","\u52C7","\u9704","\u9F99","\u708E","\u5A77","\u7814","\u52E4","\u9F50","\u5217",
                "\u6148","\u5219","\u521A","\u521B","\u521D","\u614E","\u707F","\u86CB","\u522B","\u5229","\u97F3","\u97F5","\u97F6","\u78CA","\u97EC","\u5236","\u97E6","\u524D","\u9F0E","\u610F","\u701A"};

/*  \u516C\u53F8\u540D */
        String[] Surname= {"\u7F08","\u6E38","\u6E29","\u9038","\u5D4B","\u77BB","\u989C","\u7F3A","\u6E0A","\u6696","\u6E05","\u89C5","\u89C2","\u5D27","\u9065","\u55BB","\u66F4","\u55A7","\u66F2","\u5D34","\u66FC","\u7F55","\u66F9","\u5D0E","\u817E","\u6E5B","\u77F3","\u5D07","\u559C","\u98DE","\u98D8","\u5584","\u77E5",
                "\u5D16","\u98CE","\u77E9","\u9053","\u5578","\u5DE1","\u90A6","\u662D","\u771F","\u5DE7","\u6620","\u5DE8","\u6625","\u7F8E","\u90B5","\u7701","\u6631","\u7F9A","\u6EAA","\u6634","\u7F9E","\u6636","\u773A","\u660A","\u6E90","\u660E","\u660F","\u660C","\u7FA4","\u6602","\u6606","\u6619","\u661F",
                "\u6613","\u7FBF","\u5546","\u5DDE","\u5DDD","\u7FBD","\u6615","\u6614","\u666F","\u6668","\u987A","\u7FC1","\u6664","\u9876","\u7FCE","\u9875","\u5531","\u7FD4","\u552F","\u6EE1","\u667A","\u5524","\u6674","\u90FD","\u81F4","\u664B","\u81F3","\u6643","\u5510","\u665F","\u897F","\u81E3","\u6656",
                "\u7FFC","\u6653","\u81EA","\u7686","\u800C","\u7687","\u8896","\u8000","\u99A8","\u5C71","\u8003","\u768E","\u8881","\u7693","\u8018","\u54F2","\u67AF","\u54C1","\u6797","\u54C8","\u5C51","\u54C9","\u679A","\u679C","\u5C55","\u679D","\u6781","\u5C4B","\u5C4A","\u803F","\u9996","\u803D","\u5C4F",
                "\u6787","\u9999","\u678B","\u5C45","\u8036","\u5C3C","\u6F6D","\u67F3","\u67F1","\u76CA","\u76C8","\u54A8","\u67E5","\u54B1","\u805A","\u5C27","\u67EF","\u76DB","\u67D4","\u5C18","\u806A","\u67D2","\u5C1A","\u548C","\u76EE","\u5C16","\u9152","\u5C11","\u67DA","\u67C4","\u76F4","\u5496","\u914B",
                "\u5C0A","\u76FC","\u67CF","\u5C06","\u5C01","\u76F8","\u8083","\u5CF0","\u5468","\u673D","\u5CFB","\u6731","\u6734","\u672A","\u672B","\u5CE1","\u672F","\u8096","\u672C","\u5CEA","\u5CE8","\u5CED","\u7EB1","\u5448","\u7EB3","\u671B","\u7EB7","\u7EB9","\u7EB8","\u80A9","\u7EBA","\u7EBD","\u6714",
                "\u5458","\u6708","\u6709","\u7EA2","\u670B","\u670D","\u80B4","\u7EA6","\u7EA7","\u7EAA","\u7EAF","\u542F","\u677F","\u677E","\u7ED3","\u5CB3","\u542B","\u7EDF","\u7ED8","\u5CB8","\u6770","\u7EC6","\u884C","\u7EC7","\u7EC4","\u7EC5","\u676D","\u80DC","\u5434","\u6765","\u7ECD","\u7ECA","\u7EC8",
                "\u6761","\u5CA9","\u540D","\u7EF4","\u540C","\u675C","\u80E5","\u5C97","\u675F","\u540E","\u675E","\u5409","\u5408","\u91D1","\u8877","\u5404","\u7EFF","\u91DC","\u6750","\u5C9B","\u5C9A","\u767D","\u91C7","\u767E","\u674E","\u674F","\u7678","\u886B","\u6749","\u8868","\u541B","\u91CE","\u91CF",
                "\u5415","\u91CC","\u91CD","\u91CA","\u7EE9","\u5411","\u8863","\u7D2F","\u4E7E","\u57D4","\u8BA1","\u7D2B","\u6C1B","\u8BA2","\u8BAD","\u75BE","\u8BAF","\u6C14","\u7D22","\u6C11","\u7D20","\u4E66","\u57CE","\u8BBE","\u8BBF","\u8BB8","\u4E60","\u8BBA","\u5F6D","\u4E5D","\u57F4","\u5F6C","\u5F69",
                "\u4E58","\u6C38","\u5F6A","\u5F64","\u4E54","\u5F66","\u4E56","\u57F9","\u4E50","\u4E53","\u57FA","\u4E52","\u4E49","\u8309","\u4E45","\u8304","\u8305","\u758F","\u5F77","\u5F70","\u8302","\u8303","\u5F71","\u8301","\u4E3B","\u4E3A","\u5F08","\u6C5F","\u9AD8","\u4E32","\u4E30","\u8BED","\u8377",
                "\u4E34","\u5782","\u5F18","\u578B","\u6C40","\u8363","\u4E19","\u4E18","\u8BC1","\u8BC0","\u4E1A","\u6C7D","\u8BC6","\u4E1C","\u8BC4","\u4E1E","\u6C7E","\u6C74","\u8BCD","\u5F27","\u4E16","\u5F26","\u5F3A","\u57A3","\u8BD7","\u8BDA","\u6C60","\u4E03","\u4E07","\u5FC6","\u4EF7","\u5FC5","\u575A",
                "\u4EF2","\u753A","\u4EF0","\u6C90","\u7532","\u4EFB","\u7533","\u6C9B","\u7530","\u6C99","\u5FD7","\u6C85","\u6C83","\u574A","\u6C82","\u6C81","\u5747","\u83AB","\u6C88","\u751C","\u4ED5","\u751F","\u5FE0","\u7518","\u4ED1","\u751A","\u4ED3","\u6CB3","\u6CBC","\u6CBD","\u6CBE","\u6CBF","\u6CB8",
                "\u6CB9","\u5FF5","\u6CA7","\u4EC1","\u576A","\u5FFD","\u5764","\u4ECE","\u5766","\u5761","\u6CAB","\u4EB3","\u6CD3","\u83F2","\u5F81","\u6CD7","\u5F84","\u6CD5","\u6CDB","\u5F8B","\u5F92","\u5F90","\u4EA7","\u5F97","\u4EA6","\u5703","\u4EAB","\u6CCA","\u5F99","\u4EA9","\u6CC9","\u5F98","\u4EA8",
                "\u4EAE","\u5706","\u7565","\u4EAD","\u5F9C","\u4EAC","\u6CF0","\u5FA1","\u7559","\u4E91","\u573A","\u6CF3","\u5FA8","\u5730","\u9A70","\u4E9A","\u5733","\u6CFD","\u6CE2","\u6CE5","\u572D","\u754C","\u5FB7","\u9A6C","\u4E89","\u6CE8","\u5723","\u4E8B","\u7545","\u4E8E","\u822C","\u6597","\u822A",
                "\u4F69","\u6D0B","\u6599","\u6587","\u4F7F","\u8239","\u6D1B","\u8237","\u8236","\u6D17","\u56DE","\u4F73","\u4F4F","\u820D","\u5E7C","\u5E7D","\u4F4D","\u6D2A","\u65B0","\u56E0","\u5E78","\u5E76","\u5E74","\u6D25","\u65BD","\u748B","\u5E73","\u65B9","\u65A7","\u6D3E","\u6D3D","\u821F","\u4F5B",
                "\u4F59","\u56FE","\u6D35","\u4F55","\u56FD","\u8A89","\u6D32","\u56FA","\u65A9","\u4F51","\u8212","\u4F50","\u5E1B","\u5E1D","\u826F","\u6D4E","\u74E6","\u4F2F","\u4F20","\u6D41","\u7C73","\u6D45","\u4F26","\u4F27","\u6D59","\u5E08","\u6D5A","\u4F3A","\u65C5","\u5E0C","\u827E","\u65CB","\u5E03",
                "\u5E02","\u5E05","\u4F34","\u65CF","\u5E06","\u6D6A","\u4F0A","\u5E38","\u6D69","\u65F6","\u65F7","\u4F0F","\u4F0D","\u65FA","\u6D63","\u4F01","\u6D66","\u65E2","\u4F1F","\u65E6","\u5E2D","\u65E5","\u65E9","\u65E8","\u6D77","\u4F17","\u65ED","\u6D85","\u4FE1","\u742A","\u82AF","\u82AE","\u82AD",
                "\u4FEF","\u82AC","\u4FEE","\u7426","\u82AB","\u7422","\u82B7","\u82B3","\u4FF1","\u6D93","\u82B1","\u82BD","\u6500","\u5EC9","\u82B8","\u6D9B","\u82B9","\u7C97","\u653F","\u6DA6","\u5EF6","\u653E","\u7C92","\u7409","\u8282","\u828D","\u4FCF","\u7406","\u6536","\u4FCA","\u5EFA","\u828A","\u4FD7",
                "\u8292","\u4FD0","\u4FDE","\u829D","\u4FDD","\u8A00","\u8299","\u7C89","\u5609","\u82E5","\u5E9A","\u5E9C","\u4FAF","\u6556","\u6548","\u82F1","\u747E","\u5E86","\u654F","\u6DD8","\u5E8A","\u82F9","\u6545","\u4FBF","\u6DE1","\u5EB7","\u5EB6","\u5EB8","\u5EBE","\u4F8D","\u82D1","\u82D3","\u6DF1",
                "\u82D4","\u5EA6","\u745E","\u5EA7","\u82D7","\u5EAD","\u4F9D","\u592E","\u51B6","\u5929","\u946B","\u51B0","\u592A","\u51B2","\u51AC","\u73CD","\u73CF","\u73C8","\u73CA","\u73C0","\u51A0","\u62F3","\u5907","\u8DEF","\u519B","\u62C9","\u590F","\u590D","\u5192","\u62C2","\u591A","\u62D3","\u73E0",
                "\u8D8A","\u7B03","\u5962","\u51FA","\u5965","\u51FD","\u51F0","\u8D85","\u7396","\u7B11","\u7389","\u51EF","\u7B19","\u62B1","\u51E1","\u7B1B","\u7384","\u597D","\u7387","\u73BB","\u5942","\u7B20","\u5947","\u594B","\u73AB","\u51CC","\u5954","\u5955","\u51C0","\u51C6","\u8D44","\u6267","\u94ED",
                "\u626C","\u9C7C","\u94F6","\u627F","\u8D64","\u6247","\u624D","\u5982","\u94C1","\u5999","\u5171","\u59EC","\u5175","\u5176","\u5177","\u5178","\u94A6","\u517C","\u59FF","\u5168","\u516D","\u8D1D","\u8D21","\u8D22","\u8D24","\u6210","\u8D35","\u5146","\u949F","\u514B","\u5149","\u5148","\u9497",
                "\u6B66","\u6B65","\u6B63","\u957F","\u5821","\u50B2","\u6B4C","\u955C","\u7A79","\u7A7A","\u9547","\u5806","\u5802","\u6B22","\u6B23","\u6B21","\u6B27","\u7281","\u9526","\u7A0B","\u9510","\u8427","\u950B","\u7ADF","\u6377","\u6BEB","\u7AD9","\u95FB","\u5029","\u95F2","\u84DD","\u95EE","\u8C46",
                "\u95E8","\u7ACB","\u95EA","\u503C","\u7AFF","\u7267","\u7AF9","\u7261","\u7AFA","\u500D","\u6BC5","\u7269","\u7AE0","\u8C6A","\u8C6B","\u501A","\u5883","\u5065","\u58EE","\u632F","\u58E4","\u5043","\u6B8A","\u8C37","\u631A","\u8C26","\u6853","\u539A","\u6851","\u8FEA","\u6850","\u9645","\u539F",
                "\u7965","\u6854","\u8776","\u6842","\u6843","\u797A","\u8FC1","\u8FC5","\u8FDB","\u7956","\u6866","\u8FDC","\u8FD0","\u795E","\u795F","\u6817","\u6089","\u6811","\u9614","\u6807","\u609F","\u5B57","\u8FBE","\u793E","\u5B5F","\u5B5D","\u53C2","\u8FB0","\u680B","\u7199","\u9621","\u8F89","\u5B63",
                "\u683D","\u683C","\u53F6","\u60A0","\u53F0","\u53EC","\u53EE","\u53EF","\u5B70","\u6821","\u9633","\u718A","\u9EA6","\u53E4","\u6829","\u5B8B","\u5B88","\u79E9","\u5B89","\u79EF","\u5B8F","\u5317","\u96C0","\u96C1","\u8F69","\u5319","\u5B81","\u79E6","\u5B87","\u68D5","\u68CB","\u5B9B","\u6052",
                "\u5B9A","\u5B99","\u7167","\u5B9E","\u5B9D","\u5B9C","\u8F7B","\u5B97","\u9E4F","\u96EA","\u79C9","\u96E8","\u5BAB","\u79CB","\u79C0","\u6069","\u5BA2","\u5BA3","\u715C","\u9E7F","\u606D","\u606F","\u5BB9","\u6070","\u9E64","\u79D1","\u68E0","\u5BB6","\u5357","\u5353","\u9686","\u5BC2","\u535A",
                "\u6893","\u5347","\u79BE","\u5343","\u5341","\u79B9","\u534E","\u6885","\u601D","\u5BD2","\u6881","\u5349","\u798F","\u5377","\u5370","\u6021","\u68B5","\u537F","\u9E3D","\u5378","\u68B3","\u68AD","\u68AF","\u878D","\u5366","\u9E23","\u68A8","\u5BFA","\u68A7","\u536B","\u70E8","\u9752","\u9756",
                "\u5A01","\u5A04","\u529F","\u8679","\u52AA","\u70C8","\u5A31","\u61FF","\u7855","\u52A0","\u52A1","\u864E","\u8654","\u7845","\u9769","\u52B2","\u52B1","\u70AC","\u9716","\u70AF","\u52C9","\u70AB","\u52CB","\u971C","\u52C7","\u9704","\u9F99","\u708E","\u5A77","\u7814","\u52E4","\u9F50","\u5217",
                "\u6148","\u5219","\u521A","\u521B","\u521D","\u614E","\u707F","\u86CB","\u522B","\u5229","\u97F3","\u97F5","\u97F6","\u78CA","\u97EC","\u5236","\u97E6","\u524D","\u9F0E","\u610F","\u701A"};

//\u9A8C\u8BC1\u662F\u5426\u6E05\u6D17\u7684\u6570\u7EC4

        String[] noChange = {"\u8D22\u653F","\u9ED1\u9F99\u6C5F","\u5317\u4EAC", "\u5929\u6D25", "\u4E0A\u6D77", "\u91CD\u5E86", "\u6CB3\u5317", "\u5C71\u897F", "\u8FBD\u5B81", "\u5409\u6797",  "\u6C5F\u82CF", "\u6D59\u6C5F", "\u5B89\u5FBD", "\u798F\u5EFA", "\u6C5F\u897F", "\u6CB3\u5357", "\u6E56\u5317", "\u6E56\u5357", "\u5E7F\u4E1C", "\u6D77\u5357", "\u56DB\u5DDD", "\u8D35\u5DDE", "\u4E91\u5357", "\u9655\u897F", "\u7518\u8083", "\u9752\u6D77", "\u53F0\u6E7E", "\u5185\u8499", "\u5E7F\u897F", "\u897F\u85CF", "\u5B81\u590F", "\u65B0\u7586", "\u9999\u6E2F", "\u6FB3\u95E8","\u4E2D\u5B66","\u78C1","\u5382","\u7ECF\u8425\u90E8","\u519C\u8D44\u5E97","\u9752\u94DC\u5CE1","\u81EA\u6CBB\u53BF","\u5185\u8499\u53E4","\u77F3\u5634\u5C71","\u52A0\u76DF\u5E97","\u8499\u53E4\u65CF","\u571F\u7279\u4EA7","\u526F\u98DF\u54C1","\u5408\u4F5C\u793E","\u6E05\u771F\u5BFA","\u4E92\u52A9\u793E","\u7AF9\u7EA4\u7EF4","\u6279\u53D1\u90E8","\u7ECF\u9500\u90E8","\u7535\u52A8\u8F66","\u4E2D\u5B66","\u5C0F\u5B66","\u5B66\u6821","\u9AD8\u4E2D","\u5927\u5B66","\u589E\u8865","\u4E2A\u4EBA","\u4EE3\u53D1","\u7535\u58F0","\u6D59\u6C5F","\u9488\u7EC7","\u7AE5\u88C5","\u65C5\u6E38","\u5851\u6599","\u56DE\u6536","\u5BBE\u9986","\u88C5\u9970","\u5DE5\u8D44","\u6280\u6821","\u52D8\u5BDF","\u5730\u8D28","\u4FDD\u9669","\u7269\u4E1A","\u5B89\u88C5","\u5B9E\u9A8C","\u7EBA\u7EC7","\u666F\u89C2","\u8D85\u5E02","\u5BBE\u9986","\u5546\u57CE","\u7535\u89C6","\u5EFA\u8BBE","\u5B81\u590F","\u6838\u7B97","\u6C7D\u8F66","\u6D41\u901A","\u6728\u4E1A","\u9910\u996E","\u5BB6\u79C1","\u519C\u6C11","\u9152\u5E97","\u6C34\u679C","\u5316\u5DE5","\u652F\u884C","\u94F6\u5DDD","\u7EF4\u4FEE","\u4EA4\u901A","\u53D1\u5C55","\u94F6\u884C","\u5668\u6750","\u5E02\u573A","\u5B9E\u4E1A","\u673A\u68B0","\u5DE5\u8D38","\u4E8C\u624B","\u6279\u53D1","\u98DF\u5802","\u8F66\u884C","\u96C6\u4E2D","\u673A\u7535","\u5BBF\u820D","\u5C0F\u989D","\u5927\u8857","\u7535\u5668","\u5236\u9020","\u56FA\u539F","\u5DE5\u7A0B","\u4E13\u4E1A","\u5E7C\u513F","\u519C\u573A","\u96C6\u56E2","\u7EFC\u5408","\u793E\u533A","\u79D1\u6280","\u74DC\u679C","\u6E05\u771F","\u7801\u5934","\u56ED\u533A","\u4F11\u95F2","\u7CAE\u6CB9","\u5546\u884C","\u7BA1\u7406","\u80A1\u4EFD","\u5546\u4E1A","\u6587\u5316","\u4F20\u64AD","\u4E2D\u536B","\u5E7F\u64AD","\u9152\u697C","\u5355\u5143","\u4E2D\u5FC3","\u5370\u5237","\u5F00\u53D1","\u9632\u6C34","\u5434\u5FE0","\u7535\u5B50","\u8D44\u91D1","\u5927\u4FEE","\u8D23\u4EFB","\u5EFA\u6750","\u5E55\u5899","\u5370\u52A1","\u533B\u7597","\u5609\u5174","\u519C\u6751","\u6709\u9650","\u7269\u8D44","\u5668\u68B0","\u73E0\u5B9D","\u7535\u529B","\u8D44\u4EA7","\u8D37\u6B3E","\u82D7\u6728","\u529E\u516C","\u670D\u88C5","\u670D\u52A1","\u82B1\u56ED","\u6751\u7EA7","\u79CD\u690D","\u516C\u53F8","\u884C\u653F","\u54A8\u8BE2","\u517B\u6B96","\u4FDD\u6D01","\u5C0F\u533A","\u8BBE\u5907","\u5929\u7A97","\u8857\u9053","\u56ED\u6797","\u516C\u8DEF","\u8282\u80FD","\u9500\u552E","\u8D38\u6613","\u5546\u8D38","\u8FDE\u9501","\u80F6\u7C98","\u5236\u54C1","\u8DEF\u6865","\u77FF\u4E1A","\u5357\u5BFA","\u5DE5\u4E1A","\u9676\u74F7","\u519C\u4E1A","\u679C\u852C"

        };
        String[] noChange1 = {"\u5DE5","\u4E1A","\u5C40","\u79CD","\u5927","\u9644","\u5317","\u7AD9","\u5DE6","\u5C6F","\u574A","\u5DF7","\u57CE","\u7701","\u5382","\u56DB","\u4E61","\u4E5D","\u9662","\u8DEF","\u53BF","\u533A","\u56ED","\u5BA4","\u9547","\u9762","\u6865","\u580D","\u5C42","\u5185","\u5E62","\u6D32","\u5DDE","\u53A6","\u5BB6","\u697C","\u5357","\u4FA7","\u5E97","\u524D","\u90E8","\u5F04","\u65C1","\u7EC4","\u5E84","\u6D5C","\u5341","\u6237","\u4E2D","\u793E","\u8361","\u516B","\u5E02","\u961F","\u516D","\u680B","\u540E","\u4E94","\u4E1C","\u53F7","\u6751","\u53F3","\u7B2C","\u82D1","\u4E09","\u897F","\u5C0F","\u5EA7","\u73AF","\u5BFA","\u4E00","\u4E03","\u4E8C","\u53E3","\u59D4","\u9053", "F","~","\uFF01","@","#","\uFFE5","%","\u2026","^","\u2026\u2026","&","*","\uFF08","\uFF09","\u2014","\u2014","+","}","{","\uFF1A","\u201C","\u300B","\u300A","\uFF1F","-","(",")"

        };
        String[] noChange2 = {"\u519C\u57A6","\u6C34\u7A3B","\u914D\u80A5","\u8054\u5408","\u5546\u4F1A","\u8D22\u653F","\u5BB6\u7535","\u6295\u8D44","\u5BCC\u6C11","\u7530\u56ED","\u4E94\u5E38","\u4E50\u5C71","\u81EA\u8D21","\u6CF8\u5DDE","\u96C5\u5B89","\u5B9C\u5BBE","\u8D44\u9633","\u7709\u5C71","\u8D35\u6E2F","\u7389\u6797","\u5317\u6D77","\u6F33\u5DDE","\u8861\u6C34","\u5ECA\u574A","\u627F\u5FB7","\u6E29\u5DDE","\u5B81\u6CE2","\u676D\u5DDE","\u53F0\u5DDE","\u5609\u5174","\u91D1\u534E","\u6E56\u5DDE","\u7ECD\u5174","\u821F\u5C71","\u4E3D\u6C34","\u8862\u5DDE","\u897F\u5B89","\u54B8\u9633","\u5B9D\u9E21","\u6C49\u4E2D","\u6E2D\u5357","\u5B89\u5EB7","\u6986\u6797","\u5546\u6D1B","\u5EF6\u5B89","\u94DC\u5DDD","\u6FEE\u9633","\u6CA7\u5DDE","\u5510\u5C71","\u4FDD\u5B9A","\u90AF\u90F8","\u90A2\u53F0","\u6F2F\u6CB3","\u8BB8\u660C","\u9E64\u58C1","\u6D4E\u6E90","\u957F\u6C99","\u90B5\u9633","\u5E38\u5FB7","\u8861\u9633","\u682A\u6D32","\u6E58\u6F6D","\u6C38\u5DDE","\u5CB3\u9633","\u6000\u5316","\u90F4\u5DDE","\u5A04\u5E95","\u76CA\u9633","\u53A6\u95E8","\u6CC9\u5DDE","\u798F\u5DDE","\u8386\u7530","\u5B81\u5FB7","\u4E09\u660E","\u5357\u5E73","\u9F99\u5CA9","\u5357\u5B81","\u5468\u53E3","\u5546\u4E18","\u5F00\u5C01","\u7126\u4F5C","\u66F2\u9756","\u4FDD\u5C71","\u7389\u6EAA","\u662D\u901A","\u5DF4\u4E2D","\u9042\u5B81","\u5185\u6C5F","\u67F3\u5DDE","\u6842\u6797","\u68A7\u5DDE","\u94A6\u5DDE","\u6765\u5BBE","\u6CB3\u6C60","\u767E\u8272","\u8D3A\u5DDE","\u5D07\u5DE6","\u829C\u6E56","\u5408\u80A5","\u516D\u5B89","\u5BBF\u5DDE","\u961C\u9633","\u5B89\u5E86","\u4E09\u4E9A","\u6D77\u53E3","\u743C\u6D77","\u6587\u660C","\u4E1C\u65B9","\u6210\u90FD","\u7EF5\u9633","\u5E7F\u5143","\u8FBE\u5DDE","\u5357\u5145","\u5FB7\u9633","\u5E7F\u5B89","\u9F50\u9F50","\u54C8\u5C14","\u868C\u57E0","\u6DEE\u5317","\u6DEE\u5357","\u5BA3\u57CE","\u9EC4\u5C71","\u94DC\u9675","\u4EB3\u5DDE","\u6C60\u5DDE","\u5DE2\u6E56","\u6EC1\u5DDE","\u5357\u660C","\u8D63\u5DDE","\u4E0A\u9976","\u5409\u5B89","\u4E5D\u6C5F","\u65B0\u4F59","\u629A\u5DDE","\u5B9C\u6625","\u9EC4\u5188","\u5B5D\u611F","\u5341\u5830","\u54B8\u5B81","\u9EC4\u77F3","\u4ED9\u6843","\u5929\u95E8","\u968F\u5DDE","\u8346\u95E8","\u6F5C\u6C5F","\u9102\u5DDE","\u592A\u539F","\u5927\u540C","\u8FD0\u57CE","\u957F\u6CBB","\u664B\u57CE","\u5FFB\u5DDE","\u4E34\u6C7E","\u5415\u6881","\u664B\u4E2D","\u9633\u6CC9","\u6714\u5DDE","\u5927\u8FDE","\u6C88\u9633","\u4E39\u4E1C","\u8FBD\u9633","\u5927\u5E86","\u9526\u5DDE","\u671D\u9633","\u8425\u53E3","\u978D\u5C71","\u629A\u987A","\u961C\u65B0","\u76D8\u9526","\u672C\u6EAA","\u840D\u4E61","\u9E70\u6F6D","\u6B66\u6C49","\u5B9C\u660C","\u8944\u6A0A","\u8346\u5DDE","\u94C1\u5CAD","\u53F0\u5317","\u9AD8\u96C4","\u53F0\u4E2D","\u65B0\u7AF9","\u57FA\u9686","\u53F0\u5357","\u5609\u4E49","\u5357\u901A","\u5E38\u5DDE","\u9547\u6C5F","\u626C\u5DDE","\u6DEE\u5B89","\u6CF0\u5DDE","\u5BBF\u8FC1","\u90D1\u5DDE","\u5357\u9633","\u65B0\u4E61","\u5B89\u9633","\u6D1B\u9633","\u4FE1\u9633","\u9E21\u897F","\u9ED1\u6CB3","\u7EE5\u5316","\u9E64\u5C97","\u4F0A\u6625","\u8D35\u9633","\u9075\u4E49","\u5B89\u987A","\u5170\u5DDE","\u5929\u6C34","\u5E86\u9633","\u6B66\u5A01","\u9152\u6CC9","\u5F20\u6396","\u767D\u94F6","\u5E73\u51C9","\u91D1\u660C","\u5409\u6797","\u957F\u6625","\u767D\u5C71","\u767D\u57CE","\u677E\u539F","\u8FBD\u6E90","\u901A\u5316","\u56DB\u5E73","\u94F6\u5DDD","\u5434\u5FE0","\u4E2D\u536B","\u56FA\u539F","\u9633\u6C5F","\u6885\u5DDE","\u4E91\u6D6E","\u8302\u540D","\u6C55\u5C3E","\u6D4E\u5357","\u9752\u5C9B","\u4E34\u6C82","\u6D4E\u5B81","\u83CF\u6CFD","\u70DF\u53F0","\u6DC4\u535A","\u6CF0\u5B89","\u6F4D\u574A","\u65E5\u7167","\u5A01\u6D77","\u6EE8\u5DDE","\u4E1C\u8425","\u804A\u57CE","\u5FB7\u5DDE","\u83B1\u829C","\u67A3\u5E84","\u82CF\u5DDE","\u5F90\u5DDE","\u76D0\u57CE","\u65E0\u9521","\u5357\u4EAC","\u4E1C\u839E","\u5E7F\u5DDE","\u4E2D\u5C71","\u6DF1\u5733","\u60E0\u5DDE","\u6C5F\u95E8","\u73E0\u6D77","\u6C55\u5934","\u4F5B\u5C71","\u6E5B\u6C5F","\u6CB3\u6E90","\u8087\u5E86","\u6E05\u8FDC","\u6F6E\u5DDE","\u97F6\u5173","\u63ED\u9633","\u8D22\u5BCC", "\u62C5\u4FDD","\u5317\u4EAC", "\u5929\u6D25", "\u4E0A\u6D77", "\u91CD\u5E86", "\u6CB3\u5317", "\u5C71\u897F", "\u8FBD\u5B81", "\u5409\u6797",  "\u6C5F\u82CF", "\u6D59\u6C5F", "\u5B89\u5FBD", "\u798F\u5EFA", "\u6C5F\u897F", "\u6CB3\u5357", "\u6E56\u5317", "\u6E56\u5357", "\u5E7F\u4E1C", "\u6D77\u5357", "\u56DB\u5DDD", "\u8D35\u5DDE", "\u4E91\u5357", "\u9655\u897F", "\u7518\u8083", "\u9752\u6D77", "\u53F0\u6E7E", "\u5185\u8499", "\u5E7F\u897F", "\u897F\u85CF", "\u5B81\u590F", "\u65B0\u7586", "\u9999\u6E2F", "\u6FB3\u95E8","\u4E2D\u5B66","\u5C0F\u5B66","\u5B66\u6821","\u9AD8\u4E2D","\u5927\u5B66","\u589E\u8865","\u4E2A\u4EBA","\u4EE3\u53D1","\u7535\u58F0","\u6D59\u6C5F","\u9488\u7EC7","\u7AE5\u88C5","\u65C5\u6E38","\u5851\u6599","\u56DE\u6536","\u5BBE\u9986","\u88C5\u9970","\u5DE5\u8D44","\u6280\u6821","\u52D8\u5BDF","\u5730\u8D28","\u4FDD\u9669","\u7269\u4E1A","\u5B89\u88C5","\u5B9E\u9A8C","\u7EBA\u7EC7","\u666F\u89C2","\u8D85\u5E02","\u5BBE\u9986","\u5546\u57CE","\u7535\u89C6","\u5EFA\u8BBE","\u5B81\u590F","\u6838\u7B97","\u6C7D\u8F66","\u6D41\u901A","\u6728\u4E1A","\u9910\u996E","\u5BB6\u79C1","\u519C\u6C11","\u9152\u5E97","\u6C34\u679C","\u5316\u5DE5","\u652F\u884C","\u94F6\u5DDD","\u7EF4\u4FEE","\u4EA4\u901A","\u53D1\u5C55","\u94F6\u884C","\u5668\u6750","\u5E02\u573A","\u5B9E\u4E1A","\u673A\u68B0","\u5DE5\u8D38","\u4E8C\u624B","\u6279\u53D1","\u98DF\u5802","\u8F66\u884C","\u96C6\u4E2D","\u673A\u7535","\u5BBF\u820D","\u5C0F\u989D","\u5927\u8857","\u7535\u5668","\u5236\u9020","\u56FA\u539F","\u5DE5\u7A0B","\u4E13\u4E1A","\u5E7C\u513F","\u519C\u573A","\u96C6\u56E2","\u7EFC\u5408","\u793E\u533A","\u79D1\u6280","\u74DC\u679C","\u6E05\u771F","\u7801\u5934","\u56ED\u533A","\u4F11\u95F2","\u7CAE\u6CB9","\u5546\u884C","\u7BA1\u7406","\u80A1\u4EFD","\u5546\u4E1A","\u6587\u5316","\u4F20\u64AD","\u4E2D\u536B","\u5E7F\u64AD","\u9152\u697C","\u5355\u5143","\u4E2D\u5FC3","\u5370\u5237","\u5F00\u53D1","\u9632\u6C34","\u5434\u5FE0","\u7535\u5B50","\u8D44\u91D1","\u5927\u4FEE","\u8D23\u4EFB","\u5EFA\u6750","\u5E55\u5899","\u5370\u52A1","\u533B\u7597","\u5609\u5174","\u519C\u6751","\u6709\u9650","\u7269\u8D44","\u5668\u68B0","\u73E0\u5B9D","\u7535\u529B","\u8D44\u4EA7","\u8D37\u6B3E","\u82D7\u6728","\u529E\u516C","\u670D\u88C5","\u670D\u52A1","\u82B1\u56ED","\u6751\u7EA7","\u79CD\u690D","\u516C\u53F8","\u884C\u653F","\u54A8\u8BE2","\u517B\u6B96","\u4FDD\u6D01","\u5C0F\u533A","\u8BBE\u5907","\u5929\u7A97","\u8857\u9053","\u56ED\u6797","\u516C\u8DEF","\u8282\u80FD","\u9500\u552E","\u8D38\u6613","\u5546\u8D38","\u8FDE\u9501","\u80F6\u7C98","\u5236\u54C1","\u8DEF\u6865","\u77FF\u4E1A","\u5357\u5BFA","\u5DE5\u4E1A","\u9676\u74F7","\u519C\u4E1A","\u679C\u852C"

        };
        String[] noChange3 = {"\u5E73\u9876\u5C71","\u9A7B\u9A6C\u5E97","\u4E09\u95E8\u5CE1","\u77F3\u5BB6\u5E84","\u6CB3\u5317\u533A","\u79E6\u7687\u5C9B","\u5F20\u5BB6\u53E3","\u9A6C\u978D\u5C71","\u846B\u82A6\u5C9B","\u54C8\u5C14\u6EE8","\u4F73\u6728\u65AF","\u53CC\u9E2D\u5C71","\u7261\u4E39\u6C5F","\u914D\u80A5\u7AD9","\u9ED1\u9F99\u6C5F","\u7ECF\u8425\u90E8","\u519C\u8D44\u5E97","\u9752\u94DC\u5CE1","\u81EA\u6CBB\u53BF","\u5185\u8499\u53E4","\u77F3\u5634\u5C71","\u8FDE\u4E91\u6E2F","\u52A0\u76DF\u5E97","\u8499\u53E4\u65CF","\u5EF6\u8FB9\u5DDE","\u77F3\u5634\u5C71","\u7518\u5357\u5DDE","\u571F\u7279\u4EA7","\u526F\u98DF\u54C1","\u5408\u4F5C\u793E","\u6E05\u771F\u5BFA","\u4E92\u52A9\u793E","\u7AF9\u7EA4\u7EF4","\u6279\u53D1\u90E8","\u7ECF\u9500\u90E8","\u7535\u52A8\u8F66"};

        String newName="";

//\u9A8C\u8BC1\u662F\u516C\u53F8 \u4E3A1
        int company = 0;

        for (int i = 0; i < noChange.length; i++) {
            if (str.contains(noChange[i])&&str.length()>3){
                company =1;
                break;
            }
        }
        if (company != 0) {

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
                    int hashTemp = Math.abs(arrStr[i].hashCode() + hashSalt);
                    arrStr[i] = Surname[hashTemp % (Surname.length - 1)];
                }


            }
            for (int i = 0; i < arrStr.length; i++) {
                newName += arrStr[i];
            }
//--------------------------------------------------------return

            String s = newName;
            String vLenth = value+"";
            byte[] vLenthB = vLenth.getBytes("GBK");
            byte[] sLenthB = s.getBytes("GBK");
            int diff = 0;
            if (vLenthB.length<sLenthB.length){
                diff = ((sLenthB.length - vLenthB.length) / 2) + ((sLenthB.length - vLenthB.length) % 2);
                s = s.substring(0,s.length()-diff);
            }
            if (vLenthB.length<s.getBytes("GBK").length) return new String(vLenth.getBytes("GBK"), "GBK");
            if (isSuangYin == 1){
                s = "\"" + s +"\"";
            }
            s =  new String(s.getBytes("GBK"), "GBK");

            return s;

        }else{
//\u7279\u6B8A\u5B57\u7B26
            boolean isSpecial = false;
//\u590D\u59D3
            boolean isTwoName = false;
//\u5C11\u6570\u6C11\u65CF
            boolean isRareName = false;

            String lastName = "";
            String firstName = "";

            int lastNameHashCode = 0;
            int firstNameHashCode = 0;

//\u5224\u65AD\u662F\u5426\u542B\u6709\u7279\u6B8A\u5B57\u7B26
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[0-9]*[A-Za-z]*[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~\uFF01@#\uFFE5%\u2026\u2026&*\uFF08\uFF09\u2014\u2014+|{}\u3010\u3011\u2018\uFF1B\uFF1A\u201D\u201C\u2019\u3002\uFF0C\u3001\uFF1F]*");
            for (int i = 0; i < str.length(); i++) {
                java.util.regex.Matcher matcher = pattern.matcher(str.substring(i, i + 1));
                boolean matches = matcher.matches();
                if (matches) {
                    isSpecial = matches;
                    break;
                }
            }
//\u5224\u65AD\u662F\u5426\u662F\u590D\u59D3
            for (int i = 0; i < contain.length; i++) {
                if (str.contains(contain[i])) {
                    isTwoName = true;
                }
            }
//\u5224\u65AD\u662F\u5426\u662F\u5C11\u6570\u6C11\u65CF\u201C·\u201D
            if (str.contains("·")) {
                isRareName = true;
            }
//\u6B63\u5E38\u540D\u5B57
//\u590D\u59D3\u540D\u5B57
//\u5C11\u6570\u6C11\u65CF\u540D\u5B57
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

//\u5C11\u6570\u6C11\u65CF\u62FC\u65B0\u540D\u5B57
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
                    lastNameHashCode = Math.abs(lastName.hashCode() + hashSalt);//\u59D3\u53D6\u6B63\u6570
                    newName = laName[lastNameHashCode % (laName.length - 1)]; //\u83B7\u5F97\u4E00\u4E2A\u56FA\u5B9A\u7684\u59D3\u6C0F
                    if (isTwoName) {
                        newName = contain[lastNameHashCode % (contain.length - 1)]; //\u83B7\u5F97\u4E00\u4E2A\u56FA\u5B9A\u7684\u59D3\u6C0F
                    }
                    for (int i = 0; i < firstName.length(); i++) {
                        firstNameHashCode = Math.abs(firstName.substring(i, i + 1).hashCode() + hashSalt);
                        newName += fiName[firstNameHashCode % (fiName.length - 1)];
                    }
                }
            }
//\u6B63\u5E38\u540D\u5B57\u5E26\u7279\u6B8A\u5B57\u7B26
//\u590D\u59D3\u540D\u5B57\u5E26\u7279\u6B8A\u5B57\u7B26
//\u5C11\u6570\u6C11\u65CF\u540D\u5B57\u5E26\u7279\u6B8A\u5B57\u7B26
//\u5224\u65AD\u6C49\u5B57
            java.util.regex.Pattern pattern1 = java.util.regex.Pattern.compile("[\\u4e00-\\u9fa5]");

            if (isSpecial) {
                int temp = 0;
//\u6839\u636E\u4EE5\u4E0A\u5224\u65AD\u622A\u53D6\u6BCF\u4E2A\u5B57\u7B26\u653E\u5165\u6570\u7EC4
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
                            firstNameHashCode = Math.abs(firstName.hashCode() + hashSalt);//\u540D\u53D6\u6B63\u6570
                            newName = fiName[firstNameHashCode % (fiName.length - 1)]; //\u83B7\u5F97\u4E00\u4E2A\u56FA\u5B9A\u7684\u59D3\u540D\u5B57
                            nameArray[i] = newName.substring(0);
                        }

                        if (matches1 && temp == 0) {
                            lastName = nameArray[i] + nameArray[i + 1];
                            lastNameHashCode = Math.abs(lastName.hashCode() + hashSalt);//\u59D3\u53D6\u6B63\u6570
                            newName = contain[lastNameHashCode % (contain.length - 1)]; //\u83B7\u5F97\u4E00\u4E2A\u56FA\u5B9A\u7684\u59D3\u6C0F
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
                            firstNameHashCode = Math.abs(firstName.hashCode() + hashSalt);//\u540D\u53D6\u6B63\u6570
                            nameArray[i] = fiName[firstNameHashCode % (fiName.length - 1)]; //\u83B7\u5F97\u4E00\u4E2A\u56FA\u5B9A\u7684\u59D3\u540D\u5B57
                        }
                    }
                }

                for (int i = 0; i < nameArray.length; i++) {
                    java.util.regex.Matcher matcher1 = pattern1.matcher(nameArray[i]);
                    boolean matches1 = matcher1.matches();

                    if (matches1 && temp == 1) {
                        firstName = nameArray[i];
                        firstNameHashCode = Math.abs(firstName.hashCode() + hashSalt);//\u540D\u53D6\u6B63\u6570
                        newName = fiName[firstNameHashCode % (fiName.length - 1)]; //\u83B7\u5F97\u4E00\u4E2A\u56FA\u5B9A\u7684\u59D3\u540D\u5B57
                        nameArray[i] = newName.substring(0);
                    }

                    if (matches1 && temp == 0) {
                        lastName = nameArray[i];
                        lastNameHashCode = Math.abs(lastName.hashCode() + hashSalt);//\u59D3\u53D6\u6B63\u6570
                        newName = laName[lastNameHashCode % (laName.length - 1)]; //\u83B7\u5F97\u4E00\u4E2A\u56FA\u5B9A\u7684\u59D3\u6C0F
                        nameArray[i] = newName.substring(0, 1);
                        temp += 1;
                    }

                }
//\u751F\u6210String\u7C7B\u578B\u65B0\u540D\u5B57
                newName = "";
                for (int i = 0; i < nameArray.length; i++) {
                    newName += nameArray[i];
                }
            }
//--------------------------------------------------------return

            String s = newName;
            String vLenth = value+"";
            byte[] vLenthB = vLenth.getBytes("GBK");
            byte[] sLenthB = s.getBytes("GBK");
            int diff = 0;
            if (vLenthB.length<sLenthB.length){
                diff = ((sLenthB.length - vLenthB.length) / 2) + ((sLenthB.length - vLenthB.length) % 2);
                s = s.substring(0,s.length()-diff);
            }
            if (vLenthB.length<s.getBytes("GBK").length) return new String(vLenth.getBytes("GBK"), "GBK");
            if (isSuangYin == 1){
                s = "\"" + s +"\"";
            }
            s =  new String(s.getBytes("GBK"), "GBK");

            return s;
        }



    }

}
