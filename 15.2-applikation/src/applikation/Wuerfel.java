package applikation;

public class Wuerfel {
	private int max = 6;
	private int[] haeufigkeit;
	private double[] relHaeufigkeit;

	public Wuerfel() {

		haeufigkeit = new int[max];
		relHaeufigkeit = new double[max];

		for (int i = 0; i < max; i++) {
			haeufigkeit[i] = 0;
			relHaeufigkeit[i] = 0;
		}

	}

	public void wuerfeln(int anzahl) {

		int[] intArray = new int[anzahl];
		int i, j;

		// n mal wuerfeln
		for (i = 0; i < intArray.length; i = i + 1) {
			intArray[i] = (int) ((Math.random()) * max) + 1;
		}
		for (i = 0; i < intArray.length; i = i + 1) {
			System.out.print(intArray[i] + " ");
		}
		System.out.println();

		// Berechnung der Summe
		int summe = 0;
		for (i = 0; i < intArray.length; i = i + 1) {
			summe = summe + intArray[i];
		}
		System.out.println("Summe = " + summe);
		double durchschnitt = (double) summe / anzahl;
		System.out.println("Durchschnitt = " + durchschnitt);

		// Berechnung Absolute Haeufigkeiten
		for (i = 0; i < intArray.length; i = i + 1) {
			haeufigkeit[intArray[i] - 1] = haeufigkeit[intArray[i] - 1] + 1;
		}

		// Berechnung der relativen Haeufigkeiten in %
		for (j = 0; j < relHaeufigkeit.length; j = j + 1) {
			relHaeufigkeit[j] = haeufigkeit[j] * 100.0 / anzahl;
		}

		// Berechnung Standardabweichung
		double quadAbweichung = 0;
		for (i = 0; i < intArray.length; i = i + 1) {
			quadAbweichung = quadAbweichung
					+ (intArray[i] - durchschnitt) * (intArray[i] - durchschnitt);
		}
		double stdAbweichung = Math.sqrt((1.0 / (anzahl - 1)) * quadAbweichung);
		System.out.println("Standardabweichung = " + stdAbweichung);

	}

	public int getAbsHaeufigkeit(int i) {
		return haeufigkeit[i];
	}

	public double getRelHaeufigkeit(int i) {
		return relHaeufigkeit[i];
	}

}