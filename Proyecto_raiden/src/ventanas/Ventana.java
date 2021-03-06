package ventanas;
import java.awt.*;
import javax.swing.*;

import logica_interna.*;

public class Ventana extends JFrame{
 
	private static final long serialVersionUID = 6147411015530214406L;
	JLabel textoEjemplo;
	
	public Ventana(int alto, int ancho,String titulo,GameMain game) {
		setIconImage(new ImageIcon("./resources/enemy1.png").getImage());
		JFrame frame = new JFrame(titulo);
		Dimension d = new Dimension(alto, ancho);
		
		frame.setPreferredSize(d);
		frame.setMinimumSize(d);
		frame.setMaximumSize(d);
		
		frame.add(game);
		frame.setResizable(false);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
	}

}
