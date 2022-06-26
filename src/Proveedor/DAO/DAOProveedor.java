package Proveedor.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import BBDD.BDManager;
import Observer.DAOObserver;
import Observer.Observable;
import Producto.Categoria;
import Producto.Producto;
import Proveedor.ControllerProveedor;
import Proveedor.Pedido;
import Proveedor.Proveedor;

public class DAOProveedor extends IDAOProveedor implements Observable<DAOObserver>{

	private BDManager bdManager = new BDManager();
	private List<DAOObserver> observers = new ArrayList<>();
	private List<Pedido> lps = new ArrayList<>();
	
	public DAOProveedor() {
		lps = listPedidos();
		ControllerProveedor.setDAOController(this);
	}
	
	@Override
	public boolean nuevoPedido(Pedido p) throws SQLException {
		String query = "INSERT INTO Pedidos (nombreProv, idProv, stockExtra, idProducto, idpedido) VALUES('" + p.getNombre() + "', '"+ p.getIDProv()	
		+"',' " + p.getStockExtra() + "','" +p.getIDProducto() + "','"+ p.getIDPed() +"');";
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
	public boolean cancelarPedido(int idPedido) {
		String query = "DELETE FROM pedidos WHERE id = '" +  idPedido + "';";
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
	public boolean consultarPedido(int idProducto) { //esto se llama idproducto pero es idpedido
		String query = "SELECT * from productos WHERE id = '"  + idProducto + "';";
		Pedido p =  null;
		ResultSet set = bdManager.executeQuery(query);
		try {
			if(set.next()) {
				p = new Pedido( set.getString("nombreprov"), set.getInt("idprov"), set.getInt("stockExtra"), 
								set.getInt("idproducto"), set.getInt("idpedido"));
				lps = new ArrayList<>();
				lps.add(p);

				for(DAOObserver daoo: observers) {
					daoo.onQuery(lps);
				}
			}
			return true;

		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public List<Pedido> buscarlistaPedidos(String dato, String op) {
		String query = "SELECT * FROM productos WHERE " + op + " = '" + dato + "';";
		List<Pedido> lps = new ArrayList<>();
		lps = setToArray(bdManager.executeQuery(query));
		for(DAOObserver daoo: observers) {
			daoo.onQuery(lps);
		}
		return Collections.unmodifiableList(lps);
	}

	@Override
	public boolean existeProveedor(int idProveedor) {
		boolean exists = false;
		lps = listPedidos();
		int i = 0;
		while(!exists && i < lps.size()) {
			if(idProveedor == lps.get(i).getIDPed()) exists = true;
			i++;
		}
		return exists;
	}

	@Override
	public List<Pedido> listPedidos() {
		List<Pedido> lps = new ArrayList<>();
		String query = "SELECT * FROM Productos;";
		lps = setToArray(bdManager.executeQuery(query));	
		return Collections.unmodifiableList(lps);
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

	private List<Pedido> setToArray(ResultSet set){
		List<Pedido> lps = new ArrayList<>();
		try {
			while(set.next()) {	
				Pedido p = new Pedido( set.getString("nombreprov"), set.getInt("idprov"), set.getInt("stockExtra"), 
						set.getInt("idproducto"), set.getInt("idpedido"));
				lps.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lps;
	}


}
