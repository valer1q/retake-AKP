import java.util.ArrayList;

class ChatRoom {
    private ArrayList<Member> members = new ArrayList<Member>();

    public void join(Member member) {
        members.add(member);
        System.out.println(member.getName() + " joined the chat");
    }

    public void send(Member sender, String text) {
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member != sender) {
                member.receive(sender.getName(), text);
            }
        }
    }
}

class Member {
    private String name;
    private ChatRoom room;

    public Member(String name, ChatRoom room) {
        this.name = name;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void send(String text) {
        System.out.println(name + " sends: " + text);
        room.send(this, text);
    }

    public void receive(String from, String text) {
        System.out.println("  " + name + " received from " + from + ": " + text);
    }
}

public class MediatorTest {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();
        Member anna = new Member("Anna", room);
        Member ivan = new Member("Ivan", room);
        Member oleg = new Member("Oleg", room);
        room.join(anna);
        room.join(ivan);
        room.join(oleg);
        System.out.println();
        anna.send("Hello everyone!");
        ivan.send("Hi, Anna!");
    }
}
