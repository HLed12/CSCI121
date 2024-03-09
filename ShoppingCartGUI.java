import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ShoppingCartGUI extends JFrame implements ItemListener, ActionListener {

    ShoppingCart cart = new ShoppingCart();

    public ShoppingCartGUI(){
        // Sets up the inital JFrame with the user's ability to input an item, its price, and the quantity. As well as
        // search, remove, and total.
        JFrame frame = new JFrame("Shopping Cart");
        JLabel itemLabel = new JLabel("Item: ");
        JTextField itemField = new JTextField(10);
        JLabel priceLabel = new JLabel("Price: ");
        JTextField priceField = new JTextField(10);
        JLabel quantityLabel = new JLabel("Quantity: ");
        JTextField quantityField = new JTextField(10);
        JButton addButton = new JButton("Add to Cart");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Creates the user's inputted info as an Item and the ItemOrder. Then adds them to a new shopping cart
                // called 'cart'
                String itemName = itemField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                double itemPrice = Double.parseDouble(priceField.getText());

                Item item = new Item(itemName, itemPrice);

                ItemOrder order1 = new ItemOrder(item, quantity); // 5 boxes of tissues

                cart.addItemOrder(order1);
            }
        });

        // Creates the total button. Will show user the cart total cost. Then show details regarding each item in the
        // cart
        JButton totalButton = new JButton("Get Total");
        totalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double totalCost = cart.getTotalCost();
                JOptionPane.showMessageDialog(frame, "Total Cost: " + totalCost);

                JFrame cartFrame = new JFrame("Items in Cart");
                cartFrame.setSize(300,300);

                // JTextArea's giving a blank space to add text. Represents the shopping cart
                JTextArea textArea = new JTextArea();
                for (ItemOrder order1 : cart.list) {
                    textArea.append("Item: " + order1.item.getName() +  ", Quantity: " + order1.getQuantity() +
                            ", Item Cost: $" + order1.getOrderCost() + "\n");
                }

                // Sets the JFrame with the JTextArea that holds all the ArrayList's items (the items in the
                // shopping cart).
                cartFrame.add(new JScrollPane(textArea));
                cartFrame.setVisible(true);
            }
        });

        // This presents the search for an item button. It is case-sensitive!
        JButton search = new JButton("Search for an Item");
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemName = JOptionPane.showInputDialog(null, "Enter the name of the item" +
                        " to search for in your cart:");

                System.out.println(cart.searchItemOrder(itemName));
                JFrame searchFrame = new JFrame("Search for Items");
                searchFrame.setSize(300,300);

                // Tells user if item is in cart or not
                if (cart.searchItemOrder(itemName) == true) {
                    JOptionPane.showMessageDialog(null, "Item is in cart.");
                } else {
                    JOptionPane.showMessageDialog(null, "Item is not in cart.");

                }

            }
        });


        // Creates a remove JButton. User must enter a case-sensitive item name, if the item is present, it will
        // remove all instances of it
        JButton remove = new JButton("Remove an Item");
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemName = JOptionPane.showInputDialog(null, "Enter the name of the item" +
                        " to search for in your cart:");

                System.out.println(cart.searchItemOrder(itemName));
                JFrame searchFrame = new JFrame("Search for Items");
                searchFrame.setSize(300,300);


                // Informs user if the item was removed or not in the cart
                if (cart.searchItemOrder(itemName) == true) {
                    cart.removeItemOrder(itemName);
                    JOptionPane.showMessageDialog(null, "Item has been removed from cart.");

                } else {
                    JOptionPane.showMessageDialog(null, "Item is not in cart.");
                }
            }
        });

        //Add everything to the initial JFrame called 'frame'
        frame.setLayout(new FlowLayout());
        frame.add(itemLabel);
        frame.add(itemField);
        frame.add(priceLabel);
        frame.add(priceField);
        frame.add(quantityLabel);
        frame.add(quantityField);
        frame.add(addButton);
        frame.add(totalButton);
        frame.add(search);
        frame.add(remove);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
    }

    public static void main(String[] args) {
        new ShoppingCartGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }
}
