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
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame{
	private static final long serialVersionUID = -7674724656858770912L;



	public VentanaPrincipal() {
		setLayout(new BorderLayout());
		
		setTitle("Raiden_Reborn");
		JPanel panelBotonesInicio = new JPanel();
		panelBotonesInicio.setLayout(new GridLayout(1,3));
		
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
		
		JButton botonIniciarNivelNegro = new JButton("Nivel Negro");
		botonIniciarNivelNegro.setSize(20, 60);
		botonIniciarNivelNegro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NivelNegro();
			}
		});
		
		
		JButton botonIniciarNivelRojo = new JButton("Nivel Rojo");
		botonIniciarNivelRojo.setSize(20, 60);
		botonIniciarNivelRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NivelRojo();
			}
		});
		
		JButton botonPuntuaciones = new JButton("Mejores Puntuaciones");
		botonPuntuaciones.setSize(20, 60);
		
		JButton botonAjustes = new JButton("Ajustes");
		botonAjustes.setSize(20, 60);
		
		
		panelBotonesInicio.add(botonIniciarNivelRojo);
		panelBotonesInicio.add(botonPuntuaciones);
		panelBotonesInicio.add(botonAjustes);
		panelBotonesInicio.add(botonIniciarNivelNegro);
		
		botonConfirmarNombre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nombreJug = new String(nombreField.getText());
				labelNombreResp.setText(nombreJug);
				repaint();
			}
		});
		
		this.add(panelNombre, BorderLayout.CENTER);
		this.add(panelBotonesInicio, BorderLayout.SOUTH);
		this.setVisible(true);
		setSize(800,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(true);
		
		}
	
		

	public static void main(String[] args) {
		new VentanaPrincipal();
	}


}	//comentario..prueba
