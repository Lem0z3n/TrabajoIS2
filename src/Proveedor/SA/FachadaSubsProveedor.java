package Proveedor.SA;

import java.sql.SQLException;
import java.util.List;

import Proveedor.Pedido;
import Proveedor.Proveedor;

public class FachadaSubsProveedor implements IFachadaSubsProveedor{
	private ISASubsProveedor SAProveedor;

	
	public FachadaSubsProveedor(){
		SAProveedor=new SASubsProveedor();
	}
	public boolean nuevoPedido(Pedido p) throws SQLException {
		// TODO Auto-generated method stub
		return SAProveedor.nuevoPedido(p);
	}

	@Override
	public boolean cancelarPedido(int idPedido) {
		// TODO Auto-generated method stub
		return SAProveedor.cancelarPedido(idPedido);
	}

	@Override
	public boolean consultarPedido(int idPedido) {
		// TODO Auto-generated method stub
		return SAProveedor.cancelarPedido(idPedido);
	}

	@Override
	public List<Pedido> buscarlistaPedidos(String dato, String op) {
		// TODO Auto-generated method stub
		return SAProveedor.buscarlistaPedidos(dato, op);
	}
	public List<Pedido> listPedidos() {
		// TODO Auto-generated method stub
		return SAProveedor.listPedidos();
	}

	

}
