package ShoppingCartClient;

import ShoppingCartGUI.*;
import java.util.ArrayList;

/**
 *
 * @author Group 31
 */
public class Customer extends User
{
    /**
     * Crates a customer
     * @param aName the username
     * @param pass the password
     */
    public Customer(String aName, String pass)
    {
        super(aName, pass);
        customerID = newID;
        cart = new Cart(new ArrayList());
    }
    
    /**
     * gets a new ID
     * @return the new ID
     */
    public int getNewID()
    {
        return newID++;
    }
    
    /**
     * Gets the customer's cart
     * @return the cart
     */
    public Cart getCart()
    {
        return cart;
    }
    
    /**
     * Adds an item to the customer's cart
     * @param p item to be added
     * (postcondition cart.size() is greaterthan 0)
     */
    public void addToCart(Item p)
    {
        cart.add(p);
    }
    private int customerID;
    private static int newID = 1000;
    private Cart cart;
}
