import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GridButton extends JButton implements ActionListener{
	private MindFrame frame;
	// min_num 보이게 하기
	public GridButton(MindFrame f,int r,int c,String b) {
		super(b);
		
		setVisible(false);
		frame = f;
		
		
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
}

