import java.awt.Canvas;

public class Game_Main extends Canvas implements Runnable{

	private static final long serialVersionUID = 517368560782680288L;

	public Game_Main(){
		new Ventana(1000, 600, "JuegoEjemplo", this);
	}
	
	public static void main(String[] args) {
		new Game_Main();
	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
