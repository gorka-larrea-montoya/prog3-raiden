import java.awt.Graphics;
import java.util.LinkedList;

public class GameHandler {
	LinkedList<GameObject> objectList = new LinkedList<GameObject>();
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;

	
	public void tick() {
			for (int i = 0; i < objectList.size(); i++) {
								objectList.get(i).tick();		
		} for (int i = 0; i < objectList.size(); i++) {//ESTO ESTÁ EN DOS FORS DISTINTOS PARA EVITAR OUTOFBOUNDS
			if (objectList.get(i).getId() == ID.EnemyBullet) {
				if (objectList.get(i).getY() > 700) {
					objectList.remove(objectList.get(i));
					//System.out.println("se ha borrado una bala enemiga que se salía del borde");
				}
			}
		}
	}
	public void render(Graphics g) {
		for (int i = 0; i < objectList.size(); i++) {
			objectList.get(i).render(g);
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
}
