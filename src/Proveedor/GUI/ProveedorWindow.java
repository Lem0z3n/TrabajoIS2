package Proveedor.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

import Producto.ControllerProducto;
import Producto.Producto;
import Producto.ProductoTableModel;
import Producto.GUI.AddDialog;
import Producto.GUI.ModDialogClass;
import Producto.GUI.RemoveDialogClass;
import Producto.GUI.SelecProdDialogClass;
import Producto.GUI.SelectProdListDialogClass;
import Producto.SA.FachadaSubsProducto;
import Proveedor.ControllerProveedor;
import Proveedor.Pedido;
import Proveedor.PedidoTableModel;
import Proveedor.SA.FachadaSubsProveedor;

public class ProveedorWindow extends JFrame{
	
	private JButton addPedido, removePedido, updatePedido, selecPedido,
	selecListPedido, exitButton;
	private FachadaSubsProveedor subsProveedor;
	private ControllerProveedor ctrl;
	private PedidoTableModel pdtm;
	
	public ProveedorWindow(ControllerProveedor ctrl_, FachadaSubsProveedor subsProveedor_) {
		super("Producto");
		ctrl = ctrl_;
		subsProveedor = subsProveedor_;
		pdtm = new PedidoTableModel(ctrl, subsProveedor);
		initGui();
	}

	private void initGui() {
		// TODO Auto-generated method stub
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setPreferredSize(new Dimension(500, 700));
		//algo de texto si quereis.
		
		JPanel p = new JPanel();
		p.add(new JScrollPane(new JTable(pdtm)));
		p.setPreferredSize(new Dimension(500, 500));
		p.setVisible(true);
		mainPanel.add(p, BorderLayout.CENTER);
		
		addPedido = createButton("anadir");
		addPedido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addDialog();
			}	
		});
		removePedido = createButton("eliminar");
		removePedido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeDialog();
			}		
		});
		updatePedido = createButton("actualizar");
		updatePedido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateDialog();			}
		});
		selecPedido = createButton("seleccionar producto");
		selecPedido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selecDialog();				
			}
		});
		selecListPedido = createButton("Lista");
		selecListPedido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listDialog();
			}		
		});
		exitButton = createButton("exit");
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
			
		});
		
		JToolBar j = new JToolBar();
		j.add(addPedido);
		j.add(removePedido);
		j.add(updatePedido);
		j.add(selecPedido);
		j.add(selecListPedido);
		j.addSeparator();
		j.add(exitButton);
		mainPanel.add(j, BorderLayout.PAGE_START);
		
		mainPanel.setVisible(true);
		
		this.add(mainPanel);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private JButton createButton(String text) {
		JButton button = new JButton();
		button.setText(text);
		return button;
	}
	
	private void addDialog() {
		AddPedidoDialogClass addDig = new AddPedidoDialogClass();
		int res = addDig.showConfirmDialog("Hacer pedido");
		if(res == 0) {
			Pedido p = new Pedido(addDig.getNombre(),addDig.getIDProv(), addDig.getIDProd(), 
							addDig.getStock(), pdtm.getRowCount()+1);
			try {
				subsProveedor.nuevoPedido(p); 
			} catch (SQLException e) {
				System.out.println("Error haciendo pedido");
			}
		}
	}
	
	private void removeDialog() {
		RemoveDialogClass remDig = new RemoveDialogClass(pdtm.getRowCount());
		int res = remDig.showConfirmDialog("Eliminar Producto");
		if(res == 0) {
			subsProducto.bajaProducto(remDig.getIdRem());
		}
	}
	
	private void updateDialog() {
		ModDialogClass remDig = new ModDialogClass(pdtm.getRowCount());
		int res = remDig.showConfirmDialog("Actualizar Producto");
		if(res == 0) {
			String op = remDig.getOp();
			String dato = remDig.getText();
			if(checkInfo(dato,op))subsProducto.modProducto(remDig.getIdRem(), op, dato);
		}
	}
	
	private void selecDialog() {
		SelecProdDialogClass selecProdDig = new SelecProdDialogClass( pqtm, pdtm.getRowCount(), subsProducto);
		selecProdDig.showConfirmDialog("Seleccionar Producto");
	}
	
	private void listDialog() {
		SelectProdListDialogClass selecProdListDig = new SelectProdListDialogClass(pqtm, pdtm.getRowCount(), subsProducto);
		selecProdListDig.showConfirmDialog("Seleccionar Productos");
	}
	
	public boolean exit() {
		return false;
	}
}
