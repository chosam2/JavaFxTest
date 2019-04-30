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

public class Z01_CheckComboBoxTestController2 implements Initializable {

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ToggleGroup group = new ToggleGroup();
		
		radio_male.setToggleGroup(group);
		radio_male.setUserData("남 성");
		radio_femail.setToggleGroup(group);
		radio_femail.setUserData("여 성");
	}

}
