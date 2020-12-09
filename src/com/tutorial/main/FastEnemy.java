package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FastEnemy extends GameObject {

    private Handler handler;

    private BufferedImage fastEnemy_image;

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 8;
        velY = 8;

        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);

        fastEnemy_image = ss.grabImage(2, 3, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int) y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 48) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;

//        handler.addObject(new Trail((int)x, (int) y, ID.Trail, Color.CYAN, 16, 16, 1.0f, handler));

    }

    public void render(Graphics g) {
        g.drawImage(fastEnemy_image, (int)x, (int)y, null);

    }
}

