import javax.swing.*;
public class BlackjackController {

	private Dealer dealer;
	private HumanPlayer hand_player;
	private ComputerPlayer hand_dealer;
	private final int mxcard= 21;
	
	
	
	BlackjackController(Dealer d) {
		dealer=d;
		hand_player = new HumanPlayer(3,JOptionPane.showInputDialog("이름은?"));
		hand_dealer = new ComputerPlayer(mxcard);
		manageBlackjack();
	}
	public void manageBlackjack()
	{
		hand_player.reDraw(mxcard);
		hand_dealer.reDraw(mxcard);
		
		dealer.dealOneTo(hand_player);
		dealer.dealOneTo(hand_dealer);
		dealer.dealOneTo(hand_player);
		dealer.dealOneTo(hand_dealer);
		
		System.out.println("");
		if(hand_player.totalScore()==21) {
			hand_player.youWinBlackjack();
			System.out.println("블랙잭! 승리!");
		}
		else {
			
			while(hand_dealer.totalScore()<=16) {
				dealer.dealOneTo(hand_dealer);
				System.out.println("딜러의 카드");
				hand_dealer.hand();
				System.out.println("당신의 카드");
				hand_player.showCards();
				System.out.println("\n");
			}
			
			if(hand_player.totalScore()>21)
			{
				hand_player.youLose();
				System.out.println("패배!");	
			}
			else {
				while(hand_player.totalScore()<21&&hand_player.wantsACard()== true){
					dealer.dealOneTo(hand_player);
					System.out.println("딜러의 카드");
					hand_dealer.hand();
					System.out.println("당신의 카드");
					hand_player.showCards();
					System.out.println("\n");
				}
				
				if(hand_dealer.totalScore()>21) {
					hand_player.youWin();
					System.out.println("승리!");
				}
				else {
					if(hand_player.totalScore()==hand_dealer.totalScore())
					{
							hand_player.youDraw();
							System.out.println("비겼다.");
					}
					else {
						if(hand_player.totalScore()>hand_dealer.totalScore()) {
								hand_player.youWin();
								System.out.println("승리!");
						}
						else {
						hand_player.youLose();
						System.out.println("패배!");
						}
					}
				}
			}
		}
			
			
		
		System.out.println("player :"+hand_player.totalScore());
		System.out.println("dealer :"+hand_dealer.totalScore());
		System.out.println("chip :"+hand_player.chips());
		hand_dealer.answer();
		if (JOptionPane.showInputDialog("계속하시겠습니까? Y/N").equals("Y")){
			
			
            this.manageBlackjack();
		}
		else {
            System.exit(0);
        }
	}

}


