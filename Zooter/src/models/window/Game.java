package models.window;

import models.Enums.ID;
import models.Objects.GameObjects.*;
import models.Objects.GameObjects.Canyon.*;
import models.Objects.GameObjects.Water.*;
import models.Objects.Handler;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable{

    public static final long serialVersionUID = 1L;
    public boolean isRunning = false;
    private Thread thread;
    private Handler handler;
    private SpriteSheet ss;

    private BufferedImage level = null;
    private BufferedImage sprite_sheet = null;
    private BufferedImage grass = null;

    private Camera camera;

    public Game(){
        playerWindow.createWindow(this);
        start();

        handler = new Handler();
        camera = new Camera(0, 0);
        this.addKeyListener(new KeyInput(handler));

        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("/Field2.png");
        sprite_sheet = loader.loadImage("/Spritesheet.png");

        ss = new SpriteSheet(sprite_sheet);

        grass = ss.grabImage(1,1,32, 32);

        this.addMouseListener(new MouseInput(handler, camera));

        loadLevel(level);


    }
    private void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();

    }

    private void stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(){
        new Game();
    }

    @Override
    public void run() {
    this.requestFocus();
    long lastTime = System.nanoTime();
    double amountOfTickets = 60;
    double ns = 1000000000 / amountOfTickets;
    double delta = 0;
    long timer = System.currentTimeMillis();
    int frames = 0;
    while (isRunning){
        long now = System.nanoTime();
        delta += (now - lastTime) / ns;
        lastTime = now;
        while(delta >= 1){
            tick();
            //updates
            delta--;
        }
        render();
        frames++;

        if (System.currentTimeMillis() - timer > 1000){
            timer += 1000;
            frames = 0;
            //updates = 0
        }
    }
    stop();
    }
    public void tick(){
        for (int i = 0; i < handler.object.size(); i++) {
         if (handler.object.get(i).getId() == ID.Player){
             camera.tick(handler.object.get(i));
         }

        }
        handler.tick();
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2D = (Graphics2D) g;

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,800,600);



        g2D.translate(-camera.getX(), -camera.getY());

        for (int xx = 0; xx < 30*72; xx+=32){
            for (int yy = 0; yy < 30*72; yy+=32){
                g.drawImage(grass, xx, yy, null);
            }
        }

        handler.render(g);

        g.dispose();
        bs.show();
    }

    private void loadLevel(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();

        for (int xx = 0; xx < w; xx++){
            for (int yy = 0; yy < h; yy++){
                int pixel = image.getRGB(xx,yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if ((red == 0) && (green == 0) && (blue == 0)){
                    handler.addObject(new Water_full(xx*32, yy*32, ID.Block, ss));
                }
                if ((red == 0) && (green == 255) && (blue == 0)){
                    handler.addObject(new Player(xx*32, yy*32, ID.Player, handler, ss));
                }
                if ((red == 255) && (green == 0) && (blue == 0)){
                    handler.addObject(new Enemy(xx*32, yy*32, ID.Enemy, handler, ss));
                }
                if ((red == 255) && (green == 0) && (blue == 255)){
                    handler.addObject(new Water_left(xx*32, yy*32, ID.Block, ss));
                }
                if ((red == 0) && (green == 0) && (blue == 255)){
                    handler.addObject(new Water_right(xx*32, yy*32, ID.Block, ss));
                }
                if ((red == 0) && (green == 255) && (blue == 255)){
                    handler.addObject(new Water_down(xx*32, yy*32, ID.Block, ss));
                }
                if ((red == 0) && (green == 255) && (blue == 255)){
                    handler.addObject(new Water_down(xx*32, yy*32, ID.Block, ss));
                }
                if ((red == 0) && (green == 127) && (blue == 255)){
                    handler.addObject(new Water_left_down(xx*32, yy*32, ID.Block, ss));
                }
                if ((red == 0) && (green == 255) && (blue == 127)){
                    handler.addObject(new Water_right_down(xx*32, yy*32, ID.Block, ss));
                }


                if ((red == 100) && (green == 255) && (blue == 100)){
                    handler.addObject(new Canyon_left(xx*32, yy*32, ID.Block, ss));
                }
                if ((red == 100) && (green == 100) && (blue == 255)){
                    handler.addObject(new Canyon_right(xx*32, yy*32, ID.Block, ss));
                }
                if ((red == 255) && (green == 100) && (blue == 100)){
                    handler.addObject(new Canyon_down(xx*32, yy*32, ID.Block, ss));
                }
                if ((red == 255) && (green == 255) && (blue == 100)){
                    handler.addObject(new Canyon_left_down(xx*32, yy*32, ID.Block, ss));
                }
                if ((red == 255) && (green == 100) && (blue == 255)){
                    handler.addObject(new Canyon_right_down(xx*32, yy*32, ID.Block, ss));
                }
                if ((red == 255) && (green == 255) && (blue == 255)){
                    handler.addObject(new Canyon_full(xx*32, yy*32, ID.Block, ss));
                }



            }
        }
    }
}

