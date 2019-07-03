package MultiThread;

/**
 * 使用内部类实现单例模式
 * 既不用加锁，也能实现懒加载(需要时再实例化对象)
 */
public class Singleton1 {
    public Singleton1() {
        System.out.println("singleton");
    }

    //内部类
    private static class Inner{
        private static Singleton1 singleton = new Singleton1();
    }

    private static Singleton1 getInstance(){
        return Inner.singleton;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                Singleton1.getInstance();
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
