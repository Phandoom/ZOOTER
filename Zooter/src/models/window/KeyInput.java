package models.window;

import models.Enums.ID;
import models.Objects.GameObject;
import models.Objects.Handler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player){
                if (key == KeyEvent.VK_W) handler.setUp(true);
            }
            if (tempObject.getId() == ID.Player){
                if (key == KeyEvent.VK_S) handler.setDown(true);
            }
            if (tempObject.getId() == ID.Player){
                if (key == KeyEvent.VK_A) handler.setLeft(true);
            }
            if (tempObject.getId() == ID.Player){
                if (key == KeyEvent.VK_D) handler.setRight(true);
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player){
                if (key == KeyEvent.VK_W) handler.setUp(false);
            }
            if (tempObject.getId() == ID.Player){
                if (key == KeyEvent.VK_S) handler.setDown(false);
            }
            if (tempObject.getId() == ID.Player){
                if (key == KeyEvent.VK_A) handler.setLeft(false);
            }
            if (tempObject.getId() == ID.Player){
                if (key == KeyEvent.VK_D) handler.setRight(false);
            }
        }

    }
}
