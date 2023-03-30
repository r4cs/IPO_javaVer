package com.entity;

import com.Main.GamePanel;
import com.Utils.KeyHandler;
import com.entity.Boundary;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


public class Background extends Entity {
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

    GraphicsConfiguration gc = ge.getDefaultScreenDevice().getDefaultConfiguration();
    Boundary b = new Boundary();
    public Background(GamePanel gp, KeyHandler keyH) {
        this.gp = gp; // so usa aqui, precisa msm?
        this.keyH = keyH;
        this.moving = false;
        setDefaultValues();
        // testando o return getBoundaries();
//        System.out.println("b.getBoundaries(): " + b.getBoundaries());
    }
    public void setDefaultValues() {
        position.setX(-900);
        position.setY(-550);
        velocity = 3;
    }

    public void update() {
        if (keyH.upPressed) {
            direction = 0;
            position.setY(position.getY()+velocity);
        } else if (keyH.downPressed) {
            direction = 2;
            position.setY(position.getY()-velocity);
        } else if (keyH.leftPressed) {
            direction = 3;
            position.setX(position.getX()+velocity);
        } else if (keyH.rightPressed) {
            direction = 1;
            position.setX(position.getX()-velocity);
        }
    }

    public void draw(Graphics2D g2) throws IOException {
        BufferedImage image = null;
        image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/imgs/PelletTown.png")));
        g2.drawImage(
                image,
                position.getX(),
                position.getY(),
                image.getWidth(),
                image.getHeight(),
                null);
    }
}
