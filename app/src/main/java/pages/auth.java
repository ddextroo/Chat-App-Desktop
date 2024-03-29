/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pages;

import backend.EmailValidation;
import backend.aes;
import backend.firebaseInit;
import java.util.HashMap;
import backend.pushValueExisting;
import backend.signup;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.awt.Color;
import design.RoundedPanel;
import design.RoundedPanelBorderless;
import design.fontInit;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.UUID;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author W10
 */
public class auth extends javax.swing.JFrame {

    /**
     * Creates new form auth
     */
    private HashMap<String, Object> m;
    private pushValueExisting v;
    int posX = 0, posY = 0;
    boolean authh = false;
    EmailValidation validate = new EmailValidation();
    private FirebaseAuth firebaseAuth;
    private DatabaseReference dbRef;
    aes aes = new aes();
    File file = new File("uid.txt");
    UUID uuid = UUID.randomUUID();

    public auth() {
        initComponents();
        new firebaseInit().initFirebase();
        setLocationRelativeTo(null);
        new fontInit().initialize();
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.dbRef = FirebaseDatabase.getInstance().getReference("users");

        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent evt) {
                //sets frame position when mouse dragged			
                setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);

            }
        });
        initFont();
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 12, 12));
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
        jPanel2 = new javax.swing.JPanel();
        myButton1 = new design.MyButton();
        myButton2 = new design.MyButton();
        jPanel3 = new javax.swing.JPanel();
        emailaddlabel = new javax.swing.JLabel();
        jPanel6 = new RoundedPanel(12, new Color(245,245,245));
        email = new javax.swing.JTextField();
        jPanel10 = new RoundedPanelBorderless(12, new Color(250, 250, 250,0));
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new RoundedPanelBorderless(12, new Color(250, 250, 250,0));
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new java.awt.BorderLayout());

        myButton1.setForeground(new java.awt.Color(245, 245, 245));
        myButton1.setText("Login");
        myButton1.setPreferredSize(new java.awt.Dimension(150, 35));
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(myButton1);

        myButton2.setForeground(new java.awt.Color(245, 245, 245));
        myButton2.setText("Signup");
        myButton2.setPreferredSize(new java.awt.Dimension(150, 35));
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(myButton2);

        emailaddlabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emailaddlabel.setForeground(new java.awt.Color(51, 51, 51));
        emailaddlabel.setText("Email Address");

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        email.setBackground(new java.awt.Color(245, 245, 245));
        email.setBorder(null);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailaddlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(emailaddlabel)
                .addGap(4, 4, 4)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel10.setOpaque(false);
        jPanel10.setBackground(new java.awt.Color(250, 250, 250));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabel7.setBackground(new java.awt.Color(4, 28, 52));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(4, 28, 52));
        jLabel7.setText("-");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel10.add(jLabel7, new java.awt.GridBagConstraints());

        jPanel4.setOpaque(false);
        jPanel4.setBackground(new java.awt.Color(250, 250, 250));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(4, 28, 52));
        jLabel5.setText("X");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel5, new java.awt.GridBagConstraints());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Chat app");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        // TODO add your handling code here:
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        if (email.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Field is empty");
        } else {
            {
                String email_address = email.getText();
                String password = new String(uuid.toString());

                dbRef = FirebaseDatabase.getInstance().getReference("users");
                dbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        try {
                            String loginn = "", key = "", passwd;
                            UserRecord userRecord = firebaseAuth.getUserByEmail(email_address);
                            String uid1 = userRecord.getUid();
                            for (DataSnapshot child : dataSnapshot.getChildren()) {
                                String uiddb = child.child("uid").getValue(String.class);
                                String passdb = child.child("pass").getValue(String.class);
                                System.out.println("UID_DB = " + uiddb + ": UID = " + uid1);
                                System.out.println("PASS_DB = " + passdb + ": PASS = " + password);
                                if (uiddb.equals(uid1)) {

                                    authh = true;
                                    key = uiddb;
                                    loginn = "true";
                                    System.out.println(key + " " + loginn);

                                    if (validate.validate(email_address)) {
                                        try {
                                            key = aes.encryptString(key, aes.getPassword());
                                            try {
                                                FileWriter writer = new FileWriter(file);
                                                writer.write(key);
                                                writer.close();
                                                dispose_page();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }

                                        } catch (Exception ex) {
                                            Logger.getLogger(auth.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Error: Must valid format", "Error", ERROR_MESSAGE);
                                    }
                                    break;
                                } else {
                                    //weqewq

                                }
                            }
                        } catch (FirebaseAuthException ex) {
                            Logger.getLogger(auth.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, "Error: Not registered", "Error", ERROR_MESSAGE);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("Error: " + databaseError.getMessage());
                    }
                });
            }
        }
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
        if (email.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Field is empty");

        } else {
            String email_address = email.getText();
            String password = new String(uuid.toString());
            if (validate.validate(email_address)) {
                try {
                    boolean authenticated = false;
                    authenticated = new signup(email_address, password).signUp();

                    if (authenticated) {
                        email.setText("");
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(auth.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FirebaseAuthException ex) {
                    Logger.getLogger(auth.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: Invalid format", "Error", ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_myButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(auth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(auth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(auth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(auth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new auth().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JLabel emailaddlabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private design.MyButton myButton1;
    private design.MyButton myButton2;
    // End of variables declaration//GEN-END:variables

    private void initFont() {
        emailaddlabel.setFont(new Font("Montserrat Regular", Font.BOLD, 14));
        email.setFont(new Font("Montserrat Regular", Font.PLAIN, 12));
        myButton1.setFont(new Font("Montserrat Regular", Font.BOLD, 14));
        myButton2.setFont(new Font("Montserrat Regular", Font.BOLD, 14));
        jLabel1.setFont(new Font("Montserrat Regular", Font.BOLD, 24));

    }

    private void dispose_page() {
        chat chat = new chat();
        chat.setVisible(true);
        this.dispose();
    }
}
