import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject{
	GameHandler handler;
	//TODO arreglar que las balas necesiten del ID de bala

	public Bullet(int x, int y, ID id,GameHandler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	public void tick() {
		x += velX;
		y += -2;
		colision();
		if (y <0) {
			System.out.println("hay una bala fuera");
		}
		
	}
	public void colision() {
		for (int i = 0; i < handler.objectList.size(); i++) {
			if (handler.objectList.get(i).id != id.Bullet) {
				if(getRectangle().intersects(handler.objectList.get(i).getRectangle())){
					System.out.println("una bala está chocando con algo");
				}
			}
			
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(x, y, 8, 16);
		
	}
	public Rectangle getRectangle() {
		return new Rectangle(x,y,8,16);
	}

}
