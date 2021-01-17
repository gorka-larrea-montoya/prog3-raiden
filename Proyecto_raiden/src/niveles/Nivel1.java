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
		switch(contadorGuion) {
		case 60:
			System.out.println("aquí habria que meter los bichos");
			handler.addObject(new Enemy(120, 0, 1.5, 3.2, ID.Enemy, handler));
			handler.addObject(new Enemy(512, 0,-1.1, 1.2, ID.Enemy, handler));
			handler.addObject(new Enemy(250, 0, 0, 6, ID.Enemy, handler) {
				@Override
				public void move() {
					if (velY>0.3) {
						velY = (float) (velY-0.1);
					}
					if (velY <= 0.5) {
						if (getX() >200) {
							setVelX(3);
						}else if (getX()<550) {
							setVelX(-3);
						}
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
			break;
		case 200:
			handler.addObject(new Enemy(120, 0, 1.5, 3.2, ID.Enemy, handler));
			handler.addObject(new Enemy(300, 0,-2.1, 1.2, ID.Enemy, handler));
			handler.addObject(new Enemy(250, 0, 0, 5, ID.Enemy, handler) {
				@Override
				public void move() {
					if (velY>0.3) {
						velY = (float) (velY-0.1);
					}
					if (velY <= 0.5) {
						if (getX() >200) {
							setVelX(3);
						}else if (getX()<550) {
							setVelX(-3);
						}
					}
					setX(getVelX()+getX());
					setY(getVelY()+getY());
				}
			});
			handler.addObject(new Enemy(600, 0, 0, 4, ID.Enemy, handler) {
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
			handler.addObject(new Enemy(333, 1, 1, 3, ID.Enemy, handler) {
				@Override
				public void move() {
					if (velY>0.4) {
						velY = (float) (velY-0.1);
					}
					if (velY <= 0.6) {
						if (getX() >200) {
							setVelX(3);
						}else if (getX()<550) {
							setVelX(-3);
						}
					}
					setX(getVelX()+getX());
					setY(getVelY()+getY());
				}
			});
			handler.addObject(new Enemy(400, 100, 0, 4, ID.Enemy, handler) {
				@Override
				public void move() {
					if (velY>0.4) {
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
			
			break;
		case 600:
			handler.addObject(new Enemy(120, 0, 1.5, 3.2, ID.Enemy, handler));
			handler.addObject(new Enemy(300, 0,-2.1, 1.2, ID.Enemy, handler));
			handler.addObject(new Enemy(400, 0,2.1, 1.6, ID.Enemy, handler));
			handler.addObject(new Enemy(500, 0,-1.01, 1.4, ID.Enemy, handler));
			handler.addObject(new Enemy(270, 0,-1.01, 1.4, ID.Enemy, handler));
			handler.addObject(new Enemy(250, 0, 0, 5, ID.Enemy, handler) {
				@Override
				public void move() {
					if (velY>0.3) {
						velY = (float) (velY-0.1);
					}
					if (velY <= 0.5) {
						if (getX() >200) {
							setVelX(3);
						}else if (getX()<550) {
							setVelX(-3);
						}
					}
					setX(getVelX()+getX());
					setY(getVelY()+getY());
				}
			});
			handler.addObject(new Enemy(600, 0, 0, 4, ID.Enemy, handler) {
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
			break;
		case 700:
			handler.addObject(new Enemy(0, 100,1.2, 1.4, ID.Enemy, handler));
			handler.addObject(new Enemy(320, 0,-1.01, 1.4, ID.Enemy, handler));
			break;
		case 1000:
			contadorGuion = 0;
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
