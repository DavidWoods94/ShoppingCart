package ShoppingCartClient;

/**
 *
 * @author Group 31
 */
public class Product extends Item
{
    /**
     * Creates a product
     * @param aName the name
     * @param q the quantity
     * @param d the description
     * @param sPrice the sellPrice
     * @param iPrice the invoicePrice
     */
    public Product(String aName, int q, String d, double sPrice, double iPrice)
    {
        productID = super.getNewID();
        name = aName;
        quantity = q;
        quantityPurchased = q;
        description = d;
        sellPrice = sPrice;
        invoicePrice = iPrice;
        seller = null;
    }

    /**
     * Gives the name of the product
     * @return the name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gives the quantity of the product
     * @return the quantity
     */
    public int getQuantity()
    {
        return quantity;
    }
    
    /**
     * Gives the quantity purchased of the product
     * @return quantityPurchased
     */
    public int getQuantityPurchased()
    {
        return quantityPurchased;
    }
    /**
     * Sets the quantity purchased and changes the quantity
     * @param q quantityPurchased
     */
    public void setQuantityPurchased(int q)
    {
        quantityPurchased += q - quantity;
        quantity = q;
    }
    
    /**
     * Gives the description of the product
     * @return description
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Gives the sellPrice of the Product
     * @return sellPrice
     */
    public double getSellPrice()
    {
        return sellPrice;
    }
    
    /**
     * Gives the invoice price of the product
     * @return invoicePrice
     */
    public double getInvoicePrice()
    {
        return invoicePrice;
    }
    
    /**
     * Sets the quantity
     * @param q quantity
     */
    public void setQuantity(int q)
    {
        quantity = q;
    }
    
    /**
     * Gives all of the details of the product as a string
     * @return the products details
     */
    public String getDetails()
    {
        String details = "ProductID: " + getID() + "\n" + "Name: " + getName() + "\n" + "Description: " + getDescription() + "\n"
                + "Invoice Price: " + getInvoicePrice() +"\n" + "Sell Price: " + getSellPrice() + "\n";
        
        return details;
    }
    
    /**
     * Sets the product's seller
     * @param s Seller
     */
    public void setSeller(Seller s)
    {
        seller = s;
    }
    
    /**
     * Gets the product's Seller
     * @return Seller
     */
    public Seller getSeller()
    {
        return seller;
    }
    /**
     * Sets the products ID
     * @param i ID
     */
    public void setID(int i)
    {
        super.productID = i;
    }
    
    /**
     * Sets the products Price
     * @param p price
     */
    public void setPrice(double p) {
        super.sellPrice = p;
    }
    
    /**
     * Makes a copy of the product
     * @return the copy
     */
    public Product copy()
    {
        Product newP = new Product(super.name, super.quantity, this.description, this.sellPrice, this.invoicePrice);
        newP.setID(this.getID());
        newP.setSeller(this.seller);
        return newP;
    }

    public String getDetailsForCust() {
        String details = "ProductID: " + getID() + "\n" + "Name: " + getName() + "\n" + "Description: " + getDescription() + "\n"
                 + "Sell Price: " + getSellPrice() + "\n";
        
        return details;
    }
}