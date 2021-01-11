package niveles;

import java.awt.Color;
import java.util.logging.Level;

import logica_interna.*;

public class Nivel1 extends GameMain{
	PlayerObject player;
	
	private String saveDataPath;
	private String fileName = "SaveData";
	
	public Nivel1(String nomString) {
		handler = new GameHandler();
		this.setColortest(new Color(0, 0, 10));
		new Ventana(1000, 600, "Nivel 2", this);
		//this.paint();
		start();
		this.addKeyListener(new Inputs(getHandler()));
		setHandler(handler); 
		setHandler(getHandler());
		player = new PlayerObject(300, 300, getHandler(), nomString, 100, 0,0);
		handler.addObject(player);
		
		
		
	}
	@Override
	public void generateEnemies() {
		if (this.contadorGuion == 300) {
			System.out.println("aquí habria que meter los bichos");
			handler.addObject(new Enemy(250, 0, 0, 6, ID.Enemy, handler) {
				@Override public void move() {
					handler.handlerlog(Level.INFO, "El Enemy que estaba en"+ x + ","+ y +"se mueve a " + ((int)getVelX()+getX())+","+((int)getVelY()+getY()));
					setX((int)getVelX()+getX());
					setY((int)getVelY()+getY());
				}
			});
		}
	}
}
