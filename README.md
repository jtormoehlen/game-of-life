# Game of Life - Java Anwendung

![Game of Life](https://commons.wikimedia.org/wiki/Category:Animations_of_the_Game_of_Life#/media/File:SpaceshipFormation.gif) 

## Übersicht

Die "Game of Life"-Anwendung ist eine interaktive Implementierung des berühmten zellulären Automaten, der von dem Mathematiker John Conway entwickelt wurde. In dieser Anwendung können Benutzer Zellen in einem Gitter anklicken, um sie als lebendig oder tot zu klassifizieren. Es gibt Funktionen zum Starten und Stoppen der Simulation sowie zur Anpassung der Geschwindigkeit der Entwicklungsschritte. Zudem können zufällige Populationen erzeugt werden, wobei Cluster mit unterschiedlichen Wahrscheinlichkeiten für lebende Zellen genutzt werden.

## Funktionen

- **Interaktive Zellenauswahl**: Klicken Sie auf Zellen im Gitter, um ihren Status zu ändern (lebendig oder tot).
- **Simulation Starten/Stoppen**: Starten oder stoppen Sie die Simulation mit einem Button.
- **Geschwindigkeit Einstellen**: Passen Sie die Geschwindigkeit der Simulation in Millisekunden (ms) an.
- **Zufällige Populationen**: Erzeugen Sie zufällige Populationen mit einer höheren Wahrscheinlichkeit für Cluster lebender Zellen.

## Installation

1. **Java Entwicklungsumgebung**: Stellen Sie sicher, dass Sie eine installiert haben (Java 11 oder höher empfohlen).
2. **Klonen Sie das Repository**:

   ```bash
   git clone https://github.com/jtormoehlen/GameOfLife.git
   ```

3. **Navigieren Sie in das Verzeichnis**:

   ```bash
   cd GameOfLife
   ```

4. **Projekt kompilieren**: Kompilieren Sie das Projekt mit Ihrem bevorzugten Build-Tool (z.B. Maven oder Gradle) oder verwenden Sie die Kommandozeile und den `javac`-Befehl.

5. **Anwendung starten**:

   ```bash
   java -jar GameOfLife.jar
   ```

## Benutzeranleitung

1. **Einstellen der Zellen**: Klicken Sie auf Zellen im Gitter, um sie zu aktivieren oder zu deaktivieren.
2. **Simulation starten**: Drücken Sie den "Start"-Button, um die Simulation zu beginnen. Drücken Sie erneut (Stop), um sie zu stoppen.
3. **Geschwindigkeit anpassen**: Stellen Sie die gewünschte Zeit in Millisekunden eines Evolutionsschrittes mit dem Slider ein.
4. **Zufällige Bevölkerung erzeugen**: Klicken Sie auf den Button "Zufällig", um ein zufälliges Zellmuster zu erzeugen.
5. **Feld zurücksetzen**: Klicken Sie auf Zurücksetzen, um alle Zellen des Feldes auf tot zu stellen.
6. **Aktuelle Population drucken**: Sie können die Population der neuesten Generation mit dem Button "als Datei" in `gol.txt` speichern.

## Beispielansicht

![Screenshot der Anwendung](url-zum-screenshot)

## Technologien

- Java SE
- JavaFX für die Benutzeroberfläche
- Maven für das Build-Management

## Beiträge

Bitte beachten Sie, dass Beiträge zur Verbesserung des Projekts immer willkommen sind. Fühlen Sie sich frei, Pull-Requests zu erstellen oder Probleme im Issues-Bereich zu melden.

## Lizenz

Dieses Projekt steht unter der MIT Lizenz. Weitere Informationen finden Sie in der LICENSE-Datei.

---

Viel Spaß beim Experimentieren mit der Game of Life Anwendung!