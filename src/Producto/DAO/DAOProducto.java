package Producto.DAO;

import java.sql.SQLException;
import java.util.List;

import BBDD.BDManager;
import Producto.Producto;

public class DAOProducto implements IDAOProducto{
	
	BDManager bdManager = new BDManager();
	
	@Override
	public boolean altaProducto(Producto p) throws SQLException {
		String query = "INSERT INTO Productos(id, nombre, sexo, stock, categoria, color) VALUES('" + p.getNombre()	
		+"' " + p.getSexo() + "' " + p.getCategoria() + "' " + p.getColor() +"');";
		try {
			return bdManager.executeUpdate(query);
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean bajaProducto(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Producto getProducto(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modProducto(Producto p, int op, String dato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buscProducto(String dato, String op) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsProducto(int id) {
		
		return false;
	}

	@Override
	public List<Producto> listProductos() {
		// TODO Auto-generated method stub
		return null;
	}

}
