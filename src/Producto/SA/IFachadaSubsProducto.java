package Producto.SA;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Producto.Producto;

public interface IFachadaSubsProducto {
	
	public boolean altaProducto(Producto p) throws SQLException;
	public boolean bajaProducto(int id);
	public Producto getProducto(int id);
	public boolean modProducto(Producto p, int op, String dato);
	public boolean buscProducto(String dato, int op);
	
	public List<Producto> listProductos();
	
}
