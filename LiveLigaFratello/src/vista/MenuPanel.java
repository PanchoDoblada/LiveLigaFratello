package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import utiles.Util;
import vista.recursos.Textos;

public class MenuPanel extends FondoPanel{
	
	private CardLayout cardlayout;
	
	public MenuPanel(MainFrame frame) {
		super("C:\\Users\\gabri\\fratello_workspace\\LiveLigaFratello\\src\\imagenes\\fondomenu.jpg");
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        
        panelBotones.setOpaque(false);
        
        JButton btnHistoria = new JButton("Historia");
        
        btnHistoria.setSize(50, 70);
        
        btnHistoria.setIcon(Util.redimensionarIcono("/vista/recursos/historia.png", 50, 50));

        JButton btnJugadores = new JButton("Jugadores");
        
        btnJugadores.setSize(50, 70);
        
        btnJugadores.setIcon(Util.redimensionarIcono("/vista/recursos/jugador-de-futbol.png", 50, 50));
        
        JButton btnEquipos = new JButton("Equipos");
        
        btnEquipos.setSize(50, 70);
        
        btnEquipos.setIcon(Util.redimensionarIcono("/vista/recursos/equipo.png", 50, 50));
        
        JButton btnPartidos = new JButton("Partidos");
        
        btnPartidos.setSize(50, 70);
        
        btnPartidos.setIcon(Util.redimensionarIcono("/vista/recursos/campo-de-futbol.png", 50, 50));
        
        JButton btnClasificacion = new JButton ("Clasificación");
        
        btnClasificacion.setSize(50, 70);
        
        btnClasificacion.setIcon(Util.redimensionarIcono("/vista/recursos/clasificacion.png", 50, 50));
        
        panelBotones.add(btnHistoria);

        panelBotones.add(btnJugadores);
        
        panelBotones.add(btnEquipos);
        
        panelBotones.add(btnPartidos);
        
        panelBotones.add(btnClasificacion);

        JPanel panelMenu = new JPanel(new CardLayout()) {
        	
            @Override
            protected void paintComponent(Graphics g) {
            	
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g.create();
                
                g2.setColor(new Color(255, 255, 255, 180));
                
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                
                g2.dispose();
            }
        };

        panelMenu.setOpaque(false);
        
        panelMenu.setPreferredSize(new Dimension(800, 600));
        
        panelMenu.setMaximumSize(new Dimension(800, 600));
        
        panelMenu.setMinimumSize(new Dimension(800, 600));
        
        panelMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        cardlayout = (CardLayout) panelMenu.getLayout();
        
        panelMenu.add(cardHistoria(), "Historia");
        panelMenu.add(cardJugadores(frame), "Jugadores");
        panelMenu.add(cardEquipos(frame), "Equipos");
        panelMenu.add(cardPartidos(frame), "Partidos");
        panelMenu.add(cardClasificacion(frame), "Clasificacion");
        
        
        btnHistoria.addActionListener( e -> cardlayout.show(panelMenu, "Historia"));
        btnJugadores.addActionListener(e -> cardlayout.show(panelMenu, "Jugadores"));
        btnEquipos.addActionListener( e -> cardlayout.show(panelMenu, "Equipos"));
        btnPartidos.addActionListener( e -> cardlayout.show(panelMenu, "Partidos"));
        btnClasificacion.addActionListener( e -> cardlayout.show(panelMenu, "Clasificacion"));
        

        add(Box.createVerticalGlue());
        add(panelBotones);
        add(panelMenu);
        add(Box.createVerticalGlue());
        
	}
	
	private JPanel cardHistoria() {
		JPanel panelHistoria = new JPanel();
		
		panelHistoria.setBackground(Color.white);
		
		panelHistoria.add(new JLabel("Panel historia"));
		
		return panelHistoria;
	}
	
	private JPanel cardJugadores(MainFrame frame) {
		
		JPanel panel = new JPanel();
		
		panel.setBackground(Color.white);
		
		panel.removeAll();
		
		panel.add(new JugadoresPanel(frame));
		
		panel.revalidate();
		
		panel.repaint();
		
		return panel;
	}
	
	private JPanel cardEquipos(MainFrame frame) {
		JPanel panel = new JPanel();
		
		panel.setBackground(Color.white);
		
		panel.removeAll();
		
		panel.add(new EquiposPanel(frame));
		
		panel.revalidate();
		
		panel.repaint();
		
		return panel;
		
	}
	
	private JPanel cardPartidos(MainFrame frame) {
		
		JPanel panelPartidos = new JPanel();
		panelPartidos.setBackground(Color.white);
		
		panelPartidos.add(new JLabel("Panel partidos"));
		
		return panelPartidos;
	}
	
	private JPanel cardClasificacion(MainFrame frame) {
		JPanel panel = new JPanel();
		
		panel.setBackground(Color.white);
		
		panel.removeAll();
		
		panel.add(new ClasificacionPanel(frame));
		
		panel.revalidate();
		
		panel.repaint();
		
		return panel;
		
	}
}
