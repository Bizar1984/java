package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static com.tutorial.main.Game.gameState;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean[] keyDown = new boolean[4];

    Game game;

    public KeyInput(Handler handler, Game game) {
        this.handler = handler;

        this.game = game;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    };

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player) {
                // all key events for player 1
                if(key == KeyEvent.VK_W) { tempObject.setVelY(-handler.speedW); keyDown[0] = true; }
                if(key == KeyEvent.VK_A) { tempObject.setVelX(-handler.speedA); keyDown[1] = true; }
                if(key == KeyEvent.VK_S) { tempObject.setVelY(handler.speedS);  keyDown[2] = true; }
                if(key == KeyEvent.VK_D) { tempObject.setVelX(handler.speedD);  keyDown[3] = true; }
                // why is this minus after the upgrade?
                // handler.speed set to ++ after upgrading... mmmz interesting

            }

        }
        if(key == KeyEvent.VK_P) {
            if(gameState == Game.STATE.Game) {
                Game.paused = !Game.paused;
                // what's the logic behind this?
            }

        }
        if(key == KeyEvent.VK_ESCAPE) System.exit(0);


        if(key == KeyEvent.VK_SPACE) {
            if(gameState == Game.STATE.Game) {
                gameState = Game.STATE.Shop;
            }
        } else if(gameState == Game.STATE.Shop) gameState = Game.STATE.Game;

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player) {
                // all key events for player 1
                if(key == KeyEvent.VK_W) keyDown[0] = false;
                if(key == KeyEvent.VK_A) keyDown[1] = false;
                if(key == KeyEvent.VK_S) keyDown[2] = false;
                if(key == KeyEvent.VK_D) keyDown[3] = false;

                if(!keyDown[0] && !keyDown[2]) tempObject.setVelY(0);
                if(!keyDown[1] && !keyDown[3]) tempObject.setVelX(0);



            }

        }

    }


}
