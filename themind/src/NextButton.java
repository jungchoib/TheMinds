import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NextButton extends JButton implements ActionListener{
	private MindFrame frame;
	public int lv;
	
	// min_num 보이게 하기
	public NextButton(MindFrame f, int level) {
		super("다음단계로");
		setVisible(false);
		frame = f;
		lv = level;
		
		addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		if (lv != 12) {
			lv++;
			frame.setVisible(false);
			new MindFrame(lv);
		}
//		else
			//print 승리!
	}
}

