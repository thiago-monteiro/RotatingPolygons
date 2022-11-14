import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Resources {
    public static BufferedImage LoadImage(String filename){
        BufferedImage img = null;

        try {
            img = ImageIO.read(Resources.class.getResourceAsStream("/res/" + filename + ".png"));
        }catch (IOException e) {
            System.out.println("Error while reading " + filename);
            e.printStackTrace();
        }

        return img;
    }
}
