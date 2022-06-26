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
import Producto.SA.FachadaSubsProducto;
import Proveedor.ControllerProveedor;
import Proveedor.GUI.ProveedorWindow;
import Proveedor.SA.FachadaSubsProveedor;



public class MainWindow extends JFrame {

	private JButton proveedorButton, productoButton;
	private static Border _defaultBorder = BorderFactory.createLineBorder(Color.getColor("#000000"));
	private ControllerProducto cprod;
	private ControllerProveedor cprov;
	private FachadaSubsProveedor subsProv;
	private FachadaSubsProducto subsProducto;
	
	public MainWindow() {
		super("Proyecto");
		cprod = new ControllerProducto();
		subsProducto = new FachadaSubsProducto();
		cprov = new ControllerProveedor();
		subsProv = new FachadaSubsProveedor();
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
		ProveedorWindow provWind = new ProveedorWindow(cprov, subsProv);
		
		provWind.setVisible(true);
		this.setVisible(false);
	}
	
	private void initProductos() {
		/*productosClass misprovs = new ProductosClassWindow();
		this.setVisible(false);*/
		ProductoWindow prodWind = new ProductoWindow(cprod, subsProducto);
		
		prodWind.setVisible(true);
		this.setVisible(false);
		//setVisible(true);
	}
}
