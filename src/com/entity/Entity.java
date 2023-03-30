package com.entity;
import com.Main.GamePanel;
import com.Utils.KeyHandler;
import com.Utils.Position;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Entity {
    public HashMap<String, BufferedImage> sprites = new HashMap<>();
    public Position position = new Position();
    public BufferedImage image;
    public int direction;
    public int velocity;
    public Position offset = new Position(-900, -550);

    GamePanel gp;
    KeyHandler keyH;
    Boolean moving = false;


//    public void draw() {}

}

