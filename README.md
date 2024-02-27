In this section, you create a working example of inheritance for a party planner. A general Party class will serve as a basis for a more specific DinnerParty class that includes a dinner. To see the effects of inheritance, you create this example in four stages:

First, you create a Party class that holds just one data field and three methods.

After you create the general Party class, you write an application to demonstrate its use.

Then, you create a more specific DinnerParty subclass that inherits the fields and methods of the Party class.

Finally, you modify the demonstration application to add an example using the DinnerParty class.

Step 1: Open a new file, and enter the following first few lines for a simple Party class. The class hosts one integer data field—the number of guests expected at the party:

Step 2  Add the two methods that get and set the number of guests:

Step 3. Add a void method displayInvitation() that prints "Please come to my party!"

Step 4 save the file as Party.java

Writing an Application That Uses the Party Class
Now that you have created a class, you can use it in an application. A very simple application creates a Party object, prompts the user for the number of guests at the party, sets the data field, and displays the results.

Open a new file, and start to write a UseParty application that has one method—a main() method. Declare a variable for the number of guests, a Party object, and a Scanner object to use for input:
Continue the main() method by prompting the user for a number of guests and accepting the value from the keyboard. Set the number of guests in the Party object, and then display the value.
Add a statement to display the party invitation
Save the file as UseParty.java, then compile and run the application
Output should look like (or similar) to this:

Enter number of guests for the party >> 20
The party has 20 guests
Please come to my party!

Creating a Subclass from the Party Class
Next, you create a class named DinnerParty. A DinnerParty “is a” type of Party at which dinner is served, so DinnerParty is a child class of Party.

Open a new file, and type the first few lines for the DinnerParty class
A DinnerParty contains a number of guests, but you do not have to define the variable here. The variable is already defined in Party, which is the superclass of this class. You only need to add any variables that are particular to a DinnerParty. Enter the following code to add an integer for the dinner menu choice Example : private int dinnerChoice;
The Party class already contains methods to get and set the number of guests, so DinnerParty only needs methods to get and set the dinnerChoice variable
Save the file as DinnerParty.java, and then compile it
Creating a Subclass from the Party Class

Now, you can modify the UseParty application so that it creates a DinnerParty as well as a plain Party

Open the UseParty.java file, and change the class name to UseDinnerParty . Immediately save the file as UseDinnerParty.java.
Include a new variable that holds the dinner choice for a DinnerParty: (example int choices)
Instantiate the DinnerParty object (Example DinnerParty aDinnerParty = new DinnerParty())
At the end of the main() method, after the Party object data and invitation are displayed, add a prompt for the number of guests for the DinnerParty. Accept the value the user enters and assign it to the object. Even though the DinnerParty class does not contain a setGuests() method, its parent class does, so aDinnerParty can use the method.
Next, prompt the user for a dinner choice. To keep this example simple, the program provides only two choices and does not provide range checking. Accept a response from the user, assign it to the object, and then display all the data for the DinnerParty. Even though the DinnerParty class does not contain a getGuests() method, its parent class does, so aDinnerParty can use the method. The DinnerParty class uses its own setDinnerChoice() and getDinnerChoice() methods.
Add a statement to call the displayInvitation() method with the DinnerParty object. Even though the DinnerParty class does not contain a displayInvitation() method, its parent class does, so aDinnerParty can use the method.
Save the file, compile it, and run it using values of your choice.  The DinnerParty object successfully uses the data field and methods of its superclass, as well as its own data field and methods.
Basic final output should (Your creativity is needed)
Enter number of guests for the party >> 20
The party has 20 guests
Please come to my party!
Enter number of guests for the dinner party >> 8
Enter the menu option -- 1 for chicken or 2 for Vegi >> 2
The dinner party has 8 guests
Menu option 2 will be served
Please come to my parth!
