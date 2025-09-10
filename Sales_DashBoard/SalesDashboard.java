import java.util.List;
import java.util.Map;

public class SalesDashboard {
    public static void main(String[] args) {
        Map<String, List<Map<String, List<Order>>>> cityToStoresMap = DataStore.getCityToStoresMap();
        SalesAnalyzer analyzer = new SalesAnalyzer(cityToStoresMap);

        List<Item> topPicks = analyzer.getTopAffordablePicks();
        Map<String, List<Item>> grouped = analyzer.groupByCategory(topPicks);
        
        System.out.println("\n--- Dashboard Insights ---");
        System.out.println("Grouped By Category: " + grouped);
        System.out.println("Electronics Count: " + analyzer.countElectronics(grouped));
        System.out.println("Any Above $500? " + analyzer.anyAbove500(topPicks));
        System.out.println("All Above $10? " + analyzer.allAbove10(topPicks));
        System.out.println("None Empty Names? " + analyzer.noneEmptyNames(topPicks));
        System.out.println("First Home Appliance: " + analyzer.firstHomeAppliance(grouped));
        System.out.println("Any Fitness Item: " + analyzer.anyFitness(grouped));
        System.out.println("Total Value of Picks: $" + analyzer.totalValue(topPicks));
    }
}
