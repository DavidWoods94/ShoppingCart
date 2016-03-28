
package ShoppingCartGUI;

import ShoppingCartClient.ShoppingCart;
import ShoppingCartClient.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author FREGUENS
 */
public class CustomerHome extends javax.swing.JFrame {

    /**
     * Creates new form CustomerHome
     */
    public CustomerHome() {
        initComponents();
    }
    ArrayList<Item> saleList;
    /** 
     * Sets up the page by getting all of the items from all of the sellers
     */
    public void setUp()
    {
        saleList = new ArrayList<>();
        for(Seller s: ShoppingCart.sellerList)
        {
            for(Item p: s.getSInventory())
            {
                saleList.add(p.copy());
            }
        }
        jLabel2.setText("Items in cart: " + ShoppingCart.currentCustomer.getCart().size());
    }
    
    /**
     * Shows all items from all sellers
     * @param c the customer currently browsing
     */
    public void showProducts(Customer c)
    {
        
        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
        
        //Makes a jpanel and buttons for each of the items
        for(Item p: saleList)
        {
            JPanel panel = new JPanel();
            panel.setLayout((new FlowLayout(FlowLayout.LEFT)));
            JLabel pID = new JLabel("ID: " + Integer.toString(p.getID()));
            JLabel pName = new JLabel("Name: " + p.getName());
            JLabel pQ = new JLabel("Quantity: ");
            JLabel price = new JLabel("Unit Price: $" + p.getSellPrice());
            JTextField jField = new JTextField("1", 3);
            JButton details = new JButton("Details");
            JButton addToCart = new JButton("Add to Cart");
            
            //If this button is clicked the item is added to the cart
            addToCart.addActionListener(new ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    try
                    {
                        Item n = p.copy();
                        int q = Integer.parseInt(jField.getText());
                        n.setQuantity(q);
                        //Adds item to cart if appropriate quantity
                        if(q <= p.getQuantity()&&q > 0)
                        {
                            ShoppingCart.currentCustomer.addToCart(n);
                            JOptionPane.showMessageDialog(null,"Item(s) added to cart: " + p.getName(), "Item(s) added.", JOptionPane.INFORMATION_MESSAGE);
                            p.setQuantity(p.getQuantity() - q);
                        }
                        //Doesn't add the item if the user tries to add 0
                        else if(q <= 0)
                        {
                            JOptionPane.showMessageDialog(null,"Choose a quantity greater than 0.","Added nothing to the cart" , JOptionPane.INFORMATION_MESSAGE);
                        }
                        //Doesn't add teh item if the customer trues to purchase more than what's available
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Only " + p.getQuantity() + " available.","Inventory Shortage" , JOptionPane.INFORMATION_MESSAGE);
                        }
                        refreshPage();
                    }
                    catch(IllegalArgumentException e)
                    {
                        JOptionPane.showMessageDialog(null, "Invalid input");
                    }
                }
            });
            //Displays the details of the item if this button is clicked
            details.addActionListener(new ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    JOptionPane.showMessageDialog(null,p.getDetailsForCust(), "Product Details", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            //Adding all of the components
            panel.add(pID);
            panel.add(pName);
            panel.add(price);
            panel.add(pQ);
            panel.add(jField);
            panel.add(addToCart);
            panel.add(details);
            
            
            jPanel2.add(panel);
            jPanel2.add(Box.createVerticalStrut(2));
        }
        
    }
    
    /**
     * Refreshes the page so new information can be displayed
     */
    public void refreshPage()
    {
        this.dispose();
        jPanel2.removeAll();
        ShoppingCart.openCHome(this.getX(), this.getY());
        repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(608, 470));

        jLabel1.setText("HOME PAGE");

        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Items in cart: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel2))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Logs the customer out
     * @param evt event handler for clicking the log out button
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       jPanel2.removeAll();
        ShoppingCart.setCurrentCustomer(null);
        ShoppingCart.openLogin(this.getX(),this.getY());
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Takes the customer to their cart
     * @param evt event handler for clicking this button
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ShoppingCart.openCartView(this.getX(), this.getY());
        jPanel2.removeAll();
        dispose();
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
