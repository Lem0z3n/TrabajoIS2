/**
 * 
 */
package Producto.DAO;

import java.sql.SQLException;
import java.util.List;

import Producto.Producto;

/**
 * @author guill
 *
 */
public interface IFachadaDAOProducto {

	public boolean altaProducto(Producto p) throws SQLException;
	public boolean bajaProducto(int id);
	public Producto getProducto(int id);
	public boolean modProducto(Producto p, String op, String dato);
	public List<Producto> buscProducto(String dato, String op);
	public boolean existsProducto(int id);
	
	public List<Producto> listProductos();
}
