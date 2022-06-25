package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Producto.ControllerProducto;
import Producto.ProductoTableModel;
import Producto.GUI.ProductoWindow;



public class MainWindow extends JFrame {

	private JButton proveedorButton, productoButton;
	private static Border _defaultBorder = BorderFactory.createLineBorder(Color.getColor("#000000"));
	private ControllerProducto cprod;
	
	public MainWindow() {
		super("Proyecto");
		cprod = new ControllerProducto();
		initGUI();
	}
	
	private void initGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(mainPanel);
		
		JPanel buttonsPanel = new JPanel(new BorderLayout());
		buttonsPanel.setPreferredSize(new Dimension(400,400));
		proveedorButton = new JButton();
		proveedorButton.setText("proveedores");
		proveedorButton.setPreferredSize(new Dimension(200,200));
		proveedorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initProveedores();
			}
				
		});
		buttonsPanel.add(proveedorButton, BorderLayout.WEST);
		
		productoButton = new JButton();
		productoButton.setText("productos");
		productoButton.setPreferredSize(new Dimension(200,200));
		productoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				initProductos();
			}
		});
		buttonsPanel.add(productoButton, BorderLayout.EAST);
		mainPanel.add(buttonsPanel, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	private void initProveedores() {
		/*proveedoresClass misprovs = new ProveedoresClassWindow();
		this.setVisible(false); habra que hacer algo asi pero con un cuando volver setVisible true*/
	}
	
	private void initProductos() {
		/*productosClass misprovs = new ProductosClassWindow();
		this.setVisible(false);*/
		ProductoTableModel pdtm = new ProductoTableModel(cprod);
		ProductoWindow prodWind = new ProductoWindow(pdtm);
		
		prodWind.setVisible(true);
		this.setVisible(false);
		//setVisible(true);
	}
}
