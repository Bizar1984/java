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
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 100), r.nextInt(Game.HEIGHT - 100), ID.BasicEnemy, handler));
                    handler.addObject(new PotionEnemy(r.nextInt(Game.WIDTH - 100), r.nextInt(Game.HEIGHT - 100), ID.PotionEnemy, handler));
                } else if(hud.getLevel() == 3) {
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 100), r.nextInt(Game.HEIGHT - 100), ID.SmartEnemy, handler));
                    handler.addObject(new PotionFriend(r.nextInt(Game.WIDTH - 200), r.nextInt(Game.HEIGHT - 200), ID.PotionFriend, handler));

                } else if(hud.getLevel() == 4) {
                    handler.clearEnemies();
                    handler.addObject(new EnemyBoss(Game.WIDTH / 2 - 48, - 96, ID.EnemyBoss, handler));
                    handler.addObject(new PotionFriend(r.nextInt(Game.WIDTH - 200), r.nextInt(Game.HEIGHT - 200), ID.PotionFriend, handler));

                } else if(hud.getLevel() == 5) {
                    handler.addObject(new EnemyBoss(Game.WIDTH / 2 - 48, - 96, ID.EnemyBoss, handler));
                    // interesting, we cant add objects after the clearEnemies function is called
                    handler.addObject(new PotionFriend(r.nextInt(Game.WIDTH - 200), r.nextInt(Game.HEIGHT - 200), ID.PotionFriend, handler));
                    handler.addObject(new PotionFriend(r.nextInt(Game.WIDTH - 200), r.nextInt(Game.HEIGHT - 200), ID.PotionFriend, handler));
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 200), r.nextInt(Game.HEIGHT - 200), ID.SmartEnemy, handler));
                    // we can on the other hand add the potions
                } else if(hud.getLevel() == 6) {
                    handler.clearEnemies();
                    handler.addObject(new PotionFriend(r.nextInt(Game.WIDTH - 200), r.nextInt(Game.HEIGHT - 200), ID.PotionFriend, handler));
                    handler.addObject(new PotionFriend(r.nextInt(Game.WIDTH - 200), r.nextInt(Game.HEIGHT - 200), ID.PotionFriend, handler));
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 200), r.nextInt(Game.HEIGHT - 200), ID.SmartEnemy, handler));
                    handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 200), r.nextInt(Game.HEIGHT - 200), ID.HardEnemy, handler));
                // we can on the other hand add the potions
                } else if(hud.getLevel() == 7) {
                    handler.clearEnemies();
                    handler.addObject(new EnemyBoss(Game.WIDTH / 2 + 48, - 96, ID.EnemyBoss, handler));
                    handler.addObject(new EnemyBoss(Game.WIDTH / 2 - 48, - 96, ID.EnemyBoss, handler));
                    handler.addObject(new EnemyBoss(Game.WIDTH / 2 - 148, - 96, ID.EnemyBoss, handler));
                }


            } else if(game.diff == 1) {
                if(hud.getLevel() == 2) {
                    handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 80), r.nextInt(Game.HEIGHT - 80), ID.BasicEnemy, handler));

                } else if(hud.getLevel() == 3) {
                    handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 80), r.nextInt(Game.HEIGHT - 80), ID.SmartEnemy, handler));

                } else if(hud.getLevel() == 4) {
                    handler.clearEnemies();
                    handler.addObject(new EnemyBoss(Game.WIDTH / 2 - 48, - 96, ID.EnemyBoss, handler));

                }

            }



        }
    }
}
