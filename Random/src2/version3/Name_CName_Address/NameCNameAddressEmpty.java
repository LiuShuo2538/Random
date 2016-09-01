package version3.Name_CName_Address;

/**
 * Created by ${LiuShuo} on 8/29/2016.
 */
public class NameCNameAddressEmpty {
    public static Object getModelNameAddr(Object value, Object key) {

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
        String salt = key + "";
        String saltok = salt.replaceAll("\\s*", "");
        int hashSalt = 0;
        if (salt == null || salt.equals("null") || salt.equals("")) {
        } else {
            hashSalt = Math.abs(saltok.hashCode());
        }

        //\u6B63\u5219\u6570\u5B57
        java.util.regex.Pattern pattern1 = java.util.regex.Pattern.compile("[0-9]");
        java.util.regex.Pattern pattern2 = java.util.regex.Pattern.compile("[a-eg-z]");
        java.util.regex.Pattern pattern3 = java.util.regex.Pattern.compile("[A-EG-Z]");

        //\u590D\u59D3\u7684\u6570\u7EC4
        String[] fuxing = {"\u4E07\u4FDF", "\u53F8\u9A6C", "\u4E0A\u5B98", "\u6B27\u9633", "\u590F\u4FAF", "\u8BF8\u845B", "\u95FB\u4EBA", "\u4E1C\u65B9", "\u8D6B\u8FDE", "\u7687\u752B", "\u7F8A\u820C", "\u5C09\u8FDF", "\u516C\u7F8A", "\u6FB9\u53F0", "\u516C\u51B6", "\u5B97\u6B63", "\u6FEE\u9633", "\u6DF3\u4E8E", "\u5355\u4E8E", "\u592A\u53D4", "\u7533\u5C60", "\u516C\u5B59", "\u4EF2\u5B59", "\u8F69\u8F95", "\u4EE4\u72D0", "\u949F\u79BB", "\u5B87\u6587", "\u957F\u5B59", "\u6155\u5BB9", "\u9C9C\u4E8E", "\u95FE\u4E18", "\u53F8\u5F92", "\u53F8\u7A7A", "\u5140\u5B98", "\u53F8\u5BC7", "\u5357\u95E8", "\u547C\u5EF6", "\u5B50\u8F66", "\u989B\u5B59", "\u7AEF\u6728", "\u5DEB\u9A6C", "\u516C\u897F", "\u6F06\u96D5", "\u8F66\u6B63", "\u58E4\u9A77", "\u516C\u826F", "\u62D3\u8DCB", "\u5939\u8C37", "\u5BB0\u7236", "\u8C37\u6881", "\u6BB5\u5E72", "\u767E\u91CC", "\u4E1C\u90ED", "\u5FAE\u751F", "\u6881\u4E18", "\u5DE6\u4E18", "\u4E1C\u95E8", "\u897F\u95E8", "\u5357\u5BAB", "\u7B2C\u4E94", "\u516C\u4EEA", "\u516C\u4E58", "\u592A\u53F2", "\u4EF2\u957F", "\u53D4\u5B59", "\u5C48\u7A81", "\u5C14\u6731", "\u4E1C\u4E61", "\u76F8\u91CC", "\u80E1\u6BCD", "\u53F8\u57CE", "\u5F20\u5ED6", "\u96CD\u95E8", "\u6BCB\u4E18", "\u8D3A\u5170", "\u7DA6\u6BCB", "\u5C4B\u5E90", "\u72EC\u5B64", "\u5357\u90ED", "\u5317\u5BAB", "\u738B\u5B59"};
        String[] isName ={"\u8D75","\u94B1","\u5B59","\u674E","\u5468","\u5434","\u90D1","\u738B","\u51AF","\u9648","\u891A","\u536B","\u848B","\u6C88","\u97E9","\u6768","\u6731","\u79E6","\u5C24","\u8BB8",
                "\u4F55","\u5415","\u65BD","\u5F20","\u5B54","\u66F9","\u4E25","\u534E","\u91D1","\u9B4F","\u9676","\u59DC","\u621A","\u8C22","\u90B9","\u55BB","\u67CF","\u6C34","\u7AA6","\u7AE0","\u4E91","\u82CF","\u6F58","\u845B","\u595A","\u8303","\u5F6D","\u90CE",
                "\u9C81","\u97E6","\u660C","\u9A6C","\u82D7","\u51E4","\u82B1","\u65B9","\u4FDE","\u4EFB","\u8881","\u67F3","\u9146","\u9C8D","\u53F2","\u5510","\u8D39","\u5EC9","\u5C91","\u859B","\u96F7","\u8D3A","\u502A","\u6C64","\u6ED5","\u6BB7",
                "\u7F57","\u6BD5","\u90DD","\u90AC","\u5B89","\u5E38","\u4E50","\u4E8E","\u65F6","\u5085","\u76AE","\u535E","\u9F50","\u5EB7","\u4F0D","\u4F59","\u5143","\u535C","\u987E","\u5B5F","\u5E73","\u9EC4","\u548C",
                "\u7A46","\u8427","\u5C39","\u59DA","\u90B5","\u6E5B","\u6C6A","\u7941","\u6BDB","\u79B9","\u72C4","\u7C73","\u8D1D","\u660E","\u81E7","\u8BA1","\u4F0F","\u6210","\u6234","\u8C08","\u5B8B","\u8305","\u5E9E","\u718A","\u7EAA","\u8212",
                "\u5C48","\u9879","\u795D","\u8463","\u6881","\u675C","\u962E","\u84DD","\u95F5","\u5E2D","\u5B63","\u9EBB","\u5F3A","\u8D3E","\u8DEF","\u5A04","\u5371","\u6C5F","\u7AE5","\u989C","\u90ED","\u6885","\u76DB","\u6797","\u5201","\u949F",
                "\u5F90","\u90B1","\u9A86","\u9AD8","\u590F","\u8521","\u7530","\u6A0A","\u80E1","\u51CC","\u970D","\u865E","\u4E07","\u652F","\u67EF","\u661D","\u7BA1","\u5362","\u83AB","\u7ECF","\u623F","\u88D8","\u7F2A","\u5E72","\u89E3","\u5E94",
                "\u5B97","\u4E01","\u5BA3","\u8D32","\u9093","\u90C1","\u5355","\u676D","\u6D2A","\u5305","\u8BF8","\u5DE6","\u77F3","\u5D14","\u5409","\u94AE","\u9F9A","\u7A0B","\u5D47","\u90A2","\u6ED1","\u88F4","\u9646","\u8363","\u7FC1","\u8340",
                "\u7F8A","\u4E8E","\u60E0","\u7504","\u66F2","\u5BB6","\u5C01","\u82AE","\u7FBF","\u50A8","\u9773","\u6C72","\u90B4","\u7CDC","\u677E","\u4E95","\u6BB5","\u5BCC","\u5DEB","\u4E4C","\u7126","\u5DF4","\u5F13","\u7267","\u9697","\u5C71",
                "\u8C37","\u8F66","\u4FAF","\u5B93","\u84EC","\u5168","\u90D7","\u73ED","\u4EF0","\u79CB","\u4EF2","\u4F0A","\u5BAB","\u5B81","\u4EC7","\u683E","\u66B4","\u7518","\u94AD","\u5389","\u620E","\u7956","\u6B66","\u7B26","\u5218","\u666F",
                "\u8A79","\u675F","\u9F99","\u53F6","\u5E78","\u53F8","\u97F6","\u90DC","\u9ECE","\u84DF","\u6EA5","\u5370","\u5BBF","\u767D","\u6000","\u84B2","\u90B0","\u4ECE","\u9102","\u7D22","\u54B8","\u7C4D","\u8D56","\u5353","\u853A","\u5C60",
                "\u8499","\u6C60","\u4E54","\u9634","\u90C1","\u80E5","\u80FD","\u82CD","\u53CC","\u95FB","\u8398","\u515A","\u7FDF","\u8C2D","\u8D21","\u52B3","\u9004","\u59EC","\u7533","\u6276","\u5835","\u5189","\u5BB0","\u90E6","\u96CD","\u5374",
                "\u74A9","\u6851","\u6842","\u6FEE","\u725B","\u5BFF","\u901A","\u8FB9","\u6248","\u71D5","\u5180","\u6D66","\u5C1A","\u519C","\u6E29","\u522B","\u5E84","\u664F","\u67F4","\u77BF","\u960E","\u5145","\u6155","\u8FDE","\u8339","\u4E60",
                "\u5BA6","\u827E","\u9C7C","\u5BB9","\u5411","\u53E4","\u6613","\u614E","\u6208","\u5ED6","\u5EBE","\u7EC8","\u66A8","\u5C45","\u8861","\u6B65","\u90FD","\u803F","\u6EE1","\u5F18","\u5321","\u56FD","\u6587","\u5BC7","\u5E7F","\u7984",
                "\u9619","\u4E1C","\u6B27","\u6BB3","\u6C83","\u5229","\u851A","\u8D8A","\u5914","\u9686","\u5E08","\u5DE9","\u538D","\u8042","\u6641","\u52FE","\u6556","\u878D","\u51B7","\u8A3E","\u8F9B","\u961A","\u90A3","\u7B80","\u9976","\u7A7A",
                "\u66FE","\u6BCB","\u6C99","\u4E5C","\u517B","\u97A0","\u987B","\u4E30","\u5DE2","\u5173","\u84AF","\u76F8","\u67E5","\u540E","\u8346","\u7EA2","\u6E38","\u90CF","\u7AFA","\u6743","\u902F","\u76D6","\u76CA","\u6853","\u516C","\u4EC9",
                "\u7763","\u5CB3","\u5E05","\u7F11","\u4EA2","\u51B5","\u90C8","\u6709","\u7434","\u5F52","\u6D77","\u664B","\u695A","\u95EB","\u6CD5","\u6C5D","\u9122","\u6D82","\u94A6","\u5546","\u725F","\u4F58","\u4F74","\u4F2F","\u8D4F","\u58A8",
                "\u54C8","\u8C2F","\u7BC1","\u5E74","\u7231","\u9633","\u4F5F","\u8A00","\u798F","\u5357","\u706B","\u94C1","\u8FDF","\u6F06","\u5B98","\u51BC","\u771F","\u5C55","\u7E41","\u6A80","\u796D","\u5BC6","\u656C","\u63ED","\u821C","\u697C",
                "\u758F","\u5192","\u6D51","\u631A","\u80F6","\u968F","\u9AD8","\u768B","\u539F","\u79CD","\u7EC3","\u5F25","\u4ED3","\u772D","\u8E47","\u8983","\u963F","\u95E8","\u607D","\u6765","\u7DA6","\u53EC","\u4EEA","\u98CE","\u4ECB","\u5DE8",
                "\u6728","\u4EAC","\u72D0","\u90C7","\u864E","\u679A","\u6297","\u8FBE","\u675E","\u82CC","\u6298","\u9EA6","\u5E86","\u8FC7","\u7AF9","\u7AEF","\u9C9C","\u7687","\u4E93","\u8001","\u662F","\u79D8","\u7545","\u909D","\u8FD8","\u5BBE",
                "\u95FE","\u8F9C","\u7EB5","\u4FB4"};
        //\u5355\u59D3\uFF08\u5220\u9664\u4E0D\u5E38\u89C1\u59D3\u6C0F PS:\u5220\u4E86\u597D\u591A\uFF09
        String[] laName = {"\u8D75", "\u94B1", "\u5B59", "\u674E", "\u5468", "\u5434", "\u90D1", "\u738B", "\u51AF", "\u9648", "\u848B", "\u6C88", "\u97E9", "\u6768", "\u6731", "\u79E6", "\u8BB8", "\u5F20", "\u5B54", "\u66F9", "\u4E25", "\u534E", "\u91D1", "\u9B4F", "\u59DC", "\u5F6D", "\u9C81", "\u9A6C", "\u8881", "\u67F3", "\u53F2", "\u5510", "\u859B", "\u7F57", "\u9F50", "\u5143", "\u5B5F", "\u9EC4", "\u5C39", "\u90B5", "\u6BDB", "\u5B8B", "\u5E9E", "\u718A", "\u7EAA", "\u8463", "\u6881", "\u675C", "\u962E", "\u8D3E", "\u6C5F", "\u90ED", "\u6797", "\u949F", "\u5F90", "\u9AD8", "\u590F", "\u8521", "\u7530", "\u80E1", "\u970D", "\u5362", "\u4E01", "\u9093", "\u6D2A", "\u5305", "\u77F3", "\u5D14", "\u7A0B", "\u9646", "\u7126", "\u5218", "\u53F6", "\u7533", "\u725B", "\u4E60", "\u5173", "\u5CB3", "\u695A", "\u4F5F", "\u9AD8"};
        //\u540D\u5E93
        String[] fiName = {"\u7F08", "\u9038", "\u77BB", "\u6E0A", "\u6696", "\u6E05", "\u89C2", "\u5D27", "\u9065", "\u5D34", "\u5D0E", "\u817E", "\u5D07", "\u98DE", "\u559C", "\u98D8", "\u5584", "\u77E5", "\u5578", "\u90A6", "\u662D", "\u5DE7", "\u771F", "\u6625", "\u7F8E", "\u6EAA", "\u6636", "\u660A", "\u6E90", "\u660E", "\u660C", "\u6606", "\u6619", "\u661F", "\u6613", "\u7FBF", "\u5546", "\u5DDE", "\u5DDD", "\u7FBD", "\u6615", "\u666F", "\u6668", "\u987A", "\u7FCE", "\u7FD4", "\u552F", "\u6EE1", "\u667A", "\u6674", "\u5524", "\u664B", "\u5510", "\u665F", "\u6656", "\u7FFC", "\u6653", "\u81EA", "\u7687", "\u8896", "\u99A8", "\u8000", "\u5C71", "\u768E", "\u7693", "\u54F2", "\u8018", "\u6797", "\u679C", "\u6781", "\u803F", "\u803D", "\u678B", "\u9999", "\u67F3", "\u76CA", "\u76C8", "\u805A", "\u67EF", "\u76DB", "\u67D4", "\u806A", "\u5C18", "\u5C1A", "\u67DA", "\u5496", "\u5C0A", "\u76FC", "\u67CF", "\u76F8", "\u8083", "\u5468", "\u5CF0", "\u673D", "\u5CFB", "\u6731", "\u5CEA", "\u6714", "\u6708", "\u7EA2", "\u670B", "\u7EAA", "\u7EAF", "\u542F", "\u677E", "\u5CB3", "\u7ED8", "\u6770", "\u7EC7", "\u80DC", "\u5CA9", "\u7EF4", "\u5409", "\u91D1", "\u5C9A", "\u767D", "\u767E", "\u674E", "\u674F", "\u7678", "\u541B", "\u91CD", "\u91CA", "\u7EE9", "\u5411", "\u8863", "\u7D2F", "\u4E7E", "\u57D4", "\u8BA1", "\u7D2B", "\u6C1B", "\u8BA2", "\u8BAD", "\u75BE", "\u8BAF", "\u6C14", "\u7D22", "\u6C11", "\u7D20", "\u4E66", "\u57CE", "\u8BBE", "\u8BBF", "\u8BB8", "\u4E60", "\u8BBA", "\u5F6D", "\u4E5D", "\u57F4", "\u5F6C", "\u5F69", "\u4E58", "\u6C38", "\u5F6A", "\u5F64", "\u4E54", "\u5F66", "\u4E56", "\u57F9", "\u4E50", "\u4E53", "\u57FA", "\u4E52", "\u4E49", "\u8309", "\u4E45", "\u8304", "\u8305", "\u758F", "\u5F77", "\u5F70", "\u8302", "\u8303", "\u5F71", "\u8301", "\u4E3B", "\u4E3A", "\u5F08", "\u6C5F", "\u9AD8", "\u4E32", "\u4E30", "\u8BED", "\u8377", "\u4E34", "\u5782", "\u5F18", "\u578B", "\u6C40", "\u8363", "\u4E19", "\u4E18", "\u8BC1", "\u4E1A", "\u8BC0", "\u6C7D", "\u4E1C", "\u8BC6", "\u6C7E", "\u4E1E", "\u8BC4", "\u6C74", "\u5F27", "\u8BCD", "\u5F26", "\u4E16", "\u5F3A", "\u57A3", "\u8BD7", "\u6C60", "\u8BDA", "\u4E03", "\u4E07", "\u5FC6", "\u4EF7", "\u5FC5", "\u753A", "\u4EF2", "\u575A", "\u6C90", "\u4EF0", "\u7532", "\u6C9B", "\u7533", "\u4EFB", "\u7530", "\u6C99", "\u5FD7", "\u6C85", "\u6C83", "\u6C82", "\u574A", "\u6C81", "\u5747", "\u83AB", "\u6C88", "\u751C", "\u4ED5", "\u751F", "\u7518", "\u5FE0", "\u4ED1", "\u751A", "\u6CB3", "\u4ED3", "\u6CBC", "\u6CBD", "\u6CBE", "\u6CBF", "\u6CB8", "\u5FF5", "\u6CA7", "\u4EC1", "\u576A", "\u5FFD", "\u5764", "\u6CD3", "\u4EB3", "\u83F2", "\u5F81", "\u4EA6", "\u4EAB", "\u5703", "\u6CCA", "\u6CC9", "\u4EA9", "\u5F99", "\u4EA8", "\u5F98", "\u5706", "\u4EAE", "\u4EAD", "\u7565", "\u4EAC", "\u5F9C", "\u6CF0", "\u4E91", "\u7559", "\u5FA1", "\u573A", "\u6CF3", "\u5730", "\u5FA8", "\u4E9A", "\u9A70", "\u5733", "\u6CFD", "\u6CE2", "\u572D", "\u6CE5", "\u754C", "\u5FB7", "\u9A6C", "\u4E89", "\u6CE8", "\u4E8B", "\u5723", "\u7545", "\u4E8E", "\u822C", "\u6597", "\u822A", "\u4F69", "\u6D0B", "\u6599", "\u4F7F", "\u6587", "\u6D1B", "\u8239", "\u8237", "\u8236", "\u6D17", "\u56DE", "\u4F73", "\u820D", "\u4F4F", "\u5E7C", "\u4F4D", "\u5E7D", "\u6D2A", "\u5E78", "\u56E0", "\u65B0", "\u5E76", "\u5E74", "\u65BD", "\u6D25", "\u5E73", "\u748B", "\u65B9", "\u65A7", "\u6D3E", "\u821F", "\u6D3D", "\u4F5B", "\u4F59", "\u56FE", "\u56FD", "\u4F55", "\u6D35", "\u8A89", "\u56FA", "\u6D32", "\u4F51", "\u65A9", "\u4F50", "\u8212", "\u5E1B", "\u826F", "\u5E1D", "\u74E6", "\u6D4E", "\u4F2F", "\u4F20", "\u6D41", "\u7C73", "\u6D45", "\u4F26", "\u4F27", "\u6D59", "\u5E08", "\u4F3A", "\u6D5A", "\u65C5", "\u827E", "\u5E0C", "\u5E03", "\u65CB", "\u5E02", "\u5E05", "\u4F34", "\u65CF", "\u5E06", "\u6D6A", "\u4F0A", "\u5E38", "\u6D69", "\u65F6", "\u65F7", "\u4F0F", "\u4F0D", "\u65FA", "\u6D63", "\u4F01", "\u6D66", "\u65E2", "\u4F1F", "\u65E6", "\u5E2D", "\u65E5", "\u65E9", "\u65E8", "\u6D77", "\u4F17", "\u65ED", "\u6D85", "\u4FE1", "\u742A", "\u82AF", "\u82AE", "\u82AD", "\u4FEF", "\u82AC", "\u4FEE", "\u7426", "\u82AB", "\u7422", "\u82B7", "\u82B3", "\u4FF1", "\u6D93", "\u82B1", "\u82BD", "\u6500", "\u5EC9", "\u82B8", "\u6D9B", "\u82B9", "\u7C97", "\u653F", "\u6DA6", "\u5EF6", "\u653E", "\u7C92", "\u7409", "\u8282", "\u828D", "\u4FCF", "\u7406", "\u6536", "\u4FCA", "\u5EFA", "\u828A", "\u4FD7", "\u8292", "\u4FD0", "\u4FDE", "\u829D", "\u4FDD", "\u8A00", "\u8299", "\u7C89", "\u5609", "\u82E5", "\u5E9A", "\u5E9C", "\u4FAF", "\u6556", "\u6548", "\u82F1", "\u747E", "\u5E86", "\u654F", "\u6DD8", "\u5E8A", "\u82F9", "\u6545", "\u4FBF", "\u6DE1", "\u5EB7", "\u5EB6", "\u5EB8", "\u5EBE", "\u4F8D", "\u82D1", "\u82D3", "\u6DF1", "\u82D4", "\u5EA6", "\u745E", "\u5EA7", "\u82D7", "\u5EAD", "\u4F9D", "\u592E", "\u51B6", "\u5929", "\u946B", "\u51B0", "\u592A", "\u51B2", "\u51AC", "\u73CD", "\u73CF", "\u73C8", "\u73CA", "\u73C0", "\u51A0", "\u62F3", "\u5907", "\u8DEF", "\u519B", "\u62C9", "\u590F", "\u590D", "\u5192", "\u62C2", "\u591A", "\u62D3", "\u73E0", "\u8D8A", "\u7B03", "\u5962", "\u51FA", "\u5965", "\u51FD", "\u51F0", "\u8D85", "\u7396", "\u7B11", "\u7389", "\u51EF", "\u7B19", "\u62B1", "\u51E1", "\u7B1B", "\u7384", "\u597D", "\u7387", "\u73BB", "\u5942", "\u7B20", "\u5947", "\u594B", "\u73AB", "\u51CC", "\u5954", "\u5955", "\u51C0", "\u51C6", "\u8D44", "\u6267", "\u94ED", "\u626C", "\u9C7C", "\u94F6", "\u627F", "\u8D64", "\u6247", "\u624D", "\u5982", "\u94C1", "\u5999", "\u5171", "\u59EC", "\u5175", "\u5176", "\u5177", "\u5178", "\u94A6", "\u517C", "\u59FF", "\u5168", "\u516D", "\u8D1D", "\u8D21", "\u8D22", "\u8D24", "\u6210", "\u8D35", "\u5146", "\u949F", "\u514B", "\u5149", "\u6B66", "\u6B65", "\u6B63", "\u957F", "\u50B2", "\u6B4C", "\u955C", "\u7A79", "\u7A7A", "\u9547", "\u5806", "\u5802", "\u6B22", "\u6B23", "\u6B27", "\u7281", "\u9526", "\u7A0B", "\u9510", "\u8427", "\u950B", "\u7ADF", "\u6377", "\u6BEB", "\u7AD9", "\u95FB", "\u5029", "\u95F2", "\u84DD", "\u95EE", "\u8C46", "\u95E8", "\u7ACB", "\u95EA", "\u503C", "\u7AFF", "\u7267", "\u7AF9", "\u7261", "\u7AFA", "\u500D", "\u6BC5", "\u7269", "\u7AE0", "\u8C6A", "\u8C6B", "\u501A", "\u5883", "\u5065", "\u58EE", "\u632F", "\u8C37", "\u631A", "\u8C26", "\u6853", "\u539A", "\u6851", "\u8FEA", "\u6850", "\u9645", "\u7965", "\u6854", "\u8776", "\u6842", "\u6843", "\u797A", "\u8FC1", "\u8FC5", "\u6866", "\u8FDC", "\u8FD0", "\u795E", "\u795F", "\u6817", "\u6089", "\u6811", "\u9614", "\u6807", "\u609F", "\u5B57", "\u8FBE", "\u793E", "\u5B5F", "\u5B5D", "\u53C2", "\u8FB0", "\u7199", "\u9621", "\u8F89", "\u5B63", "\u53F6", "\u60A0", "\u9633", "\u718A", "\u9EA6", "\u53E4", "\u6829", "\u5B8B", "\u5B89", "\u79EF", "\u5B8F", "\u5317", "\u96C0", "\u96C1", "\u8F69", "\u5B81", "\u79E6", "\u5B87", "\u6052", "\u5B99", "\u7167", "\u5B9E", "\u5B9D", "\u5B9C", "\u8F7B", "\u5B97", "\u9E4F", "\u96EA", "\u79C9", "\u96E8", "\u5BAB", "\u79CB", "\u79C0", "\u6069", "\u5BA2", "\u5BA3", "\u715C", "\u9E7F", "\u9E64", "\u79D1", "\u68E0", "\u5357", "\u5353", "\u9686", "\u5BC2", "\u535A", "\u6893", "\u5347", "\u79BE", "\u5343", "\u79B9", "\u534E", "\u6885", "\u601D", "\u5BD2", "\u6881", "\u5349", "\u798F", "\u5377", "\u6021", "\u9E3D", "\u68A7", "\u536B", "\u9752", "\u70E8", "\u9756", "\u5A01", "\u529F", "\u8679", "\u70C8", "\u5A31", "\u61FF", "\u7855", "\u52A0", "\u864E", "\u52B2", "\u52B1", "\u9716", "\u70AC", "\u70AF", "\u52C9", "\u52CB", "\u70AB", "\u971C", "\u52C7", "\u9704", "\u9F99", "\u708E", "\u5A77", "\u7814", "\u52E4", "\u9F50", "\u5217", "\u6148", "\u521A", "\u521D", "\u707F", "\u97F3", "\u5229", "\u97F5", "\u97F6", "\u78CA", "\u97EC", "\u9F0E", "\u701A"};
        //\u7701
        String[] provinces = {"\u5409\u6797", "\u5E7F\u4E1C", "\u5C71\u4E1C", "\u6CB3\u5357", "\u6CB3\u5317", "\u56DB\u5DDD"};
        //\u7701\u4E0B\u9762\u7684\u5E02
        String[] jilin = {"\u5409\u6797\u5E02", "\u957F\u6625\u5E02", "\u767D\u5C71\u5E02", "\u5EF6\u8FB9\u5DDE", "\u767D\u57CE\u5E02", "\u677E\u539F\u5E02", "\u8FBD\u6E90\u5E02", "\u901A\u5316\u5E02", "\u56DB\u5E73\u5E02"};
        String[] guangdong = {"\u4E1C\u839E\u5E02", "\u5E7F\u5DDE\u5E02", "\u6DF1\u5733\u5E02", "\u60E0\u5DDE\u5E02", "\u6C5F\u95E8\u5E02", "\u73E0\u6D77\u5E02", "\u6C55\u5934\u5E02", "\u4F5B\u5C71\u5E02", "\u6E5B\u6C5F\u5E02", "\u6CB3\u6E90\u5E02", "\u8087\u5E86\u5E02", "\u6E05\u8FDC\u5E02", "\u6F6E\u5DDE\u5E02", "\u97F6\u5173\u5E02", "\u63ED\u9633\u5E02", "\u9633\u6C5F\u5E02", "\u6885\u5DDE\u5E02", "\u4E91\u6D6E\u5E02", "\u8302\u540D\u5E02", "\u6C55\u5C3E\u5E02"};
        String[] shandong = {"\u6D4E\u5357\u5E02", "\u9752\u5C9B\u5E02", "\u4E34\u6C82\u5E02", "\u6D4E\u5B81\u5E02", "\u83CF\u6CFD\u5E02", "\u70DF\u53F0\u5E02", "\u6DC4\u535A\u5E02", "\u6CF0\u5B89\u5E02", "\u6F4D\u574A\u5E02", "\u65E5\u7167\u5E02", "\u5A01\u6D77\u5E02", "\u6EE8\u5DDE\u5E02", "\u4E1C\u8425\u5E02", "\u804A\u57CE\u5E02", "\u5FB7\u5DDE\u5E02", "\u83B1\u829C\u5E02", "\u67A3\u5E84\u5E02"};
        String[] henan = {"\u90D1\u5DDE\u5E02", "\u5357\u9633\u5E02", "\u65B0\u4E61\u5E02", "\u5B89\u9633\u5E02", "\u6D1B\u9633\u5E02", "\u4FE1\u9633\u5E02", "\u5E73\u9876\u5C71\u5E02", "\u5468\u53E3\u5E02", "\u5546\u4E18\u5E02", "\u5F00\u5C01\u5E02", "\u7126\u4F5C\u5E02", "\u9A7B\u9A6C\u5E97\u5E02", "\u6FEE\u9633\u5E02", "\u4E09\u95E8\u5CE1\u5E02", "\u6F2F\u6CB3\u5E02", "\u8BB8\u660C\u5E02", "\u9E64\u58C1\u5E02"};
        String[] hebei = {"\u77F3\u5BB6\u5E84\u5E02", "\u5510\u5C71\u5E02", "\u4FDD\u5B9A\u5E02", "\u90AF\u90F8\u5E02", "\u90A2\u53F0\u5E02", "\u6CA7\u5DDE\u5E02", "\u79E6\u7687\u5C9B\u5E02", "\u5F20\u5BB6\u53E3\u5E02", "\u8861\u6C34\u5E02", "\u5ECA\u574A\u5E02", "\u627F\u5FB7\u5E02"};
        String[] sichuan = {"\u6210\u90FD\u5E02", "\u7EF5\u9633\u5E02", "\u5E7F\u5143\u5E02", "\u8FBE\u5DDE\u5E02", "\u5357\u5145\u5E02", "\u5FB7\u9633\u5E02", "\u5E7F\u5B89\u5E02", "\u963F\u575D\u5DDE", "\u5DF4\u4E2D\u5E02", "\u9042\u5B81\u5E02", "\u5185\u6C5F\u5E02", "\u51C9\u5C71\u5DDE", "\u6500\u679D\u82B1\u5E02", "\u81EA\u8D21\u5E02", "\u6CF8\u5DDE\u5E02", "\u96C5\u5B89\u5E02", "\u5B9C\u5BBE\u5E02", "\u8D44\u9633\u5E02", "\u7709\u5C71\u5E02", "\u7518\u5B5C\u5DDE"};
        //\u5E02\u4E0B\u9762\u7684\u533A\u548C\u53BF
        String[] beijing = {"\u671D\u9633\u533A", "\u6D77\u6DC0\u533A", "\u901A\u5DDE\u533A", "\u623F\u5C71\u533A", "\u4E30\u53F0\u533A", "\u660C\u5E73\u533A", "\u5927\u5174\u533A", "\u987A\u4E49\u533A", "\u897F\u57CE\u533A", "\u5EF6\u5E86\u53BF", "\u77F3\u666F\u5C71\u533A", "\u5BA3\u6B66\u533A", "\u6000\u67D4\u533A", "\u5D07\u6587\u533A", "\u5BC6\u4E91\u53BF", "\u4E1C\u57CE\u533A", "\u5E73\u8C37\u533A", "\u95E8\u5934\u6C9F\u533A"};
        //\u5409\u6797
        String[] changchun = {"\u5357\u5173\u533A", "\u5BBD\u57CE\u533A", "\u671D\u9633\u533A", "\u4E8C\u9053\u533A", "\u7EFF\u56ED\u533A", "\u53CC\u9633\u533A", "\u4E5D\u53F0\u533A", "\u6986\u6811\u5E02", "\u5FB7\u60E0\u5E02", "\u519C\u5B89\u53BF"};
        String[] jilins = {"\u8239\u8425\u533A", "\u9F99\u6F6D\u533A", "\u660C\u9091\u533A", "\u4E30\u6EE1\u533A", "\u6C38\u5409\u53BF", "\u78D0\u77F3\u5E02", "\u6866\u7538\u5E02", "\u86DF\u6CB3\u5E02", "\u8212\u5170\u5E02"};
        String[] baishan = {"\u629A\u677E\u53BF", "\u9756\u5B87\u53BF", "\u4E34\u6C5F\u5E02", "\u6D51\u6C5F\u533A"};
        String[] yanbian = {"\u5EF6\u5409\u5E02", "\u56FE\u4EEC\u5E02", "\u9F99\u4E95\u5E02", "\u548C\u9F99\u5E02", "\u6C6A\u6E05\u53BF", "\u5B89\u56FE\u53BF"};
        String[] baicheng = {"\u5927\u5B89\u5E02", "\u6D2E\u5317\u533A", "\u6D2E\u5357\u533A", "\u901A\u6986\u53BF", "\u9547\u8D49\u53BF"};
        String[] songyuan = {"\u6276\u4F59\u53BF", "\u5B81\u6C5F\u533A", "\u4E7E\u5B89\u53BF", "\u957F\u5CAD\u53BF"};
        String[] liaoyuan = {"\u9F99\u5C71\u533A", "\u897F\u5B89\u533A", "\u4E1C\u4E30\u53BF", "\u4E1C\u8FBD\u53BF"};
        String[] tonghua = {"\u4E1C\u660C\u533A", "\u4E8C\u9053\u6C5F\u533A", "\u901A\u5316\u53BF", "\u67F3\u6CB3\u53BF", "\u8F89\u5357\u53BF"};
        String[] siping = {"\u94C1\u897F\u533A", "\u94C1\u4E1C\u533A", "\u53CC\u8FBD\u5E02", "\u68A8\u6811\u53BF", "\u4F0A\u901A\u6EE1\u65CF\u81EA\u6CBB\u53BF", "\u516C\u4E3B\u5CAD\u5E02"};
        //\u5E7F\u4E1C
        String[] dongguan = {"\u839E\u57CE\u533A", "\u4E1C\u57CE\u533A", "\u5357\u57CE\u533A", "\u4E07\u6C5F\u533A"};
        String[] guangzhou = {"\u8D8A\u79C0\u533A", "\u8354\u6E7E\u533A", "\u6D77\u73E0\u533A", "\u5929\u6CB3\u533A", "\u767D\u4E91\u533A", "\u9EC4\u57D4\u533A", "\u841D\u5C97\u533A", "\u756A\u79BA\u533A", "\u82B1\u90FD\u533A", "\u5357\u6C99\u533A", "\u841D\u5C97\u533A", "\u589E\u57CE\u5E02", "\u4ECE\u5316\u5E02"};
        String[] shenzhen = {"\u5B9D\u5B89\u533A", "\u798F\u7530\u533A", "\u9F99\u5C97\u533A", "\u7F57\u6E56\u533A", "\u5357\u5C71\u533A", "\u76D0\u7530\u533A"};
        String[] huizhou = {"\u60E0\u57CE\u533A", "\u60E0\u9633\u533A", "\u60E0\u4E1C\u53BF", "\u535A\u7F57\u53BF", "\u9F99\u95E8\u53BF"};
        String[] jiangmen = {"\u84EC\u6C5F\u533A", "\u6C5F\u6D77\u533A", "\u65B0\u4F1A\u533A", "\u53F0\u5C71\u5E02", "\u5F00\u5E73\u5E02", "\u9E64\u5C71\u5E02", "\u6069\u5E73\u5E02"};
        String[] zhuahi = {"\u6597\u95E8\u533A", "\u91D1\u6E7E\u533A", "\u9999\u6D32\u533A"};
        String[] shantou = {"\u91D1\u5E73\u533A", "\u9F99\u6E56\u533A", "\u6F84\u6D77\u533A", "\u6FE0\u6C5F\u533A", "\u6F6E\u5357\u533A", "\u6F6E\u9633\u533A", "\u5357\u6FB3\u53BF"};
        String[] foshan = {"\u7985\u57CE\u533A", "\u5357\u6D77\u533A", "\u987A\u5FB7\u533A", "\u9AD8\u660E\u533A", "\u4E09\u6C34\u533A"};
        String[] zhanjiang = {"\u8D64\u574E\u533A", "\u96F7\u5DDE\u5E02", "\u5EC9\u6C5F\u5E02", "\u9EBB\u7AE0\u533A", "\u5761\u5934\u533A", "\u9042\u6EAA\u53BF", "\u5434\u5DDD\u5E02", "\u971E\u5C71\u533A", "\u5F90\u95FB\u53BF"};
        String[] heyuan = {"\u6E90\u57CE\u533A", "\u548C\u5E73\u53BF", "\u9F99\u5DDD\u53BF", "\u4E1C\u6E90\u53BF", "\u7D2B\u91D1\u53BF", "\u8FDE\u5E73\u53BF"};
        String[] zhaoqing = {"\u7AEF\u5DDE\u533A", "\u9F0E\u6E56\u533A", "\u9AD8\u8981\u533A", "\u5E7F\u5B81\u53BF", "\u6000\u96C6\u53BF", "\u5C01\u5F00\u53BF", "\u5FB7\u5E86\u53BF", "\u56DB\u4F1A\u533A"};
        String[] qingyuan = {"\u6E05\u57CE\u533A", "\u6E05\u65B0\u533A", "\u4F5B\u5188\u53BF", "\u9633\u5C71\u53BF", "\u82F1\u5FB7\u5E02", "\u8FDE\u5DDE\u5E02"};
        String[] chaozhou = {"\u6E58\u6865\u533A", "\u6F6E\u5B89\u533A", "\u67AB\u6EAA\u533A", "\u9976\u5E73\u53BF"};
        String[] meizhou = {"\u5174\u5B81\u5E02", "\u6885\u6C5F\u533A", "\u6885\u53BF\u533A", "\u5927\u57D4\u53BF", "\u4E30\u987A\u53BF", "\u4E94\u534E\u53BF", "\u5E73\u8FDC\u53BF", "\u8549\u5CAD\u53BF"};
        String[] shaoguan = {"\u6D48\u6C5F\u533A", "\u6B66\u6C5F\u533A", "\u66F2\u6C5F\u533A", "\u4E50\u660C\u5E02", "\u5357\u96C4\u5E02", "\u59CB\u5174\u53BF", "\u4EC1\u5316\u53BF", "\u7FC1\u6E90\u53BF", "\u65B0\u4E30\u53BF"};
        String[] jieyang = {"\u6995\u57CE\u533A", "\u63ED\u4E1C\u533A", "\u63ED\u897F\u53BF", "\u60E0\u6765\u53BF", "\u666E\u5B81\u5E02"};
        String[] yangjiang = {"\u6C5F\u57CE\u533A", "\u9633\u4E1C\u533A", "\u9633\u897F\u53BF", "\u9633\u6625\u5E02"};
        String[] yunfu = {"\u4E91\u57CE\u533A", "\u7F57\u5B9A\u5E02", "\u4E91\u5B89\u533A", "\u65B0\u5174\u53BF", "\u90C1\u5357\u53BF"};
        String[] maoming = {"\u8302\u5357\u533A", "\u7535\u767D\u533A", "\u9AD8\u5DDE\u5E02", "\u5316\u5DDE\u5E02", "\u4FE1\u5B9C\u5E02"};
        String[] shanwei = {"\u57CE\u533A", "\u9646\u4E30\u5E02", "\u6D77\u4E30\u53BF", "\u9646\u6CB3\u53BF"};
        //\u5C71\u4E1C
        String[] jinan = {"\u5386\u4E0B\u533A", "\u5E02\u4E2D\u533A", "\u69D0\u836B\u533A", "\u5929\u6865\u533A", "\u5386\u57CE\u533A", "\u957F\u6E05\u533A", "\u5E73\u9634\u53BF", "\u6D4E\u9633\u53BF", "\u5546\u6CB3\u53BF", "\u7AE0\u4E18\u5E02"};
        String[] qingdao = {"\u5E02\u5357\u533A", "\u5E02\u5317\u533A", "\u9EC4\u5C9B\u533A", "\u5D02\u5C71\u533A", "\u674E\u6CA7\u533A", "\u80F6\u5DDE\u5E02", "\u5373\u58A8\u5E02", "\u5E73\u5EA6\u5E02", "\u83B1\u897F\u5E02"};
        String[] liyi = {"\u5170\u5C71\u533A", "\u7F57\u5E84\u533A", "\u6CB3\u4E1C\u533A", "\u90EF\u57CE\u53BF", "\u5170\u9675\u53BF", "\u8392\u5357\u53BF", "\u6C82\u6C34\u53BF", "\u8499\u9634\u53BF", "\u5E73\u9091\u53BF", "\u8D39\u53BF", "\u6C82\u5357\u53BF", "\u4E34\u6CAD\u53BF"};
        String[] jining = {"\u4EFB\u57CE\u533A", "\u5156\u5DDE\u533A", "\u5FAE\u5C71\u53BF", "\u9C7C\u53F0\u53BF", "\u91D1\u4E61\u53BF", "\u5609\u7965\u53BF", "\u6C76\u4E0A\u53BF", "\u6CD7\u6C34\u53BF", "\u6881\u5C71\u53BF"};
        String[] heze = {"\u7261\u4E39\u533A", "\u5F00\u53D1\u533A", "\u5B9A\u9676\u533A", "\u5DE8\u91CE\u53BF", "\u66F9\u53BF", "\u6210\u6B66\u53BF", "\u5355\u53BF", "\u90D3\u57CE\u53BF", "\u9104\u57CE\u53BF", "\u4E1C\u660E\u53BF"};
        String[] yantai = {"\u829D\u7F58\u533A", "\u798F\u5C71\u533A", "\u725F\u5E73\u533A", "\u83B1\u5C71\u533A", "\u957F\u5C9B\u53BF", "\u9F99\u53E3\u5E02", "\u83B1\u9633\u5E02", "\u83B1\u5DDE\u5E02", "\u84EC\u83B1\u5E02", "\u62DB\u8FDC\u5E02", "\u6816\u971E\u5E02", "\u6D77\u9633\u5E02"};
        String[] zibo = {"\u5F20\u5E97\u533A", "\u6DC4\u5DDD\u533A", "\u535A\u5C71\u533A", "\u5468\u6751\u533A", "\u4E34\u6DC4\u533A", "\u6853\u53F0\u53BF", "\u9AD8\u9752\u53BF", "\u6C82\u6E90\u53BF"};
        String[] taian = {"\u6CF0\u5C71\u533A", "\u5CB1\u5CB3\u533A", "\u65B0\u6CF0\u5E02", "\u80A5\u57CE\u5E02", "\u5B81\u9633\u53BF", "\u4E1C\u5E73\u53BF"};
        String[] weifang = {"\u6F4D\u57CE\u533A", "\u594E\u6587\u533A", "\u574A\u5B50\u533A", "\u5BD2\u4EAD\u533A", "\u9752\u5DDE\u5E02", "\u8BF8\u57CE\u5E02", "\u5BFF\u5149\u5E02", "\u5B89\u4E18\u5E02", "\u9AD8\u5BC6\u5E02", "\u660C\u9091\u5E02", "\u660C\u4E50\u53BF", "\u4E34\u6710\u53BF"};
        String[] rizhao = {"\u4E1C\u6E2F\u533A", "\u5C9A\u5C71\u533A", "\u8392\u53BF", "\u4E94\u83B2\u53BF"};
        String[] weihai = {"\u6587\u767B\u533A", "\u5357\u6D77\u65B0\u533A", "\u8363\u6210\u5E02", "\u4E73\u5C71\u5E02"};
        String[] bingzhou = {"\u6EE8\u57CE\u533A", "\u6CBE\u5316\u533A", "\u90B9\u5E73\u53BF", "\u535A\u5174\u53BF", "\u60E0\u6C11\u53BF", "\u9633\u4FE1\u53BF", "\u65E0\u68E3\u53BF"};
        String[] dongying = {"\u4E1C\u8425\u533A", "\u6CB3\u53E3\u533A", "\u5E7F\u9976\u53BF", "\u57A6\u5229\u53BF", "\u5229\u6D25\u53BF"};
        String[] liaocheng = {"\u4E1C\u660C\u5E9C\u533A", "\u5F00\u53D1\u533A", "\u4E34\u6E05\u5E02", "\u830C\u5E73", "\u4E1C\u963F", "\u9AD8\u5510", "\u9633\u8C37", "\u51A0\u53BF", "\u8398\u53BF", "\u83B1\u5DDE\u5E02", "\u84EC\u83B1\u5E02", "\u62DB\u8FDC\u5E02", "\u6816\u971E\u5E02", "\u6D77\u9633\u5E02"};
        String[] dezhou = {"\u9675\u57CE\u533A", "\u79B9\u57CE\u5E02", "\u4E50\u9675\u5E02", "\u4E34\u9091\u53BF", "\u5E73\u539F\u53BF", "\u590F\u6D25\u53BF", "\u6B66\u57CE\u53BF", "\u5E86\u4E91\u53BF", "\u5B81\u6D25\u53BF", "\u9F50\u6CB3\u53BF"};
        String[] laiwu = {"\u83B1\u57CE\u533A", "\u94A2\u57CE\u533A"};
        String[] zaozhuang = {"\u859B\u57CE\u533A", "\u5E02\u4E2D\u533A", "\u5CC4\u57CE\u533A", "\u5C71\u4EAD\u533A", "\u53F0\u513F\u5E84\u533A", "\u6ED5\u5DDE\u5E02"};
        //\u6CB3\u5357
        String[] zhengzhou = {"\u4E2D\u539F\u533A", "\u4E8C\u4E03\u533A", "\u7BA1\u57CE\u56DE\u65CF\u533A", "\u91D1\u6C34\u533A", "\u4E0A\u8857\u533A", "\u60E0\u6D4E\u533A", "\u4E2D\u725F\u53BF", "\u5DE9\u4E49\u5E02", "\u8365\u9633\u5E02", "\u65B0\u5BC6\u5E02", "\u65B0\u90D1\u5E02", "\u767B\u5C01\u5E02"};
        String[] nanyang = {"\u5B9B\u57CE\u533A", "\u5367\u9F99\u533A", "\u5357\u53EC\u53BF", "\u9547\u5E73\u53BF", "\u5185\u4E61\u53BF", "\u6DC5\u5DDD\u53BF", "\u65B0\u91CE\u53BF", "\u5510\u6CB3\u53BF", "\u6850\u67CF\u53BF", "\u65B9\u57CE\u53BF", "\u897F\u5CE1\u53BF", "\u793E\u65D7\u53BF"};
        String[] xinxiang = {"\u536B\u6EE8\u533A", "\u7EA2\u65D7\u533A", "\u51E4\u6CC9\u533A", "\u7267\u91CE\u533A", "\u536B\u8F89\u5E02", "\u8F89\u53BF\u5E02", "\u65B0\u4E61\u53BF", "\u83B7\u5609\u53BF", "\u539F\u9633\u53BF", "\u5EF6\u6D25\u53BF", "\u5C01\u4E18\u53BF"};
        String[] anyang = {"\u6587\u5CF0\u533A", "\u5317\u5173\u533A", "\u6BB7\u90FD\u533A", "\u9F99\u5B89\u533A", "\u5B89\u9633\u53BF", "\u6C64\u9634\u53BF", "\u5185\u9EC4\u53BF", "\u6797\u5DDE\u5E02"};
        String[] luoyang = {"\u6DA7\u897F\u533A", "\u897F\u5DE5\u533A", "\u8001\u57CE\u533A", "\u6D1B\u9F99\u533A", "\u5409\u5229\u533A", "\u5043\u5E08\u5E02", "\u5B5F\u6D25\u53BF", "\u65B0\u5B89\u53BF", "\u5B9C\u9633\u53BF", "\u4F0A\u5DDD\u53BF", "\u6D1B\u5B81\u53BF", "\u5D69\u53BF", "\u683E\u5DDD\u53BF", "\u6C5D\u9633\u53BF"};
        String[] xinyang = {"\u6D49\u6CB3\u533A", "\u5E73\u6865\u533A", "\u606F\u53BF", "\u65B0\u53BF", "\u7F57\u5C71\u53BF", "\u6F62\u5DDD\u53BF", "\u5149\u5C71\u53BF", "\u5546\u57CE\u53BF", "\u56FA\u59CB\u53BF", "\u6DEE\u6EE8\u53BF"};
        String[] pingdingshan = {"\u8F96\u65B0\u534E\u533A", "\u536B\u4E1C\u533A", "\u6E5B\u6CB3\u533A", "\u77F3\u9F99\u533A", "\u821E\u94A2\u5E02", "\u53F6\u53BF", "\u9C81\u5C71", "\u5B9D\u4E30", "\u90CF\u53BF"};
        String[] zhoukou = {"\u5DDD\u6C47\u533A", "\u6276\u6C9F\u53BF", "\u897F\u534E\u53BF", "\u5546\u6C34\u53BF", "\u6C88\u4E18\u53BF", "\u90F8\u57CE\u53BF", "\u6DEE\u9633\u53BF", "\u592A\u5EB7\u53BF", "\u9E7F\u9091\u53BF", "\u9879\u57CE\u5E02"};
        String[] shangqiu = {"\u6C38\u57CE\u5E02", "\u7762\u9633\u533A", "\u6881\u56ED\u533A", "\u5546\u4E18\u65B0\u533A", "\u865E\u57CE\u53BF", "\u67D8\u57CE\u53BF", "\u590F\u9091\u53BF", "\u6C11\u6743\u53BF", "\u7762\u53BF", "\u5B81\u9675\u53BF"};
        String[] kaifeng = {"\u9F13\u697C\u533A", "\u9F99\u4EAD\u533A", "\u79B9\u738B\u53F0\u533A", "\u5170\u8003\u53BF", "\u675E\u53BF", "\u901A\u8BB8\u53BF"};
        String[] jiaozuo = {"\u89E3\u653E\u533A", "\u4E2D\u7AD9\u533A", "\u9A6C\u6751\u533A", "\u5C71\u9633\u533A", "\u4FEE\u6B66\u53BF", "\u535A\u7231\u53BF", "\u6B66\u965F\u53BF", "\u6E29\u53BF", "\u6C81\u9633\u5E02", "\u5B5F\u5DDE\u5E02"};
        String[] zhumadian = {"\u9A7F\u57CE\u533A", "\u786E\u5C71\u53BF", "\u6CCC\u9633\u53BF", "\u9042\u5E73\u53BF", "\u897F\u5E73\u53BF", "\u4E0A\u8521\u53BF", "\u6C5D\u5357\u53BF", "\u5E73\u8206\u53BF", "\u6B63\u9633\u53BF"};
        String[] puyang = {"\u534E\u9F99\u533A", "\u5F00\u53D1\u533A", "\u6FEE\u9633\u53BF", "\u6E05\u4E30\u53BF", "\u5357\u4E50\u53BF", "\u8303\u53BF", "\u53F0\u524D\u53BF"};
        String[] sanxiamen = {"\u6E56\u6EE8\u533A", "\u6E11\u6C60\u53BF", "\u9655\u5DDE\u533A", "\u5362\u6C0F\u53BF", "\u4E49\u9A6C\u5E02", "\u7075\u5B9D\u5E02"};
        String[] luohe = {"\u4E34\u988D\u53BF", "\u821E\u9633\u53BF", "\u90FE\u57CE\u533A", "\u6E90\u6C47\u533A", "\u53EC\u9675\u533A"};
        String[] xuchang = {"\u9B4F\u90FD\u533A", "\u8BB8\u660C\u53BF", "\u9122\u9675\u53BF", "\u8944\u57CE\u53BF", "\u79B9\u5DDE\u5E02", "\u957F\u845B\u5E02"};
        String[] hebi = {"\u6DC7\u6EE8\u533A", "\u5C71\u57CE\u533A", "\u9E64\u5C71\u533A", "\u6DC7\u53BF", "\u6D5A\u53BF"};
        //\u6CB3\u5317
        String[] shijiazhuang = {"\u65B0\u534E\u533A", "\u6865\u897F\u533A", "\u957F\u5B89\u533A", "\u88D5\u534E\u533A", "\u77FF\u533A", "\u85C1\u57CE\u533A", "\u9E7F\u6CC9\u533A", "\u683E\u57CE\u533A", "\u8F9B\u96C6\u5E02", "\u664B\u5DDE\u5E02", "\u65B0\u4E50\u5E02", "\u6B63\u5B9A\u53BF", "\u6DF1\u6CFD\u53BF", "\u65E0\u6781\u53BF", "\u8D75\u53BF", "\u9AD8\u9091\u53BF", "\u5143\u6C0F\u53BF", "\u8D5E\u7687\u53BF", "\u4E95\u9649\u53BF", "\u5E73\u5C71\u53BF", "\u7075\u5BFF\u53BF", "\u884C\u5510\u53BF"};
        String[] tangshan = {"\u8DEF\u5357\u533A", "\u8DEF\u5317\u533A", "\u53E4\u51B6\u533A", "\u5F00\u5E73\u533A", "\u4E30\u5357\u533A", "\u4E30\u6DA6\u533A", "\u66F9\u5983\u7538\u533A", "\u6EE6\u53BF", "\u6EE6\u5357\u53BF", "\u4E50\u4EAD\u53BF", "\u8FC1\u897F\u53BF", "\u7389\u7530\u53BF", "\u9075\u5316\u5E02", "\u8FC1\u5B89\u5E02"};
        String[] baoding = {"\u5B9A\u5DDE\u5E02", "\u7ADE\u79C0\u533A", "\u83B2\u6C60\u533A", "\u6EE1\u57CE\u533A", "\u6E05\u82D1\u533A", "\u5F90\u6C34\u533A", "\u9AD8\u7891\u5E97\u5E02", "\u5B89\u56FD\u5E02", "\u6D9E\u6C34\u53BF", "\u5510\u53BF", "\u6613\u53BF", "\u6D9E\u6E90\u53BF", "\u5B9A\u5174\u53BF", "\u987A\u5E73\u53BF", "\u671B\u90FD\u53BF", "\u9AD8\u9633\u53BF", "\u5B89\u65B0\u53BF", "\u96C4\u53BF", "\u5BB9\u57CE\u53BF", "\u66F2\u9633\u53BF", "\u961C\u5E73\u53BF", "\u535A\u91CE\u53BF", "\u8821\u53BF"};
        String[] handan = {"\u90AF\u5C71\u533A", "\u4E1B\u53F0\u533A", "\u590D\u5174\u533A", "\u5CF0\u5CF0\u77FF\u533A", "\u90AF\u90F8\u53BF", "\u4E34\u6F33\u53BF", "\u6210\u5B89\u53BF", "\u5927\u540D\u53BF", "\u6D89\u53BF", "\u78C1\u53BF", "\u80A5\u4E61\u53BF", "\u6C38\u5E74\u53BF", "\u90B1\u53BF", "\u9E21\u6CFD\u53BF", "\u5E7F\u5E73\u53BF", "\u9986\u9676\u53BF", "\u9B4F\u53BF", "\u66F2\u5468\u53BF", "\u6B66\u5B89\u5E02"};
        String[] xingtai = {"\u6865\u4E1C\u533A", "\u6865\u897F\u533A", "\u5357\u5BAB\u5E02", "\u6C99\u6CB3\u5E02", "\u90A2\u53F0\u53BF", "\u67CF\u4E61\u53BF", "\u67CF\u4E61\u53BF", "\u5B81\u664B\u53BF", "\u9686\u5C27\u53BF", "\u4E34\u57CE\u53BF", "\u5E7F\u5B97\u53BF", "\u4E34\u897F\u53BF", "\u5185\u4E18\u53BF", "\u5E73\u4E61\u53BF", "\u5DE8\u9E7F\u53BF", "\u65B0\u6CB3\u53BF", "\u5357\u548C\u53BF"};
        String[] cangzhou = {"\u8FD0\u6CB3\u533A", "\u65B0\u534E\u533A", "\u6CCA\u5934\u5E02", "\u4EFB\u4E18\u5E02", "\u9EC4\u9A85\u5E02", "\u6CB3\u95F4\u5E02", "\u6CA7\u53BF", "\u9752\u53BF", "\u4E1C\u5149\u53BF", "\u6D77\u5174\u53BF", "\u76D0\u5C71\u53BF", "\u8083\u5B81\u53BF", "\u5357\u76AE\u53BF", "\u5434\u6865\u53BF", "\u732E\u53BF"};
        String[] qinhuangdao = {"\u6D77\u6E2F\u533A", "\u5C71\u6D77\u5173\u533A", "\u629A\u5B81\u533A", "\u5317\u6234\u6CB3\u533A", "\u9752\u9F99\u53BF", "\u660C\u9ECE\u53BF", "\u5362\u9F99\u53BF"};
        String[] zhangjiakou = {"\u6865\u897F\u533A", "\u6865\u4E1C\u533A", "\u4E0B\u82B1\u56ED\u533A", "\u5BA3\u5316\u533A", "\u4E07\u5168\u533A", "\u5D07\u793C\u533A", "\u5F20\u5317\u53BF", "\u5EB7\u4FDD\u53BF", "\u6CBD\u6E90\u53BF", "\u5C1A\u4E49\u53BF", "\u851A\u53BF", "\u9633\u539F\u53BF", "\u6000\u5B89\u53BF", "\u6000\u6765\u53BF", "\u6DBF\u9E7F\u53BF", "\u8D64\u57CE\u53BF"};
        String[] hengshui = {"\u6843\u57CE\u533A", "\u6EE8\u6E56\u65B0\u533A", "\u5DE5\u4E1A\u65B0\u533A", "\u5180\u5DDE", "\u6DF1\u5DDE", "\u67A3\u5F3A\u53BF", "\u6B66\u9091\u53BF", "\u6B66\u5F3A\u53BF", "\u9976\u9633\u53BF", "\u5B89\u5E73\u53BF", "\u6545\u57CE\u53BF", "\u961C\u57CE\u53BF", "\u666F\u53BF"};
        String[] langfang = {"\u4E09\u6CB3\u5E02", "\u9738\u5DDE\u5E02", "\u9999\u6CB3\u53BF", "\u56FA\u5B89\u53BF", "\u6C38\u6E05\u53BF", "\u6587\u5B89\u53BF", "\u5927\u57CE\u53BF", "\u5927\u5382\u56DE\u65CF\u81EA\u6CBB\u53BF"};
        String[] chengde = {"\u627F\u5FB7\u53BF", "\u9686\u5316\u53BF", "\u56F4\u573A\u53BF", "\u4E30\u5B81\u53BF", "\u6EE6\u5E73\u53BF", "\u5174\u9686\u53BF", "\u9752\u9F99\u53BF", "\u5E73\u6CC9\u53BF"};
        //\u56DB\u5DDD
        String[] chengdu = {"\u6B66\u4FAF\u533A", "\u9526\u6C5F\u533A", "\u9752\u7F8A\u533A", "\u91D1\u725B\u533A", "\u6210\u534E\u533A", "\u9F99\u6CC9\u9A7F\u533A", "\u6E29\u6C5F\u533A", "\u65B0\u90FD\u533A", "\u9752\u767D\u6C5F\u533A", "\u53CC\u6D41\u533A", "\u90EB\u53BF", "\u84B2\u6C5F\u53BF", "\u5927\u9091\u53BF", "\u91D1\u5802\u53BF", "\u65B0\u6D25\u53BF", "\u90FD\u6C5F\u5830\u5E02", "\u5F6D\u5DDE\u5E02", "\u909B\u5D03\u5E02", "\u5D07\u5DDE\u5E02", "\u7B80\u9633\u5E02"};
        String[] mianyang = {"\u6DAA\u57CE\u533A", "\u6E38\u4ED9\u533A", "\u5B89\u5DDE\u533A", "\u4E09\u53F0\u53BF", "\u76D0\u4EAD\u53BF", "\u6893\u6F7C\u53BF", "\u5E73\u6B66\u53BF", "\u6C5F\u6CB9\u5E02"};
        String[] guangyuan = {"\u5229\u5DDE\u533A", "\u662D\u5316\u533A", "\u671D\u5929\u533A", "\u65FA\u82CD\u53BF", "\u9752\u5DDD\u53BF", "\u5251\u9601\u53BF", "\u82CD\u6EAA\u53BF"};
        String[] dazhou = {"\u901A\u5DDD\u533A", "\u8FBE\u5DDD\u533A", "\u5BA3\u6C49\u53BF", "\u5F00\u6C5F\u53BF", "\u5927\u7AF9\u53BF", "\u6E20\u53BF", "\u4E07\u6E90\u5E02"};
        String[] nanyun = {"\u987A\u5E86\u533A", "\u9AD8\u576A\u533A", "\u5609\u9675\u533A", "\u897F\u5145\u53BF", "\u5357\u90E8\u53BF", "\u84EC\u5B89\u53BF", "\u8425\u5C71\u53BF", "\u4EEA\u9647\u53BF", "\u9606\u4E2D\u5E02"};
        String[] deyang = {"\u65CC\u9633\u533A", "\u4EC0\u90A1\u5E02", "\u5E7F\u6C49\u5E02", "\u7EF5\u7AF9\u5E02", "\u7F57\u6C5F\u53BF", "\u4E2D\u6C5F\u53BF"};
        String[] guangan = {"\u5E7F\u5B89\u533A", "\u524D\u950B\u533A", "\u5CB3\u6C60\u53BF", "\u6B66\u80DC\u53BF", "\u90BB\u6C34\u53BF", "\u534E\u84E5\u5E02"};
        String[] aba = {"\u9A6C\u5C14\u5EB7\u5E02", "\u4E5D\u5BE8\u6C9F\u53BF", "\u5C0F\u91D1\u53BF", "\u963F\u575D\u53BF", "\u82E5\u5C14\u76D6\u53BF", "\u7EA2\u539F\u53BF", "\u58E4\u5858\u53BF", "\u6C76\u5DDD\u53BF", "\u7406\u53BF", "\u8302\u53BF", "\u677E\u6F58\u53BF", "\u91D1\u5DDD\u53BF", "\u9ED1\u6C34\u53BF"};
        String[] bazhong = {"\u5DF4\u5DDE\u533A", "\u6069\u9633\u533A", "\u901A\u6C5F\u53BF", "\u5357\u6C5F\u53BF", "\u5E73\u660C\u53BF"};
        String[] suining = {"\u8239\u5C71\u533A", "\u5B89\u5C45\u533A", "\u5C04\u6D2A\u53BF", "\u84EC\u6EAA\u53BF", "\u5927\u82F1\u53BF"};
        String[] neijiang = {"\u5E02\u4E2D\u533A", "\u4E1C\u5174\u533A", "\u8D44\u4E2D\u53BF", "\u5A01\u8FDC\u53BF", "\u9686\u660C\u53BF"};
        String[] liangshan = {"\u897F\u660C\u5E02", "\u76D0\u6E90\u53BF", "\u5FB7\u660C\u53BF", "\u4F1A\u7406\u53BF", "\u4F1A\u4E1C\u53BF", "\u5B81\u5357\u53BF", "\u666E\u683C\u53BF", "\u5E03\u62D6\u53BF", "\u91D1\u9633\u53BF", "\u662D\u89C9\u53BF", "\u559C\u5FB7\u53BF", "\u5195\u5B81\u53BF", "\u8D8A\u897F\u53BF", "\u7518\u6D1B\u53BF", "\u7F8E\u59D1\u53BF", "\u96F7\u6CE2\u53BF"};
        String[] panzhihua = {"\u4E1C\u533A", "\u897F\u533A", "\u4EC1\u548C\u533A", "\u7C73\u6613\u53BF", "\u76D0\u8FB9\u53BF"};
        String[] zigong = {"\u81EA\u6D41\u4E95\u533A", "\u8D21\u4E95\u533A", "\u5927\u5B89\u533A", "\u6CBF\u6EE9\u533A", "\u8363\u53BF", "\u5BCC\u987A\u53BF"};
        String[] luzhou = {"\u6C5F\u9633\u533A", "\u9F99\u9A6C\u6F6D\u533A", "\u7EB3\u6EAA\u533A", "\u7EB3\u6EAA\u533A", "\u6CF8\u53BF", "\u5408\u6C5F\u53BF", "\u53D9\u6C38\u53BF", "\u53E4\u853A\u53BF"};
        String[] yaan = {"\u96E8\u57CE\u533A", "\u540D\u5C71\u533A", "\u53BF\u8365\u7ECF\u53BF", "\u6C49\u6E90\u53BF", "\u77F3\u68C9\u53BF", "\u5929\u5168\u53BF", "\u82A6\u5C71\u53BF", "\u5B9D\u5174\u53BF"};

        String[] yibin = {"\u7FE0\u5C4F\u533A", "\u5357\u6EAA\u533A", "\u5B9C\u5BBE\u53BF", "\u6C5F\u5B89\u53BF", "\u957F\u5B81\u53BF", "\u9AD8\u53BF", "\u7B60\u8FDE\u53BF", "\u73D9\u53BF", "\u5174\u6587\u53BF", "\u5C4F\u5C71\u53BF"};
        String[] ziyang = {"\u96C1\u6C5F\u533A", "\u5B89\u5CB3\u53BF", "\u4E50\u81F3\u53BF"};
        String[] meishan = {"\u4E1C\u5761\u533A", "\u5F6D\u5C71\u533A", "\u4EC1\u5BFF\u53BF", "\u4E39\u68F1\u53BF", "\u9752\u795E\u53BF", "\u6D2A\u96C5\u53BF"};
        String[] ganzi = {"\u5EB7\u5B9A\u5E02", "\u6CF8\u5B9A\u53BF", "\u4E39\u5DF4\u53BF", "\u4E5D\u9F99\u53BF", "\u96C5\u6C5F\u53BF", "\u9053\u5B5A\u53BF", "\u7089\u970D\u53BF", "\u7518\u5B5C\u53BF", "\u65B0\u9F99\u53BF", "\u5FB7\u683C\u53BF", "\u767D\u7389\u53BF", "\u77F3\u6E20\u53BF", "\u8272\u8FBE\u53BF", "\u7406\u5858\u53BF", "\u5DF4\u5858\u53BF", "\u4E61\u57CE\u53BF", "\u7A3B\u57CE\u53BF", "\u5F97\u8363\u53BF"};

        java.util.HashMap shengTOshi = new java.util.HashMap();
        shengTOshi.put("\u5409\u6797", jilin);
        shengTOshi.put("\u5E7F\u4E1C", guangdong);
        shengTOshi.put("\u5C71\u4E1C", shandong);
        shengTOshi.put("\u6CB3\u5357", henan);
        shengTOshi.put("\u6CB3\u5317", hebei);
        shengTOshi.put("\u56DB\u5DDD", sichuan);

        java.util.HashMap shiTOqu = new java.util.HashMap();
        shiTOqu.put("\u5317\u4EAC", beijing);
//\u5409\u6797
        shiTOqu.put("\u5409\u6797\u5E02", jilins);
        shiTOqu.put("\u957F\u6625\u5E02", changchun);
        shiTOqu.put("\u767D\u5C71\u5E02", baishan);
        shiTOqu.put("\u5EF6\u8FB9\u5DDE", yanbian);
        shiTOqu.put("\u767D\u57CE\u5E02", baicheng);
        shiTOqu.put("\u677E\u539F\u5E02", songyuan);
        shiTOqu.put("\u8FBD\u6E90\u5E02", liaoyuan);
        shiTOqu.put("\u901A\u5316\u5E02", tonghua);
        shiTOqu.put("\u56DB\u5E73\u5E02", siping);
//\u5E7F\u4E1C
        shiTOqu.put("\u4E1C\u839E\u5E02", dongguan);
        shiTOqu.put("\u5E7F\u5DDE\u5E02", guangzhou);
        shiTOqu.put("\u6DF1\u5733\u5E02", shenzhen);
        shiTOqu.put("\u60E0\u5DDE\u5E02", huizhou);
        shiTOqu.put("\u6C5F\u95E8\u5E02", jiangmen);
        shiTOqu.put("\u73E0\u6D77\u5E02", zhuahi);
        shiTOqu.put("\u6C55\u5934\u5E02", shantou);
        shiTOqu.put("\u4F5B\u5C71\u5E02", foshan);
        shiTOqu.put("\u6E5B\u6C5F\u5E02", zhanjiang);
        shiTOqu.put("\u6CB3\u6E90\u5E02", heyuan);
        shiTOqu.put("\u8087\u5E86\u5E02", zhaoqing);
        shiTOqu.put("\u6E05\u8FDC\u5E02", qingyuan);
        shiTOqu.put("\u6F6E\u5DDE\u5E02", chaozhou);
        shiTOqu.put("\u6885\u5DDE\u5E02", meizhou);
        shiTOqu.put("\u97F6\u5173\u5E02", shaoguan);
        shiTOqu.put("\u63ED\u9633\u5E02", jieyang);
        shiTOqu.put("\u9633\u6C5F\u5E02", yangjiang);
        shiTOqu.put("\u4E91\u6D6E\u5E02", yunfu);
        shiTOqu.put("\u8302\u540D\u5E02", maoming);
        shiTOqu.put("\u6C55\u5C3E\u5E02", shanwei);
//\u5C71\u4E1C
        shiTOqu.put("\u6D4E\u5357\u5E02", jinan);
        shiTOqu.put("\u9752\u5C9B\u5E02", qingdao);
        shiTOqu.put("\u4E34\u6C82\u5E02", liyi);
        shiTOqu.put("\u6D4E\u5B81\u5E02", jining);
        shiTOqu.put("\u83CF\u6CFD\u5E02", heze);
        shiTOqu.put("\u70DF\u53F0\u5E02", yantai);
        shiTOqu.put("\u6DC4\u535A\u5E02", zibo);
        shiTOqu.put("\u6CF0\u5B89\u5E02", taian);
        shiTOqu.put("\u6F4D\u574A\u5E02", weifang);
        shiTOqu.put("\u65E5\u7167\u5E02", rizhao);
        shiTOqu.put("\u5A01\u6D77\u5E02", weihai);
        shiTOqu.put("\u6EE8\u5DDE\u5E02", bingzhou);
        shiTOqu.put("\u4E1C\u8425\u5E02", dongying);
        shiTOqu.put("\u804A\u57CE\u5E02", liaocheng);
        shiTOqu.put("\u5FB7\u5DDE\u5E02", dezhou);
        shiTOqu.put("\u83B1\u829C\u5E02", laiwu);
        shiTOqu.put("\u67A3\u5E84\u5E02", zaozhuang);
//\u6CB3\u5357
        shiTOqu.put("\u90D1\u5DDE\u5E02", zhengzhou);
        shiTOqu.put("\u5357\u9633\u5E02", nanyang);
        shiTOqu.put("\u65B0\u4E61\u5E02", xinxiang);
        shiTOqu.put("\u5B89\u9633\u5E02", anyang);
        shiTOqu.put("\u6D1B\u9633\u5E02", luoyang);
        shiTOqu.put("\u4FE1\u9633\u5E02", xinyang);
        shiTOqu.put("\u5E73\u9876\u5C71\u5E02", pingdingshan);
        shiTOqu.put("\u5468\u53E3\u5E02", zhoukou);
        shiTOqu.put("\u5546\u4E18\u5E02", shangqiu);
        shiTOqu.put("\u5F00\u5C01\u5E02", kaifeng);
        shiTOqu.put("\u7126\u4F5C\u5E02", jiaozuo);
        shiTOqu.put("\u9A7B\u9A6C\u5E97\u5E02", zhumadian);
        shiTOqu.put("\u6FEE\u9633\u5E02", puyang);
        shiTOqu.put("\u4E09\u95E8\u5CE1\u5E02", sanxiamen);
        shiTOqu.put("\u6F2F\u6CB3\u5E02", luohe);
        shiTOqu.put("\u8BB8\u660C\u5E02", xuchang);
        shiTOqu.put("\u9E64\u58C1\u5E02", hebi);
//\u6CB3\u5317
        shiTOqu.put("\u77F3\u5BB6\u5E84\u5E02", shijiazhuang);
        shiTOqu.put("\u5510\u5C71\u5E02", tangshan);
        shiTOqu.put("\u4FDD\u5B9A\u5E02", baoding);
        shiTOqu.put("\u90AF\u90F8\u5E02", handan);
        shiTOqu.put("\u90A2\u53F0\u5E02", xingtai);
        shiTOqu.put("\u6CA7\u5DDE\u5E02", cangzhou);
        shiTOqu.put("\u79E6\u7687\u5C9B\u5E02", qinhuangdao);
        shiTOqu.put("\u5F20\u5BB6\u53E3\u5E02", zhangjiakou);
        shiTOqu.put("\u8861\u6C34\u5E02", hengshui);
        shiTOqu.put("\u5ECA\u574A\u5E02", langfang);
        shiTOqu.put("\u627F\u5FB7\u5E02", chengde);
//\u56DB\u5DDD
        shiTOqu.put("\u6210\u90FD\u5E02", chengdu);
        shiTOqu.put("\u7EF5\u9633\u5E02", mianyang);
        shiTOqu.put("\u5E7F\u5143\u5E02", guangyuan);
        shiTOqu.put("\u8FBE\u5DDE\u5E02", dazhou);
        shiTOqu.put("\u5357\u5145\u5E02", nanyun);
        shiTOqu.put("\u5FB7\u9633\u5E02", deyang);
        shiTOqu.put("\u5E7F\u5B89\u5E02", guangan);
        shiTOqu.put("\u963F\u575D\u5DDE", aba);
        shiTOqu.put("\u5DF4\u4E2D\u5E02", bazhong);
        shiTOqu.put("\u9042\u5B81\u5E02", suining);
        shiTOqu.put("\u5185\u6C5F\u5E02", neijiang);
        shiTOqu.put("\u51C9\u5C71\u5DDE", liangshan);
        shiTOqu.put("\u6500\u679D\u82B1\u5E02", panzhihua);
        shiTOqu.put("\u81EA\u8D21\u5E02", zigong);
        shiTOqu.put("\u6CF8\u5DDE\u5E02", luzhou);
        shiTOqu.put("\u96C5\u5B89\u5E02", yaan);
        shiTOqu.put("\u5B9C\u5BBE\u5E02", yibin);
        shiTOqu.put("\u8D44\u9633\u5E02", ziyang);
        shiTOqu.put("\u7709\u5C71\u5E02", meishan);
        shiTOqu.put("\u7518\u5B5C\u5DDE", ganzi);
        //\u6CA1\u6709\u7701
        String[][] shi = {jilin, guangdong, shandong, henan, hebei, sichuan};

//\u4E0D\u505A\u6E05\u6D17\u7684\u5B57\u7B26\u4E32
        String[] noChange1 = {"\u53E4", "\u6C5F", "\u8857", "\u6B3E", "\u521D", "\u73ED", "\u996D", "\u671F", "\u5206", "\u5927", "\u9644", "\u5317", "\u7AD9", "\u5DE6", "\u5C6F", "\u574A", "\u5DF7", "\u57CE", "\u7701", "\u5382", "\u56DB", "\u4E61", "\u4E5D", "\u9662", "\u8DEF", "\u53BF", "\u533A", "\u56ED", "\u5BA4", "\u9547", "\u9762", "\u6865", "\u580D", "\u5C42", "\u5185", "\u5E62", "\u6D32", "\u5DDE", "\u53A6", "\u5BB6", "\u697C", "\u5357", "\u4FA7", "\u5E97", "\u524D", "\u90E8", "\u5F04", "\u65C1", "\u7EC4", "\u5E84", "\u6D5C", "\u5341", "\u6237", "\u4E2D", "\u793E", "\u8361", "\u516B", "\u5E02", "\u961F", "\u516D", "\u680B", "\u540E", "\u4E94", "\u4E1C", "\u53F7", "\u6751", "\u53F3", "\u7B2C", "\u82D1", "\u4E09", "\u897F", "\u5C0F", "\u5EA7", "\u73AF", "\u5BFA", "\u4E00", "\u4E03", "\u4E8C", "\u53E3", "\u59D4", "\u9053", "F", "~", "\uFF01", "@", "#", "\uFFE5", "%", "\u2026", "^", "\u2026\u2026", "&", "*", "\uFF08", "\uFF09", "\u2014", "\u2014", "+", "}", "{", "\uFF1A", "\u201C", "\u300B", "\u300A", "\uFF1F", "-", "(", ")", "."
        };
        String[] noChange2 = {"\u4E2D\u56FD","\u7AE5\u88C5","\u5546\u57CE","\u515A\u6821","\u4EE3\u53D1","\u4EA4\u6613","\u5EFA\u8BBE","\u623F\u95F4","\u7F51\u7EDC","\u6C7D\u8F66","\u6728\u4E1A","\u5BB6\u79C1","\u9152\u5E97","\u6C34\u679C","\u52D8\u5BDF","\u5DE5\u8D44","\u4FDD\u9669","\u94F6\u5DDD","\u7EF4\u4FEE","\u4EA4\u901A","\u56FD\u8D44","\u5DE5\u8D38","\u5B9E\u4E1A","\u4E8C\u624B","\u5206\u884C","\u6279\u53D1","\u5B89\u88C5","\u4FDD\u62A4","\u98DF\u5802","\u751F\u80B2","\u65C5\u6E38","\u5BBF\u820D","\u5C0F\u989D","\u7535\u5668","\u7EC4\u7EC7","\u8BA1\u5212","\u5DE5\u7A0B","\u76D1\u7763","\u5B9E\u9A8C","\u519C\u573A","\u5B75\u5316","\u536B\u751F","\u7EFC\u5408","\u79D1\u6280","\u6267\u6CD5","\u8FD0\u8425","\u6E05\u771F","\u7801\u5934","\u8D22\u653F","\u7CAE\u6CB9","\u7BA1\u7406","\u5206\u5C40","\u5546\u4E1A","\u6587\u5316","\u5E7F\u64AD","\u5355\u5143","\u5370\u5237","\u5F00\u53D1","\u793A\u8303","\u5434\u5FE0","\u5851\u6599","\u88C5\u9970","\u5927\u4FEE","\u4E2A\u4EBA","\u5C0F\u5B66","\u5EFA\u6750","\u533B\u7597","\u8054\u5408","\u6280\u6821","\u5609\u5174","\u4EBA\u6C11","\u5B66\u6821","\u8F66\u961F","\u8D44\u4EA7","\u8D37\u6B3E","\u653F\u5E9C","\u670D\u52A1","\u79CD\u690D","\u4E2D\u5B66","\u884C\u653F","\u5DE5\u59D4","\u57CE\u7BA1","\u5730\u8D28","\u652F\u961F","\u76D1\u6D4B","\u5C0F\u533A","\u8BBE\u5907","\u5929\u7A97","\u8857\u9053","\u516C\u8DEF","\u7269\u4E1A","\u80F6\u7C98","\u5357\u5BFA","\u8D22\u52A1","\u7CBE\u795E","\u679C\u852C","\u673A\u6784","\u666F\u89C2","\u5730\u7C4D","\u8D85\u5E02","\u6D59\u6C5F","\u5BBE\u9986","\u7535\u58F0","\u7535\u89C6","\u5B81\u590F","\u6838\u7B97","\u6D41\u901A","\u6D77\u6D0B","\u9910\u996E","\u519C\u6C11","\u7F16\u5236","\u5316\u5DE5","\u652F\u884C","\u4FC3\u8FDB","\u56FD\u571F","\u53D1\u5C55","\u6CB3\u5317","\u5668\u6750","\u94F6\u884C","\u5E02\u573A","\u673A\u68B0","\u75BE\u75C5","\u8F66\u884C","\u96C6\u4E2D","\u5916\u4E8B","\u653F\u534F","\u673A\u7535","\u73AF\u5883","\u5927\u8857","\u76D1\u5BDF","\u56FA\u539F","\u5236\u9020","\u9488\u7EC7","\u4E13\u4E1A","\u63A7\u5236","\u5E7C\u513F","\u96C6\u56E2","\u793E\u533A","\u7B2C\u4E00","\u74DC\u679C","\u73AF\u4FDD","\u7EBA\u7EC7","\u8FD0\u52A8","\u56ED\u533A","\u4F11\u95F2","\u5546\u884C","\u4E2D\u5171","\u80A1\u4EFD","\u4F20\u64AD","\u4E2D\u536B","\u9152\u697C","\u4E2D\u5FC3","\u56FD\u9645","\u9632\u6C34","\u589E\u8865","\u5E7F\u7535","\u6797\u4E1A","\u9AD8\u4E2D","\u7535\u5B50","\u8D44\u91D1","\u8D23\u4EFB","\u5E55\u5899","\u5370\u52A1","\u5927\u5B66","\u519C\u6751","\u6709\u9650","\u7269\u8D44","\u5668\u68B0","\u68C0\u6D4B","\u73E0\u5B9D","\u7535\u529B","\u82D7\u6728","\u529E\u516C","\u4F9B\u6C34","\u4FDD\u536B","\u670D\u88C5","\u755C\u7267","\u7ECF\u6D4E","\u82B1\u56ED","\u6751\u7EA7","\u516C\u53F8","\u54A8\u8BE2","\u56DE\u6536","\u52A8\u7269","\u8861\u6C34","\u517B\u6B96","\u4FDD\u6D01","\u5BA3\u4F20","\u56ED\u6797","\u8282\u80FD","\u9500\u552E","\u8D38\u6613","\u5546\u8D38","\u8FDE\u9501","\u5236\u54C1","\u6316\u6F5C","\u8DEF\u6865","\u77FF\u4E1A","\u9884\u9632","\u5DE5\u4E1A","\u9676\u74F7","\u8425\u4E1A","\u519C\u4E1A"
        };
        String[] noChange3 = { "\u571F\u7279\u4EA7", "\u526F\u98DF\u54C1", "\u5408\u4F5C\u793E", "\u6E05\u771F\u5BFA", "\u4E92\u52A9\u793E", "\u7AF9\u7EA4\u7EF4", "\u6279\u53D1\u90E8", "\u7ECF\u9500\u90E8", "\u7535\u52A8\u8F66"
        };

        //\u6CA1\u6709\u201D\u7701\u201C\u5B57\u5BFC\u81F4\u6E05\u6D17\u7ED3\u679C\u5931\u771F
        String[] chengeSheng = {"\u5317\u4EAC", "\u5929\u6D25", "\u4E0A\u6D77", "\u91CD\u5E86", "\u6CB3\u5317", "\u5C71\u897F", "\u8FBD\u5B81", "\u5409\u6797", "\u9ED1\u9F99", "\u6C5F\u82CF", "\u6D59\u6C5F", "\u5B89\u5FBD", "\u798F\u5EFA", "\u6C5F\u897F", "\u5C71\u4E1C", "\u6CB3\u5357", "\u6E56\u5317", "\u6E56\u5357", "\u5E7F\u4E1C", "\u6D77\u5357", "\u56DB\u5DDD", "\u8D35\u5DDE", "\u4E91\u5357", "\u9655\u897F", "\u7518\u8083", "\u9752\u6D77", "\u53F0\u6E7E", "\u5185\u8499", "\u5E7F\u897F", "\u897F\u85CF", "\u5B81\u590F", "\u65B0\u7586", "\u9999\u6E2F", "\u6FB3\u95E8"};

        String newStrSheng = "";
        String newStrShi = "";
        String newStrXian = "";
        String newStrQu = "";
        String newCun = "";
        //\u590D\u59D3
        boolean isTwoName = false;
        boolean isOneName = false;
        String lastName = "";
        String firstName = "";
        int nameHashCode = 0;
        String s = "";
//\u9ED8\u8BA4hash\u662F\u76D0
        int hash1 = hashSalt;
//type= :1 \u53EA\u6709\u7701\u6CA1\u6709\u5E02 2 \u6709\u7701\u6709\u5E02 3 \u6CA1\u7701\u6709\u5E02
        int type = 0;
        //\u5C0F\u4E8E5\u4F5C\u59D3\u540D\u5224\u65AD
        if (str.length() < 5) {
//\u5F00\u59CB\u5904\u7406\u59D3\u540D
//\u5224\u65AD\u662F\u5426\u662F\u590D\u59D3
            for (int i = 0; i < fuxing.length; i++) {
                if (str.startsWith(fuxing[i])) {
                    isTwoName = true;
                    break;
                }
            }
//\u5224\u65AD\u662F\u5426\u662F\u5355\u59D3
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
                        nameArray[i] = laName[nameHashCode % (laName.length - 1)];//\u59D3
                    } else {
                        nameArray[i] = fiName[nameHashCode % (fiName.length - 1)];//\u540D
                    }
                }
            }
            if (isTwoName) {
                for (int i = 0; i < str.length(); i++) {
                    nameHashCode = Math.abs(str.substring(i, i + 1).hashCode() + hashSalt);
                    if (i == 0) {
                        nameArray[i] = fuxing[nameHashCode % (fuxing.length - 1)];//\u59D3
                        i++;
                    } else {
                        nameArray[i] = fiName[nameHashCode % (fiName.length - 1)];//\u540D
                    }
                }
            }
            for (int i = 0; i <nameArray.length ; i++) {
                s+=nameArray[i];
            }
        } else {
            //\u5F00\u59CB\u5904\u7406\u516C\u53F8\u540D\u3001\u5730\u5740
//\u83B7\u53D6\u7701
            if (str.contains("\u7701")) {
                String[] arrStr1 = str.split("\u7701");
                if (arrStr1.length < 2) return value;
                hash1 = Math.abs(arrStr1[0].hashCode() + hashSalt);
                newStrSheng = provinces[hash1 % (provinces.length - 1)];
                str = arrStr1[1];
                type = 1;
            }
//\u83B7\u53D6\u5E02
            if (str.contains("\u5E02")) {
                String[] arrStr1 = str.split("\u5E02");
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
                    str += arrStr1[i] + "\u5E02";
                }
                str = str.substring(0, str.length() - 1);
            }
