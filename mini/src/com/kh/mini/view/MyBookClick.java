package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.controller.MemberController;
import com.kh.mini.model.vo.Book;
import com.kh.mini.model.vo.Member;

public class MyBookClick extends JDialog{//유저의 빌린책을 반납하는 팝업창
	Member m;
	String bookName;
	MemberController mc;
	MyBookClick me;
	public MyBookClick(Book b,JTable table,Member m,String bookName,MemberController mc) {
		me = this;
		this.bookName = bookName;
		this.m = m;
		this.mc = mc;
		setTitle("반납");
		setSize(500,500);
		setLocationRelativeTo(null);
		
		setLayout(null);
		JButton btn=new JButton("반납하기");
		btn.setSize(100, 50);
		btn.setLocation(200,380);
		btn.setFont(new Font("함초롬바탕",Font.PLAIN, 15));
		
		btn.addMouseListener(new MouseAdapter() {//반납하기 눌렀을때

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(m.getRentBook1()!=null&&bookName.equals(m.getRentBook1().getbName())){//빌린책1이 null이 아니고 클릭한 책이름과 빌린책의 이름이 같으면
					m.setRentBook1(null);//빌린책을 null로 바꿈
				}
				else if(m.getRentBook2()!=null&&bookName.equals(m.getRentBook2().getbName())){
					m.setRentBook2(null);
				}
				else if(m.getRentBook3()!=null&&bookName.equals(m.getRentBook3().getbName())){
					m.setRentBook3(null);
				}
				
				mc.saveMember(m);//null로 바꾼 멤버객체를 저장
				int row =table.getSelectedRow();//클릭했었던 행의 인덱스번호
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				model.removeRow(row);//클릭했었던 행을 지움
				setVisible(false);
				
			
			}
			
		});
		JLabel bookImage = new JLabel(new ImageIcon(b.getBookNum()));//책객체에 해당하는 책이미지 불러옴
		bookImage.setSize(300, 350);
	
		bookImage.setLocation(100,30);
		add(bookImage);
		add(btn);
	}

}
