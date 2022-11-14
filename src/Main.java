import javax.swing.*;
import java.awt.*;

public class Main extends JFrame implements Elements{
    static JFrame frame;
    static boolean done = false;
    public static DrawWindow drawPanel;

    public static Quad quadTest;

    public static void main(String[] args) {
        System.out.println("3D ENGINE (Java Edition)");
        init();
        try{
            new Main().prepareGui();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void init(){
        System.out.println("Loading... NO REFUNDS");
        double[] xCoords = {-100, 100, 100, -100};
        double[] yCoords = {100, 100, -100, -100};

        quadTest = new Quad(new Color(255, 255, 255), 409, 413, xCoords, yCoords);

        //quadTest.rotate(45);
        System.out.println(quadTest);
    }

    private void prepareGui() {
        frame = new JFrame("**** 3D Engine ****");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        drawPanel = new DrawWindow();

        new Input(drawPanel);

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setResizable(false);
        drawPanel.setFocusable(true);
        drawPanel.requestFocusInWindow();


        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        update();
    }

    public static void update() {
        try{
            while (!done) {
                quadTest.update();
                Thread.sleep(14);
                frame.repaint();
            }
        }catch(Exception ignored){ }

        System.out.println("GAME OVER!!!");
    }
}
