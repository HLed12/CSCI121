import java.util.Scanner;


public class Converter {

    // Convert function reads a double and returns the amount of coins that would satisfy this amount.
    // Calculates in descending order from quarters to dimes to nickels to pennies.
    public static void convert(double x){
        int quarters;
        int dimes;
        int nickels;
        int pennies;
        Scanner sc = new Scanner(System.in);

        // modified fixes error of hundreths place not rounding up properly (i.e., 0.987777 when should be 0.99)
        double modified;
        quarters = (int)(x / .25);
        modified = x - (quarters * .25);
        modified = Math.round(modified * 100.0) / 100.0;
        dimes = (int)(modified / .10);

        // decrease modified amount with remaining moneys.
        // Protects from rounding errors, even though typically only occurs for pennies
        modified -= (dimes * .10);
        modified = Math.round(modified * 100.0) / 100.0;
        nickels = (int)(modified / .05);
        modified -= (nickels * .05);
        modified = Math.round(modified * 100.0) / 100.0;
        pennies = (int)(modified / .01);

        // Inform user of the coinage
        System.out.println("Quarters: " + quarters + ", Dimes: " + dimes + ", Nickels: " + nickels +
                ", and Pennies: " + pennies);
    }


    // inquire function gathers user input, adjusts if there is '$' or not, and returns corrected double format
    public static double inquire(){
        System.out.println("Enter the amount of money you have and " +
                "I will convert the amount into coins for you. Optional: Use '$'");

        // must introduce scanner since it is a new function (having only in main causes errors)
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // use .replace, replace $ with nothing, thus deleting it. If no $ present, string stays intact.
        String inputedit = input.replace("$","");

        // Double.parseDouble, allows input of string to convert to double
        double amount = Double.parseDouble(inputedit);
        return amount;
    }


    // Has user provide their name. Runs inquire method to get desired amount to convert,
    // then uses the return of inquire (set as an object 'answer') to run convert, which
    // does the actual coin conversion. Then offers a transaction example, followed by one more test amount
    // with the option to quit at either of those stages.
    public static void main (String[]args){
        // insert scanner feature
        Scanner sc = new Scanner(System.in);

        // provide user a warning that values should not be smaller than hundreths/pennies.
        System.out.println("Warning: this converter rounds up in the hundreths place. Do not input values smaller " +
                        "than a penny.");
        System.out.println("Please enter your name.");
        String name = sc.nextLine();
        System.out.println("Hello, " + name + "!");

        // calls inquire method which cleans the inputted amount, set it to an object 'answer'
        double answer = inquire();

        // call convert method with cleaned inputted amount from inquire
        convert(answer);

        // if the user chooses to test a transaction, they will provide the money they have, and cost of the
        // product, which will then provide the coins remaining. If not, it will skip this.
        System.out.println("Would you like to do a transaction example? Enter 'yes' or 'no'");
        String transaction = sc.nextLine();
        if (transaction.equals(new String("yes")) == true) {
            // user inputs their money and the product cost
            System.out.println("How much money do you have on your person?");
            String owned = sc.nextLine();
            System.out.println("What is the cost of the item you would like to buy?");
            String product = sc.nextLine();

            // use .replace, replace $ with nothing, thus deleting it. If no $ present, string stays intact.
            String ownededit = owned.replace("$","");
            String productedit = product.replace("$","");

            // Double.parseDouble, allows input of string to convert to double
            double ownedamount = Double.parseDouble(ownededit);
            double productamount = Double.parseDouble(productedit);

            // If the remaining amount is positive, tell amount and give coinage via convert function, else give
            // error
            double difference = (ownedamount - productamount);
            if (difference <0){
                System.out.println("Error");
            }
            else {
                difference = Math.round(difference * 100.0) / 100.0;
                System.out.println("You will get $" + difference + " back. Assuming this amount is returned in only coins" +
                        ", you can expect the following...");
                convert(difference);
            }

        }
        // User that didn't want to do transaction will see this
        else {
            System.out.println("I will not execute a transaction, " + name + ".");
        }

        // give users the option to input one more amount
        System.out.println("Would you like to test another amount? Enter 'yes' or 'no'");
        String test = sc.nextLine();

        // sets if-else statement contingent on user inputting 'yes'. Utilizes .equals() function
        // creates string 'yes' inside, instead of creating a new object to point towards
        if (test.equals(new String("yes")) == true) {

            // if the user chooses to do another, repeat earlier process, program does not allow for a third test.
            double answertwo = inquire();
            convert(answertwo);
        }
        else {
            System.out.println("Have a nice day, " + name + ".");
        }

    }
}