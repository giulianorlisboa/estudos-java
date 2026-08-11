import entities.Circle;
import entities.Color;
import entities.Rectangle;
import entities.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Shape> shapes = new ArrayList<>();

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("Shape " + i + ":");
            System.out.print("Rectangle or Circle (r/c)? ");
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("r")) {
                System.out.print("Color (BLACK/BLUE/RED): ");
                Color color = Color.valueOf(sc.nextLine());
                System.out.print("Width: ");
                Double width = sc.nextDouble();
                sc.nextLine();
                System.out.print("Height: ");
                Double height = sc.nextDouble();
                sc.nextLine();
                Shape rectangle = new Rectangle(color, width, height);
                shapes.add(rectangle);
            } else if (s.equalsIgnoreCase("c")) {
                System.out.print("Color (BLACK/BLUE/RED): ");
                Color color = Color.valueOf(sc.nextLine());
                System.out.print("Radius: ");
                Double radius = sc.nextDouble();
                sc.nextLine();
                Shape circle = new Circle(color, radius);
                shapes.add(circle);
            }else {
                System.out.println("Invalid Input");
            }
        }

        System.out.println("SHAPES AREA: ");
        for (Shape shape : shapes) {
            System.out.printf("%.2f %n", shape.area());
        }
    }
}