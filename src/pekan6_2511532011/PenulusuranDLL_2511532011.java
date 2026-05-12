package pekan6_2511532011;

public class PenulusuranDLL_2511532011 {
	static void forwardTransversal_2011(NodeDLL_2511532011 head_2011) {
		NodeDLL_2511532011 curr_2011 = head_2011;
		
		while (curr_2011 != null ) {
			System.out.print(curr_2011.data_2011 + " <-> ");
			curr_2011 = curr_2011.next_2011;
		}
		
		System.out.println();
	}
	
	static void backwardTransversal_2011(NodeDLL_2511532011 tail_2011) {
		NodeDLL_2511532011 curr_2011 = tail_2011;
		
		while (curr_2011 != null ) {
			System.out.print(curr_2011.data_2011 + " <-> ");
			curr_2011 = curr_2011.prev_2011;
		}
		System.out.println();
	}
	
	public static void main ( String[] args) {
		NodeDLL_2511532011 head_2011 = new NodeDLL_2511532011(1);
		NodeDLL_2511532011 second_2011 = new NodeDLL_2511532011(2);
		NodeDLL_2511532011 third_2011 = new NodeDLL_2511532011(3);
		
		head_2011.next_2011 = second_2011;
		second_2011.prev_2011 = head_2011;
		second_2011.next_2011 = third_2011;
		third_2011.prev_2011 = second_2011;
		
		System.out.println("Penulusuran Maju:");
		forwardTransversal_2011(head_2011);
		
		System.out.println("Penulusuran Mundur:");
		backwardTransversal_2011(third_2011);
		
	}
}
