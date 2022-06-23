package Producto.DAO;

import java.sql.SQLException;
import java.util.List;

import Producto.Producto;

public interface IDAOProducto {

	public boolean altaProducto(Producto p) throws SQLException;
	public boolean bajaProducto(int id);
	public Producto getProducto(int id);
	public boolean modProducto(Producto p, int op, String dato);
	public boolean buscProducto(String dato, String op);
	public boolean existsProducto(int id);
	
	public List<Producto> listProductos();
}
