package com.wook.basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 400);
		root.setAlignment(Pos.CENTER);

		Button btn = new Button("종료");
		btn.setPrefWidth(80);
		btn.setOnAction(event -> Platform.exit());
		root.getChildren().add(btn);

		Scene scene = new Scene(root);
		primaryStage.setTitle("Hello JavaFX");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
