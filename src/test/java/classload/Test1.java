package classload;

public class Test1 extends Test {

    public void test(){
        System.out.println("method 1");
    }
    public static void main(String[] args) {
        Test test = new Test1();
        System.out.println(test.count);
    }
}
