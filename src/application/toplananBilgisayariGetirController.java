package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.IsteMySQL.Util.VeritabaniUtil;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class toplananBilgisayariGetirController {
	
	public static int girisYapildiMi=0;
	
	public toplananBilgisayariGetirController()
	{
		baglanti=VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnKaydiSil;

    @FXML
    private Button btnKendiKaydiniEkle;

    @FXML
    private Button btnKutucuklariTemizle;

    @FXML
    private Button btnPaneliKapat;

    @FXML
    private TableView<kullaniciSistem_kayitlar> tableSistem;

    @FXML
    private TableColumn<kullaniciSistem_kayitlar,String> tableSistemAnakart;

    @FXML
    private TableColumn<kullaniciSistem_kayitlar,String> tableSistemEkrankarti;

    @FXML
    private TableColumn<kullaniciSistem_kayitlar,Integer> tableSistemId;

    @FXML
    private TableColumn<kullaniciSistem_kayitlar,String> tableSistemIslemci;

    @FXML
    private TableColumn<kullaniciSistem_kayitlar,String> tableSistemKasa;

    @FXML
    private TableColumn<kullaniciSistem_kayitlar,String> tableSistemRam;

    @FXML
    private TextField txtAnakart;

    @FXML
    private TextField txtDisKasa;

    @FXML
    private TextField txtEkrankarti;

    @FXML
    private TextField txtIslemci;

    @FXML
    private TextField txtKullaniciEposta;

    @FXML
    private TextField txtRam;
    
    Connection baglanti=null;    
    PreparedStatement sorguIfadesi=null;
    String sql;
    ResultSet getirilen;
    ObservableList<kullaniciSistem_kayitlar> veriler;

    @FXML
    void btnKaydiSilClc(ActionEvent event) {
    	int id = 0;
        
    	kullaniciSistem_kayitlar seciliKayit = tableSistem.getSelectionModel().getSelectedItem(); 
   	    if (seciliKayit != null) { 
   	        id = seciliKayit.getKullanici_sistem_id();
   	    }
   	    if(id== 0)
   	    {
   	    	Alert alert = new Alert(AlertType.INFORMATION);
           	alert.setTitle("Başarılı");
           	alert.setHeaderText("Silme İşlemini Gerçekleştirmek İçin Bir Satır Seçmelisiniz");
           	alert.showAndWait();
   	    }
   	    else
   	    {
   	    	Alert alert = new Alert(AlertType.CONFIRMATION);
   	        alert.setTitle("Uyarı");
   	        alert.setHeaderText("Emin misiniz?");
   	        alert.setContentText("Bu işlem geri alınamaz.");

   	        ButtonType sonuc = alert.showAndWait().orElse(ButtonType.CANCEL);

   	       
   	        if (sonuc == ButtonType.OK) {
   	        	sql = "DELETE FROM kullanici_sistemi_table WHERE kullanici_sistem_id=? ";
       	        try {        	
       	            sorguIfadesi = baglanti.prepareStatement(sql);
       	            sorguIfadesi.setInt(1, id);
       	            sorguIfadesi.executeUpdate(); 
       	        }
       	        catch(Exception e)
       	        {
       	            e.printStackTrace();
       	        }
       	        Alert alert2 = new Alert(AlertType.INFORMATION);
               	alert2.setTitle("Başarılı");
               	alert2.setHeaderText("Silme İşlemi Gerçekleşti");
               	alert2.showAndWait(); 	            
   	        } else {  	            	           
   	        }  	    	
   	    }
   	
       tabloYenile();
    }

    @FXML
    void btnKendiKaydiniEkleClc(ActionEvent event) {
        Alert alert2 = new Alert(AlertType.INFORMATION);
        if (!txtAnakart.getText().equals("") && !txtIslemci.getText().equals("") && !txtRam.getText().equals("")) {
            sql = "INSERT INTO kullanici_sistemi_table (kullanici_mail, kullanici_anakart, kullanici_islemci, kullanici_ekrankarti, kullanici_ram, kullanici_kasa) " +
                  "VALUES (?, ?, ?, ?, ?, ?)";
            try {
                sorguIfadesi = baglanti.prepareStatement(sql);          
                sorguIfadesi.setString(1, txtKullaniciEposta.getText().trim());
                sorguIfadesi.setString(2, txtAnakart.getText().trim());
                sorguIfadesi.setString(3, txtIslemci.getText().trim());
                sorguIfadesi.setString(4, txtEkrankarti.getText().trim());
                sorguIfadesi.setString(5, txtRam.getText().trim());
                sorguIfadesi.setString(6, txtDisKasa.getText().trim());                
                sorguIfadesi.executeUpdate();               
                alert2.setTitle("Başarılı");
                alert2.setHeaderText("Kayıt Başarıyla Eklendi");
                alert2.showAndWait();
            } catch (Exception e) {
                alert2.setTitle("Hata");
                alert2.setHeaderText("Kayıt Eklenirken Bir Hata Meydana Geldi!!!");
                alert2.showAndWait();
                e.printStackTrace();
            }
        } else {
            alert2.setTitle("Hata");
            alert2.setHeaderText("Anakart İşlemci Ve Ram olmadan Bilgisayar Kayıt Edemezsiniz!!!");
            alert2.showAndWait();
        }
    }

    @FXML
    void btnKutucuklariTemizleClc(ActionEvent event) {
    	txtAnakart.clear();
    	txtDisKasa.clear();
    	txtIslemci.clear();
    	txtRam.clear();
    	txtEkrankarti.clear();
    }

    @FXML
    void btnPaneliKapatClc(ActionEvent event) {
    	try {
        	Stage stage = (Stage) btnPaneliKapat.getScene().getWindow();
    		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("bilgisayarTopla.fxml"));
    		stage.setTitle("Topladığım Bilgisayarlar");
    		stage.setResizable(false);
    		stage.setScene(new Scene(root));
    	} 	catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void initialize() {  	
    	txtKullaniciEposta.setText(girisController.hesapBilgi);  	
    	tabloYenile();
    	tableSistem.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
            	kullaniciSistem_kayitlar selectedKayit = tableSistem.getSelectionModel().getSelectedItem();
                txtAnakart.setText(selectedKayit.getKullanici_anakart());
                txtDisKasa.setText(selectedKayit.getKullanici_anakart());
                txtEkrankarti.setText(selectedKayit.getKullanici_ekrankarti());
                txtIslemci.setText(selectedKayit.getKullanici_islemci());
                txtRam.setText(selectedKayit.getKullanici_ram());             
            }
        });

    }
    public void tabloYenile()
    {
    	sql = "SELECT * FROM kullanici_sistemi_table WHERE kullanici_mail=? ";
        try {
            sorguIfadesi = baglanti.prepareStatement(sql);
            sorguIfadesi.setString(1, girisController.hesapBilgi.trim());
            getirilen = sorguIfadesi.executeQuery();          
            veriler = FXCollections.observableArrayList();           
            veriler.clear(); // Önceki verileri temizle
            while (getirilen.next()) {
            	int sistemId = getirilen.getInt("kullanici_sistem_id");
                String anakart = getirilen.getString("kullanici_anakart");
                String ekranK = getirilen.getString("kullanici_ekrankarti");
                String islemci = getirilen.getString("kullanici_islemci");
                String kasa = getirilen.getString("kullanici_kasa");
                String ram = getirilen.getString("kullanici_ram");              
                veriler.add(new kullaniciSistem_kayitlar(sistemId, anakart, ekranK, islemci, kasa, ram));
            }
            tableSistem.setItems(veriler);

        } catch (Exception e) {
            e.printStackTrace();
        }
        tableSistemId.setCellValueFactory(new PropertyValueFactory<>("kullanici_sistem_id"));
        tableSistemAnakart.setCellValueFactory(new PropertyValueFactory<>("kullanici_anakart"));
        tableSistemEkrankarti.setCellValueFactory(new PropertyValueFactory<>("kullanici_ekrankarti"));
        tableSistemIslemci.setCellValueFactory(new PropertyValueFactory<>("kullanici_islemci"));
        tableSistemKasa.setCellValueFactory(new PropertyValueFactory<>("kullanici_kasa"));
        tableSistemRam.setCellValueFactory(new PropertyValueFactory<>("kullanici_ram"));       
    }

}
