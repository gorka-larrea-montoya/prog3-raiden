package logica_interna;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import ventanas.VentanaPrincipal;

public class Bullet extends GameObject{
	GameHandler handler;
	BufferedImage bulletImage;
//	static PlayerObject p =VentanaPrincipal.readyPlayer();
	//TODO arreglar que las balas necesiten del ID de bala

	public Bullet(float x, float y,GameHandler handler) {
		super(x, y);
		this.handler = handler;
		this.id = ID.Bullet;
		
		try{
			bulletImage = ImageIO.read(new File("./resources/bullet3.png"));
			handler.handlerlog(Level.INFO, "Cargada imagen bullet3 de la clase Bullet");
		}catch(IOException e){
			handler.handlerlog(Level.SEVERE, "Error de IO al cargar la imagen Bullet3 de la clase bullet" + e.getStackTrace());
		}
		catch(Exception e){
			handler.handlerlog(Level.SEVERE, "Error de Java al cargar la imagen Bullet3 de la clase bullet" + e.getStackTrace());
		}
	}
	public void move() {
		x += velX;
		y += -6;
	}
	public void tick() {
		move();
		colision();
		
		
		if (y < 0) {
			handler.removeobject(this);
		//////	System.out.println("se ha borrado una bala porque estaba demasiado arriba");
		}
	}
	
	public void colision() {
		for (int i = 0; i < handler.objectList.size(); i++) {
			if (handler.objectList.get(i).id == ID.Enemy) {
				Enemy tempEnemy = (Enemy) handler.objectList.get(i);
				if(getRectangle().intersects(tempEnemy.getRectangle())){
					deleteBullet();
					tempEnemy.takeDamage();
				//	p.setKillCount(p.getKillCount() +1);
					GameMain.setScore(GameMain.getScore() + 5);
					GameMain.setEnemiesKilledMain(GameMain.getEnemiesKilledMain() +1);
					handler.handlerlog(Level.INFO,GameMain.getScore() + " " + GameMain.getEnemiesKilledMain());
				//	p.killedEnemy(); sumar puntos aqui? o que sea una funcion de esto + tiempo
				}
			}
			
		}
	}
	public void deleteBullet() {
		handler.removeobject(this);
	}
	
	
	public void render(Graphics g) {
		//g.setColor(Color.PINK);
		//g.fillRect(x, y, 5, 22);
		
	}
	
	@Override
	public void paint(Graphics2D g2) {
		// TODO Auto-generated method stub
		AffineTransform at = new AffineTransform();	//Corrección al pintar la imagen
	       at.translate((int) this.x, (int) this.y+27);	     
	       at.rotate(-Math.PI/2);
	       
	       g2.drawImage(bulletImage, at, null);
		
	}
	
	public Rectangle getRectangle() {
		return new Rectangle((int)x,(int)y,5,22);
	}

	@Override
	public String toString() {
		return "Bullet [" + ", x=" + x + ", y=" + y + ", velX="
				+ velX + ", velY=" + velY + ", id=" + id + ",hashCode()=" + hashCode() + "]";
	}
	
	

}
