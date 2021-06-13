package modelo.servico;

import java.util.ArrayList;
import java.util.List;

import modelo.entidade.Departamento;

public class DepartamentoSevicos {

	public List<Departamento> buscaTodos(){
		//retornar os dados de mentira MOCK
		List<Departamento> list = new ArrayList<>();
		list.add(new Departamento(1, "Informática"));
		list.add(new Departamento(2, "RH"));
		list.add(new Departamento(3, "Gerencia"));
		list.add(new Departamento(4, "Livros"));
		list.add(new Departamento(5, "Eletronicos"));
		list.add(new Departamento(6, "Textil"));
		list.add(new Departamento(7, "Papelaria"));
		return list;		 
	}
}