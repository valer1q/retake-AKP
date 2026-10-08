interface CelsiusThermometer {
    int getTemperature();
}

class RussianThermometer implements CelsiusThermometer {
    public int getTemperature() {
        return 20;
    }
}

class AmericanThermometer {
    public int getFahrenheit() {
        return 77;
    }
}

class ThermometerAdapter implements CelsiusThermometer {
    private AmericanThermometer thermometer;

    public ThermometerAdapter(AmericanThermometer thermometer) {
        this.thermometer = thermometer;
    }

    public int getTemperature() {
        return (thermometer.getFahrenheit() - 32) * 5 / 9;
    }
}

class WeatherStation {
    public void show(CelsiusThermometer thermometer) {
        System.out.println("Temperature: " + thermometer.getTemperature() + " C");
    }
}

public class AdapterTest {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        System.out.println("Russian thermometer:");
        station.show(new RussianThermometer());

        AmericanThermometer american = new AmericanThermometer();
        System.out.println("American thermometer shows " + american.getFahrenheit() + " F");
        System.out.println("American thermometer through adapter:");
        station.show(new ThermometerAdapter(american));
    }
}
