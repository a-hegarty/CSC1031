package Week_5;

public class Shapes {
    abstract class Shape{
        //attributes
        protected String color;

        //constructor
        Shape(String color) {
            this.color = color;
        }

        //abstract method
        abstract double getArea();

        //concrete method
        void displayColor() {
            System.out.println("Shape Colour: " + color);
        }
    }

    class Circle extends Shape {
        //attributes
        private double radius;

        //constructor
        public Circle(String color, double radius) {
            super(color);
            if (radius >= 0) {
                this.radius = radius;
            } else {
                this.radius = 0;
            }
        }
       /*  public Circle(String color, double radius) {
            super(color);
            this.radius = radius;
        }*/

        //override method getArea()
        @Override
        double getArea() {
            double area = (3.14 * radius * radius);
            return area;
        }
    }

    public class Rectangle extends Shape {
        //attributes
        private double width;
        private double height;

        //constructor
        public Rectangle(String color, double width, double height) {
            super(color);
            this.width = width;
            this.height = height;
        }

        //override method getArea()
        @Override
        double getArea() {
            double area = width * height;
            return area;
        }

    }

    public static void main (String[] args) {
        Shapes.Circle circle_1 = new Shapes.Circle("green", 1);
       // Rectangle rect_1 = new Rectangle("red", 2.0, 4.0);

        circle_1.displayColor();
        circle_1.getArea();

    //    rect_1.displayColor();
      //  rect_1.getArea();*/
    }
}

