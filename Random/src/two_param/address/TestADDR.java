package two_param.address;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Created by ${LiuShuo} on 2016/6/22.
 */
public class TestADDR {
    public static void main(String[] args) {
//1号楼2单元301
//        Pattern p = Pattern.compile("^([\\u4e00-\\u9fa5])*([A-Za-z0-9_])*+(省|市|县|区|街|镇|楼|村)+([\\u4e00-\\u9fa5])*([A-Za-z0-9_])*$");
//        Pattern p = Pattern.compile("^([^\\x00-\\xff]|[A-Za-z0-9_])+$");
//        Pattern p = Pattern.compile("^([\\u4e00-\\u9fa5]|[A-Za-z0-9_])*+(省|市|县|区|街|镇|楼|村)+([\\u4e00-\\u9fa5]|[A-Za-z0-9_])*$");
//        Pattern p = Pattern.compile("^([\\u4e00-\\u9fa5])*([A-Za-z0-9_-])*(省|市|县|区|街|镇|楼|村)+([\\u4e00-\\u9fa5])*([A-Za-z0-9_-])*$");
//        boolean matches = p.matcher().matches();
//
//        System.out.println(matches);


//        Object m = Address2.getM("辽宁省葫芦岛市其他连山市昆山路莲花", 1);
//        System.out.println(m);



        String[] noChange2 = {"银川","中卫","固原","吴忠","石嘴山","蒙古族","自治县","二手","车行","物资","经营部","宁夏","农村","商业","银行","股份","有限","公司","支行","吴忠","苗木","种植","专业","合作社","吴忠","养殖","专业","合作社","村级","发展","资金","互助社","吴忠","果蔬","种植","专业","合作社","交通","资产","管理","银川","家私","制造","保洁","服务","中心","商业","餐饮","中卫","小额","贷款","青铜峡","中心","副食品","批发部","宁夏","农村","商业","银行","股份","有限","公司","支行","吴忠","陶瓷","经销部","清真","南寺","清真","清真寺","内蒙古","实业","集团","中卫","农民","专业","合作社","宁夏","园林","景观","工程"};
        Set s = new TreeSet();
        for (int i = 0; i < noChange2.length; i++) {
            s.add(noChange2[i]);
        }
        Iterator i = s.iterator();
        while (i.hasNext()){
            System.out.print("\""+i.next()+"\",");
        }


    }
}
