package telran.multithreading;
import java.time.format.DateTimeFormatter;
public class TimerControllerAppl {

	public static void main(String[] args) {
		Timer timer = new Timer(500,DateTimeFormatter.ISO_TIME);
		timer.start();
		try {
			stopThreadAfter(timer, 5_000);
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			
		}
		System.out.println("App terminated");
	}

	private static void stopThreadAfter(Thread thread, int milliseconds) {
		new Thread( () -> {
			try {
				Thread.sleep(milliseconds);
			} catch (InterruptedException e) {
				
			}
			thread.interrupt();
		}).start();
	}
}
