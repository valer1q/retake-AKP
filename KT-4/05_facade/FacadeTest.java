class Tv {
    public void on() {
        System.out.println("TV is on");
    }

    public void off() {
        System.out.println("TV is off");
    }
}

class SoundSystem {
    public void on() {
        System.out.println("Sound system is on");
    }

    public void setVolume(int volume) {
        System.out.println("Volume is set to " + volume);
    }

    public void off() {
        System.out.println("Sound system is off");
    }
}

class Lights {
    public void dim() {
        System.out.println("Lights are dimmed");
    }

    public void on() {
        System.out.println("Lights are on");
    }
}

class HomeTheaterFacade {
    private Tv tv;
    private SoundSystem sound;
    private Lights lights;

    public HomeTheaterFacade() {
        tv = new Tv();
        sound = new SoundSystem();
        lights = new Lights();
    }

    public void watchMovie() {
        System.out.println("Getting ready to watch a movie:");
        lights.dim();
        tv.on();
        sound.on();
        sound.setVolume(15);
    }

    public void endMovie() {
        System.out.println("Turning everything off:");
        sound.off();
        tv.off();
        lights.on();
    }
}

public class FacadeTest {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();
        homeTheater.watchMovie();
        System.out.println();
        homeTheater.endMovie();
    }
}
