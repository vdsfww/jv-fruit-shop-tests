package core.basesyntax.strategy;

import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> inventory, String fruit, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity for purchase cannot be negative");
        }
        int currentQuantity = inventory.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Not enough stock for " + fruit);
        }
        inventory.put(fruit, currentQuantity - quantity);
    }
}
