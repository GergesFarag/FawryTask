package Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Models.Shippable;
public class ShippingService {
    public static void ship(List<Shippable> items) {
        double totalWeight = 0;
        if (items.isEmpty()) return;

        System.out.println("** Shipment notice **");
        Map<String, Integer> itemCount = new HashMap<>();
        Map<String, Double> itemWeight = new HashMap<>();

        for (Shippable item : items) {
            String name = item.getName();
            itemCount.put(name, itemCount.getOrDefault(name, 0) + 1);
            itemWeight.put(name, item.getWeight());
            totalWeight += item.getWeight();
        }

        for (var entry : itemCount.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();
            double weight = itemWeight.get(name);
            System.out.printf("%dx %s\t%.0fg%n", count, name, weight);
        }

        System.out.printf("Total package weight %.3fkg%n", totalWeight / 1000.0);
    }
}