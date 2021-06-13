package modelo.dao;

import java.util.List;

import modelo.entidade.Departamento;
import modelo.entidade.Vendedor;

// Interface Vendedor DAO
public interface VendedorDao {

	// Operações do Objeto de acesso a dados(DAO) 
	// Para manipular os Atributos dos Vendedores.
	void inserir(Vendedor obj);
	void atualizar(Vendedor obj);
	void apagarPorId(Integer id);
	Vendedor buscaPorId(Integer id);
	//Busca todos, assinatura do metodo.
	List<Vendedor> buscaTodos();
	// Busca todo os departamento, assinatura do metodo.
	List<Vendedor> buscaTodosDepartamentos(Departamento departamento);
}