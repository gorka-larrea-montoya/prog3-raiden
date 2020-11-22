import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;


public class GameMain extends Canvas implements Runnable{

	private static final long serialVersionUID = 517368560782680288L;
	private boolean isRunning = false;
	private Thread gameThread;
	private Color colortest;
	private GameHandler handler;

	
	public GameMain(){
		new Ventana(1000, 600, "JuegoEjemplo", this);
		start();
		
		handler = new GameHandler();
		handler.addObject(new Block(100,0,0,0,ID.Block));
		handler.addObject(new Block(200,0,0,0,ID.Block));
		
		handler.addObject(new Enemy(430,0,0,0, ID.Enemy, handler));
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
		
		handler.addObject(new MejoraDoble(600,70,0,0, ID.PowerUp));
		
		this.addKeyListener(new Inputs(handler));
		handler.addObject(new PlayerObject(300, 300,handler));
	}	
	public static void main(String[] args) {
		new GameMain();	
	}
	private void start(){
		isRunning = true;
		gameThread = new Thread(this);
		gameThread.start();
	} private void stop() {
		isRunning = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}//un gameloop robado de internet calcula el juego tropecientas veces por segundo y pinta 60 veces por segundo
	
	
	public void generateEnemies() {
		
		
	}
	public void run() { 
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		long timer = System.currentTimeMillis();
		int frames = 0;
		double delta = 0;
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				//updates
				delta--;
			}	
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
				//updates = 0;
			}
		}
		stop();
		
	}//aqui se hacen los c�lculos cada segundo
	public void tick(){ 
		if (colortest == null) {
			colortest = Color.black;
		}/*
		int redTest = colortest.getRed() -1;
		int blueTest = colortest.getBlue() +1;
		int greenTest = colortest.getGreen() +1;
		colortest = new Color(redTest,blueTest,greenTest);
		//esto es una domstracion de que la pantalla pinta y cambia de color
		*/
		handler.tick();
		
	}//aqui se pinta la pantalla
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		
		///// AQUI SE PINTA LA PANTALLA 
		
		g.setColor(colortest);
		g.fillRect(0, 0, 1000, 600);
		
		//CUIDADO QUE LA PARTE DE ARRIBA SE PINTA ANTES Y POR DETRAS DE LA DE ABAJO
		handler.render(g);
		
		///// AQUI TERMINAMOS DE PINTAR LA PANTALLA
		
		g.dispose();
		bs.show();
	}
				
}