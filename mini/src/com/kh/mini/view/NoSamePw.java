package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class NoSamePw extends JDialog{

   public NoSamePw() {//��й�ȣ�� �ٸ��� �ߴ� �˾�â
      setTitle("�ȳ��޽���");
      setBounds(750, 350, 500, 250);

      JLabel label = new JLabel("��й�ȣ�� ��й�ȣ Ȯ���� �ٸ��ϴ�.");
      JLabel label2 = new JLabel("Ȯ���� �ٽ� �Է����ּ���.");
      label.setBounds(80, 40, 500, 30);
      label2.setBounds(110, 80, 500, 30);
      label.setFont(new Font("���ʷҹ���", Font.BOLD, 20));
      label2.setFont(new Font("���ʷҹ���", Font.BOLD, 20));
      
      JButton btn = new JButton("Ȯ��");
      btn.setBounds(185, 135, 100, 50);
      btn.setFont(new Font("���ʷҹ���", Font.BOLD, 18));
      JLabel a = new JLabel("");// <- �̰� �����ϸ��
      
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