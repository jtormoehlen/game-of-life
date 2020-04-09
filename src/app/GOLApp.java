package app;

import controller.GOLController;

/**
 * Created by jtormoehlen on 17.03.2020.
 */
public class GOLApp {

    public static void main(String[] args) {
        GOLController golController = new GOLController();

        try {
            golController.simulate();
        } catch (InterruptedException e) { }
    }
}
