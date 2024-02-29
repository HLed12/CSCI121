import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


public class TestWedding extends JFrame implements ActionListener {
    // Declare some variables
    JLabel brideQ, groomQ, dateQ, locationQ;
    JTextField brideAns, groomAns, dateAns, locationAns;

    JButton enter;

    Person bride = new Person();
    Person groom = new Person();
    Couple cup = new Couple();
    Wedding wed = new Wedding();

    JPanel panOne, panTwo, panThree, panFour, panFive, panJF2;


    public TestWedding() {
        // Create an inital JFrame and a second one that appears once a button is clicked
        JFrame jFrame1 = new JFrame("Input Wedding Details" );
        jFrame1.setLayout(new GridLayout(5,1));

        JFrame jFrame2 = new JFrame("Wedding Details");
        jFrame2.setLayout(new GridLayout(1,1));



        // Create JLabels and JTextFields with ActionListeners to take what the user inputs
        brideQ = new JLabel("Enter Bride's full name");
        brideAns = new JTextField("", 20);
        brideAns.addActionListener(this);

        groomQ = new JLabel("Enter Groom's full name");
        groomAns = new JTextField("", 20);
        groomAns.addActionListener(this);

        dateQ = new JLabel("Enter the date (Format: yyyy-mm-dd)");
        dateAns = new JTextField("", 20);
        dateAns.addActionListener(this);

        locationQ = new JLabel("Enter location details");
        locationAns = new JTextField("", 20);
        locationAns.addActionListener(this);


        // Create an enter button that will produce the invitation and hide the current JFrame
        enter = new JButton("Enter party information");
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Ensures the TextFields are not blank
                Boolean brideTest = brideAns.getText().equals("");
                Boolean groomTest = groomAns.getText().equals("");
                Boolean dateTest = dateAns.getText().equals("");
                Boolean locationTest = locationAns.getText().equals("");


                // When proper values are inputted, will show invitation
                if (brideTest != true && groomTest != true && dateTest != true && locationTest != true) {

                    String s = " ";

                    // use split function to catch the bride/grooms name in an array then separate it into two Strings
                    String bridesName = brideAns.getText();
                    bridesName = bridesName.strip();
                    String[] arrayOfBride = bridesName.split(s, 2);
                    String brideFirst = arrayOfBride[0].strip();
                    String brideLast = arrayOfBride[1].strip();

                    String groomsName = groomAns.getText();
                    groomsName = groomsName.strip();
                    String[] arrayOfGroom = groomsName.split(s, 2);
                    String groomFirst = arrayOfGroom[0].strip();
                    String groomLast = arrayOfGroom[1].strip();


                    //Catches the date into a string
                    LocalDate date = LocalDate.parse(dateAns.getText());
                    String location = locationAns.getText();

                    // set values to Person, Couple, and Wedding class
                    bride.setFirstName(brideFirst);
                    bride.setLastName(brideLast);
                    groom.setFirstName(groomFirst);
                    groom.setLastName(groomLast);
                    cup.setCouple(bride, groom);
                    wed.setWedding(cup, date, location);

                    //Start to format the invitation with JLabels and alter their fonts
                    JLabel header = new JLabel("Wedding Invitation");
                    header.setFont(new Font("Times New Roman", Font.ITALIC, 20));

                    JLabel brideNGroom = new JLabel(wed.getCouple().getBride().getFirstName() + " " +
                            wed.getCouple().getBride().getLastName() + " and " +
                            wed.getCouple().getGroom().getFirstName() + " " + wed.getCouple().getGroom().getLastName());
                    brideNGroom.setFont(new Font("Times New Roman", Font.BOLD, 14));

                    JLabel datee = new JLabel("On " + String.valueOf(wed.getDate()));
                    datee.setFont(new Font("Times New Roman", Font.BOLD, 12));

                    JLabel loc = new JLabel("At " + wed.getLocation());
                    loc.setFont(new Font("Times New Roman", Font.BOLD, 12));

                    JLabel question = new JLabel("Contact 'harry@yahoo.com' to confirm");
                    question.setFont(new Font("Times New Roman", Font.PLAIN, 10));


                    // For simplicity with GridLayout, using blank JLabels to put useful data in the middle of the GUI
                    JPanel top = new JPanel(new GridLayout(1,3));
                    top.add(new JLabel(" "));
                    top.add(header);
                    top.add(new JLabel(" "));

                    JPanel topO = new JPanel(new GridLayout(1,3));
                    topO.add(new JLabel(" "));
                    topO.add(brideNGroom);
                    topO.add(new JLabel(" "));

                    JPanel topI = new JPanel(new GridLayout(1,3));
                    topI.add(new JLabel(" "));
                    topI.add(datee);
                    topI.add(new JLabel(" "));

                    JPanel topL = new JPanel(new GridLayout(1,3));
                    topL.add(new JLabel(" "));
                    topL.add(loc);
                    topL.add(new JLabel(" "));

                    JPanel topE = new JPanel(new GridLayout(1,3));
                    topE.add(new JLabel(" "));
                    topE.add(question);
                    topE.add(new JLabel(" "));

                    // Make invitation light red
                    top.setBackground(new Color(255,114,118));
                    topO.setBackground(new Color(255,114,118));
                    topI.setBackground(new Color(255,114,118));
                    topL.setBackground(new Color(255,114,118));
                    topE.setBackground(new Color(255,114,118));


                    // put each panel in order onto an overarching panel
                    panJF2 = new JPanel(new GridLayout(5,1));
                    panJF2.add(top);
                    panJF2.add(topO);
                    panJF2.add(topI);
                    panJF2.add(topL);
                    panJF2.add(topE);






                    // Set basic rules for JFrame
                    jFrame2.setSize(700,300);
                    jFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jFrame2.setLocationRelativeTo(null);

                    // Add everything to the JFrame
                    jFrame2.add(panJF2);

                    // Gets rid of old JFrame and shows new one
                    jFrame1.setVisible(false);
                    jFrame2.setVisible(true);

                    // Does not move forward if anything is inputted incorrectly
                    // Gives user suggestions as to what went wrong
                } else {
                    JOptionPane.showMessageDialog(null, "Must enter all fields. " +
                            "Please ensure the date is formatted with yyyy-mm-dd and nothing else");
                }
            }


        });

        // This is the remaing set up for the initial jFrame1
        panOne = new JPanel(new GridLayout(1,2));
        panTwo = new JPanel(new GridLayout(1,2));
        panThree = new JPanel(new GridLayout(1,2));
        panFour = new JPanel(new GridLayout(1,2));
        panFive = new JPanel(new GridLayout(1,2));


        // add each component to the panel.
        panOne.add(brideQ);
        panOne.add(brideAns);

        panTwo.add(groomQ);
        panTwo.add(groomAns);

        panThree.add(dateQ);
        panThree.add(dateAns);

        panFour.add(locationQ);
        panFour.add(locationAns);

        panFive.add(enter);


        // Add each panel to the overarching panel
        JPanel panJF1 = new JPanel(new GridLayout(5,1));
        panJF1.add(panOne);
        panJF1.add(panTwo);
        panJF1.add(panThree);
        panJF1.add(panFour);
        panJF1.add(panFive);

        jFrame1.add(panJF1);

        // Set basic rules for jFrame1
        jFrame1.setSize(600,600);
        jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame1.setLocationRelativeTo(null);
        jFrame1.setVisible(true);

    }

    // Requires an @Override even though all edits were made based on the 'enter' button. Explanation for this being empty
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // Call the function to make the GUI
    public static void main(String args[]) {new TestWedding();}
}


















