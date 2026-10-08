interface DeliveryStrategy {
    int getCost(int weight);

    String getName();
}

class CourierDelivery implements DeliveryStrategy {
    public int getCost(int weight) {
        return 300 + weight * 50;
    }

    public String getName() {
        return "Courier";
    }
}

class PostDelivery implements DeliveryStrategy {
    public int getCost(int weight) {
        return 200 + weight * 20;
    }

    public String getName() {
        return "Post";
    }
}

class PickupDelivery implements DeliveryStrategy {
    public int getCost(int weight) {
        return 0;
    }

    public String getName() {
        return "Pickup";
    }
}

class Order {
    private int weight;
    private DeliveryStrategy delivery;

    public Order(int weight) {
        this.weight = weight;
    }

    public void setDelivery(DeliveryStrategy delivery) {
        this.delivery = delivery;
    }

    public void printCost() {
        int cost = delivery.getCost(weight);
        System.out.println(delivery.getName() + ": " + cost + " rub.");
    }
}

public class StrategyTest {
    public static void main(String[] args) {
        Order order = new Order(5);
        System.out.println("Delivery cost for an order of 5 kg:");

        order.setDelivery(new CourierDelivery());
        order.printCost();

        order.setDelivery(new PostDelivery());
        order.printCost();

        order.setDelivery(new PickupDelivery());
        order.printCost();
    }
}
