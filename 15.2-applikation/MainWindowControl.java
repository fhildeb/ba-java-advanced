package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainWindowControl {

	public Wuerfel wuerfel = new Wuerfel();
	@FXML
	private TextField textBox;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView tabHaeufigkeiten;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn tabAugenzahlen;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn tabAbsHaeufigkeit;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn tabRelHaeufigkeit;
	@FXML
	private PieChart diaHaeufigkeit;

	@FXML
	public void handleWuerfeln() {
		try {
			wuerfel.wuerfeln(Integer.parseInt(textBox.getText()));
		} catch (NumberFormatException e) {
			System.out.println("Keine Zahl eingegeben");
		}
		showTableView();
		showPieChart();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void showTableView() {
		@SuppressWarnings("deprecation")
		ObservableList<Haeufigkeiten> data = FXCollections.observableArrayList(
				new Haeufigkeiten("Eins", new Integer(wuerfel.getAbsHaeufigkeit(0)),
						new Double(wuerfel.getRelHaeufigkeit(0))),
				new Haeufigkeiten("Zwei", new Integer(wuerfel.getAbsHaeufigkeit(1)),
						new Double(wuerfel.getRelHaeufigkeit(1))),
				new Haeufigkeiten("Drei", new Integer(wuerfel.getAbsHaeufigkeit(2)),
						new Double(wuerfel.getRelHaeufigkeit(2))),
				new Haeufigkeiten("Vier", new Integer(wuerfel.getAbsHaeufigkeit(3)),
						new Double(wuerfel.getRelHaeufigkeit(3))),
				new Haeufigkeiten("Fuenf", new Integer(wuerfel.getAbsHaeufigkeit(4)),
						new Double(wuerfel.getRelHaeufigkeit(4))),
				new Haeufigkeiten("Sechs", new Integer(wuerfel.getAbsHaeufigkeit(5)),
						new Double(wuerfel.getRelHaeufigkeit(5))));
		tabAugenzahlen.setCellValueFactory(new PropertyValueFactory("augenzahl"));
		tabAbsHaeufigkeit.setCellValueFactory(new PropertyValueFactory("absHaeufigkeit"));
		tabRelHaeufigkeit.setCellValueFactory(new PropertyValueFactory("relHaeufigkeit"));

		tabHaeufigkeiten.setItems(data);
	}

	public void showPieChart() {
		String[] augenZahl = { "Eins", "Zwei", "Drei", "Vier", "Fuenf", "Sechs" };

		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		for (int i = 0; i < 6; i++) {
			data.add(new PieChart.Data(augenZahl[i], wuerfel.getRelHaeufigkeit(i)));
		}

		diaHaeufigkeit.setData(data);
		diaHaeufigkeit.setTitle("Relative Haeufigkeiten");
	}
}
