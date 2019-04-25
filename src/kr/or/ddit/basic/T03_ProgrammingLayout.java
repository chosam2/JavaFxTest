package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class T03_ProgrammingLayout extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// HBox컨테이너 생성
		HBox hBox = new HBox();

		// 안쪽 여백 
		// Insets객체는 값을 주는 순서가 위, 오른쪽, 아래, 왼쪽 순으로 실행한다.
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(50); // 컨트롤과 컨트롤 사이의 간격

		// 한줄의 데이터를 입력받는 컨트롤 : TextField객체
		TextField textField = new TextField();
		textField.setPrefWidth(200); // TextField의 너비 크기 설정

		Button button = new Button("확 인"); // 버튼 객체 생성

		// HBox에 추가하기
		hBox.getChildren().addAll(textField, button); // addAll하면 한번에 다 
		//		hBox.getChildren().add(textField);
		//		hBox.getChildren().add(button);

		// Scene객체 생성
		Scene scene = new Scene(hBox);

		primaryStage.setTitle("자바코드를 이용한 레이아웃 설정하기");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
