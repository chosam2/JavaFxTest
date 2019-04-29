package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class Z01_CheckComboBoxTestController implements Initializable {

	@FXML
	RadioButton radio_male;
	@FXML
	RadioButton radio_femail;
	@FXML
	CheckBox chk_trip;
	@FXML
	CheckBox chk_mountain;
	@FXML
	CheckBox chk_book;
	@FXML
	CheckBox chk_go;
	@FXML
	CheckBox chk_chess;
	@FXML
	CheckBox chk_game;
	@FXML
	CheckBox chk_tennis;
	@FXML
	CheckBox chk_badminton;
	@FXML
	Button btn_Show;
	@FXML
	TextField txt_name;
	@FXML
	TextArea txt_Show;

	
	String str = "";
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ToggleGroup group = new ToggleGroup();
		
		radio_femail.setToggleGroup(group);
		radio_femail.setUserData("여 성");
		
		radio_male.setToggleGroup(group);
		radio_male.setUserData("남 성");
		radio_male.setSelected(true);


		btn_Show.setOnAction(event -> {
			str = "";
			txt_Show.clear();

			str += "이 름 : " + txt_name.getText() + "\n성 별 : ";
			group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

				@Override
				public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
					if(group.getSelectedToggle().getUserData() != null) {
						str += group.getSelectedToggle().getUserData().toString() + "\n취 미 : ";
						System.out.println(str);
					}
				}
			});

//			if (radio_femail.isSelected()) {
//				str += radio_femail.getText() + "\n취 미 : ";
//			} else if (radio_male.isSelected()) {
//				str += radio_male.getText() + "\n취 미 : ";
//			}
			//			if (group.getSelectedToggle().isSelected()) {
			//				str += radio_femail.getText() + "\n취 미 : ";
			//			} else if (group.getSelectedToggle().isSelected()) {
			//				str += radio_male.getText() + "\n취 미 : ";
			//			}

			if (chk_trip.isSelected()) {
				str += chk_trip.getText() + ", ";
			}
			if (chk_mountain.isSelected()) {
				str += chk_mountain.getText() + ", ";
			}
			if (chk_book.isSelected()) {
				str += chk_book.getText() + ", ";
			}
			if (chk_go.isSelected()) {
				str += chk_go.getText() + ", ";
			}
			if (chk_chess.isSelected()) {
				str += chk_chess.getText() + ", ";
			}
			if (chk_game.isSelected()) {
				str += chk_game.getText() + ", ";
			}
			if (chk_tennis.isSelected()) {
				str += chk_tennis.getText() + ", ";
			}
			if (chk_badminton.isSelected()) {
				str += chk_badminton.getText() + ", ";
			}

			txt_Show.setText(str);

		});
	}

}
