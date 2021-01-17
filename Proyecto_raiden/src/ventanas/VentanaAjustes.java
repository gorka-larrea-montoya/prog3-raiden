package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;

import javax.swing.*;

public class VentanaAjustes extends JFrame {

JPanel panelDescripcion;
JLabel labelDescripcion;

JPanel panelUp;
JTextField TextFieldControlesUp;
JLabel labelControlesUp;

JPanel panelDown;
JTextField TextFieldControlesDown;
JLabel labelControlesDown;

JPanel panelLeft;
JTextField TextFieldControlesLeft;
JLabel labelControlesLeft;

JPanel panelRight;
JTextField TextFieldControlesRight;
JLabel labelControlesRight;

JPanel panelShoot;
JTextField TextFieldControlesShoot;
JLabel labelControles;


JPanel panelbotones;
JTextField TextFieldGuardar;
JTextField TextFieldDescartar;

int inputUp;
int inputRight;
int inputLeft;
int inputDown;
int inputShoot;
	public VentanaAjustes() {
		try(InputStream input = new FileInputStream("./propiedades/config.properties")){
			Properties prop = new Properties();
		prop.load(input);
		
		inputUp = Integer.parseInt(prop.getProperty("KeyEventUp", Integer.toString(KeyEvent.VK_W)));
		inputLeft =  Integer.parseInt(prop.getProperty("KeyEventLeft", Integer.toString(KeyEvent.VK_A)));
		inputRight =  Integer.parseInt(prop.getProperty("KeyEventRight", Integer.toString(KeyEvent.VK_D)));
		inputDown =  Integer.parseInt(prop.getProperty("KeyEventDown", Integer.toString(KeyEvent.VK_S)));
		inputShoot =  Integer.parseInt(prop.getProperty("KeyEventShoot", Integer.toString(KeyEvent.VK_SPACE)));
		}catch (Exception e) {
			//handler.handlerlog(Level.WARNING, "Ha habido un error al cargar los Inputs, se han retornado a su configuración original(WASD)");
			inputUp = KeyEvent.VK_W;
			inputLeft = KeyEvent.VK_A;
			inputRight = KeyEvent.VK_D;
			inputDown = KeyEvent.VK_S;
			inputShoot = KeyEvent.VK_SPACE;
		}
		setVisible(true);
		setSize(500,300);
		setTitle("Opciones");
		setLayout(new GridLayout(6,1));
		TextFieldControlesUp = new JTextField("Editar controles");
		TextFieldControlesUp.addActionListener(new ActionListener() {

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
		TextFieldControlesUp = new JTextField("Editar el movimiento hacia arriba");
		labelControlesUp = new JLabel("el boton de arriba es "+KeyEvent.getKeyText(inputUp));
		labelControlesUp.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelUp.add(labelControlesUp);
		panelUp.add(TextFieldControlesUp);
		
		add(panelUp);
		
		panelDown = new JPanel();
		panelDown.setLayout(new GridLayout(1,2));
		TextFieldControlesDown = new JTextField("Editar el movimiento hacia abajo");
		labelControlesDown = new JLabel("el boton de abajo es "+KeyEvent.getKeyText(inputDown));
		labelControlesDown.setHorizontalAlignment(SwingConstants.CENTER);
		panelDown.add(TextFieldControlesDown);
		panelDown.add(labelControlesDown);
		add(panelDown);
		
		panelRight = new JPanel();
		panelRight.setLayout(new GridLayout(1,2));
		TextFieldControlesRight = new JTextField("Editar el movimiento hacia la derecha");
		labelControlesRight = new JLabel("el boton de derecha es "+KeyEvent.getKeyText(inputRight));
		labelControlesRight.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelRight.add(labelControlesRight);
		panelRight.add(TextFieldControlesRight);
		
		add(panelRight);
		
		panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(1,2));
		TextFieldControlesLeft = new JTextField("Editar el movimiento hacia la izquierda");
		labelControlesLeft = new JLabel("el boton de izquierda es " +KeyEvent.getKeyText(inputLeft));
		labelControlesLeft.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelLeft.add(labelControlesLeft);
		panelLeft.add(TextFieldControlesLeft);
	
		add(panelLeft);
		
		panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(1,2));
		TextFieldControlesLeft = new JTextField("Editar el movimiento hacia la izquierda");
		labelControlesLeft = new JLabel("el boton de izquierda es " +KeyEvent.getKeyText(inputLeft));
		labelControlesLeft.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelLeft.add(labelControlesLeft);
		panelLeft.add(TextFieldControlesLeft);
	
		add(panelLeft);
		
		
	
	}
}
