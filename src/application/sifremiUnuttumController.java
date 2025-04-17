package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.IsteMySQL.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class sifremiUnuttumController {
	
	public sifremiUnuttumController()
	{
		baglanti=VeritabaniUtil.Baglan();
	}


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGirisEkrani;

    @FXML
    private Button btnSifreGöster;

    @FXML
    private TextField txtIsim;

    @FXML
    private TextField txtMail;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;


    @FXML
    void btnGirisEkraniClc(ActionEvent event) {
    	try {
    		Stage stage = (Stage) btnGirisEkrani.getScene().getWindow();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("giris.fxml"));
			stage.setTitle("Giriş Yap");
			stage.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnSifreGösterClc(ActionEvent event) {
    	if(txtIsim.getText().equals("") && txtMail.getText().equals(""))
    	{
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Hata");
        	alert.setHeaderText("İşlem başarısız oldu");
        	alert.setContentText("Lütfen Bilgilerinizi Eksiksiz Doldurun");
        	alert.showAndWait();
    		
    	}
    	else
    	{		
    	sql = "SELECT sifre FROM kullanici_giris_bilgileri WHERE email=? and isim=?";
        try {
            sorguIfadesi = baglanti.prepareStatement(sql);
            sorguIfadesi.setString(1, txtMail.getText().trim());
            sorguIfadesi.setString(2, txtIsim.getText().trim());

            ResultSet getirilen = sorguIfadesi.executeQuery();
            										
            if (!getirilen.next()) {
            	
            	Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setTitle("Hata");
            	alert.setHeaderText("İşlem başarısız oldu");
            	alert.setContentText("Bilgilerinizle Eşleşen Bir Parola Bulunamadı");
            	alert.showAndWait();             
            }
            else
            {
            	Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setTitle("Hata");
            	alert.setHeaderText("İşlem başarılı");
            	alert.setContentText("Şifreniz: " + getirilen.getString("sifre"));
            	alert.showAndWait();
            }
        } catch(Exception e)
        {
        	System.out.println(e.getMessage().toString());
        }}
    }

    @FXML
    void initialize() {
    }

}



