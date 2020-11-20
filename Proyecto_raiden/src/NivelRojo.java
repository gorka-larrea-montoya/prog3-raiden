import java.awt.Color;

public class NivelRojo extends GameMain{
	public NivelRojo() {
		this.colortest = Color.red;
		
		handler = new GameHandler();
		handler.addObject(new Box(100,200,0,0,ID.Block));
		handler.addObject(new Box(200,200,0,0,ID.Block) {
		public void tick(){
			this.contadorGuion++;
			
			x += velX;
			y += velY;
			//System.out.println(contadorGuion);
			if (this.contadorGuion == 100) {
				this.velX = 1;
			}if (this.contadorGuion == 200) {
				this.velX = -1;
				this.contadorGuion = this.contadorGuion -200;
			}if (this.contadorGuion == 60) {
				System.out.println("aquí creamos bala enemiga");
				handler.addObject(new EnemyBullet(x, y, 0, 2));
			}
		}});
		this.addKeyListener(new Inputs(handler));
		handler.addObject(new PlayerObject(300, 300,handler));
	}
}
