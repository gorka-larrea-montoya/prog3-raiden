package logica_interna;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

import niveles.VentanaPrincipal;

public class LeaderboardWindow extends JFrame{
	JPanel panel = new JPanel();
	public LeaderboardWindow() {
		
	
		setLayout(new FlowLayout());
		panel.add(VentanaPrincipal.leadboardTable);
		this.add(panel);
		this.setVisible(true);
		setSize(800,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(true);
		
	}

}