package kopieren;

import java.io.IOException;

public class TesterCopy {

	public static void main(String[] args) {
		SimpleFileCopy.copyFile("copyfile.txt", "filecopy.txt");
		System.out.println("Datei kopiert.");
		try {
			SimpleFileCopy.copyURL("http://www.hs-mittweida.de", "URLcopy.txt");
			System.out.println("URL kopiert.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
