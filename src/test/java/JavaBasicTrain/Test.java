package JavaBasicTrain;

public class Test {
   public void doSomething(){
       System.out.println("father something");
   }
    public static void main(String[] args) {
       Test test = new Test1();
       test.doSomething();
    }
}

class Test1 extends Test{
    @Override
    public void doSomething() {
        System.out.println("son something");
        super.doSomething();
    }
}
