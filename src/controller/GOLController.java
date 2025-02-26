package controller;

import app.GOLApp;
import core.GOL;
import view.GOLDraw;
import view.GOLWindow;

import java.util.HashMap;

/**
 * Created by jtormoehlen on 17.03.2020.
 */
public class GOLController {

    private final HashMap<String, Object> golContainer;

    private GOL gol;
    private GOLDraw golDraw;
    private GOLTimer golTimer;
    private GOLWindow golWindow;
    private GOLButton golButton;
    private GOLSlider golSlider;
    private GOLTextField golTextField;
    private GOLListener golListener;
    private GOLPanel golPanel;

    public GOLController(GOLApp golApp) {
        golContainer = new HashMap<String, Object>();

        add("golApp", golApp);

        initWindow();
        initControls();
        initListeners();
    }

    private void initWindow() {
        gol = new GOL(64);
        golDraw = new GOLDraw(gol);
        golTimer = new GOLTimer();
        golWindow = new GOLWindow(golDraw);

        add("gol", gol);
        add("golDraw", golDraw);
        add("golTimer", golTimer);
        add("golWindow", golWindow);

        ((GOLApp) get("golApp")).add(golWindow);
    }

    private void initControls() {
        golPanel = new GOLPanel(golContainer);

        add("golPanel", golPanel);

        golButton = new GOLButton(golContainer);
        golSlider = new GOLSlider(golContainer);
        golTextField = new GOLTextField(golContainer);

        add("golButton", golButton);
        add("golSlider", golSlider);
        // add("golTextField", golTextField);
    }

    private void initListeners() {
        golListener = new GOLListener(golDraw);

        add("golListener", golListener);

        golWindow.addMouseListener(golListener);
        golWindow.addMouseMotionListener(golListener);
        golWindow.addMouseWheelListener(golListener);
    }

    public Object get(String golHandlerKey) {
        return golContainer.get(golHandlerKey);
    }

    public void add(String golHandlerKey, Object golHandlerType) {
        golContainer.put(golHandlerKey, golHandlerType);
    }

    public HashMap<String, Object> getGolContainer() {
        return golContainer;
    }
}
