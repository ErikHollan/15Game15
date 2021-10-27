import javax.swing.*;
<<<<<<< HEAD
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


=======
import java.util.Collections;
import java.util.List;

public class gameLogic {


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
>>>>>>> origin/Logic
        for (int i = 0; i < tiles.length; i++) {
            if (src == tiles[i]) {
                clicked = i;
            }

<<<<<<< HEAD
            if (squares[i].getText().equals("")) {
=======
            if (tiles[i].getText().equals("")) {
>>>>>>> origin/Logic
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
<<<<<<< HEAD
=======

>>>>>>> origin/Logic
    }
}

