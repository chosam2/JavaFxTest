package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class FxmlEventTestController implements Initializable {
	//public class FxmlEventTestController {

	@FXML
	private TextField txtInput;
	@FXML
	private Button btnOk;
	@FXML
	private TextArea txtResult;

	/**
	 * FXML문서를 객체(인스턴스)화 한 후에 처리되는 영역
	 * 주로 초기화 작업등에 사용한다.
	 */
	 @Override
		public void initialize(URL location, ResourceBundle resources) {
	
		 assert txtInput != null : "fx:id=\"txtInput\" was not injected: "
			 						+ "check your FXML file 'FxmlEventTest.fxml'.";

		 assert btnOk != null : "fx:id=\"btnOk\" was not injected: "
				 + "check your FXML file 'FxmlEventTest.fxml'.";
		 
		 assert txtResult != null : "fx:id=\"txtResult\" was not injected: "
				 + "check your FXML file 'FxmlEventTest.fxml'.";
		 
	 }
		 
//	@FXML
//	public void initialize() {
//		btnOk.setOnAction(event -> {
//			btnClick(event);
//		});
//	}

	 /**
	  * 출력 버튼을 클릭할 때 실행되는 메서드
	  * @param event
	  */
	@FXML
	public void btnClick(ActionEvent event) {
		// TextField에는 출력할 단을 입력하고 버튼을 누르면 해당 단을 TextArea영역에 출력하시오.
		String strDan = txtInput.getText();
		if (!Pattern.matches("^[0-9]+$", strDan)) {
			alertError("출력할 단을 정확히 입력하세요.");
			return;
		}

		int dan = Integer.parseInt(strDan);

		txtResult.setText(dan + "단\n\n");
		for (int i = 1; i <= 9; i++) {
			int r = dan * i;
			txtResult.appendText(dan + " * " + i + " = " + r + "\n");
		}
	}

	/**
	 * 에러 메시지를 출력하는 경고창
	 * @param string
	 */
	private void alertError(String msg) {
		Alert alertError = new Alert(AlertType.ERROR);

		alertError.setTitle("ERROR");
		alertError.setContentText(msg);
		alertError.showAndWait();
	}

}
