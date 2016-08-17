package param;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 网络编程1：客户端发送给服务端，服务端将内容打印到控制台上。
 * <p>
 * TCP编程和UDP编程统称Socket编程（是个类）
 * <p>
 * Created by ${LiuShuo} on 8/16/2016.
 */
public class TCPTest {
    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;

        try {
            //1创建Socket对象，指明对方的ip地址和端口号
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9091);
            //2获取一个输出流：getOutputStream();
            os = socket.getOutputStream();
            //3通过输出流传输数据
            os.write("HHHHHHHello".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    //服务端
    @Test
    public void service(){

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;

        try {
            //1创建一个ServerSocket
            serverSocket = new ServerSocket(9091);
            //2调用accept，获得客户端Socket
            socket = serverSocket.accept();
            //3输入流
            is = socket.getInputStream();
            //4读取数据
            byte[] bytes = new byte[1024];
            int len;
            String str = "";
            while ((len = is.read(bytes))!=-1){
                str += new String(bytes,0,len);
            }
            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is != null){
                //5.关闭资源
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }


    }



}
