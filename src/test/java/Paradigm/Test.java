package Paradigm;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ObjectContainer objectContainer = new ObjectContainer();
        objectContainer.setObj("Test");
        System.out.println(objectContainer.getObj());

        objectContainer.setObj(3);
        System.out.println(objectContainer.getObj());

        List objectList = new ArrayList();
        objectList.add(objectContainer);
        //强制类型转换
        Integer fistObject = (Integer) ((ObjectContainer)objectList.get(0)).getObj();
        System.out.println(fistObject);


        //使用范型
        GenericContainer<Integer> genericContainer = new GenericContainer();
        genericContainer.setObj(3);
//        genericContainer.setObj("we");
        System.out.println(genericContainer.getObj());
        System.out.println(" *********************对比*************************************");

        List<ObjectContainer> objectList1 = new ArrayList();
        // Store instances of ObjectContainer
        for(int x=0; x <=10; x++){
            ObjectContainer myObj = new ObjectContainer();
            myObj.setObj("Test" + x);
            objectList1.add(myObj);
        }

//     //    Get the objects we need to cast
//        for(int x=0; x <= objectList1.size()-1; x++){
//            ObjectContainer obj = (ObjectContainer) objectList1.get(x);
//            System.out.println("Object Value: " + obj.getObj());
//        }
        for (ObjectContainer container : objectList1) {
            System.out.println(container.getObj());
        }

        List<GenericContainer> genericlist = new ArrayList<>();
        for (int i = 0; i <=10; i++) {
            GenericContainer<String> genericContainer1 = new GenericContainer<>();
            genericContainer1.setObj("generic" + i);
            genericlist.add(genericContainer1);

        }
        for (GenericContainer container : genericlist) {
            System.out.println(container.getObj());
        }

        System.out.println(" ****************************实例化******************************");
        GenericContainer genericContainer1 = new GenericContainer("sdf");
        GenericContainer genericContainer2 = new GenericContainer(3);

        System.out.println(" ****************************对种类型******************************");
        MultiGenericContainer<String,Integer> multiGenericContainer = new MultiGenericContainer<>();
        multiGenericContainer.setFirstPosition("string type");
        multiGenericContainer.setSecondPosition(2);
        System.out.println(multiGenericContainer.getFirstPosition());
        System.out.println(multiGenericContainer.getSecondPosition());

        MultiGenericContainer<String,Integer> multiGenericContainer1 = new MultiGenericContainer(23,34,12);
//        System.out.println(multiGenericContainer1.getFirstPosition());
        System.out.println(multiGenericContainer1.getSecondPosition());
        int secondPosition = multiGenericContainer1.getSecondPosition();//自动拆箱

        System.out.println(" ****************************有界类型******************************");
//        GenericNumberContainer<String> genericNumberContainer = new GenericNumberContainer()
        System.out.println(GenericNumberContainer.add(34,45));
        System.out.println(GenericNumberContainer.add(56,343.232));

        System.out.println(" ****************************通配符使用******************************");
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        GenericNumberContainer.checkList(list,3);
        GenericNumberContainer.checkList(list,6);

        List<String> list1 = new ArrayList<>();
        list1.add("abc");
        list1.add("asd");
        GenericNumberContainer.checkList(list1,"sd");

        // Create List of type Object
        List<Object> objList = new ArrayList<>();
        objList.add("two");
        objList.add("four");
        objList.add(list);
        GenericNumberContainer.checkList(objList,list);



    }

}
