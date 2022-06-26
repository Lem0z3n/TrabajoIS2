package Proveedor;

public class Proveedor {
	String Nombre;
	String Email;
	int Telefono;
	int IdProveedor;
	
	Proveedor (String Nombre,	String Email,	int Telefono,	int IdProveedor){
		this.Email=Email;
		this.IdProveedor=IdProveedor;
		this.Telefono=Telefono;
		this.Nombre=Nombre;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public int getIdProveedor() {
		return IdProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		IdProveedor = idProveedor;
	}
	
}
