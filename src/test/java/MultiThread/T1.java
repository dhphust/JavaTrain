package MultiThread;

/**
 * synchronized保证原子性
 */
public class T1 implements Runnable{
    private int count = 10;

    @Override
    public /*synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count=" + count);
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        //多个线程共同访问一个对象
        for (int i = 0; i < 5; i++) {
            new Thread(t1,"thread" + i).start();
            
        }
    }
}
