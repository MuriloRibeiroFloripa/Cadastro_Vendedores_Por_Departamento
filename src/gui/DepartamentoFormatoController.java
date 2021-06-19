package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.entidade.Departamento;

public class DepartamentoFormatoController implements Initializable{
	
	//Dependencia para o departamento
	private Departamento entidade;	
	
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
	
	//implementar o metodo set da entidade Departamento
	// para o controlador vai ter uma instancia do Departamento
	public void setDepartamento(Departamento entidade) {
		this.entidade = entidade;
	}
	
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
	
	//Responsavel em pegar os dados do Departemento e popular
	// as caixas de textos do formulario
	public void atualizaDadosFormulario() {
		//lançar exceção caso a entidade esteja nula.
		if(entidade == null) {
			throw new IllegalStateException("Entidade Vazia!");
		}
		txtId.setText(String.valueOf(entidade.getId()));
		txtNome.setText(entidade.getNome());
	}		
}
