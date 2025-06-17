import java.util.Scanner;
public class SumNaturalNumbers {

    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();
        int result = sumOfNaturalNumbers(n);

        System.out.println("Sum of first " + n + " natural numbers is: " + result);

        scanner.close();
    }
}
