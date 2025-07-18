import java.util.*;

class Item {
    String name;
    double price;
    int stock;

    Item(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

class Customer {
    String name;
    List<String> itemList;

    Customer(String name, List<String> itemList) {
        this.name = name;
        this.itemList = itemList;
    }
}

class CheckoutCounter {
    Queue<Customer> queue;

    CheckoutCounter() {
        queue = new LinkedList<>();
    }

    public void addCustomer(Customer customer) {
        queue.offer(customer);
        System.out.println(customer.name + " added to the queue.");
    }

    public void removeCustomer() {
        Customer customer = queue.poll();
        if (customer != null) {
            System.out.println(customer.name + " removed from the queue.");
        } else {
            System.out.println("Queue is empty.");
        }
    }

    public void processNextCustomer(Map<String, Item> itemMap) {
        if (queue.isEmpty()) {
            System.out.println("No customers to process.");
            return;
        }

        Customer customer = queue.poll();
        System.out.println("Processing " + customer.name + "'s purchase...");

        double total = 0.0;
        for (String itemName : customer.itemList) {
            Item item = itemMap.get(itemName);
            if (item == null) {
                System.out.println(itemName + " not found in store.");
            } else if (item.stock <= 0) {
                System.out.println(itemName + " is out of stock.");
            } else {
                total += item.price;
                item.stock--;
                System.out.println(itemName + ": $" + item.price + " (Remaining stock: " + item.stock + ")");
            }
        }

        System.out.printf("Total for %s: $%.2f%n", customer.name, total);
    }
}

public class SmartCheckout {
    public static void main(String[] args) {
        // Setup item catalog
        Map<String, Item> itemMap = new HashMap<>();
        itemMap.put("Apple", new Item("Apple", 0.5, 10));
        itemMap.put("Banana", new Item("Banana", 0.3, 5));
        itemMap.put("Milk", new Item("Milk", 1.2, 3));

        // Initialize checkout counter
        CheckoutCounter counter = new CheckoutCounter();

        // Create sample customers
        Customer alice = new Customer("Alice", Arrays.asList("Apple", "Milk", "Banana"));
        Customer bob = new Customer("Bob", Arrays.asList("Milk", "Milk", "Banana"));

        // Simulate checkout process
        counter.addCustomer(alice);
        counter.addCustomer(bob);

        counter.processNextCustomer(itemMap);
        counter.processNextCustomer(itemMap);

        // Try removing customer from empty queue
        counter.removeCustomer();
    }
}
