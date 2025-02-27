package Week_5;

public class Shapes {
    abstract class Shape{
        //attributes
        private String colour;

        //constructor
        Shape(String colour) {
            this.colour = colour;
        }

        //abstract method
        abstract void getArea();

        //concrete method
        public void displayColor() {
            System.out.println("Shape Colour: " + colour);
        }


    }

    static class Circle extends Shape {
        //attributes
        double radius;

        //constructor
        Circle(String colour, double radius) {
            super(colour);
            this.radius = radius;
        }

        //override method getArea()
        @Override
        void getArea() {
            double area = (2 * 3.14 * radius);
            System.out.println(area);
        }

    }

    static class Rectangle extends Shape {
        //attributes
        double width;
        double height;

        //constructor
        Rectangle(String colour, double width, double height) {
            super(colour);
            this.width = width;
            this.height = height;
        }

        //override method getArea()
        @Override
        void getArea() {
            double area = width * height;
            System.out.println(area);
        }

    }

    public static void main (String[] args) {
        Shapes.Circle circle_1 = new Shapes.Circle("green", 1);
        Shapes.Rectangle rect_1 = new Shapes.Rectangle("red", 2.0, 4.0);

        circle_1.displayColor();
        circle_1.getArea();

        rect_1.displayColor();
        rect_1.getArea();
    }
}

