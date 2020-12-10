package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Model;

public class AccueilController implements Initializable{

	@FXML 
	private Label nbDeces;
	@FXML 
	private Label casConf;
	@FXML 
	private Label nbHosp;
	@FXML 
	private Label nbRea;
	@FXML 
	private Label nbGueris;
	@FXML
	private Button pageAide;
	@FXML
	private Button pageCarte;
	@FXML
	private Button pageMaSante;
	@FXML
	private Button pageLieux;
	@FXML
	private Button pageAttestation;
	@FXML
	private Button BtnActivate;

	/**
	 * M�thode appel�e a l'initialisation de la page, permet de mettre a jour les chiffres du Covid.
	 */
	@FXML
	private void initializeLabelTexts() throws IOException {
		nbDeces.setText(Model.getData("nbDeces"));
		casConf.setText(Model.getData("nbCasConfirmes"));
		nbHosp.setText(Model.getData("nbHospitalisations"));
		nbRea.setText(Model.getData("nbEnReanimation"));
		nbGueris.setText(Model.getData("nbGuerisons"));
		if (Model.getActivation() == true){
			BtnActivate.setText("Désactiver");
		} else {
			BtnActivate.setText("Activer l'application");
			Model.setActivationFalse();
		}
	}

	/**
	 * M�thode appel�e quand l'user appuie sur le bouton activer. 
	 */
	@FXML
	private void boutonActivation(ActionEvent event){
		if (Model.getActivation() == false){
			BtnActivate.setText("Désactiver");
			Model.setActivationTrue();
		} else {
			BtnActivate.setText("Activer l'application");
			Model.setActivationFalse();
		}
	}

	/**
	 * Avec l'appel de cette m�thode on va pouvoir naviguer entre les sc�nes.
	 */
	@FXML
	private void changeScreenButton (ActionEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;

		if(event.getSource() == pageCarte){
			stage = (Stage) pageCarte.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/view/Carte.fxml"));
		}
		else{ if(event.getSource() == pageMaSante){
			stage = (Stage) pageMaSante.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/view/MaSante.fxml"));
		}
		else{ if(event.getSource() == pageLieux){
			stage = (Stage) pageLieux.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/view/Lieux.fxml"));
		}
		else{ if(event.getSource() == pageAttestation){
			stage = (Stage) pageAttestation.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/view/Attestation.fxml")); 
		}
		else{ if(event.getSource() == pageAide){ 
			stage = (Stage) pageAide.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/view/Aide.fxml"));
		}
		}
		}
		}
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			initializeLabelTexts();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}	      
