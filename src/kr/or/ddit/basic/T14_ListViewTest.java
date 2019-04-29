package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class T14_ListViewTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ListView<String> list = new ListView<>();

		Label label = new Label();
		label.setFont(new Font(20));

		// ListView에 들어갈 데이터 구성하기
		ObservableList<String> data = FXCollections.observableArrayList("green", "gold", "red", "blue", "black", "brown", "blueviolet", "pink", "yellow", "chocolate");

		VBox vbox = new VBox(10);
		// 데이터 세팅 방법1
		list.setItems(data);

		// 데이터 세팅 방법2	--> ObservableList 반환
		list.getItems().addAll("green", "gold", "red", "blue", "black", "brown", "blueviolet", "pink", "yellow", "chocolate");

		// ListView에서 값이 선택되었을떄 처리
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() { // --> getSelectionModel() 구구단 콤보박스에서 사용했었음

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				label.setText(newValue); // -> 하단 레이블에 출력
				label.setTextFill(Color.web(newValue)); // 글자색 변경 --> 선택되었을때 색상  
			}
		});

		// ListView의 내용은 변경되지 않고 화면에 보이는 부분만 변경하는 방법
		list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> param) { // EventListener에서 Change되는것처럼 사용하는거임
				return new ListCell<String>() {
					protected void updateItem(String item, boolean empty) { // item에는 색깔 red, blue 이런거 넘어옴(화면이 만들어지는 타이밍에)
						super.updateItem(item, empty);

						Rectangle rect = new Rectangle(100, 20);
						if (item != null) { // 또는 !empty
							rect.setFill(Color.web(item)); // 4각형 내부 색칠하기
							//							setGraphic(rect); // 값 변경하기.
							// 변경되는 데이터가 문자열이면 setText()메서드를 사용한다.

							Label lbTxt = new Label(item);
							lbTxt.setTextFill(Color.web(item));

							HBox hb2 = new HBox(10);
							hb2.getChildren().addAll(rect, lbTxt);

							setGraphic(hb2);

						}
						//	setText(item);
					}
				};
			}
		});

		vbox.getChildren().addAll(list, label);

		Scene scene = new Scene(vbox);
		primaryStage.setTitle("ListView 연습");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
