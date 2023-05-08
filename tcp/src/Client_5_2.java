import java.io.*;
import java.net.Socket;

public class Client_5_2 {
    public static void main(String[] args) throws IOException {

        //客户端: 将本地文件上传到服务器.接受服务器的反馈

        Socket socket = new Socket("127.0.0.1", 10006);

        //2.读取本地文件中的数据,并写道服务器中
        BufferedInputStream bis = new BufferedInputStream(new
                FileInputStream("D:\\tcp\\send\\正则表达式.png"));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        //网服务器写结束标记
        socket.shutdownOutput();

        //3.接受服务器的写会数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();
        System.out.println(line);

        //4.释放资源
        socket.close();

    }
}
