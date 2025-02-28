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
            String[] coords = scanner.nextLine().trim().split(" ");

            int n = Integer.parseInt(dimLine.trim());
            int dx = Integer.parseInt(coords[0]);
            int dy = Integer.parseInt(coords[1]);

            boolean[][] pop = new boolean[n][n];

            int i = 0;
            while (scanner.hasNextLine()) {
                String[] configLine = scanner.nextLine().trim().split(" ");

                for (int j = 0; j < configLine.length; j++) {
                    pop[i][j] = Integer.parseInt(configLine[j]) != 0;
                }

                i++;
            }
            scanner.close();

            golDraw.textToModel(pop, dx, dy);

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found!");
        }
    }
}
