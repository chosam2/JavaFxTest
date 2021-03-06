package javafx.scene.layout;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class T10_ComboGugudanMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		root.setPrefSize(300, 300);

		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(10);

		TextArea txtResult = new TextArea();
		txtResult.setPrefSize(200, 200);

		Button btnDan = new Button("출력");

		ComboBox<Integer> cmbDan = new ComboBox<>();
		cmbDan.setPrefWidth(150);

		ObservableList<Integer> list = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		cmbDan.setItems(list);

		btnDan.setOnAction(event->{
			int dan = cmbDan.getSelectionModel().getSelectedItem();

			txtResult.setText(dan + "단\n\n");
			for (int i = 1; i <= 9; i++) {
				int r = dan * i;
				txtResult.appendText(dan + " * " + i + " = " + r + "\n");
			}
		});
		
		
		// 람다식 버전(콤보박스 선택했을 때)
//		cmbDan.setOnAction(event->{
//			int dan = cmbDan.getSelectionModel().getSelectedItem();
//
//			txtResult.setText(dan + "단\n\n");
//			for (int i = 1; i <= 9; i++) {
//				int r = dan * i;
//				txtResult.appendText(dan + " * " + i + " = " + r + "\n");
//			}
//		});
//		
		
//		cmbDan.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				int dan = cmbDan.getSelectionModel().getSelectedItem();
//
//				txtResult.setText(dan + "단\n\n");
//				for (int i = 1; i <= 9; i++) {
//					int r = dan * i;
//					txtResult.appendText(dan + " * " + i + " = " + r + "\n");
//				}
//			}
//		});

//		cmbDan.valueProperty().addListener(new ChangeListener<Integer>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
//				int dan = newValue;
//
//				txtResult.setText(dan + "단\n\n");
//				for (int i = 1; i <= 9; i++) {
//					int r = dan * i;
//					txtResult.appendText(dan + " * " + i + " = " + r + "\n");
//				}
//			}
//		});

		hbox.getChildren().addAll(cmbDan, btnDan);

		root.setTop(hbox);
		root.setCenter(txtResult);

		Scene scene = new Scene(root);
		primaryStage.setTitle("콤보박스 구구단");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
