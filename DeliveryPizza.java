import java.util.Arrays;

public class DeliveryPizza extends Pizza{
    private int fee;
    private String address;

    public void setTakeout(String[] topping, String address, int quant) {
        this.address = address;
        price = 14 + (2 * (topping.length));

        if(price > 18) { fee = 3;}
        else { fee = 5;}
        String T = Arrays.toString(topping);
        T = T.replace("[","");
        T = T.replace("]", "");
        System.out.println("Pizza with " + T + " for $" + (price + fee) +
                " to " + address);
    }
}
