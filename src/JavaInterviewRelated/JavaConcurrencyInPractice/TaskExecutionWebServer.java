package JavaInterviewRelated.JavaConcurrencyInPractice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {
    private static int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);


    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                public void run() {
                    //handleRequest(connection);
                }
            };
            exec.execute(task);
        }
    }

    class ThreadPerTaskExecutor implements Executor {

        public void execute(Runnable runnable){
            new Thread(runnable).start();
        }
    }

}


