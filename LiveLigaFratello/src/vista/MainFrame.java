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
		
		mostrarLogin();
	}
	
	public void mostrarLogin() {
		
		panel.removeAll();
		
		panel.add(new LoginPanel(this));
		
		panel.revalidate();
		
		panel.repaint();
	}
	
	public void mostrarRegistro() {
		panel.removeAll();
		
		panel.add(new RegistroPanel(this));
		
		panel.revalidate();
		
		panel.repaint();
	}
	
	public void mostrarMenu() {
		panel.removeAll();
		
		panel.add(new MenuPanel(this));
		
		panel.revalidate();
		
		panel.repaint();
	}
	
	public void mostrarPanelJugadores() {
		panel.removeAll();
		
		panel.add(new JugadoresPanel(this));
		
		panel.revalidate();
		
		panel.repaint();
	}
}
