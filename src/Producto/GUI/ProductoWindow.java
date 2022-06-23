package Producto.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Producto.ProductoTableModel;

public class ProductoWindow extends JFrame{
	
	ProductoTableModel pdtm;
	JButton addProducto, removeProducto, updateProducto, selecProducto,
			selecListProducto;
	
	public ProductoWindow( ProductoTableModel pdtm_) {
		super("Producto");
		pdtm = pdtm_;
		initGUI();
	}
	
	private void initGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(mainPanel);
		
		//algo de texto si quereis.
		
		JPanel p = new JPanel();
		p.add(new JScrollPane(new JTable(pdtm)));
		p.setPreferredSize(new Dimension(500, 500));
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
	}
	
	private JButton createButton(String text) {
		JButton button = new JButton();
		button.setText(text);
		return button;
	}
	
	private void addDialog() {
		
	}
	
	private void removeDialog() {
		
	}
	
	private void updateDialog() {
		
	}
	
	private void selecDialog() {
		
	}
	
	private void listDialog() {
		
	}
}
