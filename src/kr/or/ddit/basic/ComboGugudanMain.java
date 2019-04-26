package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComboGugudanMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			// 가장 상위 객체가 Parent이므로 Parent 해도됨
			Parent root = FXMLLoader.load(this.getClass().getResource("ComboGugudan.fxml"));
//			BorderPane root = FXMLLoader.load(this.getClass().getResource("Combogugudan.fxml"));
//			System.out.println(this.getClass().getResource("ComboGugudan.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("콤보박스 구구단 분리버전");
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
