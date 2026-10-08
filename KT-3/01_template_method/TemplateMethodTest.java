abstract class Drink {
    public final void prepare() {
        boilWater();
        brew();
        pourInCup();
        addExtras();
    }

    private void boilWater() {
        System.out.println("Boil water");
    }

    private void pourInCup() {
        System.out.println("Pour into cup");
    }

    abstract void brew();

    abstract void addExtras();
}

class Tea extends Drink {
    void brew() {
        System.out.println("Steep the tea leaves");
    }

    void addExtras() {
        System.out.println("Add lemon");
    }
}

class Coffee extends Drink {
    void brew() {
        System.out.println("Brew ground coffee");
    }

    void addExtras() {
        System.out.println("Add milk and sugar");
    }
}

public class TemplateMethodTest {
    public static void main(String[] args) {
        Drink tea = new Tea();
        System.out.println("Making tea:");
        tea.prepare();
        System.out.println();
        Drink coffee = new Coffee();
        System.out.println("Making coffee:");
        coffee.prepare();
    }
}
