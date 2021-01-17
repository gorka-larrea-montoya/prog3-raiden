package logica_interna;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class GameObject {
	protected float x;
	protected float y;
	protected float velX;
	protected float velY;
	protected ID id;
	
	public GameObject(float x, float y) {
		this.x = x;
		this.y = y;
	}


	public GameObject() {
		// TODO NO TOCAR?
	}


	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void paint(Graphics2D g2);
	public abstract Rectangle getRectangle();
	//GETTERS Y SETTERS
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getVelX() {
		return velX;
	}
	public void setVelX(float velX) {
		this.velX = velX;
	}
	public float getVelY() {
		return velY;
	}	
	public void setVelY(float velY) {
		this.velY = velY;
	}

	
}
