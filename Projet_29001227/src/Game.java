import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends Thread implements Board{
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	private ArrayList<Ball> deleteBalls = new ArrayList<Ball>();
	boolean move =false,pause = false;
	private int score = 0,nbBall;
	
	public Game(int nbBall) {
		this.setDaemon(true);
		this.nbBall = nbBall; 
	}
	
	public void createBall(int with,int heigth) {
		for(int i = 0;i<nbBall;i++) {
	    	balls.add(new Ball(with,heigth));
	    }
	}
	public ArrayList<Ball> getBallList(){
		return balls;
	}
	
	public boolean getPause() {
		return this.pause;
	}
	public void pauseGame() {
		this.pause = true;
	}
	public void startGame() {
		this.pause = false;
	}
	public void addBall(Ball ball) {
		if(balls.size()<nbBall) {
			balls.add(ball);
		}
	}
	
	public void removeBall(){
		if(balls.size()>0) {
			balls.remove(balls.size()-1);
		}
	}
	public synchronized void drawList(Graphics g) {
		
		if(!move) {
		    for(Ball ball: balls) {
		    	ball.draw(g);
		    }
		  move = true;
		}
	}
	
	public synchronized void moves() {
		
		if(move) {
			try {
				while(pause) {wait();}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(int i = 0 ;i<balls.size();i++) {
				balls.get(i).move();
				for(int j = i+1;j<balls.size();j++ ) {
					if(balls.get(i).collision(balls.get(j))) {
						deleteBalls.add(balls.get(i));
						deleteBalls.add(balls.get(j));
						score = score + 2;
					}
				}
			}
			for(Ball delete:deleteBalls) {
				balls.remove(delete);
			}
			deleteBalls.clear();
			try {
				sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			move = false;
		}
	}
	
	public String getScoreBoard() {
		return "Score : "+this.score;
	}
	public void run() {
		while(true) {
					moves();
		}
	}
}
