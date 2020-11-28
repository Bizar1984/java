package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();
    private float redValue = 150;
    private int counter = 0;
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    public void tick() {

        x += velX;
        y += velY;

        x = Game.clamp(((int)x), 0, Game.WIDTH - 48);
        y = Game.clamp((int)y, 0, Game.HEIGHT - 70);



        collision();

    }

    private void collision() {
        for(int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy) {

                // collision code
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 2;

                }
            }

            redValue = (int) Game.clamp((int)redValue, 0, 255);

            if(tempObject.getId() == ID.SmartEnemy) {

                // collision code
                if (getBounds().intersects(tempObject.getBounds())) {
                    redValue++;

                }
            }

        }
    }

    public void render(Graphics g) {
        if(id == ID.Player) g.setColor(Color.yellow);

        if(id == ID.Player) g.setColor(new Color((int) redValue, 50, 180));

        if(id == ID.BasicEnemy) g.setColor(Color.red);

        g.fillRect((int)x, ((int)y), 32, 32);

    }


    public Rectangle getBounds() {
        return new Rectangle((int)x, ((int)y), 32, 32);
    }


}
