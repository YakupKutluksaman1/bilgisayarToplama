package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.time.Duration;
import java.util.ResourceBundle;

import com.IsteMySQL.Util.VeritabaniUtil;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;



public class girisController {
	

	public girisController()
	{
		baglanti=VeritabaniUtil.Baglan();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdminGiris;

    @FXML
    private Button btnGiris;

    @FXML
    private Button btnMisafirGiris;

    @FXML
    private Hyperlink linkKayitOl;

    @FXML
    private Hyperlink linkSifreUnuttum;

    @FXML
    private TextField txtPosta;

    @FXML
    private PasswordField txtSifre;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    public static int girisYapildiMi=0;
	public static String hesapBilgi="";
	public String getEposta()
    {
    	return hesapBilgi;
    }
    

    @FXML
    void btnAdminGirisClc(ActionEvent event) {
    	//ADMİN GİRİŞ PANELİNE AKTARIR
    	try {
    		Stage stage = (Stage) btnAdminGiris.getScene().getWindow();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("adminGiris.fxml"));
			stage.setTitle("Admin Girişi");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnGirisClc(ActionEvent event) {
//KULLANICI HESAP BİLGİLERİ İLE GİRİŞ YAPMAK İSTEDİ
    	
    	if(txtPosta.getText().equals("") && txtSifre.getText().equals(""))
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Başarısız");
        	alert.setHeaderText("Lütfen Kutucukları Doldurunuz");

        	alert.show();
    	}
    	else
    	{
    		sql = "SELECT * FROM kullanici_giris_bilgileri WHERE email=? AND sifre=?";
            try {
                sorguIfadesi = baglanti.prepareStatement(sql);
                sorguIfadesi.setString(1, txtPosta.getText().trim());
                sorguIfadesi.setString(2, txtSifre.getText().trim());

                ResultSet getirilen = sorguIfadesi.executeQuery();
                
                if (getirilen.next()) {
                	// KULLANICI ŞİFRESİ DOĞRU
                	Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Başarılı");
                	alert.setHeaderText("Kullanıcı E-posta ve Parola Doğru");
                	alert.setContentText("Giriş Yapılıyor");

                	alert.show();
                	PauseTransition wait = new PauseTransition(Duration.seconds(1));
                	PauseTransition wait2 = new PauseTransition(Duration.seconds(1));
                	wait.setOnFinished((e) -> alert.close());
                	wait.play();
                	
                    try {
                    	
                        Stage stage = (Stage) btnGiris.getScene().getWindow();
                        AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("kullaniciPanel.fxml"));
                        stage.setTitle("Topla Veya Tamir Et");
                        stage.setResizable(false);
                        wait2.setOnFinished((e) -> stage.setScene(new Scene(root)));
                        wait2.play();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    girisYapildiMi = 1;
                    hesapBilgi = txtPosta.getText();
                    
                } else {
                	// KULLANICI GİRİŞ BİLGİLERİ DOĞRU DEĞİL
                	Alert alert = new Alert(AlertType.INFORMATION);
                	alert.setTitle("Hata");
                	alert.setHeaderText("İşlem başarısız oldu");
                	alert.setContentText("E-posta veya Parola hatalı!!!");
                	alert.showAndWait();

                }
            } catch(Exception e) {
                System.out.println(e.getMessage().toString());
            }
    	}
    }

    @FXML
    void btnMisafirGirisClc(ActionEvent event) {
    	//MİSAFİR OLARAK GİRİŞ YAPTIRIR
    	try {
    		Stage stage = (Stage) btnMisafirGiris.getScene().getWindow();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("kullaniciPanel.fxml"));
			stage.setTitle("Topla Veya Tamir Et");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void linkKayitOlClc(ActionEvent event) {
    	//KULLANICI YENİ HESAP OLUŞTURMAK İSTEDİ
    	try {
    		Stage stage = (Stage) linkKayitOl.getScene().getWindow();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("kayitOlPanel.fxml"));
			stage.setTitle("Kayıt Paneli");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void linkSifreUnuttumClc(ActionEvent event) {
    	//KULLANICI ŞİFRESİNİ ÖĞRENMEK İSTEDİ
    	try {
    		Stage stage = (Stage) linkSifreUnuttum.getScene().getWindow();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("sifremiUnuttum.fxml"));
			stage.setTitle("Şifre Hatırlatıcı");
			stage.setResizable(false);
			stage.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {

    }

}
