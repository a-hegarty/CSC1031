
public class SmartHome {

    static class Appliance {
        //attributes
        private String brand;
        private double powerConsumption;
    
        //constructor
        public Appliance(String brand, double powerConsumption) {
            this.brand = brand;
            this.powerConsumption = powerConsumption;
        }
    
        //method prints that appliance is turned on
        public void turnOn() {
            System.out.println("Turning on " + brand + " appliance");
        }
    
        //method prints that appliance is turned off
        public void turnOff() {
            System.out.println("Turning off " + brand + " appliance");
        }
    
        //method returns brnad of applinace
        public String getBrand() {
            return brand;
        }
    
        public double getPowerConsumption() {
            return powerConsumption;
        }
    }
    
    static class WashingMachine extends Appliance {
        //attributes
        private int drumSize;
    
        //constructor
        public WashingMachine(String brand, double powerConsumption, int drumSize) {
            super(brand, powerConsumption);
            this.drumSize = drumSize;
        }
    
        public void washClothes() {
            System.out.println("Washing clothes in a " + getBrand() + " washing machine");
        }
    
        //returns drum size in kg
        public int getDrumSize() {
            return drumSize;
        }
    }
    
    static class Refrigerator extends Appliance {
        //attributes
        private double temperature;
    
        //constructor
        public Refrigerator(String brand, double powerConsumption, double temperature) {
            super(brand, powerConsumption);
            this.temperature = temperature;
        }
    
        public void coolItems() {
            System.out.println("Cooling items in a " + getBrand() + " refrigerator at " + temperature + "°C");
        }
    
        public double getTemperature() {
            return temperature;
        }
    
        public double setTemperature(double temp) {
            temperature = temp;
            return temperature;
        }
    }
    
    static class SmartWashingMachine extends WashingMachine {
        //attributes
        private boolean hasWifi;
    
        public SmartWashingMachine(String brand, double powerConsumption, int drumSize, boolean hasWifi) {
            super(brand, powerConsumption, drumSize);
            this.hasWifi = hasWifi;
        }
    
        public void connectToWiFi() {
            if(hasWifi == false) {
                System.out.println("This washing machine does not support WiFi");
            }
            else{
                System.out.println("Smart Washing Machine connected to WiFi");
            }
            //System.out.println("Smart Washing Machine connected to WiFi");
        }
    
        public boolean hasWiFi() {
            return hasWifi;
        }
    }

    public static void main(String[] args) {
        SmartHome.Appliance appliance_1 = new SmartHome.Appliance("Samsung", 2.0);
        SmartHome.WashingMachine washer_1 = new SmartHome.WashingMachine("Dell", 2.0, 9);
        SmartHome.Refrigerator fridge_1 = new SmartHome.Refrigerator("new", 3.0, 2.2);
        SmartHome.SmartWashingMachine smart_washer_1 = new SmartHome.SmartWashingMachine("internetty", 5.0, 7, false);

        appliance_1.turnOn();
        appliance_1.turnOff();

        washer_1.turnOn();
        washer_1.washClothes();
        washer_1.turnOff();

        fridge_1.turnOn();
        fridge_1.coolItems();
        fridge_1.turnOff();

        smart_washer_1.turnOn();
        System.out.println("WiFi enabled: " + smart_washer_1.hasWiFi());
        smart_washer_1.connectToWiFi();
        System.out.println("WiFi enabled: " + smart_washer_1.hasWiFi());
        smart_washer_1.turnOff();
    }
}
