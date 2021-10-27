import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class Tile {
    gameLogic logic = new gameLogic();
    JButton tiles[] = new JButton[16];
    ArrayList<Integer> numberList = new ArrayList<>();
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    Tile() {
        for (int i = 0; i <= 15; i++) {
            if (i < 15) {
                numberList.add(i + 1);
                tiles[i] = new JButton("" + numberList.get(i));
                tiles[i].setBorder(border);
                tiles[i].setFont(new Font("Serif", Font.PLAIN, 50));
                tiles[i].addMouseListener(click);
            } else {
                tiles[i] = new JButton("");
                tiles[i].setBorder(border);
                tiles[i].setFont(new Font("Serif", Font.PLAIN, 50));
                tiles[i].addMouseListener(click);
            }
        }

    }


    MouseAdapter click = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) throws ClassCastException {
            logic.tileClick(numberList, e);
            //Logik för knapptryck
            /*
            gameLogic l = new gameLogic();   //behöver man göra detta??
            l.src=e.getSource();

             */
        }

    };
}
