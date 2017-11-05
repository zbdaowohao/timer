package timer;

import java.util.Timer;

/**
 * task:所要安排的任务 
 * timer:执行任务的时间
 * 
 */
public class MyTimer {

	public static void main(String[] args) {
		// 创建一个Timer实例
		Timer timer = new Timer();
		// 创建一个任务实例
		MyTimerTask myTimerTask = new MyTimerTask("N0.1");
		// 通过timer定时调用myTimerTask的业务逻辑（第一次执行是在当前时间的2s后，之后每隔1s执行一次）
		timer.schedule(myTimerTask, 2000L, 1000L);
	}
}
