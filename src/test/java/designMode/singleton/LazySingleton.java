package designMode.singleton;

/**
 * 懒汉式：用到时实例化对象
 * 优点：相对懒汉式，实例化更加灵活；
 * 缺点：多线程情况下，出现创建多个实例对象的情况
 * getInstance()：多线程情况下，当第一个线程实例化对象时，
 *                由于进行资源初始化工作，需要一定的时间创建对象；
 *                所以，如果这个时候第二个线程也实例化对象，
 *                因为第一个线程并没有完成实例化，会导致第二个线程也可以进行实例化操作
 */
public class LazySingleton {
    //volatile修饰成员变量，保证多线程情况下的内存可见性
    private volatile static LazySingleton instance;

    /**
     * 默认生成public的空构造函数,为避免
     * 在类的外部使用new创建对象，实现private构造函数
     */
    private LazySingleton() {}

    /**
     * 静态方法，在类的外部通过类名来访问，无需创建对象
     * @return
     */
    public static LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 多线程情况，为保证单例对象的唯一性，加锁
     */
    public static LazySingleton getThreadSafeInstance(){
        if(instance == null){
            synchronized (LazySingleton.class){
                if(instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return  instance;
    }
}
