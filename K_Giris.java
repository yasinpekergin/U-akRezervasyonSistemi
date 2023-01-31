
package odev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;




 
           /**
     
     * 
     * Bu Sayfada Veri Tabanı Kullanılmıştır .
     * 
     * k_kayit Tablosudan veriler Çekildi .
     * 
     * Şifre Ve TC Bilgileri Çeklilmektedir.
     * 
     * Şifre ve TC girilen textAdi ve textSifre Eşitt İse Kullanıcı Menü'ye erişmekdedir
     *
     */
public class K_Giris extends javax.swing.JFrame {



    public K_Giris() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Sifre = new java.awt.TextField();
        Adi = new java.awt.TextField();
        jLabel2 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("TC");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 120, 30));
        jPanel1.add(Sifre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 240, 30));
        jPanel1.add(Adi, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 240, 30));

        jLabel2.setText("ŞİFRE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        button1.setLabel("Giriş Yap");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 111, -1));

        button2.setLabel("Kayıt Ol");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 89, -1));

        button3.setLabel("Geri Dön");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        jPanel1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 89, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {
    
       new KayıtOl().setVisible(true);
      this.dispose(); 
       
     
        
    }

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
               
    Connection mycoib;  
   String url = "jdbc:mysql://localhost:3306/odev";
   String user = "root";
   String pass = "";
   
  try{
      Class.forName("com.mysql.jdbc.Driver");
     mycoib = DriverManager.getConnection(url,user,pass);
     Statement stmt = mycoib.createStatement();
   
    String sql = "Select * from k_kayit where TC='"+Adi.getText()+"' and pass='"+Sifre.getText()+"'";
     ResultSet rs=stmt.executeQuery(sql);
     if(rs.next()){
        JOptionPane.showMessageDialog(this,"Başarılı");
         new K_AnaSayfa().setVisible(true);
         this.dispose();
         
    }else{
         JOptionPane.showMessageDialog(this,"Başarısız Lütfen Tekrar Giriniz! ");
         mycoib.close();
        
     }
  }catch(SQLException e){
      e.printStackTrace();
      System.out.println("HATA");
  }     catch (ClassNotFoundException ex) {
          
        }
        
    }

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {

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
            java.util.logging.Logger.getLogger(K_Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(K_Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(K_Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(K_Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new K_Giris().setVisible(true);
            }
        });
    }

   
    private java.awt.TextField Adi;
    private java.awt.TextField Sifre;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    
}
