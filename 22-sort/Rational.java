package sort;

public class Rational implements Comparable<Rational> {
	// Deklarieren von Variablen
	private int zaehler;
	private int nenner;

	// Konstruktor mit 2 Parametern
	public Rational(int z, int n) {
		this.zaehler = z;
		this.nenner = n;
	}

	// Konstruktor ohne Parameter
	public Rational() {
		this.zaehler = 1;
		this.nenner = 1;
	}

	// Ausgabemethode Zaehler
	public int getZaehler() {
		return this.zaehler;
	}

	// Ausgabemethode Nenner
	public int getNenner() {
		return this.nenner;
	}

	// String Ausgabe
	public String toString() {
		return this.getZaehler() + "/" + this.getNenner();
	}

	// Vergleich von Rationalen Zahlen
	public boolean equals(Rational r) {
		return (((this.getZaehler()) == (r.getZaehler())) &&
				((this.getNenner()) == (r.getNenner())));
	}

	// Rationale Zahl im Bruch ausgeben
	public double doubleValue() {
		return ((double) this.zaehler / (double) this.nenner);
	}

	// Addition von zwei Rationalen Zahlen
	public Rational plus(Rational r) {
		int neuerZaehler = ((this.getZaehler() * r.getNenner()) + (r.getZaehler() * this.getNenner()));
		int neuerNenner = (this.getNenner() * r.getNenner());
		return new Rational(neuerZaehler, neuerNenner);

	}

	// Subtraktion von zwei Rationalen Zahlen
	public Rational minus(Rational r) {
		int neuerZaehler = (this.getZaehler() * r.getNenner() - (r.getZaehler() * this.getNenner()));
		int neuerNenner = (this.getNenner() * r.getNenner());
		return new Rational(neuerZaehler, neuerNenner);
	}

	// Multiplikation von zwei Rationalen Zahlen
	public Rational mal(Rational r) {
		int neuerZaehler = (this.getZaehler() * r.getZaehler());
		int neuerNenner = (this.getNenner() * r.getNenner());
		return new Rational(neuerZaehler, neuerNenner);
	}

	// Division von zwei Rationalen Zahlen
	public Rational durch(Rational r) {
		int neuerZaehler = (this.getZaehler() * r.getNenner());
		int neuerNenner = (this.getNenner() * r.getZaehler());
		return new Rational(neuerZaehler, neuerNenner);
	}

	/*
	 * / Zusatz
	 */

	// Groesten gemeinsamen Teiler finden
	private int ggt(int zae, int nen) {
		int rest;
		while (nen != 0) {
			rest = nen;
			nen = zae % nen;
			zae = rest;
		}
		return zae;
	}

	// Bruch kuerzen
	public Rational gekuerzterBruch() {
		int teiler = ggt(this.getZaehler(), this.getNenner());
		return new Rational((this.zaehler / teiler), (this.nenner / teiler));
	}

	// Groesser-Als testen
	public boolean groesserAls(Rational r) {
		return this.doubleValue() > r.doubleValue();
	}

	// Klassenkonstanten anlegen

	public static final Rational NULL = new Rational(0, 1);
	public static final Rational EINS = new Rational(1, 1);

	// Klassenmethode Plus
	public static Rational plus(Rational r1, Rational r2) {
		int newZaehler = ((r1.getZaehler() * r2.getNenner()) + (r2.getZaehler() * r1.getNenner()));
		int newNenner = (r1.getNenner() * r2.getNenner());
		return new Rational(newZaehler, newNenner);
	}

	// Klassenmethode Minus
	public static Rational minus(Rational r1, Rational r2) {
		int newZaehler = ((r1.getZaehler() * r2.getNenner()) - (r2.getZaehler() * r1.getNenner()));
		int newNenner = (r1.getNenner() * r2.getNenner());
		return new Rational(newZaehler, newNenner);
	}

	// Klassenmethode Mal
	public static Rational mal(Rational r1, Rational r2) {
		int newZaehler = (r1.getZaehler() * r2.getZaehler());
		int newNenner = (r1.getNenner() * r2.getNenner());
		return new Rational(newZaehler, newNenner);
	}

	// Klassenmethode Durch
	public static Rational durch(Rational r1, Rational r2) {
		int newZaehler = (r1.getZaehler() * r2.getNenner());
		int newNenner = (r1.getNenner() * r2.getZaehler());
		return new Rational(newZaehler, newNenner);
	}

	public float getValue() {
		float value = this.getZaehler() / this.getNenner();
		return value;
	}

	@Override
	public int compareTo(Rational r2) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if (this == r2)
			return EQUAL;

		if (this.getValue() < r2.getValue())
			return BEFORE;
		if (this.getValue() > r2.getValue())
			return AFTER;

		return EQUAL;
	}

	// Main-Methode
	public static void main(String[] args) {
		// Erstellen von Rationalen Zahlen
		Rational r1 = new Rational(8, 2);
		new Rational(8, 2);
		Rational r3 = new Rational(4, 3);
		new Rational();

		System.out.println(r1.compareTo(r3));
	}
}