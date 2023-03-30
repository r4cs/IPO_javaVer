package com.Main;
import com.Utils.KeyHandler;
import com.Utils.Position;
import com.entity.Background;
import com.entity.Boundary;
import com.entity.Player;
import com.entity.Renderables;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel  implements Runnable {
//    final int originalTileSize = 16;
//    final int scale = 3;
    public final int tileSize = 48; //originalTileSize * scale; // 48x48 tile
    final int screenWidth = 1200; // = tileSize * maxScreenCol; 768
    final int screenHeight = 900; // = tileSize * maxScreenRow;  576

    int FPS = 60;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    Background bc = new Background(this, keyH);
    Player p = new Player(this, keyH);
    Boundary bd = new Boundary();

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    // delta game loop
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        bc.update();
        p.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        try {
            bc.draw(g2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            bd.getBoundaries().forEach(boundary -> boundary.draw(g2));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            p.draw(g2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        g2.dispose();
    }
}
