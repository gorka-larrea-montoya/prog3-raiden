package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;

import javax.swing.*;

import propiedades.myProperties;

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

Properties prop;
	public VentanaAjustes() {
		try(InputStream input = new FileInputStream("./propiedades/config.properties")){
			prop = new Properties();
		prop.load(input);
		
		inputUp = Integer.parseInt(prop.getProperty("KeyEventUp", Integer.toString(KeyEvent.VK_W)));
		inputLeft =  Integer.parseInt(prop.getProperty("KeyEventLeft", Integer.toString(KeyEvent.VK_A)));
		inputRight =  Integer.parseInt(prop.getProperty("KeyEventRight", Integer.toString(KeyEvent.VK_D)));
		inputDown =  Integer.parseInt(prop.getProperty("KeyEventDown", Integer.toString(KeyEvent.VK_S)));
		inputShoot =  Integer.parseInt(prop.getProperty("KeyEventShoot", Integer.toString(KeyEvent.VK_SPACE)));
		}catch (Exception e) {
			System.out.println("ERROR AL LEER PROPIEDADES");
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
							prop.setProperty("KeyEventUp", Integer.toString(KeyEvent.VK_W));
							prop.setProperty("KeyEventDown", Integer.toString(KeyEvent.VK_S));
							prop.setProperty("KeyEventLeft", Integer.toString(KeyEvent.VK_A));
							prop.setProperty("KeyEventRight", Integer.toString(KeyEvent.VK_D));
							prop.setProperty("KeyEventShoot", Integer.toString(KeyEvent.VK_SPACE));
							
							inputUp = Integer.parseInt(prop.getProperty("KeyEventUp", Integer.toString(KeyEvent.VK_W)));
							inputLeft =  Integer.parseInt(prop.getProperty("KeyEventLeft", Integer.toString(KeyEvent.VK_A)));
							inputRight =  Integer.parseInt(prop.getProperty("KeyEventRight", Integer.toString(KeyEvent.VK_D)));
							inputDown =  Integer.parseInt(prop.getProperty("KeyEventDown", Integer.toString(KeyEvent.VK_S)));
							inputShoot =  Integer.parseInt(prop.getProperty("KeyEventShoot", Integer.toString(KeyEvent.VK_SPACE)));
							
							labelControlesUp.setText("el boton de arriba es "+KeyEvent.getKeyText(inputUp));
							labelControlesDown.setText("el boton de abajo es "+KeyEvent.getKeyText(inputDown));
							labelControlesLeft.setText("el boton de izquierda es " +KeyEvent.getKeyText(inputLeft));
							labelControlesRight.setText("el boton la derecha es "+KeyEvent.getKeyText(inputRight));
							labelControlesShoot.setText("el boton de disparar es " +KeyEvent.getKeyText(inputShoot));
							
							TextFieldControlesUp = new JTextField("Editar el movimiento hacia arriba");
							TextFieldControlesDown = new JTextField("Editar el movimiento hacia abajo");
							TextFieldControlesLeft = new JTextField("Editar el movimiento hacia la izquierda");
							TextFieldControlesRight = new JTextField("Editar el movimiento hacia la derecha");
							TextFieldControlesShoot = new JTextField("Editar el boton de disparar");
							
							try (OutputStream output = new FileOutputStream("./propiedades/config.properties")){
								//GUARDA LAS PROPIEDADES
								prop.store(output, null);
								System.out.println("culo");
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} catch (Exception e2) {
								e2.printStackTrace();
							}
						
							
			}
		});
		buttonGuardar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				char up =TextFieldControlesUp.getText().charAt(0);
				inputUp = KeyEvent.getExtendedKeyCodeForChar(up);
				labelControlesUp.setText("el boton de arriba es "+KeyEvent.getKeyText(inputUp));
				prop.setProperty("KeyEventUp", Integer.toString(inputUp));
				
				char down =TextFieldControlesDown.getText().charAt(0);
				inputDown = KeyEvent.getExtendedKeyCodeForChar(down);
				labelControlesDown.setText("el boton de abajo es "+KeyEvent.getKeyText(inputDown));
				prop.setProperty("KeyEventDown", Integer.toString(inputDown));
				
				char left = TextFieldControlesLeft.getText().charAt(0);
				inputLeft = KeyEvent.getExtendedKeyCodeForChar(left);
				labelControlesLeft.setText("el boton de la izquierda es "+KeyEvent.getKeyText(inputLeft));
				prop.setProperty("KeyEventLeft", Integer.toString(inputLeft));
				
				char right =TextFieldControlesRight.getText().charAt(0);
				inputRight = KeyEvent.getExtendedKeyCodeForChar(right);
				labelControlesRight.setText("el boton la derecha es "+KeyEvent.getKeyText(inputRight));
				prop.setProperty("KeyEventRight", Integer.toString(inputRight));
				
				char shoot =TextFieldControlesShoot.getText().charAt(0);
				inputShoot = KeyEvent.getExtendedKeyCodeForChar(shoot);
				labelControlesShoot.setText("el boton de disparar es "+KeyEvent.getKeyText(inputShoot));
				prop.setProperty("KeyEventShoot", Integer.toString(inputShoot));
				
				try (OutputStream output = new FileOutputStream("./propiedades/config.properties")){
					//GUARDA LAS PROPIEDADES
					prop.store(output, null);
					System.out.println("culo");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});


		
		
		
		panelbotones.add(buttonGuardar);
		panelbotones.add(buttonRefrescar);
		add(panelbotones);
	
	}
}
