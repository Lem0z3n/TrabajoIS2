package Main;

import javax.swing.SwingUtilities;

import Vista.MainWindow;

public class Main {
	
	public static void main(String[] args) {
		initGui();
	}
	
	private static void initGui() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow();
			}
		});
	}
	
}
