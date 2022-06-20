package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class NoSamePw extends JDialog{

   public NoSamePw() {//비밀번호가 다를때 뜨는 팝업창
      setTitle("안내메시지");
      setBounds(750, 350, 500, 250);

      JLabel label = new JLabel("비밀번호와 비밀번호 확인이 다릅니다.");
      JLabel label2 = new JLabel("확인후 다시 입력해주세요.");
      label.setBounds(80, 40, 500, 30);
      label2.setBounds(110, 80, 500, 30);
      label.setFont(new Font("함초롬바탕", Font.BOLD, 20));
      label2.setFont(new Font("함초롬바탕", Font.BOLD, 20));
      
      JButton btn = new JButton("확인");
      btn.setBounds(185, 135, 100, 50);
      btn.setFont(new Font("함초롬바탕", Font.BOLD, 18));
      JLabel a = new JLabel("");// <- 이거 무시하면됨
      
      add(label);
      add(label2);
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