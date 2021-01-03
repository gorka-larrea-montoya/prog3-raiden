package niveles;
import java.awt.*;
import javax.swing.*;

import logica_interna.*;

public class Ventana extends JFrame{
 
	private static final long serialVersionUID = 6147411015530214406L;
	JLabel textoEjemplo;
	
	public Ventana(int alto, int ancho,String titulo,GameMain game) {
		JFrame frame = new JFrame(titulo);
		Dimension d = new Dimension(alto, ancho);
		
		frame.setPreferredSize(d);
		frame.setMinimumSize(d);
		frame.setMaximumSize(d);
		
		frame.add(game);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) {
	//	new Ventana_Ejemplo(300,200,"pito");
	}
}
