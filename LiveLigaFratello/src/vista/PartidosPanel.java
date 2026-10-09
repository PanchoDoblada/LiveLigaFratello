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

public class PartidosPanel extends FondoPanel{

	public PartidosPanel(MainFrame frame) {
		super("C:\\Users\\gabri\\fratello_workspace\\LiveLigaFratello\\src\\imagenes\\fondo_blanco.jpg", 100);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbcTitulo = new GridBagConstraints();
		
		gbcTitulo.gridx = 0;
		
		gbcTitulo.gridy= 0;
		
		gbcTitulo.anchor = GridBagConstraints.NORTH;
		
		gbcTitulo.insets = new Insets(20, 0, 10, 0);
		
		JLabel tituloPartidos = new JLabel("Lista Partidos");
		
		tituloPartidos.setFont(new Font("Arial", Font.BOLD, 22));
		
		tituloPartidos.setHorizontalAlignment(JLabel.CENTER);
		
		add(tituloPartidos, gbcTitulo);
		
		
		GridBagConstraints gbcFormulario = new GridBagConstraints();
		
		gbcFormulario.gridx = 0;
		
		gbcFormulario.gridy= 1;
		
		gbcFormulario.anchor = GridBagConstraints.NORTH;
		
		gbcFormulario.weighty= 1;
		
		
		JPanel panelFormulario = formularioJPartidos();
		
		add(panelFormulario, gbcFormulario);
	}
	
	private JPanel formularioJPartidos() {
		
		JPanel panel = new JPanel(new GridBagLayout());
		
	    panel.setOpaque(false);
	
	    GridBagConstraints gbcFormulario = new GridBagConstraints();
	    
	    gbcFormulario.insets = new Insets(10, 10, 10, 10);
	    
	    gbcFormulario.anchor = GridBagConstraints.WEST;
	
	    // label equipo local
	    
	    gbcFormulario.gridx = 0;
	    
	    gbcFormulario.gridy = 0;
	    
	    JLabel locallbl = new JLabel("Equipo local:");
	    
	    panel.add(locallbl, gbcFormulario);
	
	    // combo local
	    
	    gbcFormulario.gridx = 1;
	    
	    gbcFormulario.fill = GridBagConstraints.HORIZONTAL;
	    
	    
	    
	    //TODO: rellenar con los equipos de la BBDD
	    
	    String [] local = {"Selecciona equipo"};

	    JComboBox<String> comboLocal = new JComboBox<>(local);
	    
	    panel.add(comboLocal, gbcFormulario);
	    
	    //label visitante
	    
	    gbcFormulario.gridx = 2;
	    
	    gbcFormulario.gridy = 0;
	    
	    JLabel visitanteLbl = new JLabel("Equipo Visitante:");
	    
	    panel.add(visitanteLbl, gbcFormulario);
	    
	    // combo local
	    
	    gbcFormulario.gridx = 3;
	    
	    gbcFormulario.fill = GridBagConstraints.HORIZONTAL;
	    
	    
	    
	    //TODO: rellenar con los equipos de la BBDD
	    
	    String [] visitante = {"Selecciona equipo"};

	    JComboBox<String> comboVisitantes = new JComboBox<>(visitante);
	    
	    panel.add(comboVisitantes, gbcFormulario);
	    
	    //golesLocal lbl
	    
	    gbcFormulario.gridx = 0;
	    
	    gbcFormulario.gridy = 1;
	    
	    JLabel golesLocalLbl = new JLabel("Goles local:");
	    
	    panel.add(golesLocalLbl, gbcFormulario);
	    
	    //golesLocal txt
	    
	    gbcFormulario.gridx = 1;
	    
	    gbcFormulario.gridy = 1;
	    
	    JTextField golesLocalTxt = new JTextField(20);
	    
	    panel.add(golesLocalTxt, gbcFormulario);
	    
	    //golesVisitante lbl
	    
	    gbcFormulario.gridx = 2;
	    
	    gbcFormulario.gridy = 1;
	    
	    JLabel golesVisitanteLbl = new JLabel("Goles visitante:");
	    
	    panel.add(golesVisitanteLbl, gbcFormulario);
	    
	    //golesVisitante txt
	    
	    gbcFormulario.gridx = 3;
	    
	    gbcFormulario.gridy = 1;
	    
	    JTextField golesVisitanteTxt = new JTextField(20);
	    
	    panel.add(golesVisitanteTxt, gbcFormulario);
	    
	    //jornada lbl
	    
	    gbcFormulario.gridx = 0;
	    
	    gbcFormulario.gridy = 2;
	    
	    JLabel fechaLbl = new JLabel("Jornada:");
	    
	    panel.add(fechaLbl, gbcFormulario);
	    
	    //Selector jornada
	    
	    gbcFormulario.gridx = 1;
	    
	    gbcFormulario.gridy = 2;
	    
	    JComboBox<Integer> comboJornadas = new JComboBox<>();
	    
	    for(int i = 0; i <= 26; i++) {
	    	comboJornadas.addItem(i);
	    }
	    
	    panel.add(comboJornadas, gbcFormulario);
	    
	    //JButton añadir
	    
	    gbcFormulario.gridx = 0;
	    
	    gbcFormulario.gridy = 3;
	    
	    JButton addEquipo = new JButton("Añadir");
	    
	    panel.add(addEquipo, gbcFormulario);
	    
	    //JButton actualizar
	    
	    gbcFormulario.gridx = 1;
	    
	    gbcFormulario.gridy = 3;
	    
	    JButton modificarEquipoBtn = new JButton("Modificar");
	    
	    panel.add(modificarEquipoBtn, gbcFormulario);
	    
	    //JButton Listar
	    
	    gbcFormulario.gridx = 2;
	    
	    gbcFormulario.gridy = 3;
	    
	    JButton listarEquipoBtn = new JButton("Listar");
	    
	    panel.add(listarEquipoBtn, gbcFormulario);
	    
	    //JButton Eliminar
	    
	    gbcFormulario.gridx = 3;
	    
	    gbcFormulario.gridy = 3;
	    
	    JButton eliminarEquipoBtn = new JButton("Eliminar");
	    
	    panel.add(eliminarEquipoBtn, gbcFormulario);
	    
	    //JButton Limpiar
	    
	    gbcFormulario.gridx = 4;
	    
	    gbcFormulario.gridy = 3;
	    
	    gbcFormulario.weightx = 1;
	    
	    JButton limpiarEquipoBtn = new JButton("Limpiar");
	    
	    panel.add(limpiarEquipoBtn, gbcFormulario);
	    
	    return panel;
	}
	
	private JPanel tablaPatidos() {
		//TODO: Mostraremos la tabla equipos recuperandola desde la BBDD
		
		JPanel panel = new JPanel(new GridBagLayout());
		
		
		return panel;
	}

}