//    # BEFORE GUI APPRAOCH
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Enter Bride's first and last name");
//        String bridesName = sc.nextLine();
//        System.out.println("Enter Groom's first and last name");
//        String groomsName = sc.nextLine();
//
//
//        // Strips the name of any spaces before or after. This also ensures that the split will take correctly
//        // formatted first and last names (i.e., the first name won't become ('   Jack')
//        String s = " ";
//
//        bridesName = bridesName.strip();
//        String[] arrayOfBride = bridesName.split(s, 2);
//        String brideFirst = arrayOfBride[0].strip();
//        String brideLast = arrayOfBride[1].strip();
//        Person bride = new Person();
//        bride.setFirstName(brideFirst);
//        bride.setLastName(brideLast);
//
//        groomsName = groomsName.strip();
//        String[] arrayOfGroom = groomsName.split(s, 2);
//        String groomFirst = arrayOfGroom[0].strip();
//        String groomLast = arrayOfGroom[1].strip();
//        Person groom = new Person();
//        groom.setFirstName(groomFirst);
//        groom.setLastName(groomLast);
//
//        Couple cup = new Couple();
//        cup.setCouple(bride, groom);
//
//
//
//        System.out.println("Enter the date of the wedding. Format: yyyy-mm-dd, include leading zeros for single " +
//                "digit values.");
//        String dateString = sc.nextLine();
//        LocalDate date = LocalDate.parse(dateString);
//        System.out.println(date);
//
//
//        System.out.println("Enter the location of the venue");
//        String location = sc.nextLine();
//
//        Wedding wed = new Wedding();
//        wed.setWedding(cup, date, location);
//
//
//        wed.printWeddingDetails();
//
//    }
//}
