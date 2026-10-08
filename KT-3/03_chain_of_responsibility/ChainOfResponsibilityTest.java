abstract class Support {
    protected Support next;

    public void setNext(Support next) {
        this.next = next;
    }

    public abstract void handle(int level);
}

class Operator extends Support {
    public void handle(int level) {
        if (level == 1) {
            System.out.println("Operator solved the problem of level " + level);
        } else if (next != null) {
            System.out.println("Operator passes the request on");
            next.handle(level);
        } else {
            System.out.println("Nobody can solve the problem of level " + level);
        }
    }
}

class Engineer extends Support {
    public void handle(int level) {
        if (level == 2) {
            System.out.println("Engineer solved the problem of level " + level);
        } else if (next != null) {
            System.out.println("Engineer passes the request on");
            next.handle(level);
        } else {
            System.out.println("Nobody can solve the problem of level " + level);
        }
    }
}

class Manager extends Support {
    public void handle(int level) {
        if (level == 3) {
            System.out.println("Manager solved the problem of level " + level);
        } else if (next != null) {
            System.out.println("Manager passes the request on");
            next.handle(level);
        } else {
            System.out.println("Nobody can solve the problem of level " + level);
        }
    }
}

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Support operator = new Operator();
        Support engineer = new Engineer();
        Support manager = new Manager();
        operator.setNext(engineer);
        engineer.setNext(manager);

        for (int level = 1; level <= 4; level++) {
            System.out.println("Request of level " + level + ":");
            operator.handle(level);
            System.out.println();
        }
    }
}
