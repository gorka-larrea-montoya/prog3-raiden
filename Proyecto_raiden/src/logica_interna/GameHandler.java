package logica_interna;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.logging.Level;

public class GameHandler {
	LinkedList<GameObject> objectList = new LinkedList<GameObject>();
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	long waveStartTimer;
	long waveStartTimerDiff;
	int waveNumber;
	int ticklogger;
	boolean waveStart;
	GameMain gameMain;

	
	public void tick() {
		//sorprendentemente las balas hay que tratarlas en esta clase y no en bullet 
		for (int i = 0; i < objectList.size(); i++) {
			objectList.get(i).tick();
		}for (int i = 0; i < objectList.size(); i++) {
			if(objectList.get(i).getY() > 700) {
				GameMain.getGameLogger().log(Level.FINE,"BORRADO OBJETO QUE SE SALIA DEL BORDE"+ objectList.get(i).toString());
				objectList.remove(objectList.get(i));
			}
		}
	}
	public void render(Graphics g) {
		for (int i = 0; i < objectList.size(); i++) {
			objectList.get(i).render(g);
			objectList.get(i).paint((Graphics2D) g);
			
		}
	}
	
	
	
	public void addObject(GameObject a) {
		objectList.add(a);
	}
	public void removeobject(GameObject a) {
		objectList.remove(a);
	}//GETTERS SETTERS
	
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean isDown() {
		return down;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public LinkedList<GameObject> getObjectList() {
		return this.objectList;
	}
	public long getWaveStartTimer() {
		return waveStartTimer;
	}
	public void setWaveStartTimer(long waveStartTimer) {
		this.waveStartTimer = waveStartTimer;
	}
	public long getWaveStartTimerDiff() {
		return waveStartTimerDiff;
	}
	public void setWaveStartTimerDiff(long waveStartTimerDiff) {
		this.waveStartTimerDiff = waveStartTimerDiff;
	}
	public int getWaveNumber() {
		return waveNumber;
	}
	public void setWaveNumber(int waveNumber) {
		this.waveNumber = waveNumber;
	}
	public int getTicklogger() {
		return ticklogger;
	}
	public void setTicklogger(int ticklogger) {
		this.ticklogger = ticklogger;
	}
	public boolean isWaveStart() {
		return waveStart;
	}
	public void setWaveStart(boolean waveStart) {
		this.waveStart = waveStart;
	}
	public GameMain getGameMain() {
		return gameMain;
	}
	public void setGameMain(GameMain gameMain) {
		this.gameMain = gameMain;
	}
	public void setObjectList(LinkedList<GameObject> objectList) {
		this.objectList = objectList;
	}
	
}
