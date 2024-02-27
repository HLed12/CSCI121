import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BadSubscriptCaught {


    public static void main(String[] args) {
        String[] firstNames = {"Harry", "Jack", "Jason", "Mason",
                "Alex", "Tim", "Sobchuck", "Gram",
                "Atillio", "Ryan"};
        Scanner sc = new Scanner(System.in);
            try {
                System.out.println("Input an integer number 0-9");
                int index = sc.nextInt();
                System.out.println(firstNames[index]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Found exception: Array index out of bounds");
            } catch (ArithmeticException e) {
                System.out.println("Found arithmatic exception: invalid calculation");
            } catch (InputMismatchException e){
                System.out.println("Found exception: input is a mismatch. Make sure using integers");
            }

    }
}




