import java.util.*;

public class TestList {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("1313");
        list.add(12123);//自动装箱，int to Integer
        System.out.println(list.size());
        List list1 = new ArrayList();
        list1.add(2424);
        list1.add(3453);
        list.add(list);

        System.out.println(list.size());
        for (Object o : list) {
            System.out.println(o);
        }

        Map<Integer,String> map = new HashMap();
        map.put(213, "324");//213自动装箱
        map.put(454,"324");
        map.remove(453);
        map.get(213);
        System.out.println(map.get(453));
        for (Map.Entry<Integer, String> integerStringEntry : map.entrySet()) {
            System.out.println(integerStringEntry.getKey() +":"+integerStringEntry.getValue());
        }
        Set<Integer> set = new HashSet();
        set.add(123);
        set.add(123);
        for (Integer integer : set) {
            System.out.println(integer);
        }

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {//itit
            Integer num = (Integer) iterator.next();
            System.out.println(num);

        }






    }
}
