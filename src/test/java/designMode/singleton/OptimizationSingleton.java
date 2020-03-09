package designMode.singleton;


/**
 * 综合恶汉式、懒汉式，改进后的单例类
 * 在单例类中增加一个静态内部类，在该内部类中创建单例对象
 * 再将该单例对象通过getInstance()返回给外部使用
 * 优势：
 *      1、外部的类初始化时不会实例化对象
 *      2、getInstance()调用内部类实例化对象，跟恶汉式一样，由JVM虚拟机保证了线程安全性
 */
public class OptimizationSingleton {

    private OptimizationSingleton(){}

    private static class HolderClass{
        private final static OptimizationSingleton singleton = new OptimizationSingleton();
    }

    public static OptimizationSingleton getInstance(){
        return HolderClass.singleton;
    }

    public static void main(String[] args) {
        OptimizationSingleton singleton1, singleton2;
        singleton1 = OptimizationSingleton.getInstance();
        singleton2 = OptimizationSingleton.getInstance();
        if(singleton1 == singleton2){
            System.out.println("单例保证实例对象的唯一性");
        }
    }
}
