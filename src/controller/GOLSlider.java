package controller;

import javax.swing.*;

/**
 * Created by jtormoehlen on 04.06.2021.
 */
public class GOLSlider {

    GOLController golController;

    public GOLSlider(GOLController golController) {
        this.golController = golController;
        this.timeIntervalSlider();
    }

    public void timeIntervalSlider() {
        final int TIME_INTERVAL_MIN = 50;
        final int TIME_INTERVAL_MAX = 550;
        final int TIME_INTERVAL_INIT = 250;    //initial frames per second

        JSlider timeInterval = new JSlider(JSlider.HORIZONTAL,
                TIME_INTERVAL_MIN, TIME_INTERVAL_MAX, TIME_INTERVAL_INIT);

        timeInterval.setMajorTickSpacing(100);
        timeInterval.setMinorTickSpacing(50);
        timeInterval.setPaintTicks(true);
        timeInterval.setPaintLabels(true);
        timeInterval.setSnapToTicks(true);
        timeInterval.setToolTipText("Zeitintervall / ms");

        golController.controlPanel.add(timeInterval);

        timeInterval.addChangeListener(changeEvent -> {
            JSlider source = (JSlider)changeEvent.getSource();
            if (!source.getValueIsAdjusting()) {
                int timeIntervalValue = source.getValue();
                golController.golTimer.delayTime = timeIntervalValue;
            }
        });
    }
}
