import java.time.LocalDate;
import java.util.*;

public class Order {
     LocalDate date;
     List<Item> items;

    public Order(LocalDate d, List<Item> it) {
        this.date = d;
        this.items = it;
    }

    public LocalDate getDate() { return date; }
    public List<Item> getItems() { return items; }
}
