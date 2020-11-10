import java.awt.event.*;

public class Inputs extends KeyAdapter {
	GameHandler handler;
	
	public Inputs(GameHandler handler) {
			this.handler = handler;
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
				
		for (int i = 0; i < handler.objectList.size(); i++) {
			if (handler.objectList.get(i).getId() == ID.Player) {
				if (key == KeyEvent.VK_W) {
					handler.setUp(true);
				}
				if (key == KeyEvent.VK_A) {
					handler.setLeft(true);
				}
				if (key == KeyEvent.VK_S) {
					handler.setDown(true);
				}
				if (key == KeyEvent.VK_D) {
					handler.setRight(true);
				}
				if (key == KeyEvent.VK_SPACE) {
					System.out.println("space"); 
					handler.addObject(new Bullet(handler.objectList.get(i).getX()+12, handler.objectList.get(i).getY()-16,ID.Bullet)); 
				} //TODO buscar una manera de enchufar esto con un sistema de powerup o algo similar.
				}
			}
		}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.objectList.size(); i++) {
			if (handler.objectList.get(i).getId() == ID.Player) {
				if (key == KeyEvent.VK_W) {
					handler.setUp(false);
				}
				if (key == KeyEvent.VK_A) {
					handler.setLeft(false);
				}
				if (key == KeyEvent.VK_S) {
					handler.setDown(false);
				}
				if (key == KeyEvent.VK_D) {
					handler.setRight(false);
				}
			}
		}
	}
	
}
