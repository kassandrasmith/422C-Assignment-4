import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Random;

public class Car {
    int bodyX = 00;
    int bodyY = 35;
    int bodyWidth = 60;
    int bodyHeight = 10;
    int frontTireX = 10;
    int frontTireY = 45;
    int frontTireWidth = 10;
    int frontTireHeight = 10;
    int rearTireX = 40;
    int rearTireY = 45;
    int rearTireWidth = 10;
    int rearTireHeight = 10;
    int r1x = 10;
    int r1y = 35;
    int r2x = 20;
    int r2y = 25;
    int r3x = 40;
    int r3y = 25;
    int r4x = 50;
    int r4y = 35;
    int flagX = 250;
    int carNumber = 0;
    Rectangle body;
    Ellipse2D.Double frontTire;
    Ellipse2D.Double rearTire;
    Point2D.Double r1;
    Point2D.Double r2;
    Point2D.Double r3;
    Point2D.Double r4;
    Point2D.Double flagPoleTop;
    Point2D.Double flagPoleEnd;
    // create the windshields and roof of the car
    Line2D.Double frontWindshield;
    Line2D.Double roofTop;
    Line2D.Double rearWindshield;
    Line2D.Double flagPole;
    Line2D.Double flagTop;
    Line2D.Double flagBottom;

    public Car() {
        int i=1;
        bodyY += (50 * i);
        frontTireY += (50 * i);
        rearTireY += (50 * i);
        r1y += (50 * i);
        r2y += (50 * i);
        r3y += (50 * i);
        r4y += (50 * i);
        carNumber += 1;

        body = new Rectangle(bodyX, bodyY, bodyWidth, bodyHeight);
        frontTire = new Ellipse2D.Double(frontTireX, frontTireY, frontTireWidth, frontTireHeight);
        rearTire = new Ellipse2D.Double(rearTireX, rearTireY, rearTireWidth, rearTireHeight);
        r1 = new Point2D.Double(r1x, r1y);
        r2 = new Point2D.Double(r2x, r2y);
        r3 = new Point2D.Double(r3x, r3y);
        r4 = new Point2D.Double(r4x, r4y);
        // create the windshields and roof of the car
        frontWindshield = new Line2D.Double(r1, r2);
        roofTop = new Line2D.Double(r2, r3);
        rearWindshield = new Line2D.Double(r3, r4);
        flagPole = new Line2D.Double(flagPoleTop, flagPoleEnd);

    }

    public Car(int i) {
        bodyY += (50 * i);
        frontTireY += (50 * i);
        rearTireY += (50 * i);
        r1y += (50 * i);
        r2y += (50 * i);
        r3y += (50 * i);
        r4y += (50 * i);
        carNumber += 1;

        body = new Rectangle(bodyX, bodyY, bodyWidth, bodyHeight);
        frontTire = new Ellipse2D.Double(frontTireX, frontTireY, frontTireWidth, frontTireHeight);
        rearTire = new Ellipse2D.Double(rearTireX, rearTireY, rearTireWidth, rearTireHeight);
        r1 = new Point2D.Double(r1x, r1y);
        r2 = new Point2D.Double(r2x, r2y);
        r3 = new Point2D.Double(r3x, r3y);
        r4 = new Point2D.Double(r4x, r4y);
        flagPoleTop = new Point2D.Double(310, 0);
        flagPoleEnd = new Point2D.Double(310, 500);
        // create the windshields and roof of the car
        frontWindshield = new Line2D.Double(r1, r2);
        roofTop = new Line2D.Double(r2, r3);
        rearWindshield = new Line2D.Double(r3, r4);
        flagPole = new Line2D.Double(flagPoleTop, flagPoleEnd);
    }


    public void draw(Graphics g) {
        Color burntOrange = new Color(255, 90, 10);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(burntOrange);
            g2.draw(this.body);
            g2.draw(this.frontWindshield);
            g2.draw(this.roofTop);
            g2.draw(this.rearWindshield);
            g2.setColor(Color.BLACK);
            g2.draw(this.frontTire);
            g2.draw(this.rearTire);
            g2.draw(this.flagPole);
            String carNumber = ("#" + this.carNumber);
            g2.drawString(carNumber, this.bodyX + 15, bodyY + 10);
    }

    public void moveX() {
        Random rand = new Random();
        int n = rand.nextInt(50) + 1;
            this.bodyX += n;
            this.frontTireX += n;
            this.rearTireX += n;
            this.r1x += n;
            this.r2x += n;
            this.r3x += n;
            this.r4x += n;
        body = new Rectangle(bodyX, bodyY, bodyWidth, bodyHeight);
        frontTire = new Ellipse2D.Double(frontTireX, frontTireY, frontTireWidth, frontTireHeight);
        rearTire = new Ellipse2D.Double(rearTireX, rearTireY, rearTireWidth, rearTireHeight);
        r1 = new Point2D.Double(r1x, r1y);
        r2 = new Point2D.Double(r2x, r2y);
        r3 = new Point2D.Double(r3x, r3y);
        r4 = new Point2D.Double(r4x, r4y);
        // create the windshields and roof of the car
        frontWindshield = new Line2D.Double(r1, r2);
        roofTop = new Line2D.Double(r2, r3);
        rearWindshield = new Line2D.Double(r3, r4);
    }

}
