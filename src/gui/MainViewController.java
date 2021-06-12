package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

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
		System.out.println("onMenuItemDepartamentosAction");
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
		System.out.println("onMenuItemSobreAction");
	}
	
	// Metodo da Interface Initializable
	@Override
	public void initialize(URL uri, ResourceBundle rb) {		
	}
}
