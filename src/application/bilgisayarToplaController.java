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
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class bilgisayarToplaController {
	public bilgisayarToplaController()
	{
		baglanti=VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBilgisayarBul;

    @FXML
    private Button btnEskiSistemler;

    @FXML
    private Button btnGeriDon;

    @FXML
    private ComboBox<String> cmboxAmac;

    @FXML
    private ComboBox<String> cmboxMonitor;

    @FXML
    private ComboBox<String> cmboxSeviye;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void btnBilgisayarBulClc(ActionEvent event) {
    	String monitorSecim,amac;
    	if( !(cmboxAmac.getSelectionModel().getSelectedItem() == null) && !(cmboxSeviye.getSelectionModel().getSelectedItem() == null) && !(cmboxMonitor.getSelectionModel().getSelectedItem() == null) ) 
    	{
    			monitorSecim = cmboxMonitor.getSelectionModel().getSelectedItem().toString();
        		amac = cmboxAmac.getSelectionModel().getSelectedItem().toString();
        		try {
            		FXMLLoader loader = new FXMLLoader(getClass().getResource("bilgisayarToplaAna.fxml"));
            		AnchorPane pane2 = (AnchorPane) loader.load();

            		bilgisayarToplaAnaController nesne = loader.getController();
            		nesne.veriAl(monitorSecim,amac); 
            		
        			Scene scene2= new Scene(pane2);
        			Stage stage2 = new Stage();
        			stage2.setScene(scene2);
            		stage2.setTitle("Bakım Yapalım");
            		stage2.setResizable(false);
        			stage2.show();
        		
            		}	catch(Exception e) {
            		e.printStackTrace();
            		}
        			
        		}

    }

    @FXML
    void btnEskiSistemlerClc(ActionEvent event) {
    	if(girisController.girisYapildiMi==0)
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Hata");
        	alert.setHeaderText("Bu Özelliği Kullanabilmek İçin Giriş Yapmalısınız!!!");
        	alert.showAndWait();
    	}
    	else
    	{
    		try {
    	    	Stage stage = (Stage) btnEskiSistemler.getScene().getWindow();
    			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("toplananBilgisayariGetir.fxml"));
    			stage.setTitle("Topladığım Bilgisayarlar");
    			stage.setResizable(false);
    			stage.setScene(new Scene(root));
    			} 	
    			
    		catch(Exception e) {
    			e.printStackTrace();
    			}
    	}

    }

    @FXML
    void btnGeriDonClc(ActionEvent event) {
    	try {
    		Stage stage = (Stage) btnGeriDon.getScene().getWindow();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("kullaniciPanel.fxml"));
			stage.setTitle("Topla Veya Tamir Et");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
    	

    }

    @FXML
    void cmboxAmacClc(ActionEvent event) {

    }

    @FXML
    void cmboxMonitorClc(ActionEvent event) {

    }

    @FXML
    void cmboxSeviyeClc(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	cmboxAmac.setItems(FXCollections.observableArrayList("1- Offis İşlerinde Kullanmak İstiyorum"
    			, "2- Eğitim İçin Kullanmak İstiyorum"
    			, "3- Oyun Amaçlı Kullanmak İstiyorum"
    			, "4- Sunucu Olarak Kullanmak İstiyorum"
    			, "5- Grafik-Render Tasarımları İçin İstiyorum"));
    	cmboxSeviye.setItems(FXCollections.observableArrayList("1- Her Şeyi En Üst Seviye İstiyorum"
    			, "2- Orta Segment Bir Bilgisayar İstiyorum"
    			, "3- Bütçe Dostu Bir Bilgisayar İstiyorum"));
    	cmboxMonitor.setItems(FXCollections.observableArrayList("1- Sistemde Üst Seviye Bir Monitör İstiyorum"
    			, "2- Sistemde Normal Bir Monitör İstiyorum"
    			, "3- Sistemde Ofis Monitorü İstiyorum"
    			, "4- Sistemde Monitör İstemiyorum"));
    	btnGeriDon.setOnMouseEntered(event -> btnGeriDon.setEffect(new DropShadow()));
    	btnGeriDon.setOnMouseExited(event -> btnGeriDon.setEffect(null));
    	btnGeriDon.setOnMouseEntered(event -> btnGeriDon.setEffect(new DropShadow()));
    	btnBilgisayarBul.setOnMouseExited(event -> btnGeriDon.setEffect(null));
    	btnEskiSistemler.setOnMouseEntered(event -> btnEskiSistemler.setEffect(new DropShadow()));
    	btnEskiSistemler.setOnMouseExited(event -> btnEskiSistemler.setEffect(null));

    }

}
