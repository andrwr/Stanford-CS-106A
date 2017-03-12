package worlds;

import java.awt.Color;

import acm.program.*;
import acm.graphics.*;

public class graphi extends ConsoleProgram {

   public void run() {
    int n = readInt("Enter the number of objects n: ");
    int k = readInt("Enter number to be chosen k: ");
    println("C(" + n + ", " + k + ") = " + combinations(n, k));
   }
   
   public int combinations(int n, int k) {
	   return (factorial(n) / (factorial(k) * factorial(n - k)));
   }
   
   public int factorial(int n) {
	   int total = 1;
	   for (int i = 1; i <= n; i++) {
		   total = total * i;
	   }
	   return total;
   }
   
}
