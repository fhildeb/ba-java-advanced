package applikation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainWindowController {

	@FXML
	public Label praktikumLabel;
	@FXML
	public TextField textBox;

	@FXML
	public void handleCangeText(ActionEvent e) {
		praktikumLabel.setText(textBox.getText());
	}

	public void handleClearText(ActionEvent e) {
		praktikumLabel.setText(null);
	}
}
