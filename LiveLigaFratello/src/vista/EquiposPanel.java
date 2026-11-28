package vista;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.EquipoDaoImpl;
import modelo.Equipo;

public class EquiposPanel extends FondoPanel{
	
	private JTextField nombreEquipoTxt;
	private JTextField ciudadTxt;
	private JTextField entrenadorTxt;
	private EquipoDaoImpl equipoDao = new EquipoDaoImpl();
	private JTable tablaEquipos;
	private DefaultTableModel modeloTabla;
	
	public EquiposPanel (MainFrame frame) {
		
		super("/imagenes/fondo_blanco.jpg", 100);
		
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
		
		gbcFormulario.gridy = 1;
		
		gbcFormulario.anchor = GridBagConstraints.NORTH;
		
		gbcFormulario.weighty = 0;
		
		JPanel panelFormulario = formularioJEquipos(frame);
		
		add(panelFormulario, gbcFormulario);
		
	
		GridBagConstraints gbcTabla = new GridBagConstraints();

		gbcTabla.gridx = 0;
		
		gbcTabla.gridy = 2;
		
		gbcTabla.fill = GridBagConstraints.BOTH;
		
		gbcTabla.weightx = 1;
		
		gbcTabla.weighty = 1;
		
		gbcTabla.insets = new Insets(10, 20, 40, 20);

		add(tablaEquipos(), gbcTabla);

		cargarEquipos();
		
		seleccionarEquipo();
	
	}

	private JPanel formularioJEquipos(MainFrame frame) {
	
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
	    
	    nombreEquipoTxt = new JTextField(20); 
	    
	    panel.add(nombreEquipoTxt, gbcFormulario);
	    
	    //label nombre
	    
	    gbcFormulario.gridx = 2;
	    
	    gbcFormulario.gridy = 0;
	    
	    JLabel ciudadLbl = new JLabel("Ciudad:");
	    
	    panel.add(ciudadLbl, gbcFormulario);
	    
	    //txt ciudad
	    
	    gbcFormulario.gridx = 3;
	    
	    gbcFormulario.gridy = 0;
	    
	    ciudadTxt = new JTextField(15);
	    
	    panel.add(ciudadTxt, gbcFormulario);
	    
	    //entrenador lbl
	    
	    gbcFormulario.gridx = 0;
	    
	    gbcFormulario.gridy = 1;
	    
	    JLabel entrenadorLbl = new JLabel("Entrenador:");
	    
	    panel.add(entrenadorLbl, gbcFormulario);
	    
	    //entrenador txt
	    
	    gbcFormulario.gridx = 1;
	    
	    gbcFormulario.gridy = 1;
	    
	    entrenadorTxt = new JTextField(20);
	    
	    panel.add(entrenadorTxt, gbcFormulario);
	    
	    
	    //JButton añadir
	    
	    gbcFormulario.gridx = 0;
	    
	    gbcFormulario.gridy = 2;
	    
	    JButton anadirEquipoBtn = new JButton("Añadir");
	    
	    anadirEquipoBtn.setEnabled(frame.esAdminActual());
	    
	    panel.add(anadirEquipoBtn, gbcFormulario);
	    
	    anadirEquipoBtn.addActionListener(e -> agregarEquipo());
	    
	    //JButton actualizar
	    
	    gbcFormulario.gridx = 1;
	    
	    gbcFormulario.gridy = 2;
	    
	    JButton modificarEquipoBtn = new JButton("Modificar");
	    
	    modificarEquipoBtn.setEnabled(frame.esAdminActual());
	    
	    panel.add(modificarEquipoBtn, gbcFormulario);
	    
	    modificarEquipoBtn.addActionListener(e -> modificarEquipo());
	    
	    //JButton Listar
	    
	    gbcFormulario.gridx = 2;
	    
	    gbcFormulario.gridy = 2;
	    
	    JButton listarEquipoBtn = new JButton("Listar");
	    
	    panel.add(listarEquipoBtn, gbcFormulario);
	    
	    listarEquipoBtn.addActionListener(e -> cargarEquipos());
	    
	    //JButton Eliminar
	    
	    gbcFormulario.gridx = 3;
	    
	    gbcFormulario.gridy = 2;
	    
	    JButton eliminarEquipoBtn = new JButton("Eliminar");
	    
	    eliminarEquipoBtn.setEnabled(frame.esAdminActual());
	    
	    panel.add(eliminarEquipoBtn, gbcFormulario);
	    
	    eliminarEquipoBtn.addActionListener(e -> eliminarEquipo());
	    
	    //JButton Limpiar
	    
	    gbcFormulario.gridx = 4;
	    
	    gbcFormulario.gridy = 2;
	    
	    gbcFormulario.weightx = 1;
	    
	    JButton limpiarEquipoBtn = new JButton("Limpiar");
	    
	    panel.add(limpiarEquipoBtn, gbcFormulario);
	    
	    limpiarEquipoBtn.addActionListener(e -> limpiarCampos());
	    
	    return panel;
	}
	
