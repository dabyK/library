package com.kh.mini.view;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	public MainFrame() {//프레임은 하나기때문에 더이상 생성하면안됨!!!다른곳에서 필요하면 참조형변수 선언하고 매개변수로 넘겨줘야함.

		new LoginPan(this);//로그인 판넬 생성 , 프레임 자신의 주소를 로그인판넬의 생성자 매개변수를 넘겨줌
		setTitle("돈돈까스 도서관 ");//제목
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
		
		
		setSize(1400, 800);//프레임의  크기
		setResizable(false);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);//x버튼 누르면 프로그램 종료
		setVisible(true);//프레임화면을 보여줌
		gong.setVisible(true);//스폰받은 팝업창 띄움
	}
}
