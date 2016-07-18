package two_param.name;

import two_param.address.Address;

/**
 * Created by ${LiuShuo} on 2016/6/22.
 */
public class TestNAME {
    public static void main(String[] args) {
//        Object addr= Address.getM("河南省南阳市中州路42号","哈1111科");//辽宁省葫芦岛市其他连山区昆山路莲花小区4号楼2单元301

        //辽宁省其他连山区昆山路莲花小区4号楼2单元301

        Object addr= Address.getM("辽宁省葫芦岛市其他市连山区昆山路莲花小区1号楼2单元301","哈1高科");
//        Object addr= Address.getM("辽宁省其他连山区昆山路莲花小区4号楼2单元301","哈1高科");


        System.out.println(addr);

    }
}
