package com.tutorial.main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();
    public int timer = 0;
    private int healthIncrease = 10;
    private float redValue = 150;
    Handler handler;

    private BufferedImage player_image;



    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        // super can be used to invoke immediate parent class constructor
        this.handler = handler;

        // what is this handler doing? Adding, removing objects and clearing enemies
        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);

        player_image = ss.grabImage(1, 3, 32, 32);
    }

    public void tick() {

        x += velX;
        y += velY;

        x = Game.clamp(((int)x), 0, Game.WIDTH - 48);
        y = Game.clamp((int)y, 0, Game.HEIGHT - 70);
        // how could we clamp the height only to 50 where the health bar is located?
        timer++;


        collision();

    }

    private void collision() {
        for(int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.HardEnemy) {

                // collision code
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 1;
                }
            }
            if(tempObject.getId() == ID.PotionEnemy) {

                // collision code
                if (getBounds().intersects(tempObject.getBounds())) {

                    HUD.HEALTH -= 1;
                    handler.speedW = handler.slow;
                    handler.speedA = handler.slow;
                    handler.speedS = handler.slow;
                    handler.speedD = handler.slow;
                    // this will slow you down. How could we make this a temporary effect?
                    // or may be add another potion that resets the speed for now
                }

            }
            if(tempObject.getId() == ID.PotionFriend) {

                // collision code
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH += 3;
                    handler.speedW = handler.speedReset;
                    handler.speedA = handler.speedReset;
                    handler.speedS = handler.speedReset;
                    handler.speedD = handler.speedReset;



                }

            }

            redValue = (int) Game.clamp((int)redValue, 0, 255);

            if(tempObject.getId() == ID.SmartEnemy) {

                // collision code
                if (getBounds().intersects(tempObject.getBounds())) {
                    redValue++;

                }
            }
            if(tempObject.getId() == ID.EnemyBoss) {
                // collision code



            }

        }
    }

    public void render(Graphics g) {

//        if(id == ID.Player) g.setColor(new Color((int) redValue, 50, 180));
//
//
//
//        g.fillRect((int)x, ((int)y), 32, 32);
        g.drawImage(player_image, (int)x, (int)y, null);


    }


    public Rectangle getBounds() {
        return new Rectangle((int)x, ((int)y), 32, 32);
    }


}
