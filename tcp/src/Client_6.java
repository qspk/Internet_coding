import java.io.*;
import java.net.Socket;

public class Client_6 {
    //使用循环
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10008);

        BufferedInputStream bis = new BufferedInputStream(new
                FileInputStream("D:\\tcp\\send\\正则表达式.png"));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();
        System.out.println(line);

        socket.close();
    }
}
