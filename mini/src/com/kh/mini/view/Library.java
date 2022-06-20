package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.kh.mini.controller.MemberController;
import com.kh.mini.model.vo.Member;

public class Library extends JPanel {
	private JFrame main;
	private JPanel login;
	private Library me;
	private Member m;
	private MemberController mc;

	/* private HashMap<String, SBoard> boards; */
	public Library(JFrame main, JPanel login, Member m, MemberController mc/* ,HashMap<String, SBoard> boards */) {
		//사용할 이미지 파일
		ImageIcon gae = new ImageIcon("마이페이지.png");
		ImageIcon iii = new ImageIcon("열람실.png");
		ImageIcon b = new ImageIcon("back.png");
		ImageIcon ggg = new ImageIcon("게시판.jpg");
		ImageIcon hhh = new ImageIcon("책찾기.jpg");
		
		//____________________________________________________________________________________
		setLayout(null);
		setBackground(new Color(215, 204, 200));
		this.mc = mc;
		me = this;
		this.main = main;
		this.login = login;
		this.m = m;
		/* this.boards=boards; */
		JButton btn1 = new JButton("BOOK SEARCH");
		btn1.setFont(new Font("함초롬바탕", Font.BOLD, 40));
		btn1.setBounds(350, 20, 350, 350);
		btn1.setBackground(new Color(188, 170, 164));

		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.remove(me);
				BookSearch bs = new BookSearch(main, m, me, mc);
				main.add(bs);
				bs.revalidate();
				main.repaint();

			}
			@Override
			public void mouseEntered(MouseEvent e) {
			
				btn1.setIcon(hhh);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn1.setIcon(null);

			}
		});
		JButton btn2 = new JButton("MY PAGE");
		btn2.setFont(new Font("함초롬바탕", Font.BOLD, 50));
		btn2.setBounds(350, 400, 350, 350);
		btn2.setBackground(new Color(188, 170, 164));

//		EtchedBorder eborder = new EtchedBorder(EtchedBorder.RAISED);// 평면에 끌로 판듯이 외곽선 효과를 내는 것이고 양각의 효과를 준다.
//		btn2.setBorder(eborder);

		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.remove(me);
				MyPage mp = new MyPage(me, main, m, mc);
				main.add(mp);
				mp.revalidate();
				main.repaint();

				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			
				btn2.setIcon(gae);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn2.setIcon(null);

			}
		});

		
		JButton btn3 = new JButton("BOARD");
		btn3.setFont(new Font("함초롬바탕", Font.BOLD, 50));
		btn3.setBounds(750, 20, 350, 350);
		btn3.setBackground(new Color(188, 170, 164));

		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.remove(me);
				BoardMainP bmp = new BoardMainP(main, m, me/* ,boards */);
				main.add(bmp);
				bmp.revalidate();
				main.repaint();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btn3.setIcon(ggg);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn3.setIcon(null);

			}

		});

		JButton btn4 = new JButton("STUDY ROOM");
		btn4.setFont(new Font("함초롬바탕", Font.BOLD, 40));
		btn4.setBounds(750, 400, 350, 350);
		btn4.setBackground(new Color(188, 170, 164));

		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.remove(me);
				StudyRoomMain srm = new StudyRoomMain(me, main, m/* ,boards */);
				main.add(srm);
				srm.revalidate();
				main.repaint();

			}

			@Override
			public void mouseEntered(MouseEvent e) {

				btn4.setIcon(iii);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn4.setIcon(null);

			}
		});

		
		JLabel back = new JLabel(b);
		back.setBounds(0, 0, 100, 100);

		back.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				main.remove(me);

				main.add(login);// 기존의 로그인 불러오는거임
				login.revalidate();
				main.repaint();
			}

		});

		add(back);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
	}

}
