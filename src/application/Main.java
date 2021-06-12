package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * Main view
 * Checklist:
 *  Create FXML "MainView" (package "gui")
 *  Load FXML in Main
 *  Update Main.java
 *  
 */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Instanciando novo objeto do tipo loader tipo FXMLLoader, 
			// Para podr manipular a tela antes de carregar
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			Parent parent = loader.load(); // Chama o objeto load(), passando o caminho da View
			// Carrega o objeto tipo Scene, "Sena principal" instanciando ela ja passando como argumento
			// o objeto principal AnchorPane vazio
			Scene mainScene = new Scene(parent); 
			// No palco da sena que vai chegar pela instancia Start(Stage Application)
			// Setando ele como sena Principal
			primaryStage.setScene(mainScene);
			// Definindo um Titulo Para o Palco
			primaryStage.setTitle("Cadastro de Vendedores por Departamento");
			// Ai mostra o palco
			primaryStage.show();
			// Trata possíveis exceções.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}