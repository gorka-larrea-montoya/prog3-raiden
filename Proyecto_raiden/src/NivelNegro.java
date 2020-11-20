import java.awt.Color;

public class NivelNegro extends GameMain {
	private static final long serialVersionUID = 2160909145754779743L;
	public NivelNegro() {
		this.colortest = Color.black;
		handler = new GameHandler();
		handler.addObject(new Box(100,300,0,0,ID.Block));
		handler.addObject(new Box(400,200,0,0,ID.Block));
		this.addKeyListener(new Inputs(handler));
		handler.addObject(new PlayerObject(300, 300,handler));
	}
	
}
