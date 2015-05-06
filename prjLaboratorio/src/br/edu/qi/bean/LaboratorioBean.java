package br.edu.qi.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.LaboratorioDao;
import br.edu.qi.dto.Laboratorio;

@Stateless
@Local
public class LaboratorioBean {

	public void save(Laboratorio obj) throws Exception
	{
		if (obj.getQtdeMaquinas() <= 0 ||
			obj.getQtdeMaquinas() > 25 	)
			throw new Exception("Qtde de máquinas não pode ser menor/igual ou superior a 25");
		
		LaboratorioDao dao = new LaboratorioDao();
		
		dao.save(obj);
	}
}
