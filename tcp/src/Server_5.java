import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_5 {
    public static void main(String[] args) throws IOException {
//        服务器: 接受客户端上传的文件,上传完毕后给出反馈

        ServerSocket ss = new ServerSocket(10005);

        //2.等待客户端来连接
        Socket socket = ss.accept();

        //3.读取数据并保存到本地文件夹中
        BufferedInputStream bis = new
                BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new
                FileOutputStream("D:\\tcp\\receive\\正则表达式.png"));
        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes))  != -1) {
            bos.write(bytes,0,len);
        }
        bos.close();

        //4.回写数据
        BufferedWriter bw = new BufferedWriter(new
                OutputStreamWriter(socket.getOutputStream()));
        bw.write("上传成功");
        bw.newLine();
        bw.flush();

        //5.释放资源
        socket.close();
        ss.close();
    }
}
