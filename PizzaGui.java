import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PizzaGui extends JFrame implements ItemListener, ActionListener {
//    Initially declare lots of objects so that they can be altered from different functions and @Overrides
    ButtonGroup pizzaSizeGroup;
    JCheckBox small, medium, large, superd;
    JPanel panel;
    JPanel panelTwo;
    JPanel panelThree;
    JPanel panelFour;
    JPanel panelFive;
    JPanel panelSix;
    JPanel panelSixTwo;
    JPanel panelSeven;


    JComboBox topOne;
    JComboBox topTwo;
    JComboBox topThree;

    String top1;
    String top2;
    String top3;
    BasicArrowButton arrowUp;
    BasicArrowButton arrowDown;
    int countOne;
    int countTwo;
    int countThree;
    int count = 0;
    int pizzaCount = 1;
    double extra = 0;
    double initialcost = 0;


    String selection;
    String x;
    String y;
    String z;

    JLabel arrows = new JLabel("Total Pizzas: 1");
    JLabel order = new JLabel("Order: ");
    JLabel cost = new JLabel("Total Cost: ");





    public PizzaGui() {
        //super("PizzaAppl"); DELETE BEFORE SUBMIT


        // set up the basic structure of the GUI
        // Approach is having many smaller panels add onto a bigger one in the correct order. Initial 'panel' has
        // the 'heading', then gets the other panels added onto it.
        panel = new JPanel(new GridLayout(9,4));

        JLabel heading = new JLabel("Welcome to BigY Pizza Pick-Up Service. To start, choose a size");

        panel.add(heading, BorderLayout.CENTER);

        // Create 4 check boxes for the different size of the pizza. Adding ItemListeners so can tell when selected
        small = new JCheckBox("Small - $5", false);
        small.addItemListener(this);
        medium = new JCheckBox("Medium - $10", false);
        medium.addItemListener(this);
        large = new JCheckBox("Large - $15", false);
        large.addItemListener(this);
        superd = new JCheckBox("Super - $20", false);
        superd.addItemListener(this);

        // add each to a buttongroup so that only one size can be selected for a single pizza
        pizzaSizeGroup = new ButtonGroup();
        pizzaSizeGroup.add(small);
        pizzaSizeGroup.add(medium);
        pizzaSizeGroup.add(large);
        pizzaSizeGroup.add(superd);

        // 'panelTwo' holds the sizing
        panelTwo = new JPanel(new GridLayout(1,4));
        panelTwo.add(small);
        panelTwo.add(medium);
        panelTwo.add(large);
        panelTwo.add(superd);

        // panelThree gives costs/info about toppings
        panelThree = new JPanel(new GridLayout(1,1));
        JLabel toppings = new JLabel("Additional Toppings: 1 - $0.50, 2 - $1, 3 - $1.25. " +
                "Maximum of 3 toppings. Extra Cheese is FREE! ");
        panelThree.add(toppings);

        // two sets of topping lists, one includes extra cheese. Prevents user from adding Extra Cheese more than once
        String topps[] = { "No Topping", "Extra Cheese", "Pepperoni", "Mushroom", "Pineapple", "Buffalo Chicken",
                            "Barbecue Chicken", "Burger"};
        String toppsNoCheese[] = {"No Topping", "Pepperoni", "Mushroom", "Pineapple", "Buffalo Chicken",
                                  "Barbecue Chicken", "Burger"};
        // Use a Combo Box for each of the three added toppings. Adds ItemListeners.
        topOne = new JComboBox(topps);
        topOne.addItemListener(this);
        topTwo = new JComboBox(toppsNoCheese);
        topTwo.addItemListener(this);
        topThree = new JComboBox(toppsNoCheese);
        topThree.addItemListener(this);

        // Give each topping its own panel/row
        panelFour = new JPanel(new GridLayout(1,1));
        panelFour.add(topOne);
        panelFive = new JPanel(new GridLayout(1,1));
        panelFive.add(topTwo);
        panelSix = new JPanel(new GridLayout(1,1));
        panelSix.add(topThree);

        // Create arrow buttons for adding pizzas
        arrowUp = new BasicArrowButton(BasicArrowButton.NORTH);
        arrowUp.addActionListener(this);
        arrowDown = new BasicArrowButton(BasicArrowButton.SOUTH);
        arrowDown.addActionListener(this);

        // Add the JLabel arrows (outside of this function) along with the two arrow buttons to 'panelSixTwo'
        panelSixTwo = new JPanel(new GridLayout(1,2));
        panelSixTwo.add(arrows);
        panelSixTwo.add(arrowUp);
        panelSixTwo.add(arrowDown);

        // Add all of the above panels to the main panel (in order)
        panel.add(panelTwo);
        panel.add(panelThree);
        panel.add(panelFour);
        panel.add(panelFive);
        panel.add(panelSix);
        panel.add(panelSixTwo);

        // Add another panel that will total the cost and give a short description of the order/chosen food
        // Both objects created outside of this function as well to allow modifications in other functions
        panelSeven = new JPanel(new GridLayout(3,1));
        panelSeven.add(cost);
        panelSeven.add(order);

        // Add an 'add to cart' feature. Resets the page once clicked. Also doesn't work unless user picks a size
        // for their pizza to reference a real website which would not let someone order only Pepperoni.
        JButton addCart = new JButton("Add to cart");
        addCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // if a size is selected, reset ButtonGroup, ComboBox, Amount of pizzas, cost, and order description
                if (small.isSelected() || medium.isSelected() || large.isSelected() || superd.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Added to order!");
                    pizzaSizeGroup.clearSelection();
                    topOne.setSelectedIndex(0);
                    topTwo.setSelectedIndex(0);
                    topThree.setSelectedIndex(0);
                    cost.setText("Total Cost: ");
                    order.setText("Order: ");
                    pizzaCount = 1;
                    arrows.setText("Total Pizzas: " + pizzaCount);
                    initialcost = 0;
                    extra = 0;

                    // if a size is not selected, show an error
                } else {
                    JOptionPane.showMessageDialog(null, "Error: select the size of " +
                            "your pizza.");
                }
            }
        });

        // Adds to 'panelSeven' and the main 'panel'
        panelSeven.add(addCart);
        panel.add(panelSeven);

        // Adds everything onto the JFrame
        add(panel);



        // Set basic rules for JFrame
        setSize(900,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


    }
        // Call the function to make the GUI
    public static void main(String args[]) {
        new PizzaGui();
    }

    // ActionListener for the buttons. Adds one when user clicks arrows up, deletes when clicks arrow down. Doesn't
    // allow to go below 1. Also ensures that the cost updates with this. (a second pizza adds the pizza cost AND
    // toppings)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == arrowUp) {
            pizzaCount += 1;
            arrows.setText("Total Pizzas: " + pizzaCount);
            cost.setText("Total Cost: " + (pizzaCount * (initialcost + extra)));

        } else if (e.getSource() == arrowDown){
            if(pizzaCount > 1) {
                pizzaCount -= 1;
                arrows.setText("Total Pizzas: " + pizzaCount);
                cost.setText("Total Cost: " + (pizzaCount * (initialcost + extra)));

            }
        }
    };

    // Item Listener for the ButtonGroup (sizes) and ComboBox (toppings)
    // ButtonGroup will update the cost and order based on selection.
    // First ComboBox makes sure if 'extra cheese' or 'no topping' is selected that it doesn't increase the count
    // (count is recording the number of toppings. Since both of those don't cost anything, do not want to count them.
    // Other two ComboBoxes just check for 'no topping'. All three also update the order description.

    @Override
    public void itemStateChanged(ItemEvent e) {
        x = String.valueOf(topOne.getSelectedItem());
        y = String.valueOf(topTwo.getSelectedItem());
        z = String.valueOf(topThree.getSelectedItem());
        if(e.getSource() == small){
                    initialcost = 5;
                    selection = "Small";
                } else if(e.getSource()== medium) {
                    initialcost = 10;
                    selection = "Medium";
                } else if(e.getSource() == large) {
                    initialcost = 15;
                    selection = "Large";
                } else if(e.getSource() == superd){
                    initialcost = 20;
                    selection = "Super";
                }

        if(x.equals("Extra Cheese")) {
            top1 = x;
            countOne = 0;
        } else if (x.equals("No Topping")) {
            top1 = x;
            countOne = 0;
        } else {
            countOne = 1;
            top1 = x;
        }


        if (y.equals("No Topping")) {
            top2 = y;
            countTwo = 0;
        } else {
            countTwo = 1;
            top2 = y;
        }

        if (z.equals("No Topping")) {
            top3 = z;
            countThree = 0;
        } else {
            countThree = 1;
            top3 = z;
        }

        // Sets price of toppings based on criteria
        count = (countOne + countTwo + countThree);
        if (count == 3) {
            extra = 1.25;
        }
        if (count == 2) {
            extra = 1;
        }
        if (count == 1) {
            extra = 0.5;
        }
        if (count == 0) {
            extra = 0;
        }

        // Updates the JLabels for cost and order description with each new selection
        cost.setText("Total Cost: " + (pizzaCount * (initialcost + extra)));
        order.setText("Order: " + selection + " pizza with " + top1 + ", " + top2 + ", " + top3);    //REPLACE X Y Z WITH TOP1 TOP2 TOP3, and only worry about counting for the total cost.

    }

}