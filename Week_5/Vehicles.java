package Week_5;

public class Vehicles {
    interface Vehicle {
        void start();
        void stop();
    }

    class Car implements Vehicle {
        //override method start()
        @Override
        public void start() {
            System.out.println("Car is staring . . .");
        }
        
        //override method stop
        @Override
        public void stop(){
            System.out.println("Car is stopping . . .");
        }
    }

    class Bicycle implements Vehicle {
        //override method start()
        @Override
        public void start() {
            System.out.println("Bicycle is staring . . .");
        }
        
        //override method stop
        @Override
        public void stop(){
            System.out.println("Bicycle is stopping . . .");
        }
    }
}
