package niveles;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import logica_interna.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaPrincipal extends JFrame{
	private static final long serialVersionUID = -7674724656858770912L;
	protected static final GameHandler handler = null;
	public static JTable leadboardTable;
	DefaultTableModel leadBoardTableModel;
	JScrollPane leadBoardJScroll;
	String nombreDelJugador;
	


	public VentanaPrincipal() {
		setLayout(new BorderLayout());
		
		setTitle("Raiden_Reborn");
		JPanel panelBotonesInicio = new JPanel();
		panelBotonesInicio.setLayout(new GridLayout(1,4));
		
		JPanel panelNombre = new JPanel();
		panelNombre.setLayout(new FlowLayout());
		
		JLabel lNombre = new JLabel("Nombre: ");
		lNombre.setSize(50, 20);
		
		JTextField nombreField = new JTextField("Jugador 1");
		
		//nombreField.setSize(200, 300);
		
		
		JButton botonConfirmarNombre = new JButton("Confirmar");
		
		JLabel labelNombreResp = new JLabel();
		

		
		panelNombre.add(lNombre);
		panelNombre.add(nombreField);
		panelNombre.add(botonConfirmarNombre);
		panelNombre.add(labelNombreResp);
		
		
		
		JButton botonNivel1 = new JButton("Nivel 1");
		botonNivel1.setSize(20, 60);
		botonNivel1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Nivel1();
			}
		});
		
		JButton botonNivel2 = new JButton("Nivel 2");
		botonNivel2.setSize(20, 60);
		botonNivel2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			//	String nombreJug = nombreField.;
				new Nivel2(nombreDelJugador);	
			}
		});
		
		JButton botonPuntuaciones = new JButton("Mejores Puntuaciones");
		botonPuntuaciones.setSize(20, 60);
		
		

        Class[] clases = {String.class, Integer.class};
        leadBoardTableModel = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return clases[columnIndex];
            }
        };
        
        leadboardTable = new JTable(leadBoardTableModel);
        leadboardTable.setEnabled(false);
        
        leadBoardTableModel.addColumn("PLAYER: ");
        leadBoardTableModel.addColumn("SCORE: ");
        
        leadBoardJScroll = new JScrollPane(leadboardTable);
        botonPuntuaciones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//add(leadboardTable);
				new LeaderboardWindow();
				
			}
		});
        

		
		JButton botonAjustes = new JButton("Ajustes");
		botonAjustes.setSize(20, 60);
		
		panelBotonesInicio.add(botonNivel1);
		panelBotonesInicio.add(botonNivel2);
		panelBotonesInicio.add(botonPuntuaciones);
		panelBotonesInicio.add(botonAjustes);
		
		botonConfirmarNombre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nombreDelJugador = nombreField.getText().toString();
				PlayerObject newPlayer = new PlayerObject(getX(),getY());
				newPlayer.setName(nombreField.getText());
				
			//	player.setName(newPlayer.getName());
				//player.setName(nombreField.getText());
				//setName(newPlayer, nombreField.getText());
				
				//PlayerObject newPlayer = new PlayerObject(getX(), getY(), handler, nombreField.getText());
				//player.setName(nombreField.getText());
				
				Object[] newPlayerSaved = {newPlayer.getName(), newPlayer.getScore()};
				setPlayerName(newPlayer);
				
                //leadBoardTableModel.addRow(leadboardTable);
				
				
				leadBoardTableModel.addRow(newPlayerSaved);
				////falta guardar nombre en jugador
				//repaint();
				
			}
			
			public String setPlayerName(PlayerObject player){
				String namme = player.getName();
				return namme;
			}
			
			public int setPlayerScore(PlayerObject player){
				int scorre = player.getScore();
				return scorre;
			}
			
		
		});
		
		this.add(panelNombre, BorderLayout.CENTER);
		this.add(panelBotonesInicio, BorderLayout.SOUTH);
		this.setVisible(true);
		setSize(800,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(true);
		
		
	
		
		}
	
		
	public String newPlayerName(String playerName_new) {
		
		return playerName_new;
	}
	
	public static void main(String[] args) {
		new VentanaPrincipal();
	}

    public static void setName(PlayerObject player, String name) {
    	player.setName(name);;
    }
}	//comentario..prueba
