import java.util.function.Consumer;
import java.util.Timer;
import java.util.TimerTask;

public class Scheduler{

	public static void f(long msec){
		System.out.println("f() called after " + msec + "milliseconds");
	}

	Scheduler(Consumer<Long> f, long msec){
		new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				f.accept(msec);
			}
		}, msec);

	}
	public static void main(String[] args){
		long msec;
		try {
			msec = Integer.parseInt(args[0]);
			new Scheduler(Scheduler::f, msec);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("give command line arguments\n EX: java Scheduler <milliseconds>");
			System.exit(0);
		}
	} 
}