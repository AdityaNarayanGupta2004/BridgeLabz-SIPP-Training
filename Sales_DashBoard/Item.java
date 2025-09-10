import java.util.*;

public class Item {
    private String name;
    private String category;
    private double price;

    public Item(String n, String c, double p) {
        this.name = n;
        this.category = c;
        this.price = p;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + "Rs-" + price  ;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
