package MultiThread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * TimerTask实现周期性执行任务
 */
public class TimeTask{
    public static void main(String[] args) {
        Timer timer = new Timer();
        //周期性执行任务
        timer.schedule(new MyTask(),1000,2000);//1000ms后开始执行，每隔2000ms执行一次
    }
}
class MyTask extends TimerTask{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ok" + i);
        }
        System.out.println("over");
    }
}

