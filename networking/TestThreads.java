import java.net.*;
public class TestThreads {
	public static void main(String[] args) {
	ThreadOne t1 = new ThreadOne ();
	Thread one = new Thread(t1);
	ThreadTwo t2 = new ThreadTwo ();
	Thread two = new Thread(t2);
	one.start();
	two.start();
	}

}
class ThreadOne implements Runnable {
	public void run() {
		Accum a =Accum.getAccum();
		for (int i=0;i<98;i++) {
			a.updateCounter(1000);
			try{
				Thread.sleep(60);
			}catch(Exception ex) {ex.printStackTrace(); }
		}
		System.out.println("one " + a.getCount());
	}
}
class ThreadTwo implements Runnable {
	public void run() {
		Accum a = Accum.getAccum();
		for(int i =0; i<99;i++) {
			a.updateCounter(1);
			try {
				Thread.sleep(60);
			} catch (Exception ex) {ex.printStackTrace(); }
			
		}
		System.out.println("two " + a.getCount());
	}
}
		

