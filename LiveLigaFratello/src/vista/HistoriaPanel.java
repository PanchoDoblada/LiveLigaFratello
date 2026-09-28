package vista;

import javax.swing.JTextArea;

public class HistoriaPanel extends FondoPanel{

	public HistoriaPanel(MainFrame frame) {
		super("C:\\Users\\gabri\\fratello_workspace\\LiveLigaFratello\\src\\imagenes\\fondo_blanco.jpg", 20);
		
		JTextArea historiaTxt = new JTextArea();
		
		historiaTxt.setText("La liga fra");
		
		add(historiaTxt);
	}

}
