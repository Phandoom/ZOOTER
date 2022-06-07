package models.window;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectWindow {
    static CurrentCharacter c = new CurrentCharacter();
    static Action action = new Action();
    static boolean selected = false;
    static JButton c1 = new JButton("C1");
    static JButton c2 = new JButton("C2");
    static JButton c3 = new JButton("C3");
    static JFrame frame = new JFrame("Selector");

    public static void main () {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.setSize(800, 600);
        frame.add(panel);

        panel.add(c1, BorderLayout.CENTER);
        panel.add(c2, BorderLayout.CENTER);
        panel.add(c3, BorderLayout.CENTER);
        c1.addActionListener(action);
        c2.addActionListener(action);
        c3.addActionListener(action);

        frame.setVisible(true);

    }
    static class Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == c1){
                c.setId(1);
                frame.setVisible(false);
                Game.main(0);
            }
            else if (e.getSource() == c2){
                c.setId(2);
                frame.setVisible(false);
                Game.main(1);
            }
            else if (e.getSource() == c3) {
                c.setId(3);
                frame.setVisible(false);
                Game.main(2);
            }
        }

    }
}
