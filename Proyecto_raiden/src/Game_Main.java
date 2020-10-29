import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game_Main extends Canvas implements Runnable{

	private static final long serialVersionUID = 517368560782680288L;
	private boolean isRunning = false;
	private Thread gameThread;
	private Color colortest;

	
	public Game_Main(){
		new Ventana(1000, 600, "JuegoEjemplo", this);
		start();
	}	
	public static void main(String[] args) {
		new Game_Main();	
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
	//NO TOCAR POR AHORA
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
		
	}//aqui se hacen los cálculos cada segundo
	public void tick(){ 
		if (colortest == null) {
			colortest = Color.red;
		}
		int redTest = colortest.getRed() -1;
		int blueTest = colortest.getBlue() +1;
		int greenTest = colortest.getGreen() +1;
		colortest = new Color(redTest,blueTest,greenTest);
		//esto es una domstracion de que la pantalla pinta y cambia de color
				
		
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
		
		///// AQUI TERMINAMOS DE PINTAR LA PANTALLA
		g.dispose();
		bs.show();
	}
				
}