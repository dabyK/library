package com.kh.mini.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.mini.controller.MemberController;
import com.kh.mini.handler.BookRent;
import com.kh.mini.model.vo.Book;
import com.kh.mini.model.vo.Member;

public class BookClick extends JDialog {
	//책목록에서 책을 더블클릭하면 나오는 팝업창(책 이름, 이미지, 대출 버튼이 나옴)
	
	public BookClick(Member m,Book b,MemberController mc) {
		//다이얼로그 생성
		setTitle("도서 대출");
		setSize(500,500);
		setLocationRelativeTo(null); //팝업창의 위치를 프로그램의 가운데로 지정
		
		setLayout(null); //널 레이아웃
		
		//클릭한 책의 이름
		JLabel bookName=new JLabel(b.getbName());//클릭한책 이름표시
		bookName.setBounds(180, 10, 350, 60);
		bookName.setFont(new Font("함초롬바탕",Font.BOLD, 20));
		
		//클릭한 책의 이미지
		JLabel bookImage = new JLabel(new ImageIcon(b.getBookNum())); //book객체의 bookName변수가 이미지 파일의 이름!
		bookImage.setSize(300, 350);
		bookImage.setLocation(100,30);

		//대출하기 버튼
		JButton btn=new JButton("대출하기");
		btn.setSize(100, 50);
		btn.setLocation(200,380);
		btn.setFont(new Font("함초롬바탕",Font.PLAIN, 15));
		
		//버튼 누르면 대출하는 로직으로 이동
		btn.addMouseListener(new BookRent(this,m,b,mc));
		
		add(bookName);
		add(bookImage);
		add(btn);
		
	}

}
