package kr.or.ddit.basic.paging;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.scene.Node;
import javafx.scene.control.Pagination;

public class PagingController implements Initializable {

	@FXML
	private TableView<MemberVO> tableView;
	@FXML
	private TableColumn<MemberVO, String> id;
	@FXML
	private TableColumn<MemberVO, String> name;
	@FXML
	private TableColumn<MemberVO, String> address;
	@FXML
	private Pagination pagination;

	private int from, to, itemsForPage;

	private ObservableList<MemberVO> allTableData, currentPageData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		address.setCellValueFactory(new PropertyValueFactory<>("address"));

		// 전체 테이블 데이터 설정
		allTableData = FXCollections.observableArrayList(new MemberVO("1", "홍길동1", "대전시 중구 대흥동 대덕인재개발원"), new MemberVO("2", "홍길동2", "대전시 중구 대흥동 대덕인재개발원"), new MemberVO("3", "홍길동3", "대전시 중구 대흥동 대덕인재개발원"),
				new MemberVO("4", "홍길동4", "대전시 중구 대흥동 대덕인재개발원"), new MemberVO("5", "홍길동5", "대전시 중구 대흥동 대덕인재개발원"), new MemberVO("6", "홍길동6", "대전시 중구 대흥동 대덕인재개발원"), new MemberVO("7", "홍길동7", "대전시 중구 대흥동 대덕인재개발원"),
				new MemberVO("8", "홍길동8", "대전시 중구 대흥동 대덕인재개발원"), new MemberVO("9", "홍길동9", "대전시 중구 대흥동 대덕인재개발원"), new MemberVO("10", "홍길동10", "대전시 중구 대흥동 대덕인재개발원"), new MemberVO("11", "홍길동11", "대전시 중구 대흥동 대덕인재개발원"),
				new MemberVO("12", "홍길동12", "대전시 중구 대흥동 대덕인재개발원"), new MemberVO("13", "홍길동13", "대전시 중구 대흥동 대덕인재개발원"), new MemberVO("14", "홍길동14", "대전시 중구 대흥동 대덕인재개발원"), new MemberVO("15", "홍길동15", "대전시 중구 대흥동 대덕인재개발원"),
				new MemberVO("16", "홍길동16", "대전시 중구 대흥동 대덕인재개발원"));

		itemsForPage = 5;	// 한 페이지에 보여줄 항목 수 설정

		int toItemCnt = allTableData.size();
		int toPageCnt = toItemCnt % itemsForPage == 0 ? 
						toItemCnt / itemsForPage : toItemCnt / itemsForPage + 1;
			pagination.setPageCount(toPageCnt);
		
		// 방법1(Callback타입의 익명객체 생성)
		pagination.setPageFactory(new Callback<Integer, Node>() {

			@Override
			public Node call(Integer pageIndex) {
				from = pageIndex * itemsForPage;
				to = from + itemsForPage - 1;
				tableView.setItems(getTableData(from, to));
				return tableView;
			}

		});
		
		// 방법2(람다식)
		pagination.setPageFactory((Integer pageIndex)->{
			
			from = pageIndex * itemsForPage;
			to = from + itemsForPage - 1;
			tableView.setItems(getTableData(from, to));
			
			return tableView;
		});

	}

	/**
	 * TableView에 채워줄 데이터를 가져오는 함수
	 * @param from
	 * @param to
	 * @return
	 */
	private ObservableList<MemberVO> getTableData(int from, int to) {
		currentPageData = FXCollections.observableArrayList(); // 현재페이지 데이터 쵝화
		int toSize = allTableData.size();
		for(int i = from; i <= to && i < toSize; i++) {
			currentPageData.add(allTableData.get(i));
		}
		return currentPageData;
	}

}
