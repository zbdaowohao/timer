package timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class CancelTask {

	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();
		MyTimerTask task1 = new MyTimerTask("N0.1");
		MyTimerTask task2 = new MyTimerTask("N0.2");
		Calendar calendar = Calendar.getInstance();
		System.out.println("Current time is : " + new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").format(calendar.getTime()));

		timer.schedule(task1, 3000, 1000);
		timer.schedule(task2, 3000, 1000);
		
		System.out.println("Canceled task number is : " + timer.purge());
		Thread.sleep(4500);
		/** 停止全部任务 */
		//timer.cancel();
		// 停止单个任务
		task2.cancel();
		System.out.println("All tasks canceled time is : " + new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").format(calendar.getTime()));
		System.out.println("Canceled task number is : " + timer.purge());
	}

}
