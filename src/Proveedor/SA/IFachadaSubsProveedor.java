package Proveedor.SA;

import java.sql.SQLException;
import java.util.List;

import Proveedor.Pedido;
import Proveedor.Proveedor;

public interface IFachadaSubsProveedor {
	public boolean nuevoPedido(Pedido p) throws SQLException;
	public boolean cancelarPedido(int idPedido);
	public boolean consultarPedido(int idProducto);
	public List<Pedido> buscarlistaPedidos(String dato, String op);
	public boolean recibirPedido(int idPedido);
}
