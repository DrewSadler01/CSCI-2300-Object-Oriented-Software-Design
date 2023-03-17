package view;

/*
 * Movable image
 */

import model.PointObserver;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.Rectangle;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class MovableImage extends JLabel implements Icon, PointObserver
{
   private String source;
   private Image image;
   private int width;
   private int height;
   private int x;
   private int y;

   public MovableImage(String source, int width, int height)throws IOException{
      this.source = source;
      this.x = 0;
      this.y = 0;
      this.width = width;
      this.height = height;
      image = ImageIO.read(new File(source));
      // scale down the image
      image = image.getScaledInstance(this.width/2, this.height/2, Image.SCALE_DEFAULT);
      super.setIcon(this);
   }

   
   @Override 
   public void update(int x, int y)
   {
      this.x = x;
      this.y = y;
      this.revalidate();
      this.repaint();
   }

   @Override
   public int getIconWidth()
   {
      return this.width;
   }

   @Override
   public int getIconHeight()
   {
      return this.height;
   }

   @Override   
   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      g.drawImage(image, x + this.x, y + this.y, null);   
   }
}
