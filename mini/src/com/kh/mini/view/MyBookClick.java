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

public class MyBookClick extends JDialog{//������ ����å�� �ݳ��ϴ� �˾�â
	Member m;
	String bookName;
	MemberController mc;
	MyBookClick me;
	public MyBookClick(Book b,JTable table,Member m,String bookName,MemberController mc) {
		me = this;
		this.bookName = bookName;
		this.m = m;
		this.mc = mc;
		setTitle("�ݳ�");
		setSize(500,500);
		setLocationRelativeTo(null);
		
		setLayout(null);
		JButton btn=new JButton("�ݳ��ϱ�");
		btn.setSize(100, 50);
		btn.setLocation(200,380);
		btn.setFont(new Font("���ʷҹ���",Font.PLAIN, 15));
		
		btn.addMouseListener(new MouseAdapter() {//�ݳ��ϱ� ��������

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(m.getRentBook1()!=null&&bookName.equals(m.getRentBook1().getbName())){//����å1�� null�� �ƴϰ� Ŭ���� å�̸��� ����å�� �̸��� ������
					m.setRentBook1(null);//����å�� null�� �ٲ�
				}
				else if(m.getRentBook2()!=null&&bookName.equals(m.getRentBook2().getbName())){
					m.setRentBook2(null);
				}
				else if(m.getRentBook3()!=null&&bookName.equals(m.getRentBook3().getbName())){
					m.setRentBook3(null);
				}
				
				mc.saveMember(m);//null�� �ٲ� �����ü�� ����
				int row =table.getSelectedRow();//Ŭ���߾��� ���� �ε�����ȣ
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				model.removeRow(row);//Ŭ���߾��� ���� ����
				setVisible(false);
				
			
			}
			
		});
		JLabel bookImage = new JLabel(new ImageIcon(b.getBookNum()));//å��ü�� �ش��ϴ� å�̹��� �ҷ���
		bookImage.setSize(300, 350);
	
		bookImage.setLocation(100,30);
		add(bookImage);
		add(btn);
	}

}
