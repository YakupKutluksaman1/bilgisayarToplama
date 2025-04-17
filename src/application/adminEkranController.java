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

public class adminEkranController {
	
	public static int girisYapildiMi=0;
	
	public adminEkranController()
	{
		baglanti=VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdminCikisAnakart;

    @FXML
    private Button btnAdminCikisEkrankarti;

    @FXML
    private Button btnAdminCikisIslemci;

    @FXML
    private Button btnAdminCikisKasa;

    @FXML
    private Button btnAdminCikisMonitor;

    @FXML
    private Button btnAdminCikisRam;

    @FXML
    private Button btnAnakartKayitEkle;

    @FXML
    private Button btnAnakartKayitGetir;

    @FXML
    private Button btnAnakartKayitSil;

    @FXML
    private Button btnIslemciKayitEkle;

    @FXML
    private Button btnIslemciKayitGetir;

    @FXML
    private Button btnIslemciKayitSil;

    @FXML
    private Button btnRamKayitEkle;

    @FXML
    private Button btnRamKayitGetir;

    @FXML
    private Button btnRamKayitSil;

    @FXML
    private Button ekrankartiKayitEkle;

    @FXML
    private Button ekrankartiKayitGetir;

    @FXML
    private Button ekrankartiKayitSil;

    @FXML
    private Button kasaKayitEkle;

    @FXML
    private Button kasaKayitGetir;

    @FXML
    private Button kasaKayitSil;

    @FXML
    private Button monitorKayitEkle;

    @FXML
    private Button monitorKayitGetir;

    @FXML
    private Button monitorKayitSil;

    @FXML
    private TableColumn<Kayitlar_bilesenler,Integer> tableAnakartId;

    @FXML
    private TableColumn<Kayitlar_bilesenler,String> tableAnakartIsim;

    @FXML
    private TableColumn<Kayitlar_bilesenler,Integer> tableEkrankartiId;

    @FXML
    private TableColumn<Kayitlar_bilesenler,String> tableEkrankartiIsim;

    @FXML
    private TableColumn<Kayitlar_bilesenler,Integer> tableIslemciId;

    @FXML
    private TableColumn<Kayitlar_bilesenler,String> tableIslemciIsim;

    @FXML
    private TableColumn<Kayitlar_bilesenler,Integer> tableKasaId;

    @FXML
    private TableColumn<Kayitlar_bilesenler,String> tableKasaIsim;

    @FXML
    private TableColumn<Kayitlar_bilesenler,Integer> tableMonitorId;

    @FXML
    private TableColumn<Kayitlar_bilesenler,String> tableMonitorIsim;

    @FXML
    private TableColumn<Kayitlar_bilesenler,Integer> tableRamId;

    @FXML
    private TableColumn<Kayitlar_bilesenler,String> tableRamIsim;

    @FXML
    private TableView<Kayitlar_bilesenler> table_anakart;

    @FXML
    private TableView<Kayitlar_bilesenler> table_ekranKarti;

    @FXML
    private TableView<Kayitlar_bilesenler> table_islemci;

    @FXML
    private TableView<Kayitlar_bilesenler> table_kasa;

    @FXML
    private TableView<Kayitlar_bilesenler> table_monitor;

    @FXML
    private TableView<Kayitlar_bilesenler> table_ram;

    @FXML
    private TextField txtAnakartId;

    @FXML
    private TextField txtAnakartIsim;

    @FXML
    private TextField txtEkranKartiId;

    @FXML
    private TextField txtEkranKartiIsim;

    @FXML
    private TextField txtKasaId;

    @FXML
    private TextField txtKasaIsim;

    @FXML
    private TextField txtMonitorId;

    @FXML
    private TextField txtMonitorIsim;

    @FXML
    private TextField txtRamId;

    @FXML
    private TextField txtRamIsim;

    @FXML
    private TextField txtİslemciId;

    @FXML
    private TextField txtİslemciIsim;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    ObservableList<Kayitlar_bilesenler> veriler;

    @FXML
    void btnAdminCikisAnakartClc(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Uyarı");
        alert.setHeaderText("Emin misiniz?");
        alert.setContentText("Çıkış Yapmak Üzeresiniz!");

        ButtonType sonuc = alert.showAndWait().orElse(ButtonType.CANCEL);

       
        if (sonuc == ButtonType.OK) {

        	try {
        		Stage stage = (Stage) btnAdminCikisAnakart.getScene().getWindow();
    			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("adminGiris.fxml"));
    			stage.setTitle("Bilgisayarınızı Özelleştirelim");
    			stage.setScene(new Scene(root));
    		} catch(Exception e) {
    			e.printStackTrace();
    		}           
        } 
    }

