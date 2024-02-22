import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        double[] list = new double[20];
        System.out.println("Enter 20 integer values only.");
        int i;
        for (i = 0; i < list.length; i++) {
            System.out.println("value at index " + i);
            Scanner sc = new Scanner(System.in);
            double input = sc.nextDouble();
            list[i] = input;
            System.out.println(list[i]);
            if(i == 19) {
                System.out.println("You have filled the array");
            }

        }
    }
}


