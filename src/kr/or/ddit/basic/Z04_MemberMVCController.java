package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Z04_MemberMVCController implements Initializable {

	@FXML
	TextField input_id;
	@FXML
	TextField input_name;
	@FXML
	TextField input_tel;
	@FXML
	Button btn_add;
	@FXML
	Button btn_edit;
	@FXML
	Button btn_delete;
	@FXML
	Button btn_ok;
	@FXML
	Button btn_cancel;
	@FXML
	TableView<Member> tableView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}

class Member {
	private String id; // 아이디
	private String name; // 이름
	private String tel; // 전화번호
	private String addr; // 주소

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}
