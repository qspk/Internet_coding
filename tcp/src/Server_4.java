import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_4 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10004);

        Socket accept = ss.accept();

        InputStream is = accept.getInputStream();
        int b;
        while ((b = is.read()) != -1) {
            System.out.print((char) b);
        }
        System.out.println("看看我执行了么");

        BufferedWriter bw = new BufferedWriter(new
                OutputStreamWriter(accept.getOutputStream()));
        bw.write("你谁啊?");
        bw.newLine();   //写一行行分隔符
        bw.flush();  //刷新流

        bw.close();
        is.close();
        accept.close();
        ss.close();
    }
}
