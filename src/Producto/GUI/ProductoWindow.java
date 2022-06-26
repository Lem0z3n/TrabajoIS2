package Producto.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;

import Producto.Categoria;
import Producto.ControllerProducto;
import Producto.ProductQueryTableModel;
import Producto.Producto;
import Producto.ProductoTableModel;
import Producto.SA.FachadaSubsProducto;

public class ProductoWindow extends JFrame{
	
	private ProductoTableModel pdtm;
	private JButton addProducto, removeProducto, updateProducto, selecProducto,
			selecListProducto, exitButton;
	private FachadaSubsProducto subsProducto;
	private ControllerProducto ctrl;
	private ProductQueryTableModel pqtm;
	
	public ProductoWindow( ControllerProducto ctrl_, FachadaSubsProducto subsProducto_) {
		super("Producto");
		ctrl = ctrl_;
		subsProducto = subsProducto_;
		pdtm = new ProductoTableModel(ctrl, subsProducto);
		pqtm = new ProductQueryTableModel(ctrl);
		initGUI();
	}
	
	private void initGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setPreferredSize(new Dimension(500, 700));
		//algo de texto si quereis.
		
		JPanel p = new JPanel();
		p.add(new JScrollPane(new JTable(pdtm)));
		p.setPreferredSize(new Dimension(500, 500));
		p.setVisible(true);
		mainPanel.add(p, BorderLayout.CENTER);
		
		addProducto = createButton("anadir");
		addProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addDialog();
			}	
		});
		removeProducto = createButton("eliminar");
		removeProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeDialog();
			}		
		});
		updateProducto = createButton("actualizar");
		updateProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateDialog();			}
		});
		selecProducto = createButton("seleccionar producto");
		selecProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selecDialog();				
			}
		});
		selecListProducto = createButton("Lista");
		selecListProducto.addActionListener(new ActionListener() {
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
		j.add(addProducto);
		j.add(removeProducto);
		j.add(updateProducto);
		j.add(selecProducto);
		j.add(selecListProducto);
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
		AddDialog addDig = new AddDialog(ctrl);
		int res = addDig.showConfirmDialog("Anadir Producto");
		if(res == 0) {
			Producto p = new Producto(addDig.getNombre(), pdtm.getRowCount()+1,addDig.getCategoria(), addDig.getGender(), 
							addDig.getStock(), addDig.getColor());
			try {
				subsProducto.altaProducto(p);
			} catch (SQLException e) {
				System.out.println("Error añadiendo producto");
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
			boolean posible = true;
				switch(op) {
				
				case "id":
					try {
					int i = Integer.parseInt(dato);
					}catch(Exception e){
						posible = false;
					}
					break;
				case "categoria":
					try {
						Categoria.valueOf(dato);
					}catch (Exception e) {
						posible = false;
					}
					break;
					
				case  "stock":
					try {
						int i = Integer.parseInt(dato);
						}catch(Exception e){
							posible = false;
						}
					break;

			}
				if(posible)subsProducto.modProducto(remDig.getIdRem(), op, dato);
		}
	}
	
	private void selecDialog() {
		SelecProdDialogClass selecProdDig = new SelecProdDialogClass( pqtm, pdtm.getRowCount(), subsProducto);
		selecProdDig.showConfirmDialog("Seleccionar Producto");
	
	}
	
	private void listDialog() {
		
	}
	
	public boolean exit() {
		return false;
	}
}
