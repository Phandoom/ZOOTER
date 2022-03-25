package models.Objects.GameObjects;

import models.Enums.ID;
import models.Objects.GameObject;
import models.Objects.Handler;
import models.window.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {

    Handler handler;
    private BufferedImage player = null;
    int gold = 0;
    int exp = 0;

    public Player(int x, int y, ID id, Handler handler, SpriteSheet ss) {
        super(x, y, id, ss);
        this.handler = handler;
        player = ss.grabImage(3, 1, 32, 32);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;


        //x -= -velX * -1;
        //y -= -velY * -1;


        collision();

        if (handler.isUp()){
            velY = -5;
        }
        else if (!handler.isDown()){
            velY = 0;
        }

        if (handler.isDown()){
            velY = 5;
        }
        else if (!handler.isUp()){
            velY = 0;
        }

        if (handler.isLeft()){
            velX = -5;
        }
        else if (!handler.isRight()){
            velX = 0;
        }

        if (handler.isRight()){
            velX = 5;
        }
        else if (!handler.isLeft()){
            velX = 0;
        }

    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Block){

                if (getBounds().intersects(tempObject.getBounds())){
                    x += velX * -1;
                    y += velY * -1;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(player, x, y,null);
        }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    public void addGold(int Gold){
        gold = gold + Gold;
    }

    public void addExp(int Exp){
        exp = exp + Exp;
    }
}
