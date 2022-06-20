package com.kh.mini.handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.kh.mini.controller.MemberController;
import com.kh.mini.model.vo.Book;
import com.kh.mini.model.vo.Member;
import com.kh.mini.view.BookClick;
import com.kh.mini.view.RentFinish;

public class BookRent extends MouseAdapter {// 대출하기 눌렀을때 이벤트

	private Member m; //현재 접속한 사람
	private Book b; //책 객체
	private MemberController mc; 
	private BookClick bc; //현재 팝업(책 더블클릭하면 뜨는 책 정보, 책 대출하기 버튼이 있는 팝업)

	public BookRent(BookClick bc, Member m, Book b, MemberController mc) {
		this.bc = bc;
		this.mc = mc;
		this.m = m;
		this.b = b;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		super.mouseClicked(e);

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());// 현재 날짜 시간정보 가져옴
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 출력 포맷 지정
		String rentDate = df.format(cal.getTime()); // rentDate 변수에, 위 포맷으로 현재 날짜 저장

		cal.add(Calendar.DATE, 7);// 현재 날짜에 7일을 더한다.
		String backDate = df.format(cal.getTime()); // backDate 변수에, 위 포맷으로 7일 후 날짜(반납날짜) 저장

		b.setRentDate(rentDate);// 해당 책 객체에 대여날짜를 현재 날짜로 저장
		b.setBackDate(backDate);// 해당 책 객체에 반납날짜를 7일 후 날짜로 저장

		boolean rent = true; // 대여를 기본적으로 성공상태로 지정

		if (m != null) { // 현재 접속한 사람의 정보가 있을 때
			if (m.getRentBook1() == null) { // 접속한 사람의 대여한책1이 비어있다면
				m.setRentBook1(b); // 해당 책을 접속한 사람의 정보에 저장

			} else if (m.getRentBook2() == null) { // 접속한 사람의 대여한책2이 비어있다면
				m.setRentBook2(b); // 해당 책을 접속한 사람의 정보에 저장
			} else if (m.getRentBook3() == null) { // 접속한 사람의 대여한책3이 비어있다면
				m.setRentBook3(b); // 해당 책을 접속한 사람의 정보에 저장
			} else { // 셋 다 아니라면 rent에 false를 저장(대여 실패로 지정)
				rent = false;
			}
		} else { // 현재 접속한 사람의 정보가 없다면 rent에 false를 저장(대여 실패로 지정)
			rent = false;
		}
		mc.saveMember(m);// 대출한후에 회원객체를 파일에 저장
		new RentFinish(bc, rent, b).setVisible(true); // 대출 완료 or 대출 불가능 내용의 팝업을 호출
	}

}
