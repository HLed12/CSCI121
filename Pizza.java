import java.util.Arrays;

public class Pizza {
    private String[] topping;
    private int quantity;

    // protected allows it to be visible to the DeliveryPizza class as well
    protected int price;

    public String setStuff(String[] topping, int quantity) {
        this.topping = topping;
        this.quantity = quantity;
        price = 14 + (2 * (topping.length));

        String T = Arrays.toString(topping);
        T = T.replace("[", "");
        T = T.replace("]", "");

        String s = "1 Pizza with the following toppings: " + T + " for $" + price;

        return(s);
    }

    public void toString(String s) {
        System.out.println(s);
    }
}
