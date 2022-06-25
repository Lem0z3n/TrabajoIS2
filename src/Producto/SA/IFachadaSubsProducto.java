package Producto.SA;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Producto.Producto;

public interface IFachadaSubsProducto {
	
	public boolean altaProducto(Producto p) throws SQLException;
	public boolean bajaProducto(int id);
	public Producto getProducto(int id);
	public boolean modProducto(int i, String op, String dato);
	public List<Producto> buscProducto(String dato, String op);
	
	public List<Producto> listProductos();
	
}
