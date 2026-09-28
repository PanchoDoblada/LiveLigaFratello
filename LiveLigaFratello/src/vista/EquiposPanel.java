package vista;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Posicion;

public class EquiposPanel extends FondoPanel{
	
	public EquiposPanel (MainFrame frame) {
		
		super("C:\\Users\\gabri\\fratello_workspace\\LiveLigaFratello\\src\\imagenes\\fondo_blanco.jpg");
		
		setOpaque(false);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbcTitulo = new GridBagConstraints();
		
		gbcTitulo.gridx = 0;
		
		gbcTitulo.gridy= 0;
		
		gbcTitulo.anchor = GridBagConstraints.NORTH;
		
		gbcTitulo.insets = new Insets(20, 0, 10, 0);
		
		JLabel tituloEquipos = new JLabel("Lista Equipos");
		
		tituloEquipos.setFont(new Font("Arial", Font.BOLD, 22));
		
		tituloEquipos.setHorizontalAlignment(JLabel.CENTER);
		
		add(tituloEquipos, gbcTitulo);
		
		
		GridBagConstraints gbcFormulario = new GridBagConstraints();
		
		gbcFormulario.gridx = 0;
		
		gbcFormulario.gridy= 1;
		
		gbcFormulario.anchor = GridBagConstraints.NORTH;
		
		gbcFormulario.weighty= 1;
		
		
		JPanel panelFormulario = formularioJEquipos();
		
		add(panelFormulario, gbcFormulario);
	
	
	}

	private JPanel formularioJEquipos() {
	
		JPanel panel = new JPanel(new GridBagLayout());
		
	    panel.setOpaque(false);
	
	    GridBagConstraints gbcFormulario = new GridBagConstraints();
	    
	    gbcFormulario.insets = new Insets(10, 10, 10, 10);
	    
	    gbcFormulario.anchor = GridBagConstraints.WEST;
	
	    // label selecciona equipo
	    
	    gbcFormulario.gridx = 0;
	    
	    gbcFormulario.gridy = 0;
	    
	    JLabel equipolbl = new JLabel("Nombre equipo:");
	    
	    panel.add(equipolbl, gbcFormulario);
	
	    // combo equipos
	    
	    gbcFormulario.gridx = 1;
	    
	    gbcFormulario.fill = GridBagConstraints.HORIZONTAL;
	    
	    JTextField nombreEquipoTxt = new JTextField(20); 
	    
	    panel.add(nombreEquipoTxt, gbcFormulario);
	    
	    //label nombre
	    
	    gbcFormulario.gridx = 2;
	    
	    gbcFormulario.gridy = 0;
	    
	    JLabel ciudadLbl = new JLabel("Ciudad:");
	    
	    panel.add(ciudadLbl, gbcFormulario);
	    
	    //txt ciudad
	    
	    gbcFormulario.gridx = 3;
	    
	    gbcFormulario.gridy = 0;
	    
	    JTextField ciudadTxt = new JTextField(15);
	    
	    panel.add(ciudadTxt, gbcFormulario);
	    
	    //entrenador lbl
	    
	    gbcFormulario.gridx = 0;
	    
	    gbcFormulario.gridy = 1;
	    
	    JLabel entrenadorLbl = new JLabel("Entrenador:");
	    
	    panel.add(entrenadorLbl, gbcFormulario);
	    
	    //entrenador txt
	    
	    gbcFormulario.gridx = 1;
	    
	    gbcFormulario.gridy = 1;
	    
	    JTextField entrenadorTxt = new JTextField(20);
	    
	    panel.add(entrenadorTxt, gbcFormulario);
	    
	    
	    //JButton añadir
	    
	    gbcFormulario.gridx = 0;
	    
	    gbcFormulario.gridy = 2;
	    
	    JButton addEquipo = new JButton("Añadir");
	    
	    panel.add(addEquipo, gbcFormulario);
	    
	    //JButton actualizar
	    
	    gbcFormulario.gridx = 1;
	    
	    gbcFormulario.gridy = 2;
	    
	    JButton modificarEquipoBtn = new JButton("Modificar");
	    
	    panel.add(modificarEquipoBtn, gbcFormulario);
	    
	    //JButton Listar
	    
	    gbcFormulario.gridx = 2;
	    
	    gbcFormulario.gridy = 2;
	    
	    JButton listarEquipoBtn = new JButton("Listar");
	    
	    panel.add(listarEquipoBtn, gbcFormulario);
	    
	    //JButton Eliminar
	    
	    gbcFormulario.gridx = 3;
	    
	    gbcFormulario.gridy = 2;
	    
	    JButton eliminarEquipoBtn = new JButton("Eliminar");
	    
	    panel.add(eliminarEquipoBtn, gbcFormulario);
	    
	    //JButton Limpiar
	    
	    gbcFormulario.gridx = 4;
	    
	    gbcFormulario.gridy = 2;
	    
	    gbcFormulario.weightx = 1;
	    
	    JButton limpiarEquipoBtn = new JButton("Limpiar");
	    
	    panel.add(limpiarEquipoBtn, gbcFormulario);
	    
	    return panel;
	}
	
	private JPanel tablaJugadores() {
		//TODO: Mostraremos la tabla equipos recuperandola desde la BBDD
		
		JPanel panel = new JPanel(new GridBagLayout());
		
		
		return panel;
	}

}


