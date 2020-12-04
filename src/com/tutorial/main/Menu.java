package com.tutorial.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    public Menu(Game game, Handler handler, HUD hud) {
        this.game = game;
        this.hud = hud;
        this.handler = handler;
    }


    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if(game.gameState == STATE.Menu) {
            // play button
            if(mouseOver(mx, my, 210, 150, 200, 64)) {
//                game.gameState = STATE.Game;
//                handler.addObject(new Player(Game.WIDTH/2-16, Game.HEIGHT/2+16 , ID.Player, handler));
//                handler.clearEnemies();
//                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), 32, ID.BasicEnemy, handler));
                game.gameState = STATE.Select;

                AudioPlayer.getSound("menu_sound").play();
                return;
                // without the return the select difficulty screen wont appear
            }

            // help button
            if(mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = STATE.Help;
                AudioPlayer.getSound("menu_sound").play();
            }

            // quit button
            if(mouseOver(mx, my, 210, 350, 200, 64)) {
                System.exit(1);
            }

        }
        if(game.gameState == STATE.Select) {
            // normal button
            if(mouseOver(mx, my, 210, 150, 200, 64)) {
                game.gameState = STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-16, Game.HEIGHT/2+16 , ID.Player, handler));
                handler.clearEnemies();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), 32, ID.BasicEnemy, handler));

                game.diff = 0;


                AudioPlayer.getSound("menu_sound").play();
            }

            // hard button
            if(mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-16, Game.HEIGHT/2+16 , ID.Player, handler));
                handler.clearEnemies();
                handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), 32, ID.BasicEnemy, handler));


                game.diff = 1;
                AudioPlayer.getSound("menu_sound").play();
            }

            // back button
            if(mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = STATE.Menu;
                AudioPlayer.getSound("menu_sound").play();
                return;
            }

        }


        // back button for help
        if(game.gameState == STATE.Help)
            if(mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = STATE.Menu;
                AudioPlayer.getSound("menu_sound").play();
                return;
            }

        // play again button
        if(game.gameState == STATE.End)
            if(mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = STATE.Menu;
                hud.setLevel(1);
                hud.setScore(0);

                AudioPlayer.getSound("menu_sound").play();

            }

    }

    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if(mx > x && mx < x + width) {
            if(my > y && my < y + height) {
                return true;
            } else return false;

        } return false;
    }

    public void tick() {

    }

    public void render (Graphics g) {
        if(game.gameState == STATE.Menu) {
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);

        g.setFont(fnt);
        g.setColor(Color.GREEN);
        g.drawString("Waves", 240, 70);

        g.setFont(fnt2);
        g.setColor(Color.GREEN);
        g.drawString("Play", 280, 192);

        g.setColor(Color.GREEN);
        g.drawRect(210, 150, 200, 64);

        g.setColor(Color.GREEN);
        g.drawRect(210, 250, 200, 64);
        g.drawString("Help", 280, 292);

        g.setColor(Color.GREEN);
        g.drawRect(210, 350, 200, 64);
        g.drawString("Quit", 280, 392);

        } else if(game.gameState  == STATE.Help) {
            Font fnt = new Font("arial", 1, 40);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.GREEN);
            g.drawString("Help", 260, 70);

            g.setFont(fnt3);
            g.drawString("Move WASD arrows to move and dodge enemies", 90, 200);

            g.setFont(fnt2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 275, 390);

        } else if(game.gameState  == STATE.End) {
            Font fnt = new Font("arial", 1, 40);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.YELLOW);
            g.drawString("Game Over", 220, 70);

            g.setFont(fnt3);

            g.drawString("You lost with a score of: " + hud.getScore(), 185, 200);

            g.setFont(fnt2);
            g.drawRect(215, 350, 200, 64);
            g.drawString("Play Again", 241, 390);

        } else if(game.gameState == STATE.Select) {

                Font fnt = new Font("arial", 1, 50);
                Font fnt2 = new Font("arial", 1, 30);

                g.setFont(fnt);
                g.setColor(Color.GREEN);
                g.drawString("Select Difficulty", 155, 70);

                g.setFont(fnt2);
                g.drawRect(210, 150, 200, 64);
                g.drawString("Normal", 260, 192);

                g.drawRect(210, 250, 200, 64);
                g.drawString("Hard", 280, 292);

                g.drawRect(210, 350, 200, 64);
                g.drawString("Back", 280, 392);
        }

    }
}
