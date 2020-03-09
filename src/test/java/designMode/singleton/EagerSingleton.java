package designMode.singleton;

/**
 * 恶汉式，在类加载时就创建对象
 * 优点：不会出现多线程情况下创建多个对象的问题
 * 缺点：系统在加载时由于需要创建恶汉式单例对象，加载时间可能比较长；
 *      由于在类加载时就创建对象，如果系统在运行时并不需要该单例对象，存在资源浪费
 */
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();

    /**
     * 默认生成public的空构造函数,为避免
     * 在类的外部使用new创建对象，实现private构造函数
     */
    private EagerSingleton() {}

    /**
     * 静态方法，在类的外部通过类名来访问，无需创建对象
     * @return
     */
    public static EagerSingleton getInstance(){
        return instance;
    }
}
