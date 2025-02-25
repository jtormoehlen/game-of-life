package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jtormoehlen on 09.06.2021.
 */
public class GOLFile {

    private GOLDraw golDraw;

    public GOLFile(GOLDraw golDraw) {
        this.golDraw = golDraw;
    }

    public void modelToFile(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName + ".txt");
            fileWriter.write(golDraw.modelToText());
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException ioException) {
            System.out.println("File writing error occurred.");
        }
    }

    public void fileToModel(String fileName) {
        try {
            File file = new File(fileName + ".txt");
            Scanner scanner = new Scanner(file);

            String dimLine = scanner.nextLine();
            String xLine = scanner.nextLine();
            String yLine = scanner.nextLine();

            int dim = Integer.parseInt(dimLine.trim());
            int x0 = Integer.parseInt(xLine.trim());
            int y0 = Integer.parseInt(yLine.trim());

            boolean[][] config = new boolean[dim][dim];

            int i = 0;
            while (scanner.hasNextLine()) {
                String[] configLine = scanner.nextLine().trim().split(" ");

                for (int j = 0; j < configLine.length; j++) {
                    config[j][i] = Boolean.parseBoolean(configLine[j]);
                }

                i++;
            }
            scanner.close();

            golDraw.textToModel(config, dim, x0, y0);

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("An error occurred.");
            fileNotFoundException.printStackTrace();
        }
    }
}
