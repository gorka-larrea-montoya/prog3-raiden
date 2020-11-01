import java.awt.Graphics;
import java.util.LinkedList;

public class GameHandler {
	LinkedList<GameObject> objectList = new LinkedList<GameObject>();
	
	public void tick() {
		for (int i = 0; i < objectList.size(); i++) {
			objectList.get(i).tick();
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
	}
}
