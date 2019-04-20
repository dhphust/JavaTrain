package MultiThread;

/**
 * 模拟死锁
 * 假设两个线程t1,t2，两个对象a1,a2
 * t1线程执行需要依次锁定a1，a2
 * t2线程执行需要依次锁定a2，a1
 * 假设t1当前已经锁定a1，t2当前已经锁定a2对象
 * 此时t1、t2所需的另一个对象a2、a1分别被对方锁住，导致死锁
 */
public class DeadLock implements Runnable {

    // flag=1，占有对象o1，等待对象o2
    // flag=0，占有对象o2，等待对象o1
    public int flag = 1;

    // 定义两个Object对象，模拟两个线程占有的资源
    private Object o1 = new Object();
    private Object o2 = new Object();
    @Override
    public void run() {
        System.out.println("flag:"+flag);
        //deadLock2占用对象o1，准备获取对象o2
        if(flag == 1){
            synchronized (o1){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("1");
                }
            }
        }
        // deadLock1占用资源o2，准备获取资源o1
        else if(flag == 0){
            synchronized (o2){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("2");
                }
            }
        }

    }

    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock();
        DeadLock deadLock2 = new DeadLock();
        deadLock1.flag = 0;
        deadLock2.flag = 1;

        Thread thread1 = new Thread(deadLock1);
        Thread thread2 = new Thread(deadLock2);
        thread1.start();
        thread2.start();


    }
}
