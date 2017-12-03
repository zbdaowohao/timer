package timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

	private String name;
	private Integer count = 0;
	
	public MyTimerTask() {
		super();
	}

	public MyTimerTask(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		if (count >= 3) {
			// 取消当前任务
			cancel();
			System.out.println("Excute over 3 times, task has been canceled .");
			return;
		}
		count++;
		System.out.println("Current name is : " + name + ". Excute time is : " + getCurrentTime());
	}
	
	public String getCurrentTime() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
		return sdf.format(calendar.getTime());
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
