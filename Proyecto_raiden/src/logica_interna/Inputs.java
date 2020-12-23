package logica_interna;
import java.awt.event.*;

public class Inputs extends KeyAdapter {
	GameHandler handler;
	
	public Inputs(GameHandler handler) {
			this.handler = handler;
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
				
		for (int i = 0; i < handler.getObjectList().size(); i++) {
			if (handler.getObjectList().get(i).getId() == ID.Player) {
				PlayerObject tempPlayer = (PlayerObject) handler.getObjectList().get(i); 
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
								
					if (tempPlayer.getMejoraActual() ==  Mejoras.ESTANDAR) {
						handler.addObject(new Bullet(tempPlayer.getX()+12,tempPlayer.getY()-16,handler)); 
					} else if (tempPlayer.getMejoraActual() == Mejoras.DOBLE) {
						handler.addObject(new Bullet(tempPlayer.getX()+20,tempPlayer.getY()-16,handler));
						handler.addObject(new Bullet(tempPlayer.getX()+4, tempPlayer.getY()-16,handler));
					} 
					
					}
					
					
				}
			}
		}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.getObjectList().size(); i++) {
			if (handler.getObjectList().get(i).getId() == ID.Player) {
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
