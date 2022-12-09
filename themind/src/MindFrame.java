import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MindFrame extends JFrame{
	int set_num, life = 2, su = 1, level = 1;
	JLabel label;
	CardDeck deck;

//	// 웨안됨????
	public CardPlayer p_hand;
	public CardPlayer c_hand;
//	c_hand = new CardPlayer(12);
	
	public MindFrame(CardPlayer p, CardPlayer c) {
		p = new CardPlayer(12);
		c = new CardPlayer(12);
		p_hand = p;
		c_hand = c;
		
	}
//	
//	frame 구현!!!!!!!!!!!!!!!!
//	
//	
//	
//	
//	
//	
//	
//	
//	// 버튼에 쓸 함수
//	
	// 최소숫자 비교
	public boolean pIsBig() {
		if (p_hand.min_num > c_hand.min_num)
			return true;
		else
			return false;
	}
	
	// 카드 내면 일단 set num 업데이트
	public void updateNum(CardPlayer hand) {
		set_num = hand.min_num;
		hand.removeCard();
		
	}
	
	public void lossLife() {
		life--;
	}
	
	public void lossSu() {
		su--;
	}
	public void levelUp() {
		level++;
		p_hand.reDraw(12);
		c_hand.reDraw(12);
		// 덱 초기화 구현필요 !!!!!!!!!!!
		// p,c 패 level만큼 뽑기 구현 필요 !!!!!!!!!!!!!
		if (level % 3 == 2)
			su++;
		else if (level % 3 == 0)
			life++;
	}
	
	// 잘못된 카드 내면 더 작은 카드들 버리기
	public void failAction() {
		while (set_num > p_hand.min_num) {
			// print (버릴카드 번호) 구현하기 !!!!!!!!!!!!!!!!
			p_hand.removeCard();
			p_hand.updateMinNum();
		}
		while (set_num > c_hand.min_num) {
			// print (버릴카드 번호) 구현하기 !!!!!!!!!!!!!!!!
			c_hand.removeCard();
			c_hand.updateMinNum();
		}
	}
	
	// 수리검 내면 작동
	public void useSu() {
		// print("Player min_num: **     Com min_num: **") 구현!!!!!!!!!
		
		//제일 작은카드들 제거하기, 각자 min_num update하기
		c_hand.removeCard();
		c_hand.updateMinNum();
		p_hand.removeCard();
		p_hand.updateMinNum();
		su--;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
