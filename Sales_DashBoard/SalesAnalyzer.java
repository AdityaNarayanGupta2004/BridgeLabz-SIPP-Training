import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalesAnalyzer {
     private final Map<String, List<Map<String, List<Order>>>> cityToStoresMap;

    public SalesAnalyzer(Map<String, List<Map<String, List<Order>>>> cityToStoresMap) {
        this.cityToStoresMap = cityToStoresMap;
    }

    public List<Item> getTopAffordablePicks() {
        return cityToStoresMap.values().stream()
            .flatMap(List::stream) // stores
            .flatMap(store -> store.values().stream()) // customers' orders
            .filter(orders -> orders.stream()
                    .filter(o -> o.getDate().isAfter(LocalDate.now().minusDays(60)))
                    .count() >= 3)
            .flatMap(orders -> orders.stream()
                    .flatMap(order -> order.getItems().stream()))
            .distinct()
            .sorted(Comparator.comparingDouble(Item::getPrice).reversed())
            .peek(item -> System.out.println("Processing: " + item))
            .skip(2)
            .limit(10)
            .collect(Collectors.toList());
    }

    public Map<String, List<Item>> groupByCategory(List<Item> items) {
        return items.stream().collect(Collectors.groupingBy(Item::getCategory));
    }

    public long countElectronics(Map<String, List<Item>> grouped) {
        return grouped.getOrDefault("Electronics", List.of()).size();
    }

    public boolean anyAbove500(List<Item> items) {
        return items.stream().anyMatch(i -> i.getPrice() > 500);
    }

    public boolean allAbove10(List<Item> items) {
        return items.stream().allMatch(i -> i.getPrice() > 10);
    }

    public boolean noneEmptyNames(List<Item> items) {
        return items.stream().noneMatch(i -> i.getName() == null || i.getName().trim().isEmpty());
    }

    public Optional<Item> firstHomeAppliance(Map<String, List<Item>> grouped) {
        return grouped.getOrDefault("Home Appliances", List.of()).stream().findFirst();
    }

    public Optional<Item> anyFitness(Map<String, List<Item>> grouped) {
        return grouped.getOrDefault("Fitness", List.of()).stream().findAny();
    }

    public double totalValue(List<Item> items) {
        return items.stream().map(Item::getPrice).reduce(0.0, Double::sum);
    }
}
