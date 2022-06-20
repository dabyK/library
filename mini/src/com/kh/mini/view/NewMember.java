package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.mini.controller.MemberController;
import com.kh.mini.model.vo.Member;

public class NewMember extends JDialog{
	private NewMember me;
	private Member m;//�����ü �������� ����
	private MemberController mc;
	private HashMap<String,JComponent> mycom=new HashMap();//JTextField,JPasswordField�� ������� ����
	
	
	
	public NewMember(MemberController mc) {//ȸ������â
		ImageIcon newmem = new ImageIcon("newmem.png");

		
		me = this;
		this.mc = mc;
		setTitle("ȸ������");
		setBounds(790,300,400,500); 
		JLabel id = new JLabel("[ID]");//JLabel�� ��� �ؽ�Ʈ�� �����ֱ�����.
		id.setBounds(20,60,100,100);
		id.setFont(new Font("���ʷҹ���", Font.BOLD, 17));
		JLabel pw = new JLabel("[PW]");
		pw.setBounds(20,110,100,100);
		pw.setFont(new Font("���ʷҹ���", Font.BOLD, 17));
		JLabel pw2 = new JLabel("[PW Ȯ��]");
		pw2.setBounds(20,160,100,100);
		pw2.setFont(new Font("���ʷҹ���", Font.BOLD, 17));
		JLabel name = new JLabel("[�̸�]");
		name.setBounds(20,210,100,100);
		name.setFont(new Font("���ʷҹ���", Font.BOLD, 17));
		JLabel phone = new JLabel("[��ȭ��ȣ]");
		phone.setBounds(20,260,100,100);
		phone.setFont(new Font("���ʷҹ���", Font.BOLD, 17));
		JLabel address = new JLabel("[�ּ�]");
		address.setBounds(20,310,100,100);
		address.setFont(new Font("���ʷҹ���", Font.BOLD, 17));
		JLabel a = new JLabel("");//<-�̰� �ִ� ���� ���� �Ű�Ƚᵵ�� �������� ������
		
		JTextField tId = new JTextField();//JTextField,JPasswordField�� ����ڰ� �Է��� ���̴�.
		tId.setBounds(110,98,200,30); //y+40
		JPasswordField tPw = new JPasswordField();
		tPw.setBounds(110,148,200,30);
		JPasswordField tPw2 = new JPasswordField();
		tPw2.setBounds(110,198,200,30);
		JTextField tName = new JTextField();
		tName.setBounds(110,248,200,30);
		JTextField tPhone = new JTextField();
		tPhone.setBounds(110,298,200,30);
		JTextField tAddress = new JTextField();
		tAddress.setBounds(110,348,200,30);
		JLabel btn = new JLabel(newmem);//��ư
		btn.setBounds(160,360,100,100);
		ImageIcon minil=new ImageIcon("minilogo.png");
		JLabel minilogo=new JLabel(minil);
		minilogo.setBounds(70,0,300,100);
		
		
		
		
		add(minilogo);
		add(btn);//ȸ������â�� ��,�ؽ�Ʈ�ʵ�,��ư �߰�
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
		
		mycom.put("id", tId);//HashMap���� Ű���� String����(Ű�� �츮�� �˾ƺ��⽱��) ������ JTextField,JPasswordField�� �ִ´�
		mycom.put("pw", tPw);//����ڰ� �Է��� ������ ���������� HashMap�� ��Ҵٰ� mouseClicked�޼ҵ�ȿ��� �����.
		mycom.put("pw2",tPw2);
		mycom.put("name", tName);
		mycom.put("phone", tPhone);
		mycom.put("address", tAddress);
	
		
		
		
		//btn.addMouseListener(new MouseHandler2(mycom,uc));//�̰� ���콺�ڵ鷯 Ŭ������ ��������ǵ� Ȥ�ø��� �����.
		btn.addMouseListener(new MouseAdapter() {//�����ϱ� ��ưŬ�������� �̺�Ʈ �߻�
			//���콺Ŭ���̺�Ʈ�� �߻��ϸ� ����ڰ� �Է��� ������� �����ü� ����.
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = "";//Member��ü�� ���� �Ű����� ����
				String pw ="";
				String pw2 ="";
				String name = "";
				String phone = "";
				String address = "";
				//����ڰ� �Է��� ������� ��Ƶξ���  mycom HashMap�� ����Ͽ� Member��ü �Ű������� ����ش�.
				for (Object o : mycom.keySet()) {
					if(o.equals("id")) {//Ű���� id�϶�
						JTextField a =(JTextField)mycom.get(o);//Ű���� ���� value���� �̴´�(����ȯ�������)
						 id = a.getText();//getText�� String�� ��ȯ(�Է³���)
					}
					else if(o.equals("pw")) {//Ű���� pw�϶�
						JPasswordField a =(JPasswordField)mycom.get(o);
						char[] b = a.getPassword(); //JPasswordField��ü�� getPassword�޼ҵ带 ���� ���� �����;��Ѵ�.
						for(char c : b) {//getPassword�޼ҵ�� char �迭�� ��ȯ�ϱ⶧���� �迭�� ���ڵ��� �ϳ����޾Ƽ�
							 pw +=c;// String������ ����������
						}
					}
					else if(o.equals("pw2")) {//Ű���� pw2�϶�
						JPasswordField a =(JPasswordField)mycom.get(o);
						char[] b = a.getPassword();  
						for(char c : b) {
							 pw2 +=c;
						}
					}
					else if(o.equals("name")) {//Ű���� name�϶�
						JTextField a =(JTextField)mycom.get(o);
						 name = a.getText();
					}
					else if(o.equals("phone")) {//Ű���� phone�϶�
						JTextField a =(JTextField)mycom.get(o);
						 phone = a.getText();
					}
					else if(o.equals("address")) {//Ű���� address�϶�
						JTextField a =(JTextField)mycom.get(o);
						 address = a.getText();
					}
					
				}
				if(mc.existId(id)&&!(pw.equals(pw2))) {//���̵� �ߺ��̰� ��й�ȣ�� �ٸ����
					new ExistId().setVisible(true);//���̵� �ߺ�â�� ����
				}
				else if(mc.existId(id)||!(pw.equals(pw2))) {//���̵� �ߺ��̰ų� ��й�ȣ�� �ٸ����
					if(mc.existId(id)) {//���̵� �ߺ��ΰ��
						new ExistId().setVisible(true);//���̵��ߺ� �ξ�â
					}
					else if(!(pw.equals(pw2))) {//��й�ȣ�� �ٸ����
						new NoSamePw().setVisible(true);//��й�ȣ �ٸ��ٴ� �˾�â
					}
				}else {//�������ΰ�� 
					m = new Member(id,pw,pw2,name,phone,address);//�����ü ����(ȸ������)
					 mc.saveMember(m);//��Ʈ�ѷ� �޼ҵ带 ����Ͽ� ���DB�� ����(�����ü�迭�� txt���Ͽ� ����ȴٰ� �����)
					 new SaveOk(me).setVisible(true);//����Ȯ���̶�� �˾�â�� �ٿ�.
					 
				}
		
				
				
				 
					
				
			}
		});
		
		
		
		
	}
	
}