package gui.util;



import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

/*
 * Design do formulário do departamento (caixa de diálogo) 
 * pacote gui.util, classe Utils com o metodo Palco Atual.
 * Com comportamento Moldal
 * 
 * Checklist:
 *  Create gui.util.Utils.java with currentStage method
 *  Criar DepartamentoFormato.fxml (AnchorPane)
 * o GridPane 3x3 (anchors: 20 top, 20 left)
 * o Id text box: not editable
 * o Label error: red
 * o HBox (spacing: 5)
 *  //Dentro da classe DepartamentoListaController, criar createDialogForm method
 *  Call createDialogForm on "new" button action
 *  
*/

// acessar Stage onde o controler que recebe o evento(ActionEvent) está.
public class Utils {
	
	// Função com o metodo palco atual para quando executar uma ação em um botao pegando
	// o Stage e apartir dele abrir uma janela encima.
	public static Stage currentStage(ActionEvent event) {
		
		// pegar Stage apartir de um evento genérico getSouces mas colocado na 
		// forma de Node, e apartir dele chamar a Scene, pegando a janela da super classe do Stage
		return (Stage) ((Node)event.getSource()).getScene().getWindow();//
		
	}
}