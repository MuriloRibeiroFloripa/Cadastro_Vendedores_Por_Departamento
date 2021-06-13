package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

// controle que inica o Initializable
public class MainViewController implements Initializable{
	
	// Itens de controle de tela para corresponder com os itens com
	// Menu da tela
	// Atributos dos menu
	@FXML
	private MenuItem menuItemVendedores;
	
	@FXML
	private MenuItem menuItemDepartamentos;
	
	@FXML
	private MenuItem menuItemManual;
	
	// Declaração dos metodos para tratar as eventos, ações dos itens do menu da tela	
	@FXML
	public void onMenuItemVendedoresAction() {
		System.out.println("onMenuItemVendedoresAction");
	}

	// metodo da interface Initializable
	@FXML
	public void onMenuItemDepartamentosAction() {
		loadView("/gui/DepartamentoLista.fxml");
	}
	
	@FXML
	public void onMenuItemManualAction() {
		System.out.println("onMenuItemManualAction");
	}
	
	@FXML
	public void onMenuItemOqueAdeNovoAction() {
		System.out.println("onMenuItemOqueAdeNovoAction");
	}
	
	@FXML
	public void onMenuItemAtualizaSistemaAction() {
		System.out.println("onMenuItemAtualizaSistemaAction");
	}
	
	@FXML
	public void onMenuItemSobreAction() {
		//System.out.println("onMenuItemSobreAction");
		loadView("/gui/Sobre.fxml");		
	}
	
	// Metodo da Interface Initializable
	@Override
	public void initialize(URL uri, ResourceBundle rb) {		
	}
	
	private synchronized void loadView(String absoluteName) { // synchronized garante para ter interupção inesperada
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			//manipulando a cena principal incluindo nela alem do mainMenu os filhos da janela que eu estiver abrindo
			//Mostrar a View dentro da janela principal pegando a referência do método
			// Main.java Scene
			// insere dentro ScrollPane os filhos da tela Abaut preservando o Menu box e excluindo os filhos MainView
			
			Scene mainScene = Main.getMainScene();
			VBox mainVbox = (VBox)((ScrollPane)mainScene.getRoot()).getContent();
			
			// inserir no lugar os filhos da tela About, preservando o MenuBar.
			Node mainMenu = mainVbox.getChildren().get(0);//recebe o primeiro filho da VBox da janela principal
			mainVbox.getChildren().clear(); //limpa todos os filhos do MainVBox
			mainVbox.getChildren().add(mainMenu); //adciona no mainVBox mainMenu, 
			mainVbox.getChildren().addAll(newVBox.getChildren()); //agora adcionar mainVbox os filhos do newVbox			
			
		}
		catch (IOException e) {
			Alerts.showAlert("Io Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
			}
	}
}
