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

public class MejoraDoble extends GameObject{
	GameHandler handler;
	BufferedImage MejoraDobleImage;
	public MejoraDoble(float x, float y, float velx, float vely,GameHandler handler) {
		super(x, y);
		this.velX = velx;
		this.velY = vely;
		this.id = ID.PowerUp;
		try {
			MejoraDobleImage = ImageIO.read(new File("./resources/mejoraDoble.png"));
			handler.handlerlog(Level.INFO, "Cargada imagen mejoraDoble de la clase MejoraDoble");
		} catch (IOException e) {
			handler.handlerlog(Level.SEVERE, "Error de IO al cargar la imagen mejoraDoble de la clase MejoraDoble" + e.getStackTrace());
		} catch (Exception e) {
			handler.handlerlog(Level.SEVERE, "Error de Java al cargar la imagen mejoraDoble de la clase MejoraDoble" + e.getStackTrace());
		}

	}
	public void move() {
		x += velX;
		y += velY;
	}
	@Override
	public void tick() {
		move();
	}

/*	@Override
	public void render(Graphics g) {
		g.fillRect((int)x,(int)y, 22, 22);
		g.setColor(Color.magenta);
		
	}*/
	@Override
	public void paint(Graphics2D g2) {
		AffineTransform at = new AffineTransform();	//Corrección al pintar la imagen
	       at.translate((int) this.x, (int) this.y+27);	     
	       at.rotate(-Math.PI/2);
	       
	       g2.drawImage(MejoraDobleImage, at, null);
	}
	@Override
	public Rectangle getRectangle() {
		// TODO Auto-generated method stub
		return new Rectangle(22, 22, 0, 0);
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
