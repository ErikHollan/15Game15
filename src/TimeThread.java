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
                label.setText(clock.elapsedTime());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
