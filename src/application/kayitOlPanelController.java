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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class kayitOlPanelController {
	
	public kayitOlPanelController()
	{
		baglanti=VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGiris;

    @FXML
    private Button btnKayitOl;

    @FXML
    private TextField txtKulAdi;

    @FXML
    private TextField txtMail;

    @FXML
    private PasswordField txtSifre;

    @FXML
    private PasswordField txtSifreTekrar;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    public static int girisYapildiMi=0;

    @FXML
    void btnGirisClc(ActionEvent event) {
    	try {
        	Stage stage = (Stage) btnGiris.getScene().getWindow();
    		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("giris.fxml"));
    		stage.setTitle("Giriş Yap");
    		stage.setScene(new Scene(root));
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void btnKayitOlClc(ActionEvent event) {
    	if(!txtMail.getText().equals("") && !txtKulAdi.getText().equals("") && !txtSifre.getText().equals("") && !txtSifreTekrar.getText().equals(""))
    	{
    		if(txtMail.getText().contains("@") && txtMail.getText().contains(".com"))
    		{
    			if(txtSifre.getText().equals(txtSifreTekrar.getText()))
    			{
    				if(txtSifre.getText().length()>= 8)
    				{
	
    					sql = "SELECT * FROM kullanici_giris_bilgileri WHERE email=?";
    			        try {
    			            sorguIfadesi = baglanti.prepareStatement(sql);
    			            sorguIfadesi.setString(1, txtSifre.getText().trim());

    			            ResultSet getirilen = sorguIfadesi.executeQuery();
    			            
    			            if (getirilen.next()) {
    			            	
    			            	Alert alert = new Alert(AlertType.INFORMATION);
    			            	alert.setTitle("Hata");
    			            	alert.setHeaderText("İşlem başarısız oldu");
    			            	alert.setContentText("Bu Eposta Adına Zaten Kayıt Var");
    			            	alert.showAndWait();
    			                
    			            } else {
    			            	String sql = "INSERT INTO kullanici_giris_bilgileri (email, sifre, isim) VALUES (?, ?, ?)";
    			            	try {
    			            	sorguIfadesi=baglanti.prepareStatement(sql);
    			    			sorguIfadesi.setString(1,txtMail.getText().trim());
    			    			sorguIfadesi.setString(2,txtSifre.getText().trim());
    			    			sorguIfadesi.setString(3, txtKulAdi.getText().trim());
    			    			
    			            	sorguIfadesi.executeUpdate();
    			            	
    			            
    			            	
    			            	Alert alert = new Alert(AlertType.INFORMATION);
    			            	alert.setTitle("Başarılı");
    			            	alert.setHeaderText("İşlem Başarılı");
    			            	alert.setContentText("Kaydınız Oluşturulmuştur");
    			            	alert.showAndWait();
    			            	
    			            	}
    			            	catch(Exception e)
    			            	{
    			            		Alert alert = new Alert(AlertType.INFORMATION);
        			            	alert.setTitle("Başarısız");
        			            	alert.setHeaderText("İşlem Başarısız");
        			            	alert.setContentText("Kaydınız Oluşturulurken Bir Hata Meydana Geldi");
        			            	alert.showAndWait();
    			            		System.out.println(e.getMessage().toString());
    			            	}
    
    			            }
    			        } catch(Exception e) {
    			            System.out.println(e.getMessage().toString());
    			        }
	
    				}
    				else
    				{
    					Alert alert = new Alert(AlertType.INFORMATION);
                    	alert.setTitle("Başarısız");
                    	alert.setHeaderText("Daha Güçlü Bir Şifre Girin");
                    	alert.showAndWait();
    				}
    			}
    			else
    			{
    				Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Başarısız");
                	alert.setHeaderText("Parolalar Eşleşmiyor");
                	alert.showAndWait();
    			}
    		}
    		else
    		{
    			Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setTitle("Başarısız");
            	alert.setHeaderText("Lütfen Geçerli Bir E-posta Adresi Girin");
            	alert.showAndWait();
    		}
    	}
    	else
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Başarısız");
        	alert.setHeaderText("Lütfen Kutucukları Doldurunuz");
        	alert.showAndWait();
    	}
    	
    }

    @FXML
    void initialize() {


    }

}
