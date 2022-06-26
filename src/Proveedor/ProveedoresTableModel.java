package Proveedor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Observer.DAOObserver;
import Proveedor.SA.FachadaSubsProveedor;

public class ProveedoresTableModel extends AbstractTableModel implements DAOObserver{
	String[] colNames_ = {"nombre", "id", "categoria", "sexo", "stock", "color"};
	List<Pedido> lps = new ArrayList<>();
	
	
	FachadaSubsProveedor subsProveedor = new FachadaSubsProveedor();
	
	public ProveedoresTableModel(ControllerProveedor ctrl) {
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
			break;
		case 1:
			s= s + lps.get(rowIndex).getIDProv();
			break;
		case 2:
			s = s + lps.get(rowIndex).getStockExtra();
			break;
		case 3:
			s = s + lps.get(rowIndex).getIDProducto();
			break;
		case 4:
			s = s + lps.get(rowIndex).getIDPed();
			break;
		}
		return s;
	}

	@Override
	public void onRegister() {
		lps = subsProveedor.listPedidos();
	}

	/*@Override
	public void onDDL() {
		lps = subsProveedor.listProductos();
		update();
	}*/

	@Override
	public <T> void onQuery(List<T> list) {	
	}

	@Override
	public void onUpdate() {
		//lps = subsProveedor.listProductos();
		update();
	}
	
	public void update() {
		fireTableDataChanged();;
	}

	@Override
	public void onDDL() {
		// TODO Auto-generated method stub
		
	}
}
