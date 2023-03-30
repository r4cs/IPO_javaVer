package com.entity;

import com.Utils.KeyHandler;
import com.Main.GamePanel;
import com.Utils.Position;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    HashMap<String, Integer> framesList = new HashMap<>();
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

    GraphicsConfiguration gc = ge.getDefaultScreenDevice().getDefaultConfiguration();
    public Position position = new Position();

    public Player() {
        setDefaultValues();
        getPlayerImage();
    }
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp; // so usa aqui, precisa msm?
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        position.setX(330);
        position.setY(295);
        direction = 2;
        this.framesList.put("max", 4);
        this.framesList.put("elapsed", 0);
        this.framesList.put("val", 0);
    }

    public HashMap<String, BufferedImage> getPlayerImage() {
        try {
            sprites.put(
                    "playerUp",
                    ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/imgs/playerUp.png"))));

            sprites.put(
                    "playerDown",
                    ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/imgs/playerDown.png"))));

            sprites.put(
                    "playerLeft",
                    ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/imgs/playerLeft.png"))));

            sprites.put(
                    "playerRight",
                    ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/imgs/playerRight.png"))));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return sprites;
        }
    }

    public void update() {
        if (keyH.upPressed) {
            direction = 0;
        } else if (keyH.rightPressed) {
            direction = 1;
        } else if (keyH.downPressed) {
            direction = 2;
        } else if (keyH.leftPressed) {
            direction = 3;
        }
    }


    public void draw(Graphics2D g2) throws Exception {
        switch (direction) {
            case 0 -> { // up
                image = sprites.get("playerUp");
            }
            case 1 -> { // right
                image = sprites.get("playerRight");
            }
            case 3 -> { // left
                image = sprites.get("playerLeft");
            }
            default -> { // down
                image = sprites.get("playerDown");
            }
        }
        ;
        int frameWidth = image.getWidth() / framesList.get("max");
        int frameX = framesList.get("val") * frameWidth;
        g2.drawImage(
                image,
                position.getX(), // dx1 canto superior esquerdo do destino
                position.getY(), // dy1 canto superior esquerdo do destino
                position.getX() + frameWidth, // dx2 canto inferior direito do destino
                position.getY() + image.getHeight(), // dy2 canto inferior direito do destino
                frameX, // sx1 canto superior esquerdo da origem
                0, // sy1 canto superior esquerdo da origem
                frameX + frameWidth,  // sx2 canto inferior direito da origem
                image.getHeight(), // sy2 canto inferior direito da origem
                null // observer
        );
//        if (!moving) return; onde incluir isso? acho que mais pra frente no GamePanel
        if (framesList.get("max") > 1) {
            framesList.replace("elapsed", framesList.get("elapsed")+1);
        }
        if (framesList.get("val") < (framesList.get("max") - 1)) {
            framesList.replace("val", (framesList.get("val") + 1));
        } else {
            framesList.replace("val", 0);
        }
    }
}