package pekan4_2511532011;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public class IterasiQueue_2511532011 {
	public static void main (String []args) {
		Queue<String> q_2011 = new LinkedList<>();
		
		q_2011.add("Pratikum");
		q_2011.add("struktur");
		q_2011.add("Data");
		q_2011.add("Dan");
		q_2011.add("Algoritma");
		
		Iterator<String> iterator_2011 = q_2011.iterator();
		
		while(iterator_2011.hasNext()) {
			System.out.print(iterator_2011.next() + " ");
		}
	}
}
