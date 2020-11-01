import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerObject extends GameObject {
	GameHandler handler;
	int speed;

	public PlayerObject(int x, int y, ID id, GameHandler handler) {
		super(x, y, id);
		this.handler = handler;
		speed = 3;

	}
	public void tick() {
		x += velX;
		y += velY;
		
		if (handler.isDown()) {	velY = speed;}else if (!handler.isUp()) {velY = 0;}
		if (handler.isUp()) {velY = -speed;}else if (!handler.isDown()) {velY = 0;}
		if (handler.isLeft()) {velX = -speed;}else if (!handler.isRight()) {velX = 0;}
		if (handler.isRight()) {velX = speed;}else if (!handler.isLeft()) {velX = 0;}
		
		
		
	}
		

	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 32, 48);
	}
	public Rectangle getRectangle() {
		return new Rectangle(x,y,32,48);
	}
}
