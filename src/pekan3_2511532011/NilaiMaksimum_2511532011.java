package pekan3_2511532011;
import java.util.Stack;
import java.util.Scanner;


public class NilaiMaksimum_2511532011 {
	public static int max_2011(Stack<Integer> s_2011) {
		Stack<Integer> backup_2011 = new Stack<Integer>();
		int maxValue_2011 = s_2011.pop();
		backup_2011.push(maxValue_2011);
		
		while ( !s_2011.isEmpty()) {
			int next_2011 = s_2011.pop();
			backup_2011.push(next_2011);
			maxValue_2011 = Math.max(maxValue_2011, next_2011);
		}
		
		while (!backup_2011.isEmpty()) {
			s_2011.push(backup_2011.pop());
		}
		return maxValue_2011;
	}
	
	public static void main (String []args) {
		Stack<Integer> s_2011 = new Stack<Integer>();
		s_2011.push(70);
		s_2011.push(12);
		s_2011.push(20);
		
		System.out.println("isi Stack " + s_2011);
		System.out.println("Stack teratas " + s_2011.peek());
		System.out.println("Nilai teratas " + max_2011(s_2011));
		
	}
} 
