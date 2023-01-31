
package odev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;




       /**Bu Sayfa'da Veri Tabanı Kullanılmıştır
      * 
      * geri Button Ekledim Eger Tıklanırsa Y_AnaSayfa Gidiliyor.
      * 
      * bildirim Tablosunu Oluşturdum
      * 
      * Tarih ve Bildirim verlilerini Oluşturdum.
      * 
      * TarihTextBox ve BildirimTextbox Oluşturdum
      * 
      * Mysql Kodu İnsert İnto Şeklinde Verileri Ekliyorum.
      * 
      * Gönder Tıklarsa VeriTabanı ve TextBox'dakileri Eşit'leyip Ekliyor.
      * 
     *
     */
public class Y_Bildirim extends javax.swing.JFrame {

 private static final String url = "jdbc:mysql://localhost:3306/odev";
 private static final String user = "root";
 private static final String pass = "";
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    public Y_Bildirim() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        A2 = new java.awt.TextField();
        A1 = new java.awt.TextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Tarih");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 110, 30));

        jLabel2.setText("Bildirim");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 110, 30));

        A2.setName("A2"); // NOI18N
        jPanel1.add(A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 190, 120));

        A1.setName("A1"); // NOI18N
        jPanel1.add(A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 190, 39));

        jButton1.setText("Gönder");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 190, 40));

        jButton2.setText("Geri Dön");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 480));

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   try
        {

            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(url,user,pass);
            pst = sqlConn.prepareStatement("insert into bildirim(Tarih,Bildirim)value(?,?)");

            pst.setString(1, A1.getText());
            pst.setString(2, A2.getText());
           

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Bildirim Eklendi");
            
            A1.setText("");
            
            A2.setText("");
      
            
        }

        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KayıtOl.class.getName()).log(java.util.logging.Level.
                SEVERE,null, ex);

        } catch (SQLException ex) {
            
            java.util.logging.Logger.getLogger(KayıtOl.class.getName()).log(java.util.logging.Level.
                SEVERE,null, ex);

        }    

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Y_AnaSayfa().setVisible(true);
        this.dispose();     
    }

    
    public static void main(String args[]) {
        
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Y_Bildirim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Y_Bildirim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Y_Bildirim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Y_Bildirim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Y_Bildirim().setVisible(true);
            }
        });
    }

    private java.awt.TextField A1;
    private java.awt.TextField A2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
