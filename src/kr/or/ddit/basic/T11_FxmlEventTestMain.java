package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class T11_FxmlEventTestMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("FxmlEventTest.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Fxml 이벤트 연습");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
