import javax.swing.*;

public class HumanPlayer extends CardPlayer {
	private String name;
	private int chips;
	
    public HumanPlayer(int max_cards,String n) {
        super(max_cards);
        name=n;
        chips=0;
       
    }

    public boolean wantsACard() {
        String response = JOptionPane.showInputDialog("한장 더 드릴까요? (Y/N)");
        return response.equals("Y");
    }
    public void youWin(){
    	chips++;
    }
    public void youWinBlackjack() {
    	chips+=2;
    }
    public void youLose() {
    	chips--;
    }
    public void youDraw() {
    	
    }
    public int chips() {
    	return chips;
    }
}