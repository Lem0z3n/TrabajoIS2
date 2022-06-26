package Proveedor.SA;

import java.sql.SQLException;
import java.util.List;

import Proveedor.Pedido;
import Proveedor.Proveedor;
import Proveedor.DAO.FachadaDAOProveedor;
import Proveedor.DAO.IFachadaDAOProveedor;

public class SASubsProveedor implements ISASubsProveedor{
	
	private IFachadaDAOProveedor fachadaDAO;
	
	public SASubsProveedor(){
		fachadaDAO = new FachadaDAOProveedor();
	}
	
	@Override
	public boolean nuevoPedido(Pedido p) throws SQLException {
		// TODO Auto-generated method stub
		return fachadaDAO.nuevoPedido(p);
	}

	@Override
	public boolean cancelarPedido(int idPedido) {
		// TODO Auto-generated method stub
		return fachadaDAO.cancelarPedido(idPedido);
	}

	@Override
	public boolean consultarPedido(int idProducto) {
		// TODO Auto-generated method stub
		return fachadaDAO.consultarPedido(idProducto);
	}

	@Override
	public List<Pedido> buscarlistaPedidos(String dato, String op) {
		// TODO Auto-generated method stub
		return fachadaDAO.buscarlistaPedidos(dato, op);
	}

	@Override
	public List<Pedido> listPedidos() {
		// TODO Auto-generated method stub
		return fachadaDAO.listPedidos();
	}

	
}
