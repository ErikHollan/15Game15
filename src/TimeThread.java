import javax.swing.*;

public class TimeThread extends Thread{

    Clock clock;
    JLabel label;
    boolean running = true;
    boolean pause = false;

    public TimeThread(Clock clock, JLabel label){
        this.clock = clock;
        this.label = label;
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
                Thread.sleep(1000);
                label.setText(clock.elapsedTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
