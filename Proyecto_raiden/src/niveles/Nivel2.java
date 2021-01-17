package niveles;
import java.awt.Color;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import logica_interna.*;
import ventanas.Ventana;


public class Nivel2 extends GameMain {
	private static final long serialVersionUID = 6317331953250680569L;
	PlayerObject player;

	private String saveDataPath;
	private String fileName = "SaveData";


	public Nivel2(String nomString){
		handler = new GameHandler();
		this.setColortest(new Color(0, 0, 0));
		new Ventana(1000, 600, "Nivel 2", this);
		//this.paint();
		start();



		float f = (float) (Math.random() * 1001);
		setHandler(handler);
		//handler.addObject(new Block(100,0,0,0,ID.Block));
		//handler.addObject(new Block(200,0,0,0,ID.Block));


		for(float i = 0; i < 20; i++) {
			getHandler().addObject(new Enemy(i*35 ,-250.0 , 0.2, 1.75, ID.Enemy, getHandler()));

		}




		getHandler().addObject(new Enemy(250 ,250 , (int)0.6, (int)0.75, ID.Enemy, getHandler()));
		getHandler().addObject(new Enemy(310 ,250 , (int)0.6, (int)0.75, ID.Enemy, getHandler()));
		getHandler().addObject(new Enemy(340 ,250 , (int)0.6, (int)0.75-1, ID.Enemy, getHandler()));







		/*	handler.addObject(new Enemy(430,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(460,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(490,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(520,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(550,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(580,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(610,0,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(640,0,0,0, ID.Enemy, handler));

		handler.addObject(new Enemy(430,30,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(460,30,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(490,30,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(520,30,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(550,30,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(580,30,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(610,30,0,0, ID.Enemy, handler));
		handler.addObject(new Enemy(640,30,0,0, ID.Enemy, handler));

		handler.addObject(new MejoraDoble(600,70,0,0));
		 */	

		this.addKeyListener(new Inputs(getHandler()));
		//player.setName(playername);
		//player.setX(300);
		//player.setY(300);
		//player.handler = handler;
		player = new PlayerObject(300, 300, getHandler(), nomString, 100, 0,0);

		getHandler().addObject(player);

		System.out.println(player.toString());
	}	

	private void createSaveData() {
		try {
			File file = new File(saveDataPath, fileName);
			FileWriter output = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(output);
			writer.write((int) getScore());;
			writer.close();
			//
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}


	private void loadHighScore() {
		try {
			File f = new File(saveDataPath, fileName);
			if(f.isFile()) {
				createSaveData();
			}

			BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(new FileInputStream(f)));
			//highScore = Integer.parseInt(reader.readLine());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private void setHighScore() {
	}


	public void getPlayer() {

	}
}	

/*	public void paint(Graphics g){
			Font font  = new Font("Serif",Font.BOLD, 36);
			g.setFont(font);
			g.setColor(Color.WHITE);

			g.drawString(Integer.toString(GameMain.score), 200, 150);

		}
 */