//-------------------------------------------------------------
            if (str.contains("\u53BF")) {
                String[] arrStr1 = str.split("\u53BF");
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
            } else if (str.contains("\u533A")) {
                if (str.contains("\u5C0F\u533A")) {
                    String[] arrStr1xiaoqu = str.split("\u5C0F\u533A");
                    String tem = "";
                    if (arrStr1xiaoqu[0].contains("\u533A")) {
                        String[] arrStr1 = str.split("\u533A");
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
                        str = tem + "\u5C0F\u533A" + arrStr1xiaoqu[1];
                    }
                } else {
                    try {
                        String[] arrStr1 = str.split("\u533A");
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
                                str += arrStr1[i] + "\u533A";
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
                        if (arrStr[i].contains(noChange3[j].substring(0,1)) && arrStr[i + 1].contains(noChange3[j].substring(1,2)) && arrStr[i + 2].contains(noChange3[j].substring(2,3))){
                            i+=2;
                            temp = 1;
                            break;
                        }
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    i+=2;
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
                if (arrStr[i].contains("\u5E02")) {
                    arrStr[i] = "\u8857";
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
                newStrSheng += "\u7701";
            }
            s = newStrSheng + newStrShi + newStrXian + newStrQu + newCun;
        }
        if (isSuangYin == 1) {
            s = "\"" + s + "\"";
        }
        return s;
    }
}
