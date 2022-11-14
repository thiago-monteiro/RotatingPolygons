import javax.swing.*;
import java.awt.*;

public class DrawWindow extends JPanel implements Elements{
    public void paintComponent (Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        Main.quadTest.draw(g);
    }
}
