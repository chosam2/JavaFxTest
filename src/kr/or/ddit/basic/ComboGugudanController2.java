package kr.or.ddit.basic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class ComboGugudanController2 {	// initialize 안하고 그냥 해도됨

	@FXML // 어노테이션 : 멤버변수 선언. 해당 정보는 fxml에 파싱해서 정보를 만들어줌
	private ComboBox<Integer> cmbDan; // 보안을 위해서 private 해줌
	@FXML
	private Button btnDan;
	@FXML
	private TextArea txtResult;

	@FXML	// @Override대신 @FXML붙히고 해도됨
	public void initialize() {

		ObservableList<Integer> list = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		cmbDan.setItems(list);

		btnDan.setOnAction(event -> {
			int dan = cmbDan.getSelectionModel().getSelectedItem();

			txtResult.setText(dan + "단\n\n");
			for (int i = 1; i <= 9; i++) {
				int r = dan * i;
				txtResult.appendText(dan + " * " + i + " = " + r + "\n");
			}
		});

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
	}
}
