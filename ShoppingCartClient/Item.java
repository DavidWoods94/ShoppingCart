package ShoppingCartClient;

/**
 *
 * @author Group 31
 */
public abstract class Item {
    /**
     * Gets a new ID for the item
     * @return new ID
     */
    public int getNewID()
    {
        return newID++;
    }
    
    /**
     * Gives the item's ID
     * @return ID
     */
    public int getID()
    {
        return productID;
    }
    /**
     * Gives the item's name
     * @return name
     */
    public abstract String getName();
    /**
     * Gives the item's quantity
     * @return quantity
     */
    public abstract int getQuantity();
    /**
     * Gives the number of items purchased
     * @return quantityPurchased
     */
    public abstract int getQuantityPurchased();
    /**
     * Sets the quantityPurchased
     * @param q the new quantity purchased
     */
    public abstract void setQuantityPurchased(int q);
    /**
     * Gives the description of the item
     * @return the description
     */
    public abstract String getDescription();
    /**
     * Gives the sellPrice
     * @return sellPrice
     */
    public abstract double getSellPrice();
    /**
     * Gives the invoice price
     * @return invoicePrice
     */
    public abstract double getInvoicePrice();
    /**
     * Set the quantity of the item
     * @param q the quantity
     */
    public abstract void setQuantity(int q);
    /**
     * Gives all of the item's details as a string
     * @return details as a string
     */
    public abstract String getDetails();
    /**
     * Gives all of the item's details as a string but without invoice price
     * @return details as a string
     */
    public abstract String getDetailsForCust();
    /**
     * Set the item's Seller
     * @param s Seller
     */
    public abstract void setSeller(Seller s);
    /**
     * Gives the item's seller
     * @return Seller
     */
    public abstract Seller getSeller();
    /**
     * Set's the item's ID
     * @param i the ID
     */
    public abstract void setID(int i);
    /**
     * Makes a copy of the item
     * @return the copy
     */
    public abstract Item copy();
    /**
     * Set's the item's price
     * @param p price
     */
    public abstract void setPrice(double p);
    static int newID = 1000;
    public int productID;
    public int quantity;
    public int quantityPurchased;
    public Seller seller;
    public String name;
    public String description;
    public double sellPrice;
    public double invoicePrice;
}
