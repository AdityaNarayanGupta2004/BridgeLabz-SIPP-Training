import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStore {
    public static Map<String, List<Map<String, List<Order>>>> getCityToStoresMap() {
        Map<String, List<Map<String, List<Order>>>> cityToStoresMap = new HashMap<>();

        // Example data for testing
        Item phone = new Item("Smartphone", "Electronics", 800);
        Item blender = new Item("Blender", "Home Appliances", 120);
        Item dumbbell = new Item("Dumbbell", "Fitness", 50);

        Order o1 = new Order(LocalDate.now().minusDays(10), Arrays.asList(phone, blender));
        Order o2 = new Order(LocalDate.now().minusDays(20), Arrays.asList(phone, dumbbell));
        Order o3 = new Order(LocalDate.now().minusDays(30), Arrays.asList(blender, dumbbell));

        Map<String, List<Order>> store1 = new HashMap<>();
        store1.put("cust1", Arrays.asList(o1, o2, o3));

        cityToStoresMap.put("New York", Arrays.asList(store1));

        return cityToStoresMap;
    }
    
}
