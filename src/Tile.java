import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tile {

    JButton[] tiles = new JButton[16];
    ArrayList<Integer> numberList = new ArrayList<>();
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
    JButton play = new JButton("Nytt spel");
    JButton cheat = new JButton("Reset");
    JButton counter;
    gameLogic gameLogic;

    public Tile(TimeThread tt) {
        gameLogic = new gameLogic(tt);
        counter = new JButton("" + gameLogic.countClicks);
        for (int i = 0; i <= 15; i++) {
            if (i < 15) {
                numberList.add(i + 1);
                tiles[i] = new JButton("" + numberList.get(i));
                tiles[i].setBackground(Color.WHITE);
                tiles[i].setForeground(Color.black);
                tiles[i].setBorder(border);
                tiles[i].setFont(new Font("Serif", Font.PLAIN, 50));
                tiles[i].addActionListener(click);
            } else {
                tiles[i] = new JButton("");
                tiles[i].setBackground(Color.WHITE);
                tiles[i].setForeground(Color.black);
                tiles[i].setBorder(border);
                tiles[i].setFont(new Font("Serif", Font.PLAIN, 50));
                tiles[i].addActionListener(click);

            }
        }


        play.addActionListener(click);
        cheat.addActionListener(click);
    }

    ActionListener click = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            numberList.clear();
            Object src = e.getSource();
            int clicked = 0;
            int empty = 0;
            String sClicked = "";
            String sEmpty = "";

            if (src == cheat) {
                gameLogic.cheat(tiles, numberList);
            }
            if (src == play) {
                gameLogic.play(tiles, numberList);
            }

            gameLogic.move(tiles,src, clicked,empty,sClicked,sEmpty);
            gameLogic.checkWin(tiles, src, cheat);
            gameLogic.counter(src, tiles, counter);

        }
    };
}
