import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client_3 {
    public static void main(String[] args) throws IOException {
        //客户端多次发送数据

        Socket socket = new Socket("127.0.0.1", 10003);
        Scanner sc = new Scanner(System.in);
        OutputStream os = socket.getOutputStream();

        while (true) {
            System.out.println("请输入您要发送的信息:");
            String str = sc.nextLine();
            if ("886".equals(str)) {
                break;
            }
            os.write(str.getBytes(StandardCharsets.UTF_8));
        }
        socket.close();
        os.close();
    }
}
