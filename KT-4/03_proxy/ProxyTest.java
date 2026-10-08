import java.util.ArrayList;

interface VideoService {
    void play(String name);
}

class RealVideoService implements VideoService {
    public void play(String name) {
        System.out.println("Downloading " + name + " from server...");
        System.out.println("Playing " + name);
    }
}

class VideoProxy implements VideoService {
    private RealVideoService service = new RealVideoService();
    private ArrayList<String> cache = new ArrayList<String>();

    public void play(String name) {
        if (cache.contains(name)) {
            System.out.println("Playing " + name + " from cache");
        } else {
            service.play(name);
            cache.add(name);
        }
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        VideoService video = new VideoProxy();
        video.play("cats.mp4");
        System.out.println();
        video.play("dogs.mp4");
        System.out.println();
        video.play("cats.mp4");
    }
}
