import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_3 {
    public static void main(String[] args) throws IOException {
        //服务端多次接受数据,并打印

        ServerSocket ss = new ServerSocket(10003);
        Socket socket = ss.accept();

        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        socket.close();
        ss.close();
    }
}
