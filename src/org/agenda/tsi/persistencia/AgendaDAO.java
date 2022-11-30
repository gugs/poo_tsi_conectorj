package org.agenda.tsi.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.agenda.tsi.model.Agenda;

public class AgendaDAO implements IPersistencia{

	private IConnectionDB databaseMySQL;
	private static AgendaDAO instance;
	
	private AgendaDAO() {
		databaseMySQL = new DatabaseMySQL();
	}
	
	public static AgendaDAO getInstance() {
		if(instance == null)
			return new AgendaDAO();
		else
			return instance;
	}
	
	@Override
	public void adicionarItem(Agenda a) {
	
		try {
			PreparedStatement pstm = databaseMySQL.
					getConnection().prepareStatement("INSERT INTO AGENDA VALUES (?, ?, ?, ?);");
			pstm.setInt(1, a.getId());
			pstm.setString(2, a.getNome());
			pstm.setString(3, a.getEmail());
			pstm.setString(4, a.getTelefone());
			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Agenda localizarItem(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removerItem(Agenda a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarItem(Agenda a) {
		// TODO Auto-generated method stub
		
	}
}
