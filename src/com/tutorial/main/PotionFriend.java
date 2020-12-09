package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PotionFriend extends GameObject {

    private Handler handler;

    private BufferedImage potion_friend;

    public PotionFriend(int x, int y, ID id, Handler  handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 3;
        velY = 3;

        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);

        potion_friend = ss.grabImage(3, 4, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int) y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;

//         how can we prevent the enemies to hit the health bar? Found another trick!
//         why 96 pixels is working for an image with a height of 64 pixels?
        if(y <= 0 || y >= Game.HEIGHT - 64) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 64) velX *= -1;

//        handler.addObject(new Trail((int)x, (int) y, ID.Trail, Color.RED, 16, 16, 1.0f, handler));

    }

    public void render(Graphics g) {
        g.drawImage(potion_friend, (int)x, (int)y, null);

    }
}

