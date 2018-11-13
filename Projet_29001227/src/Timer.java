
public class Timer extends Thread implements Board{
	private int time = 0;
	private boolean pause = false;
	
	public Timer() {
		this.setDaemon(true);
	}

	public void pauseTimer() {
		this.pause = true;
	}
	public void startTimer() {
		this.pause = false;
	}
	public String getScoreBoard() {
		return "Timer : "+this.time;
	}
	
	public synchronized void timer() {
		try {
			while(pause) {
				wait();}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		time++;
		
	}
	
	public void run() {
		while(true) {
			timer();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
