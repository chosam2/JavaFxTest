package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class T12_CheckBoxTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Rectangle rect = new Rectangle(90, 30); // 4각형 그리기
		rect.setArcHeight(10); // 둥근 4각형 만들기 위한 꼭지점 모따기
		rect.setArcWidth(10);
		rect.setFill(Color.rgb(41, 41, 41)); // 4각형 내부 색칠하기

		String[] names = new String[] { "Security", "Project", "Chart" };
		Image[] images = new Image[names.length];
		ImageView[] icons = new ImageView[names.length];
		CheckBox[] chkBoxs = new CheckBox[names.length];

		for (int i = 0; i < names.length; i++) {
			// 출력할 이미지 읽어오기
			final Image img = images[i] = new Image(getClass().getResourceAsStream("images/" + names[i] + ".png"));

			//			System.out.println(getClass().getResourceAsStream("images/Chart.png"));

			// 이미지를 출력하는 객체 생성
			final ImageView icon = icons[i] = new ImageView();
			final CheckBox cb = chkBoxs[i] = new CheckBox(names[i]);

			//CheckBox를 출력해서 값이 변경되었을 때의 이벤트 처리
			cb.selectedProperty().addListener(new ChangeListener<Boolean>() {

				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					// 변수 oldValue는 변경되기 전 상태 값
					// 변수 newValue는 변경된 후의 상태 값

					// ImageView의 setImage()메서드는 보여줄 이미지를 세팅하는 메서드 이다.
					// icon.setImage(newValue ? img : null);

					if (newValue == true) {
						icon.setImage(img);
					} else {
						icon.setImage(null); // ImageView에서 이미지 삭제
					}
				}
			});
		}

		Button btnOk = new Button("확 인");

		btnOk.setOnAction(e -> {
			// CheckBox의 check여부를 확인 하는 방법
			if (chkBoxs[1].isSelected()) {
				System.out.println(chkBoxs[1].getText() + "체크");
			} else {
				System.out.println(chkBoxs[1].getText() + "체크 해제");
			}

			// CheckBox의 check여부 세팅하기
			// chkBoxs[0].setSelected(true); // 체크 하기
			// chkBoxs[0].setSelected(false); // 체크 해제 하기
			chkBoxs[0].setSelected(!chkBoxs[1].isSelected());
		});

		VBox vbox = new VBox(5);
		vbox.getChildren().addAll(chkBoxs);
		vbox.getChildren().add(btnOk);

		HBox hbox = new HBox();
		hbox.getChildren().addAll(icons);
		hbox.setPadding(new Insets(0, 0, 0, 5));

		// StackPane은 컨트롤들을 쌓아 놓는 방식으로 배치하는  컨테이너이다.
		StackPane stack = new StackPane();
		stack.getChildren().addAll(rect, hbox);
		StackPane.setAlignment(rect, Pos.TOP_CENTER);

		HBox root = new HBox();
		root.setSpacing(40);
		root.setPadding(new Insets(20, 10, 10, 20));
		root.getChildren().addAll(vbox, stack);

		Scene scene = new Scene(root);

		primaryStage.setTitle("CheckBox 연습");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
