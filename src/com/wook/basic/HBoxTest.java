package com.wook.basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HBoxTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("HBoxTest.fxml"));
		Scene sceen = new Scene(root);
		
		primaryStage.setTitle("HBoxTest!!");
		primaryStage.setResizable(false);
		primaryStage.setScene(sceen);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
