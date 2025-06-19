import java.util.*;
public class ReverseNumberArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input a number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int temp = number;

        // Step 2: Count digits
        int count = 0;
        while (temp > 0) {
            temp /= 10;
            count++;
        }

        // Step 3: Extract digits into an array
        int[] digits = new int[count];
        temp = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        // Step 4: Reverse the digits into a new array
        int[] reversed = new int[count];
        for (int i = 0; i < count; i++) {
            reversed[i] = digits[count - 1 - i];
        }

        // Step 5: Display the reversed number
        System.out.print("Reversed Number: ");
        for (int d : reversed) {
            System.out.print(d);
        }

        sc.close();
    }
}
