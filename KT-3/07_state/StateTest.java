interface LightState {
    void show();

    void next(TrafficLight light);
}

class RedState implements LightState {
    public void show() {
        System.out.println("Red: stop");
    }

    public void next(TrafficLight light) {
        light.setState(new GreenState());
    }
}

class GreenState implements LightState {
    public void show() {
        System.out.println("Green: go");
    }

    public void next(TrafficLight light) {
        light.setState(new YellowState());
    }
}

class YellowState implements LightState {
    public void show() {
        System.out.println("Yellow: get ready to stop");
    }

    public void next(TrafficLight light) {
        light.setState(new RedState());
    }
}

class TrafficLight {
    private LightState state;

    public TrafficLight() {
        state = new RedState();
    }

    public void setState(LightState state) {
        this.state = state;
    }

    public void show() {
        state.show();
    }

    public void change() {
        state.next(this);
    }
}

public class StateTest {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        for (int i = 0; i < 4; i++) {
            light.show();
            light.change();
        }
    }
}
