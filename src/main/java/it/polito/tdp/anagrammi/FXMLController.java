package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polit.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model=new Model();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtCorretto;

    @FXML
    private TextArea txtErrati;

    @FXML
    private TextField txtParola;

    @FXML
    void handleCalcola(ActionEvent event) {
    	
    	String parola=txtParola.getText();
    	txtCorretto.clear();
    	txtErrati.clear();
    	
    	if(parola.length()<2) {
    		txtCorretto.appendText("Parola troppo corta");
    		return;
    	}
    	
    	if(parola.length()>8) {
    		txtCorretto.appendText("Parola troppo lunga");
    		return;
    	}
    	
    	Set <String> anagrammi=this.model.calcolaAnagrammi(parola);
    	
    	for(String a: anagrammi) {
    		if(this.model.isCorrect(a)==true) {
    			txtCorretto.appendText(a+"\n");
    		}
    		else
    			txtErrati.appendText(a+"\n");
    	}
    }

    @FXML
    void handleReset(ActionEvent event) {
    	txtParola.clear();
    	txtCorretto.clear();
    	txtErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtCorretto != null : "fx:id=\"txtCorretto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
