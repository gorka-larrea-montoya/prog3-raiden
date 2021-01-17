package niveles;

import java.awt.Color;
import java.awt.Window;
import java.util.logging.Level;

import logica_interna.*;
import ventanas.Ventana;

public class Nivel1 extends GameMain{
	PlayerObject player;
	
	private String saveDataPath;
	private String fileName = "SaveData";
	
	public Nivel1(String nomString) {
		handler = new GameHandler();
		this.setColortest(new Color(0, 0, 10));
		new Ventana(1000, 600, "Nivel 1", this);
		//this.paint();
		start();
		this.addKeyListener(new Inputs(getHandler()));
		setHandler(handler); 
		setHandler(getHandler());
		player = new PlayerObject(300, 300, getHandler(), nomString, 100, 0,0);
		handler.addObject(player);
		
		
		
	}@Override
	public void generateEnemies() {
		switch (contadorGuion) {
		case 60: {
			System.out.println("aquí habria que meter los bichos");
			System.out.println("aquí habria que meter los bichos");
			handler.addObject(new Enemy(250, 0, 0, 6, ID.Enemy, handler) {
				@Override
				public void move() {
					if (velY>0.3) {
						velY = (float) (velY-0.1);
					}
					setX(getVelX()+getX());
					setY(getVelY()+getY());
				}
			});
			handler.addObject(new Enemy(600, 0, 0, 6, ID.Enemy, handler) {
				@Override
				public void move() {
					if (velY>0.3) {
						velY = (float) (velY-0.1);
					}
					if (velY <= 0.5) {
						if (getX() <100) {
							setVelX(3);
						}else if (getX()>550) {
							setVelX(-3);
						}
					}
					setX(getVelX()+getX());
					setY(getVelY()+getY());

				}
			}
					);
		}

		}
	}

	/*
	@Override
	public void generateEnemies() {
		if (this.contadorGuion == 60) {
			System.out.println("aquí habria que meter los bichos");
			handler.addObject(new Enemy(250, 0, 0, 6, ID.Enemy, handler) {
				@Override
				public void move() {
					if (velY>0.3) {
						velY = (float) (velY-0.1);
					}
					setX(getVelX()+getX());
					setY(getVelY()+getY());
				}
			});
			handler.addObject(new Enemy(600, 0, 0, 6, ID.Enemy, handler) {
				@Override
				public void move() {
					if (velY>0.3) {
						velY = (float) (velY-0.1);
					}
					if (velY <= 0.5) {
						if (getX() <100) {
							setVelX(3);
						}else if (getX()>550) {
							setVelX(-3);
						}
					}
					setX(getVelX()+getX());
					setY(getVelY()+getY());
					
				}
			});
		}
	}
	*/
	public void close() {
		this.getParent().disable();

	}
}
