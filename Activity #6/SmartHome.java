
public class SmartHome {
    public static void main(String[] args) {
        AirConditioner ac = new AirConditioner(3, 24);
        LampShade lamp1 = new LampShade(100, "Yellow");
        LampShade lamp2 = new LampShade(lamp1);
        Television tv = new Television(1, 10);
        Microwave mw = new Microwave();

        Device[] devices = { ac, lamp1, lamp2, tv, mw };

        System.out.println("《== INITIAL STATES ==》");
        for (Device d : devices) d.showStatus();

        DeviceUtils.switchAllDevices(devices, true);

        System.out.println("\n《== AFTER TURNING EVERYTHING ON ==》");
        for (Device d : devices) d.showStatus();

        int onCount = DeviceUtils.countPoweredOn(devices);
        System.out.println("\nDevices currently ON: " + onCount);

        DeviceUtils.switchAllDevices(devices, false);

        System.out.println("\n《== AFTER TURNING EVERYTHING OFF ==》");
        for (Device d : devices) d.showStatus();
    }
}

abstract class Device {
    private boolean isOn;

    public Device() {
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public abstract void showStatus();
}

class AirConditioner extends Device {
    private int fanSpeed;
    private int temperature;

    public AirConditioner(int fanSpeed, int temperature) {
        this.fanSpeed = fanSpeed;
        this.temperature = temperature;
    }

    @Override
    public void showStatus() {
        if (isOn()) {
            System.out.println("[AIRCON] ON | Fan Speed: " + fanSpeed + " | Temp: " + temperature);
        } else {
            System.out.println("[AIRCON] OFF");
        }
    }
}

class LampShade extends Device {
    private int brightness;
    private String lightColor;

    public LampShade(int brightness, String color) {
        this.brightness = brightness;
        this.lightColor = color;
    }

    public LampShade(LampShade other) {
        this.brightness = other.brightness;
        this.lightColor = other.lightColor;
    }

    @Override
    public void showStatus() {
        if (isOn()) {
            System.out.println("[LAMP] ON | Brightness: " + brightness + "% | Color: " + lightColor);
        } else {
            System.out.println("[LAMP] OFF");
        }
    }
}

class Television extends Device {
    private int channel;
    private int volume;

    public Television(int channel, int volume) {
        this.channel = channel;
        this.volume = volume;
    }

    @Override
    public void showStatus() {
        if (isOn()) {
            System.out.println("[TV] ON | Channel: " + channel + " | Volume: " + volume + "%");
        } else {
            System.out.println("[TV] OFF");
        }
    }
}

class Microwave extends Device {
    private int timer;
    private int temperature;

    public Microwave() {
        this.timer = 0;
        this.temperature = 25;
    }

    @Override
    public void showStatus() {
        if (isOn()) {
            System.out.println("[MICROWAVE] ON | Timer: " + timer + " | Temp: " + temperature);
        } else {
            System.out.println("[MICROWAVE] OFF");
        }
    }
}

class DeviceUtils {
    public static void switchAllDevices(Device[] devices, boolean turnOn) {
        for (Device d : devices) {
            if (turnOn) d.turnOn();
            else d.turnOff();
        }
    }

    public static int countPoweredOn(Device[] devices) {
        int count = 0;
        for (Device d : devices) {
            if (d.isOn()) count++;
        }
        return count;
    }
}