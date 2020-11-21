import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyBullet extends GameObject{

	public EnemyBullet(int x, int y, float velx,float vely) {
		super(x, y);
		this.velX = velx;
		this.velY = vely;
		this.id = id.EnemyBullet;

	}

	@Override
	public void tick() {
		this.contadorGuion++;
		x += velX;
		y += velY;
		//System.out.println(contadorGuion);
		//System.out.println(y);
		// TODO HACER ALGO PARA BORRAR LAS BALAS QUE SE SALEN DEL MAPA
}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x,y,5,10);
		
	}

	@Override
	public Rectangle getRectangle() {
		return new Rectangle(x,y,8,8);
	}

}
