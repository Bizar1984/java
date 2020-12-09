package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SmartEnemy extends GameObject {

    private Handler handler;

    private BufferedImage smartEnemy_image;

    private GameObject player;

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);

        smartEnemy_image = ss.grabImage(2, 3, 32, 32);
        // this is important, otherwise the player.getX() returns null
         for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int) y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 2;
        float diffY = y - player.getY() - 2;
        float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

        velX = (float) ((-2.0/distance) * diffX);
        velY = (float) ((-2.0/distance) * diffY);

        if(y <= 0 || y >= Game.HEIGHT - 48) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;

//        handler.addObject(new Trail((int)x, (int) y, ID.Trail, Color.YELLOW, 16, 16, 0.99f, handler));

    }

    public void render(Graphics g) {
        g.drawImage(smartEnemy_image, (int)x, (int)y, null);

    }
}

