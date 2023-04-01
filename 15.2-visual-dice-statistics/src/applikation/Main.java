package applikation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loadernew = new FXMLLoader();
			loadernew.setLocation(Main.class.getResource("MainWindow.fxml"));
			AnchorPane root = loadernew.load();
			Scene scene = new Scene(root, 900, 450);
			primaryStage.setTitle("Praktikum 15b");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
