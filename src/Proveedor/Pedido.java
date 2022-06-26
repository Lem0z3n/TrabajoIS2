package Proveedor;

public class Pedido {
	private String nombreProv;
	private int idProv, stockExtra, idProducto, idPedido;
	
	public Pedido(String nombre_, int idProd_, int idProv_, int idPed_, int stock_) {
		this.nombreProv = nombre_;
		this.idProv = idProv_;
		this.stockExtra = stock_;
		this.idProducto = idProd_;
		this.idPedido = idPed_;
	}
	
	public int getIDProv() {
		return idProv;
	}
	public String getNombre() {
		return nombreProv;
	}
	public int getStockExtra() {
		return stockExtra;
	}
	public int getIDProducto() {
		return idProducto;
	}
	public int getIDPed() {
		return idPedido;
	}
	
	public void setIDProv(int id) {
		idProv = id;
	}
	public void setNombre(String s) {
		nombreProv = s;
	}
	public void setStock(int i) {
		stockExtra = i;
	}
	public void setIDProducto(int i) {
		idProducto = i;
	}
	public void setIDPed(int i) {
		idPedido = i;
	}
}
