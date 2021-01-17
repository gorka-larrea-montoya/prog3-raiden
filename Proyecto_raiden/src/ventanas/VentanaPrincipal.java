package ventanas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.io.File;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import logica_interna.*;
import database.DBException;
import database.DBManager;
import niveles.Nivel1;
import niveles.Nivel2;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaPrincipal extends JFrame{
	private static final long serialVersionUID = -7674724656858770912L;
	protected static final GameHandler handler = null;
	public static JTable leadboardTable;
	DefaultTableModel leadBoardTableModel;
	private static JScrollPane leadBoardJScroll;
	String nombreDelJugador;
	JPanel panelBotonesInicio;
	JPanel panelNombre;
	JLabel lNombre;
	JTextField nombreField;
	JButton botonConfirmarNombre;
	JLabel labelNombreResp;
	JButton botonNivel1;
	JButton botonNivel2;
	JButton botonPuntuaciones;
	JButton botonAjustes;
	
	public static List<String> partidasJugadas;

	public static DBManager databaseManager;
	
	
	Font fuente = new Font("Serif", Font.BOLD,16);
	public VentanaPrincipal() throws DBException {
		
		databaseManager = new DBManager();
		databaseManager.open();
		databaseManager.createNewTable();
		
		partidasJugadas = new ArrayList<String>();
		
		setIconImage(new ImageIcon("./resources/enemy1.png").getImage());
		setLayout(new BorderLayout());
		
		setTitle("Raiden_Reborn");
		setBackground(Color.black);
		panelBotonesInicio = new JPanel();
		panelBotonesInicio.setLayout(new GridLayout(1,4));
		panelBotonesInicio.setBackground(Color.black);
		
		panelNombre = new JPanel();
		panelNombre.setLayout(new FlowLayout());
		
		lNombre = new JLabel("NOMBRE: ");
		lNombre.setForeground(Color.white);
		lNombre.setOpaque(true);
		lNombre.setBackground(Color.BLACK);
		lNombre.setFont(fuente);
		lNombre.setSize(50, 20);
		getContentPane().setBackground(Color.black);
		nombreField = new JTextField("Jugador 1");
		
		
		//nombreField.setSize(200, 300);
		
		panelNombre.setBackground(null);
		botonConfirmarNombre = new JButton("CONFIRMAR");
		botonConfirmarNombre.setFont(fuente);
		botonConfirmarNombre.setBackground(Color.BLACK);
		botonConfirmarNombre.setForeground(Color.white);
		
		labelNombreResp = new JLabel();

		panelNombre.add(lNombre);
		panelNombre.add(nombreField);
		panelNombre.add(botonConfirmarNombre);
		panelNombre.add(labelNombreResp);
		
		
		
		botonNivel1 = new JButton("NIVEL 1");
		botonNivel1.setBackground(Color.black);
		botonNivel1.setForeground(Color.white);
		botonNivel1.setFont(fuente);
		botonNivel1.setSize(20, 60);
		botonNivel1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Nivel1(nombreDelJugador);
			}
		});
		
		botonNivel2 = new JButton("NIVEL 2");
		botonNivel2.setSize(20, 60);
		botonNivel2.setBackground(Color.black);
		botonNivel2.setForeground(Color.white);
		botonNivel2.setFont(fuente);
		botonNivel2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			//	String nombreJug = nombreField.;
				new Nivel2(nombreDelJugador);	
			}
		});
		
		botonPuntuaciones = new JButton("PUNTUACIONES");
		botonPuntuaciones.setSize(20, 60);
		botonPuntuaciones.setBackground(Color.black);
		botonPuntuaciones.setForeground(Color.white);
		botonPuntuaciones.setFont(fuente);
		

        Class[] clases = {String.class, Integer.class};
        leadBoardTableModel = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return clases[columnIndex];
            }
        };
        
        leadboardTable = new JTable(leadBoardTableModel);
        leadboardTable.setEnabled(false);
        leadboardTable.setDragEnabled(false);
        leadboardTable.setColumnSelectionAllowed(false);
        
        leadBoardTableModel.addColumn("PLAYER: ");
        leadBoardTableModel.addColumn("SCORE: ");
        
        setLeadBoardJScroll(new JScrollPane(leadboardTable));
        botonPuntuaciones.addActionListener(new ActionListener() {
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				//add(leadboardTable);
				
				try {
					databaseManager.fillLeaderboard();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/*
				for(String s: VentanaPrincipal.partidasJugadas) {
					leadBoardTableModel.addRow(s.split(","));
				}
				*/
				new LeaderboardWindow();
				
			}
		});
        
      //  public PlayerObject readyPlayer(new Pl) {
     //   	return;
     //   };
        

		
		botonAjustes = new JButton("AJUSTES");
		botonAjustes.setBackground(Color.black);
		botonAjustes.setForeground(Color.white);
		botonAjustes.setFont(fuente);
		botonAjustes.setSize(20, 60);
		botonAjustes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaAjustes();		
			}
		});
		
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
		
		this.add(panelNombre, BorderLayout.NORTH);
		this.add(new PaintImage("./resources/Final2.png"), BorderLayout.CENTER);
		this.add(panelBotonesInicio, BorderLayout.SOUTH);
		this.setVisible(true);
		setSize(800,550);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setBackground(Color.black);
		
	
		
		}
	
		
	public String newPlayerName(String playerName_new) {
		
		return playerName_new;
	}
	
	public static void main(String[] args) {
		try {
			new VentanaPrincipal();
		} catch (DBException e) {
			System.out.println("ERROR AL ABRIR");
			e.printStackTrace();
		}
	}

    public static void setName(PlayerObject player, String name) {
    	player.setName(name);;
    }


	public static JScrollPane getLeadBoardJScroll() {
		return leadBoardJScroll;
	}


	public void setLeadBoardJScroll(JScrollPane leadBoardJScroll) {
		this.leadBoardJScroll = leadBoardJScroll;
	}
}	//comentario..prueba
