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
import javax.swing.JToolBar;

import Producto.ProductoTableModel;

public class ProductoWindow extends JFrame{
	
	ProductoTableModel pdtm;
	JButton addProducto, removeProducto, updateProducto, selecProducto,
			selecListProducto, exitButton;
	
	public ProductoWindow( ProductoTableModel pdtm_) {
		super("Producto");
		pdtm = pdtm_;
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
		
	}
	
	private void removeDialog() {
		
	}
	
	private void updateDialog() {
		
	}
	
	private void selecDialog() {
		
	}
	
	private void listDialog() {
		
	}
	
	public boolean exit() {
		return false;
	}
}
