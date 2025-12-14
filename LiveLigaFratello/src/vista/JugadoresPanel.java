package vista;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Posicion;

public class JugadoresPanel extends FondoPanel{

	public JugadoresPanel(MainFrame frame) {
		super("C:\\Users\\gabri\\fratello_workspace\\LiveLigaFratello\\src\\imagenes\\fondo_blanco.jpg");
		
		setOpaque(false);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbcTitulo = new GridBagConstraints();
		
		gbcTitulo.gridx = 0;
		
		gbcTitulo.gridy= 0;
		
		gbcTitulo.anchor = GridBagConstraints.NORTH;
		
		gbcTitulo.insets = new Insets(20, 0, 10, 0);
		
		JLabel tituloJugadores = new JLabel("========================== Lista Jugadores ==========================");
		
		tituloJugadores.setFont(new Font("Arial", Font.BOLD, 22));
		
		tituloJugadores.setHorizontalAlignment(JLabel.CENTER);
		
		add(tituloJugadores, gbcTitulo);
		
		
		GridBagConstraints gbcFormulario = new GridBagConstraints();
		
		gbcFormulario.gridx = 0;
		
		gbcFormulario.gridy= 1;
		
		gbcFormulario.anchor = GridBagConstraints.NORTH;
		
		gbcFormulario.weighty= 1;
		
		
		JPanel panelFormulario = formularioJugadores();
		
		add(panelFormulario, gbcFormulario);
		
		
	}
	
	private JPanel formularioJugadores() {
		
		JPanel panel = new JPanel(new GridBagLayout());
		
	    panel.setOpaque(false);

	    GridBagConstraints gbcFormulario = new GridBagConstraints();
	    
	    gbcFormulario.insets = new Insets(10, 10, 10, 10);
	    
	    gbcFormulario.anchor = GridBagConstraints.WEST;

	    // label selecciona equipo
	    
	    gbcFormulario.gridx = 0;
	    
	    gbcFormulario.gridy = 0;
	    
	    JLabel equipolbl = new JLabel("Selecciona equipo:");
	    
	    panel.add(equipolbl, gbcFormulario);

	    // combo equipos
	    
	    gbcFormulario.gridx = 1;
	    
	    gbcFormulario.fill = GridBagConstraints.HORIZONTAL;
	    
	    
	    
	    //TODO: rellenar con los equipos de la BBDD
	    
	    String [] equipos = {"Selecciona equipo"};

	    JComboBox<String> comboEquipos = new JComboBox<>(equipos);
	    
	    panel.add(comboEquipos, gbcFormulario);
	    
	    //label nombre
	    
	    gbcFormulario.gridx = 2;
	    
	    gbcFormulario.gridy = 0;
	    
	    JLabel nombrelbl = new JLabel("Nombre:");
	    
	    panel.add(nombrelbl, gbcFormulario);
	    
	    //txt nombre
	    
	    gbcFormulario.gridx = 3;
	    
	    gbcFormulario.gridy = 0;
	    
	    JTextField nombretxt = new JTextField(15);
	    
	    panel.add(nombretxt, gbcFormulario);
	    
	    //Dorsal lbl
	    
	    gbcFormulario.gridx = 0;
	    
	    gbcFormulario.gridy = 1;
	    
	    JLabel dorsalLbl = new JLabel("Dorsal:");
	    
	    panel.add(dorsalLbl, gbcFormulario);
	    
	    //Dorsal COMBO
	    //TODO: Lógica para que el dorsal no este repetido
	    
	    gbcFormulario.gridx = 1;
	    
	    gbcFormulario.gridy = 1;
	    
	    
	    JComboBox<Integer> comboDorsal = new JComboBox<>();
	    
	    for(int i = 0; i <= 50; i++) {
	    	comboDorsal.addItem(i);
	    }
	    
	    panel.add(comboDorsal, gbcFormulario);
	    
	    
	    //label posicion
	    
	    gbcFormulario.gridx = 2;
	    
	    gbcFormulario.gridy = 1;
	    
	    JLabel posicionLbl = new JLabel("Posición:");
	    
	    panel.add(posicionLbl, gbcFormulario);
	    
	    //ENUM Posicion
	    
	    gbcFormulario.gridx = 3;
	    
	    gbcFormulario.gridy = 1;
	    
	    JComboBox<Posicion> comboPosicion = new JComboBox<>(Posicion.values());
	    
	    panel.add(comboPosicion, gbcFormulario);
	    
	    //JButton añadir
	    
	    gbcFormulario.gridx = 0;
	    
	    gbcFormulario.gridy = 2;
	    
	    JButton addJugador = new JButton("Añadir");
	    
	    panel.add(addJugador, gbcFormulario);
	    
	    //JButton actualizar
	    
	    gbcFormulario.gridx = 1;
	    
	    gbcFormulario.gridy = 2;
	    
	    JButton modificarJugadorBtn = new JButton("Modificar");
	    
	    panel.add(modificarJugadorBtn, gbcFormulario);
	    
	    //JButton Listar
	    
	    gbcFormulario.gridx = 2;
	    
	    gbcFormulario.gridy = 2;
	    
	    JButton listarJugadorBtn = new JButton("Listar");
	    
	    panel.add(listarJugadorBtn, gbcFormulario);
	    
	    //JButton Eliminar
	    
	    gbcFormulario.gridx = 3;
	    
	    gbcFormulario.gridy = 2;
	    
	    gbcFormulario.weightx = 1;
	    
	    JButton eliminarJugadorBtn = new JButton("Eliminar");
	    
	    panel.add(eliminarJugadorBtn, gbcFormulario);
	    
	    return panel;
	}
	
	private JPanel tablaJugadores() {
		//TODO: Mostraremos la tabla jugadores recuperandola desde la BBDD
		
		JPanel panel = new JPanel(new GridBagLayout());
		
		
		return panel;
	}
	
}
