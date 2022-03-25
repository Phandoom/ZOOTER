package models.window;

import models.Enums.ID;
import models.Objects.GameObject;
import models.Objects.GameObjects.Arrow;
import models.Objects.Handler;
import models.window.Camera;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    private Handler handler;
    private Camera camera;
    private SpriteSheet ss;

    public MouseInput (Handler handler, Camera camera){
        this.handler = handler;
        this.camera = camera;
    }

    public void mousePressed(MouseEvent e) {
        int key = e.getButton();
        if (key == MouseEvent.BUTTON1) {
            int mx = (int) (e.getX() + camera.getX());
            int my = (int) (e.getY() + camera.getY());

            for (int i = 0; i < handler.object.size(); i++) {
                GameObject tempObject = handler.object.get(i);

                if (tempObject.getId() == ID.Player) {
                    handler.addObject(new Arrow(tempObject.getX() + 16, tempObject.getY() + 16, ID.Arrow, handler, mx, my, ss));
                }
            }
        }
    }




}

