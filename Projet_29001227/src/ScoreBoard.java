import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreBoard extends JLabel{
	Board score,time;
	public ScoreBoard (Board score,Board time) {
		this.score = score;
		this.time = time;
		this.setFont(new Font("Courier New",Font.LAYOUT_NO_LIMIT_CONTEXT,30));
		this.setText(score.getScoreBoard()+" "+time.getScoreBoard());
		this.setHorizontalAlignment(CENTER);
	}
	
	public void paint(Graphics g) {
		this.setText(score.getScoreBoard()+" "+time.getScoreBoard());
		super.paint(g);
		repaint();
	}
}
