package ShoppingCartClient;

import ShoppingCartClient.Customer;
import ShoppingCartClient.Product;
import ShoppingCartClient.Seller;
import ShoppingCartClient.User;
import ShoppingCartGUI.CheckoutView;
import ShoppingCartGUI.CustomerHome;
import ShoppingCartGUI.Login;
import ShoppingCartGUI.SellerView;
import ShoppingCartGUI.ShoppingCartView;
import ShoppingCartGUI.SignUpView;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Group 31
 */
public class ShoppingCart {
    public static void main(String args[])
    {
        //Create list of customers and seller
        custList = new ArrayList<>();
        sellerList = new ArrayList<>();
        //Create sellers and customers
        Seller joe = new Seller("Joe", "Joe");       
        Customer bob = new Customer("Bob","Bob");
        Seller paul = new Seller("Paul", "Paul");  
        //Make some default items
        Product p1 = new Product("Sock", 10, "It keeps your feet warm", 5.0, 1.0);
        Product p2 = new Product("Sword", 10, "It's dangerous to go alone", 5.0, 1.0);
        Product p3 = new Product("Shoe", 100, "It's a shoe", 115.0, 3.0);
        Product p4 = new Product("Bucket", 4, "Holds water", 1.0, .50);

        //Give joe and paul some items to sell
        joe.addProduct(p1);
        joe.addProduct(p2);
        paul.addProduct(p4);
        paul.addProduct(p3);

        //Add them to their lists
        custList.add(bob);
        sellerList.add(joe);
        sellerList.add(paul);
        
        //Create the different pages
        log = new Login();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        cHome = new CustomerHome();
        signUp = new SignUpView();
        sHome = new SellerView();
        cartView = new ShoppingCartView();
        checkout = new CheckoutView();
       
    }
    /**
     * Opens the checkout page
     * @param x x-position of page
     * @param y y-position of page
     */
    static public void openCheckoutView(int x, int y)
    {
        checkout.setLocation(x, y);
        checkout.AmountDue();
        checkout.setVisible(true);
    }
    /**
     * Opens the customer home page
     * @param x x-position of page
     * @param y y-position of page
     */
    static public void openCHome(int x, int y){
        cHome.setLocation(x, y);
        cHome.setUp();
        cHome.showProducts(currentCustomer);
        cHome.setVisible(true);
        
    }
    
    /**
     * Opens the cart page
     * @param x x-position of page
     * @param y y-position of page
     */
    static public void openCartView(int x, int y)
    {
        cartView.setLocation(x, y);
        cartView.setVisible(true);
        cartView.showProducts(currentCustomer);
    }
    
    /**
     * Opens the seller home page
     * @param x x-position of page
     * @param y y-position of page
     */
    static public void openSHome(int x, int y){
        sHome.setLocation(x, y);
        sHome.showProducts(currentSeller);
        sHome.profits();
        sHome.setVisible(true);
    }
    
    /**
     * Opens the sign up page
     * @param x x-position of page
     * @param y y-position of page
     */
    static public void openSignUp(int x, int y){
        signUp.setLocation(x, y);
        signUp.setVisible(true);
    }
    
    /**
     * Opens the log in page
     * @param x x-position of page
     * @param y y-position of page
     */
    static public void openLogin(int x, int y){
        log.setLocation(x, y);
        log.setVisible(true);
    }
    
    /**
     * Sets the current seller
     * @param s current seller
     */
    static public void setCurrentSeller(Seller s)
    {
        currentSeller = s;
    }
    
    /**
     * Sets the current customer
     * @param c current customer
     */
    static public void setCurrentCustomer(Customer c)
    {
        currentCustomer = c;
    }
    
    /**
     * clears the text if someone logs out
     */
    public void loggingOut()
    {
        log.clearText();
    }
    
    static public SellerView sHome;
    static public List<Customer> custList;
    static public List<Seller> sellerList;
    static public Login log;
    static public CustomerHome cHome;
    static public SignUpView signUp;
    static public User currentUser;
    static public Customer currentCustomer;
    static public Seller currentSeller;
    static public ShoppingCartView cartView;
    static public CheckoutView checkout;
}