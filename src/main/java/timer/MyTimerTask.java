package timer;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	public MyTimerTask(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void run() {
		System.out.println("Current name is : " + name);
	}

}
