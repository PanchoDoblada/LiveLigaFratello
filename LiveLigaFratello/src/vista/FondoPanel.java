package vista;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoPanel extends JPanel{
	
	private Image imagenFondo;
	
	private float opacidad;
	
	public FondoPanel(String rutaImg, int opacidad) {
		
		imagenFondo = new ImageIcon(rutaImg).getImage();
		
		this.opacidad = opacidad/100f;
		
		setOpaque(false);
	}
	
	 @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setComposite(
	        AlphaComposite.getInstance(
	            AlphaComposite.SRC_OVER,
	            opacidad
	        )
        );
        
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }
	
	
}
