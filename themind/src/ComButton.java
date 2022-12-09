import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ComButton extends JButton implements ActionListener{
	private MindFrame frame;
	// min_num 보이게 하기
	public ComButton(MindFrame f) {
		frame = f;
		addActionListener(this);
	}

	// 버튼 누르면
	public void actionPerformed(ActionEvent e) {
		// c가 더 작으면 
		if (frame.pIsBig()) {
			frame.updateNum(frame.c_hand);
			if (frame.c_hand.card_count == 0 && frame.p_hand.card_count == 0)
				frame.levelUp();
		}
		// p가 더 작으면 (오답이면)
		else {
			if (frame.life > 1) {
				frame.lossLife();
				frame.failAction();
			}
			else
				;
				// print(gameover) 구현하기 !!!!!!!!!!!!!!
		}
	}
}
