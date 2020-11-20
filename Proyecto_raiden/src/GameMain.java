import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public abstract class GameMain extends Canvas implements Runnable{
	
	static final long serialVersionUID = 517368560782680288L;
	boolean isRunning = false;
	Thread gameThread;
	Color colortest;
	GameHandler handler;
	long ContadorGuion = 0;
	
	public GameMain(){
		new Ventana(1000, 600, "JuegoEjemplo", this);
		start();
		
		
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
		ContadorGuion++;
		handler.tick();
		//System.out.println(ContadorGuion);
		
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

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public Thread getGameThread() {
		return gameThread;
	}

	public void setGameThread(Thread gameThread) {
		this.gameThread = gameThread;
	}

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

	public long getContadorGuion() {
		return ContadorGuion;
	}

	public void setContadorGuion(long contadorGuion) {
		ContadorGuion = contadorGuion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
				
}