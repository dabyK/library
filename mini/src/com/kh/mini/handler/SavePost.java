package com.kh.mini.handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.model.dao.SBoardDB;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.SBoard;

public class SavePost extends MouseAdapter {

	private JPanel now;
	private JFrame main;
	private Member m; //현재 접속한 사람
	private HashMap<String, SBoard> boards; //게시글들의 맵
	private JTextField jm; //글 제목을 입력하는 field
	private JTextArea content; //글 내용을 입력하는 area
	private JDialog dialog; //현재 팝업창(게시글 작성팝업)
	private JTable table; //게시글들 목록이 보여지는 테이블

	public SavePost(JPanel now, JFrame main, Member m, HashMap<String, SBoard> boards, JTextField jm, JTextArea content,
			JDialog dialog, JTable table) {
		super();
		this.now = now;
		this.main = main;
		this.m = m;
		this.boards = boards;
		this.jm = jm;
		this.content = content;
		this.dialog = dialog;
		this.table = table;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		//저장을 누르면 글을 저장하도록 만드는 이벤트
		
		//새로 써진 글의 게시글 번호를 가장 큰 번호로 지정해주는 로직s
		String num = "1";//글 번호를 기본적으로 1로 설정한다
		int max = 0; //이전에 써졌던 글의 최대값을 구해 비교하기 위해 max값을 만들어줌
		String a = ""; //게시글 번호가 String으로 저장되어 있기 때문에, 그것을 받아오기 위해 String 변수를 하나 선언해줌
		
		if (boards == null) { //게시글이 하나도 없는 상태라면
			num = "1"; //게시글번호를 1로 설정함
		} else {
			try {
				Set keys = boards.keySet(); // boards라는 Map의 키 모아오기(key는 String 타입의 게시글 번호들)
				String[] nums = new String[keys.size()];// 키의 갯수만큼의 배열을 만듬
				Iterator<String> it = keys.iterator();// 키를 iterator로 모아옴
				while (it.hasNext()) { //게시글 번호들을 String배열에 넣어주기
					int i = 0; 
					nums[i] = (String) it.next();// 객체 배열에 키값들을 하나씩 넣어줌
					i++;
				}
				for (int i = 0; i < nums.length; i++) { //이미 있는 게시글 번호의 최대값을 구해주기
					a = boards.get(nums[i]).getNum(); //게시글 번호를 a에 저장
					int compare = Integer.parseInt(a); //a를 숫자형인 compare에 저장해주기(compare=게시글 번호)
					if (compare > max) {// max값보다 compare가 크면(게시글 번호가 더 크면)
						max = compare + 1; //그 게시글 번호보다 1 큰 값을 max에 저장해줌
					}
					num = Integer.valueOf(max).toString();// max(게시글 수보다 1큰값)를 String화시킴 
				}
			} catch (Exception x) {

			}
		}


		// 작성한 제목과 내용 스트링에 넣어주기
		String sjm = jm.getText();
		String scon = content.getText();

		// 작성된 날짜 구하기
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(cal.getTime());
		
		SBoard newpost = new SBoard(num, sjm, scon, m.getId(), date);//해당 정보를 통해 새 글 객체를 만들어주기
		new SBoardDB().saveBoard(newpost, boards);//새 글을 게시글map에 저장해 파일에 저장하기(덮어쓰기)

		DefaultTableModel model = (DefaultTableModel) table.getModel();//현재 게시글들이 써져있는 테이블을 불러옴
		model.addRow(new String[] { newpost.getNum(), newpost.getTitle(), newpost.getWriter(), newpost.getDate() });
		//방금 작성한 글 정보를 토대로 행을 추가해줌(테이블에도 새글을 추가해주는 로직)
		
		dialog.dispose();//작성 후 현재 팝업(글쓰기 팝업) 끄기

	}

}
