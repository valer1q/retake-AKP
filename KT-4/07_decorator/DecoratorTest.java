interface Coffee {
    int getCost();

    String getDescription();
}

class SimpleCoffee implements Coffee {
    public int getCost() {
        return 100;
    }

    public String getDescription() {
        return "Coffee";
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public int getCost() {
        return coffee.getCost();
    }

    public String getDescription() {
        return coffee.getDescription();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public int getCost() {
        return coffee.getCost() + 30;
    }

    public String getDescription() {
        return coffee.getDescription() + ", milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public int getCost() {
        return coffee.getCost() + 10;
    }

    public String getDescription() {
        return coffee.getDescription() + ", sugar";
    }
}

public class DecoratorTest {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + ": " + coffee.getCost() + " rub.");

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + ": " + coffee.getCost() + " rub.");

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + ": " + coffee.getCost() + " rub.");
    }
}
