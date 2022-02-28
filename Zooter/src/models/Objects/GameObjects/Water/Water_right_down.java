package models.Objects.GameObjects.Water;

import models.Enums.ID;
import models.Objects.GameObject;
import models.window.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Water_right_down extends GameObject {

    private BufferedImage water = null;

    public Water_right_down(int x, int y, ID id, SpriteSheet ss) {
        super(x, y, id, ss);

        water = ss.grabImage(5, 3, 32, 32);

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(water, x, y, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
