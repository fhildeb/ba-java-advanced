package fakultät;

public class Fakultaet {

	public static long berechneFakultaet(int n) {
			if (n>1) return(n * berechneFakultaet(n - 1));
			else return(1);
	}
}
