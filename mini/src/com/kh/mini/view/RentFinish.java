package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import com.kh.mini.model.vo.Book;

public class RentFinish extends JDialog {
	// 대출하기 누르면 뜨는 팝업창(완료되거나,3권초과)

	public RentFinish(BookClick bc, boolean rent, Book b) {
		// 이전팝업(책 더블클릭하면 나오는 책이름,이미지,대출버튼 팝업),대출이 성공했는지 상태, 현재 책 객체 받아옴

		setTitle("안내메시지");
		setSize(500, 200); // 팝업창 크기
		setLocationRelativeTo(null); // 팝업 위치를 프로그램 가운데로
		setLayout(null); // 널레이아웃
		JLabel msg;
		JLabel date;

		if (rent) {// 대출이 됐을경우
			msg = new JLabel("♥ 대출 완료 ♥"); // 메시지
			date = new JLabel("대여 기간 : " + b.getRentDate() + " ~ " + b.getBackDate()); // 대여기간 표시
			date.setBounds(80, 20, 400, 100); // 대여기간라벨의 크기
			date.setFont(new Font("함초롬바탕", Font.PLAIN, 20));
			add(date); // 대여기간 추가
		} else {// 책의 제한개수 초과인경우
			msg = new JLabel("대출 권수를 초과했습니다."); //메시지
		}
		msg.setBounds(123, 28, 400, 50);
		msg.setFont(new Font("함초롬바탕", Font.BOLD, 20));
		add(msg);
		
		//확인 버튼
		JButton btn = new JButton("확인");
		btn.setBounds(205, 90, 90, 45); //크기와 위치
		btn.setFont(new Font("함초롬바탕", Font.BOLD, 20)); //폰트 설정
		btn.addActionListener(new ActionListener() { //누르면 현재 팝업창 꺼짐
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				bc.setVisible(false);
			}
		});
		
		add(btn);

		msg.revalidate();

	}

}
