public class CardPlayer {

    private Card[] hand; // 갖고 있는 카드
    public int card_count; // 갖고 있는 카드의 장 수
    public int min_num; // 손패 중 제일 작은 숫자 (손패(card_count)=0일때는 0)

    // max_cards는 12단계이므로 12로 사용

    /** Constructor CardPlayer - max_cards 카드를 수용가능한 Card 배열 객체를 만들어 CardPlayer 생성
     * @param max_cards - 들고 있을 수 있는 카드의 최대 장수 */
    public CardPlayer(int max_cards) {
        hand = new Card[max_cards];
        card_count = 0;
    }

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
    // 시작할때 level만큼 받기 반복필요
    // 전부 뽑고나서는 hand[]를 Rank의 내림차순 배열로 수정해주는 코드 필요
   
    
    
   // 새로운 레벨 시작하기 전에 손패 초기화
    public void reDraw(int max_cards) {
    	hand = new Card[max_cards];
		card_count = 0;
    }
    
    
    //사람 버튼에 숫자 보여주기위해
    /** showCards - 클릭시 낼 카드(패중 제일 작은카드) 보여준다.
     * @return 들고 있는 카드 전체  */
    public Card showCards() {
        return hand[min_num - 1];
    }
    
    // min_num 업데이트하기 (버튼 누를때마다 발생)
    public void updateMinNum() {
    	min_num = hand[card_count - 1].getRank();
    }
    
    // 사용한 카드 패에서 제거하기
    // 제거됬으면 true, 불가하면 false
    public boolean removeCard() {
    	if (card_count > 0) {
    		hand[card_count - 1] = null;
    		return true;
    	}
    	else
    		return false;
    }

}