package view;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by jtormoehlen on 09.06.2021.
 */
public class GOLFile {

    private GOLDraw golDraw;

    public GOLFile(GOLDraw golDraw) {
        this.golDraw = golDraw;
    }

    public void modelToFile(String filename) {
        try {
            FileWriter fileWriter = new FileWriter(filename + ".txt");
            fileWriter.write(golDraw.modelToText());
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException ioException) {
            System.out.println("File writing error occurred.");
        }
    }
}
