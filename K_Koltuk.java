package odev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel; //dizayn ile ilgili

/**
 *
 * @author Yasin Pekergin
 */

public class K_Koltuk extends javax.swing.JFrame {

     Connection mycoib; 
     PreparedStatement pst;
     ResultSet rs;
    //  Mysql VeriTabanı bağlantısı // 
   String url = "jdbc:mysql://localhost:3306/odev";
   String user = "root";
   String pass = "";
   
   Connection sqlConn = null;
   
    int q, i, id, deleteItem;
   
     public K_Koltuk() {
        initComponents();
        
        BiletBUl();
        
        jTextField1.setText("1");
        
          try {
              pst = mycoib.prepareStatement("Select id,ToplamBilet,MevcutBilet from k_koltuk where id ='1'");
              
            ResultSet rs1 = pst.executeQuery();
              if(rs1.next()==false){
                  
                  JOptionPane.showMessageDialog(this,"Error");
                  
                   }
               else{
                  
                 jTextField2.setText(rs1.getString("ToplamBilet"));
                 jTextField3.setText(rs1.getString("MevcutBilet"));
              }
             
          } 
          catch (Exception e) {
        }
    }
     public void BiletBUl() {
         try {
      Class.forName("com.mysql.jdbc.Driver");
     mycoib = DriverManager.getConnection(url,user,pass);
     
       } 
          catch (Exception e) {
         }
    }
  
    @SuppressWarnings("unchecked")
    //Dizayn kısmı butonlar tanımlandı 
    
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Koltuk Düzeni");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 120, 30));

        jButton1.setText("Devam Et");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
        }
        } );
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 250, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
        }
        } );
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 150, 30));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField2.setEditable(false);
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 150, 30));

        jTextField3.setEditable(false);
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 150, 30));

        jLabel3.setText("Mevcut Bilet Sayısı");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 120, 30));

        jLabel2.setText("Toplam Bilet Sayısı");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 430));

        jButton2.setText("Devam Et");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
        }
        }  );
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 250, 30));

        pack();
    }

    //Devam et Button Tıklanırsa  K_Odeme Sayfasına Yönlenecektir.
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
          
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(url,user,pass);
            pst = sqlConn.prepareStatement("update k_koltuk SET ToplamBilet=?,MevcutBilet=?  where id ='1'");
             
            //Toplam Bilet sayısı için gelen sayıları int çevirip 
        //select id ile k_koltuk veritabına bir azaltma işlemi yapıyorum .
               int toplamBilet = Integer.parseInt(jTextField2.getText());
                toplamBilet=toplamBilet-1;
               pst.setInt(1, toplamBilet);
               
               //Mevcut Bilet sayısı için gelen sayıları int çevirip 
       // select id ile k_koltuk veritabına bir artıma işlemi yapıyorum .
                  int mevcutBilet = Integer.parseInt(jTextField3.getText());
                   mevcutBilet=mevcutBilet+1;
                   pst.setInt(2, mevcutBilet);
        
                //Koltuk Sayısı  Mevcutdur ve İstege Göre artırılabilir.
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Koltuk Numarası Alındı!");
          
//Try-catch ile hata yazdırma
        }
         catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(K_Koltuk.class.getName()).log(java.util.logging.Level.
                SEVERE,null, ex);
            JOptionPane.showMessageDialog(this,"Hata!");

        } 
         catch (SQLException ex) {
            
            java.util.logging.Logger.getLogger(K_Koltuk.class.getName()).log(java.util.logging.Level.
                SEVERE,null, ex);
            JOptionPane.showMessageDialog(this,"Hata!");
        }
        new K_Odeme().setVisible(true);
        this.dispose();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
       
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
            java.util.logging.Logger.getLogger(K_Koltuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
          catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(K_Koltuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
          catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(K_Koltuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
          catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(K_Koltuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new K_Koltuk().setVisible(true);
        }
        }
            );
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    
} //Çerçeve Panel ve button tasarmı ve yazı biçimi 
