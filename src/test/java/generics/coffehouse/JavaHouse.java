package generics.coffehouse;

import java.util.ArrayList;
import java.util.List;

public class JavaHouse {
    List<CoffeeSaleType> purchase = new ArrayList<>();
    List<Cup> cupsPurchased = new ArrayList<>();
    List<Bag> bagsPurchased = new ArrayList<>();
    List<Dark> darkTypes = new ArrayList<>();
    List<CoffeeType> mediumTypes = new ArrayList<>();
    List<Light> lightTypes = new ArrayList<>();

    public List<CoffeeSaleType> getCurrentPurchase() {
        return purchase;
    }

    /**
     * Add a cup of coffee to the purchase
     * @param coffeeType
     * @param cupSize
     */
    public void addCup(CoffeeType coffeeType, double cupSize){
        Cup cup = new CoffeeCup(coffeeType,cupSize);
        cupsPurchased.add(cup);
    }

    /**
     * Add a list of cups to purchase
     * @param cups
     */
    public void addCups(List<CoffeeCup> cups){
        for (CoffeeCup cup : cups) {
            cupsPurchased.add(cup);
        }
    }

    /**
     * Add a bag of coffee to the purchase
     *
     * @param coffeeType
     * @param weight
     */
    public void addBag(CoffeeType coffeeType, double weight) {
        Bag bag = new CoffeeBag(coffeeType, weight);
        bagsPurchased.add(bag);
    }

    /**
     * Add a list of CoffeeBag to purchase
     *
     * @param bags
     */
    public void addBags(List<CoffeeBag> bags) {
        for (CoffeeBag bag : bags) {
            bagsPurchased.add(bag);
        }
    }

    /**
     * Add a list of CoffeeSaleType objects to the purchase This List can
     * consist of either bags or cups
     * @param saleList
     * @param <T>
     */
    public <T extends CoffeeSaleType> void addToPurchased(List<T> saleList){
        for (T t : saleList) {
            purchase.add(t);
        }

    }
    /**
     * Prints the purchase out. Accepts Lists of CoffeeSaleType objects (bags or
     * cups).
     *
     * @param input
     */
    public void printPurchase(List<? extends CoffeeSaleType> input){
        for (CoffeeSaleType coffeeSaleType : input) {
            System.out.println(coffeeSaleType.getType());
        }

    }

    /**
     * Returns the number of purchase of type T. This method uses a stream on
     * the purchase list, then filters upon the specified CoffeeType, and finally
     * returns a count
     *
     * @param <T>
     * @param coffeeType
     * @return
     */
    public <T> long countTypes(T coffeeType) {
        long count = purchase.stream().filter(
                (sale) -> (sale.getType().getType().equals(coffeeType)))
                .count();
        return count;
    }


    /**
     * A utility function to add all cups and bags purchased to the purchase
     * list, and print out some useful labels.
     */
    public void checkout(){
        System.out.println("cups Purchased");
        printPurchase(cupsPurchased);
        addToPurchased(cupsPurchased);
        System.out.println("Bags Purchased");
        printPurchase(bagsPurchased);
        addToPurchased(bagsPurchased);
        sortByCoffeeStrength(purchase);

    }

    /**
     * This method accepts a purchase list (List of CoffeeSaleTypes), and extracts
     * the individual CoffeeType from each element within the purchase list.  It
     * then determines if the CoffeeType is an instance of Dark, Medium, or Light,
     * and places it into the appropriate container.
     * @param coffeeSale
     */
    public void sortByCoffeeStrength(List<? extends CoffeeSaleType> coffeeSale){
        for (CoffeeSaleType coffeeSaleType : coffeeSale) {
            CoffeeType coffeeType = coffeeSaleType.getType();
            if(coffeeType instanceof Dark){
                darkTypes.add((Dark) coffeeType);
            }else if(coffeeType instanceof Medium){
                mediumTypes.add(coffeeType);
            }else if(coffeeType instanceof Light) {
                lightTypes.add((Light) coffeeType);
            }
        }
        System.out.println("Number of Dark Types: " + darkTypes.size());
        System.out.println("Number of Medium Types: " + mediumTypes.size());
        System.out.println("Number of Light Types: " + lightTypes.size());
    }

}
