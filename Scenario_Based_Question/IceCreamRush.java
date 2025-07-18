/*IceCreamRush – Sorting Flavors by Popularity (Bubble Sort)
Story: At “IceCreamRush,” a small local vendor sells 8 different ice cream flavors. At the end of
each week, the shopkeeper wants to sort these flavors based on how many times each was
sold. Since the list is short and he updates it manually, he prefers a simple sorting method —
Bubble Sort — where he repeatedly compares adjacent sales figures and swaps them if
needed.
Concepts Involved:
● Bubble Sort
● Small data size
● Repeated adjacent comparisons */
public class IceCreamRush{
    public static void main(String[] args) {
        String[] flavors = {"Vanilla", "Chocolate", "Strawberry", "Mint","Mango", "Rose", "Coffee", "ButterScotch"};
        int[] sales = {120, 200, 150, 90,170, 130, 80, 60};
        for(int i = 0; i < sales.length - 1; i++) {
            for (int j = 0; j < sales.length - 1 - i; j++) {
                if (sales[j] < sales[j + 1]) {
                    // Swap sales
                    int tempSales = sales[j];
                    sales[j] = sales[j + 1];
                    sales[j + 1] = tempSales;

                    // Swap corresponding flavors
                    String tempFlavor = flavors[j];
                    flavors[j] = flavors[j + 1];
                    flavors[j + 1] = tempFlavor;
                }
            }
        }
        System.out.println("Flavors sorted by popularity (most to least):");
        for (int i = 0; i < flavors.length; i++) {
            System.out.println(flavors[i] + " - " + sales[i] + " scoops sold");
        }
    }
}