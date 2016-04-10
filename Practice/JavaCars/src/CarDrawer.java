/**
 * the purpose of this example applet it to draw a boxy car out of
 * basic graphical shapes (rectangles, circles and lines) on the applet
 * window. It's position and size has been predetermined by sketching
 * it out on graph paper first. The specific values of the coordinates
 * of the shapes have been arbitrarily chosen.
 */

import java.applet.Applet;
import java.awt.*;

public class CarDrawer extends Applet implements Runnable {
    Car[] cars = new Car[5];
    boolean atEnd = false;
    Dimension appletSize = this.getSize();
    int appletWidth = appletSize.width;

    public void paint(Graphics g) {
        for (int i = 0; i < 5; i++) {
           if(!atEnd) cars[i].moveX() ;
            else stop();
           if (cars[i].bodyX >= 250){
               atEnd = true;
           }
            cars[i].draw(g);
        }
    }
    Thread runner;
    public void start() {
        if (runner == null) {
            runner = new Thread(this);
            for (int i = 0; i < 5; i++) {
                cars[i] = new Car(i);
                cars[i].carNumber = i;
            }
            runner.start();
        }
    }

    public void stop() {
        if (runner != null) {
            runner.stop();
            runner = null;
        }
    }

    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
} // end of CarDrawer