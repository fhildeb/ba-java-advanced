package graph;

/*************************************************************************
 * Hilfsklasse. 
 * 
 * Liest Zahlen oder Zeichketten aus einer anzugebenden Datei. 
 * Intern wird die Scanner-Klasse zur Verwaltung der Datei bzw. des Eingabe-
 * stroms verwendet.
 *
 *************************************************************************/

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * <i>Eingabe</i>.
 **/
public final class Eingabe {

    private Scanner scanner;

    private static final String CHARSET_NAME = "UTF-8";
    private static final Locale LOCALE = Locale.GERMAN;

    /**
     * Oeffnet eine Datei.
     */
    public Eingabe(File file) {
        try {
            scanner = new Scanner(file, CHARSET_NAME);
            scanner.useLocale(LOCALE);
        } catch (IOException ioe) {
            System.err.println("Datei konnte nicht geoeffnet werden " + file);
        }
    }

    /**
     * Konstruktor. Nimmt eine Pfadangabe entgegen und
     * öffnet anschließend die zugehörige Datei.
     */
    public Eingabe(String s) {
        try {
            // prüfe zunächst, ob es sich um eine Datei handelt
            File file = new File(s);
            if (file.exists()) {
                scanner = new Scanner(file, CHARSET_NAME);
                scanner.useLocale(LOCALE);
                return;
            }

        } catch (IOException ioe) {
            System.err.println("Konnte Datei nicht oeffnen: " + s);
        }
    }

    /**
     * Liest eine Zeile aus der Eingabe.
     */
    public String readLine() {
        String line;
        try {
            line = scanner.nextLine();
        } catch (Exception e) {
            line = null;
        }
        return line;
    }

    /**
     * Prüft, ob die aktuelle Eingabe-Quelle noch Zeichen enthält.
     * 
     * @return
     */
    public boolean isEmpty() {
        return !scanner.hasNext();
    }

    /**
     * Prüft, ob noch eine Zeile/Char in der Eingabe-Quelle vorliegt.
     * 
     * @return
     */
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    /**
     * Gibt einen String zurück.
     */
    public String readString() {
        return scanner.next();
    }

    /**
     * Liest die nächste Zahl aus der Eingabe und gibt diese zurück.
     */
    public int readInt() {
        return scanner.nextInt();
    }

    /**
     * Schließt den Eingabestrom wieder.
     */
    public void close() {
        scanner.close();
    }

}
