package ShoppingCartClient;

import ShoppingCartGUI.*;
import java.util.ArrayList;

/**
 *
 * @author Group 31
 */
public class Seller extends User
{
    /**
     * Creates a seller
     * @param aName The username
     * @param pass The password
     */
    public Seller(String aName, String pass) 
    {
        super(aName, pass);
        sellerID = getNewID();
        sellerInventory = new Inventory(new ArrayList<Item>());
        revenue  = 0;
        invoice = 0;
    }

    /**
     * Gives a new ID
     * @return newID
     */
    @Override
    public int getNewID() 
    {
        return newID++;
    }
    
    /**
     * Gives the current invoice
     * @return invoice
     */
    public double getInvoice()
    {
        return invoice;
    }
    
    /**
     * Gives the current revenue
     * @return revenue
     */
    public double getRevenue()
    {
        return revenue;
    }
    
    /**
     * Calculates the current profit and returns it
     * @return profit
     */
    public double getProfit()
    {
        calcProfit();
        return profit;
    }
    
    /**
     * Calculates the profit
     */
    public void calcProfit()
    {
        profit = getRevenue() - getInvoice();  
    }
    
    /**
     * Adds a product to the inventory
     * @param p Product
     */
    public void addProduct(Product p)
    {
        sellerInventory.add(p);
        p.setSeller(this);
    }
    
    /**
     * Calculates the invoice
     */
    public void calcInvoice()
    {
        invoice = 0;
        for(Item p: sellerInventory)
        {
            invoice += p.getInvoicePrice()*p.getQuantityPurchased();
        }
    }
    
    /**
     * Calculates the revenue
     * @param price price of the item
     * @param numPurchased the number of items purchased
     */
    public void calcRevenue(Double price, int numPurchased)
    {
        revenue += price*numPurchased;
    }
    
    /**
     * Gives the seller's inventory
     * @return the inventory
     */
    public Inventory getSInventory()
    {
        return sellerInventory;
    }
    
    /**
     * Removes a product from the inventory
     * @param p product to be removed
     */
    public void RemoveProduct(Item p)
    {
        sellerInventory.remove(p);
    }
    
    private int sellerID;
    private static int newID = 1000;
    private double invoice = 0;
    private double profit = 0;
    private double revenue = 0;
    private Inventory sellerInventory;
}
