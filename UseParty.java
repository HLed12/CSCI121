import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
public class UseParty extends JFrame implements ItemListener, ActionListener {

    JPanel panel;
    JPanel panelZero;
    JPanel panelOne;
    JPanel panelTwo;
    JPanel panelThree;
    JPanel panelFour;
    JTextField nameAns;
    JTextField partyAns;
    JTextField dinnerAns;

    JButton enter;

    ButtonGroup mealGroup;
    JCheckBox one, two;

    int dinnerChoice;
    int numParty;
    int numDinner;
    double foodCost;
    DinnerParty aDinnerParty = new DinnerParty();
    Party object = new Party();



    public UseParty() {
        panel = new JPanel(new GridLayout(9, 4));

        // Create Name, Party, and Dinner Party JLabels with a blank JTextField plus actionListener
        // Assign each to its own panel
        JLabel nameQuestion = new JLabel("Enter your name");
        nameAns = new JTextField();
        nameAns.addActionListener(this);
        panelZero = new JPanel(new GridLayout(1,2));
        panelZero.add(nameQuestion);
        panelZero.add(nameAns);

        JLabel partyQuestion = new JLabel("Enter number of guests for the party.");
        partyAns = new JTextField();
        partyAns.addActionListener(this);
        panelOne = new JPanel(new GridLayout(1,2));
        panelOne.add(partyQuestion);
        panelOne.add(partyAns);

        JLabel dinnerQuestion = new JLabel("Enter number of guests for the dinner party.");
        dinnerAns = new JTextField();
        dinnerAns.addActionListener(this);
        panelTwo = new JPanel(new GridLayout(1,2));
        panelTwo.add(dinnerQuestion);
        panelTwo.add(dinnerAns);


        // Meal option will use JCheckBox instead
        JLabel mealQuestion = new JLabel("Choose type of dinner party.");
        one = new JCheckBox("Option 1 - Meat", false);
        one.addItemListener(this);
        two = new JCheckBox("Option 2 - Vegetarian", false);
        two.addItemListener(this);

        // add each to a buttongroup so that only one option can be selected for a dinner party
        mealGroup = new ButtonGroup();
        mealGroup.add(one);
        mealGroup.add(two);

        panelThree = new JPanel(new GridLayout(1,3));
        panelThree.add(mealQuestion);
        panelThree.add(one);
        panelThree.add(two);

        // Create an enter button that will produce the output then reset the page
        enter = new JButton("Enter party information");
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if enter is selected, makes sure that the user did not enter a non Int value for both guest fields.
                // Handles use of non-numeric values and doubles.
                try {
                    int partyGuesser = Integer.parseInt(partyAns.getText());
                    int dinnerGuesser = Integer.parseInt(dinnerAns.getText());
                } catch(Exception ex) {
                    System.out.println("Found Exception");
                    JOptionPane.showMessageDialog(null, "Must enter value for " +
                            "Party and Dinner Party. Must be Integers.");
                }


                // Change inputs to int form.
                int partyGuesser = Integer.parseInt(partyAns.getText());
                int dinnerGuesser = Integer.parseInt(dinnerAns.getText());
                int dinnerMealer = aDinnerParty.getDinnerChoice();

                // Updates the meal choice in the DinnerParty class
                // and introduces new variable that gives the cost for food
                if(one.isSelected() == true) {
                    aDinnerParty.setDinnerChoice(1);
                    foodCost = dinnerGuesser * 20.25;
                } else if(two.isSelected() == true){
                    aDinnerParty.setDinnerChoice(2);
                    foodCost = dinnerGuesser * 25.25;
                } else {
                    aDinnerParty.setDinnerChoice(0);
                }

                // Ensures the name TextField is not blank
                Boolean nameTest = nameAns.getText().equals("");

                // When proper values are inputted, will show invitation
                if (partyGuesser > 0 && dinnerGuesser > 0 && dinnerMealer != 0 && nameTest != true) {

                    // set values to DinnerParty and Party class
                    object.setGuests(Integer.parseInt(partyAns.getText()));
                    aDinnerParty.setGuests(Integer.parseInt(dinnerAns.getText()));


                    // Displays the inputted values using displayInvitation from Party class
                    JOptionPane.showMessageDialog(null, "Dinner Party Finalized!" + "\n" +
                            "You're estimated food cost is: $" + foodCost + "\n" +
                            "The following is how your invitation will look:" + "\n" +  "\n" + "\n"
                            + nameAns.getText().toUpperCase() + "'s Dinner Party" + "\n" +
                            aDinnerParty.displayInvitation(aDinnerParty, object));

                    // Resets inputs to allow for fresh page
                    nameAns.setText("");
                    partyAns.setText("");
                    dinnerAns.setText("");
                    mealGroup.clearSelection();
                    aDinnerParty.setDinnerChoice(0);


                    // if a meal is not selected, name not entered or negative integer inputted,
                    // shows a pop-up and does not wipe the page. User must make corrections.
                } else {
                    JOptionPane.showMessageDialog(null, "Must enter your name, " +
                            "select a meal option and input a positive integer for guest counts.");
                }
            }


        });

        panelFour = new JPanel(new GridLayout(1,1));
        panelFour.add(enter);

        // add each panel to the overarching panel.
        panel.add(panelZero);
        panel.add(panelOne);
        panel.add(panelTwo);
        panel.add(panelThree);
        panel.add(panelFour);

        add(panel);

        // Set basic rules for JFrame
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // Sets the dinner choice based on selected box
        if(e.getSource() == one){
            dinnerChoice = 1;
            aDinnerParty.setDinnerChoice(dinnerChoice);
        } else {
            dinnerChoice = 2;
            aDinnerParty.setDinnerChoice(dinnerChoice);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Sets the amount of guests for the party and dinner party based on user input
        if (e.getSource() == partyAns) {
            numParty = Integer.parseInt(e.getActionCommand());
            object.setGuests(numParty);
        }
        if (e.getSource() == dinnerAns){
            numDinner = Integer.parseInt(e.getActionCommand());
            aDinnerParty.setGuests(numDinner);
        }

    }

    // Call the function to make the GUI
    public static void main(String args[]) {
        new UseParty();
    }







    // CODE FOR BEFORE GUI
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter number of guests for the party.");

//        int guestCount = sc.nextInt();
//        Party object = new Party();
//        object.setGuests(guestCount);

//        System.out.println("Enter number of guests for the dinner party.");

//        int choices = sc.nextInt();
//        DinnerParty aDinnerParty = new DinnerParty();
//        aDinnerParty.setGuests(choices);

//        System.out.println("Enter type of dinner party. Options: 1 for 'meat' or 2 for 'vegetarian'.");

//        int dinnerChoice = sc.nextInt();
//        aDinnerParty.setDinnerChoice(dinnerChoice);
//        aDinnerParty.getDinnerChoice();
//        aDinnerParty.displayInvitation(aDinnerParty, object);

//        }
}