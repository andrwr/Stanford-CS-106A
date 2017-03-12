
import acm.program.*;

public class Fib extends ConsoleProgram{

	private static final int MAX = 10000;
	
	public void run() {
		println("This program lists the Fibonacci sequence.");
		
		int total = 0;
		int first = 0;
		int second = 1;
		while (total < MAX) {
			println(total);
			first = second;
			second = total;
			total = first + second;
		}
	}
}
