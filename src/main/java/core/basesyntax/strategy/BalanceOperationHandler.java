package core.basesyntax.strategy;

import core.basesyntax.service.InventoryService;

public class BalanceOperationHandler implements OperationHandler {
    private final InventoryService inventoryService = new InventoryService();

    public BalanceOperationHandler() {
    }

    @Override
    public void apply(String fruit, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        inventoryService.addFruit(fruit, quantity);
    }
}
