package logica_interna;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;


public abstract class GameMain extends Canvas implements Runnable{

	static final long serialVersionUID = 517368560782680288L;
	private static int score = 0;
	boolean isRunning = false;
	Thread gameThread;
	private Color colortest;
	private GameHandler handler;
	int contadorGuion;
	
	


	protected void start(){
		isRunning = true;
		gameThread = new Thread(this);
		gameThread.start(); 
	} protected void stop() {
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
			setScore(getScore() + 1);
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
		/*
		int redTest = colortest.getRed() -1;
		int blueTest = colortest.getBlue() +1;
		int greenTest = colortest.getGreen() +1;
		colortest = new Color(redTest,blueTest,greenTest);
		//esto es una domstracion de que la pantalla pinta y cambia de color
		*/
		getHandler().tick();
		contadorGuion++;
		GameMain.setScore(GameMain.getScore()+ (int) 0.1);
		
	}//aqui se pinta la pantalla
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		///// AQUI SE PINTA LA PANTALLA 
		
		g.setColor(getColortest());
		g.fillRect(0, 0, 1000, 600);
		
		
		String s = Integer.toString(getScore());
		g.setColor(Color.WHITE);
		
		
		//CUIDADO QUE LA PARTE DE ARRIBA SE PINTA ANTES Y POR DETRAS DE LA DE ABAJO
		getHandler().render(g);
		
		g.drawString(s, getWidth() - 150, 50);
		
		///// AQUI TERMINAMOS DE PINTAR LA PANTALLA
		
		g.dispose();
		bs.show();

		
	}
/*	public void paint(Graphics g){
		Font font  = new Font("Serif",Font.BOLD, 36);
		g.setFont(font);
		g.setColor(Color.WHITE);
		
		g.drawString(Integer.toString(GameMain.score), 200, 150);
		
	}
	*/
	public Color getColortest() {
		return colortest;
	}
	public void setColortest(Color colortest) {
		this.colortest = colortest;
	}
	public GameHandler getHandler() {
		return handler;
	}
	public void setHandler(GameHandler handler) {
		this.handler = handler;
	}
	public static int getScore() {
		return score;
	}
	public static void setScore(int score) {
		GameMain.score = score;
	}			
}