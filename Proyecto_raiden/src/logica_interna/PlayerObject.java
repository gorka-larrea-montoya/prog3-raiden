package logica_interna;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.LinkedList;

import javax.imageio.ImageIO;
public class PlayerObject extends GameObject {

	GameHandler handler;
	String name;
	int health;
	int speed;
	int score = 0;
	int killCount = 0;


	Mejoras mejoraActual = Mejoras.ESTANDAR;
	
	BufferedImage playerImage;
	//String playerPath = "resources/player.png";
//	Image plyr = this.getClass().getResource(playerPath);

	public PlayerObject(int x, int y, GameHandler handler, String name,int health, int score, int killCount) {
		super(x, y);
		this.handler = handler;
		this.name = name;
		this.health = 100;
		this.speed = (int) 4 ;
		this.id = ID.Player;
		this.mejoraActual = getMejoraActual();
		this.score = score;
		this.killCount = killCount;
		
	    try{
	    	 playerImage = ImageIO.read(new File("./resources/player2.png"));
	        }catch(IOException e){
	        	e.printStackTrace();}
	        catch(Exception e){e.printStackTrace();}
	    }

	/*public PlayerObject(int x, int y, GameHandler handler) {
		super(x, y);
		this.name = VentanaPrincipal.player.getName();
		this.handler = null;;
		this.health = 100;
		speed = (int) 4 ;
		this.id = ID.Player;
		this.mejoraActual = getMejoraActual();
		this.score = 0;
	
	    }
	*/
	//public void PlayerObjectSetName(String name) {
	//	this.name = VentanaPrincipal.sendName(playerName);
		
	/*public PlayerObject PlayerObjectTabla(String name, int score, int enemiesKilled, String date){
	new PlayerO;
	this.score = this.
		return PlayerObjectTabla(name, score, enemiesKilled, date);
	};*/
	public PlayerObject(int killCount) {
	this.name = name;
	this.score = score;
	this.killCount = killCount;
		
	};
	
	public int getKillCount() {
		return killCount;
	}

	public void setKillCount(int killCount) {
		this.killCount = killCount;
	}

	public PlayerObject(String name, int x, int y, GameHandler handler) {
		super(x, y);
		this.name = name;
		}
	
	public PlayerObject(int x,int y) {
		this.name = name;
		// TODO Auto-generated constructor stub
	}


	//}
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String nombre) {
		this.name = nombre;
	}

	public Mejoras getMejoraActual() {
	
		return mejoraActual;
	}
	public void setMejoraActual(Mejoras mejoraActual) {
		this.mejoraActual = mejoraActual;
	}
	public void tick() {
		x += velX;
		y += velY;
		colision();
		//tiene el fallo de que al pulsar direcciones opuestas lo resuelve con la que tiene la linea escrita mas tarde. Habr�a que reescribir mucho para arreglarlo
		if (handler.isDown()) {	velY =+ speed;}else if (!handler.isUp()) {velY = 0;}
		if (handler.isUp()) {velY =- speed;}else if (!handler.isDown()) {velY = 0;}
		if (handler.isLeft()) {velX =- speed;}else if (!handler.isRight()) {velX = 0;}
		if (handler.isRight()) {velX =+ speed;}else if (!handler.isLeft()) {velX = 0;}
	}
	public void colision() {
		for (int i = 0; i < handler.objectList.size(); i++) {
			GameObject object = handler.objectList.get(i);
			if (object.id != ID.Player && object.id != ID.Bullet) {
				if(getRectangle().intersects(handler.objectList.get(i).getRectangle())){
			
							if (object.id == ID.EnemyBullet){
							//setHealth(getHealth() - 25);
							//System.out.println("Player HP: " + getHealth());
					//System.out.println("el jugador esta chocando con " + object.id);
				}
				
			}
			
		}
	}
	}
	

	public void render(Graphics g) {
	//	g.setColor(Color.GREEN);
	//	g.fillRect(x, y, 46, 38);
	};
	
//	public void paint(Graphics2D g2) {
//	g2.drawImage(playerImage, null, null);
//}

	 public void paint(Graphics2D g2){
	        AffineTransform at = new AffineTransform();
	       at.translate((int)x + 48 , (int)this.y + 38); 
	       at.rotate(Math.PI);
	    //   at.translate(playerImage.getWidth()/4, playerImage.getHeight()/4);
	        g2.drawImage(playerImage, at, null);
	    }
	
	 
	public Rectangle getRectangle() {
		return new Rectangle(x,y,46,38);
	}

	

	public void checkHealth() {
		if (getHealth() <= 0) {
			
			handler.removeobject(this);
		}
		
	}

	@Override
	public String toString() {
		return 	"Name: " + name + "\n"
				+ "Health=" + health +"\n"
				+ "Score=" + GameMain.getScore();
	}
	
	public void killedEnemy() {
		int scoree = getScore() +5 ;
		setScore(scoree);
	}
	
	
	public String PartidaToString() {
		String name =  getName();
		String score = Float.toString(GameMain.getScore());
		return (name + "," + (int) GameMain.getScore() + "," + (int) GameMain.getEnemiesKilledMain() + "," + GameMain.getDateString());
	}
	
	String s = this.PartidaToString();
	
	String[] tablaDatosFila = s.split(",");
	String nombreTable = tablaDatosFila[0];
	String scoreTable = tablaDatosFila[1];
	String enemiesKilledTable = tablaDatosFila[2];
	String dateTable = tablaDatosFila[3];
	
	PlayerObjectTabla pTabla = new PlayerObjectTabla(nombreTable, scoreTable, enemiesKilledTable, dateTable);
	
}