	private JPanel tablaEquipos() {

	    JPanel panel = new JPanel(new java.awt.BorderLayout());

	    panel.setOpaque(false);

	    String[] columnas = {"ID", "Nombre", "Ciudad", "Entrenador"};

	    modeloTabla = new DefaultTableModel(columnas, 0) {

	        @Override
	        public boolean isCellEditable(int fila, int columna) {
	            return false;
	        }
	    };

	    tablaEquipos = new JTable(modeloTabla);

	    tablaEquipos.setFillsViewportHeight(true);

	    JScrollPane scroll = new JScrollPane(tablaEquipos);

	    scroll.setVerticalScrollBarPolicy(
	        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
	    );
	    
	    panel.add(scroll, java.awt.BorderLayout.CENTER);

	    return panel;
	}
	
	private void cargarEquipos() {

	    modeloTabla.setRowCount(0);

	    try {

	        List<Equipo> equipos = equipoDao.obtenerTodosLosEquipos();

	        for (Equipo equipo : equipos) {

	            Object[] fila = {
	                equipo.getId_equipo(),
	                equipo.getNombre(),
	                equipo.getCiudad(),
	                equipo.getEntrenador()
	            };

	            modeloTabla.addRow(fila);
	        }

	    } catch (SQLException e) {

	        JOptionPane.showMessageDialog(
	            this,
	            "Error al cargar los equipos: " + e.getMessage(),
	            "Error",
	            JOptionPane.ERROR_MESSAGE
	        );

	        e.printStackTrace();
	    }
	}
	
	private void seleccionarEquipo() {

	    tablaEquipos.getSelectionModel().addListSelectionListener(e -> {

	        if (!e.getValueIsAdjusting()) {

	            int fila = tablaEquipos.getSelectedRow();

	            if (fila != -1) {

	                nombreEquipoTxt.setText(modeloTabla.getValueAt(fila, 1).toString());

	                ciudadTxt.setText(modeloTabla.getValueAt(fila, 2).toString());

	                entrenadorTxt.setText(modeloTabla.getValueAt(fila, 3).toString());

	            }
	        }
	    });
	    
	}
	
	private void agregarEquipo() {

	    String nombre = nombreEquipoTxt.getText().trim();
	    String ciudad = ciudadTxt.getText().trim();
	    String entrenador = entrenadorTxt.getText().trim();

	    // Comprobamos que los campos no estén vacíos
	    if (nombre.isEmpty() || ciudad.isEmpty() || entrenador.isEmpty()) {

	        JOptionPane.showMessageDialog(
	            this,
	            "Debes rellenar todos los campos.",
	            "Campos incompletos",
	            JOptionPane.WARNING_MESSAGE
	        );

	        return;
	    }

	    try {

	        Equipo equipo = new Equipo(nombre, ciudad, entrenador);

	        equipoDao.agregarEquipo(equipo);

	        JOptionPane.showMessageDialog(
	            this,
	            "Equipo añadido correctamente.",
	            "Éxito",
	            JOptionPane.INFORMATION_MESSAGE
	        );

	        cargarEquipos();

	        limpiarCampos();

	    } catch (SQLException e) {

	        JOptionPane.showMessageDialog(
	            this,
	            "Error al añadir el equipo: " + e.getMessage(),
	            "Error",
	            JOptionPane.ERROR_MESSAGE
	        );

	        e.printStackTrace();
	    }
	}
	
