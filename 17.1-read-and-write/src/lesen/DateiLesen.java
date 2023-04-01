package lesen;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DateiLesen {

	public static void main(String[] args) {
		try {
			int[] zahlen = new int[100];
			RandomAccessFile dateiLesenSchreiben = new RandomAccessFile("NeueDatei.txt", "rw");

			for (int i = 1, j = 0; i <= 50; i++, j++) {
				zahlen[j] = i * i;
				dateiLesenSchreiben.writeInt(zahlen[j]);
			}

			dateiLesenSchreiben.seek(0);
			// System.out.println("" + dateiLesenSchreiben.readInt());

			int k = (int) dateiLesenSchreiben.length();
			while (k > 0) {
				try {
					System.out.println("" + dateiLesenSchreiben.readInt());
					// System.out.println(dateiLesenSchreiben.getFilePointer());
				} catch (EOFException e) {

				}
				k--;
			}
			dateiLesenSchreiben.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			// code
		}
	}
}
