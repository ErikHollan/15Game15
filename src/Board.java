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

        //upper----------

        //clock
        JButton clock = new JButton("0");
        clock.setBackground(Color.WHITE);
        clock.setForeground(Color.black);
        clock.setFont((new Font("Serif", Font.BOLD, 12)));
        Clock time = new Clock();
        TimeThread timeThread = new TimeThread(time,clock);
        Tile t = new Tile(timeThread);

        //click counter
        t.counter.setBackground(Color.WHITE);
        t.counter.setForeground(Color.black);
        t.counter.setFont((new Font("Serif", Font.BOLD, 12)));

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
