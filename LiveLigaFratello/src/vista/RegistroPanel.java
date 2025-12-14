package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistroPanel extends FondoPanel{

	public RegistroPanel(MainFrame frame) {
		
		super("C:\\Users\\gabri\\fratello_workspace\\LiveLigaFratello\\src\\imagenes\\fondoRegistro.jpg");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);

        // PANEL CENTRAL CON TRANSPARENCIA
        JPanel panelRegistro = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(new Color(255, 255, 255, 180));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                g2.dispose();
            }
        };

        panelRegistro.setOpaque(false);
        panelRegistro.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15,15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; 
        gbc.gridy = 0;
        panelRegistro.add(new JLabel("Usuario"), gbc);

        gbc.gridx = 1;
        JTextField txtUsuario = new JTextField(15);
        panelRegistro.add(txtUsuario, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 1;
        panelRegistro.add(new JLabel("Contraseña"), gbc);

        gbc.gridx = 1;
        JPasswordField txtPass = new JPasswordField(15);
        panelRegistro.add(txtPass, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 2;
        panelRegistro.add(new JLabel("Correo"), gbc);

        gbc.gridx = 1;
        JTextField txtCorreo = new JTextField(15);
        panelRegistro.add(txtCorreo, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 3;
        panelRegistro.add(new JLabel("Género"), gbc);

        gbc.gridx = 1;
        JComboBox<String> seleccionaGenero = new JComboBox<>();
        seleccionaGenero.addItem("Mujer");
        seleccionaGenero.addItem("Hombre");
        panelRegistro.add(seleccionaGenero, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton btnRegistrar = new JButton("Registrarse");
        panelRegistro.add(btnRegistrar, gbc);
        
        gbc.insets = new Insets(0, 15, 15, 15);
        
        gbc.gridx = 0; 
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        JButton btnVolver = new JButton("Volver");
        panelRegistro.add(btnVolver, gbc);
        
        btnVolver.addActionListener(e -> {
        	frame.mostrarLogin();
        });

        panelRegistro.setPreferredSize(new Dimension(450, 400));
        panelRegistro.setMaximumSize(new Dimension(450, 400));
        panelRegistro.setMinimumSize(new Dimension(450, 400));


        add(Box.createVerticalGlue());
        add(panelRegistro);
        add(Box.createVerticalGlue());
        
        
        
        
	}
	
	
	
}

