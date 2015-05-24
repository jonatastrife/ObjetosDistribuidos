package br.edu.qi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.qi.model.Contato;

public class ContatoDao extends GenericDao implements IDAO<Contato>{

	private static final String INSERT = "INSERT INTO Contatos VALUES(?, ?, ?, ?, ?, ?)";
	private static final String DELETE = "DELETE FROM Contatos WHERE nome like '?'";
	private static final String FIND_ALL = "SELECT * FROM Contato";
	private static final String UPDATE = 
			" UPDATE Contatos" +
			" SET apelido = ?, email = ?, celular = ?, telephone = ?, celular = ?, dt_nasc = ? " +
			" WHERE nome = '?' ";
	
	
	@Override
	public void save(Contato obj) throws Exception {
		executeSQL(INSERT, obj.getNome(), obj.getApelido(), obj.getTelephone(), obj.getCelular(), obj.getEmail(), obj.getDt_nasc());
	}

	@Override
	public void delete(Contato obj) throws Exception {
		executeSQL(DELETE, obj.getNome());
	}

	@Override
	public Contato find(Contato obj) throws Exception {
		// TODO
		return null;
	}

	@Override
	public ArrayList<Contato> findAll() throws Exception {
		PreparedStatement pstm = null;
		
		ArrayList<Contato> listaContatos = new ArrayList<Contato>();
		
		try {
			pstm = ConnectionManager.getInstance().getConnection().prepareStatement(FIND_ALL);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setNome(rs.getString("nome"));
				contato.setApelido(rs.getString("apelido"));
				contato.setEmail(rs.getString("email"));
				contato.setCelular(rs.getString("celular"));
				contato.setTelephone(rs.getString("telephone"));
				contato.setDt_nasc(rs.getDate("dt_nasc"));
				
				listaContatos.add(contato);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaContatos; 
	}

	@Override
	public void update(Contato obj) throws Exception {
		executeSQL(UPDATE, obj.getApelido(), obj.getTelephone(), obj.getCelular(), obj.getEmail(), obj.getDt_nasc(), obj.getNome());
	}

}
