package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.IsteMySQL.Util.VeritabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class bilgisayarToplaAnaController {
	
	public bilgisayarToplaAnaController()
	{
		baglanti=VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnKontrol;

    @FXML
    private Button btnTopladigimiKaydet;

    @FXML
    private ComboBox<kullaniciPcToplama_Kayitlar> cmboxAnakart;

    @FXML
    private ComboBox<kullaniciPcToplama_Kayitlar> cmboxEkrankarti;

    @FXML
    private ComboBox<kullaniciPcToplama_Kayitlar> cmboxIslemci;

    @FXML
    private ComboBox<kullaniciPcToplama_Kayitlar> cmboxKasa;

    @FXML
    private ComboBox<kullaniciPcToplama_Kayitlar> cmboxMonitor;

    @FXML
    private ComboBox<kullaniciPcToplama_Kayitlar> cmboxRam;

    @FXML
    private Label lblKontrol;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    
    

    @FXML
    void btnKontrolClc(ActionEvent event) {
    	if(!(cmboxIslemci.getSelectionModel().getSelectedItem() == null) && !(cmboxEkrankarti.getSelectionModel().getSelectedItem() == null))
    	{
    		if(Math.abs(cmboxIslemci.getSelectionModel().getSelectedIndex()-cmboxEkrankarti.getSelectionModel().getSelectedIndex()) <= 5)
    		{
    			lblKontrol.setText("Bilgisayarınız Gayet Uyumlu");		
    		}
    		else
    		{
    			lblKontrol.setText("Ekran Kartı İle İşemci Uyumluluğunda Problem Var");
    		}
    	}
    	else
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Hata");
        	alert.setHeaderText("Ekran Kartı İle İşlemciyi Girmeniz Gerekmektedir");
        	alert.showAndWait();
    	}
    }

    @FXML
    void btnTopladigimiKaydetClc(ActionEvent event) {
    	if(girisController.girisYapildiMi==1)
    	{
    	Alert alert2 = new Alert(AlertType.INFORMATION);
    	if(!(cmboxIslemci.getSelectionModel().getSelectedItem() == null) && !(cmboxEkrankarti.getSelectionModel().getSelectedItem() == null) && !(cmboxRam.getSelectionModel().getSelectedItem() == null))
    	{
    	sql = "INSERT INTO kullanici_sistemi_table (kullanici_mail, kullanici_anakart, kullanici_islemci, kullanici_ekrankarti, kullanici_ram, kullanici_kasa) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
    	try {
    		sorguIfadesi = baglanti.prepareStatement(sql);
        	
            sorguIfadesi.setString(1, girisController.hesapBilgi.trim());
            sorguIfadesi.setString(2, cmboxAnakart.getSelectionModel().getSelectedItem().toString().trim());
            sorguIfadesi.setString(3, cmboxIslemci.getSelectionModel().getSelectedItem().toString().trim());
            sorguIfadesi.setString(4, cmboxEkrankarti.getSelectionModel().getSelectedItem().toString().trim());
            sorguIfadesi.setString(5, cmboxRam.getSelectionModel().getSelectedItem().toString().trim());
            sorguIfadesi.setString(6, cmboxKasa.getSelectionModel().getSelectedItem().toString().trim());                    
            sorguIfadesi.executeUpdate();
                 
        	alert2.setTitle("Başarılı");
        	alert2.setHeaderText("Kayıt Başarıyla Eklendi");
        	alert2.showAndWait();
    	}
    	catch(Exception e)
    	{
        	alert2.setTitle("Hata");
        	alert2.setHeaderText("Kayıt Eklenirken Bir Hata Meydana Geldi!!!");
        	alert2.showAndWait();
    		e.printStackTrace();
    	}   	
    	}
    	else
    	{   		
        	alert2.setTitle("Hata");
        	alert2.setHeaderText("Anakart İşlemci Ve Ram olmadan Bilgisayar Kayıt Edemezsiniz!!!");
        	alert2.showAndWait();
    	}
    	}
    	else
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Hata");
        	alert.setHeaderText("Bu Özelliği Kullanabilmek İçin Giriş Yapmalısınız!");
        	alert.showAndWait();
    	}


    }

    @FXML
    void cmboxAnakartClc(ActionEvent event) {

    }

    @FXML
    void cmboxEkrankartiClc(ActionEvent event) {

    }

    @FXML
    void cmboxIslemciClc(ActionEvent event) {

    }

    @FXML
    void cmboxKasaClc(ActionEvent event) {

    }

    @FXML
    void cmboxMonitorClc(ActionEvent event) {

    }

    @FXML
    void cmboxRamClc(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

    public void sqlSor(String sorgu,String columnName, ComboBox<kullaniciPcToplama_Kayitlar> comboBox){
    	ObservableList<kullaniciPcToplama_Kayitlar> veriListesi = FXCollections.observableArrayList();
    	try {
			sorguIfadesi = baglanti.prepareStatement(sorgu);
			getirilen = sorguIfadesi.executeQuery();
			while (getirilen.next()) {
	            String veri = getirilen.getString(columnName);
	            veriListesi.add(new kullaniciPcToplama_Kayitlar(veri));
	        }
			comboBox.setItems(veriListesi);
		} catch (SQLException e) {

			e.printStackTrace();
		}
        
    }
    public void veriAl(String monitor,String amac)
    {
    	 if (monitor.charAt(0) == '1') {
    	        sqlSor("SELECT monitor_isim FROM monitor_table WHERE monitor_id <= 10", "monitor_isim", cmboxMonitor);
    	    } else if (monitor.charAt(0) == '2') {
    	        sqlSor("SELECT monitor_isim FROM monitor_table WHERE monitor_id > 10 AND monitor_id <= 20", "monitor_isim", cmboxMonitor);
    	    } else if (monitor.charAt(0) == '3') {
    	        sqlSor("SELECT monitor_isim FROM monitor_table WHERE monitor_id > 20", "monitor_isim", cmboxMonitor);
    	    }

    	    if (amac.charAt(0) == '1') {
    	        sqlSor("SELECT islemci_isim FROM islemci_ram WHERE islemci_id > 20", "islemci_isim", cmboxIslemci);
    	        sqlSor("SELECT anakart_isim FROM anakart_table WHERE anakart_id > 20", "anakart_isim", cmboxAnakart);
    	        sqlSor("SELECT ram_isim FROM ram_table WHERE ram_id > 20", "ram_isim", cmboxRam);
    	        sqlSor("SELECT kasa_isim FROM kasa_table WHERE kasa_id > 20", "kasa_isim", cmboxKasa);
    	        sqlSor("SELECT ekrankarti_isim FROM ekrankarti_table WHERE ekrankarti_id > 20", "ekrankarti_isim", cmboxEkrankarti);
    	    } else if (amac.charAt(0) == '2') {
    	        sqlSor("SELECT islemci_isim FROM islemci_ram WHERE islemci_id >10 AND islemci_id <= 20", "islemci_isim", cmboxIslemci);
    	        sqlSor("SELECT anakart_isim FROM anakart_table WHERE anakart_id > 10 AND anakart_id <= 20", "anakart_isim", cmboxAnakart);
    	        sqlSor("SELECT ram_isim FROM ram_table WHERE ram_id > 10 AND ram_id <= 20", "ram_isim", cmboxRam);
    	        sqlSor("SELECT kasa_isim FROM kasa_table WHERE kasa_id > 10 AND kasa_id <= 20", "kasa_isim", cmboxKasa);
    	        sqlSor("SELECT ekrankarti_isim FROM ekrankarti_table WHERE ekrankarti_id > 10 AND ekrankarti_id <= 20", "ekrankarti_isim", cmboxEkrankarti);
    	    } else if (amac.charAt(0) == '3' || amac.charAt(0) == '4') {
    	        sqlSor("SELECT islemci_isim FROM islemci_ram WHERE islemci_id <= 10", "islemci_isim", cmboxIslemci);
    	        sqlSor("SELECT anakart_isim FROM anakart_table WHERE anakart_id <= 10", "anakart_isim", cmboxAnakart);
    	        sqlSor("SELECT ram_isim FROM ram_table WHERE ram_id <= 10", "ram_isim", cmboxRam);
    	        sqlSor("SELECT kasa_isim FROM kasa_table WHERE kasa_id <= 10", "kasa_isim", cmboxKasa);
    	        sqlSor("SELECT ekrankarti_isim FROM ekrankarti_table WHERE ekrankarti_id <= 10", "ekrankarti_isim", cmboxEkrankarti);
    	    }	   	
    }
}


