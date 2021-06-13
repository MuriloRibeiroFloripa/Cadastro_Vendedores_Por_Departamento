package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import aplicacao.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.entidade.Departamento;
import modelo.servico.DepartamentoSevicos;




public class DepartamentoListaController implements Initializable{
	
	/*
	 * Declarando uma Dependência do serviço class DepartamentoSevicos
	 * Carregando os departamentos para mostrar na TableView
	 * Sem instanciar para não gerar o acoplamento dependência forte.
	 * Criando um método set ao invés de intanciar o objeto diretamente aqui
	 * private DepartamentoSevicos servicos;
	*/
	private DepartamentoSevicos servicos;	
	
	// criando as referencias para os departamentoList
	@FXML
	private TableView<Departamento> tableViewDepartamento;
	
	@FXML
	private TableColumn<Departamento, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Departamento, String> tableColumnNome;
	
	@FXML
	private Button btCadastrarNovoDepartamento;
	
	// Pegando o service do método setDepartamentoServicos, e carregar
	// Os departamentos e mostrar dentro do objeto TableView<Deparamento>	
	private ObservableList<Departamento> obsList; // Carregando os departamentos na obsList
	
	
	//Metodo do tratamento do Evento do Botão CadastrarNovoDepartamento
	@FXML
	public void onBtCadastrarNovoDepartamentoAction() {
		System.out.println("onBtCadastrarNovoDepartamento");
	}
	
	// criando acoplamento dependência fraca através do metodo set.
	// Invertendo controle de princípio solid de inversão de controle
	public void setDepartamentoServicos(DepartamentoSevicos servicos) {
		this.servicos = servicos;		
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
	
	// método responsavel de acessar o serviço carregar os departamentos e joga-los na obsList
	// método que sera chamado manualmente Lembrando no MainViewController.java usamos loadView, 
	// Alterando para testes loadView2
	public void updateTableView() {
		if(servicos == null) {
			throw new IllegalStateException("Sevico Sem dados! verifique se o service foi instânciado corretamente");
		}
		List<Departamento> list = servicos.buscaTodos();//da classe DepartamentoServicos.java
		obsList = FXCollections.observableArrayList(list); // Carregando a lista dentro do obsList
		tableViewDepartamento.setItems(obsList);
	}
}