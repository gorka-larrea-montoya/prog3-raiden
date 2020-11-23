import java.awt.*;

public class Block extends GameObject {
//NO USAR MAS POR AHORA
	public Block(int x, int y,float velx,float vely,ID id) {
		super(x,y);
		this.velX = velx;
		this.velY = vely;
		this.id = ID.Block;

	}

	public void tick() {
		x += velX;
		y += velY;
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 32, 32);
		
	}

	public Rectangle getRectangle() {
		return new Rectangle(x,y,32,32);
	}

	@Override
	public void paint(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}
	
	
}
