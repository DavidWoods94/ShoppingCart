package ShoppingCartClient;

import ShoppingCartGUI.*;

/**
 *
 * @author Group 31
 */
public class DiscountItem extends Item
{

    /**
     * Creates a discount item
     * @param i the item being discounted
     * @param d the discount percent
     */
    public DiscountItem(Item i, double d)
    {
        item = i;
        discount = d;
        setPrice(item.getSellPrice()*((100-discount)/100));
        super.productID = item.productID;
        this.description = item.getDescription();
        this.invoicePrice = item.getInvoicePrice();
        this.name = item.getName();
        this.quantity = item.getQuantity();
        this.quantityPurchased = item.getQuantityPurchased();
        this.seller = item.getSeller();
    }
    /**
     * Gives the name of the item
     * @return item's name
     */
    @Override
    public String getName() {
        return this.name; 
    }

    /**
     * Gives the quantity of the item
     * @return quantity
     */
    @Override
    public int getQuantity() {

        return this.quantity;
    }

    /**
     * gives the quantity purchased
     * @return quantity purchased
     */
    @Override
    public int getQuantityPurchased() {
        return this.quantityPurchased;
    }

    /**
     * Sets the quantity purchased and changes quantity
     * @param q quantity purchased
     */
    @Override
    public void setQuantityPurchased(int q) {
        quantityPurchased += q - quantity;
        quantity = q;
    }

    /**
     * The items description
     * @return The items description plus the discount
     */
    @Override
    public String getDescription() {
        
        return item.getDescription() + "\n" + discount + " % Discount";
    }

    /**
     * Gives the sell price of the item
     * @return the discounted price
     */
    @Override
    public double getSellPrice() {
        return this.sellPrice;
    }

    /**
     * Gives the invoice price of the item
     * @return invoice price
     */
    @Override
    public double getInvoicePrice() {
        return this.invoicePrice;
    }

    /** 
     * Sets the quantity of the item
     * @param q quantity
     */
    @Override
    public void setQuantity(int q) {
        this.quantity = q;
    }

    /**
     * Gives all of the details of the item as a string
     * @return Item details
     */
    @Override
    public String getDetails() {
         String details = "ProductID: " + getID() + "\n" + "Name: " + getName() + "\n" + "Description: " + getDescription() + "\n"
                + "Invoice Price: " + getInvoicePrice() +"\n" + "Sell Price: " + getSellPrice() + "\n";
        return details;
    }

    /**
     * Sets the seller of the item
     * @param s Seller
     */
    @Override
    public void setSeller(Seller s) {
        this.seller = s;
    }

    /**
     * Gives the seller of the item
     * @return Seller
     */
    @Override
    public Seller getSeller() {
        return this.seller;
    }

    /**
     * Sets the ID of the item
     * @param i item's new id
     */
    @Override
    public void setID(int i) {
        this.productID = i;
    }

    /**
     * Makes a copy of the item
     * @return a copy of the item
     */
    @Override
    public Item copy() {
        DiscountItem copy = new DiscountItem(this.item, this.discount);
        copy.setID(this.productID);
        return copy;
    }
    

    /**
     * Sets the sellPrice of the item
     * @param p price
     */
    @Override
    public void setPrice(double p) {
        super.sellPrice = p;
    }
    private Item item;
    private double discount;

    /**
     * Gives all of the details of the item as a string
     * @return Item details
     */
    @Override
    public String getDetailsForCust() {
        String details = "ProductID: " + getID() + "\n" + "Name: " + getName() + "\n" + "Description: " + getDescription() + "\n"
                + "Sell Price: " + getSellPrice() + "\n";
        return details;
    }
}
