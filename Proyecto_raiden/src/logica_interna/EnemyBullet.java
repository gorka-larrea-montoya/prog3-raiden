package logica_interna;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import database.DBException;
import database.DBManager;
import niveles.VentanaPrincipal;

public class EnemyBullet extends GameObject{
	GameHandler handler;
	Enemy enemy;
	BufferedImage enemyBulletImage;
	//DBManager databaseManager;

	public EnemyBullet(float x, float y,GameHandler handler) {
		super(x, y);
		this.handler = handler;
		this.id = ID.EnemyBullet;
		try{
			enemyBulletImage = ImageIO.read(new File("./resources/enemyBullet1.png"));
		}catch(IOException e){
			e.printStackTrace();
			handler.getGameMain();
			GameMain.getGameLogger().log(Level.SEVERE, "No se ha encontrado la imagen de EnemyBullet");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void move() {
		x += velX;
		y += +2;
	}
	public void tick() {
		move();
		colision();
	}

	public void colision() {
		for (int i = 0; i < handler.objectList.size(); i++) {
			if (handler.objectList.get(i).id == ID.Player) {
				PlayerObject tempPlayer =(PlayerObject) handler.objectList.get(i);
				if(getRectangle().intersects(tempPlayer.getRectangle())){
					handler.removeobject(this);
					//tempPlayer.enemyBulletDamage();
					tempPlayer.setHealth(tempPlayer.getHealth() - 25);
					if(tempPlayer.getHealth() <= 0) {
						handler.removeobject(tempPlayer);//muere jugador por herida de bala(hp<0)
					//	System.out.println(tempPlayer.setHighScore());
						try {
							VentanaPrincipal.databaseManager.insertPlayer(tempPlayer);
						} catch (DBException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//VentanaPrincipal.partidasJugadas.add(tempPlayer.PartidaToString());
						
						System.out.println(tempPlayer.PartidaToString());
					}
					//System.out.println("HP: " + tempPlayer.getHealth());
				}	

			}
		}
	}





	public void render(Graphics g) {
		//g.setColor(Color.PINK);
		//g.fillRect(x+15, y, 5, 12);

	}
	public Rectangle getRectangle() {
		return new Rectangle((int)x+15,(int)y,5,12);
	}
	@Override
	public void paint(Graphics2D g2) {
		// TODO Auto-generated method stub
		//for (int i = 0; i < handler.objectList.size(); i++) {
		//	if (handler.objectList.get(i).getId() == ID.Enemy) {	
		//			}
		//		}
		AffineTransform at = new AffineTransform();
		at.translate(x+55,y+35);	     //Correccion de Imagen balaEnemigo
		at.rotate(-Math.PI);
		g2.drawImage(enemyBulletImage, at, null);

	}


}
