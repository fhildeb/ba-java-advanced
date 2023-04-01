package schreiben;

import java.io.IOException;
import java.io.RandomAccessFile;

public class StringsSchreiben {

	public static void main(String[] args) {
		try {
			String[] wortgruppe = new String[10];
			long[] filepoint = new long[10];
			RandomAccessFile dateiLesenSchreiben = new RandomAccessFile("StringsSchreiben.txt", "rw");

			wortgruppe[0] = "Testnachricht";
			wortgruppe[1] = "Das ist ein Text";
			wortgruppe[2] = "LaLaLa";
			wortgruppe[3] = "Guten Morgen";
			wortgruppe[4] = "Herrliches Wetter";
			wortgruppe[5] = "Herr";
			wortgruppe[6] = "Minister";
			wortgruppe[7] = "20 Jahre";
			wortgruppe[8] = "Bli Bla Blub";
			wortgruppe[9] = "Nina";

			for (int j = 0; j <= 9; j++) {
				filepoint[j] = dateiLesenSchreiben.getFilePointer();
				// System.out.println(filepoint[j]);
				dateiLesenSchreiben.writeUTF(wortgruppe[j]);
			}
			// Ersten Text ausgeben
			// dateiLesenSchreiben.seek(filepoint[0]);
			// System.out.println(dateiLesenSchreiben.readUTF());

			for (int k = 0; k <= 9; k++) {
				dateiLesenSchreiben.seek(filepoint[k]);
				System.out.println(dateiLesenSchreiben.readUTF());
			}

			dateiLesenSchreiben.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			// code
		}

	}
}
