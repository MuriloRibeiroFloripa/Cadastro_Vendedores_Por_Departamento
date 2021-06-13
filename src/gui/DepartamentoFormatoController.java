package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/* Checklist:
 *  criar DepartamentoFormatoController.java
 *  Detro view, associar os controller, ids, events
*/

public class DepartamentoFormatoController implements Initializable{
	
	@FXML
	private TextField txtId;
	

	@FXML
	private TextField txtNome;
	

	@FXML
	private Label labelErroNome;
	

	@FXML
	private Button btSalvar;
	

	@FXML
	private Button btCancelar;
	
	// metodos tratar os eventos dos bottones
	@FXML
	public void onBtSaveAction() {
		System.out.println("OnBtSaveAction");		
	}
	
	@FXML
	public void onBtCancelarAction() {
		System.out.println("OnBtCancelarAction");		
	}	
		

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
				
	}
	
	// criando uma limitações paras os campos
	private void initializeNodes() {
		
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtNome, 30);
	}
}
