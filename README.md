Write classes to model a shopping list. Make an Item class that represents a grocery item's name and price, such as tissues for $3. Also implement an ItemOrder class that represents a shopper's desire to purchase a given item in a given quantity, such as five boxes of tissues. You might wish to implement bulk-discounted items, such as two boxes of tissue for $4 which would bring the cost of the given order of 2+2+1 boxes of tissues to $4+$4+$3 (total $11). 

Lastly, implement a ShoppingCart class that stores ItemOrder in an ArrayList and allows item orders to be added to, removed from or searched for in the cart. The cart should be able to report the total price of all item orders in currently carries. 

Hint : ArrayList<ItemOrder> list = new ArrayList<ItemOrder>
