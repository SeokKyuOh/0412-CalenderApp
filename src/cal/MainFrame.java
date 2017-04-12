package cal;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener{
	JPanel p_north, p_center;
	JButton bt_prev, bt_next;
	JLabel la_title;
	DateBox[] box = new DateBox[6*7];
	Calendar cal=Calendar.getInstance();
	
	//현재 날짜를 계산하기 위한 변수
	int yy;
	int mm;
	int dd;
	
	
	public MainFrame() {
		p_north = new JPanel();
		p_center = new JPanel();
		bt_prev = new JButton("◀");
		bt_next = new JButton("▶");
		la_title = new JLabel("2017년 4월");
		la_title.setFont(new Font("돋움",Font.BOLD|Font.ITALIC, 28));
		
		p_north.add(bt_prev);
		p_north.add(la_title);
		p_north.add(bt_next);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		yy = cal.get(Calendar.YEAR);		//반환형이 field일 경우 강력한 확률로 상수를 뜻한다.
		mm = cal.get(Calendar.MONTH);	//달력은 자바에서 0부터 시작하기 때문에 계산할때는 상관없지만 출력할때에는 더하기 1을 해야한다.
		dd = cal.get(Calendar.DATE);	
				
		System.out.println(yy+"-"+mm+"-"+dd);
		printDate();
		
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		
		setSize((120*7)+70, (120*6)+120);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//날짜 출력 메서드 정의
	public void printDate(){
		//현재 날짜를 라벨에 출력
		la_title.setText(yy+"-"+(mm+1));
		
		//사각형 모두 날리기
		p_center.removeAll(); 		//달력 바뀔때 마다 박스 새로 생성되는 것 막기
		
		//각 월은 무슨 요일부터 시작할까?
		//해당 월을 1일로 맞추고, 그 요일이 무슨 요일인지 물어보면된다.
		cal.set(yy, mm, 1);
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);	//한주의 시작을 구하기
		System.out.println(mm+"의 시작요일은"+firstDay);
		
		//각 월의 마지막 날짜 알아맞추기
		//왜?? 반복문의 끝을 알기 위해
		cal.set(yy, mm+1, 0);
		int lastDay = cal.get(Calendar.DATE);
		
		int num=0;	//실제 찍힐 날짜용 변수
		for(int i=0;i<box.length;i++){
			box[i] = new DateBox(this);
			p_center.add(box[i]);
			
			/*
			if(i>=firstDay-1){		//firstDay가 0부터 시작이니까 -1
				num++;
				box[i].la.setText(Integer.toString(num));
			}*/
			
			if(i>=firstDay-1){		//firstDay가 0부터 시작이니까 -1
				num++;
			}else{
				num=0;
			}
			if(num!=0){
				if(num<=lastDay){
					box[i].la.setText(Integer.toString(num));
				}else{
					box[i].la.setText("");
				}				
			}else{
				box[i].la.setText("");
			}
		}	
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();	
		if(obj == bt_prev){ //이전 달
			mm--;
			if(mm<0){
				mm=11;		//printDate 할때 1씩 더하므로 11
				yy--;
			}
			printDate();
		}else if(obj == bt_next){ //다음 달
			mm++;
			if(mm>11){
				mm=0;
				yy++;
			}
			printDate();
		}		
	}
	
	
	
	public static void main(String[] args) {
		new MainFrame();
	}



}
