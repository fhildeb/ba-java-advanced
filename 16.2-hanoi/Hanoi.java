package hanoi;

import java.util.Scanner;

public class Hanoi {

	int starthoehe;
	static int bewegungen = 0;

	public static void bewegen(char von, char nach) {
		System.out.println("Schiebe von " + von + " nach " + nach);
		bewegungen++;
	}
	
	public static void turm(char start, char ziel, char ablage, int hoehe) {
		if(hoehe > 1) {
			turm(start, ablage, ziel, hoehe - 1);
		}
		bewegen(start, ziel);
		if(hoehe>1) {
			turm(ablage, ziel, start, hoehe -1);
		}
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("Geben sie die Anzahl der Scheiben des Turms an:");
		int hoehe = s.nextInt();
		
		System.out.println("Die Ausgabe fuer einen Turm von Hanoi der Hoehe " + hoehe + ".");
		System.out.println("Die Staebe sind mit A, B, C bezeichnet.");
		System.out.println("Der Turm soll von A nach C transportiert werden.");
		turm('A', 'B', 'C', hoehe);
		System.out.println("Es wurden " + bewegungen + " Bewegungen benoetigt.");
	}
}
