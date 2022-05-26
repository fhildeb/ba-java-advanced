package graph;

/**
 * Rahmenklasse fuer einen Algorithmus zur Tiefensuche.
 *
 */
public class Tiefensuche {

	private int s; // Start-Knoten, von dem aus die Suche beginnen soll.

	/**
	 * Konstruktor.
	 * 
	 * @param G zu durchsuchender Graph
	 * @param s Nummer des Ausgangspunktes (Vertex)
	 */
	public Tiefensuche(Graph G, int s) {
		// Hier muessen noch die Attribute der Klasse initialisiert werden
		suche(G, s);
	}

	/**
	 * Eigentliche Suchmethode.
	 * 
	 * @param G zu durchsuchender Graph
	 *          * @param v AusgangspunktVertex)
	 */
	private void suche(Graph G, int v) {

	}

	/**
	 * Gibt die Anzahl der Knoten zurueck, die mit dem Start-Knoten <tt>s</tt>
	 * verbunden sind.
	 * 
	 * @return Anzahl <tt>s</tt>
	 */
	public int count() {
		return s;
		// bitte ergaenzen
	}

	/**
	 * Existiert ein Pfad zwischen Knoten <tt>s</tt> Knoten <tt>v</tt>?
	 * 
	 * @param v der Knoten
	 * @return <tt>true</tt> falls Pfad existiert, andernfalls <tt>false</tt>
	 */
	public boolean marked(int v) {
		return false;
		// bitte ergaenzen Tipp: Wenn ein Knoten markiert ist, so kann er von s aus auch
		// erreicht werden
	}
}
