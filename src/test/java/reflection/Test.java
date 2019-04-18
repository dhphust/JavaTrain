package reflection;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws Exception {
        //从配置文件获取类名称和方法名
        File config = new File("src/test/java/reflection/spring.txt");
//        System.out.println(config.getAbsolutePath());
        Properties properties = new Properties();
        properties.load(new FileInputStream(config));
        String className = (String) properties.get("class");
        String methodName = (String) properties.get("method");

        //根据类名称创建类对象
        Class clazz = Class.forName(className);
        //根据方法名称，获取方法
        Method method = clazz.getMethod(methodName);
        //获取构造器
        Constructor constructor = clazz.getConstructor();
        //根据构造器，实例化对象
        Object service = constructor.newInstance();
        //调用对象的指定方法
        method.invoke(service);

        //传统方法,不够灵活
        new Service1().doService1();
        new Service2().doService2();


    }
}
