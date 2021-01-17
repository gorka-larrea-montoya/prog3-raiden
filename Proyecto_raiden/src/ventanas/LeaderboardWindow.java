package ventanas;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
import database.DBException;
 
public class LeaderboardWindow extends JFrame{
	JPanel panel;
	JPanel panelReset;
	JButton botonReset = new JButton("Resetear Puntuacioneses");
	JButton yesButton;
	JButton noButton;
	JOptionPane jPane;
 
	JButton [] options = {yesButton, noButton};
 
	int[] optt = {0,1};
	public LeaderboardWindow() {
 
		yesButton = new JButton("Si");
		noButton = new JButton("No");
 
		panel = new JPanel();
		panelReset = new JPanel();
 
 
		panelReset.add(botonReset);
		setLayout(new BorderLayout());
		panel.add(VentanaPrincipal.leadBoardJScroll);
		this.add(panel,BorderLayout.CENTER);
		this.add(panelReset, BorderLayout.SOUTH);
		this.setVisible(true);
		setSize(800,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(true);
 
		botonReset.addActionListener(new ActionListener() {
 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String message = "¿Seguro que quiere resetear la tabla? "
						+ "Se eliminarán para siempre todos los registros. ";
				//jPane = new JOptionPane();
 
				JOptionPane.showOptionDialog(null, 
				        message, 
				        "Leaderboard Reset", 
				        JOptionPane.YES_NO_CANCEL_OPTION, 
				        JOptionPane.INFORMATION_MESSAGE, 
				        null, 
				        new String[]{"Si", "No"}, // this is the array
				        "default");
 
 
 
 
 
			}
		});
 
	}
 
}