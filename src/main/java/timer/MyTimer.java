package timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * 只有一个后台线程,是串行的,不适用于高并发、高时效性的的业务（多任务会导致执行时间与预期不符）
 * 抛出异常若未进行处理，则任务中断执行
 * task:所要安排的任务 
 * timer:执行任务的时间
 */
public class MyTimer {

	public static void main(String[] args) {
		// 创建一个Timer实例
		Timer timer = new Timer();
		// 创建一个任务实例
		MyTimerTask myTimerTask = new MyTimerTask("N0.1");
		// 通过timer定时调用myTimerTask的业务逻辑（第一次执行是在当前时间的2s后，之后每隔1s执行一次）
		//timer.schedule(myTimerTask, 2000L, 1000L);
		
		Calendar calendar = Calendar.getInstance();
		System.out.println("Current time is : " + new MyTimerTask().getCurrentTime());
		/** 距当前时间3s后执行 */
		/*calendar.add(Calendar.SECOND, 3);
		myTimerTask.setName("schedule1");
		// 所安排的任务，首次执行任务的时间
		timer.schedule(myTimerTask, calendar.getTime());*/
		
		/** 距当前时间3s后执行，之后每隔1s再次执行 */
		/*calendar.add(Calendar.SECOND, 3);
		myTimerTask.setName("schedule2");
		// 所安排的任务，首次执行任务的时间,之后执行的时间间隔
		timer.schedule(myTimerTask, calendar.getTime(), 1000);*/
		
		/** 距当前时间3s后执行任务 */
		/*myTimerTask.setName("schedule3");
		// 所安排的任务,执行当前任务前的延时时间
		timer.schedule(myTimerTask, 3000);*/
		
		/** 距当前时间3s后执行，之后每隔1s再次执行 */
		/*myTimerTask.setName("schedule4");
		// 所安排的任务,执行当前任务前的延时时间，执行一次任务的时间间隔
		timer.schedule(myTimerTask, 3000, 1000);*/
		
		/** 距当前时间3s后执行，之后每隔1s再次执行 */
		/*calendar.add(Calendar.SECOND, 3);
		timer.scheduleAtFixedRate(myTimerTask, calendar.getTime(), 1000);*/
		/** 距当前时间3s后执行，之后每隔1s再次执行 */
		timer.scheduleAtFixedRate(myTimerTask, 3000, 1000);
		// 返回此任务最近实际执行的时间
		System.out.println("实际执行时间: " + new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").format(myTimerTask.scheduledExecutionTime()));
		
	}
}
