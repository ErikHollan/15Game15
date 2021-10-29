import javax.swing.*;

public class TimeThread extends Thread{

    Clock clock;
    JButton clockButton;
    boolean running = true;
    boolean pause = false;

    public TimeThread(Clock clock, JButton button){
        this.clock = clock;
        this.clockButton = button;
    }

    public void prepareClock(){
        clock.timeStart();
    }

    public void setPause(boolean p){
        this.pause = p;
    }

    public void run() {
        while (running) {
            if(pause)
                continue;
            try {
                clockButton.setText(clock.elapsedTime());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
