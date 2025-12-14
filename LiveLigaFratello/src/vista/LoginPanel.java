package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends FondoPanel{
	
public LoginPanel(MainFrame frame) {
		
		super("C:\\Users\\gabri\\fratello_workspace\\LiveLigaFratello\\src\\imagenes\\fondoLogin.jpg");
        
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
        
        JTextField txtUser = new JTextField(15);
        txtUser.setMaximumSize(txtUser.getPreferredSize());
        txtUser.setAlignmentX(CENTER_ALIGNMENT);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setAlignmentX(CENTER_ALIGNMENT);
        
        JPasswordField txtPass = new JPasswordField(15);
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

        btnLogin.addActionListener(e -> {
            //TODO: Lógica para comprobar si existe el usuario
        	frame.mostrarPanelJugadores();
        });
        
        btnRegistro.addActionListener(e -> {
        	frame.mostrarRegistro();
        });
	}
}
