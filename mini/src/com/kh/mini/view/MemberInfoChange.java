package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.mini.controller.MemberController;
import com.kh.mini.model.vo.Member;

public class MemberInfoChange extends JDialog {
	private HashMap<String, JComponent> mycom = new HashMap();// JTextField,JPasswordField를 담기위해 생성
	
	private MemberInfoChange me;

	public MemberInfoChange(Member m, MemberController mc) {
		me = this;
		setBounds(550,250,400,500);
		setTitle("회원정보 수정");
		ImageIcon newmem = new ImageIcon("newmem.png");
		JLabel id = new JLabel("[ID]");//JLabel은 모두 텍스트로 보여주기위함.
		id.setBounds(20,60,100,100);
		id.setFont(new Font("함초롬바탕", Font.BOLD, 17));
		JLabel pw = new JLabel("[PW]");
		pw.setBounds(20,110,100,100);
		pw.setFont(new Font("함초롬바탕", Font.BOLD, 17));
		JLabel pw2 = new JLabel("[PW 확인]");
		pw2.setBounds(20,160,100,100);
		pw2.setFont(new Font("함초롬바탕", Font.BOLD, 17));
		JLabel name = new JLabel("[이름]");
		name.setBounds(20,210,100,100);
		name.setFont(new Font("함초롬바탕", Font.BOLD, 17));
		JLabel phone = new JLabel("[전화번호]");
		phone.setBounds(20,260,100,100);
		phone.setFont(new Font("함초롬바탕", Font.BOLD, 17));
		JLabel address = new JLabel("[주소]");
		address.setBounds(20,310,100,100);
		address.setFont(new Font("함초롬바탕", Font.BOLD, 17));
		JLabel a = new JLabel("");//<-이거 있는 이유 굳이 신경안써도됨 지우지는 마세요
		
		JTextField tId = new JTextField(m.getId());//JTextField,JPasswordField는 사용자가 입력할 곳이다.
		tId.setBounds(110,98,200,30); //y+40
		tId.setEnabled(false);
		JPasswordField tPw = new JPasswordField();
		tPw.setBounds(110,148,200,30);
		JPasswordField tPw2 = new JPasswordField();
		tPw2.setBounds(110,198,200,30);
		JTextField tName = new JTextField(m.getName());
		tName.setBounds(110,248,200,30);
		tName.setEnabled(false);
		JTextField tPhone = new JTextField();
		tPhone.setBounds(110,298,200,30);
		JTextField tAddress = new JTextField();
		tAddress.setBounds(110,348,200,30);
		JLabel btn = new JLabel(newmem);//버튼
		btn.setBounds(160,360,100,100);
		ImageIcon minil=new ImageIcon("minilogo.png");
		JLabel minilogo=new JLabel(minil);
		minilogo.setBounds(70,0,300,100);
		add(minilogo);
		add(btn);// 회원가입창에 라벨,텍스트필드,버튼 추가
		add(tPw);
		add(tPw2);
		add(tName);
		add(tPhone);
		add(tAddress);
		add(tId);
		add(id);
		add(pw);
		add(pw2);
		add(name);
		add(phone);
		add(address);
		add(a);
		mycom.put("id", tId);// HashMap으로 키에는 String으로(키는 우리가 알아보기쉽게) 값에는 JTextField,JPasswordField를 넣는다
		mycom.put("pw", tPw);// 사용자가 입력한 내용을 가져가위해 HashMap에 담았다가 mouseClicked메소드안에서 사용함.
		mycom.put("pw2", tPw2);
		mycom.put("name", tName);
		mycom.put("phone", tPhone);
		mycom.put("address", tAddress);
		btn.addMouseListener(new MouseAdapter() {// 저장하기 버튼클릭했을때 이벤트 발생
			// 마우스클릭이벤트가 발생하면 사용자가 입력한 내용들을 가져올수 있음.
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = "";// Member객체에 넣을 매개변수 선언
				String pw = "";
				String pw2 = "";
				String name = "";
				String phone = "";
				String address = "";

				// 사용자가 입력한 내용들을 담아두었던 mycom HashMap을 사용하여 Member객체 매개변수로 담아준다.
				for (Object o : mycom.keySet()) {
					if (o.equals("id")) {// 키값이 id일때
						JTextField a = (JTextField) mycom.get(o);// 키값을 통해 value값을 뽑는다(형변환해줘야함)
						id = a.getText();// getText는 String을 반환(입력내용)
					} else if (o.equals("pw")) {// 키값이 pw일때
						JPasswordField a = (JPasswordField) mycom.get(o);
						char[] b = a.getPassword(); // JPasswordField객체는 getPassword메소드를 통해 값을 가져와야한다.
						for (char c : b) {// getPassword메소드는 char 배열로 반환하기때문에 배열의 문자들을 하나씩받아서
							pw += c;// String변수에 누적시켜줌
						}
					} else if (o.equals("pw2")) {// 키값이 pw2일때
						JPasswordField a = (JPasswordField) mycom.get(o);
						char[] b = a.getPassword();
						for (char c : b) {
							pw2 += c;
						}
					} else if (o.equals("name")) {// 키값이 name일때
						JTextField a = (JTextField) mycom.get(o);
						name = a.getText();
					} else if (o.equals("phone")) {// 키값이 phone일때
						JTextField a = (JTextField) mycom.get(o);
						phone = a.getText();
					} else if (o.equals("address")) {// 키값이 address일때
						JTextField a = (JTextField) mycom.get(o);
						address = a.getText();
					}

				}
				if(pw.equals(pw2)) {//비밀번호와 비밀번호 확인이 같다면
					m.setPw(pw);
					m.setPw2(pw2);
					m.setPhone(phone);
					m.setAddress(address);
					mc.saveMember(m);//사용자가 수정할려고한 데이터로 멤버객체 저장
					new SaveOk(me).setVisible(true);//저장확인이라는 팝업창을 뛰움.
				}
				else {//비밀번호와 비밀번호 확인이 다르다면
					new NoSamePw().setVisible(true);//비밀번호 다르다는 팝업창
				}
				

			}
		});
	}
}
