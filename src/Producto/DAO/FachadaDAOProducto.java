package Producto.DAO;

import java.sql.SQLException;
import java.util.List;

import Producto.Producto;

public class FachadaDAOProducto implements IFachadaDAOProducto{
	
	DAOProducto dao = new DAOProducto();

	@Override
	public boolean altaProducto(Producto p) throws SQLException {
		return dao.altaProducto(p);
	}

	@Override
	public boolean bajaProducto(int id) {
		return dao.bajaProducto(id);
	}

	@Override
	public Producto getProducto(int id) {
		Producto p = dao.getProducto(id);
		return p;
	}

	@Override
	public boolean modProducto(Producto p, String op, String dato) {		
		return dao.modProducto(p, op, dato);
	}

	@Override
	public List<Producto> buscProducto(String dato, String op) {		
		return dao.buscProducto(dato, op);
	}

	@Override
	public List<Producto> listProductos() {
		return dao.listProductos();
	}

	@Override
	public boolean existsProducto(int id) {
		return dao.existsProducto(id);
	}

}
