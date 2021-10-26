import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Board extends JFrame {

    JPanel upper = new JPanel();
    JPanel lower = new JPanel();
    JButton play = new JButton("Nytt spel");
    JButton cheat = new JButton("Fuska");
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    Board() {
        //bottenplatta
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        Tile t = new Tile();

        //upper
        add(upper, BorderLayout.NORTH);
        upper.add(play);
        upper.add(cheat);
        upper.setBackground(Color.ORANGE);

        //lower
        add(lower, BorderLayout.CENTER);
        lower.setLayout(new GridLayout(4, 4));
        lower.setBorder(border);
        lower.setBackground(Color.cyan);
        for (int i = 0; i < t.tiles.length; i++) {
            lower.add(t.tiles[i]);

        }

    }
}
