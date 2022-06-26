package Proveedor.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import Producto.ControllerProducto;

public class AddPedidoDialogClass extends JDialog{

	
	private JTextField nombre;
	private JSpinner idProdSpinner, stockSpinner, idProvSpinner;
	
	private int result;
	
	public AddPedidoDialogClass() {
		super(new JFrame(), "Anadir", true);
		initGui();
	}

	private void initGui() {
		JPanel anadirPanel = new JPanel();
		anadirPanel.setLayout(new BorderLayout());
		anadirPanel.setPreferredSize(new Dimension(1200, 60));
		JLabel infoText = new JLabel("Anadir un nuevo producto.");
		anadirPanel.add(infoText, BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		JLabel nameText = new JLabel("Nombre: ");
		buttonPanel.add(nameText);
		nombre = new JTextField(16);
		buttonPanel.add(nombre);
		JLabel idProdText = new JLabel("ID producto: ");
		idProdSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
		idProdSpinner.setMaximumSize(new Dimension(100,100));
		buttonPanel.add(idProdText);
		buttonPanel.add(idProdSpinner);
		JLabel stockText = new JLabel("Stock: ");
		stockSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
		stockSpinner.setMaximumSize(new Dimension(100,100));
		buttonPanel.add(stockText);
		buttonPanel.add(stockSpinner);
		JLabel idProvText = new JLabel("idProv: ");
		idProvSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
		idProvSpinner.setMaximumSize(new Dimension(100,100));
		buttonPanel.add(idProvText);
		buttonPanel.add(idProvSpinner);
		anadirPanel.add(buttonPanel, BorderLayout.CENTER);
		
		JPanel accCancPanel = new JPanel();
		accCancPanel.setLayout(new FlowLayout());
		
		JButton accept = new JButton("OK");
		accept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				result = 0;
				setVisible(false);
				dispose();
			}
		});
		
		accCancPanel.add(accept);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				result = 1;
				setVisible(false);
				dispose();
			}
		});
		accCancPanel.add(cancel);
		anadirPanel.add(accCancPanel, BorderLayout.SOUTH);
		
		anadirPanel.setVisible(true);
		this.add(anadirPanel);
	}
	
	public int showConfirmDialog(String title) {
		setTitle(title);
		setLocationRelativeTo(getParent());
		pack();
		setSize(700, 120);
		setVisible(true);
		return result;
	}
	public String getNombre() {
		return nombre.getText();
	}
	public int getStock() {
		return (int) stockSpinner.getValue();
	}
	public int getIDProd() {
		return (int) idProdSpinner.getValue();
	}
	public int getIDProv() {
		return (int) idProvSpinner.getValue();
	}
}
