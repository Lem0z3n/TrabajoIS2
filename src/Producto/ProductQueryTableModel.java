package Producto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Observer.DAOObserver;
import Producto.SA.FachadaSubsProducto;

public class ProductQueryTableModel extends AbstractTableModel implements DAOObserver {
	
	String[] colNames_ = {"nombre", "id", "categoria", "sexo", "stock", "color"};
	List<Producto> lps = new ArrayList<>();
	
	public ProductQueryTableModel(ControllerProducto ctrl) {
		
		ctrl.addObserver(this);
	}
	
	@Override
	public int getColumnCount() {
		return colNames_.length;
	}
	
	public String getColumnName(int col) {
		return colNames_[col];
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
			s =  lps.get(rowIndex).getNombre();
			break;
		case 1:
			s= String.valueOf(lps.get(rowIndex).getId());
			break;
		case 2:
			s = lps.get(rowIndex).getCategoria().toString();
			break;
		case 3:
			s = lps.get(rowIndex).getSexo();
			break;
		case 4:
			s = String.valueOf(lps.get(rowIndex).getStock());
			break;
		case 5:
			s = lps.get(rowIndex).getColor();
			break;
		}
		return s;
	}

	@Override
	public void onRegister() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDDL() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void onQuery(List<T> list) {
		lps = (List<Producto>) list;
		fireTableDataChanged();;
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		
	}

}
