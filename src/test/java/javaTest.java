import sun.jvm.hotspot.HelloWorld;

public class javaTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = HelloWorld.class.getClassLoader();
        System.out.println(classLoader);
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
        classLoader.loadClass("Test2");
        //使用Class.forName()来加载类，默认会执行初始化块
        Class.forName("Test2");

    }
}


class Test2{
    static {
        System.out.println("静态初始化块执行了");
    }

}
