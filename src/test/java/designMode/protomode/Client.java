package designMode.protomode;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //深克隆
        String id = "1";
        String name = "tom";
        ProtoType protoTypeA = new ConcretePrototypeA(id, name);
        System.out.println(protoTypeA);

        //克隆一个对象
        ProtoType protoTypeA1 = protoTypeA.deepCopy();
     //   protoTypeA1.setId("2");
        System.out.println(protoTypeA1);
        System.out.println(protoTypeA == protoTypeA1);    //false
        System.out.println(protoTypeA.getId() == protoTypeA1.getId());   //false

        //浅克隆
        String name1 = "jack";
        int age = 20;
        ShallowCopy shallowCopy = new ShallowCopy(name1, age);
        System.out.println(shallowCopy);

        ShallowCopy shallowCopy1 = shallowCopy.clone();
      //  shallowCopy1.setAge(24);
        System.out.println(shallowCopy1);
        System.out.println(shallowCopy == shallowCopy1);
        System.out.println(shallowCopy.getAge() == shallowCopy1.getAge());
        System.out.println(shallowCopy.getName() == shallowCopy1.getName());
    }
}
