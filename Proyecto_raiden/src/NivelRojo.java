import java.awt.Color;

public class NivelRojo extends GameMain{
	private static final long serialVersionUID = -601629228271885895L;
	public void tick(){ 
		
		
		ContadorGuion++;
		handler.tick();
		//System.out.println(ContadorGuion);
		
		
	}
	public NivelRojo() {
		this.colortest = Color.red;
		
		
		
		handler = new GameHandler();
		handler.addObject(new Box(100,200,0,0,ID.Block));
		handler.addObject(new Box(200,100,0,0,ID.Block) {
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
			}if (this.contadorGuion % 30 == 0) {
				//System.out.println("aquí creamos bala enemiga");
				handler.addObject(new EnemyBullet(x+10, y+10, 0, 2));
			}
		}});
		this.addKeyListener(new Inputs(handler));
		handler.addObject(new PlayerObject(300, 300,handler));
	}
}
