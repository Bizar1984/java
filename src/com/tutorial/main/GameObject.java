package com.tutorial.main;

import java.awt.*;

public abstract class GameObject {

    protected float x, y;
    protected ID id;
    protected float velX, velY;
    
    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
        // we are creating a constructor for our game object
        // and when we create our player object it needs this constructor
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    public void setId(ID id) {
        this.id = id;
    }
    public ID getId() {
        return id;
    }
    public void setVelX(int velX) {
        this.velX = velX;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }

    public float getVelX(int velX) {
        return velX;
    }
    public float getVelY(int velY) {
        return velY;
    }

}
