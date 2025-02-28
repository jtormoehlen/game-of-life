package controller;

import java.util.HashMap;

import javax.swing.JComboBox;

import core.GOL;

public class GOLComboBox {

    private final HashMap<String, Object> golContainer;

    public GOLComboBox(HashMap<String, Object> golContainer) {
        this.golContainer = golContainer;

        initPatternComboBox();
    }

    public void initPatternComboBox() {
        String[] patternNames = {"Choose Pattern...",  "Single random", "Clustering", "Simplex noise", "Neumann neighborhood"};
        JComboBox<String> patternComboBox = new JComboBox<>(patternNames);

        ((GOLPanel) golContainer.get("golPanel")).add(patternComboBox);

        patternComboBox.addItemListener(itemEvent -> {
            switch (itemEvent.getItem().toString()) {
                case "Single random":
                    ((GOL) golContainer.get("gol")).setRandomMode((byte) 0);
                    break;
                case "Clustering":
                    ((GOL) golContainer.get("gol")).setRandomMode((byte) 1);
                    break;
                case "Simplex noise":
                    ((GOL) golContainer.get("gol")).setRandomMode((byte) 2);
                    break;
                case "Neumann neighborhood":
                    ((GOL) golContainer.get("gol")).setRandomMode((byte) 3);  
                    break;
            }
        });
    }
}
