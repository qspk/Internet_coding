import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client_4 {
    public static void main(String[] args) throws IOException {
        //接受并反馈
        Socket socket = new Socket("127.0.0.1", 10004);

        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes(StandardCharsets.UTF_8));

        //os.close() 如果在这里关流,会导致整个socket都无法使用
        //仅关闭输出流,并写一个结束标记,对socket没任何影响
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new
                InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        os.close();
        socket.close();
    }
}
