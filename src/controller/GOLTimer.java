package controller;

/**
 * Created by jtormoehlen on 25.05.2021.
 */
public class GOLTimer {

    final static long INIT_DELAY_TIME = 50;

    private long zeroTime;
    private long delayTime = INIT_DELAY_TIME;

    private boolean isRunning;

    public void start() {
        zeroTime = System.nanoTime() / 1000000;
    }

    public long getCurrentTime() {
        return System.nanoTime() / 1000000;
    }

    public void delayTime() {
        long startTime = getCurrentTime();
        long currentTime;

        do {
            currentTime = getCurrentTime();
        } while ((currentTime - startTime) <= delayTime);
    }

    public void toggleRunning() {
        isRunning = !isRunning;
    }

    public void toggleRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    public boolean getRunning() {
        return isRunning;
    }
}
