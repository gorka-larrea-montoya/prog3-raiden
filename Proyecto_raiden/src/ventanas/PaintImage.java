package ventanas;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class PaintImage extends JPanel
{
  public static BufferedImage image;
 
  public PaintImage (String path)
  {
    super();
    try
    {               
      image = ImageIO.read(new File(path));
    }
    catch (IOException e)
    {
     System.out.println("error al cargar la imagen");
    }
  }

  public void paintComponent(Graphics g)
  {
    g.drawImage(image, 0, 0, null);
    repaint();
  }
}