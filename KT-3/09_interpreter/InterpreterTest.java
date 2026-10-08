interface Expression {
    int interpret();
}

class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    public int interpret() {
        return number;
    }
}

class PlusExpression implements Expression {
    private Expression left;
    private Expression right;

    public PlusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class MinusExpression implements Expression {
    private Expression left;
    private Expression right;

    public MinusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

class Parser {
    public Expression parse(String text) {
        String[] parts = text.split(" ");
        Expression result = new NumberExpression(Integer.parseInt(parts[0]));
        for (int i = 1; i < parts.length; i = i + 2) {
            String operation = parts[i];
            Expression right = new NumberExpression(Integer.parseInt(parts[i + 1]));
            if (operation.equals("+")) {
                result = new PlusExpression(result, right);
            } else {
                result = new MinusExpression(result, right);
            }
        }
        return result;
    }
}

public class InterpreterTest {
    public static void main(String[] args) {
        Parser parser = new Parser();
        String[] examples = {"10 + 5", "20 - 7 + 3", "100 - 30 - 20 + 5"};
        for (int i = 0; i < examples.length; i++) {
            Expression expression = parser.parse(examples[i]);
            System.out.println(examples[i] + " = " + expression.interpret());
        }
    }
}
