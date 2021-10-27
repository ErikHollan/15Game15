import javax.swing.*;
import java.util.Collections;
import java.util.List;

public class Logic {


    public void cheat(JButton[] tiles, List<Integer> numberList) {
        for (int i = 1; i <= 15; i++) {
            tiles[15].setText("");
            numberList.add(i);
        }
        for (int i = 0; i < 15; i++) {
            tiles[i].setText("" + numberList.get(i));
        }
    }

    public void play(JButton[] tiles, List<Integer> numberList) {

        for (int i = 1; i <= 15; i++) {
            tiles[15].setText("");
            numberList.add(i);
            Collections.shuffle(numberList);
        }

        for (int i = 0; i < 15; i++) {
            tiles[i].setText("" + numberList.get(i));
        }

    }

    public void move(JButton[] tiles, Object src, int clicked, int empty, String sClicked, String sEmpty) {
        for (int i = 0; i < tiles.length; i++) {
            if (src == tiles[i]) {
                clicked = i;
            }

            if (tiles[i].getText().equals("")) {
                empty = i;
            }

        }
        if (clicked + 1 == empty || clicked - 1 == empty ||
                clicked + 4 == empty || clicked - 4 == empty) {
            sClicked = tiles[clicked].getText();
            sEmpty = tiles[empty].getText();

            tiles[clicked].setText(sEmpty);
            tiles[empty].setText(sClicked);

        }

    }
}

