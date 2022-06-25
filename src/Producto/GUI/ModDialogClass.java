package Producto.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import Producto.Categoria;
import Producto.ControllerProducto;

public class ModDialogClass extends JDialog{

	
	private int result, idMax;
	private JSpinner stockSpinner;
	private JTextField c;
	private String[] opNames_ = {"nombre", "id", "categoria", "sexo", "stock", "color"};
	private JComboBox<Object> opSwitch;
	private String res;

	public ModDialogClass(int idMax_) {
		super(new JFrame(), "Anadir", true);
		idMax = idMax_;
		initGui();
	}

	private void initGui() {
		JPanel anadirPanel = new JPanel();
		anadirPanel.setLayout(new BorderLayout());
		anadirPanel.setPreferredSize(new Dimension(600, 60));
		JLabel infoText = new JLabel("Modificar un producto.");
		anadirPanel.add(infoText, BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		JLabel stockText = new JLabel("Id: ");
		stockSpinner = new JSpinner(new SpinnerNumberModel(1, 1, idMax, 1));
		stockSpinner.setMaximumSize(new Dimension(100,100));
		buttonPanel.add(stockText);
		buttonPanel.add(stockSpinner);
		
		JLabel catText = new JLabel("operaciones: ");
		opSwitch = new JComboBox<>();
		for(String op: opNames_) {
			opSwitch.addItem(op);
		}
		buttonPanel.add(catText);
		buttonPanel.add(opSwitch);
		JLabel generoText = new JLabel("Dato: ");
		buttonPanel.add(generoText);
		c = new JTextField(16);
		buttonPanel.add(c);
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
	
	public String getOp() {
		return (String) opSwitch.getSelectedItem();
	}
	public String getText() {
		return c.getText();
		}
	public int getIdRem() {
		return (int) stockSpinner.getValue();
	}
}
