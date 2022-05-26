package sort;

public class Sort {

	public static int seqSuche(int[] feld, int gesucht) {
		int i = 0;

		while (feld[i] != gesucht) {
			i++;
		}
		return i;
	}

	public static int binSuche(int[] feld, int gesucht, int von, int bis) {
		int pos = -1;

		if (von <= bis) {
			int mitte = (von + bis) / 2;
			if (gesucht > feld[mitte])
				pos = binSuche(feld, gesucht, mitte + 1, bis);
			else {
				if (gesucht < feld[mitte])
					pos = binSuche(feld, gesucht, von, mitte - 1);
				else
					pos = mitte;
			}
			return pos;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] feld = new int[200];
		for (int i = 0; i < 200; i++) {
			feld[i] = i;
		}
		int gefunden = seqSuche(feld, 4);
		System.out.println(gefunden);
		int gefunden2 = binSuche(feld, 4, 0, 200);
		System.out.println(gefunden2);

	}
}
