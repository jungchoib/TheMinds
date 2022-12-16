import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SuButton extends JButton implements ActionListener{
	private MindFrame frame;
	

	//su 갯수 보이게 하기 super(su)??
	public SuButton(MindFrame f, String su) {
		super(su);
		frame = f;
		addActionListener(this);
	}
	
	// 버튼 누르면
	public void actionPerformed(ActionEvent e) {
		frame.useSu();
		
		if (frame.su == 0)
			setVisible(false);
	}
}
