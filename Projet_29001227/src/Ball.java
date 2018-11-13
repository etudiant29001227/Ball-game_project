import java.awt.*;
import javax.swing.JPanel;

public class Ball{
	private int speed;
	private Color color;
	private int x,y,diameter,with,height;
	boolean backX = false, backY = false;
	
	public Ball(int winX, int winY) {
		
		this.with = winX;
		this.height = winY;
		this.diameter = winX/15;
		
		Randomizer xRand = new Randomizer(winX);
		Randomizer yRand = new Randomizer(winY);
		Randomizer vectorSpeed = new Randomizer(7,1);
		
		this.speed = vectorSpeed.getInt();
		this.x = xRand.getInterval(this.diameter,winX-this.diameter/2);
		this.y = yRand.getInterval(this.diameter,winY-this.diameter/2);
		this.color = xRand.getRandomColor();
		
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int getDiameter(){
		return this.diameter;
	}
	
	
	public Color getColor(){
		return this.color;
	}
	
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillOval(this.x, this.y, this.diameter, this.diameter);
	}
	
	public boolean collision(Ball ball) {
		int dCollision = (int)( Math.pow((this.x-ball.getX()),2)+Math.pow((this.y-ball.getY()), 2));
		return dCollision < (int)(Math.pow(((this.diameter/2)+(ball.getDiameter()/2)), 2));
	}
	
	public void move() {

	      if (this.x < 1) {
	        backX = false;
	      }
	      if (this.x > this.with - this.diameter) {
	        backX = true;
	      }
	      if (this.y < 1) {
	        backY = false;
	      }
	      if (this.y > this.height - this.diameter) {
	        backY = true;
	      }
	      if (!backX){
	    	  this.x+=1*speed;
	      }else{
	    	  this.x-=1*speed;
	      }
	      if (!backY){
	    	  this.y+=1*speed;
	      }else{
	    	  this.y-=1*speed;
	      }

	}
}
