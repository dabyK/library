package com.kh.mini.handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.mini.controller.MemberController;
import com.kh.mini.model.vo.Member;

public class MouseHandler2 extends MouseAdapter {
	MemberController uc;
	Member u;
	HashMap<String, JComponent> mycom = new HashMap<String, JComponent>();

	public MouseHandler2(HashMap<String, JComponent> mycom, MemberController uc) {
		this.uc = uc;
		this.mycom = mycom;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String pw = "";
		String pw2 = "";
		String id = "";
		String name = "";
		String phone = "";
		String address = "";

		for (Object o : mycom.keySet()) {
			if (o.equals("id")) {
				JTextField a = (JTextField) mycom.get(o);
				id = a.getText();
			} else if (o.equals("pw")) {
				JPasswordField a = (JPasswordField) mycom.get(o);
				char[] b = a.getPassword();
				for (char c : b) {
					pw += c;
				}
			} else if (o.equals("pw2")) {
				JPasswordField a = (JPasswordField) mycom.get(o);
				char[] b = a.getPassword();
				for (char c : b) {
					pw2 += c;
				}
			} else if (o.equals("name")) {
				JTextField a = (JTextField) mycom.get(o);
				name = a.getText();
			} else if (o.equals("phone")) {
				JTextField a = (JTextField) mycom.get(o);
				phone = a.getText();
			} else if (o.equals("address")) {
				JTextField a = (JTextField) mycom.get(o);
				address = a.getText();
			}

		}

//		u = new User(id,pw,pw2,name,phone,address);
//		uc.savaUser(u);

	}
}
