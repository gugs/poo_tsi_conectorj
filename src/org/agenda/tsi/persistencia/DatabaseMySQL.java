package org.agenda.tsi.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMySQL implements IConnectionDB{

	final String HOST_NAME = "localhost";
	final String PORT_NUMBER = "3306";
	final String USER_NAME = "root";
	final String PASSWORD = "root";
	final String DATABASE = "database";
	
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			Connection conn = DriverManager.
					getConnection("jdbc:mysql://"+HOST_NAME+":"
			+PORT_NUMBER+"/"+DATABASE, USER_NAME, PASSWORD);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
