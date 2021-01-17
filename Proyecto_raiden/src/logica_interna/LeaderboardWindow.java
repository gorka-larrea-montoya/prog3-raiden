package logica_interna;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ventanas.VentanaPrincipal;

public class LeaderboardWindow extends JFrame{
	JPanel panel = new JPanel();
	public LeaderboardWindow() {
		
	
		setLayout(new FlowLayout());
		panel.add(VentanaPrincipal.getLeadBoardJScroll());
		this.add(panel);
		this.setVisible(true);
		setSize(800,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(true);
		
	}

}