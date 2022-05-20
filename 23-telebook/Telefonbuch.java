package telebook;

import java.util.*;

public class Telefonbuch {

    Map<String, Set<String>> Speicher; // erster wert string, folgende werte eine samlung an strings

    public static void main(String[] args) {
        Telefonbuch t = new Telefonbuch();
        t.einfuegen("Otto", "1234");
        t.einfuegen("Otto", "0174");
        t.einfuegen("heinz", "0174");
        System.out.println(t);
        System.out.println(t.HatTelNr("Otto"));
    }

    public Telefonbuch() {
        Speicher = new HashMap<String, Set<String>>();
    }

    public boolean einfuegen(String name, String nummer) {
        if (Speicher.containsKey(name)) { // name bekannt ,nummer gespeichert
            Speicher.get(name).add(nummer);
            return true;
        } else { // neuer name
            HashSet<String> nummern = new HashSet<String>();
            nummern.add(nummer);
            Speicher.put(name, nummern);
            return false;
        }

    }

    public String toString() {
        return Speicher.toString();
    }

    public String HatTelNr(String name) {
        if (Speicher.containsKey(name)) {
            return Speicher.get(name).toString();
        }
        return "Fehler";
    }

    public boolean loeschen(String name) {
        if (Speicher.containsKey(name)) {
            Speicher.remove(name);
            return true;
        } else
            return false;
    }

    public boolean loeschen(String name, String nummer) {
        if (Speicher.containsKey(name)) {
            Speicher.get(name).remove(nummer);
            return true;
        } else
            return false;
    }

}
