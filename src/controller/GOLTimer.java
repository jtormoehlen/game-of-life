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
        zeroTime = System.currentTimeMillis();
        isRunning = true;
    }

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public void delayTime() {
        long startTime = getCurrentTime();
        
        while (getCurrentTime() - startTime < delayTime) {
            try {
                // Put current thread to sleep mode
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // Reset unterrupt state
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void toggleRunning() {
        isRunning = !isRunning;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    public boolean isRunning() {
        return !isRunning;
    }
}