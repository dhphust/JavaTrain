package MultiThread;

import java.util.concurrent.Executor;

/**
 * 认识executor,execute()执行某个任务
 */
public class T20_MyExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
     //   new Thread(command).start();
    }

    public static void main(String[] args) {
        new T20_MyExecutor().execute(
                ()-> System.out.println("hello exector")
        );
    }
}
