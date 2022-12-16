import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

public class MindFrame extends JFrame{
	int set_num=0,set_num2=0,ansnum=0,level=1,life=3,su=3;
	
	String lifeString="            ";
	JLabel label;
	CardDeck deck;

	
//	// 웨안됨????
	public CardPlayer p_hand;
	public CardPlayer c_hand;
	private CardDeck card;
    public PlayerButton p_button;
    public ComButton c_button;
    public SuButton s_button;
    private GridButton[][] g_button;
    public NextButton n_button;
    public int[] rrans;    
    
    private JLabel label1=new JLabel(lifeString);
  
//	c_hand = new CardPlayer(12);
	
	public MindFrame(int level) {
		
		n_button=new NextButton(this, level);
		
		CardPlayer p = new CardPlayer(level);
		CardPlayer c = new CardPlayer(level);
		card=new CardDeck();
		g_button=new GridButton[4][6];
		for(int i=1;i<=level;i++) {
			p.receiveCard(card.newCard());
			c.receiveCard(card.newCard());
		}
		int index=0;
		int[]answer=new int[24];
		for(int num: p.showCards()) {
			answer[index++]=num;
		}
		for(int num: c.showCards()) {
			answer[index++]=num;
		}
		
		
		System.out.println(Arrays.toString(c.showCards()));
		
		p_hand = p;
		c_hand = c;
		
		
		
		Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(1,3));
        s_button=new SuButton(this,"수리검 : "+Integer.toString(su));
        if(level==1) {
			s_button.setVisible(false);
		}
        life++;
        lossLife();
        label1.setForeground(Color.red);
        label1.setFont(label1.getFont().deriveFont(15.0f));
        JLabel label2=new JLabel("level : "+Integer.toString(level)+"                     ");
        p1.add(label2);
    	p1.add(s_button);
    	p1.add(label1);
    	
    	int[]rans=Arrays.copyOf(answer,answer.length-( (12-level)*2));
    	
    	Arrays.sort(rans);
    	rrans=Arrays.copyOf(rans,rans.length+( (12-level)*2));
    	JPanel p2 = new JPanel(new GridLayout(4,6));
    	for (int row = 0; row < 4 ;row++) {
    		  for(int col=0;col<6; col++) {
    			  g_button[row][col] = new GridButton(this,row,col,Integer.toString(rrans[row*6+col]));
                  p2.add(g_button[row][col]);
    		  }
    	}
    		
        
    	Arrays.sort(p.showCards());
    	JPanel p3 = new JPanel(new GridLayout(4,1));
    	JLabel yours=new JLabel(Arrays.toString(p.yourCards()));
    	p3.add(yours);
    
    	p_button=new PlayerButton(this);
        c_button=new ComButton(this);
        
        p3.add(p_button);
        p3.add(c_button);
    	p3.add(n_button);
    	
    	cp.add(p1,BorderLayout.NORTH);
        cp.add(p2,BorderLayout.CENTER);
        cp.add(p3,BorderLayout.SOUTH);
      



        setTitle("TheMind");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        

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
	
	
	// 카드 내면 일단 set num 업데이트
	public void updateNum(CardPlayer hand) {
		
		g_button[set_num2][set_num].setVisible(true);
		set_num++;
		if(set_num==6) {
			set_num=0;
			set_num2++;
		}
		hand.removeCard();
		if(hand.showCards().length==0) { 
			if(hand.equals(p_hand))
				p_button.setVisible(false);
			if(hand.equals(c_hand))
				c_button.setVisible(false);
		}
		
	}
	
	
	public void lossLife() {
		life--;
		lifeString="            ";
		for(int l=0;l<life;l++) {
        	lifeString=lifeString+" ♥ ";
        }
        label1.setText(lifeString);
        label1.setForeground(Color.red);
        label1.setFont(label1.getFont().deriveFont(15.0f));
	}
	
	public void lossSu() {
		su--;
	}
	public void levelUp() {
		level++;
	}
	
	// 잘못된 카드 내면 더 작은 카드들 버리기
	
	// 수리검 내면 작동
	public void useSu() {
		if(su!=0) {
			if ((c_hand.hand.length - 1 >= 0) && (p_hand.hand.length - 1 >= 0)) {
				if (c_hand.showCards()[c_hand.hand.length - 1] < p_hand.showCards()[p_hand.hand.length - 1]) {
					while (c_hand.showCards().length > 0 && c_hand.showCards()[c_hand.hand.length - 1] < p_hand.showCards()[p_hand.hand.length - 1]) {
						c_hand.updateMinNum();
						updateNum(c_hand);
						ansnum++;
					}
					if (c_hand.hand.length == 0)
						c_button.setVisible(false);
					
					if (p_hand.hand.length - 1 >= 0) {
						p_hand.updateMinNum();
						updateNum(p_hand);
						ansnum++;
					}
					if (p_hand.hand.length == 0)
						p_button.setVisible(false);
					
					if ((c_hand.hand.length == 0 && p_hand.hand.length == 0)) {
						n_button.setVisible(true);
						p_button.setVisible(false);
						c_button.setVisible(false);
					}
				}
				else {
					while (p_hand.showCards().length > 0 &&p_hand.hand[p_hand.hand.length - 1] < c_hand.hand[c_hand.hand.length - 1]) {
						if (p_hand.hand.length > 0)
						p_hand.updateMinNum();
						updateNum(p_hand);
						ansnum++;
					}
					if (p_hand.hand.length == 0)
						p_button.setVisible(false);
					
					if (c_hand.hand.length - 1 >= 0) {
						c_hand.updateMinNum();
						updateNum(c_hand);
						ansnum++;
					}
					if (c_hand.hand.length == 0)
						c_button.setVisible(false);
					
					if (c_hand.hand.length == 0 && p_hand.hand.length == 0) {
						n_button.setVisible(true);
						p_button.setVisible(false);
						c_button.setVisible(false);
					}
				}
				su--;
				s_button.setText("수리검 : "+Integer.toString(su));
			}
			else	
				s_button.setVisible(false);
		}	
	}	
}
