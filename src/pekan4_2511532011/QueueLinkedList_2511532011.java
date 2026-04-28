package pekan4_2511532011;

import java.util.Queue;
import java.util.LinkedList;

public class QueueLinkedList_2511532011 {
	public static void main (String [] args) {
		Queue<Integer> q_2011 = new LinkedList<>();
		
		for ( int i = 0; i < 6; i++) 
			q_2011.add(i);
		
		System.out.println("Element Antrian " + q_2011);
		
		int hapus_2011 = q_2011.remove();
		
		System.out.println("Hapus Elemen = " + hapus_2011);
		System.out.println(q_2011);
		
		int depan_2011 = q_2011.peek();
		System.out.println("Kepala antrian = " + depan_2011);
		
		int banyak_2011 = q_2011.size();
		System.out.println("Size antrian = " + banyak_2011);
	}
}
