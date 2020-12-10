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

public class AttestationController{

	@FXML
	private Button pageAide;
	@FXML
	private Button pageAccueil;
	@FXML
	private Button pageCarte;
	@FXML
	private Button pageMaSante;
	@FXML
	private Button pageLieux;
	@FXML
	private Button annulation;

	/**
	 * Avec l'appel de cette m�thode on va pouvoir naviguer entre les sc�nes.
	 */
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
		else{ if(event.getSource() == pageAide){
			stage = (Stage) pageAide.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/view/Aide.fxml"));
		}
		else{ if(event.getSource() == pageMaSante){
			stage = (Stage) pageMaSante.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/view/MaSante.fxml"));
		}
		else{ if(event.getSource() == pageLieux){
			stage = (Stage) pageLieux.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/view/Lieux.fxml"));
		}
		else{ if(event.getSource() == annulation){
			stage = (Stage) annulation.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/view/Attestation.fxml"));
		}
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
	 * M�thode appel�e quand l'user veut g�n�rer une attestation.
	 */
	@FXML
	private void boutonGeneration(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Tous Anti Covid");
		alert.setHeaderText(null);
		alert.setContentText("Le telechargement de votre attestation sur votre smartphone va debuter.");
		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("../view/Main.css").toExternalForm());
		dialogPane.getStyleClass().add("myDialog");
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("/imgs/icon.PNG"));
		alert.showAndWait();
	}
}