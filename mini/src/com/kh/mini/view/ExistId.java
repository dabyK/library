package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ExistId extends JDialog{

   public ExistId() {
      setTitle("�ȳ��޽���");
      setBounds(750, 350, 500, 250);

      JLabel label = new JLabel("�̹� �����ϴ� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
      label.setBounds(60, 50, 500, 50);
      label.setFont(new Font("���ʷҹ���",Font.BOLD, 15));
      
      JButton btn = new JButton("Ȯ��");
      btn.setBounds(190, 120, 100, 50);
      btn.setFont(new Font("���ʷҹ���",Font.BOLD, 15));

      JLabel a = new JLabel("");// <- �̰� �����ϸ��
      
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