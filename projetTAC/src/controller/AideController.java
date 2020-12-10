package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AideController {
	/**
	 * Avec l'appel de cette m�thode on va pouvoir naviguer entre les sc�nes.
	 */
	@FXML
	private Button pageAccueil;
	@FXML
	private Button pageCarte;
	@FXML
	private Button pageMaSante;
	@FXML
	private Button pageLieux;
	@FXML
	private Button pageAttestation;


	@FXML
	private void changeScreenButton (ActionEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;

		if(event.getSource() == pageAccueil){
			stage = (Stage) pageAccueil.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/view/Accueil.fxml"));
		}
		else{ if(event.getSource() == pageCarte){
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
		else{
			if(event.getSource() == pageAttestation){
				stage = (Stage) pageAttestation.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/view/Attestation.fxml")); 
			}
		}
		}	
		}

		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}