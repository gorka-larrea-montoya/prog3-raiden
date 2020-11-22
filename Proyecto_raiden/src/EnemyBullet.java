import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemyBullet extends GameObject{
	GameHandler handler;
	Enemy enemy;
	BufferedImage enemyBulletImage;
	//TODO arreglar que las balas necesiten del ID de bala

	public EnemyBullet(int x, int y,GameHandler handler) {
		super(x, y);
		this.handler = handler;
		this.id = ID.EnemyBullet;
		 try{
			 enemyBulletImage = ImageIO.read(new File("./resources/enemyBullet1.png"));
	        }catch(IOException e){
	        	e.printStackTrace();}
	        catch(Exception e){e.printStackTrace();}
	    }
	public void tick() {
		x += velX;
		y += +2;
		colision();
		
		if (y < 0) {
			handler.removeobject(this);
			System.out.println("se ha borrado una bala porque estaba demasiado arriba");
		}
	}
	
	public void colision() {
		for (int i = 0; i < handler.objectList.size(); i++) {
			if (handler.objectList.get(i).id == ID.Player) {
				GameObject tempPlayer = handler.objectList.get(i);
				if(getRectangle().intersects(tempPlayer.getRectangle())){
					handler.removeobject(this);
					//handler.removeobject(tempPlayer);
					
				}
			}
			
		}
	}
	
	
	
	
	public void render(Graphics g) {
		//g.setColor(Color.PINK);
		//g.fillRect(x+15, y, 5, 12);
		
	}
	public Rectangle getRectangle() {
		return new Rectangle(x+15,y,5,12);
	}
	@Override
	public void paint(Graphics2D g2) {
		// TODO Auto-generated method stub
		for (int i = 0; i < handler.objectList.size(); i++) {
			if (handler.objectList.get(i).getId() == ID.Enemy) {	
					}
				}
		   AffineTransform at = new AffineTransform();
	       at.translate(x+55,y+35);	     //Corrección de Imagen balaEnemigo
	       at.rotate(-Math.PI);
	       g2.drawImage(enemyBulletImage, at, null);
		
	}


}
