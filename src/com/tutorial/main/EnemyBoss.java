package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemyBoss extends GameObject {

    private Handler handler;
    private GameObject player;

    private BufferedImage enemyBoss_image;

    Random r = new Random();

    private int timer = 80;
    private int timer2 = 50;

    public EnemyBoss(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
        }

        velX = 0;
        velY = 2;

        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);

        enemyBoss_image = ss.grabImage(1, 3, 64, 62);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int) y, 64, 64);
    }

    public void tick() {
        x += velX;
        y += velY;

        float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

        if(distance < 100) {
            HUD.HEALTH--;
        }

        if (timer <= 0) velY = 0;
        else timer--;

        if (timer <= 0) timer2--;
        if (timer2 <= 0) {
            if(velX == 0) velX = 2;
            if(velX > 0) {
                velX += 0.005f;
            } else if(velX < 0) {
                velX -= 0.005f;
            }
            velX = Game.clamp(velX, -5, 5);
            int spawn = r.nextInt(6);
            if(spawn == 0) handler.addObject(new EnemyBossBullet((int)x + 48, (int)y + 48, ID.BasicEnemy, handler));
        }



        if(x <= 0 || x >= Game.WIDTH - 96) velX *= -1; 

//        handler.addObject(new Trail((int)x, (int) y, ID.Trail, Color.blue, 64, 32, 1.0f, handler));

    }

    public void render(Graphics g) {
        g.drawImage(enemyBoss_image, (int)x, (int)y, null);

    }
}
