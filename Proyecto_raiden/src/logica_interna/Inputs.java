package logica_interna;
import java.awt.event.*;

public class Inputs extends KeyAdapter {
	GameHandler handler;
	int keyEventUp;
	int keyEventLeft;
	int keyEventRight;
	int keyEventDown;
	int keyEventShoot;
	
	
	public Inputs(GameHandler handler) {
		this.handler = handler;
		keyEventUp = KeyEvent.VK_W;
		keyEventLeft = KeyEvent.VK_A;
		keyEventRight = KeyEvent.VK_D;
		keyEventDown = KeyEvent.VK_S;
		keyEventShoot = KeyEvent.VK_SPACE;
		
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		

		for (int i = 0; i < handler.objectList.size(); i++) {
			if (handler.objectList.get(i).getId() == ID.Player) {
				PlayerObject tempPlayer = (PlayerObject) handler.objectList.get(i); 
				if (key == keyEventShoot) {
					tempPlayer.shoot();	
				}
				if (key == keyEventUp) {
					handler.setUp(true);
				}
				if (key == keyEventLeft) {
					handler.setLeft(true);
				}
				if (key == keyEventDown) {
					handler.setDown(true);
				}
				if (key == keyEventRight) {
					handler.setRight(true);
				}

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
