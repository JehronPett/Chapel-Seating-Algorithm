import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class LuHiChapel {

   
   public LuHiChapel(String[][] b) {
      Color[] colors = {Color.black, Color.black, Color.gray, Color.gray, Color.white, Color.white, Color.black, Color.black, Color.gray, Color.gray, Color.white, Color.white};
      int columns = b.length;
      int rows = b[0].length;
      JPanel panel = new JPanel(new GridLayout(rows, columns));
      for (int c = 0; c < rows; c++) {
         for (int a = 0; a < columns; a++) {
            final JToggleButton button = new JToggleButton(b[a][c]);
            button.setBackground(colors[a]);
            button.setForeground(Color.white);
            if (a >= 10 || a == 4 || a == 5) {
               button.setForeground(Color.black);
            }
            panel.add(button);
         }
      }
      final JFrame frame = new JFrame("Chapel Seating Seating Chart - Algorithm By Jehron Petty");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(panel);
      frame.pack();
      frame.setLocation(300, 100);
      frame.setSize(1400,600);
      frame.setVisible(true);
   }
}