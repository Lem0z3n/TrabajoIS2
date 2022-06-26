package Producto.GUI;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import Producto.Categoria;
import Producto.ProductQueryTableModel;
import Producto.SA.FachadaSubsProducto;

public class SelectProdListDialogClass extends JDialog{

	private ProductQueryTableModel pqtm;
	private JSpinner stockSpinner;
	private int idMax, result;
	private JTextField c;
	private FachadaSubsProducto subsProducto;
	private String[] opNames_ = {"nombre", "id", "categoria", "sexo", "stock", "color"};
	private JComboBox<Object> opSwitch;
	
	public SelectProdListDialogClass(ProductQueryTableModel pqtm_,int idMax_, FachadaSubsProducto subsProducto_) {
		super(new JFrame(), "Selecionar", true);
		subsProducto = subsProducto_;
		pqtm = pqtm_;
		idMax = idMax_;
		initGui();
	}

	private void initGui() {
		// TODO Auto-generated method stub
		JPanel anadirPanel = new JPanel();
		anadirPanel.setLayout(new BorderLayout());
		anadirPanel.setPreferredSize(new Dimension(600, 400));
		JLabel infoText = new JLabel("Seleccionar productos.");
		
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(infoText);
		anadirPanel.add(buttonPanel, BorderLayout.NORTH);
		
		JPanel selecPanel = new JPanel();
		selecPanel.setLayout(new BorderLayout());
		
		JPanel selPanel  = new JPanel();
		selPanel.setLayout(new FlowLayout());
		JLabel catText = new JLabel("operaciones: ");
		opSwitch = new JComboBox<>();
		for(String op: opNames_) {
			opSwitch.addItem(op);
		}
		selPanel.add(catText);
		selPanel.add(opSwitch);
		JLabel generoText = new JLabel("Dato: ");
		selPanel.add(generoText);
		c = new JTextField(16);
		selPanel.add(c);
		selecPanel.add(selPanel, BorderLayout.NORTH);
		
		JPanel p = new JPanel();
		p.add(new JScrollPane(new JTable(pqtm)));
		p.setPreferredSize(new Dimension(400, 150));
		p.setVisible(true);
		selecPanel.add(p, BorderLayout.SOUTH);
		anadirPanel.add(selecPanel, BorderLayout.CENTER);
		
		JPanel accCancPanel = new JPanel();
		JButton accept = new JButton("OK");
		accept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				result = 0;
				if(checkInfo(getText(),getOp())) {
					subsProducto.buscProducto(getText(),getOp());
				}
			}
		});
		
		accCancPanel.add(accept);
		
		JButton cancel = new JButton("Close");
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
	
	
	private boolean checkInfo(String dato, String op) {
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
		return posible;
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
}
