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

public class adminGirisController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdminGeri;

    @FXML
    private Button btnAdminGiris;

    @FXML
    private TextField txtID;

    @FXML
    private PasswordField txtSifre;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    public adminGirisController()
	{
		baglanti=VeritabaniUtil.Baglan();
	}
	
    
    @FXML
    void btnAdminGeriClc(ActionEvent event)
    {
    	try {
    		Stage stage = (Stage) btnAdminGeri.getScene().getWindow();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("giris.fxml"));
			stage.setTitle("Giriş Yap");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    void btnAdminGirisClc(ActionEvent event) 
    {
    	if(txtID.getText().equals("") && txtSifre.getText().equals(""))
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Hata");
        	alert.setHeaderText("Lütfen Bilgilerinizi Giriniz");
        	alert.showAndWait();
    	}
    	else {

    	sql = "SELECT * FROM admin_giris_bilgileri WHERE admin_Id=? and admin_sifre=?";
    	
    	try {
    		sorguIfadesi = baglanti.prepareStatement(sql);
        	sorguIfadesi.setString(1, txtID.getText().trim());
        	sorguIfadesi.setString(2, txtSifre.getText().trim());
        
        	ResultSet getirilen = sorguIfadesi.executeQuery();       	
        	if(getirilen.next())
        	{
        		Stage stage = (Stage) btnAdminGiris.getScene().getWindow();
    			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("adminEkran.fxml"));
    			stage.setTitle("Admin Panel");
    			stage.setResizable(false);
    			stage.setScene(new Scene(root));  			
        	}
        	else
        	{
        		Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setTitle("Hata");
            	alert.setHeaderText("İşlem başarısız oldu");
            	alert.setContentText("Geçersiz ID veya Parola");
            	alert.showAndWait();
        	}    		
		} catch(Exception e) {
			e.printStackTrace();
		}}	
    }

    @FXML
    void initialize() {
    }
}
