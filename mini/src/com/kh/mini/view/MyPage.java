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

public class MyPage extends JPanel{//나의 대여목록을 보여주는 페이지
   
   private MyPage me;
   
   public MyPage(Library l,JFrame main,Member m,MemberController mc) {
      setLayout(null);
      me=this;
      
      setBackground(new Color(215, 204, 200));
      
      JLabel name = new JLabel("< "+m.getName()+"님의 대여목록 >");
      name.setFont(new Font("함초롬바탕",Font.BOLD,30));
      add(name);   
      name.setBounds(550,30,400,80);
      JButton change = new JButton("회원정보 수정");
      change.setBackground(new Color(188, 170, 164));
      change.setFont(new Font("함초롬바탕",Font.BOLD,20));
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
            
            main.add(l);//기존의 로그인 불러오는거임
            l.revalidate();
            main.repaint();
         }
         
      });

      String header[]= {"도서명","대여일","반납일"};

       //프레임과 판넬 사이의 모델 생성. 
       DefaultTableModel dtable=new DefaultTableModel(null, header) {
          public boolean isCellEditable(int ro,int co) {
             return false;
          }      
       };//수정을 못하게 만드는 익명 클래스
       
       if(m.getRentBook1()!=null) { Book b=m.getRentBook1();dtable.addRow(new Object[] {b.getbName(),b.getRentDate(),b.getBackDate()}); }
       if(m.getRentBook2()!=null) { Book b=m.getRentBook2();dtable.addRow(new Object[] {b.getbName(),b.getRentDate(),b.getBackDate()}); }
       if(m.getRentBook3()!=null) { Book b=m.getRentBook3();dtable.addRow(new Object[] {b.getbName(),b.getRentDate(),b.getBackDate()}); }
       //사람이 빌린책의 객체가 null이 아니면 b변수에 빌린책의 객체를 넣고 table에 도서명,대여날짜,반납날짜를 행추가
//       JTable table=new JTable(content,cl); //괄호 안에 (앞은 내용, 뒤는 헤더(컬럼))      
       JTable table=new JTable(dtable);
       
              
       
       //스크롤 생성.
       JScrollPane scr=new JScrollPane(table); //검색 결과창 스크롤 생성.
      //dtable생성 -> tbale의 매개변수로 넣어서 table생성 -> scr의 매개변수로 넣어서 scr생성 
      //scr이 테이블을 가지고 있다??
       scr.setBounds(50,150,1300,570);
       
       table.setRowHeight(25);
       table.setFont(new Font("함초롬바탕",Font.PLAIN, 20));
       table.addMouseListener(new MouseAdapter() {
          
          @Override
         public void mouseClicked(MouseEvent e) {//테이블을 더블클릭했을 때
             if (e.getClickCount() == 2) {//클릭횟수가 2번일때 
               int row = table.getSelectedRow();//클릭한 테이블의 행의 인덱스
               String bookName = (String) table.getValueAt(row, 0);//내가 선택한 행의 책이름
               Book b = new BookController().clickBook(bookName);//클릭한 책객체
               JDialog myBookClick=new MyBookClick(b,table,m,bookName,mc);//클릭한 책의 반납하기 창
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