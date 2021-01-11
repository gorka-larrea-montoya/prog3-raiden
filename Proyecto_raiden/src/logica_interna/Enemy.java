package logica_interna;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;

import javax.imageio.ImageIO;

public class Enemy extends GameObject{
	
	private GameHandler handler;
	Random r = new Random();
	int choose = 0;
	int hp = 100;
	
	BufferedImage enemyImage;
	BufferedImage enemyBulletImage;
	private int health;
	private int contadorGuion;
	
	public Enemy(float x, float y, float velX, float velY, ID id, GameHandler handler) {
		super(x, y);
		this.velX = velX;
		this.velY = velY;
		this.health = 40;
		this.id = ID.Enemy;
		this.handler = handler;
		handler.handlerlog(Level.INFO, "Se ha creado un objeto Enemy en X,Y: " + x +","+ y + "con velocidad: "+ velX+","+velY);
		 try{
			 enemyImage = ImageIO.read(new File("./resources/enemy1.png"));
			 handler.handlerlog(Level.INFO, "Se ha cargado la imagen enemy1 para la clase Enemy");
	        }catch(IOException e){
	        	e.printStackTrace();}
	        catch(Exception e){e.printStackTrace();}
	    }
	public void move() {
		handler.handlerlog(Level.INFO, "El Enemy que estaba en"+ x + ","+ y +"se mueve a " + ((int)getVelX()+getX())+","+((int)getVelY()+getY()));
		setX((int)getVelX()+getX());
		setY((int)getVelY()+getY());
	}

	

	@Override
	public void tick() {
		this.move();		
		choose = r.nextInt(200);
		
		if(choose == 0) {
			velX = (r.nextInt(1));
			shoot(this);
			handler.handlerlog(Level.FINE, "Enemy ha tirado shoot(this) en "+x+","+y);
			//velY = velY + (float)0.07;
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		//g.setColor(Color.yellow);
		//g.fillRect(x, y, 32, 32);
		
	}

	@Override
	public Rectangle getRectangle() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int) y, 32, 32);
	}

	@Override
	 public void paint(Graphics2D g2){
        AffineTransform at = new AffineTransform();
       at.translate((int)x, (int)y);
      //  at.rotate(Math.PI/2);
       // at.translate(-playerImage.getWidth()/2, -playerImage.getHeight()/2);
        g2.drawImage(enemyImage, (int)x, (int)y, null);
	}
	
	
	public void colision() {
		for (int i = 0; i < handler.objectList.size(); i++) {
			if (handler.objectList.get(i).id == ID.Bullet) {
				
				GameObject temp = handler.objectList.get(i);
				if(getRectangle().intersects(temp.getRectangle())){
					
					handler.removeobject(this);
					handler.removeobject(temp);
					
					
				}
			}
			
		}
	}
	
	public void shoot(Enemy e) {
	handler.addObject(new EnemyBullet(e.getX(), e.getY(),handler));
	}
	public GameHandler getHandler() {
		return handler;
	}
	public void setHandler(GameHandler handler) {
		this.handler = handler;
	}
	public Random getR() {
		return r;
	}
	public void setR(Random r) {
		this.r = r;
	}
	public int getChoose() {
		return choose;
	}
	public void setChoose(int choose) {
		this.choose = choose;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public BufferedImage getEnemyImage() {
		return enemyImage;
	}
	public void setEnemyImage(BufferedImage enemyImage) {
		this.enemyImage = enemyImage;
	}
	public BufferedImage getEnemyBulletImage() {
		return enemyBulletImage;
	}
	public void setEnemyBulletImage(BufferedImage enemyBulletImage) {
		this.enemyBulletImage = enemyBulletImage;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getContadorGuion() {
		return contadorGuion;
	}
	public void setContadorGuion(int contadorGuion) {
		this.contadorGuion = contadorGuion;
	}
	
	
}
