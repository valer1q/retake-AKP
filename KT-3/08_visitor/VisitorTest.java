interface Visitor {
    void visit(Square square);

    void visit(Rectangle rectangle);
}

interface Shape {
    void accept(Visitor visitor);
}

class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class AreaVisitor implements Visitor {
    public void visit(Square square) {
        int area = square.getSide() * square.getSide();
        System.out.println("Square area: " + area);
    }

    public void visit(Rectangle rectangle) {
        int area = rectangle.getWidth() * rectangle.getHeight();
        System.out.println("Rectangle area: " + area);
    }
}

class PerimeterVisitor implements Visitor {
    public void visit(Square square) {
        int perimeter = 4 * square.getSide();
        System.out.println("Square perimeter: " + perimeter);
    }

    public void visit(Rectangle rectangle) {
        int perimeter = 2 * (rectangle.getWidth() + rectangle.getHeight());
        System.out.println("Rectangle perimeter: " + perimeter);
    }
}

public class VisitorTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Square(3);
        shapes[1] = new Rectangle(4, 5);

        Visitor areaVisitor = new AreaVisitor();
        Visitor perimeterVisitor = new PerimeterVisitor();

        for (int i = 0; i < shapes.length; i++) {
            shapes[i].accept(areaVisitor);
        }
        System.out.println();
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].accept(perimeterVisitor);
        }
    }
}
