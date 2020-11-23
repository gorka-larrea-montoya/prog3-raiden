import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Enemy extends GameObject{
	
	private GameHandler handler;
	Random r = new Random();
	int choose = 0;
	int hp = 100;
	
	BufferedImage enemyImage;
	BufferedImage enemyBulletImage;
	
	
	public Enemy(int x, int y, float velX, float velY, ID id, GameHandler handler) {
		super(x, y);
		this.velX = velX;
		this.velY = velY;
		this.id = ID.Enemy;
		this.handler = handler;
		
		 try{
			 enemyImage = ImageIO.read(new File("./resources/enemy1.png"));
	        }catch(IOException e){
	        	e.printStackTrace();}
	        catch(Exception e){e.printStackTrace();}
	    }
		

	

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		choose = r.nextInt(200);
		
		if(choose ==0 ) {
			velX = (r.nextInt(1));
			shoot(this);
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
		return new Rectangle(x, y, 32, 32);
	}

	@Override
	 public void paint(Graphics2D g2){
        AffineTransform at = new AffineTransform();
       at.translate((int)x, (int)y);
      //  at.rotate(Math.PI/2);
       // at.translate(-playerImage.getWidth()/2, -playerImage.getHeight()/2);
        g2.drawImage(enemyImage, x, y, null);
	}
	
	
	
	public void shoot(Enemy e) {
	handler.addObject(new EnemyBullet(e.getX(), e.getY(),handler));
	}
	
	
}
