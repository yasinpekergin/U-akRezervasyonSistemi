package odev;

import java.sql.Connection;
import java.sql.DriverManager;   //veri tabanı bağlantı kütüphaensi ve driver kontrolü
import java.sql.PreparedStatement; //sql sorgusundaki değerler veri tabanına gönderilir.
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;  //kullanıcıdan veri alırken ve ekrana bilgi gönderirken 

/**
 *
 * @author Yasin Pekergin
 */

public class K_Sayfa extends javax.swing.JFrame { //Veri tabnı bağlantısı
    private static final String url = "jdbc:mysql://localhost:3306/odev";
    private static final String user = "root";
    private static final String pass = "";
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    
    public K_Sayfa() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    //Dizayn parametreleri
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel1.setText("Hava Yolu");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 80, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel2.setText("Gidilecek Yer");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 80, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz", "Türk Hava Yolları", "Pegasus", "Sunexpress", "AnadoluJet", "Onur Air", "Atlasglobal" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 170, 30));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz", "\"Adana\"", "\"Adıyaman\"", "\"Afyonkarahisar\"", "\"Ağrı\"", "\"Aksaray\"", "\"Amasya\"", "\"Ankara\"", "\"Antalya\"", "\"Ardahan\"", "\"Artvin\"", "\"Aydın\"", "\"Balıkesir\"", "\"Bartın\"", "\"Batman\"", "\"Bayburt\"", "\"Bilecik\"", "\"Bingöl\"", "\"Bitlis\"", "\"Bolu\"", "\"Burdur\"", "\"Bursa\"", "\"Çanakkale\"", "\"Çankırı\"", "\"Çorum\"", "\"Denizli\"", "\"Diyarbakır\"", "\"Düzce\"", "\"Edirne\"", "\"Elazığ\"", "\"Erzincan\"", "\"Erzurum\"", "\"Eskişehir\"", "\"Gaziantep\"", "\"Giresun\"", "\"Gümüşhane\"", "\"Hakkâri\"", "\"Hatay\"", "\"Iğdır\"", "\"Isparta\"", "\"İstanbul\"", "\"İzmir\"", "\"Kahramanmaraş\"", "\"Karabük\"", "\"Karaman\"", "\"Kars\"", "\"Kastamonu\"", "\"Kayseri\"", "\"Kilis\"", "\"Kırıkkale\"", "\"Kırklareli\"", "\"Kırşehir\"", "\"Kocaeli\"", "\"Konya\"", "\"Kütahya\"", "\"Malatya\"", "\"Manisa\"", "\"Mardin\"", "\"Mersin\"", "\"Muğla\"", "\"Muş\"", "\"Nevşehir\"", "\"Niğde\"", "\"Ordu\"", "\"Osmaniye\"", "\"Rize\"", "\"Sakarya\"", "\"Samsun\"", "\"Şanlıurfa\"", "\"Siirt\"", "\"Sinop\"", "\"Sivas\"", "\"Şırnak\"", "\"Tekirdağ\"", "\"Tokat\"", "\"Trabzon\"", "\"Tunceli\"", "\"Uşak\"", "\"Van\"", "\"Yalova\"", "\"Yozgat\"", "\"Zonguldak\"" }));
        jComboBox3.setName(""); 
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 170, 30));

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setText("Giriş");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 260, 30));

        jButton2.setText("Geri Dön");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 270));

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        new K_AnaSayfa().setVisible(true);
        this.dispose();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
             try
        {

            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(url,user,pass);
            pst = sqlConn.prepareStatement("insert into k_bilet(Git,HavaYolu)value(?,?)");
               //Gidilecek Yer ve Havayolu Şirketi Bilgisi MYSQL e ekleniyor
            
            String value=jComboBox2.getSelectedItem().toString();
            pst.setString(1,value);
                
            String value2=jComboBox3.getSelectedItem().toString();
               pst.setString(2,value2);
          

            pst.executeUpdate();
           
        
            //Giris Buttona Tıklanırsa K_Koltuk Gidliyor.
          new K_Koltuk().setVisible(true);
            this.dispose();
            
        }

        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KayıtOl.class.getName()).log(java.util.logging.Level.
                SEVERE,null, ex); //sınıf bulunamadı hatası null döndür

        } 
        catch (SQLException ex) {
           
            java.util.logging.Logger.getLogger(KayıtOl.class.getName()).log(java.util.logging.Level.
                SEVERE,null, ex); //SQL bağlantı hatası null döndür

        }
        
        
       
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
            java.util.logging.Logger.getLogger(K_Sayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(K_Sayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(K_Sayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(K_Sayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new K_Sayfa().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    
}  //Çerçeve Panel ve button tasarmı ve yazı biçimi 
