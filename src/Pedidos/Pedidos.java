package Pedidos;

public class Pedidos {
	private String nombreProv;
	private int idProv, stockExtra, idProducto, idPedido;
	
	public Pedidos(String nombre_, int idProd_, int idProv_, int idPed_, int stock_) {
		this.nombreProv = nombre_;
		this.idProv = idProv_;
		this.stockExtra = stock_;
		this.idProducto = idProd_;
		this.idPedido = idPed_;
	}
}
