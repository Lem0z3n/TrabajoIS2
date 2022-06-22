package Producto.DAO;

import java.sql.SQLException;
import java.util.List;

import Producto.Producto;

public class FachadaDAOProducto implements IFachadaDAOProducto{

	@Override
	public boolean altaProducto(Producto p) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajaProducto(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Producto getProducto(int id) {
		Producto p = null;
		return p;
	}

	@Override
	public boolean modProducto(Producto p, int op, String dato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buscProducto(String dato, int op) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Producto> listProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsProducto(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
