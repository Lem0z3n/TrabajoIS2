package Producto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Observer.DAOObserver;
import Producto.SA.FachadaSubsProducto;

public class ProductoTableModel extends AbstractTableModel implements DAOObserver {
	
	String[] colNames_ = {"nombre", "id", "categoria", "sexo", "stock", "color"};
	List<Producto> lps = new ArrayList<>();
	
	
	FachadaSubsProducto subsProducto = new FachadaSubsProducto();
	
	public ProductoTableModel(ControllerProducto ctrl) {
		ctrl.addObserver(this);
	}

	@Override
	public int getColumnCount() {
		return colNames_.length;
	}

	@Override
	public int getRowCount() {
		return lps.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String s= "";
		switch (columnIndex) {
		case 0:
			s = s + lps.get(rowIndex).getNombre();
		case 1:
			s= s + lps.get(rowIndex).getId();
		case 2:
			s = s + lps.get(rowIndex).getCategoria();
		case 3:
			s = s + lps.get(rowIndex).getSexo();
		case 4:
			s = s + lps.get(rowIndex).getStock();
		case 5:
			s = s + lps.get(rowIndex).getColor();
		}
		return s;
	}

	@Override
	public void onRegister() {
		lps = subsProducto.listProductos();
	}

	@Override
	public void onDDL() {
		lps = subsProducto.listProductos();
		update();
	}

	@Override
	public <T> void onQuery(List<T> list) {	
	}

	@Override
	public void onUpdate() {
		lps = subsProducto.listProductos();
		update();
	}
	
	public void update() {
		fireTableDataChanged();;
	}
	
}
