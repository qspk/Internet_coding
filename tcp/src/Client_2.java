import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client_2 {
    public static void main(String[] args) throws IOException {
        //TCP 协议发送中文

        Socket socket = new Socket("localhost", 100002);
        OutputStream os = socket.getOutputStream();
        os.write("你好你好".getBytes(StandardCharsets.UTF_8)); //12字节

        os.close();
        socket.close();
    }
}
