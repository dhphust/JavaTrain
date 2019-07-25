package classload;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        DecrptClassLoader loader = new DecrptClassLoader("./src/test/java/classload/temp");
        Class<?> test = loader.loadClass("People");
        System.out.println(test);
    }
}
