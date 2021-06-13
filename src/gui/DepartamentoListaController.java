package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import aplicacao.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.entidade.Departamento;
import modelo.servico.DepartamentoSevicos;

public class DepartamentoListaController implements Initializable{
	
	/*
	 * Declarando uma Depend�ncia do servi�o class DepartamentoSevicos
	 * Carregando os departamentos para mostrar na TableView
	 * Sem instanciar para n�o gerar o acoplamento depend�ncia forte.
	 * Criando um m�todo set ao inv�s de intanciar o objeto diretamente aqui
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
	
	// Pegando o service do m�todo setDepartamentoServicos, e carregar
	// Os departamentos e mostrar dentro do objeto TableView<Deparamento>	
	private ObservableList<Departamento> obsList; // Carregando os departamentos na obsList
	
	
	//Metodo do tratamento do Evento do Bot�o CadastrarNovoDepartamento
	@FXML
	public void onBtCadastrarNovoDepartamentoAction(ActionEvent event) {
		
		// Chamando createDialogForm e acessando a fun��o criada na pacote gui.util 
		// Classe Utils, fun��o currentStage
		Stage parentStage = Utils.currentStage(event); //pegando referencia para Stage atual
		// Passo a referencia para ele criar a janela de formulario
		createDialogForm("/gui/DepartamentoFormato.fxml", parentStage); 
	}
	
	// criando acoplamento depend�ncia fraca atrav�s do metodo set.
	// Invertendo controle de princ�pio solid de invers�o de controle
	public void setDepartamentoServicos(DepartamentoSevicos servicos) {
		this.servicos = servicos;		
	}

	//macete para as colunas funcionar initializeNodes()
	// padr�o do javaFX para iniciar o comportamento das colunas
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
	
	// m�todo responsavel de acessar o servi�o carregar os departamentos e joga-los na obsList
	// m�todo que sera chamado manualmente Lembrando no MainViewController.java usamos loadView, 
	// Alterando para testes loadView2
	public void updateTableView() {
		if(servicos == null) {
			throw new IllegalStateException("Sevico Sem dados! verifique se o service foi inst�nciado corretamente");
		}
		List<Departamento> list = servicos.buscaTodos();//da classe DepartamentoServicos.java
		obsList = FXCollections.observableArrayList(list); // Carregando a lista dentro do obsList
		tableViewDepartamento.setItems(obsList);
	}
	
	// Dentro da classe DepartmentoListaController, criar createDialogForm method, 
	// Informando quem criou a janela de dialogo
	private void createDialogForm(String absoluteName, Stage parentStage) {
		// instanciar a janela de dialogo com tratamento de exception
		try {
			// L�gica para abrir a janela de formulario copiando da Classe MainViewControler da acaoDeInicializa��o 
			// Onde informa o nome da view que sera carregada 
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			// carregando a view
			Pane pane = loader.load();
			
			// Sempre que criar uma janela molda na frente de uma janela existente
			// temos que instanciar o novo Palco (Sera um palco na frente de outro).
			Stage dialogStage = new Stage(); //elemento raiz painel 
			// Configurando o Palco
			dialogStage.setTitle("Digite os Dados do Departamento");//nome da nova janela
			//Quem sera a sena principal aqui do meu palco, criando nova sena.
			dialogStage.setScene(new Scene (pane));// elemento raiz painelzinho pane
			// a janela pode ou nao ser redimencionada 
			dialogStage.setResizable(false);
			// quem � o palco pai desta janela
			dialogStage.initOwner(parentStage);
			// informando o comportamento molda da janela
			dialogStage.initModality(Modality.WINDOW_MODAL);
			// Mostrar e esperar o evento
			dialogStage.showAndWait();			
		}
		// caso ocorra uma exce��o envia a mensagem
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro Loading view", e.getMessage(), AlertType.ERROR);
		}
	}	
}