package Producto;

public class Producto {
	private String nombre, color;
	private int id, sexo, stock;
	private Categoria categoria;
	
	public Producto(String nombre_, int id_, Categoria categoria_, int sexo_, int stock_, String color_) {
		this.nombre = nombre_;
		this.id = id_;
		this.sexo = sexo_;
		this.stock = stock_;
		this.categoria = categoria_;
		this.color = color_;
	}
	
	
	public String getNombre() {
		return this.nombre;
	}
	public int getId() {
		return this.id;
	}
	public int getSexo() {
		return this.sexo; //aqui podemos hacer que devuelva directamente hombre o mujer o unisex 
							//si sois unos meapilas
	}
	public int getStock() {
		return this.stock;
	}
	public Categoria getCategoria() {
		return this.categoria;
	}
	public String getColor() {
		return this.color;
	}
	
	public void setNombre(String n) {
		this.nombre = n;
	}
	public void setSexo(int n) {
		this.sexo = n;
	}
	public void setStock(int n) {
		this.stock = n;
	}
	public void setCategoria (Categoria n) {
		this.categoria = n;
	}
	public void setColor(String n) {
		this.color = n; //igual aqui habria que comprobar que no puede poner una locura.
	}
}
