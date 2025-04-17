package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.IsteMySQL.Util.VeritabaniUtil;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class sorunBulKullaniciController {

    public sorunBulKullaniciController() {
        baglanti = VeritabaniUtil.Baglan();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGeriDon;

    @FXML
    private Button btnSorunBul;

    @FXML
    private ComboBox<String> cmboxNasilBasladi;

    @FXML
    private ComboBox<String> cmboxSorun;

    Connection baglanti = null;
    PreparedStatement sorguIfadesi = null;
    PreparedStatement sorguIfadesi2 = null;
    ResultSet getirilen = null;
    String sql;

    @FXML
    void btnGeriDonClc(ActionEvent event) {
        try {
            Stage stage = (Stage) btnGeriDon.getScene().getWindow();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("kullaniciPanel.fxml"));
            stage.setTitle("Topla Veya Tamir Et");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSorunBulClc(ActionEvent event) {
    	if(!(cmboxSorun.getSelectionModel().getSelectedItem() == null) && !(cmboxNasilBasladi.getSelectionModel().getSelectedItem()==null))
    	{
        try {
        	String anaSorun = cmboxSorun.getSelectionModel().getSelectedItem().toString();
        	
        	String nasilBasladi = cmboxNasilBasladi.getSelectionModel().getSelectedItem().toString();
        	
        	String veri = "Boş",veri1 = "Boş";
        	
        	sql = "SELECT asilSorun FROM sorunu_bul_table WHERE id=?";
            sorguIfadesi = baglanti.prepareStatement(sql);
            sorguIfadesi.setString(1, String.valueOf(anaSorun.substring(0, 2)).trim());
            
            
            sql = "SELECT nasilBasladi FROM sorunu_bul_table WHERE id=?";
            sorguIfadesi2 = baglanti.prepareStatement(sql);
            sorguIfadesi2.setString(1, String.valueOf(nasilBasladi.substring(0, 2)).trim());
            ResultSet getirilen = sorguIfadesi.executeQuery();
            ResultSet getirilen2 = sorguIfadesi2.executeQuery();
            
            if (getirilen2.next()) {
                veri1 = getirilen2.getString(1); // İlgili sütunun indeksi
            }
            
            if (getirilen.next()) {
                veri = getirilen.getString(1); // İlgili sütunun indeksi
            }
         	
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("sorunBuldu.fxml"));
        		AnchorPane pane2 = (AnchorPane) loader.load();
    			
        		sorunBulduController nesne = loader.getController();
    			nesne.veriAl(veri, veri1); 			
    			Scene scene2= new Scene(pane2);
    			Stage stage2 = new Stage();
    			stage2.setScene(scene2);
        		stage2.setTitle("Bakım Yapalım");     		
        		stage2.setResizable(false);
    			stage2.show();
  			
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    		
    	}
    	else
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Hata");
        	alert.setHeaderText("İşlem başarısız oldu");
        	alert.setContentText("Bilgilerin Tamamını Doldurunuz..");
        	alert.showAndWait();
    	}
    }

    @FXML
    void cmboxNasilBasladiClc(ActionEvent event) {
        // Gerekirse burada ek işlemler yapılabilir
    }

    @FXML
    void cmboxSorunClc(ActionEvent event) {
        // Gerekirse burada ek işlemler yapılabilir
    }

    @FXML
    void initialize() {
        cmboxSorun.setItems(FXCollections.observableArrayList(
                "1 - Bilgisayarım Start Almıyor",
                "2 - Bilgisayarım Açılıyor Ama Görüntü Vermiyor",
                "3 - Bilgisayarım Açılıyor Fakat Görüntü Bozuk",
                "4 - Bilgisayarım Olur Olmadık Yerde Kapanıyor",
                "5 - Mavi Ekran Hatası Alıyorum",
                "6 - Bilgisayarımın Bazı Kompanentleri Doğru Çalışmıyor",
                "7 - Bilgisayarımın USB Çıkışları Çalışmıyor",
                "8 - Bilgisayarım İnternete Bağlanmıyor",
                "9 - Bilgisayarım Çok Yavaşladı",
                "10 - Bilgisayarımın Ses Çıkışları Çalışmıyor",
                "11 - Sorunum Burada Yok"));
        cmboxNasilBasladi.setItems(FXCollections.observableArrayList(
                "1 - Bir Anda Olmaya Başladı",
                "2 - Zaman İçerisinde Ara Ara Oluyor",
                "3 - Normal Bir Şekilde Açtığımda Sorun İle Karşılaştım",
                "4 - Fiziksel Hasar Sonucu",
                "5 - Cevabım Burada Yok"));
    }
}
