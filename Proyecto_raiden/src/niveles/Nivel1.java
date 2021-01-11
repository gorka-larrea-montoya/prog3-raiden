package niveles;

import java.awt.Color;

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
		setHandler(handler); 
		setHandler(getHandler());
		
		handler.addObject(new Enemy(250, 0, 0, 0, ID.Enemy, handler));
	}
}
