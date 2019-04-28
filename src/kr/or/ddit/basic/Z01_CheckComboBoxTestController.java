package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;

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

	ToggleGroup group = new ToggleGroup();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		radio_femail.setToggleGroup(group);
		radio_male.setToggleGroup(group);

		//		group.selectedToggleProperty().addListener((observable, oldVal, newVal) -> System.out.println(newVal + "선택"));
		btn_Show.setOnAction(event -> {
			txt_Show.clear();

			String str = "";
			str += "이 름 : " + txt_name.getText() + "\n성 별 : ";

			if (radio_femail.isSelected()) {
				str += radio_femail.getText() + "\n취 미 : ";
			} else if (radio_male.isSelected()) {
				str += radio_male.getText() + "\n취 미 : ";
			}
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
