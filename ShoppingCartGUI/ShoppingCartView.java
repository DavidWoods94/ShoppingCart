package ShoppingCartGUI;

import ShoppingCartClient.ShoppingCart;
import ShoppingCartClient.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Group 31
 */
public class ShoppingCartView extends javax.swing.JFrame {

    /**
     * Creates new form ShoppingCartView
     */
    public ShoppingCartView() {
        initComponents();
    }
    /**
     * Shows all of the products for sale. Adds JLabels and Jbuttons for things
     * such as adding products to cart and changing the quantity
     * @param c current seller
     */
    public void showProducts(Customer c)
    {
        
        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
        for(Item p: ShoppingCart.currentCustomer.getCart())
        {
            //Adds all of the buttons for the products
            JPanel panel = new JPanel();
            panel.setLayout((new FlowLayout(FlowLayout.LEFT)));
            JLabel pID = new JLabel("ID: " + Integer.toString(p.getID()));
            JLabel pName = new JLabel("Name: " + p.getName());
            JLabel price = new JLabel("Price: $" + p.getSellPrice()*p.getQuantity());
            JLabel pQ = new JLabel("Quantity: ");
            JTextField jField = new JTextField(Integer.toString(p.getQuantity()), 3);
            JButton details = new JButton("Details");
            JButton update = new JButton("Update");
            JButton remove = new JButton("Remove");
            
            //Action listener for updating the quantity of the items
            update.addActionListener(new ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    try
                    {
                        Integer q;
                        q = Integer.parseInt(jField.getText());
                        if(q>0)
                        {

                            //Making sure the customer gets an appropriate amount
                            //of products
                            for(Item p2: p.getSeller().getSInventory())
                            {
                                if(p.getID()==p2.getID())
                                {
                                    if(q > p2.getQuantity())
                                    {
                                        JOptionPane.showMessageDialog(null,"Only"
                                                + " " + p2.getQuantity() +
                                                " available.","Inventory Shortage" 
                                                , JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else
                                    {
                                        p.setQuantity(q);
                                        JOptionPane.showMessageDialog(null,"Quantity updated."
                                                ,"Update" , JOptionPane.INFORMATION_MESSAGE);
                                        refreshPage();
                                    }
                                }
                            }

                        }
                    }
                    catch(IllegalArgumentException e)
                    {
                        JOptionPane.showMessageDialog(null, "Invalid input");
                    }
                }
            });
            //Opens the details window when clicked
            details.addActionListener(new ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    JOptionPane.showMessageDialog(null,p.getDetailsForCust(), 
                            "Product Details", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            
            //Removes the product from the customer's cart when remove button 
            //is clicked
            remove.addActionListener(new ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    
                    JOptionPane.showMessageDialog(null, 
                            "Product removed from cart","Removed", 
                            JOptionPane.INFORMATION_MESSAGE);
                    ShoppingCart.currentCustomer.getCart().remove(p);
                    refreshPage();
                }
            });
            //Adds all the components
            panel.add(pID);
            panel.add(pName);
            panel.add(price);
            panel.add(pQ);
            panel.add(jField);
            panel.add(update);
            panel.add(details);
            panel.add(remove);
            
            //adds all of the buttons the jpanel with the scroll pane
            jPanel2.add(panel);
            jPanel2.add(Box.createVerticalStrut(2));
        }
        
    }
    
    /**
     * Refreshes the page so new information can be displayed when it is updated
     */
    public void refreshPage()
    {
        this.dispose();
        jPanel2.removeAll();
        ShoppingCart.openCartView(this.getX(), this.getY());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(608, 470));

        jPanel1.setMinimumSize(new java.awt.Dimension(298, 72));
        jPanel1.setPreferredSize(new java.awt.Dimension(298, 72));

        jLabel1.setText("Your Cart");

        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(13, 13, 13))
        );

        jButton2.setText("Continue Shopping");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Purchase");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jButton2)
                .addGap(78, 78, 78)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Opens the other page if customer clicks continue shopping
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jPanel2.removeAll();
        ShoppingCart.openCHome(this.getX(),this.getY());
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Logs the user out when the customer clicks log out
     * @param evt event handler for clicking the log out button
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       jPanel2.removeAll();
        ShoppingCart.setCurrentCustomer(null);
        ShoppingCart.openLogin(this.getX(),this.getY());
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * Opens the Checkoutpage if the cart isn't empty
     * @param evt event handler for clicking the purchase button
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //tell user their cart is empty
        if(ShoppingCart.currentCustomer.getCart().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Cart is empty"
                                            ,"Error" , JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            ShoppingCart.openCheckoutView(this.getX(), this.getY());
            jPanel2.removeAll();
            dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}