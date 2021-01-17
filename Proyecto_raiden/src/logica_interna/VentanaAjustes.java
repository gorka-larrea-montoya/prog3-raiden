package logica_interna;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaAjustes extends JFrame {

JPanel panelDescripcion;
JLabel labelDescripcion;

JPanel panelUp;
JButton buttonControlesUp;
JLabel labelControlesUp;

JPanel panelDown;
JButton buttonControlesDown;
JLabel labelControlesDown;

JPanel panelLeft;
JButton buttonControlesLeft;
JLabel labelControlesLeft;

JPanel panelRight;
JButton buttonControlesRight;
JLabel labelControlesRight;

JPanel panelbotones;
JButton buttonGuardar;
JButton buttonDescartar;

int inputUp;
int inputRight;
int inputLeft;
int inputDown;
	public VentanaAjustes() {
		setVisible(true);
		setSize(500,300);
		setTitle("Opciones");
		setLayout(new GridLayout(6,1));
		buttonControlesUp = new JButton("Editar controles");
		buttonControlesUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addKeyListener(new KeyListener() {
					@Override
					public void keyTyped(KeyEvent e) {
						//e.getKeyCode();
						System.out.println(e.getKeyCode());
					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub						
					}

					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub						
					}
				}
						)
				;

			}
		}
				);
		panelDescripcion = new JPanel();
		panelDescripcion.add(labelDescripcion = new JLabel("Aqui puedes personalizar tu experiencia"));
		add(panelDescripcion);
		
		panelUp = new JPanel();
		panelUp.setLayout(new GridLayout(1,2));
		buttonControlesUp = new JButton("Editar el movimiento hacia arriba");
		labelControlesUp = new JLabel("el boton de arriba es"+" TODO");
		labelControlesUp.setHorizontalAlignment(SwingConstants.CENTER);
		panelUp.add(buttonControlesUp);
		panelUp.add(labelControlesUp);
		add(panelUp);
		
		panelDown = new JPanel();
		panelDown.setLayout(new GridLayout(1,2));
		buttonControlesDown = new JButton("Editar el movimiento hacia abajo");
		labelControlesDown = new JLabel("el boton de abajo es"+" TODO");
		labelControlesDown.setHorizontalAlignment(SwingConstants.CENTER);
		panelDown.add(buttonControlesDown);
		panelDown.add(labelControlesDown);
		add(panelDown);
		
		panelRight = new JPanel();
		panelRight.setLayout(new GridLayout(1,2));
		buttonControlesRight = new JButton("Editar el movimiento hacia la derecha");
		labelControlesRight = new JLabel("el boton de derecha es"+" TODO");
		labelControlesRight.setHorizontalAlignment(SwingConstants.CENTER);
		panelRight.add(buttonControlesRight);
		panelRight.add(labelControlesRight);
		add(panelRight);
		
		panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(1,2));
		buttonControlesLeft = new JButton("Editar el movimiento hacia la izquierda");
		labelControlesLeft = new JLabel("el boton de izquierda es" + " TODO");
		labelControlesLeft.setHorizontalAlignment(SwingConstants.CENTER);
		panelLeft.add(buttonControlesLeft);
		panelLeft.add(labelControlesLeft);
		add(panelLeft);
		
		
	
	}
}
