package br.edu.qi.dao;

import java.util.ArrayList;

import br.edu.qi.dto.Laboratorio;

public class LaboratorioDao extends GenericDao
		implements IDao<Laboratorio>{

	private static final String INSERT=
			"insert into laboratorio values(?,?,?)";
	
	public int save(Laboratorio obj) throws Exception {
		return executeNoQuery(INSERT, obj.getCodTurma(),
							   obj.getCodDisciplina(),
							   obj.getQtdeMaquinas());
		
	}

	
	public int delete(Laboratorio obj) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Laboratorio find(Laboratorio obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<Laboratorio> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
