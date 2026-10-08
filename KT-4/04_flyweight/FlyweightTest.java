import java.util.ArrayList;

class TreeType {
    private String name;
    private String color;

    public TreeType(String name, String color) {
        this.name = name;
        this.color = color;
        System.out.println("Creating tree type: " + name);
    }

    public String getName() {
        return name;
    }

    public void draw(int x, int y) {
        System.out.println(name + " (" + color + ") at " + x + ", " + y);
    }
}

class TreeFactory {
    private ArrayList<TreeType> types = new ArrayList<TreeType>();

    public TreeType getTreeType(String name, String color) {
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).getName().equals(name)) {
                return types.get(i);
            }
        }
        TreeType type = new TreeType(name, color);
        types.add(type);
        return type;
    }

    public int getCount() {
        return types.size();
    }
}

class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}

public class FlyweightTest {
    public static void main(String[] args) {
        TreeFactory factory = new TreeFactory();
        Tree[] forest = new Tree[6];

        for (int i = 0; i < forest.length; i++) {
            TreeType type;
            if (i % 2 == 0) {
                type = factory.getTreeType("Oak", "green");
            } else {
                type = factory.getTreeType("Pine", "dark green");
            }
            forest[i] = new Tree(i * 10, i * 5, type);
        }

        System.out.println();
        for (int i = 0; i < forest.length; i++) {
            forest[i].draw();
        }

        System.out.println();
        System.out.println("Trees: " + forest.length + ", tree types in memory: " + factory.getCount());
    }
}
