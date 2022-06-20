package com.kh.mini.view;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	public MainFrame() {//�������� �ϳ��⶧���� ���̻� �����ϸ�ȵ�!!!�ٸ������� �ʿ��ϸ� ���������� �����ϰ� �Ű������� �Ѱ������.

		new LoginPan(this);//�α��� �ǳ� ���� , ������ �ڽ��� �ּҸ� �α����ǳ��� ������ �Ű������� �Ѱ���
		setTitle("����� ������ ");//����
		JFrame f= new JFrame();

		try {
			setIconImage(ImageIO.read(new File("booklogo.png")));
		}catch(IOException e) {
			e.printStackTrace();
		}

		
		JDialog gong = new JDialog();
		
		gong.setBounds(750,350,480,500);
		
		ImageIcon icon = new ImageIcon("libraryImage.png");
		JLabel img = new JLabel(icon);
		img.setSize(500, 500);

		gong.add(img);
		
		
		setSize(1400, 800);//��������  ũ��
		setResizable(false);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);//x��ư ������ ���α׷� ����
		setVisible(true);//������ȭ���� ������
		gong.setVisible(true);//�������� �˾�â ���
	}
}
