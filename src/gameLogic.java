import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class gameLogic {

//Fungerande logik som måste kopplas med Tile och Board. Hur?



    public void tileClick(ArrayList<Integer> numberList, MouseEvent e) {
        numberList.clear();
        Object src = e.getSource();
        int clicked = 0;
        int empty = 0;
        String sClicked = "";
        String sEmpty = "";

        if (src == cheat) {
            for (int i = 1; i <= 15; i++) {
                tiles[15].setText("");
                numberList.add(i);
            }
            for (int i = 0; i < 15; i++) {
                tiles[i].setText("" + numberList.get(i));
            }
        }

        if (src == play) {
            for (int i = 1; i <= 15; i++) {
                tiles[15].setText("");
                numberList.add(i);
                Collections.shuffle(numberList);
            }

            for (int i = 0; i < 15; i++) {
                tiles[i].setText("" + numberList.get(i));
            }

        }


        for (int i = 0; i < tiles.length; i++) {
            if (src == tiles[i]) {
                clicked = i;
            }

            if (squares[i].getText().equals("")) {
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

