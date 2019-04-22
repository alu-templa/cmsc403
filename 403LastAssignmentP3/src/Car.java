import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Car extends JComponent implements Runnable {
    public BufferedImage image;
    public int xPosition;
    public int yPosition;

    public Car(int xPosition, int yPosition){
        try {
            this.image = ImageIO.read(new File("sportive-car.png"));
            this.xPosition = xPosition;
            this.yPosition = yPosition;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean isDriving(){
        return this.xPosition < 400;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, xPosition, yPosition, this);
    }

    @Override
    public void run(){
        try{
            Random random = new Random();
            this.xPosition = xPosition + random.nextInt(10);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
