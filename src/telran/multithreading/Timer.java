package telran.multithreading;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer extends Thread {
	//TODO - displaying time in a given format and a given resolution
	//example displaying each second or each 5 second etc.
	long displayInterval;
	DateTimeFormatter formatter;
	public Timer( int displayInteraval, DateTimeFormatter formatter) {
		setDaemon(true);
		this.displayInterval = displayInteraval;
		this.formatter = formatter;
	}
	
	public void run() {
		while( true  ) {
			System.out.println(LocalTime.now().format(formatter));
			try {
				sleep(displayInterval);
			} catch (InterruptedException e) {
				return;
			}
		}
		
	}

}
