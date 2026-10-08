import java.util.ArrayList;

interface Subscriber {
    void update(String news);
}

class NewsAgency {
    private ArrayList<Subscriber> subscribers = new ArrayList<Subscriber>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publish(String news) {
        System.out.println("Agency publishes: " + news);
        for (int i = 0; i < subscribers.size(); i++) {
            subscribers.get(i).update(news);
        }
    }
}

class Reader implements Subscriber {
    private String name;

    public Reader(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println("  " + name + " got the news: " + news);
    }
}

public class ObserverTest {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        Reader anna = new Reader("Anna");
        Reader ivan = new Reader("Ivan");

        agency.subscribe(anna);
        agency.subscribe(ivan);
        agency.publish("Snow is expected tomorrow");

        agency.unsubscribe(ivan);
        agency.publish("Exams start on Monday");
    }
}