	private void limpiarCampos() {

	    nombreEquipoTxt.setText("");
	    
	    ciudadTxt.setText("");
	    
	    entrenadorTxt.setText("");

	    tablaEquipos.clearSelection();
	}
	
	private void modificarEquipo() {

	    int fila = tablaEquipos.getSelectedRow();

	    if (fila == -1) {

	        JOptionPane.showMessageDialog(
	            this,
	            "Debes seleccionar un equipo de la tabla.",
	            "Equipo no seleccionado",
	            JOptionPane.WARNING_MESSAGE
	        );

	        return;
	    }

	    String nombre = nombreEquipoTxt.getText().trim();
	    String ciudad = ciudadTxt.getText().trim();
	    String entrenador = entrenadorTxt.getText().trim();

	    if (nombre.isEmpty() || ciudad.isEmpty() || entrenador.isEmpty()) {

	        JOptionPane.showMessageDialog(
	            this,
	            "Debes rellenar todos los campos.",
	            "Campos incompletos",
	            JOptionPane.WARNING_MESSAGE
	        );

	        return;
	    }

	    int id = (int) modeloTabla.getValueAt(fila, 0);

	    Equipo equipo = new Equipo(nombre, ciudad, entrenador);

	    equipo.setId_equipo(id);

	    try {

	        equipoDao.actualizarEquipo(equipo);

	        JOptionPane.showMessageDialog(
	            this,
	            "Equipo modificado correctamente.",
	            "Éxito",
	            JOptionPane.INFORMATION_MESSAGE
	        );

	        cargarEquipos();

	        limpiarCampos();

	    } catch (SQLException e) {

	        JOptionPane.showMessageDialog(
	            this,
	            "Error al modificar el equipo: " + e.getMessage(),
	            "Error",
	            JOptionPane.ERROR_MESSAGE
	        );

	        e.printStackTrace();
	    }
	}
	
	private void eliminarEquipo() {

	    int fila = tablaEquipos.getSelectedRow();

	    if (fila == -1) {

	        JOptionPane.showMessageDialog(
	            this,
	            "Tienes que seleccionar un equipo de la tabla",
	            "Equipo no seleccionado",
	            JOptionPane.WARNING_MESSAGE
	        );

	        return;
	    }

	    int respuesta = JOptionPane.showConfirmDialog(
	        this,
	        "¿Estás seguro de que quieres eliminar este equipo?",
	        "Confirmar eliminación",
	        JOptionPane.YES_NO_OPTION,
	        JOptionPane.WARNING_MESSAGE
	    );

	    if (respuesta == JOptionPane.YES_OPTION) {

	        int id = (int) modeloTabla.getValueAt(fila, 0);

	        try {

	            equipoDao.eliminarEquipo(id);

	            JOptionPane.showMessageDialog(
	                this,
	                "Equipo eliminado correctamente.",
	                "Éxito",
	                JOptionPane.INFORMATION_MESSAGE
	            );

	            cargarEquipos();

	            limpiarCampos();

	        } catch (SQLException e) {

	            JOptionPane.showMessageDialog(
	                this,
	                "Error al eliminar el equipo: " + e.getMessage(),
	                "Error",
	                JOptionPane.ERROR_MESSAGE
	            );

	            e.printStackTrace();
	        }
	    }
	}

}


