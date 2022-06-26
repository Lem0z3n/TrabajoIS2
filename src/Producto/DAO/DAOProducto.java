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
	
	private BDManager bdManager = new BDManager();
	private List<DAOObserver> observers = new ArrayList<>();
	private List<Producto> lps = new ArrayList<>();
	
	public DAOProducto() {
		lps = listProductos();
		ControllerProducto.setDAOController(this);
	}
	
	@Override
	public boolean altaProducto(Producto p) throws SQLException {
		String query = "INSERT INTO Productos(id, nombre, sexo, stock, categoria, color) VALUES('" + p.getId() + "', '"+ p.getNombre()	
		+"',' " + p.getSexo() + "','" +p.getStock() + "','"+ p.getCategoria() + "',' " + p.getColor() +"');";
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
		String query = "DELETE FROM productos WHERE id = '" +  id + "';";
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
		String query = "SELECT * from productos WHERE id = '"  + id + "';";
		Producto p =  null;
		ResultSet set = bdManager.executeQuery(query);
		try {
			if(set.next()) {
				p = new Producto(set.getString("nombre"), id, Categoria.valueOf(set.getString("categoria")),
						set.getString("sexo"), set.getInt("stock"), set.getString("color"));
				lps = new ArrayList<>();
				lps.add(p);

				for(DAOObserver daoo: observers) {
					daoo.onQuery(lps);
				}
			}
			return p;

		} catch (SQLException e) {
			return null;
		}
		
	}

	@Override
	public boolean modProducto(int i, String op, String dato) {
		String query = "UPDATE productos SET " + op + " = '" + dato + "' WHERE id = '" + i + "';";
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
		lps = listProductos();
		int i = 0;
		while(!exists && i < lps.size()) {
			if(id == lps.get(i).getId()) exists = true;
			i++;
		}
		return exists;
	}

	@Override
	public List<Producto> listProductos() {
		List<Producto> lps = new ArrayList<>();
		String query = "SELECT * FROM Productos;";
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
