package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.mini.controller.MemberController;
import com.kh.mini.model.dao.SBoardDB;
import com.kh.mini.model.vo.SBoard;

public class LoginPan extends JPanel {
	private JFrame main;// 프레임의 주소를 받기위한 참조형 변수선언
	private MemberController mc = new MemberController();// 멤버컨트롤러 생성 ,멤버컨트롤러는 프로젝트 내에서 무조건 하나여야함!!!
	private LoginPan me;
	/*private HashMap<String, SBoard> boards;*/
	
	public LoginPan(JFrame main) {// 로그인화면
		setBackground(new Color(215, 204, 200));
		me = this;
		mc.startDB();
		this.main = main;// 매개변수로 넘어온 프레임주소를 참조형 변수에 대입

		setLayout(null);// null레이아웃은 컴포넌트의 위치와 크기를 마음대로 조정할 수 있음.그래서 null레이아웃으로 지정함.

		
		ImageIcon icon = new ImageIcon("oo.PNG"); // 이미지 아이콘 객체 생성
		JLabel img = new JLabel(icon);
		img.setSize(200, 200);
		img.setLocation(250, 197);

		JLabel loglogo = new JLabel("로그인");// JLabel은 사용자에게 보여지는 텍스트역할
		loglogo.setFont(new Font("함초롬바탕", Font.BOLD, 25));
		loglogo.setSize(200, 200);
		loglogo.setLocation(500, 130);
		JLabel id = new JLabel("ID : ");
		id.setFont(new Font("SansSerif", Font.BOLD, 20));
		id.setSize(300, 300);// JLabel의 크기 지정
		id.setLocation(444, 120);
		JLabel pw = new JLabel("PW : ");
		pw.setFont(new Font("SansSerif", Font.BOLD, 20));
		pw.setSize(300, 300);
		pw.setLocation(430, 170);

		JTextField idinput = new JTextField(10);
		idinput.setFont(new Font("SansSerif", Font.PLAIN, 17));
		idinput.setSize(450, 40);
		idinput.setLocation(500, 250);
		
		JPasswordField pwinput = new JPasswordField(10);
		pwinput.setFont(new Font("SansSerif", Font.PLAIN, 17));
		pwinput.setSize(450, 40);
		pwinput.setLocation(500, 300);
		pwinput.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
				int keyCord = e.getKeyCode();
				if(keyCord == 10) {
					
				
					String id = idinput.getText();//텍스트필드에 입력된 값을 변수에 담음
					String pw = "";
					char[] a = pwinput.getPassword();//패스워드필드에 입력된 값을 변수에 담음
					for (char b : a) {
						pw += b;
					}
					int result = mc.checkPw(id, pw);
					if (result == -1 || result == 0) {
						new NotFoundId().setVisible(true);
					} else {
						main.remove(me);
						Library l = new Library(main, me, mc.loadMember(id), mc/*, boards*/);
						main.add(l);
						l.revalidate();
						main.repaint();
					}
				}
				
//				String s = e.getKeyChar() + " " +e.getKeyCode() + " " +"ALT " + e.isAltDown() + " " 
//				+"SHIFT " + e.isShiftDown() + " " +
//						"CTRL " + e.isControlDown() + " " ;
//			System.out.println(s);
				
				
			}
		});
		
		

		JButton login = new JButton("Log In");// 로그인 버튼
		login.setBackground(new Color(109, 76, 65));
		login.setForeground(Color.WHITE);
		login.setFont(new Font("함초롬바탕", Font.BOLD, 23));
		login.setSize(450, 40);
		login.setLocation(500, 350);
		
		ImageIcon img1 = new ImageIcon("log1.png");
		JLabel im1=new JLabel(img1);
		im1.setBounds(460, 410,500,300);

		JLabel newUser = new JLabel("[  회원가입  ]");// 회원가입
		newUser.setFont(new Font("함초롬바탕", Font.BOLD, 15));
		newUser.setSize(100, 50);
		newUser.setLocation(690, 400);

		newUser.addMouseListener(new MouseAdapter() {// 회원가입 버튼 클릭했을때 이벤트 발생,익명클래스 사용
			@Override
			public void mouseClicked(MouseEvent e) {

				// add(new NewMember());//<-- 로그인판넬에 회원가입창을 붙이려고 해봤지만 에러뜸
				// 아마도 회원가입창은 팝업창이기때문에 판넬에 붙는게 아니고 따로 생성된다고 봐야할듯 ->setVisible사용
				new NewMember(mc).setVisible(true);// 회원가입창 객체를 만들고 보여줌
			}
		});
	

		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String id = idinput.getText();//텍스트필드에 입력된 값을 변수에 담음
				String pw = "";
				char[] a = pwinput.getPassword();//패스워드필드에 입력된 값을 변수에 담음
				for (char b : a) {
					pw += b;
				}
				int result = mc.checkPw(id, pw);
				if (result == -1 || result == 0) {
					new NotFoundId().setVisible(true);
				} else {
					main.remove(me);
					Library l = new Library(main, me, mc.loadMember(id), mc/*, boards*/);
					main.add(l);
					l.revalidate();
					main.repaint();

				}

			}
		});
		ImageIcon img2 = new ImageIcon("logo.png");
		JLabel im2=new JLabel(img2);
		im2.setBounds(440, 0,600,200);

		// 로그인판넬에 위에서 정의한 라벨,버튼 추가
		add(im2);
		add(im1);
		add(img);
		add(loglogo);
		add(id);
		add(pw);
		add(login);
		add(newUser);
		add(idinput);
		add(pwinput);
		main.add(this);// 매개변수로 받아온 프레임에 로그인 판넬을 부착
		// main은 받아온 프레임의 주소이고 this는 로그인판넬 자기자신임

	}
}
