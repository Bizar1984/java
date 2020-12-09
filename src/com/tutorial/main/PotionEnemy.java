package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PotionEnemy extends GameObject {

    private Handler handler;

    private BufferedImage potion_image;

    public PotionEnemy(int x, int y, ID id, Handler  handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 1;
        velY = 1;

        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);

        potion_image = ss.grabImage(3, 3, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int) y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;

//         how can we prevent the enemies to hit the health bar? Found another trick!
//         why 96 pixels is working for an image with a height of 64 pixels?
        if(y <= 0 || y >= Game.HEIGHT - 96) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 64) velX *= -1;

//        handler.addObject(new Trail((int)x, (int) y, ID.Trail, Color.RED, 16, 16, 1.0f, handler));

    }

    public void render(Graphics g) {
        g.drawImage(potion_image, (int)x, (int)y, null);

    }
}

