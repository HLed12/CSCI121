import java.util.Arrays;
import java.util.Scanner;

public class DemoPizza {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your toppings. Type 'quit' to stop");


        // search for the first null index then make a new array and iterate thru the old adding to the new one.

        // Initializes a 10 space/element array and adds to it for each user input.
        // Once it reaches 10, will inform user that the maximum amount of toppings have been added and print the
        // toppings chosen (deleting brackets from the print)

        String[] top = new String[10];
        int i;
        for (i = 0; i < top.length + 1; i++) {
            if (i == 10) {
                System.out.println("Maximum toppings");
                String T = Arrays.toString(top);
                T = T.replace("[", "");
                T = T.replace("]", "");
                System.out.println(T);

                // If the user does not enter 10 toppings, 2 things will occur. First, it will check if they entered
                // quit, in which case it will create a new array with the quantity of toppings as the amount of
                // elements (which saves space). It utilizes an intermediate array which gets NULLed out after.

                // The other option: quit is not inputted, and the user's topping is added to the original arrays
                // index.

            } else {
                String k = sc.nextLine();
                String test = k.toUpperCase();
                String stop = "QUIT";

                if (test.equals(stop)) {
                    int z = i;
                    String[] top1 = new String[z];
                    int b = 0;
                    for(b = 0; b < z; b++) {
                        top1[b] = top[b];
                    }

                    // resets the top object to top1 so that the final output can always return top and be correct.
                    top = top1;
                    String T = Arrays.toString(top);
                    T = T.replace("[", "");
                    T = T.replace("]", "");
                    System.out.println(T);

                    // Sets new top1 array to null to save space and be deleted in the future
                    top1 = null;
                    break;
                } else {
                    // adds the input to the next index of the array
                    top[i] = k;
                }
            }
        }


        // Portion regarding delivery. If the user wants delivered, will ask for address and use the DeliveryPizza
        // class. If not, will excuted the Pizza class and NOT ask about the address.
        System.out.println("Will your pizza be delivered? yes or no. If unknown value, will be treated as 'no'");
        String ans = sc.nextLine();
        ans = ans.toLowerCase();
        String yes = "yes";
        String no = "no";
        if(ans.equals(yes)) {
            System.out.println("Please enter your address");
            String addy = sc.nextLine();
            DeliveryPizza deliv = new DeliveryPizza();
            int quant = top.length;
            deliv.setTakeout(top, addy, quant);

        } else {
            System.out.println("Please arrive in 20-30 minutes to pick up your order. Thank you for your service.");
            Pizza inPerson = new Pizza();
            int quant = top.length;
            String output = inPerson.setStuff(top, quant);
            inPerson.toString(output);
        }

    }
}
