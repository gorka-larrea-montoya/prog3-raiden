import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class Ventana_Ejemplo extends JFrame{
	JLabel textoEjemplo;
	
	public Ventana_Ejemplo() {
		JLabel textoEjemplo = new JLabel("Esta ventana está en progreso por ahora");
		add(textoEjemplo);
		setVisible(true);
		setSize(300,200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(true);
	}
	public static void main(String[] args) {
		new Ventana_Ejemplo();
	}
}
