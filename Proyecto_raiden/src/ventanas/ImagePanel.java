package ventanas;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import logica_interna.*;

public class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel() {
       try {                
          image = ImageIO.read(new File("./resources/player2.png"));
       } catch (IOException ex) {
           System.out.println("Error al cargar la imagen");
       }
      
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

}