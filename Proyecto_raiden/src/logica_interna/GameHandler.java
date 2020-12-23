package logica_interna;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

public class GameHandler {
	private LinkedList<GameObject> objectList = new LinkedList<GameObject>();
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;

	
	public void tick() {
		//sorprendentemente las balas hay que tratarlas en esta clase y no en bullet 
		for (int i = 0; i < getObjectList().size(); i++) {
			getObjectList().get(i).tick();
		}for (int i = 0; i < getObjectList().size(); i++) {
			if(getObjectList().get(i).getY() > 700) {
				getObjectList().remove(getObjectList().get(i));
				//System.out.println("se ha borrado una bala enemiga que salia del borde");
			}
		}
	}
	public void render(Graphics g) {
		for (int i = 0; i < getObjectList().size(); i++) {
			getObjectList().get(i).render(g);
			getObjectList().get(i).paint((Graphics2D) g);
			
		}
	}
	
	
	
	public void addObject(GameObject a) {
		getObjectList().add(a);
	}
	public void removeobject(GameObject a) {
		getObjectList().remove(a);
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
		return objectList;
	}
	public void setObjectList(LinkedList<GameObject> objectList) {
		this.objectList = objectList;
	}
}
