package Proveedor;
import Observer.DAOObserver;
import Proveedor.DAO.DAOProveedor;
public class ControllerProveedor {
	
	public static DAOProveedor dao;
	
	public static void setDAOController(DAOProveedor dao_) {
		dao = dao_;
	}
	
	public void addObserver(DAOObserver o) {
		dao.addObserver(o);
	}
	public void removeObserver(DAOObserver o) {
		dao.removeObserver(o);
	}
}
