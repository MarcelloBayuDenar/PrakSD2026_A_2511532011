package pekan4_2511532011;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class ReverseData_2511532011 {
	public static void main (String []args) {
		Queue<Integer> q_2011 = new LinkedList<Integer>();
		
		q_2011.add(1);
		q_2011.add(2);
		q_2011.add(3);
		
		System.out.println("sebelum reverse " + q_2011 );
		
		Stack<Integer> s_2011 = new Stack<Integer>();
		
		while(!q_2011.isEmpty()) {
			s_2011.push(q_2011.remove());
		}
		
		while(!s_2011.isEmpty()) {
			q_2011.add(s_2011.pop());
		}
		System.out.println("Sesudah reverse= " + q_2011);
		
	}
}
