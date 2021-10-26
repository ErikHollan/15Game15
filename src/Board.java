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
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(upper, BorderLayout.NORTH);
        upper.add(play);
        upper.add(cheat);
        upper.setBackground(Color.ORANGE);

        add(lower, BorderLayout.CENTER);
        lower.setLayout(new GridLayout(4, 4));
        lower.setBorder(border);
        lower.setBackground(Color.cyan);


    }

}
