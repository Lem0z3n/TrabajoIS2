package Proveedor.DAO;

import java.sql.SQLException;
import java.util.List;

import Producto.Producto;
import Proveedor.Pedido;
import Proveedor.Proveedor;
;

public abstract class IDAOProveedor {
	public abstract boolean nuevoPedido(Pedido p) throws SQLException;
	public abstract boolean cancelarPedido(int idPedido);
	public abstract boolean consultarPedido(int idProducto);
	
	public abstract List<Pedido> listPedidos();
	public abstract List<Pedido> buscarlistaPedidos(String dato, String op);
	public abstract boolean existeProveedor(int idProveedor);
}
