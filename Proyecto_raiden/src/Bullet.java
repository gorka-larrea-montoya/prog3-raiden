import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject{
	GameHandler handler;
	//TODO arreglar que las balas necesiten del ID de bala

	public Bullet(int x, int y,GameHandler handler) {
		super(x, y);
		this.handler = handler;
		this.id = id.Bullet;
	}
	public void tick() {
		x += velX;
		y += -5;
		colision();	
		if (y < 0) {
			handler.removeobject(this);
			//System.out.println("se ha borrado una bala porque estaba demasiado arriba");
		}
	}
	public void colision() {
		for (int i = 0; i < handler.objectList.size(); i++) {
			if (handler.objectList.get(i).id == ID.Enemy) {
				GameObject temp = handler.objectList.get(i);
				if(getRectangle().intersects(temp.getRectangle())){
					handler.removeobject(temp);
					handler.removeobject(this);
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
