package text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Rechtschreibung {

    private String woerterbuchfile;
    private String textfile;
    private Set<String> woerterbuch;
    private Map<Integer, List<String>> fehlerspeicher;

    public Rechtschreibung(String wb, String textfile) {
        this.woerterbuch = new HashSet<String>(200);
        this.fehlerspeicher = new HashMap<Integer, List<String>>();
        this.woerterbuchfile = wb;
        this.textfile = textfile;
        initialisierWoerterbuch();
        analysiereText();
    }

    private void initialisierWoerterbuch() {

        try {
            BufferedReader in = new BufferedReader(new FileReader(woerterbuchfile));

            String zeile = in.readLine();
            while (zeile != null) {
                woerterbuch.add(zeile);
                zeile = in.readLine();
                // Tester des W�rterbuchinhalts
                // System.out.println(woerterbuch);
            }
            in.close();
        } catch (Exception e) {
            // e.printStrackTrace();
        }

    }

    private void analysiereText() {
        try {
            @SuppressWarnings("resource")
            BufferedReader in = new BufferedReader(new FileReader(textfile));
            String[] zeile = new String[18];

            for (int i = 1; i <= 18; i++) {
                zeile[i] = in.readLine().toLowerCase();
                String rawZeile = null;
                StringTokenizer tokenizer = new StringTokenizer(zeile[i], "\n\t.,;:?!()");
                while (tokenizer.hasMoreTokens()) {
                    rawZeile += tokenizer.nextToken();
                    zeile[i] = rawZeile.substring(4, rawZeile.length());
                }
                System.out.println("Zeile " + i + ": " + zeile[i]);

                String einzeln = zeile[i];
                String[] wortInZeile = einzeln.split(" ");
                List<String> fehlerwortliste = new ArrayList<String>();
                for (int a = 0; a < wortInZeile.length; a++) {
                    if (woerterbuch.contains(wortInZeile[a])) {
                        // Wort ist richtig geschrieben
                    } else {
                        // Wort ist falsch geschrieben
                        fehlerwortliste.add(wortInZeile[a]);
                    }
                }
                fehlerspeicher.put(i, fehlerwortliste);
                // Fehler der vorherigen Zeile:
                // System.out.println("Fehler in Zeile "+ i + " : " + fehlerwortliste);

                // Fehlermap ausgeben:
                System.out.println("gesammelte Fehler: " + fehlerspeicher);
            }

        } catch (Exception e) {
            // e.printStrackTrace();
        }

    }

    public static void main(String[] args) {
        new Rechtschreibung("bin/text/woerter.txt", "bin/text/text.txt");

    }
}
