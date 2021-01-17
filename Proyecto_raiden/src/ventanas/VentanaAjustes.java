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
JLabel labelControlesShoot;

int inputUp;
int inputRight;
int inputLeft;
int inputDown;
int inputShoot;

JPanel panelbotones;
JButton buttonRefrescar;
JButton buttonGuardar;
JButton buttonSalir;
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
		setLayout(new GridLayout(7,1));
		TextFieldControlesUp = new JTextField("Editar controles");
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
		
		panelDown.add(labelControlesDown);
		panelDown.add(TextFieldControlesDown);
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
		
		panelShoot = new JPanel();
		panelShoot.setLayout(new GridLayout(1,2));
		TextFieldControlesShoot = new JTextField("Editar el boton de disparar");
		labelControlesShoot = new JLabel("el boton de disparar es " +KeyEvent.getKeyText(inputShoot));
		labelControlesShoot.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelShoot.add(labelControlesShoot);
		panelShoot.add(TextFieldControlesShoot);
	
		add(panelShoot);
		
		panelbotones = new JPanel();
		buttonRefrescar = new JButton("VOLVER A LOS CONTROLES ORIGINALES");
		buttonGuardar = new JButton("GUARDAR");
		buttonSalir = new JButton("SALIR");
		buttonRefrescar.addActionListener(new ActionListener() {
						@Override
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		
		
		
		
		
		panelbotones.add(buttonGuardar);
		panelbotones.add(buttonRefrescar);
		panelbotones.add(buttonSalir);
		add(panelbotones);
	
	}
}
