package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class NoReserve extends JDialog{

   public NoReserve() {
	   //������ �¼��� ������ ��, �̹� �ٸ� �ڸ��� �����ߴٸ� �ߴ� �˾�â
	   
      setTitle("�ȳ��޽���");
      setBounds(700, 400, 500, 250);
      
      //�޽���
      JLabel label = new JLabel("�̹� �����Ͻ� �ڸ��� �ֽ��ϴ�.");
      label.setBounds(105, 40, 300, 20);
      label.setFont(new Font("���ʷҹ���",Font.BOLD, 20));
      
      //Ȯ�� ��ư
      JButton btn = new JButton("Ȯ��");
      btn.setFont(new Font("���ʷҹ���",Font.BOLD, 20));
      btn.setBounds(190, 100, 100, 50);
      
      //Ȯ�� ��ư ������ ���� �˾��� ������
      btn.addMouseListener(       
         new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               // TODO Auto-generated method stub  
               setVisible(false);              
            }
         });
      
      JLabel a = new JLabel("");// <- �̰� �����ϸ��
      
      add(label);
      add(btn);
      add(a);
   }
}