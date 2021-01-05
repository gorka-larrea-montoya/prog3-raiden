package logica_interna;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import niveles.VentanaPrincipal;

public class Bullet extends GameObject{
	GameHandler handler;
	BufferedImage bulletImage;
//	static PlayerObject p =VentanaPrincipal.readyPlayer();
	//TODO arreglar que las balas necesiten del ID de bala

	public Bullet(int x, int y,GameHandler handler) {
		super(x, y);
		this.handler = handler;
		this.id = ID.Bullet;
		try{
	    bulletImage = ImageIO.read(new File("./resources/bullet3.png"));
	    }catch(IOException e){
	    e.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
	}
	
	public void tick() {
		x += velX;
		y += -6;
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
					handler.removeobject(this);
					handler.removeobject(tempEnemy);
				//	p.setKillCount(p.getKillCount() +1);
					GameMain.setScore(GameMain.getScore() + 5);
					GameMain.setEnemiesKilledMain(GameMain.getEnemiesKilledMain() +1);
					System.out.println(GameMain.getScore() + " " + GameMain.getEnemiesKilledMain());
				//	p.killedEnemy(); sumar puntos aqui? o que sea una funcion de esto + tiempo
				}
			}
			
		}
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
		return new Rectangle(x,y,5,22);
	}

	@Override
	public String toString() {
		return "Bullet [" + ", x=" + x + ", y=" + y + ", velX="
				+ velX + ", velY=" + velY + ", id=" + id + ",hashCode()=" + hashCode() + "]";
	}
	
	

}
