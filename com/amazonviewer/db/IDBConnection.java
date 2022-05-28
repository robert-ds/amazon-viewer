package com.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.amazonviewer.db.DataBase.*;

public interface IDBConnection {
	
	@SuppressWarnings("finally")
	default Connection connectToDB() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL+DB, USER, PASSWORD);
			
			if (connection != null) {
				System.out.println("Se Estableció la Conexión");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			return connection;
		}
		
	}
	
}
