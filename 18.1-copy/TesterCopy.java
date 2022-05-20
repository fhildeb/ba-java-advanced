package copy;

import java.io.IOException;

public class TesterCopy {

	public static void main(String[] args) {
		SimpleFileCopy.copyFile("copyfile.txt", "filecopy.txt");
		try {
			SimpleFileCopy.copyURL("http://www.hs-mittweida.de", "URLcopy.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
