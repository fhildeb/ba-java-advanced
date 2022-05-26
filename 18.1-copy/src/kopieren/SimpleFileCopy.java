package kopieren;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class SimpleFileCopy {

	public static void copyFile(String source, String target) {
		Path sourcePath = Paths.get(source);
		Path destinationPath = Paths.get(target);

		try {
			Files.copy(sourcePath, destinationPath,
					StandardCopyOption.REPLACE_EXISTING);
		} catch (FileAlreadyExistsException e) {
			// destination file already exists
		} catch (IOException e) {
			// something else went wrong
			e.printStackTrace();
		}
	}

	public static void moveFile(String source, String target) {
		Path sourcePath = Paths.get(source);
		Path destinationPath = Paths.get(target);

		try {
			Files.move(sourcePath, destinationPath,
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// moving file failed.
			e.printStackTrace();
		}
	}

	public static void copyURL(String source, String target) throws IOException {
		URL website = new URL(source);
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		@SuppressWarnings("resource")
		FileOutputStream fos = new FileOutputStream(target);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	}
}
