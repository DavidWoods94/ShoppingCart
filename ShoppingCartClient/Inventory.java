package ShoppingCartClient;

import ShoppingCartGUI.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author Group 31
 */
public class Inventory implements Iterable<Item> {

    /**
     * Creates an inventory
     * @param p an ArrayList of items
     */
    public Inventory(ArrayList<Item> p){
        allProducts = p;
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
                return !(allProducts.size() == index);
            }

            @Override
            public Item next() {
                if(hasNext()){
                    return allProducts.get(index ++);
                }
                else{
                    throw new NoSuchElementException("No such element !!!");
                }
            }                                       
        };
    }
    
    /**
     * Adds an item to the inventory
     * @param p the item to be added
     * (postcondition allProducts.size() is greater than 0)
     */
    public void add(Item p) {
        allProducts.add(p);
    }
    
    /**
     * Removes an item from the inventory
     * @param p the item being removed
     * (preconditon allProducts.size() is greater than 0)
     */
    public void remove(Item p) {
        allProducts.remove(p);
    }
    /**
     * Size of the collection
     * @return size
     */
    public int size()
    {
        return allProducts.size();
    }
    
    private List<Item> allProducts;
    private int index;
}
