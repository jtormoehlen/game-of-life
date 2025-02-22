package app;

import controller.GOLTimer;
import core.GOL;

import java.util.HashMap;

/**
 * Created by jtormoehlen on 09.06.2021.
 */
public class GOLRunner {

    private final HashMap<String, Object> golContainer;

    public GOLRunner(HashMap<String, Object> golContainer) {
        this.golContainer = golContainer;
    }

    public void run() throws InterruptedException {
        ((GOLTimer)golContainer.get("golTimer")).start();

        while (true) {
            if (((GOLTimer)golContainer.get("golTimer")).isRunning()) {
                ((GOL)golContainer.get("gol")).select();
                ((GOLTimer)golContainer.get("golTimer")).delayTime();
            }
            ((GOLApp)golContainer.get("golApp")).repaint();
        }
    }
}
