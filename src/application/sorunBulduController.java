package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class sorunBulduController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtAnaProblem;

    @FXML
    private TextArea txtNasilBasladi;
    
    @FXML
    private TextArea txtCozum;
   
    public void veriAl (String anaProblem, String nasilBasladi)
    {
    	this.txtAnaProblem.setText(anaProblem);
    	
    	this.txtNasilBasladi.setText(nasilBasladi);	
    }

    @FXML
    void initialize() {
        // Initialization logic if needed
    }
}
