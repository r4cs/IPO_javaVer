package com.entity;

// 2h35
import com.Utils.KeyHandler;
import com.Utils.Collisions;
import com.Utils.Position;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class Boundary extends Entity {
    private static int width;
    private static int height;
    public Position position;

    private static final Collisions vila = Collisions.VILA;

    private static final ArrayList<int[]> collisionsMap = new ArrayList<>();
static List<Boundary> boundaries = new ArrayList<>();

    public Boundary(Position position) {
        this.position = position;
        setDefaultValues();
    }

    public Boundary() {};

    public void setDefaultValues() {
        width = 48; // pixels
        height = 48; // pixels
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

     public static ArrayList<int[]> getCollisionsMap(){
        for (int i = 0; i< vila.getCollisions().length; i+=70) {
            int[] subArray = Arrays.copyOfRange(
                    vila.getCollisions(),
                    i,
                    70+i);
            collisionsMap.add(subArray);
        }
        return collisionsMap;
    }

    public List<Boundary> getBoundaries() {
        int z = 0;
        for (int[] row : getCollisionsMap()) {
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1025) {
                    boundaries.add(new Boundary(new Position(
                            j * Boundary.getWidth() + this.offset.getX(),
                            z * Boundary.getHeight() + this.offset.getY()
                    )));
                }
            }
            z++;
        }
        // testando o return getBoundaries() ---> testando no construtor de Background;
//        System.out.println( "boundaries.size(): " + boundaries.size() ); // 185
//        int counter = 0;
//        for (Boundary b : boundaries) {
//            System.out.println("Counter: " + counter);
//            counter++;
//            System.out.println("b.position.getX(): " + b.position.getX());
//            System.out.println("b.position.getY(): " + b.position.getY());
//            System.out.println("b.width: " + b.width);
//            System.out.println("b.height: " + b.height);
//            System.out.println("b.height: " + b.);
//        }
//        System.out.println("\n\n");
        return boundaries;
    }

    public void draw(Graphics2D g2) {
//        g2.setComposite(java.awt.AlphaComposite.getInstance((AlphaComposite.SRC_OVER), 0.2f));
        g2.setColor(new Color(255, 0, 0));
        g2.fillRect(
                position.getX(),
                position.getY(),
                getWidth(),
                getHeight()
        );

//        g2.fill(new Rectangle2D.Double(
//                position.getX(),
//                position.getY(),
//                getWidth(),
//                getHeight())
//        );
//
//
    }
}
