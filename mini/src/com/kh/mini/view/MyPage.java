package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.controller.BookController;
import com.kh.mini.controller.MemberController;
import com.kh.mini.handler.BookCellEvent;
import com.kh.mini.model.vo.Book;
import com.kh.mini.model.vo.Member;

public class MyPage extends JPanel{//���� �뿩����� �����ִ� ������
   
   private MyPage me;
   
   public MyPage(Library l,JFrame main,Member m,MemberController mc) {
      setLayout(null);
      me=this;
      
      setBackground(new Color(215, 204, 200));
      
      JLabel name = new JLabel("< "+m.getName()+"���� �뿩��� >");
      name.setFont(new Font("���ʷҹ���",Font.BOLD,30));
      add(name);   
      name.setBounds(550,30,400,80);
      JButton change = new JButton("ȸ������ ����");
      change.setBackground(new Color(188, 170, 164));
      change.setFont(new Font("���ʷҹ���",Font.BOLD,20));
      add(change);
      change.setBounds(1148,80,200,50);
      change.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseClicked(MouseEvent e) {
            
            new MemberInfoChange(m,mc).setVisible(true);
         }
         
      });
      ImageIcon ba = new ImageIcon("back.png");
      JLabel back = new JLabel(ba);
      back.setBounds(0, 0, 100, 100);
      back.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseClicked(MouseEvent e) {
            
            main.remove(me);
            
            main.add(l);//������ �α��� �ҷ����°���
            l.revalidate();
            main.repaint();
         }
         
      });

      String header[]= {"������","�뿩��","�ݳ���"};

       //�����Ӱ� �ǳ� ������ �� ����. 
       DefaultTableModel dtable=new DefaultTableModel(null, header) {
          public boolean isCellEditable(int ro,int co) {
             return false;
          }      
       };//������ ���ϰ� ����� �͸� Ŭ����
       
       if(m.getRentBook1()!=null) { Book b=m.getRentBook1();dtable.addRow(new Object[] {b.getbName(),b.getRentDate(),b.getBackDate()}); }
       if(m.getRentBook2()!=null) { Book b=m.getRentBook2();dtable.addRow(new Object[] {b.getbName(),b.getRentDate(),b.getBackDate()}); }
       if(m.getRentBook3()!=null) { Book b=m.getRentBook3();dtable.addRow(new Object[] {b.getbName(),b.getRentDate(),b.getBackDate()}); }
       //����� ����å�� ��ü�� null�� �ƴϸ� b������ ����å�� ��ü�� �ְ� table�� ������,�뿩��¥,�ݳ���¥�� ���߰�
//       JTable table=new JTable(content,cl); //��ȣ �ȿ� (���� ����, �ڴ� ���(�÷�))      
       JTable table=new JTable(dtable);
       
              
       
       //��ũ�� ����.
       JScrollPane scr=new JScrollPane(table); //�˻� ���â ��ũ�� ����.
      //dtable���� -> tbale�� �Ű������� �־ table���� -> scr�� �Ű������� �־ scr���� 
      //scr�� ���̺��� ������ �ִ�??
       scr.setBounds(50,150,1300,570);
       
       table.setRowHeight(25);
       table.setFont(new Font("���ʷҹ���",Font.PLAIN, 20));
       table.addMouseListener(new MouseAdapter() {
          
          @Override
         public void mouseClicked(MouseEvent e) {//���̺��� ����Ŭ������ ��
             if (e.getClickCount() == 2) {//Ŭ��Ƚ���� 2���϶� 
               int row = table.getSelectedRow();//Ŭ���� ���̺��� ���� �ε���
               String bookName = (String) table.getValueAt(row, 0);//���� ������ ���� å�̸�
               Book b = new BookController().clickBook(bookName);//Ŭ���� å��ü
               JDialog myBookClick=new MyBookClick(b,table,m,bookName,mc);//Ŭ���� å�� �ݳ��ϱ� â
               myBookClick.setVisible(true);
          }
          
         }
      });
       
       

      add(scr);   
      add(back);
//      frame.pack();
//      frame.setVisible(true);
      
      
      
      
      
      
   }

}