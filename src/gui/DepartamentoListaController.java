package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.entidade.Departamento;

public class DepartamentoListaController implements Initializable{
	
	// criando as referencias para os departamentoList
	@FXML
	private TableView<Departamento> tableViewDepartamento;
	
	@FXML
	private TableColumn<Departamento, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Departamento, String> tableColumnNome;
	
	@FXML
	private Button btCadastrarNovoDepartamento;
	
	//Metodo do tratamento do Evento do Botão CadastrarNovoDepartamento
	@FXML
	public void onBtCadastrarNovoDepartamentoAction() {
		System.out.println("onBtCadastrarNovoDepartamento");
	}

	//macete para as colunas funcionar initializeNodes()
	// padrão do javaFX para iniciar o comportamento das colunas
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		// Para tableView e tableViewDepartamento ajustar o tamanho da janela no Stage
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartamento.prefHeightProperty().bind(stage.heightProperty());		
	}
}