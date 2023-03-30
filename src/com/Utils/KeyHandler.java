package com.Utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Character lastKey = Character.MIN_VALUE;
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = true;
            lastKey = 'w';
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
            lastKey = 's';
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
            lastKey = 'a';
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
            lastKey = 'd';
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
