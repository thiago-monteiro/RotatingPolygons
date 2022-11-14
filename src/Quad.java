import java.awt.*;
import java.util.Arrays;

public class Quad implements Elements{

    double[] xCoords = new double[4];
    double[] yCoords = new double[4];

    double[] xOrigin;
    double[] yOrigin;

    int[] xC = new int[4];
    int[] yC = new int[4];

    double angle = 0.0;

    private final int geomCenterX, geomCenterY;

    Color color;

    boolean debug = true;

    public Quad(Color color, int geomCenterX, int geomCenterY, double[] xOrigin, double[] yOrigin){
        this.color = color;

        this.geomCenterX = geomCenterX;
        this.geomCenterY = geomCenterY;

        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;

        this.rotate(0);
    }

    void rotate(double deg){
        double rad = deg * PI / 180.00;

        //System.out.println("The degree of: " + deg + " in radians is: " + rad);

        for (int i = 0; i < 4; i++){
            //double x = xOrigin[i] * Math.cos(rad) - yOrigin[i] * Math.cos(rad);
            double x = xOrigin[i] - yOrigin[i];
            double y = yOrigin[i] * Math.cos(rad) + xOrigin[i] * Math.sin(rad);
            //double y = yOrigin[i] + xOrigin[i];

            xC[i] = (int) (x + geomCenterX);
            yC[i] = (int) (y + geomCenterY);
        }
    }

    void update(){
        this.angle += 1.0;
        this.rotate(this.angle);
    }

    void draw(Graphics g){
        g.setColor(color);
        g.fillPolygon(xC, yC, 4);

        if (debug){
            g.setColor(Color.MAGENTA);
            g.drawString("A", xC[0] - 4, yC[0] - 4);
            g.drawString("B", xC[1] + 4, yC[1] + 4);
            g.drawString("C", xC[2] - 4, yC[2] + 12);
            g.drawString("D", xC[3] - 10, yC[3] + 4);
        }
    }

    @Override
    public String toString(){
        return "\n X Integer Coordinates: \n" + Arrays.toString(xC)
                + "\n Y Integer Coordinates: \n" + Arrays.toString(yC);
    }
}
