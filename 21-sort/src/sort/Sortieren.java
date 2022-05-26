package sort;

import java.util.*;

public class Sortieren {
    // Entwickeln Sie hier Ihre Loesungen

    // Bubblesort
    public static int[] bubblesort(int[] zusortieren) {
        int temp;
        for (int i = 1; i < zusortieren.length; i++) {
            for (int j = 0; j < zusortieren.length - i; j++) {
                if (zusortieren[j] > zusortieren[j + 1]) {
                    temp = zusortieren[j];
                    zusortieren[j] = zusortieren[j + 1];
                    zusortieren[j + 1] = temp;
                }

            }
        }
        return zusortieren;
    }

    // InsertionSort
    public static int[] insertionsort(int[] sortieren) {
        int temp;
        for (int i = 1; i < sortieren.length; i++) {
            temp = sortieren[i];
            int j = i;
            while (j > 0 && sortieren[j - 1] > temp) {
                sortieren[j] = sortieren[j - 1];
                j--;
            }
            sortieren[j] = temp;
        }
        return sortieren;
    }

    // SelectionSort
    public static int[] selectionsort(int[] sortieren) {
        for (int i = 0; i < sortieren.length - 1; i++) {
            for (int j = i + 1; j < sortieren.length; j++) {
                if (sortieren[i] > sortieren[j]) {
                    int temp = sortieren[i];
                    sortieren[i] = sortieren[j];
                    sortieren[j] = temp;
                }
            }
        }

        return sortieren;
    }

    /**
     * main()-Methode zum Testen
     *
     * @param args die Kommandozeilenparameter
     */
    public static void main(String[] args) {
        int anzahl = 50000; // 50.000
        int[] a;

        a = bestArray(anzahl);
        System.out.print("aufsteigend geordnetes Array");

        long start1 = System.currentTimeMillis();
        bubblesort(a);
        System.out.println("Zeit benoetigt BubbleSort Best: " + (System.currentTimeMillis() - start1));

        long start11 = System.currentTimeMillis();
        insertionsort(a);
        System.out.println("Zeit benoetigt InsertionSort Best: " + (System.currentTimeMillis() - start11));

        long start111 = System.currentTimeMillis();
        selectionsort(a);
        System.out.println("Zeit benoetigt SelectionSort Best: " + (System.currentTimeMillis() - start111));
        System.out.println();

        a = worstArray(anzahl);
        System.out.print("absteigend geordnetes Array");

        long start2 = System.currentTimeMillis();
        bubblesort(a);
        System.out.println("Zeit benoetigt BubbleSort Worst: " + (System.currentTimeMillis() - start2));

        long start22 = System.currentTimeMillis();
        insertionsort(a);
        System.out.println("Zeit benoetigt InsertionSort Worst: " + (System.currentTimeMillis() - start22));

        long start222 = System.currentTimeMillis();
        insertionsort(a);
        System.out.println("Zeit benoetigt SelectionSort Worst: " + (System.currentTimeMillis() - start222));
        System.out.println();

        a = randArray(anzahl);
        System.out.println("zufoelliges Array");

        long start3 = System.currentTimeMillis();
        bubblesort(a);
        System.out.println("Zeit benoetigt BubbleSort Random: " + (System.currentTimeMillis() - start3));

        long start33 = System.currentTimeMillis();
        insertionsort(a);
        System.out.println("Zeit benoetigt InsertionSort Random: " + (System.currentTimeMillis() - start33));

        long start333 = System.currentTimeMillis();
        insertionsort(a);
        System.out.println("Zeit benoetigt SelectionSort Random: " + (System.currentTimeMillis() - start333));
        System.out.println();

    }

    // Hilfsmethoden

    /**
     * Methode zum Ausgeben eines Arrays von int-Zahlen
     *
     * @param zahlen das auszugebende Array von int-Zahlen
     */
    public static void printArray(int[] zahlen) {
        System.out.println(Arrays.toString(zahlen));
    }

    /**
     * Methode zum Erzeugen eines aufsteigend sortierten Arrays von int-Zahlen
     *
     * @param n die Groesse des zu erzeugenden Arrays
     * @return das erzeugte Array {0, 1, ... , n-1}
     */
    public static int[] bestArray(int n) {
        int[] zahlen = new int[n];
        for (int i = 0; i < n; i++) {
            zahlen[i] = i;
        }
        return zahlen;
    }

    /**
     * Methode zum Erzeugen eines absteigend sortierten Arrays von int-Zahlen
     *
     * @param n die Groesse des zu erzeugenden Arrays
     * @return das erzeugte Array {n-1, n-2, ... , 0}
     */
    public static int[] worstArray(int n) {
        int[] zahlen = new int[n];
        for (int i = 0; i < n; i++) {
            zahlen[i] = n - 1 - i;
        }
        return zahlen;
    }

    /**
     * Methode zum Erzeugen eines Arrays von zufoelligen int-Zahlen
     *
     * @param n die Groesse des zu erzeugenden Arrays
     * @return das erzeugte Array aus Zufallszahlen
     */
    public static int[] randArray(int n) {
        int[] zahlen = new int[n];
        for (int i = 0; i < n; i++) {
            zahlen[i] = (int) (Math.random() * n);
        }
        return zahlen;
    }
}