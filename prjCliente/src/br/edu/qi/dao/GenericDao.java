package br.edu.qi.dao;

import java.sql.PreparedStatement;

public abstract class GenericDao {

	protected int executeSQL(String sql, Object... parameters) throws Exception {
		PreparedStatement pstm = null;
		try {
			pstm = ConnectionManager.getInstance().getConnection().prepareStatement(sql);
			for (int i = 0; i < parameters.length; i++) {
				pstm.setObject(i+1, parameters[i]);
			}
			return pstm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		finally {
			if (pstm != null) {
				pstm.close();
			}
			ConnectionManager.getInstance().close();
		}
	}
	
}
