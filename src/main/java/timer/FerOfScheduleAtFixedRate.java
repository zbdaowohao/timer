package timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class FerOfScheduleAtFixedRate {

	public static void main(String[] args) {
		Timer timer = new Timer();
		Calendar calendar = Calendar.getInstance();
		System.out.println("Current time is : " + new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").format(calendar.getTime()));
		// 实际执行时间晚于计划执行时间
		//delayTask(timer, calendar);
		// 任务执行说需要的时间超出任务执行的周期间隔
		unExpectedTask(timer, calendar);
		
	}

	private static void unExpectedTask(Timer timer, Calendar calendar) {
		// 按实际任务所需时间执行，上一个任务结束了才会开始下一个任务，任务计划执行越多变会不断延迟
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Schedule excute time is : "  + new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").format(scheduledExecutionTime()));
			}
		}, calendar.getTime(), 2000);
		// 按实任务计划去执行，上一个任务未结束下一个任务仍然按计划执行，任务不会被delay
		/*timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("ScheduleAtFixedRate excute time is : "  + new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").format(scheduledExecutionTime()));
			}
		}, calendar.getTime(), 2000);*/
	}

	private static void delayTask(Timer timer, Calendar calendar) {
		// 设置时间为当前时间的前6s
		calendar.add(Calendar.SECOND, -6);
		
		// 实际执行时间晚于计划执行时间，从实际执行开始按计划执行
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("Schedule excute time is : "  + new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").format(scheduledExecutionTime()));
			}
		}, calendar.getTime(), 2000);
		// 实际执行时间晚于计划执行时间，从实际执行开始多次执行任务，直到赶上计划后按计划继续执行
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				System.out.println("ScheduleAtFixedRate excute time is : "  + new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").format(scheduledExecutionTime()));
			}
		}, calendar.getTime(), 2000);
	}

}
