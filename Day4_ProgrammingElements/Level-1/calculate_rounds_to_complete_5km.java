import java.util.*;
public class calculate_rounds_to_complete_5km {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = scanner.nextDouble();

        double perimeter = side1 + side2 + side3;

        double totalDistance = 5000;

        double rounds = totalDistance / perimeter;

        System.out.printf("The athlete needs to complete %.2f rounds to run 5 km.%n", rounds);

        scanner.close();
    }
}
