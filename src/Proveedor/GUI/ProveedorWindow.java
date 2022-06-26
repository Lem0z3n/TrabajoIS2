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

import Producto.Categoria;
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
import Proveedor.PedidoQueryTableModel;
import Proveedor.PedidoTableModel;
import Proveedor.SA.FachadaSubsProveedor;

public class ProveedorWindow extends JFrame{
	
	private JButton addPedido, removePedido, updatePedido, selecPedido,
	selecListPedido, exitButton;
	private FachadaSubsProveedor subsProveedor;
	private ControllerProveedor ctrl;
	private PedidoTableModel pdtm;
	private PedidoQueryTableModel pqtm;
	private int auxPed= 100;
	boolean exit = false;
	
	public ProveedorWindow(ControllerProveedor ctrl_, FachadaSubsProveedor subsProveedor_) {
		super("Proveedor");
		ctrl = ctrl_;
		subsProveedor = subsProveedor_;
		pdtm = new PedidoTableModel(ctrl, subsProveedor);
		pqtm = new PedidoQueryTableModel(ctrl);
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
		
		addPedido = createButton("añadir");
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
		updatePedido = createButton("Recibir");
		updatePedido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				recibirDialog();
			}		
		});
		exitButton = createButton("exit");
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				exit = true;
				exit();
			}
			
		});
		
		JToolBar j = new JToolBar();
		j.add(addPedido);
		j.add(removePedido);
		j.add(selecPedido);
		j.add(selecListPedido);
		j.add(updatePedido);
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
			Pedido p = new Pedido(addDig.getNombre(),addDig.getIDProd(), addDig.getIDProv(), 
					auxPed, addDig.getStock()); 
			auxPed++;
			try {
				subsProveedor.nuevoPedido(p); 
			} catch (SQLException e) {
				System.out.println("Error haciendo pedido");
			}
		}
	}
	
	private void removeDialog() {
		RemovePedidoDialogClass remDig = new RemovePedidoDialogClass();
		int res = remDig.showConfirmDialog("Cancelar pedido");
		if(res == 0) {
			if(!subsProveedor.cancelarPedido(remDig.getIdRem()))
				System.out.println("id no reconocido.");
		}
	}
	
	/*private void updateDialog() {
		ModPedidoDialogClass remDig = new ModPedidoDialogClass(pdtm.getRowCount());
		int res = remDig.showConfirmDialog("Actualizar Pedido");
		if(res == 0) {
			String op = remDig.getOp();
			String dato = remDig.getText();
			if(checkInfo(dato,op))subsProveedor.modPedido(remDig.getIdRem(), op, dato);
		}
	}*/
	
	private void selecDialog() {
		SelecPedDialogClass selecProdDig = new SelecPedDialogClass( pqtm, pdtm.getIds(), subsProveedor);
		selecProdDig.showConfirmDialog("Seleccionar Pedido");
	}
	
	private void listDialog() {
		SelecPedListDialogClass selecProdListDig = new SelecPedListDialogClass(pqtm, pdtm.getIds(), subsProveedor);
		selecProdListDig.showConfirmDialog("Seleccionar Lista Pedidos");
	}
	
	private void recibirDialog() {
		recibirDialogClass recDig = new recibirDialogClass(pdtm.getIds());
		int res = recDig.showConfirmDialog("Recibir pedido");
		if(res == 0) {
			subsProveedor.recibirPedido(recDig.getIdRem());
		}
	}
	
	public boolean exit() {
		
		return exit;
	}
	
}
