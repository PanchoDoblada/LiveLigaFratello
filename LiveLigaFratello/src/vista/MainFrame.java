package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Usuario;

public class MainFrame extends JFrame{
	
	private JPanel panel;
	private Usuario usuarioActual;
	
	public MainFrame() {
		
		setTitle("Live Liga Fratello");
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
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
	
	public void setUsuarioActual(Usuario usuario) {
	    this.usuarioActual = usuario;
	}

	public Usuario getUsuarioActual() {
	    return usuarioActual;
	}

	public boolean esAdminActual() {
	    return usuarioActual != null && usuarioActual.esAdmin();
	}
	
}
