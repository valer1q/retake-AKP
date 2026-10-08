import java.util.ArrayList;

interface Item {
    int getSize();

    void print(String indent);
}

class File implements Item {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void print(String indent) {
        System.out.println(indent + name + " (" + size + " KB)");
    }
}

class Folder implements Item {
    private String name;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(Item item) {
        items.add(item);
    }

    public int getSize() {
        int total = 0;
        for (int i = 0; i < items.size(); i++) {
            total = total + items.get(i).getSize();
        }
        return total;
    }

    public void print(String indent) {
        System.out.println(indent + name + "/ (" + getSize() + " KB)");
        for (int i = 0; i < items.size(); i++) {
            items.get(i).print(indent + "    ");
        }
    }
}

public class CompositeTest {
    public static void main(String[] args) {
        Folder photos = new Folder("Photos");
        photos.add(new File("sea.jpg", 300));
        photos.add(new File("mountains.jpg", 450));

        Folder documents = new Folder("Documents");
        documents.add(new File("report.docx", 120));
        documents.add(new File("notes.txt", 5));
        documents.add(photos);

        documents.print("");
        System.out.println();
        System.out.println("Total size: " + documents.getSize() + " KB");
    }
}
