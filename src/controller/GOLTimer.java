package controller;

/**
 * Created by jtormoehlen on 25.05.2021.
 */
public class GOLTimer {

    long zeroTime;
    long delayTime = 250;

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
}
