package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

/*
 * Main view Design
 * Checklist:
 * Design MainView.fxml
 * Customize menu intems
 * Update Main.java
 *  *  
 */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			// Instanciando novo objeto do tipo loader tipo FXMLLoader, 
			// Para podr manipular a tela antes de carregar
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));			
			// Chama o objeto load(), passando o caminho da View
			// Carrega o objeto tipo ScrollPane, "Sena principal" instanciando ela ja passando como argumento
			// o objeto principal AnchorPane vazio.	
			ScrollPane scrollPane = loader.load(); 
			
			// 2 macetes para deixar o scrollPane ajustado na altura e largura da janela
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			
			// vou carregar a sena passando scrollPane como argumento
			// No palco da sena que vai chegar pela instancia Start(Stage Application)				
			Scene mainScene = new Scene(scrollPane); 
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