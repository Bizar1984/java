package com.tutorial.main;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Game game;

    private int scoreKeep = 0;

    private Random r = new Random();

    public Spawn(Handler handler, HUD hud, Game game) {
        this.handler = handler;
        this.hud = hud;
        this.game = game;
    }

    public void tick() {
        scoreKeep++;
        if(scoreKeep >= 250) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            if(game.diff == 0) {
                if(hud.getLevel() == 2) {
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                } else if(hud.getLevel() == 3) {
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
                } else if(hud.getLevel() == 4) {
                    handler.clearEnemies();
                    handler.addObject(new EnemyBoss(Game.WIDTH / 2 - 48, - 96, ID.EnemyBoss, handler));
                }
            } else if(game.diff == 1) {
                if(hud.getLevel() == 2) {
                    handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));

                } else if(hud.getLevel() == 3) {
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));

                } else if(hud.getLevel() == 4) {
                    handler.clearEnemies();
                    handler.addObject(new EnemyBoss(Game.WIDTH / 2 - 48, - 96, ID.EnemyBoss, handler));
                }

            }



        }
    }
}
