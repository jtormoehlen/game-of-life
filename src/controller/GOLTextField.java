package controller;

import javax.swing.*;
import java.util.HashMap;

/**
 * Created by jtormoehlen on 22.02.2025
 */
public class GOLTextField {

    private final HashMap<String, Object> golContainer;

    public GOLTextField(HashMap<String, Object> golContainer) {
        this.golContainer = golContainer;

        probsTextField();
    }

    public void probsTextField() {

        JTextField probs = new JTextField(16);

        probs.addActionListener(_ -> {
            String content = probs.getText();
            float prob = Float.parseFloat(content);
            System.out.println("" + prob);
        });
    }
}