import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Window extends JFrame implements MouseListener{
	
	  private JPanel header,bottom;
	  private ScoreBoard scoreboard;
	  private Screen screen;
	  private JButton start,more,less;
	  private Game game;
	  private Timer time;



	  public Window(int nbBall) {

	    this.setTitle("Asteroide");
	    

	    this.setSize(800, 800);

	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    this.setLocationRelativeTo(null);
	    
	    this.setLayout(new BorderLayout());
	    
	    this.setResizable(false);
	    
	    game = new Game(nbBall);
	    time = new Timer();
	    
	    init();
	    this.setVisible(true);
	    game.createBall(screen.getWidth(), screen.getHeight());
	    game.start();
	    time.start();

	  }
	  
	  public void init() {
		  
		  	bottom = new JPanel();
		    scoreboard = new ScoreBoard(game,time);
		    
		    start = new JButton("Stop");
		    more = new JButton("+");
		    less = new JButton("-");
		    
		    start.addActionListener(new ActionListener(){
			        public void actionPerformed(ActionEvent e){
			        	if(!game.getPause()) {
			        		game.pauseGame();
			        		time.pauseTimer();
			        		start.setText("Start");
			        	}else {
			        		game.startGame();
			        		time.startTimer();
			        		synchronized (time) {
			        			time.notify();
							}
			        		synchronized (game) {
								game.notify();
							}
			        		start.setText("Stop");

			        	}
			        }
		        });
		    more.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent e){
		        	game.addBall(new Ball(screen.getWidth(), screen.getHeight()));
		        }
	        });
		    less.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent e){
		        	game.removeBall();
		        }
	        });
		    
		    bottom.add(start);
		    bottom.add(more);
		    bottom.add(less);
		    
		    this.add(scoreboard, BorderLayout.NORTH);
		    this.add(screen = new Screen(game),BorderLayout.CENTER);
		    this.add(this.bottom,BorderLayout.SOUTH);
	  }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	  

	  
}

