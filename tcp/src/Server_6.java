import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server_6 {

    public static void main(String[] args) throws IOException {
        //创建线程池对象
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,  //核心线程数量
                16, //线程池总大小
                60,//空闲时间
                TimeUnit.SECONDS,//空闲时间(单位)
                new ArrayBlockingQueue<>(2), //队列
                Executors.defaultThreadFactory(),//线程工厂,让线程池如何创建对象
                new ThreadPoolExecutor.AbortPolicy() //阻塞队列
        );

        ServerSocket ss = new ServerSocket(10008);
        while (true) {
            //等待客户端来连接
            Socket socket = ss.accept();

            //开启一条线程
            //一个用户就对应服务端的一条线程
            //new Thread(new MyRunnable(socket)).start();
            //开启线程池
            pool.submit(new MyRunnable(socket));
        }
    }
}
