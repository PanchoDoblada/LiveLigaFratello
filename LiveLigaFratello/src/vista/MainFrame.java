package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	
	private JPanel panel;
	
	public MainFrame() {
		
		setTitle("Live Liga Fratello");
		
		setSize(1000, 600);
		
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		setLayout(new BorderLayout());
		
		panel = new JPanel(new BorderLayout());
		
		add(panel, BorderLayout.CENTER);
		
		mostrarRegistro();
	}
	
	public void mostrarRegistro() {
		
		panel.removeAll();
		
		panel.add(new RegistroPanel(this));
		
		panel.revalidate();
		
		panel.repaint();
	}
}
