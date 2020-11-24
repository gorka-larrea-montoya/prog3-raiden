import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerObject extends GameObject {
	GameHandler handler;
	int speed;
	Mejoras mejoraActual = Mejoras.ESTANDAR;
	
	BufferedImage playerImage;
	//String playerPath = "resources/player.png";
//	Image plyr = this.getClass().getResource(playerPath);
	
	
	public PlayerObject(int x, int y, GameHandler handler) {
		super(x, y);
		this.handler = handler;
		speed = (int) 3.5 ;
		this.id = ID.Player;
		this.mejoraActual = getMejoraActual();
		
	    try{
	    	 playerImage = ImageIO.read(new File("./resources/player2.png"));
	        }catch(IOException e){
	        	e.printStackTrace();}
	        catch(Exception e){e.printStackTrace();}
	    }

	public Mejoras getMejoraActual() {
	
		return mejoraActual;
	}
	public void setMejoraActual(Mejoras mejoraActual) {
		this.mejoraActual = mejoraActual;
	}
	public void tick() {
		x += velX;
		y += velY;
		colision();
		//tiene el fallo de que al pulsar direcciones opuestas lo resuelve con la que tiene la linea escrita mas tarde. Habr�a que reescribir mucho para arreglarlo
		if (handler.isDown()) {	velY =+ speed;}else if (!handler.isUp()) {velY = 0;}
		if (handler.isUp()) {velY =- speed;}else if (!handler.isDown()) {velY = 0;}
		if (handler.isLeft()) {velX =- speed;}else if (!handler.isRight()) {velX = 0;}
		if (handler.isRight()) {velX =+ speed;}else if (!handler.isLeft()) {velX = 0;}
	}
	public void colision() {
		for (int i = 0; i < handler.objectList.size(); i++) {
			if (handler.objectList.get(i).id != ID.Player) {
				if(getRectangle().intersects(handler.objectList.get(i).getRectangle())){
					System.out.println("el jugador esta chocando con " + (handler.objectList.get(i).id.toString()));
				}
			}
			
		}
	}
	public void shoot() {
		
	}
	public void render(Graphics g) {
		//g.setColor(Color.GREEN);
		//g.fillRect(x, y, 30, 40);
	};
	
//	public void paint(Graphics2D g2) {
//	g2.drawImage(playerImage, null, null);
//}

	 public void paint(Graphics2D g2){
	        AffineTransform at = new AffineTransform();
	       at.translate((int)x + 39 , (int)this.y + 40); 
	       at.rotate(Math.PI);
	    //   at.translate(playerImage.getWidth()/4, playerImage.getHeight()/4);
	        g2.drawImage(playerImage, at, null);
	    }
	
	public Rectangle getRectangle() {
		return new Rectangle(x,y,30,40);
	}



	
}
