import java.util.*;
public class SpringSeason {
    public static boolean isSpringSeason(int month, int day) {
        return (month == 3 && day >= 20 && day <= 31) ||
               (month == 4 && day >= 1 && day <= 30) ||
               (month == 5 && day >= 1 && day <= 31) ||
               (month == 6 && day >= 1 && day <= 20);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter the day: ");
        int day = scanner.nextInt();

        if (isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }

        scanner.close();
    }
}
