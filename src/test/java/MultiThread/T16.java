package MultiThread;

public class T16 {
    public synchronized static void staticLock() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
             Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +" "+i);
        }
    }
    public synchronized void lock() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +" "+i);
        }
    }

    public static void main(String[] args){
        T16 t16 = new T16();
        T16 t141 = new T16();
        new Thread(()-> {
            try {
                t16.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread1").start();

        new Thread(()-> {
            try {
                t141.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread2").start();
    }
}
