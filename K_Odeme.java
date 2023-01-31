package odev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet; //sql den sonra veri tabanındaki verileri tutmak
import java.sql.SQLException;
import java.sql.Statement;  //sql metni çalıştırma
import java.util.logging.Level;  //hata seviyelerine göre
import java.util.logging.Logger; //günlük oluşturma hata kaydı vb
import javax.swing.JOptionPane;
/**
 *
 * @author Yasin Pekergin
 */
public class K_Odeme extends javax.swing.JFrame {

   Connection mycoib;  
   String url = "jdbc:mysql://localhost:3306/odev";
   String user = "root";
   String pass = "";
    public K_Odeme() {
        initComponents();
    }
    @SuppressWarnings("unchecked") //olası çalıştırma hatasına dair
    //Dizayn kısmı
   
// 64.ve74.kod satırlarında  Kartnotext ve KartŞifreText Oluşturdum. 
    
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Tamamla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 270, 30));

        jLabel2.setText("Kart N.O");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 50, 30));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 270, 30));

        jLabel3.setText("Kart Şifresi");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 70, 40));

        jTextField3.setName("B_pass"); 
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 270, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        jLabel1.setText("NOT: Kart Şiferesi : 1234");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 160, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
       
 try{
      Class.forName("com.mysql.jdbc.Driver");
     mycoib = DriverManager.getConnection(url,user,pass);
     Statement stmt = mycoib.createStatement();
   
    String sql = "Select * from ";
     ResultSet rs=stmt.executeQuery(sql);
     if(rs.next()){
        JOptionPane.showMessageDialog(this,"Başarılı"); //sql bağlantısı başarılı
         new Y_AnaSayfa().setVisible(true);
         this.dispose(); //yönlendirme
         
          }
    else{
         JOptionPane.showMessageDialog(this,"Başarısız Lütfen Tekrar Giriniz! ");
         mycoib.close();
        
     }
  }
       catch(SQLException e){
      e.printStackTrace();
      System.out.println("HATA");
  }     
       catch (ClassNotFoundException ex) {
        
        }
             if("1234".equals(jTextField3.getText())){ //1234 girildiğinde yönlendirileceği yer ve uygulamada allacağı geribildirim
            
             JOptionPane.showMessageDialog(this,"Şife Dogru ");
             
             JOptionPane.showMessageDialog(this,"işlem tamamlandı. Yarın 18:30 Uçak Kalkıyor ");
             
             JOptionPane.showMessageDialog(this," AnaSayfaya Gidliyor "); //Anasayfaya yönlendirme
             
             
             new K_AnaSayfa().setVisible(true);
     
             this.dispose();
             
             }
       else{
            
             JOptionPane.showMessageDialog(this,"Şifre Yanlış Lütfen Tekrar Giriniz! ");
        }
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
     
    }

    public static void main(String args[]) {
   
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
       catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(K_Odeme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
       catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(K_Odeme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
       catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(K_Odeme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
       catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(K_Odeme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new K_Odeme().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    
} //Çerçeve Panel ve button tasarmı ve yazı biçimi 
