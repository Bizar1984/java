package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class EnemyBoss extends GameObject {

    private Handler handler;

    Random r = new Random();

    private int timer = 80;
    private int timer2 = 50;

    public EnemyBoss(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 0;
        velY = 2;
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int) y, 64, 64);
    }

    public void tick() {
        x += velX;
        y += velY;

        //if(y <= 0 || y >= Game.HEIGHT - 48) velY *= -1;
        //if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
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
            int spawn = r.nextInt(10);
            if(spawn == 0) handler.addObject(new EnemyBossBullet((int)x + 48, (int)y + 48, ID.BasicEnemy, handler));
        }



        if(x <= 0 || x >= Game.WIDTH - 96) velX *= -1;

        handler.addObject(new Trail((int)x, (int) y, ID.Trail, Color.blue, 64, 32, 0.8f, handler));

    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int)x, (int) y, 64, 64);

    }
}
