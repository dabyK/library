package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class NoReserve extends JDialog{

   public NoReserve() {
	   //열람실 좌석을 예약할 때, 이미 다른 자리를 예약했다면 뜨는 팝업창
	   
      setTitle("안내메시지");
      setBounds(700, 400, 500, 250);
      
      //메시지
      JLabel label = new JLabel("이미 예약하신 자리가 있습니다.");
      label.setBounds(105, 40, 300, 20);
      label.setFont(new Font("함초롬바탕",Font.BOLD, 20));
      
      //확인 버튼
      JButton btn = new JButton("확인");
      btn.setFont(new Font("함초롬바탕",Font.BOLD, 20));
      btn.setBounds(190, 100, 100, 50);
      
      //확인 버튼 누르면 현재 팝업이 꺼지게
      btn.addMouseListener(       
         new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               // TODO Auto-generated method stub  
               setVisible(false);              
            }
         });
      
      JLabel a = new JLabel("");// <- 이거 무시하면됨
      
      add(label);
      add(btn);
      add(a);
   }
}