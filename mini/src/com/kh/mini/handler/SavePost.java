package com.kh.mini.handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.model.dao.SBoardDB;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.SBoard;

public class SavePost extends MouseAdapter {

	private JPanel now;
	private JFrame main;
	private Member m; //���� ������ ���
	private HashMap<String, SBoard> boards; //�Խñ۵��� ��
	private JTextField jm; //�� ������ �Է��ϴ� field
	private JTextArea content; //�� ������ �Է��ϴ� area
	private JDialog dialog; //���� �˾�â(�Խñ� �ۼ��˾�)
	private JTable table; //�Խñ۵� ����� �������� ���̺�

	public SavePost(JPanel now, JFrame main, Member m, HashMap<String, SBoard> boards, JTextField jm, JTextArea content,
			JDialog dialog, JTable table) {
		super();
		this.now = now;
		this.main = main;
		this.m = m;
		this.boards = boards;
		this.jm = jm;
		this.content = content;
		this.dialog = dialog;
		this.table = table;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		//������ ������ ���� �����ϵ��� ����� �̺�Ʈ
		
		//���� ���� ���� �Խñ� ��ȣ�� ���� ū ��ȣ�� �������ִ� ����s
		String num = "1";//�� ��ȣ�� �⺻������ 1�� �����Ѵ�
		int max = 0; //������ ������ ���� �ִ밪�� ���� ���ϱ� ���� max���� �������
		String a = ""; //�Խñ� ��ȣ�� String���� ����Ǿ� �ֱ� ������, �װ��� �޾ƿ��� ���� String ������ �ϳ� ��������
		
		if (boards == null) { //�Խñ��� �ϳ��� ���� ���¶��
			num = "1"; //�Խñ۹�ȣ�� 1�� ������
		} else {
			try {
				Set keys = boards.keySet(); // boards��� Map�� Ű ��ƿ���(key�� String Ÿ���� �Խñ� ��ȣ��)
				String[] nums = new String[keys.size()];// Ű�� ������ŭ�� �迭�� ����
				Iterator<String> it = keys.iterator();// Ű�� iterator�� ��ƿ�
				while (it.hasNext()) { //�Խñ� ��ȣ���� String�迭�� �־��ֱ�
					int i = 0; 
					nums[i] = (String) it.next();// ��ü �迭�� Ű������ �ϳ��� �־���
					i++;
				}
				for (int i = 0; i < nums.length; i++) { //�̹� �ִ� �Խñ� ��ȣ�� �ִ밪�� �����ֱ�
					a = boards.get(nums[i]).getNum(); //�Խñ� ��ȣ�� a�� ����
					int compare = Integer.parseInt(a); //a�� �������� compare�� �������ֱ�(compare=�Խñ� ��ȣ)
					if (compare > max) {// max������ compare�� ũ��(�Խñ� ��ȣ�� �� ũ��)
						max = compare + 1; //�� �Խñ� ��ȣ���� 1 ū ���� max�� ��������
					}
					num = Integer.valueOf(max).toString();// max(�Խñ� ������ 1ū��)�� Stringȭ��Ŵ 
				}
			} catch (Exception x) {

			}
		}


		// �ۼ��� ����� ���� ��Ʈ���� �־��ֱ�
		String sjm = jm.getText();
		String scon = content.getText();

		// �ۼ��� ��¥ ���ϱ�
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(cal.getTime());
		
		SBoard newpost = new SBoard(num, sjm, scon, m.getId(), date);//�ش� ������ ���� �� �� ��ü�� ������ֱ�
		new SBoardDB().saveBoard(newpost, boards);//�� ���� �Խñ�map�� ������ ���Ͽ� �����ϱ�(�����)

		DefaultTableModel model = (DefaultTableModel) table.getModel();//���� �Խñ۵��� �����ִ� ���̺��� �ҷ���
		model.addRow(new String[] { newpost.getNum(), newpost.getTitle(), newpost.getWriter(), newpost.getDate() });
		//��� �ۼ��� �� ������ ���� ���� �߰�����(���̺��� ������ �߰����ִ� ����)
		
		dialog.dispose();//�ۼ� �� ���� �˾�(�۾��� �˾�) ����

	}

}
