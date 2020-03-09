package designMode.singleton;

/**
 * 单例模式的结构：懒汉式
 */
public class Singleton {
    private static Singleton instance;

    /**
     * 默认生成public的空构造函数,为避免
     * 在类的外部使用new创建对象，实现private构造函数
     */
    private Singleton() {}

    /**
     * 静态方法，在类的外部通过类名来访问，无需创建对象
     * @return
     */
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

}
