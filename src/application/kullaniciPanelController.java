package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class kullaniciPanelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBilgisayarSorunBul;

    @FXML
    private Button btnBilgisayarTopla;

    @FXML
    private Button btnGirisEkrani;

    @FXML
    private Label lblKullaniciBilgiGoster;

    @FXML
    void btnBilgisayarSorunBulClc(ActionEvent event) {
    	try {
    		Stage stage = (Stage) btnBilgisayarSorunBul.getScene().getWindow();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("sorunBulKullanici.fxml"));
			stage.setTitle("Bakım Yapalım");
			stage.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnBilgisayarToplaClc(ActionEvent event) {
    	try {
    		Stage stage = (Stage) btnBilgisayarTopla.getScene().getWindow();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("bilgisayarTopla.fxml"));
			stage.setTitle("Bilgisayarınızı Özelleştirelim");
			stage.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnGirisEkraniClc(ActionEvent event) {
    	if(girisController.girisYapildiMi==1)
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Dikkat");
        	alert.setHeaderText("Hesabınızdan Çıkış Yapmak Üzeresiniz!");
        	alert.setContentText("Çıkış Yapmak İstiyor Musunuz?");
        	ButtonType buttonTypeYes = new ButtonType("Evet");
        	ButtonType buttonTypeNo = new ButtonType("Hayır");
        	alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        	ButtonType result = alert.showAndWait().orElse(null);

        	if (result == buttonTypeYes) {
        		try {
            		Stage stage = (Stage) btnGirisEkrani.getScene().getWindow();
        			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("giris.fxml"));
        			stage.setTitle("Giriş Yap");
        			stage.setScene(new Scene(root));
        			girisController.girisYapildiMi = 0;
        		} catch(Exception e) {
        			e.printStackTrace();
        		}
        	} else if (result == buttonTypeNo) {      	    
        	}
    	}
    	else {
    	try {
    		Stage stage = (Stage) btnGirisEkrani.getScene().getWindow();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("giris.fxml"));
			stage.setTitle("Giriş Yap");
			stage.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
    	}
    }

    @FXML
    void initialize() {}
    }


