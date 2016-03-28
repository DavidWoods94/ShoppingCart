package ShoppingCartClient;

import ShoppingCartGUI.*;
import java.util.ArrayList;

/**
 * 
 * @author Group 31
 */
public class Bundle extends Item {
    
    /**
     * Creates a new bundle
     * @param q the quantity of the bundle.
     */
    public Bundle(int q){
        items = new ArrayList<>();
        productID = super.getNewID();
        quantity = q;
        quantityPurchased = q;
        seller = null;
    }
    
    /**
     * Adds an item to the bundle's list of items
     * @param i an item to be added
     * (postcondition items.size() is greaterthan 0)
     */
    public void add(Item i){
        items.add(i);
        calcSellPrice();
    }
    
    /**
     * Sets items of the bundle to l
     * @param l ArrayList of items 
     */
    public void setList(ArrayList l)
    {
        items = l;
    }
    
    /**
     * Gives the name of the bundle as a combination of the names of the items in the bundle
     * @return name of the bundle
     */
    public String getName() {
        String name = "BUNDLE: ";
        for(Item i: items)
        {
            name += i.getName() + ", ";
        }
        return name;
    }

    
    /**
     * The quantity of the bundle
     * @return the quantity
     */
    public int getQuantity() {
        return super.quantity;
    }

    /**
     * Gives the description of the bundle as the description of all of the items in the bundle
     * @return the description
     */
    @Override
    public String getDescription() {
        String description = "";
        for(Item i: items)
        {
            description += i.getDescription() + "\n\n";
        }
        return description;
    }

    /**
     * Gives the sell price of the bundle. It is a combination of the sell prices of all of the items in the bundle
     * @return the sell price of the bundle
     */
    public double getSellPrice() {
        return this.sellPrice;
    }

    /**
     * Gives the invoice price of the bundle. 
     * It is a combination of all of the invoice prices of the items in the bundle
     * @return the invoice price
     */
    public double getInvoicePrice() {
        double invoicePrice = 0;
        for(Item i: items)
        {
            invoicePrice += i.getInvoicePrice();
        }
        return invoicePrice;
    }

    /**
     * Calculates the sell price of the bundle by adding all of the sell prices together
     */
    public void calcSellPrice()
    {
        sellPrice = 0;
        for(Item i: items)
        {
            sellPrice += i.getSellPrice();
        }
    }
    
    /**
     * Gets the information of the bundle as a string.
     * @return the details of the bundle.
     */
    @Override
    public String getDetails() {
        String details = "ProductID: " + getID() + "\n" + "Name: " + getName() + "\n" + "Description: " + getDescription() + "\n"
                + "Invoice Price: " + getInvoicePrice() +"\n" + "Sell Price: " + getSellPrice() + "\n";
        return details;
    }

    /**
     * Sets the seller of the bundle
     * @param s seller of this bundle
     */
    @Override
    public void setSeller(Seller s) {
        seller = s;
    }

    /**
     * Gives the seller of the bundle
     * @return the seller
     */
    @Override
    public Seller getSeller() {
        return seller;
    }

    /**
     * Makes a copy of this bundle
     * @return a copy of the bundle
     */
    @Override
    public Item copy() {
        Bundle copy = new Bundle(this.quantity);
        copy.setList(items);
        copy.setID(this.productID);
        return copy;
    }

    /**
     * Set's the quantity purchased
     * @param q amount of this bundle that was purchased
     */
    @Override
    public void setQuantityPurchased(int q)
    {
        quantityPurchased += q - quantity;
        quantity = q;
    }


    /**
     * Set's the quantity of the bundle
     * @param q quantity of the bundle.
     */
    @Override
    public void setQuantity(int q) {
        quantity = q;
    }

    /**
     * Set's the ID of the bundle
     * @param i the new ID
     */
    @Override
    public void setID(int i)
    {
        super.productID = i;
    }
    
    /**
     * Sets the selling price of the bundle
     * @param p the new sellPrice
     */
    public void setPrice(double p) {
        super.sellPrice = p;
    }
    
    /**
     * Gives the quantity purchased
     * @return quantityPurchased
     */
    public int getQuantityPurchased() 
    {
        return quantityPurchased;    
    }
    private ArrayList<Item> items;

    /**
     * Gets the information of the bundle as a string.
     * @return the details of the bundle.
     */
    @Override
    public String getDetailsForCust() {
        String details = "ProductID: " + getID() + "\n" + "Name: " + getName() + "\n" + "Description: " + getDescription() + "\n"
                + "Sell Price: " + getSellPrice() + "\n";
        return details;
    }

}