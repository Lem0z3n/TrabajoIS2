package Proveedor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Observer.DAOObserver;
import Producto.ControllerProducto;
import Producto.SA.FachadaSubsProducto;
import Proveedor.SA.FachadaSubsProveedor;

public class PedidoTableModel extends AbstractTableModel implements DAOObserver{

	private String[] colNames_ = {"nombre Proveedor", "ID Prod.", "ID prov.", "ID pedido", "Stock Extra"};
	private List<Pedido> lpeds = new ArrayList<>();
	private FachadaSubsProveedor subsProveedor;
	
	public PedidoTableModel(ControllerProveedor ctrl, FachadaSubsProveedor subsProveedor_) {
		subsProveedor = subsProveedor_;
		ctrl.addObserver(this);
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lpeds.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colNames_.length;
	}
	
	public String getColumnName(int col) {
		return colNames_[col];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String s= "";
		switch (columnIndex) {
		case 0:
			s =  lpeds.get(rowIndex).getNombre();
			break;
		case 1:
			s= String.valueOf(lpeds.get(rowIndex).getIDProducto());
			break;
		case 2:
			s = String.valueOf(lpeds.get(rowIndex).getIDProv());
			break;
		case 3:
			s = String.valueOf(lpeds.get(rowIndex).getIDPed());
			break;
		case 4:
			s = String.valueOf(lpeds.get(rowIndex).getStockExtra());
			break;
		}
		return s;
	}

	@Override
	public void onRegister() {
		// TODO Auto-generated method stub
		lpeds = subsProveedor.listPedidos();
	}

	@Override
	public void onDDL() {
		// TODO Auto-generated method stub
		lpeds = subsProveedor.listPedidos();
		update();
	}

	@Override
	public <T> void onQuery(List<T> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		lpeds = subsProveedor.listPedidos();
		update();
	}
	
	public void update() {
		fireTableDataChanged();;
	}

}
