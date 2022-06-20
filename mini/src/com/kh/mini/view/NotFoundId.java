package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class NotFoundId extends JDialog{

   public NotFoundId() {
      
      setTitle("안내메시지");
      setBounds(750, 350, 500, 250);
      
      JLabel label = new JLabel("입력하신 정보가 맞지않습니다. 확인 후 다시 입력해주세요.");
      label.setBounds(40, 50, 500, 50);
      label.setFont(new Font("함초롬바탕",Font.BOLD, 15));

      
      JButton btn = new JButton("확인");
      btn.setBounds(180, 120, 100, 50);
      btn.setFont(new Font("함초롬바탕",Font.BOLD, 15));

      JLabel a = new JLabel("");// <- 이거 무시하면됨
      
      add(label);
      add(btn);
      add(a);
      
      btn.addMouseListener(
         
         new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               // TODO Auto-generated method stub
               
               setVisible(false);
               
            }
         });
   }
}