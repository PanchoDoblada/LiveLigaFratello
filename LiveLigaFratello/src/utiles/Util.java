package utiles;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Util {

	public static Icon redimensionarIcono(String url, int ancho, int alto) {
		
		ImageIcon icono = new ImageIcon(Util.class.getResource(url));
		
		Image imagen = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		
		ImageIcon imagenLista = new ImageIcon(imagen);
		
		return imagenLista;
	}
}
