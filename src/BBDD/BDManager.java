package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;

public class BDManager {
	private static final String CONTROLADOR = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USUARIO = "postgres";
	private static final String CLAVE = "admin";
	Connection connection;
	Statement statement;
	ResultSet set;

	public Connection createConnection() {
		Connection connection = null;
		
		try {
			Class.forName(CONTROLADOR);
			connection = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexion OK");

		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Error en la conexi�n");
			e.printStackTrace();
		}
		
		return connection;
	}
	
	 public ResultSet executeQuery(String query) {
	        connection = createConnection();
	        statement = null;
	        set = null;
	        try {
	            statement = connection.createStatement();
	            set = statement.executeQuery(query);
	            return set;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	        return null;
	    }

	    public boolean executeUpdate(String update) throws SQLException {
	        Connection connection = createConnection();
	        Statement statement = null;
	        boolean exito = false;
	        try {
	            statement = connection.createStatement();
	            exito = statement.executeUpdate(update) > 0;
	        } catch (SQLException e) {
	            throw e;
	        } finally {
	            try {
	                statement.close();
	            } catch (Exception e) {
	            }
	            try {
	                connection.close();
	            } catch (Exception e) {
	            }
	        }
	        
	        return exito;
	    }
	    
	    public void close() {
	    	try {
	            set.close();
	        } catch (Exception e) {
	        }
	        try {
	            statement.close();
	        } catch (Exception e) {
	        }
	        try {
	            connection.close();
	        } catch (Exception e) {
	        }
	    }
}
