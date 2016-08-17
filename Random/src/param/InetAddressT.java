package param;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一、网络通信的要素：①要知道双方的通信地址：IP地址   ②要遵循一定的通信协议
 * 二、IP：唯一的标识 internet上的一台计算机
 *      1.一个ip地址，对应着java.net.InetAddress类的一个对象
 *      2.如何实例化InetAddress
 *          ①getByName（String host）②获取本机的Ip地址：getLocalHost（）
 *      3.ip地址格式：比如192.168.10.165
 *      为了方便的使用ip地址，我们提出了域名的概念。比如：www.baidu.com; www.atguigu.com;
 *      www.sina.com; www.mi.com;www.jd.com;  www.vip.com;
 *      4.两个常用的方法：getHostName():获取域名/主机名
 * 				getHostAddress():获取主机的ip地址
 *      5.本地的回路地址：127.0.0.1
 *      三、端口号：用于区分一台主机上不同的进程。0--65535
 *      常见的端口号： oracle:1521  mysql:3306 http:80  tomcat:8080 ...
 *
 * * Created by ${LiuShuo} on 8/16/2016.
 */
public class InetAddressT {
    public static void main(String[] args) {
        try {
//            InetAddress byName = InetAddress.getByName("www.wiseweb.com.cn");
//            System.out.println(byName);
//            InetAddress byName2 = InetAddress.getByName("116.255.238.39");
//            System.out.println(byName2);
//            System.out.println(byName2.getHostName());
//            System.out.println(byName2.getHostAddress());
//            System.out.println(byName2.getCanonicalHostName());
            //获取本机的ip地址对应的InetAddress类的对象
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }




}
