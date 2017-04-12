/*
	각 날짜를 표현하는 커스터마이징 컴포넌트
*/
package cal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DateBox extends JPanel{
	JLabel la;
	MainFrame mainFrame;		//마우스 이벤트 시에 메인프레임을 활용하게 되는데 이때 미리 얻어오기위해 선언
	
	public DateBox(MainFrame mainFrame) {
		this.mainFrame=mainFrame;
		this.setLayout(new BorderLayout());		//라벨을 북쪽에 붙이기 위해 보더레이아웃으로 선언
		la = new JLabel();
		
		add(la, BorderLayout.NORTH);
		setPreferredSize(new Dimension(120, 120));
		setBackground(Color.CYAN);
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				selectBox();
			}
		});
		
	}
	
	public void selectBox(){
		int yy = mainFrame.yy;
		int mm = mainFrame.mm;
		int dd = Integer.parseInt(la.getText());
		JOptionPane.showMessageDialog(mainFrame, yy+"-"+mm+"-"+dd);
		
		for(int i=0;i<mainFrame.box.length;i++){
			if(mainFrame.box[i]!=this){	//내가 아니라면
				mainFrame.box[i].setBackground(Color.CYAN);
			}else{
				mainFrame.box[i].setBackground(Color.PINK);
			}
		}
	}
	
}
