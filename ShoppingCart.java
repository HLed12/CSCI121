import java.util.ArrayList;

public class ShoppingCart {
    ArrayList<ItemOrder> list;

    public ShoppingCart() {
        list = new ArrayList<ItemOrder>();
    }

    public void addItemOrder(ItemOrder itemOrder) {
        list.add(itemOrder);
    }

    // Using an arrays, removeIf, method, it will remove every single order in the cart
    // that has the itemName inputted by the user. This is best because if the user inputs,
    // 'tissues' twice, it will delete both instances!
    public void removeItemOrder(String itemName) {
        list.removeIf(order -> order.item.getName().equals(itemName));
    }

    public boolean searchItemOrder(String itemName) {
        for (ItemOrder order : list) {
            if (order.item.getName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    public double getTotalCost() {
        double totalCost = 0.0;
        for (ItemOrder itemOrder : list) {
            totalCost += itemOrder.getOrderCost();
        }
        return totalCost;
    }
}