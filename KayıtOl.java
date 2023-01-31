
package odev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



   /**
     * Bu Sayfada Veri Tabanı Kullanılmıştır .
     * 
     * k_kayit Tablosu oluşturuldu .
     * 
     * Adı Soyad Dogum Tarihi Telefon Numarası TC Ve Şifre TextBox Eklendi
     * 
     * Kayıtol Button Tıklandıgında insert into Yaparak gelen textbox veritabanına karşılık gelecek şekilde Ekleme Yapıyor
     * 
     * 
     */
public class KayıtOl extends javax.swing.JFrame {
 private static final String url = "jdbc:mysql://localhost:3306/odev";
 private static final String user = "root";
 private static final String pass = "";
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    public KayıtOl() {
        initComponents();
    }
    
    

   
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        A4 = new java.awt.TextField();
        jLabel1 = new javax.swing.JLabel();
        A6 = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        A2 = new java.awt.TextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        A3 = new java.awt.TextField();
        A1 = new java.awt.TextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        A5 = new java.awt.TextField();
        jButton1 = new javax.swing.JButton();
        button2 = new java.awt.Button();

        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(102, 51, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        A4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A4ActionPerformed(evt);
            }
        });
        jPanel1.add(A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 190, 39));

        jLabel1.setText("Adı");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 110, 30));
        jPanel1.add(A6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 190, 39));

        jLabel2.setText("Soyad");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 110, 30));
        jPanel1.add(A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 190, 39));

        jLabel3.setText("TC");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 110, 30));

        jLabel4.setText("Doğum Tarihi");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 110, 30));
        jPanel1.add(A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 190, 39));
        jPanel1.add(A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 190, 39));

        jLabel5.setText("Telefon Numarası");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 110, 30));

        jLabel6.setText("Şifre");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 110, 30));
        jPanel1.add(A5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 190, 39));

        jButton1.setText("Kayıt Ol");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 190, 40));

        button2.setLabel("Geri Dön");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 14, 89, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 570));

        pack();
    }

    private void A4ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
           try
        {

            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(url,user,pass);
            pst = sqlConn.prepareStatement("insert into k_kayit(Adi,Soyad,Tarih,Tel,"
                + "TC,pass)value(?,?,?,?,?,?)");

            pst.setString(1, A1.getText());
            pst.setString(2, A2.getText());
            pst.setString(3, A3.getText());
            pst.setString(4, A4.getText());
            pst.setString(5, A5.getText());
            pst.setString(6, A6.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Kullanıcı Eklendi");
            JOptionPane.showMessageDialog(this,"AnaSayfaya Yönlendiriliyor");
            
            new AnaSayfa().setVisible(true);
             this.dispose(); 
            
        }

        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KayıtOl.class.getName()).log(java.util.logging.Level.
                SEVERE,null, ex);

        } catch (SQLException ex) {
          
            java.util.logging.Logger.getLogger(KayıtOl.class.getName()).log(java.util.logging.Level.
                SEVERE,null, ex);

        }
        
    }

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {

        new AnaSayfa().setVisible(true);
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
            java.util.logging.Logger.getLogger(KayıtOl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KayıtOl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KayıtOl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KayıtOl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KayıtOl().setVisible(true);
            }
        });
    }

    
    private java.awt.TextField A1;
    private java.awt.TextField A2;
    private java.awt.TextField A3;
    private java.awt.TextField A4;
    private java.awt.TextField A5;
    private java.awt.TextField A6;
    private java.awt.Button button2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    
}
