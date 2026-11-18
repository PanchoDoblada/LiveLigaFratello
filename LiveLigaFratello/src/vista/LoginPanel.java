package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.UsuarioDaoImpl;
import modelo.Usuario;
import utiles.Seguridad;

public class LoginPanel extends FondoPanel{
	
	private JTextField txtUser;
	private JPasswordField txtPass;
	private UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
	private MainFrame frame;
	
	public LoginPanel(MainFrame frame) {
		
		super("/imagenes/fondoLogin.jpg", 100);
		
		this.frame = frame;
			
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(60, 300, 100, 300));
        setOpaque(false);

        JPanel panelLogin = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                Graphics2D g2 = (Graphics2D) g.create();

                g2.setColor(new Color(255, 255, 255, 180));
                
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                
                g2.dispose();
            }
        };
        
        panelLogin.setLayout(new BoxLayout(panelLogin, BoxLayout.Y_AXIS));
        panelLogin.setOpaque(false); 
        
        JLabel tituloLogin = new JLabel("LIVE LIGA FRATELLO!");
        tituloLogin.setFont(new Font("Algerian", Font.BOLD, 24));
        tituloLogin.setForeground(new Color(34, 56, 22));
        tituloLogin.setAlignmentX(CENTER_ALIGNMENT);
        
        JLabel subTituloLogin = new JLabel("La mejor liga de la Comunidad Valenciana");
        subTituloLogin.setFont(new Font("Arial",0, 18));
        subTituloLogin.setForeground(new Color(84, 97, 77));
        subTituloLogin.setAlignmentX(CENTER_ALIGNMENT);
        
        JLabel lblUser = new JLabel("Usuario:");
        lblUser.setAlignmentX(CENTER_ALIGNMENT);
        
        txtUser = new JTextField(15);
        txtUser.setMaximumSize(txtUser.getPreferredSize());
        txtUser.setAlignmentX(CENTER_ALIGNMENT);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setAlignmentX(CENTER_ALIGNMENT);
        
        txtPass = new JPasswordField(15);
        txtPass.setMaximumSize(txtPass.getPreferredSize());
        txtPass.setAlignmentX(CENTER_ALIGNMENT);

        JButton btnLogin = new JButton("Entrar");
        btnLogin.setAlignmentX(CENTER_ALIGNMENT);
        
        JButton btnRegistro = new JButton("Registrarme");
        btnRegistro.setAlignmentX(CENTER_ALIGNMENT);
        
        panelLogin.add(Box.createVerticalStrut(30));
        panelLogin.add(tituloLogin);
        panelLogin.add(Box.createVerticalStrut(10));
        panelLogin.add(subTituloLogin);
        panelLogin.add(Box.createVerticalStrut(10));
        panelLogin.add(lblUser);
        panelLogin.add(txtUser);
        panelLogin.add(Box.createVerticalStrut(10));
        panelLogin.add(lblPass);
        panelLogin.add(txtPass);
        panelLogin.add(Box.createVerticalStrut(20));
        panelLogin.add(btnLogin);
        panelLogin.add(Box.createVerticalStrut(10));
        panelLogin.add(btnRegistro);
        panelLogin.add(Box.createVerticalStrut(50));

        add(Box.createVerticalGlue());
        add(panelLogin);
        add(Box.createVerticalGlue());

        btnLogin.addActionListener(e -> iniciarSesion());
        
        btnRegistro.addActionListener(e -> {
        	frame.mostrarRegistro();
        });
	}
	
	private void iniciarSesion() {

	    String nombreUsuario = txtUser.getText().trim();
	    String password = new String(txtPass.getPassword());

	    // Comrobamos los campos vacios
	    if (nombreUsuario.isEmpty() || password.isEmpty()) {

	        JOptionPane.showMessageDialog(
	            this,
	            "Introduce tu usuario y contraseña",
	            "Introduce tu contraseña",
	            JOptionPane.WARNING_MESSAGE
	        );

	        return;
	    }

	    try {

	        // Buscar el usuario en la base de datos
	        Usuario usuario = usuarioDao.buscarPorNombre(nombreUsuario);

	        // Comprobar si existe
	        if (usuario == null) {

	            JOptionPane.showMessageDialog(
	                this,
	                "El usuario no está registrado"
	            );

	            return;
	        }

	        // Recuperar los datos almacenados de la contraseña
	        String[] datosPassword = usuario.getPassword().split(":", 3);

	        if (datosPassword.length != 3) {

	            JOptionPane.showMessageDialog(
	                this,
	                "Los datos de la contraseña almacenada no son válidos"
	            );

	            return;
	        }

	        int iteraciones = Integer.parseInt(datosPassword[0]);
	        String salt = datosPassword[1];
	        String hashGuardado = datosPassword[2];

	        // Verificar la contraseña
	        boolean contraseñaCorrecta = Seguridad.verificarPassword(
	            password,
	            salt,
	            hashGuardado,
	            iteraciones,
	            256
	        );

	        if (contraseñaCorrecta) {

	            JOptionPane.showMessageDialog(
	                this,
	                "¡Bienvenido a Live Liga Fratelo!"
	            );

	            txtPass.setText("");
	            
	            frame.setUsuarioActual(usuario);
	            frame.mostrarMenu();

	        } else {

	            JOptionPane.showMessageDialog(
	                this,
	                "Usuario o contraseña incorrectos"
	            );

	            txtPass.setText("");
	        }

	    } catch (SQLException | NumberFormatException e) {

	        JOptionPane.showMessageDialog(
	            this,
	            "Error al iniciar sesión: " + e.getMessage(),
	            "Error",
	            JOptionPane.ERROR_MESSAGE
	        );

	        e.printStackTrace();
	    }
	}
}
