package vista;

import javax.swing.JTextArea;

public class HistoriaPanel extends FondoPanel{

	public HistoriaPanel(MainFrame frame) {
		super("/imagenes/fondo_blanco.jpg", 100);
		
		JTextArea historiaTxt = new JTextArea();
		
		historiaTxt.setText("La liga fra");
		
		add(historiaTxt);
	}

}
