package citic.idcard;

import java.util.regex.Pattern;

/**
 * 身份证号码脱敏规则：身份证前四位不变，第五位到第六位按照加权算法修改。
 * （见附件中的公式一）。18位身份证的第七位到第十位减2，第十一位到第十二位加7取12的余数，
 * 07直接改为08。15位身份证的第七位到第八位减2，第九位到第十位加7取12的余数，特殊情况下，
 * 对于15位身份证号需修改第十三位，对于18位身份证号需修改第十五位。（见附件中的公式二）。
 * 18位身份证得出前17位身份证后，再按照校验算法计算出第十八位的效验位（见附件中的公式三）。
 * 对于同时拥有15位和18位身份证的客户信息， 15位的身份证在相关算法操作后，仍然保持15位不变；
 * 它证件种类脱敏规则；使用加权算法替换后两位号码，计算时原有号码中的汉字保持不变，并且不参与计算，
 * 字母按照附件中的对比关系,替换成数字后进行换算（见附件中的公式四）。
 公式一：
 权数表示：A(n) ，使用：A=（2，7，5，6，1，1）
 身份证表示：Id(n)
 FOR n= 5 TO 6
 FOR 1  TO n
 An * Id(n) = C1C2( 两位整数 )
 C1 + C2 = Dn
 Dn=Dn mod 11    (mod 为取余数运算)
 若Dn为10则取0
 E=E + Dn
 ENDFOR
 E=E mod 11
 E=11–E
 若E为10则取0,若为11则取1.
 Id(n)=E
 ENDFOR

 公式二：
 SELECT
 WHEN 原来的身份证位数=15
 Id(7,8)= Id(7,8)-2
 IF Id(9,12) not in （‘0729’，‘0730’，‘0731’）
 Id(9,10)= （Id(9,10)+7）mod 12
 ELSE
 Id(13)=（ID(13)+1）mod 10
 ENDIF
 WHEN原来的身份证位数=18
 C1C2C3=Id(9)*10+Id(10)+98
 IF C1=0
 Id(7,8)='19’
 ENDIF
 Id(9,10)=C2C3
 IF Id(11,14) not in （‘0729’，‘0730’，‘0731’）
 Id(11,12)= （Id(11,12)+7）mod 12
 ELSE
 Id(15)= （ID(15)+1）mod 10
 ENDIF
 OTHER
 ENDSL
 公式四：
 字母和数字的对应关系表，大小写一致。
 A	B	C	D	E	F	G	H	I
 10	11	12	13	14	15	16	17	18
 J	K	L	M	N	O	P	Q	R
 19	20	21	22	23	24	25	26	27
 S	T	U	V	W	X	Y	Z
 28	29	30	31	32	33	34	35

 权数表示：A(n) ，使用：A=（2，7，5，6，1，1，5，4，3，1，9，6，8，1，2，2，3，5）
 证件号码表示：Id(n),
 FOR m= n-1 TO n
 FOR 1  TO m
 An * Id(m) = C1C2   ( 只取个位、十位两位结果 )
 C1 + C2 = Dm
 Dm=Dm mod 11
 若Dm为10则取0
 E=E + Dm
 ENDFOR
 E=E mod 11
 E=11–E
 若E为10则取0,若为11则取1.
 Id(n)=E
 ENDFOR

 * Created by ${LiuShuo} on 2016/7/4.
 */
public class IdCard {
    public static Object getM(Object value,Object key) {
        //判断参数是否为null、"null"、"" ,为true时不做处理
        if (value==null||value.equals("null")||value.equals("")) return value;
        String str = value+"";
        str=str.replace(" ", "");
        //证件号长度小于4不做处理
        if (str.length()<4) return value;
        String salt = key + "";
        String saltok = salt.replace(" ", "");
        //盐值hash
        int hashSalt = 0;

        if (salt.length()<1){
            //没有盐值
        }else {
            hashSalt=Math.abs(saltok.hashCode());
        }
        //正则表达式 数字
        Pattern numRegex = Pattern.compile("^([0-9])$");
        String subStr1 = "";
        String subStr2 = "";
        String subStr3 = "";
        String subStr4 = "";
        String newStr1 = "";


        //15 15位身份证     18 18位身份证   0 其他（加权清洗后两位）
        int type = 0;
        //15位身份证都是数字 如果含有字母肯定不是（只能做到如此，不知道他们数据库有没有其他15的帐号）下同
        if (str.length() == 15 && numRegex.matcher(str).matches()){
            type = 15;
        }
        if (str.length() == 18 && numRegex.matcher(str.substring(0,17)).matches()){
            type = 18;
        }

        if (type == 15){
            newStr1 = str.substring(0,4);
            subStr2 = str.substring(4,6);
            subStr3 = str.substring(6,8);
            subStr4 = str.substring(6,8);










        }else if (type == 18){

        }else {

        }













        return "";
    }
}
