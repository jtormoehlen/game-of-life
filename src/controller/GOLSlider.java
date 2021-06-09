package controller;

import javax.swing.*;
import java.util.HashMap;

/**
 * Created by jtormoehlen on 04.06.2021.
 */
public class GOLSlider {

    private HashMap<String, Object> golContainer;

    public GOLSlider(HashMap<String, Object> golContainer) {
        this.golContainer = golContainer;

        timeIntervalSlider();
    }

    private void timeIntervalSlider() {
        final int TIME_INTERVAL_MIN = 0;
        final int TIME_INTERVAL_MAX = 1000;
        final int TIME_INTERVAL_INIT = (int)GOLTimer.INIT_DELAY_TIME;

        JSlider timeInterval = new JSlider(JSlider.HORIZONTAL,
                TIME_INTERVAL_MIN, TIME_INTERVAL_MAX, TIME_INTERVAL_INIT);

        timeInterval.setMajorTickSpacing(200);
        timeInterval.setMinorTickSpacing(50);
        timeInterval.setPaintTicks(true);
        timeInterval.setPaintLabels(true);
        timeInterval.setSnapToTicks(true);
        timeInterval.setToolTipText("Zeitintervall / ms");

        ((GOLPanel)golContainer.get("golPanel")).add(timeInterval);

        timeInterval.addChangeListener(changeEvent -> {
            JSlider source = (JSlider)changeEvent.getSource();
            if (!source.getValueIsAdjusting()) {
                int timeIntervalValue = source.getValue();
                ((GOLTimer)golContainer.get("golTimer")).setDelayTime(timeIntervalValue);
            }
        });
    }
}
