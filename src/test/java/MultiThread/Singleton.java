package MultiThread;

/**
 * 多线程单例模式
 */
public class Singleton {
    private static Singleton singleton;
    public Singleton() {
    }
    public static synchronized Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
