package vista;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoPanel extends JPanel{
	
	private Image imagenFondo;
	
	public FondoPanel(String rutaImg) {
		
		imagenFondo = new ImageIcon(rutaImg).getImage();
		
		setOpaque(false);
	}
	
	 @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }
	
	
}
