package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class JokerEnemy extends GameObject {

    private Handler handler;

    private BufferedImage jokerEnemy_image;

    private GameObject player;

    private double angle = 0.1;
    private final double MAX_X = 150;
    private final double MAX_Y = 150;

    public JokerEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);

        jokerEnemy_image = ss.grabImage(4, 3, 32, 32);
        // this is important, otherwise the player.getX() returns null
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int) y, 32, 32);
    }

    public void tick() {

        angle++;
    }

    public void render(Graphics g) {
        double random = angle * 2.0 * Math.PI/360.0; //this will convert it to rads
        // rotate around P(0/0)
        int x = (int) (Math.cos(random) * MAX_X);
        int y = (int) (Math.sin(random) * MAX_Y);

        // move P to center of JFrame (width and height = 1000)
        x += 320;
        y += 240;

        // image is 500x300, calc upper left corner
        x -= 32;
        y -= 32;
        g.drawImage(jokerEnemy_image, x, y, null);

    }
}


