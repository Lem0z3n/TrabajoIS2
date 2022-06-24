package Producto.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import BBDD.BDManager;
import Observer.DAOObserver;
import Observer.Observable;
import Producto.Categoria;
import Producto.ControllerProducto;
import Producto.Producto;


public class DAOProducto extends IDAOProducto implements Observable<DAOObserver>{
	
	BDManager bdManager = new BDManager();
	List<DAOObserver> observers = new ArrayList<>();
	List<Producto> lps = new ArrayList<>();
	
	public DAOProducto() {
		lps = listProductos();
		ControllerProducto.setDAOController(this);
	}
	
	@Override
	public boolean altaProducto(Producto p) throws SQLException {
		String query = "INSERT INTO Productos(id, nombre, sexo, stock, categoria, color) VALUES('" + p.getNombre()	
		+"' " + p.getSexo() + "' " + p.getCategoria() + "' " + p.getColor() +"');";
		try {
			bdManager.executeUpdate(query);
			for(DAOObserver daoo: observers) {
				daoo.onDDL();
			}
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean bajaProducto(int id) {
		String query = "DROP FROM productos WHERE id = '" + "';";
		try {
			bdManager.executeUpdate(query);
			for(DAOObserver daoo: observers) {
				daoo.onDDL();
			}
			return true;
		} catch (SQLException e) {
			return false;
		}	
	}

	@Override
	public Producto getProducto(int id) { //esto igual es mas correcto que sea un boolean
		String query = "SELECET * from productos WHERE id = '"  + id + "';";
		ResultSet set = bdManager.executeQuery(query);
		try {
			Producto p = new Producto(set.getString("nombre"), id, Categoria.valueOf(set.getString("categoria")),
									  set.getString("sexo"), set.getInt("stock"), set.getString("color"));
			lps.add(p);
			for(DAOObserver daoo: observers) {
				daoo.onQuery(lps);
			}
			return p;
		} catch (SQLException e) {
			return null;
		}
		
	}

	@Override
	public boolean modProducto(Producto p, String op, String dato) {
		String query = "UPDATE producto SET " + op + " = '" + dato + "' WHERE id = '" + p.getId() + "';";
		try {
			bdManager.executeUpdate(query);
			for(DAOObserver daoo: observers) {
				daoo.onUpdate();
			}
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}

	@Override
	public List<Producto> buscProducto(String dato, String op) {
		String query = "SELECT * FROM productos WHERE " + op + " = '" + dato + "';";
		List<Producto> lps = new ArrayList<>();
		lps = setToArray(bdManager.executeQuery(query));
		for(DAOObserver daoo: observers) {
			daoo.onQuery(lps);
		}
		return Collections.unmodifiableList(lps);
	}

	@Override
	public boolean existsProducto(int id) {
		boolean exists = false;
		String query = "SELECT * FROM productos WHERE id = '" + id +"';";
		if(bdManager.executeQuery(query) != null) exists = true;
		return exists;
	}

	@Override
	public List<Producto> listProductos() {
		List<Producto> lps = new ArrayList<>();
		String query = "SELECT * FROM productos;";
		lps = setToArray(bdManager.executeQuery(query));	
		return Collections.unmodifiableList(lps);
	}

	private List<Producto> setToArray(ResultSet set){
		List<Producto> lps = new ArrayList<>();
		try {
			while(set.next()) {	
				Producto p = new Producto(set.getString("nombre"), set.getInt("id"), Categoria.valueOf(set.getString("categoria")), 
						set.getString("sexo"), set.getInt("stock"), set.getString("color"));
				lps.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lps;
	}

	@Override
	public void addObserver(DAOObserver o) {
		observers.add(o);
		for(DAOObserver daoo: observers) {
			daoo.onRegister();
		}
	}

	@Override
	public void removeObserver(DAOObserver o) {
		// TODO Auto-generated method stub
		
	}

}
