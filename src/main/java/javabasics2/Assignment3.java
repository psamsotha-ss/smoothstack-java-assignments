package javabasics2;

import java.util.Arrays;
import java.util.List;

public class Assignment3 {

    public static void main(String... args) {
        List<Shape> shapes = Arrays.asList(
                new Circle(100),
                new Rectangle(50, 100),
                new Triangle(30, 40 , 50));

        for (Shape shape: shapes) {
            shape.display();
        }
    }

    public interface Shape {
        double calculateArea();
        void display();
    }

    public static class Rectangle implements Shape {

        private final int width;
        private final int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double calculateArea() {
            return width * height;
        }

        @Override
        public void display() {
            System.out.println(
                    "A rectangle with w(" + width + ") and h(" + height + ") has an area of " + calculateArea());
        }
    }

    public static class Circle implements Shape {

        private final int radius;

        public Circle(int radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * Math.pow(radius, 2);
        }

        @Override
        public void display() {
            System.out.println("Circle with radius " + radius + ", has an area of " + calculateArea());
        }
    }

    public static class Triangle implements Shape {

        private final int a;
        private final int b;
        private final int c;

        public Triangle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double calculateArea() {
            int p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        @Override
        public void display() {
            System.out.println(
                    "A triangle with sides (" + a + "," + b + "," + c + ") has an area of " + calculateArea());
        }
    }
}
