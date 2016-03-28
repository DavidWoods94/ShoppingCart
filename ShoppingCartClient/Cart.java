package ShoppingCartClient;

import ShoppingCartGUI.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author Group31
 */
public class Cart implements Iterable<Item>{

    /**
     * Creates a new Cart object
     * @param p an ArrayList of items
     */
    public Cart(ArrayList<Item> p){
        customerProducts = p;
    }
  
    /**
     * Gives an iterator for the collection
     * @return iterator for the collection
     */
    @Override
    public Iterator<Item> iterator() 
    {
        index = 0;
        return new Iterator<Item>() {

            @Override
            public boolean hasNext() {
                return !(customerProducts.size() == index);
            }

            @Override
            public Item next() {
                if(hasNext()){
                    return customerProducts.get(index ++);
                }
                else{
                    throw new NoSuchElementException("No such element !!!");
                }
            }                                       
        };
    }
    
    /**
     * Adds an item to the cart
     * @param p an item
     * (postcondition customerProducts is greaterthan 0)
     */
    public void add(Item p) {
        customerProducts.add(p);
    }
    
    /**
     * Removes an item from the cart
     * @param p the item to be removed
     * (precondition customerProducts is greaterthan 0)
     */
    public void remove(Item p) {
        customerProducts.remove(p);
    }
    
    /**
     * Checks if the cart is empty
     * @return true if it is empty
     */
    public boolean isEmpty()
    {
        return customerProducts.isEmpty();
    }
    
    /**
     * Size of the shopping cart
     * @return number of items in the cart
     */
    public int size()
    {
        return customerProducts.size();
    }
    /**
     * Removes all of the items in the cart
     * customerProducts.size() == 0;
     */
    public void removeAll()
    {
        customerProducts.clear();
    }
    
    /**
     * The total price of all of the items in the cart
     * @return price of all items
     */
    public Double getAmountDue() 
    {
       Double amountDue = 0.0;
       for(Item p: customerProducts)
       {
          amountDue += p.getSellPrice() *p.getQuantity();
       }
       return amountDue;
    }
    
    /**
     * The number of products in the cart
     * @return amount of items
     */
    public int getAmountOfProducts() {
       int numProducts = 0;
       for(Item p: customerProducts)
       {
          numProducts++;
       }
       return numProducts;
    }
    
    private List<Item> customerProducts;
    private int index;
    
}
