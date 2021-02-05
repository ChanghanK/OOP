/**
 * Created on Jun 23, 2019
 *
 * Project: demo04-BasicThreading 
 */
package basicThreads;

/**
 * @author kitty
 * @version 1.0
 */
public class Run_Lambda
{
	public static void main(String [] args) 
	{
		// create anonymous class and use lambda expression to override run()
		new Thread(() -> {
			System.out.println("Hello Kitty!");
		 }).start();
	}
}
