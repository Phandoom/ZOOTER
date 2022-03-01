package models.window;

import jdk.jfr.Unsigned;
import models.Enums.ID;
import models.Objects.GameObject;
import models.Objects.GameObjects.Arrow;
import models.Objects.Handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MouseInput extends MouseAdapter{

    private Handler handler;
    private Camera camera;
    private SpriteSheet ss;
    private long j = 0;

    public MouseInput (Handler handler, Camera camera){
        this.handler = handler;
        this.camera = camera;
    }

    public void mousePressed(MouseEvent e) {
        int key = e.getButton();
        if (key == MouseEvent.BUTTON1) {
            int mx = (int) (e.getX() + camera.getX());
            int my = (int) (e.getY() + camera.getY());
            if (cooldown()) {
                for (int i = 0; i < handler.object.size(); i++) {
                    GameObject tempObject = handler.object.get(i);

                    if (tempObject.getId() == ID.Player) {
                        handler.addObject(new Arrow(tempObject.getX() + 16, tempObject.getY() + 16, ID.Arrow, handler, mx, my, ss));
                    }
                }
            }
        }
    }
    public void mouseWheelMoved(MouseWheelEvent e, int mode){
        int notches = e.getWheelRotation();
        if (notches < 0){
            mode++;
        }
        else if(notches > 0){
            mode--;
        }
    }

    public boolean cooldown(){
        long cdTime = 500;


        if(System.currentTimeMillis()>cdTime+j){
            j=System.currentTimeMillis();
            return true;
        }
        else {
            return false;
        }

    }





}

