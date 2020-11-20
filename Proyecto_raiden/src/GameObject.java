import java.awt.*;

public abstract class GameObject {
	protected int x;
	protected int y;
	protected float velX;
	protected float velY;
	protected ID id;
	protected long contadorGuion;
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getRectangle();
	//GETTERS Y SETTERS
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
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
