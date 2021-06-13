package modelo.servico;

import java.util.List;

import modelo.dao.DepartamentoDao;
import modelo.dao.FabricaDao;
import modelo.entidade.Departamento;

public class DepartamentoSevicos {

	private DepartamentoDao dao = FabricaDao.criarDepartamentoDao();
	public List<Departamento> buscaTodos(){		
		return dao.buscaTodos();
	}
	public void saveOrUpdate(Departamento obj) {
		if (obj.getId() == null) {
			dao.inserir(obj);
		}
		else {
			dao.atualizar(obj); //busca no banco os dados
		}
	}	
}