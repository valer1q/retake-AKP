import java.util.ArrayList;

class Memento {
    private String text;

    public Memento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class Editor {
    private String text = "";

    public void type(String words) {
        text = text + words;
    }

    public String getText() {
        return text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void restore(Memento memento) {
        text = memento.getText();
    }
}

class History {
    private ArrayList<Memento> saves = new ArrayList<Memento>();

    public void push(Memento memento) {
        saves.add(memento);
    }

    public Memento pop() {
        if (saves.size() == 0) {
            return null;
        }
        return saves.remove(saves.size() - 1);
    }
}

public class MementoTest {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.type("Hello");
        history.push(editor.save());
        System.out.println("Text: " + editor.getText());

        editor.type(", world");
        history.push(editor.save());
        System.out.println("Text: " + editor.getText());

        editor.type("!!! typo");
        System.out.println("Text: " + editor.getText());

        editor.restore(history.pop());
        System.out.println("Undo: " + editor.getText());

        editor.restore(history.pop());
        System.out.println("Undo: " + editor.getText());
    }
}
