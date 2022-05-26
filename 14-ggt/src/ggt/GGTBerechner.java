/**
 * 
 */
package ggt;

/**
 * @author Felix Hildebrandt
 *
 */
public class GGTBerechner {
	public static long berechneGGT(long a, long b)
			throws IllegalArgumentException {
		if ((a <= 0) || (b <= 0)) {
			throw new IllegalArgumentException("nicht zwei positive ganze Zahlen!");
		}
		if (a < b) {
			long hilf = a;
			a = b;
			b = hilf;
		}
		long r = a % b;
		while (r > 0) {
			a = b;
			b = r;
			r = a % b;
		}
		return b;
	}
}
