package Producto.GUI;

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
import javax.swing.SpinnerNumberModel;

import Producto.ControllerProducto;

public class RemoveDialogClass extends JDialog{
	
	private int result, idMax;
	private JSpinner stockSpinner;
	
	
	public RemoveDialogClass() {
		super(new JFrame(), "Anadir", true);
		
		initGui();
	}

	private void initGui() {
		// TODO Auto-generated method stub
		JPanel remPanel = new JPanel();
		remPanel.setLayout(new BorderLayout());
		remPanel.setPreferredSize(new Dimension(600, 60));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		JLabel stockText = new JLabel("Id: ");
		stockSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 250, 1));
		stockSpinner.setMaximumSize(new Dimension(100,100));
		buttonPanel.add(stockText);
		buttonPanel.add(stockSpinner);
		remPanel.add(buttonPanel);
		
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
		remPanel.add(accCancPanel, BorderLayout.SOUTH);
		
		remPanel.setVisible(true);
		this.add(remPanel);
	}

	public int showConfirmDialog(String title) {
		setTitle(title);
		setLocationRelativeTo(getParent());
		pack();
		setSize(700, 120);
		setVisible(true);
		return result;
	}
	
	public int getIdRem() {
		return (int) stockSpinner.getValue();
	}

}
