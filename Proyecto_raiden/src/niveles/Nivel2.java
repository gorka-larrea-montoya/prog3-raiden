package niveles;
import java.awt.Color;

import logica_interna.*;
public class Nivel2 extends GameMain {
	private static final long serialVersionUID = 6317331953250680569L;
	
	public Nivel2(){
		this.colortest = new Color(0, 0, 0);
		new Ventana(1000, 600, "JuegoEjemplo", this);
		start();
		
		handler = new GameHandler();
		//handler.addObject(new Block(100,0,0,0,ID.Block));
		//handler.addObject(new Block(200,0,0,0,ID.Block));
		
		handler.addObject(new Enemy(430,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(460,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(490,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(520,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(550,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(580,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(610,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(640,0,0,0, ID.Enemy, handler));
	
		handler.addObject(new Enemy(430,30,1,0, ID.Enemy, handler));
		handler.addObject(new Enemy(460,30,0,1, ID.Enemy, handler));
		handler.addObject(new Enemy(490,30,1,0, ID.Enemy, handler));
		handler.addObject(new Enemy(520,30,0,1, ID.Enemy, handler));
		handler.addObject(new Enemy(550,30,1,0, ID.Enemy, handler));
		handler.addObject(new Enemy(580,30,0,1, ID.Enemy, handler));
		handler.addObject(new Enemy(610,30,1,0, ID.Enemy, handler));
		handler.addObject(new Enemy(640,30,0,1, ID.Enemy, handler));
		
		handler.addObject(new MejoraDoble(600,70,0,0));
		
		this.addKeyListener(new Inputs(handler));
		handler.addObject(new PlayerObject(300, 300,handler));
	}	

}
