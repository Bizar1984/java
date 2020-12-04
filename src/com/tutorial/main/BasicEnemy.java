package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BasicEnemy extends GameObject {

    private Handler handler;

    private BufferedImage enemy_image;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 5;
        velY = 5;

        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);

        enemy_image = ss.grabImage(1, 1, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int) y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 48) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;

//        handler.addObject(new Trail((int)x, (int) y, ID.Trail, Color.RED, 16, 16, 1.0f, handler));

    }

    public void render(Graphics g) {
        g.drawImage(enemy_image, (int)x, (int)y, null);

    }
}
