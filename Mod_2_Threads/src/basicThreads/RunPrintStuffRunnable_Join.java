/**
 * Created on Sep 18, 2009
 *
 * Project: demo04-BasicThreading 
 */
package basicThreads;

/**
 * @author dwatson, kitty
 * @version 1.2
 */
public class RunPrintStuffRunnable_Join
{
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String [] args) throws InterruptedException
	{
		PrintStuffRunnable psr = new PrintStuffRunnable("Object");
		ThreadGroup tg = new ThreadGroup("Threads");

		Thread t1 = new Thread(tg, psr);
		t1.start();
		
		Thread t2 = new Thread(tg, psr);
		t2.start();
		
		Thread t3 = new Thread(tg, psr);
		t3.start();
		
		Thread t4 = new Thread(tg, psr);
		t4.start();
		
		// main thread will wait until all 4 threads are done (sequenced)
		t1.join();
		t2.join();
		t3.join();
		t4.join();
	
		System.out.println("All threads are complete");
	}
}
