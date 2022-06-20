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
	private JFrame main;// �������� �ּҸ� �ޱ����� ������ ��������
	private MemberController mc = new MemberController();// �����Ʈ�ѷ� ���� ,�����Ʈ�ѷ��� ������Ʈ ������ ������ �ϳ�������!!!
	private LoginPan me;
	/*private HashMap<String, SBoard> boards;*/
	
	public LoginPan(JFrame main) {// �α���ȭ��
		setBackground(new Color(215, 204, 200));
		me = this;
		mc.startDB();
		this.main = main;// �Ű������� �Ѿ�� �������ּҸ� ������ ������ ����

		setLayout(null);// null���̾ƿ��� ������Ʈ�� ��ġ�� ũ�⸦ ������� ������ �� ����.�׷��� null���̾ƿ����� ������.

		
		ImageIcon icon = new ImageIcon("oo.PNG"); // �̹��� ������ ��ü ����
		JLabel img = new JLabel(icon);
		img.setSize(200, 200);
		img.setLocation(250, 197);

		JLabel loglogo = new JLabel("�α���");// JLabel�� ����ڿ��� �������� �ؽ�Ʈ����
		loglogo.setFont(new Font("���ʷҹ���", Font.BOLD, 25));
		loglogo.setSize(200, 200);
		loglogo.setLocation(500, 130);
		JLabel id = new JLabel("ID : ");
		id.setFont(new Font("SansSerif", Font.BOLD, 20));
		id.setSize(300, 300);// JLabel�� ũ�� ����
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
					
				
					String id = idinput.getText();//�ؽ�Ʈ�ʵ忡 �Էµ� ���� ������ ����
					String pw = "";
					char[] a = pwinput.getPassword();//�н������ʵ忡 �Էµ� ���� ������ ����
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
		
		

		JButton login = new JButton("Log In");// �α��� ��ư
		login.setBackground(new Color(109, 76, 65));
		login.setForeground(Color.WHITE);
		login.setFont(new Font("���ʷҹ���", Font.BOLD, 23));
		login.setSize(450, 40);
		login.setLocation(500, 350);
		
		ImageIcon img1 = new ImageIcon("log1.png");
		JLabel im1=new JLabel(img1);
		im1.setBounds(460, 410,500,300);

		JLabel newUser = new JLabel("[  ȸ������  ]");// ȸ������
		newUser.setFont(new Font("���ʷҹ���", Font.BOLD, 15));
		newUser.setSize(100, 50);
		newUser.setLocation(690, 400);

		newUser.addMouseListener(new MouseAdapter() {// ȸ������ ��ư Ŭ�������� �̺�Ʈ �߻�,�͸�Ŭ���� ���
			@Override
			public void mouseClicked(MouseEvent e) {

				// add(new NewMember());//<-- �α����ǳڿ� ȸ������â�� ���̷��� �غ����� ������
				// �Ƹ��� ȸ������â�� �˾�â�̱⶧���� �ǳڿ� �ٴ°� �ƴϰ� ���� �����ȴٰ� �����ҵ� ->setVisible���
				new NewMember(mc).setVisible(true);// ȸ������â ��ü�� ����� ������
			}
		});
	

		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String id = idinput.getText();//�ؽ�Ʈ�ʵ忡 �Էµ� ���� ������ ����
				String pw = "";
				char[] a = pwinput.getPassword();//�н������ʵ忡 �Էµ� ���� ������ ����
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

		// �α����ǳڿ� ������ ������ ��,��ư �߰�
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
		main.add(this);// �Ű������� �޾ƿ� �����ӿ� �α��� �ǳ��� ����
		// main�� �޾ƿ� �������� �ּ��̰� this�� �α����ǳ� �ڱ��ڽ���

	}
}
