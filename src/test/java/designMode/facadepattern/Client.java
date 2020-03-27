package designMode.facadepattern;

public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();

        //singleton facade pattern
        FacadeA instance = FacadeA.getInstance();
        instance.method();


    }
}
