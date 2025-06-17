import java.util.*;
public class SmallestLargestFinder {
    public static int[] findSmallestLargest(int a, int b, int c) {
        int smallest = a;
        int largest = a;

        if (b < smallest) {
            smallest = b;
        }
        if (b > largest) {
            largest = b;
        }

        if (c < smallest) {
            smallest = c;
        }
        if (c > largest) {
            largest = c;
        }

        return new int[] {smallest, largest};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();
        int[] result = findSmallestLargest(num1, num2, num3);

        System.out.println("Smallest number: " + result[0]);
        System.out.println("Largest number: " + result[1]);

        scanner.close();
    }
}
