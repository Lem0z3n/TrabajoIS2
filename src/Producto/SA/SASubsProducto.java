package Producto.SA;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Producto.Producto;
import Producto.DAO.FachadaDAOProducto;
import Producto.DAO.IFachadaDAOProducto;

public class SASubsProducto implements ISASubsProducto{
	
	private IFachadaDAOProducto fachadaDAO;
	private boolean exito = false;
	
	public SASubsProducto() {
		fachadaDAO = new FachadaDAOProducto();
	}
	@Override
	public boolean altaProducto(Producto p) throws SQLException {
		exito = fachadaDAO.existsProducto(p.getId());
		if(exito) {
			exito = fachadaDAO.altaProducto(p);
		}
		return exito;
	}

	@Override
	public boolean bajaProducto(int id) {
		exito = fachadaDAO.existsProducto(id);
		if(exito) {
			exito = fachadaDAO.bajaProducto(id);
		}
		return exito;
	}

	@Override
	public Producto getProducto(int id) {
		Producto p = null;
		exito = fachadaDAO.existsProducto(id);
		if(exito) {
			p = fachadaDAO.getProducto(id);
		}
		return p;
	}

	@Override
	public boolean modProducto(Producto p, int op, String dato) {
		exito = fachadaDAO.existsProducto(p.getId());
		if(exito) {
			exito = fachadaDAO.modProducto(p, op, dato);
		}
		return exito;
	}

	@Override
	public boolean buscProducto(String dato, int op) {
		return fachadaDAO.buscProducto(dato, op);
	}

	@Override
	public List<Producto> listProductos() {
		
		return fachadaDAO.listProductos();
	}

}
