package generics.coffehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class JavaHouseVisit {
    public static void main(String[] args) {
        JavaHouse javaHouse = new JavaHouse();
        //购买面包、咖啡
        javaHouse.addBag(new FrenchRoast(),12);
        javaHouse.addCup(new DoughnutRoast(),23);
        javaHouse.addBag(new FrenchRoast(),11);
//        javaHouse.addBag(new Integer(3),33);
        javaHouse.checkout();

        //统计购买数量
        List<CoffeeSaleType> purchaseList = javaHouse.getCurrentPurchase();
        System.out.println("Number of items purchase " + purchaseList.size());

        //打印购买详情
        purchaseList.stream().forEach((coffeeSale) -> {
            System.out.println(coffeeSale.getType().getType() + " Description - " +
                    coffeeSale.getType().getDescription());
        });

        //单独统计法棍购买数量
        System.out.println("FrenchRoast:" + javaHouse.countTypes(FrenchRoast.class));

        List<CoffeeType> coffeeList = new ArrayList();
        coffeeList.add(new DoughnutRoast());
        coffeeList.add(new FrenchRoast());

        // Print the coffees that match the criteria
        System.out.println("Whole Bean");
        compareCoffee(coffeeList, (n)->n.getDescription().contains(CoffeeType.WHOLE_BEAN));
        System.out.println("Aromatic");
        compareCoffee(coffeeList, (n)->n.getDescription().contains(CoffeeType.AROMATIC));
        System.out.println("Ground");
        compareCoffee(coffeeList, (n)->n.getDescription().contains(CoffeeType.GROUND));

    }

    /**
     * Compare two types of coffee
     * 判断predicate是否在list中
     * @param list
     * @param predicate
     */
    public static void compareCoffee(List<CoffeeType> list, Predicate<CoffeeType> predicate) {
        list.stream().filter((n) -> (predicate.test(n))).forEach((n) -> {
            System.out.println(n + " ");
        });
    }
}
