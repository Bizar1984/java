package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemyBossBullet extends GameObject {

    private Handler handler;

    private BufferedImage enemyBossBullet_image;
    Random r = new Random();

    public EnemyBossBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = (r.nextInt(10 - -1) - 5);
        velY = (r.nextInt(20) + 4);

        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);

        enemyBossBullet_image = ss.grabImage(2, 4, 16, 16);
    }

    public Rectangle getBounds() {

        return new Rectangle((int)x, (int) y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        //if(y <= 0 || y >= Game.HEIGHT - 48) velY *= -1;
        //if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;

        if(y >= Game.HEIGHT) handler.removeObject(this);

//        handler.addObject(new Trail((int)x, (int) y, ID.Trail, Color.blue, 16, 16, 1.0f, handler));

    }

    public void render(Graphics g) {
        g.drawImage(enemyBossBullet_image, (int)x, (int)y, null);
    }
}