    @FXML
    void btnAdminCikisEkrankartiClc(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Uyarı");
        alert.setHeaderText("Emin misiniz?");
        alert.setContentText("Çıkış Yapmak Üzeresiniz!");
        ButtonType sonuc = alert.showAndWait().orElse(ButtonType.CANCEL);       
        if (sonuc == ButtonType.OK) {

        	try {
        		Stage stage = (Stage) btnAdminCikisEkrankarti.getScene().getWindow();
    			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("adminGiris.fxml"));
    			stage.setTitle("Bilgisayarınızı Özelleştirelim");
    			stage.setScene(new Scene(root));
    		} catch(Exception e) {
    			e.printStackTrace();
    		}            
        } 
    }

    @FXML
    void btnAdminCikisIslemciClc(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Uyarı");
        alert.setHeaderText("Emin misiniz?");
        alert.setContentText("Çıkış Yapmak Üzeresiniz!");
        ButtonType sonuc = alert.showAndWait().orElse(ButtonType.CANCEL);

        if (sonuc == ButtonType.OK) {
        	try {
        		Stage stage = (Stage) btnAdminCikisIslemci.getScene().getWindow();
    			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("adminGiris.fxml"));
    			stage.setTitle("Bilgisayarınızı Özelleştirelim");
    			stage.setScene(new Scene(root));
    		} catch(Exception e) {
    			e.printStackTrace();
    		}    
        } 
    }

    @FXML
    void btnAdminCikisKasaClc(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Uyarı");
        alert.setHeaderText("Emin misiniz?");
        alert.setContentText("Çıkış Yapmak Üzeresiniz!");
        ButtonType sonuc = alert.showAndWait().orElse(ButtonType.CANCEL);      
        if (sonuc == ButtonType.OK) {

        	try {
        		Stage stage = (Stage) btnAdminCikisKasa.getScene().getWindow();
    			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("adminGiris.fxml"));
    			stage.setTitle("Bilgisayarınızı Özelleştirelim");
    			stage.setScene(new Scene(root));
    		} catch(Exception e) {
    			e.printStackTrace();
    		}            
        } 
    }

    @FXML
    void btnAdminCikisMonitorClc(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Uyarı");
        alert.setHeaderText("Emin misiniz?");
        alert.setContentText("Çıkış Yapmak Üzeresiniz!");

        ButtonType sonuc = alert.showAndWait().orElse(ButtonType.CANCEL);      
        if (sonuc == ButtonType.OK) {

        	try {
        		Stage stage = (Stage) btnAdminCikisMonitor.getScene().getWindow();
    			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("adminGiris.fxml"));
    			stage.setTitle("Bilgisayarınızı Özelleştirelim");
    			stage.setScene(new Scene(root));
    		} catch(Exception e) {
    			e.printStackTrace();
    		}            
        }
    }

    @FXML
    void btnAdminCikisRamClc(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Uyarı");
        alert.setHeaderText("Emin misiniz?");
        alert.setContentText("Çıkış Yapmak Üzeresiniz!");

        ButtonType sonuc = alert.showAndWait().orElse(ButtonType.CANCEL);       
        if (sonuc == ButtonType.OK) {

        	try {
        		Stage stage = (Stage) btnAdminCikisRam.getScene().getWindow();
    			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("adminGiris.fxml"));
    			stage.setTitle("Bilgisayarınızı Özelleştirelim");
    			stage.setScene(new Scene(root));
    		} catch(Exception e) {
    			e.printStackTrace();
    		}            
        } 
    }

    @FXML
    void btnAnakartKayitEkleClc(ActionEvent event) {
    	kayitEkle("anakart_table", "anakart_id", "anakart_isim", txtAnakartIsim, txtAnakartId);

    }

    @FXML
    void btnAnakartKayitGetirClc(ActionEvent event) {
    	tabloYenile("anakart_table","anakart_id","anakart_isim",table_anakart,tableAnakartId,tableAnakartIsim);
    }

    @FXML
    void btnAnakartKayitSilClc(ActionEvent event) {
    	kayitSil("anakart_table", "anakart_id", table_anakart);
    }

    @FXML
    void btnIslemciKayitEkleClc(ActionEvent event) {
    	kayitEkle("islemci_ram", "islemci_id", "islemci_isim", txtİslemciIsim, txtİslemciId);
    }

    @FXML
    void btnIslemciKayitGetirClc(ActionEvent event) {
        tabloYenile("islemci_ram", "islemci_id", "islemci_isim", table_islemci, tableIslemciId, tableIslemciIsim);
    }

    @FXML
    void btnIslemciKayitSilClc(ActionEvent event) {
        kayitSil("islemci_ram", "islemci_id", table_islemci);
    }

    @FXML
    void btnRamKayitEkleClc(ActionEvent event) {
        kayitEkle("ram_table", "ram_id", "ram_isim", txtRamIsim, txtRamId);
    }

    @FXML
    void btnRamKayitGetirClc(ActionEvent event) {
        tabloYenile("ram_table", "ram_id", "ram_isim", table_ram, tableRamId, tableRamIsim);
    }

    @FXML
    void btnRamKayitSilclc(ActionEvent event) {
        kayitSil("ram_table", "ram_id", table_ram);
    }

    @FXML
    void ekrankartiKayitEkleClc(ActionEvent event) {
        kayitEkle("ekrankarti_table", "ekrankarti_id", "ekrankarti_isim", txtEkranKartiIsim, txtEkranKartiId);

    }

    @FXML
    void ekrankartiKayitGetirClc(ActionEvent event) {
        tabloYenile("ekrankarti_table", "ekrankarti_id", "ekrankarti_isim", table_ekranKarti, tableEkrankartiId, tableEkrankartiIsim);
    }

    @FXML
    void ekrankartiKayitSilClc(ActionEvent event) {
        kayitSil("ekrankarti_table", "ekrankarti_id", table_ekranKarti);
    }

    @FXML
    void kasaKayitEkleClc(ActionEvent event) {
        kayitEkle("kasa_table", "kasa_id", "kasa_isim", txtKasaIsim, txtKasaId);
    }

    @FXML
    void kasaKayitGetirClc(ActionEvent event) {
        tabloYenile("kasa_table", "kasa_id", "kasa_isim", table_kasa, tableKasaId, tableKasaIsim);
    }

    @FXML
    void kasaKayitSilClc(ActionEvent event) {
        kayitSil("kasa_table", "kasa_id", table_kasa);
    }

    @FXML
    void monitorKayitEkleClc(ActionEvent event) {
        kayitEkle("monitor_table", "monitor_id", "monitor_isim", txtMonitorIsim, txtMonitorId);
    }

    @FXML
    void monitorKayitGetirClc(ActionEvent event) {
        tabloYenile("monitor_table", "monitor_id", "monitor_isim", table_monitor, tableMonitorId, tableMonitorIsim);
    }

    @FXML
    void monitorKayitSilClc(ActionEvent event) {
    	 kayitSil("monitor_table", "monitor_id", table_monitor);
    }    
    @FXML
    void initialize() {
    	tabloYenile("anakart_table","anakart_id","anakart_isim",table_anakart,tableAnakartId,tableAnakartIsim);
        tabloYenile("islemci_ram", "islemci_id", "islemci_isim", table_islemci, tableIslemciId, tableIslemciIsim);
        tabloYenile("ram_table", "ram_id", "ram_isim", table_ram, tableRamId, tableRamIsim);
        tabloYenile("ekrankarti_table", "ekrankarti_id", "ekrankarti_isim", table_ekranKarti, tableEkrankartiId, tableEkrankartiIsim);
        tabloYenile("kasa_table", "kasa_id", "kasa_isim", table_kasa, tableKasaId, tableKasaIsim);
        tabloYenile("monitor_table", "monitor_id", "monitor_isim", table_monitor, tableMonitorId, tableMonitorIsim);
    }
    public void tabloYenile(String tablo_isim, String alinanSutunID,String alinanSutunIsim, TableView<Kayitlar_bilesenler> genel_tablo, TableColumn<Kayitlar_bilesenler, Integer> idSutunIsim, TableColumn<Kayitlar_bilesenler,String> urunSutunisim)
    {
    	sql = "SELECT * FROM " + tablo_isim ;
        try {
            sorguIfadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguIfadesi.executeQuery();            
            veriler = FXCollections.observableArrayList();           
            veriler.clear(); 

            while (getirilen.next()) {
            	int Id = getirilen.getInt(alinanSutunID);
                String Isim = getirilen.getString(alinanSutunIsim);             
                veriler.add(new Kayitlar_bilesenler(Id, Isim));
            }
            genel_tablo.setItems(veriler);

        } catch (Exception e) {
            e.printStackTrace();
        }
        idSutunIsim.setCellValueFactory(new PropertyValueFactory<>("Id"));
        urunSutunisim.setCellValueFactory(new PropertyValueFactory<>("Isim"));

    }
    
    public void kayitEkle(String tabloismi, String idSutunIsim, String ekleSutunIsim, TextField isimDeger, TextField idDeger) {
        Alert alert2 = new Alert(AlertType.INFORMATION);
        if (!idDeger.getText().equals("") && !isimDeger.getText().equals("")) {
            if (idDeger.getText().matches("\\d+")) {
                // SQL sorgusunu doğru şekilde oluşturma
                sql = "INSERT INTO " + tabloismi + " (" + idSutunIsim + ", " + ekleSutunIsim + ") VALUES (?, ?)";
                try {
                    sorguIfadesi = baglanti.prepareStatement(sql);
                    sorguIfadesi.setInt(1, Integer.parseInt(idDeger.getText().trim()));
                    sorguIfadesi.setString(2, isimDeger.getText().trim());
                    sorguIfadesi.executeUpdate();

                    alert2.setTitle("Başarılı");
                    alert2.setHeaderText(null);
                    alert2.setContentText("Kayıt başarıyla eklendi.");
                    alert2.showAndWait();
                } catch (Exception e) {
                    alert2.setTitle("Hata");
                    alert2.setHeaderText("Kayıt Eklenirken Bir Hata Meydana Geldi!");
                    alert2.setContentText(e.getMessage());
                    alert2.showAndWait();
                    e.printStackTrace();
                }
            } else {
                alert2.setTitle("Hata");
                alert2.setHeaderText("ID Kutusuna Sadece Sayı Girebilirsiniz");
                alert2.showAndWait();
            }
        } else {
            alert2.setTitle("Hata");
            alert2.setHeaderText("Kutuları Doldurmanız Gerekmektedir");
            alert2.showAndWait();
        }
    }
    public void kayitSil(String tabloismi, String idSutunIsim, TableView<Kayitlar_bilesenler> table_sistem) {
        int id = 0;
        
        Kayitlar_bilesenler seciliKayit = table_sistem.getSelectionModel().getSelectedItem(); 
        if (seciliKayit != null) { 
            id = seciliKayit.getId();
        }
        if(id == 0) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Başarılı");
            alert.setHeaderText("Silme İşlemini Gerçekleştirmek İçin Bir Satır Seçmelisiniz");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Uyarı");
            alert.setHeaderText("Emin misiniz?");
            alert.setContentText("Bu işlem geri alınamaz.");

            ButtonType sonuc = alert.showAndWait().orElse(ButtonType.CANCEL);

            if (sonuc == ButtonType.OK) {
                sql = "DELETE FROM " + tabloismi + " WHERE " + idSutunIsim + " = ?";
                try {
                    sorguIfadesi = baglanti.prepareStatement(sql);
                    sorguIfadesi.setInt(1, id);
                    sorguIfadesi.executeUpdate();

                    Alert alert2 = new Alert(AlertType.INFORMATION);
                    alert2.setTitle("Başarılı");
                    alert2.setHeaderText("Silme İşlemi Gerçekleşti");
                    alert2.showAndWait();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            } 
        }
    }
  
}
