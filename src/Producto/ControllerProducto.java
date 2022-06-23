package Producto;

import Observer.DAOObserver;
import Producto.DAO.DAOProducto;

public class ControllerProducto {
	public static DAOProducto dao;
	
	public static void setDAOController(DAOProducto dao_) {
		dao = dao_;
	}
	
	public void addObserver(DAOObserver o) {
		dao.addObserver(o);
	}
	public void removeObserver(DAOObserver o) {
		dao.removeObserver(o);
	}
}
