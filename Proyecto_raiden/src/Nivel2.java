import java.awt.Color;

public class Nivel2 extends GameMain {
	private static final long serialVersionUID = 6317331953250680569L;
	PlayerObject player;
	
	
	
	
	public Nivel2(String nomString){
		
		this.colortest = new Color(0, 0, 0);
		new Ventana(1000, 600, "JuegoEjemplo", this);
		start();
		
		
		float f = (float) (Math.random() * 1001);
		handler = new GameHandler();
		//handler.addObject(new Block(100,0,0,0,ID.Block));
		//handler.addObject(new Block(200,0,0,0,ID.Block));
		
		
		for(int i = 0; i < 20; i++) {
			handler.addObject(new Enemy(i*35 ,-250 , (int)0.2 -2+1 +1, (int)1.75+ +1 -2 +1, ID.Enemy, handler));
			
		}
		
	
			
		
	
		
		
	
		
	/*	handler.addObject(new Enemy(430,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(460,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(490,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(520,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(550,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(580,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(610,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(640,0,0,0, ID.Enemy, handler));
	
		handler.addObject(new Enemy(430,30,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(460,30,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(490,30,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(520,30,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(550,30,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(580,30,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(610,30,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(640,30,0,0, ID.Enemy, handler));
		
		handler.addObject(new MejoraDoble(600,70,0,0));
	*/	
		this.addKeyListener(new Inputs(handler));
		//player.setName(playername);
		//player.setX(300);
		//player.setY(300);
		//player.handler = handler;
		player = new PlayerObject(300, 300, handler, nomString, 100, 0);
		
		handler.addObject(player);
		 
		System.out.println(player.toString());
	}	
	
		public void getPlayer() {
			
		}

}
