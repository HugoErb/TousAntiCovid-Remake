package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MaSanteController {

	@FXML
	private Button pageAide;
	@FXML
	private Button pageAccueil;
	@FXML
	private Button pageCarte;
	@FXML
	private Button pageLieux;
	@FXML
	private Button pageAttestation;

	/**
	 * Avec l'appel de cette m�thode on va pouvoir naviguer entre les sc�nes.
	 */
	@FXML
	private void changeScreenButtonPushed (ActionEvent event) throws IOException {
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
		else{ if(event.getSource() == pageAide){
			stage = (Stage) pageAide.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/view/Aide.fxml"));
		}else{ if(event.getSource() == pageLieux){
			stage = (Stage) pageLieux.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/view/Lieux.fxml"));
		}
		else{ if(event.getSource() == pageAttestation){
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

	/**
	 * M�thode appel�e quand l'user clique sur le bouton "Enregistrer l'�tat de sant�".
	 */
	@FXML
	private void boutonEnregistrer(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Tous Anti Covid");
		alert.setHeaderText(null);
		alert.setContentText("Enregistrement pris en compte.");
		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("../view/Main.css").toExternalForm());
		dialogPane.getStyleClass().add("myDialog");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("/imgs/icon.PNG"));
		alert.showAndWait();
	}
}
