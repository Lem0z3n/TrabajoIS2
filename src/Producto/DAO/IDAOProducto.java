package Producto.DAO;

import java.sql.SQLException;
import java.util.List;

import Producto.Producto;

public abstract class IDAOProducto {

	public abstract boolean altaProducto(Producto p) throws SQLException;
	public abstract boolean bajaProducto(int id);
	public abstract Producto getProducto(int id);
	public abstract boolean modProducto(Producto p, String op, String dato);
	public abstract List<Producto> buscProducto(String dato, String op);
	public abstract boolean existsProducto(int id);
	
	public abstract List<Producto> listProductos();
}
