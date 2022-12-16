import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ComButton extends JButton implements ActionListener{
	private MindFrame frame;
	
	private NextButton next;
	// min_num 보이게 하기
	public ComButton(MindFrame f) {
		super("컴퓨터");
		frame = f;
		
		addActionListener(this);
	}

	// 버튼 누르면
	public void actionPerformed(ActionEvent e) {
		// c가 더 작으면
		if ( frame.p_hand.showCards().length + frame.c_hand.showCards().length == 2) {
			frame.s_button.setVisible(false);
		}
		if (frame.p_hand.showCards().length == 0 || frame.c_hand.showCards().length == 0) {
			frame.s_button.setVisible(false);
		}
		if ((frame.p_hand.card_count-1 >= 0) && (frame.rrans[frame.ansnum]==frame.c_hand.showCards()[frame.c_hand.card_count-1])) {
			frame.c_hand.showCards();
			frame.updateNum(frame.c_hand);
			frame.ansnum++;
			if ( frame.p_hand.showCards().length + frame.c_hand.showCards().length == 2) {
				frame.s_button.setVisible(false);
					
			}
			if (frame.p_hand.showCards().length == 0 || frame.c_hand.showCards().length == 0) {
				frame.s_button.setVisible(false);
			}
			
			if(frame.c_hand.showCards().length==0) {
				setVisible(false);
			}
		    if (frame.c_hand.card_count == 0 && frame.p_hand.card_count == 0) {
		    	frame.n_button.setVisible(true);
				frame.s_button.setVisible(false);
				frame.c_button.setVisible(false);			
			}
					
					
		}
			// p가 더 작으면 (오답이면)
		else if((frame.p_hand.card_count-1 >= 0) && (frame.rrans[frame.ansnum]!=frame.c_hand.showCards()[frame.c_hand.card_count-1])){
			if (frame.life > 0) {
				frame.lossLife();
				while ((frame.p_hand.showCards().length-1 >= 0) && (frame.rrans[frame.ansnum]==frame.p_hand.showCards()[frame.p_hand.showCards().length-1])) {
					frame.p_hand.showCards();
					frame.updateNum(frame.p_hand);
					frame.ansnum++;
				}
				frame.c_hand.showCards();
				frame.updateNum(frame.c_hand);
				frame.ansnum++;
				if ( frame.p_hand.showCards().length + frame.c_hand.showCards().length == 2) {
					frame.s_button.setVisible(false);
				}
				if (frame.p_hand.showCards().length == 0 || frame.c_hand.showCards().length == 0) {
					frame.s_button.setVisible(false);
				}
				if(frame.c_hand.showCards().length==0) {
					setVisible(false);
				}
				if(frame.p_hand.showCards().length==0) {
					frame.p_button.setVisible(false);
				}
				if (frame.c_hand.card_count == 0 && frame.p_hand.card_count == 0) {
					frame.n_button.setVisible(true);
					frame.p_button.setVisible(false);
					frame.c_button.setVisible(false);
				}
			}
			else
				System.out.println("game over");
		}
		else if ((frame.p_hand.card_count-1 < 0) && (frame.c_hand.card_count-1 >= 0)){
			frame.c_hand.showCards();
			frame.updateNum(frame.c_hand);
			frame.ansnum++;
			if (frame.c_hand.card_count == 0 && frame.p_hand.card_count == 0) {
				frame.n_button.setVisible(true);
				frame.s_button.setVisible(false);
				frame.c_button.setVisible(false);
			}
		}
	}
}
