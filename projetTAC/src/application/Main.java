package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Model;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;

public class Main extends Application {

	private Stage primaryStage;



	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.getIcons().add(new Image("/imgs/icon.PNG"));
		this.primaryStage.setTitle("TousAntiCovid");

		initPageAccueil();
	}


	public void initPageAccueil(){

		try {
			// On charge la page d'accueil depuis le fichier fxml.
			AnchorPane pageAccueil = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/Accueil.fxml"));
			Scene scene = new Scene(pageAccueil);

			// Emp�che l'utilisateur de redimensionner l'application.
			primaryStage.setResizable(false);

			// On affiche la sc�ne.
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Returns the main stage.
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) throws IOException {
		Model.initializeMap();
		launch(args);
	}
}
