import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Board extends JFrame {

    JPanel upper = new JPanel();
    JPanel lower = new JPanel();

    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    Board() {
        //bottenplatta
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JLabel clock = new JLabel("0");
        Clock time = new Clock();
        TimeThread timeThread = new TimeThread(time,clock);
        Tile t = new Tile(timeThread);



        //upper
        add(upper, BorderLayout.NORTH);
        upper.add(t.counter);
        upper.add(t.play);
        upper.add(t.cheat);
        upper.add(clock);
        upper.setBackground(Color.ORANGE);

        //lower
        add(lower, BorderLayout.CENTER);
        lower.setLayout(new GridLayout(4, 4));
        lower.setBorder(border);
        for (int i = 0; i < t.tiles.length; i++) {
            lower.add(t.tiles[i]);
        }
        timeThread.prepareClock();
        timeThread.start();
    }
}
