package test_exam;

public class Person {
    String name;
    int age;
    String address;

    public Person(String name, int age, String address) {
        System.out.println("Person constructor");
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}

interface SpecialFunctionality {
    void fire();
}

class Worker extends Person implements SpecialFunctionality {
    String workerID;

    public Worker(String name, int age, String address, String workerID) {
        super(name, age, address);
        System.out.println("Worker constructor");
        this.workerID = workerID;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Worker ID: " + workerID);
    }

    public void updateWorkerInfo(String newAddress) {
        this.address = newAddress;
    }

    public void updateWorkerInfo(int newAge) {
        this.age = newAge;
    }

    @Override
    public void fire() {
        System.out.println("Worker " + name + " has been fired.");
    }
}

