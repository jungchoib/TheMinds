public abstract class CardPlayer implements CardPlayerBehavior {

    private Card[] hand; // 갖고 있는 카드
    private int card_count; // 갖고 있는 카드의 장 수

    

    /** Constructor CardPlayer - max_cards 카드를 수용가능한 Card 배열 객체를 만들어 CardPlayer 생성
     * @param max_cards - 들고 있을 수 있는 카드의 최대 장수 */
    public CardPlayer(int max_cards) {
        hand = new Card[max_cards];
        card_count = 0;
    }

    /** wantsACard - 카드 한 장을 받겠는지 답한다.
     * @return 카드를 받고 싶으면 true, 아니면 false */
    public abstract boolean wantsACard();

    /** receiveCard - 카드를 한장 받는다. 한도(배열 hand의 크기)를 초과하면 받을 수 없다.
     * @param c - 카드
     * @return 성공적으로 받았으면 true, 그렇지 않으면 false */
    public boolean receiveCard(Card c) {
        if (card_count < hand.length) {
            hand[card_count] = (c);
            card_count += 1;
            
            return true;
        }
        else
        	
            return false;
    }
   
    	
   
    public void reDraw(int max_cards) {
    	hand = new Card[max_cards];
		card_count = 0;
    	
    }
    
    public Card[] hand() {
    	Card[] card = new Card[card_count];
        
        for (int k = 0; k < card_count;k++) {
        	if(k==0)
        		System.out.println("???");
        	else
        		System.out.println(hand[k].getSuit()+" "+hand[k].getRank());
        }
        return card;
    }
    public Card[] answer() {
    	Card[] card = new Card[card_count];
    	System.out.println("??? : "+hand[0].getSuit()+" "+hand[0].getRank());
    	return card;
    }
    /** showCards - 들고 있는 카드를 내준다.
     * @return 들고 있는 카드 전체  */
    public Card[] showCards() {
    	
        Card[] card = new Card[card_count];
     
        for (int k = 0; k < card_count;k++) {
        	
        	System.out.println(hand[k].getSuit()+" "+hand[k].getRank());
        }
        return card;
        
    }
    public int totalScore() {
    	int total = 0;
		int point;
    	for (int i=0;i<hand.length && hand[i]!=null;i++) 
    	{
			point = hand[i].getRank();
			if (point == 1) {
				if (total + 11 <= 21)
					total += 11;
				else
					total ++;
			}
			else {
				if (point>10)point=10;
					total+=point;
				
				
			}
		}
		
		return total;
		
    
    }

}