package com.tutorial.main;

import java.awt.*;

public class HUD {

    public int bounds = 0;
    public static float HEALTH = 100;

    private float greenValue = 255;

    public int score = 0;
    private int level = 1;

    public void tick() {
        HEALTH = (int) Game.clamp((int)HEALTH, 0, 100 + (bounds/2));
        // divide it by two because we multiply health by two
        greenValue = HEALTH * 2;
        // if you switch around the statements above and below you get errors, why?
        greenValue = (int) Game.clamp((int)greenValue, 0, 255);



        score++;

    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200 + bounds, 32);

        g.setColor(new Color(125, (int)greenValue, 0));
        g.fillRect(15, 15, (int) (HEALTH * 2), 32);

        g.setColor(Color.white);
        g.drawRect(15, 15, 200 + bounds, 32);

        g.drawString("Score: " + score, 15, 64);
        g.drawString("Level: " + level, 15, 80);
        g.drawString("Space for Shop: ",15, 94);
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }


}
