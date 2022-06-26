package Proveedor.DAO;

import java.sql.SQLException;
import java.util.List;

import Proveedor.Pedido;
import Proveedor.Proveedor;

public class FachadaDAOProveedor implements IFachadaDAOProveedor{

	DAOProveedor dao = new DAOProveedor();
	
	@Override
	public boolean nuevoPedido(Pedido p) throws SQLException {
		// TODO Auto-generated method stub
		return dao.nuevoPedido(p);
	}

	@Override
	public boolean cancelarPedido(int idPedido) {
		// TODO Auto-generated method stub
		return dao.cancelarPedido(idPedido);
	}

	@Override
	public boolean consultarPedido(int idProducto) {
		// TODO Auto-generated method stub
		return dao.consultarPedido(idProducto);
	}

	@Override
	public List<Pedido> buscarlistaPedidos(String dato, String op) {
		// TODO Auto-generated method stub
		return dao.buscarlistaPedidos(dato, op);
	}

	@Override
	public boolean existeProveedor(int idProveedor) {
		// TODO Auto-generated method stub
		return dao.existeProveedor(idProveedor);
	}

	@Override
	public List<Pedido> listPedidos() {
		// TODO Auto-generated method stub
		return dao.listPedidos();
	}

	
}
