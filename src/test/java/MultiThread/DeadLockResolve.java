package MultiThread;

/**
 * 解决死锁
 * 避免锁嵌套
 */
public class DeadLockResolve implements Runnable {

    // flag=1，占有对象o1，等待对象o2
    // flag=0，占有对象o2，等待对象o1
    public int flag = 1;

    // 定义两个Object对象，模拟两个线程占有的资源
    //此处必须用static修饰，静态变量在内存中只有一个拷贝(节省内存), JVM只为静态变量分配一次内存.在加载类的过程中完成静态变量的内存分配.
    //对于非静态变量, 每创建一个实例, 就会为非静态变量分配一次内存, 非静态变量可以在内存中有多个拷贝, 互不影响, 需要通过实例的引用来访问.
    private static Object o1 = new Object();
    private static Object o2 = new Object();
    @Override
    public void run() {
        System.out.println("flag:"+flag);
        //deadLock2占用对象o1，准备获取对象o2
        if(flag == 1){
            synchronized (o1){
                System.out.println(flag + ":持有->" + o1.hashCode());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (o2){
                System.out.println(flag + ":持有->" + o2.hashCode());
            }
        }
        // deadLock1占用资源o2，准备获取资源o1
        else if(flag == 0){
            synchronized (o2){
                System.out.println(flag + ":持有->" + o2.hashCode());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (o1){
                System.out.println(flag + ":持有->" + o1.hashCode());
            }
        }

    }

    public static void main(String[] args) {
        DeadLockResolve deadLock1 = new DeadLockResolve();
        DeadLockResolve deadLock2 = new DeadLockResolve();
        deadLock1.flag = 0;
        deadLock2.flag = 1;

        Thread thread1 = new Thread(deadLock1);
        Thread thread2 = new Thread(deadLock2);
        thread1.start();
        thread2.start();


    }
}
