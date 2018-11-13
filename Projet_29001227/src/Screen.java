import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Screen extends JPanel{
	private Game game;
	
	public Screen(Game game) {
		this.game = game;
		this.setSize(new Dimension(794, 600));
	}

	public void paint(Graphics g) {

		    g.setColor(Color.white);
		    g.fillRect(0, 0, this.getWidth(), this.getHeight());
		   if(!game.getPause()) {
			   game.drawList(g);
		   }else {
			   for(Ball ball:game.getBallList()) {
				   ball.draw(g);
			   }
		   }
		    /*try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		    repaint();
		}

	

}
