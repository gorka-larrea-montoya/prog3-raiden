package propiedades;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class myProperties {
	public static void main(String[] args) {
		try (OutputStream output = new FileOutputStream("./propiedades/config.properties")){
			Properties prop = new Properties();
			//CREA LAS PROPIEDADES
			prop.setProperty("KeyEventUp", Integer.toString(KeyEvent.VK_W));
			prop.setProperty("KeyEventDown", Integer.toString(KeyEvent.VK_S));
			prop.setProperty("KeyEventLeft", Integer.toString(KeyEvent.VK_A));
			prop.setProperty("KeyEventRight", Integer.toString(KeyEvent.VK_D));
			prop.setProperty("KeyEventShoot", Integer.toString(KeyEvent.VK_SPACE));
			
			//GUARDA LAS PROPIEDADES
			prop.store(output, null);
			System.out.println("culo");
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
}
