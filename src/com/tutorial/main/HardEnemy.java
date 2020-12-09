package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class HardEnemy extends GameObject {

    private Handler handler;

    private BufferedImage hardEnemy_image;
    private Random r = new Random();

    public HardEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 2;
        velY = 2;

        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);

        hardEnemy_image = ss.grabImage(4, 4, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int) y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;

//        if(y <= 0 || y >= Game.HEIGHT - 64) { if(velY < 0) velY = -(r.nextInt(7) + 1)* -1; else velY = (r.nextInt(7) + 1)* -1; };
//        if(x <= 0 || x >= Game.WIDTH - 64) { if(velX < 0) velX = -(r.nextInt(7) + 1)* -1; else velX = (r.nextInt(7) + 1)* -1; };
        if(y <= 0 || y >= Game.HEIGHT - 64) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 48) velX *= -1;

//        handler.addObject(new Trail((int)x, (int) y, ID.Trail, Color.ORANGE, 16, 16, 0.04f, handler));

    }

    public void render(Graphics g) {
        g.drawImage(hardEnemy_image, (int)x, (int)y, null);

    }
}
