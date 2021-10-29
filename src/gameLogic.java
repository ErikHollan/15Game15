import javax.swing.*;
import java.util.Collections;
import java.util.List;

public class gameLogic {
    int countClicks = 0;

    Clock time = new Clock();
    TimeThread timeThread;

    public gameLogic(TimeThread tt) {
        time.timeStart();
        timeThread = tt;
    }

    public void counter(Object src, JButton[] tiles, JButton counter) {
        for (int i = 0; i < tiles.length; i++) {
            if (src == tiles[i]) {
                countClicks++;
            }
        }
        counter.setText("" + countClicks);
    }

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
        countClicks = 0;
        time.timeStart();
        timeThread.prepareClock();
        timeThread.setPause(false);
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

    public void checkWin(JButton[] tiles, Object src, JButton cheat) {
        boolean correct = true;
        for (int i = 0; i < 16; ++i) {
            if (!tiles[i].getText().equals((i + 1) + "")) {
                if (i == 15 && tiles[i].getText().equals("")) {
                    continue;
                }
                correct = false;
            }
        }
        if (correct) {
           if (src == cheat) {
                countClicks--;
            }
            timeThread.setPause(true);
            JOptionPane.showMessageDialog(null, "Grattis! Du klarade spelet på " + (countClicks + 1) + " drag" +
                    " \noch " + time.elapsedTime() + " sekunder.");
            countClicks=0;
        }
    }
}

