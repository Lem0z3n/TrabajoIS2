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
		if(dao.existsProducto(id)) {
			Producto p = dao.getProducto(id);
			return p;
		}else {
			System.out.println("No se encontro id en BD");
			return null;
		}
	}

	@Override
	public boolean modProducto(int i, String op, String dato) {		
		return dao.modProducto(i, op, dato);
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
