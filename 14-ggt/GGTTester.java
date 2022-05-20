/**
 * 
 */
package ggt;

/**
 * @author Felix Hildebrandt
 *
 */
public class GGTTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Aufruf: java GGTTester 1.Zahl 2.Zahl ");
			System.exit(1);
		}
		try {
			long a = Long.parseLong(args[0]);
			long b = Long.parseLong(args[1]);
			long ggt = GGTBerechner.berechneGGT(a, b);
			System.out.println("GGT(" + a + ", " + b + ") = " + ggt);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
