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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

import Producto.ProductQueryTableModel;
import Producto.SA.FachadaSubsProducto;
import Proveedor.PedidoQueryTableModel;
import Proveedor.SA.FachadaSubsProveedor;

public class SelecPedDialogClass extends JDialog{
	
	
	private PedidoQueryTableModel pqtm;
	private JSpinner stockSpinner;
	private int idMax, result;
	private FachadaSubsProveedor subsProducto;
	
	public SelecPedDialogClass(PedidoQueryTableModel pqtm_,int idMax_, FachadaSubsProveedor subsProducto_) {
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
		anadirPanel.setPreferredSize(new Dimension(600, 250));
		JLabel infoText = new JLabel("Seleccionar un pedido.");
		
JPanel buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(infoText);
		
		JLabel stockText = new JLabel("Id: ");
		stockSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 250, 1));
		stockSpinner.setMaximumSize(new Dimension(100,100));
		buttonPanel.add(stockText);
		buttonPanel.add(stockSpinner);
		anadirPanel.add(buttonPanel, BorderLayout.NORTH);
		
		JPanel p = new JPanel();
		p.add(new JScrollPane(new JTable(pqtm)));
		p.setPreferredSize(new Dimension(400, 150));
		p.setVisible(true);
		anadirPanel.add(p, BorderLayout.CENTER);
		
		JPanel accCancPanel = new JPanel();
		accCancPanel.setLayout(new FlowLayout());
		
		JButton accept = new JButton("OK");
		accept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				result = 0;
				if(!subsProducto.consultarPedido(getId()))
					System.out.println("id no reconocido");
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
	
	public int showConfirmDialog(String title) {
		setTitle(title);
		setLocationRelativeTo(getParent());
		pack();
		setSize(700, 250);
		setVisible(true);
		return result;
	}
	
	public int getId() {
		return  (int) stockSpinner.getValue();
	}
}
