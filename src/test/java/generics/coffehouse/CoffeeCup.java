package generics.coffehouse;

public class CoffeeCup implements Cup {
    private double cupSize;
    private CoffeeType coffeeType;

    public CoffeeCup(CoffeeType coffeeType, double size) {
        this.cupSize = size;
        this.coffeeType = coffeeType;
    }

    @Override
    public double getCupSize() {
        return 0;
    }

    public void setCupSize(double cupSize){
        this.cupSize = cupSize;
    }

    @Override
    public CoffeeType getType() {
        return this.coffeeType;
    }

    public void setType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }


}
