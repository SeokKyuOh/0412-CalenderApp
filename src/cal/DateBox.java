/*
	�� ��¥�� ǥ���ϴ� Ŀ���͸���¡ ������Ʈ
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
	MainFrame mainFrame;		//���콺 �̺�Ʈ �ÿ� ������������ Ȱ���ϰ� �Ǵµ� �̶� �̸� ���������� ����
	
	public DateBox(MainFrame mainFrame) {
		this.mainFrame=mainFrame;
		this.setLayout(new BorderLayout());		//���� ���ʿ� ���̱� ���� �������̾ƿ����� ����
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
			if(mainFrame.box[i]!=this){	//���� �ƴ϶��
				mainFrame.box[i].setBackground(Color.CYAN);
			}else{
				mainFrame.box[i].setBackground(Color.PINK);
			}
		}
	}
	
}
