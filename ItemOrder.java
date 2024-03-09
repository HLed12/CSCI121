public class ItemOrder {

    public Item item;
    public int quantity;

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getOrderCost() {
        if (quantity >= 2) {
            int bulkQuant = quantity / 2;
            int singleQuan = quantity % 2;

            // bulkPrice wasn't explicit in the instructions, I made it so that the cost becomes
            // 1.5 item cost. so if quant = 2, instead of price * 2, it is price * 1.5
            // 1 of the 2 items are 50% off.
            double bulkPrice = item.getItemPrice() * 1.5;
            return bulkQuant * bulkPrice + singleQuan * item.getItemPrice();
        } else {
            return quantity * item.getItemPrice();
        }
    }

}