package generics.coffehouse;

public class CoffeeBag implements Bag {
    private double ounces;//盎司
    private CoffeeType coffeeType;

    public CoffeeBag(CoffeeType coffeeType, double ounces) {
        this.ounces = ounces;
        this.coffeeType = coffeeType;
    }

    public void setWeight(double ounces) {
        this.ounces = ounces;
    }

    public void setType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }


    @Override
    public double getWeight() {
        return this.ounces;
    }

    @Override
    public CoffeeType getType() {
        return this.coffeeType;
    }
}
