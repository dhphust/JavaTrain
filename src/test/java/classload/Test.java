package classload;

public class Test {
    int count = 0;
    static {
        System.out.println("static method body");
    }

    public void method1(){
        System.out.println("method");
    }

}
