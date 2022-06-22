package Producto.SA;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Producto.Producto;

public class FachadaSubsProducto implements IFachadaSubsProducto{
	
	private ISASubsProducto SAProducto;
	
	public FachadaSubsProducto() {
		SAProducto = new SASubsProducto();
	}
	
	
	@Override
	public boolean altaProducto(Producto p) throws SQLException {
		// TODO Auto-generated method stub
		return SAProducto.altaProducto(p);
	}

	@Override
	public boolean bajaProducto(int id) {
		// TODO Auto-generated method stub
		return SAProducto.bajaProducto(id);
	}

	@Override
	public Producto getProducto(int id) {
		// TODO Auto-generated method stub
		return SAProducto.getProducto(id);
	}

	@Override
	public boolean modProducto(Producto p, int op, String dato) {
		// TODO Auto-generated method stub
		return SAProducto.modProducto(p, op, dato);
	}

	@Override
	public boolean buscProducto(String dato, int op) {
		// TODO Auto-generated method stub
		return SAProducto.buscProducto(dato, op);
	}


	@Override
	public List<Producto> listProductos() {
		// TODO Auto-generated method stub
		return SAProducto.listProductos();
	}

}
