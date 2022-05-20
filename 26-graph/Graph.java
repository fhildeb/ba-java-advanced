package graph;

import java.util.LinkedList;
import java.util.Stack;

/*************************************************************************
 *
 * Implementiert eine Graph-Klasse mit seinen Knoten.
 * Multigraphen (parallele Kanten) und Schleifen (Knoten die sich selbst
 * referenzieren) sind erlaubt.
 *
 * % java Graph graph_unconnected.txt
 * 13 vertices, 13 edges
 * 0: 6 2 1 5
 * 1: 0
 * 2: 0
 * 3: 5 4
 * 4: 5 6 3
 * 5: 3 4 0
 * 6: 0 4
 * 7: 8
 * 8: 7
 * 9: 11 10 12
 * 10: 9
 * 11: 9 12
 * 12: 11 9
 *
 * 
 *************************************************************************/

public class Graph {
    private final int V;
    private int E;
    private LinkedList<Integer>[] adj;

    /**
     * Legt einen Graphen bestehen aus nur einem Knoten und ohne Kanten
     * an.
     */
    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }

    /**
     * Bau einen Graphen über einen Eingabe-Strom auf.
     * Dieser Konstruktor liest alle Knoten und Kanten
     * aus einer Datei.
     */
    public Graph(Eingabe in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    /**
     * Initialisiert den Graph über ein
     * anderes Graph-Objekt.
     */
    public Graph(Graph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // Stapel mit allen Nachbarknoten
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }

    /**
     * Gibt die Anzahl der Knoten (Vertexes) zurück.
     */
    public int V() {
        return V;
    }

    /**
     * Gibt die Anzahl der Kanten (Edges) zurück.
     */
    public int E() {
        return E;
    }

    /**
     * Prüfe, ob die Knotennummer zwischen 0 und V-1 liegt.
     */
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("Knoten  " + v + " ist nicht zwischen 0 und " + (V - 1));
    }

    /**
     * Fügt eine Kante zwischen v int w ein.
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     * Gibt die benachbarten (adjaszenten) Knoten
     * in Form einer Liste mit Zahlen (Knotennummern) zurück.
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Gibt den Grad (Anzahl der angrenzenden Kanten) für
     * den angegebenen Knoten v zurück.
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * Ausgabe aller gespeicherten Knoten und Kanten des Graphen.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    /**
     * Test-Methode. Akezeptiert als Parameter einen Dateinamen.
     * Die Datei wird anschließend geöffnet und ein Graph-Objekt erzeugt
     * bzw. der Graph wird ausgegeben.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.print("Keine Parameter angegeben! \nEs wird eine Nummer benoetigt.");
        } else {
            Eingabe in = new Eingabe(args[0]);
            Graph G = new Graph(in);
            System.out.println(G);
        }

    }

}