public class CardDeck {

    private int card_count; // 남은 카드 수
    private Card[] deck = new Card[100];
    // Invariant: deck[0], .., decl[card_count-1] 에 카드가 있다.

    public CardDeck() {
        createDeck();
    }

    private void createDeck() {
        for (int i = 1; i <= 100; i++) {
        	deck[card_count] = new Card(i);
            card_count = card_count + 1;
        }
    }

    /** newCard - 임의의 새 카드 한 장을 뽑아 줌
    * @return 카드 덱에서 임의로 한 장을 뽑아 리턴
    *         없으면 카드 1벌을 새로 만들고 한 장을 뽑아 리턴   */
    public Card newCard() {
        int index = (int)(Math.random() * card_count);
        Card card_to_draw = deck[index];
        for (int i = index+1; i < card_count; i++)
            deck[i-1] = deck[i];
        card_count = card_count - 1;
        return card_to_draw;
    }
}