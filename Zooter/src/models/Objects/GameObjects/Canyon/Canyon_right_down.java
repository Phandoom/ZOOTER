package models.Objects.GameObjects.Canyon;

import models.Enums.ID;
import models.Objects.GameObject;
import models.window.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Canyon_right_down extends GameObject {

    private BufferedImage canyon = null;

    public Canyon_right_down(int x, int y, ID id, SpriteSheet ss) {
        super(x, y, id, ss);

        canyon = ss.grabImage(5, 2, 32, 32);

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(canyon, x, y, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
