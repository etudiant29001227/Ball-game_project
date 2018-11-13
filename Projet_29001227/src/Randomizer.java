import java.awt.Color;
import java.util.Random;

public class Randomizer {
	private Random rand = new Random();
	private int randomInt;
	private int min;
	private int max;
	
	public Randomizer(int randomInt) {
		this.randomInt = randomInt;
		this.min = 0;
	}
	/**
	 * getInt return a number in interval min , randomInt
	 * @param randomInt
	 * @param min
	 */
	public Randomizer(int randomInt, int min) {
		this.randomInt = randomInt;
		this.min = min;
	}
	
	public int getInt() {
		return rand.nextInt(this.randomInt)+this.min;
	}
	
	public int getInterval(int min, int max) {
		int nb = (int)(rand.nextInt(max));
		while(nb>max || nb<min) {
			nb = (int)(rand.nextInt(max));
		}
		return nb;
	}
	
	public Color getRandomColor() {
		
		return new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
	}
	
}
