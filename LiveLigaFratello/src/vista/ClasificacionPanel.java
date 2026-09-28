package vista;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClasificacionPanel extends FondoPanel{

	public ClasificacionPanel(MainFrame frame) {
		super("C:\\Users\\gabri\\fratello_workspace\\LiveLigaFratello\\src\\imagenes\\fondo_blanco.jpg");
		setOpaque(false);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbcTitulo = new GridBagConstraints();
		
		gbcTitulo.gridx = 0;
		
		gbcTitulo.gridy= 0;
		
		gbcTitulo.anchor = GridBagConstraints.NORTH;
		
		gbcTitulo.insets = new Insets(20, 0, 10, 0);
		
		JLabel tituloJugadores = new JLabel("Clasificación");
		
		tituloJugadores.setFont(new Font("Arial", Font.BOLD, 22));
		
		tituloJugadores.setHorizontalAlignment(JLabel.CENTER);
		
		add(tituloJugadores, gbcTitulo);
		
		
		GridBagConstraints gbcFormulario = new GridBagConstraints();
		
		gbcFormulario.gridx = 0;
		
		gbcFormulario.gridy= 1;
		
		gbcFormulario.anchor = GridBagConstraints.NORTH;
		
		gbcFormulario.weighty= 1;
		
		
		
	}

}
