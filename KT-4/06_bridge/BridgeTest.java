interface Sender {
    void send(String text);
}

class EmailSender implements Sender {
    public void send(String text) {
        System.out.println("Email: " + text);
    }
}

class SmsSender implements Sender {
    public void send(String text) {
        System.out.println("SMS: " + text);
    }
}

abstract class Message {
    protected Sender sender;

    public Message(Sender sender) {
        this.sender = sender;
    }

    public abstract void send(String text);
}

class SimpleMessage extends Message {
    public SimpleMessage(Sender sender) {
        super(sender);
    }

    public void send(String text) {
        sender.send(text);
    }
}

class UrgentMessage extends Message {
    public UrgentMessage(Sender sender) {
        super(sender);
    }

    public void send(String text) {
        sender.send("URGENT! " + text);
    }
}

public class BridgeTest {
    public static void main(String[] args) {
        Sender email = new EmailSender();
        Sender sms = new SmsSender();

        Message message1 = new SimpleMessage(email);
        message1.send("Meeting at 10:00");

        Message message2 = new SimpleMessage(sms);
        message2.send("Meeting at 10:00");

        Message message3 = new UrgentMessage(email);
        message3.send("Server is down");

        Message message4 = new UrgentMessage(sms);
        message4.send("Server is down");
    }
}
