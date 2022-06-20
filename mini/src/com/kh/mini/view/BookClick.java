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
	//å��Ͽ��� å�� ����Ŭ���ϸ� ������ �˾�â(å �̸�, �̹���, ���� ��ư�� ����)
	
	public BookClick(Member m,Book b,MemberController mc) {
		//���̾�α� ����
		setTitle("���� ����");
		setSize(500,500);
		setLocationRelativeTo(null); //�˾�â�� ��ġ�� ���α׷��� ����� ����
		
		setLayout(null); //�� ���̾ƿ�
		
		//Ŭ���� å�� �̸�
		JLabel bookName=new JLabel(b.getbName());//Ŭ����å �̸�ǥ��
		bookName.setBounds(180, 10, 350, 60);
		bookName.setFont(new Font("���ʷҹ���",Font.BOLD, 20));
		
		//Ŭ���� å�� �̹���
		JLabel bookImage = new JLabel(new ImageIcon(b.getBookNum())); //book��ü�� bookName������ �̹��� ������ �̸�!
		bookImage.setSize(300, 350);
		bookImage.setLocation(100,30);

		//�����ϱ� ��ư
		JButton btn=new JButton("�����ϱ�");
		btn.setSize(100, 50);
		btn.setLocation(200,380);
		btn.setFont(new Font("���ʷҹ���",Font.PLAIN, 15));
		
		//��ư ������ �����ϴ� �������� �̵�
		btn.addMouseListener(new BookRent(this,m,b,mc));
		
		add(bookName);
		add(bookImage);
		add(btn);
		
	}

}
