package pekan6_2511532011;

public class HapusDLL_2511532011 {
	public static NodeDLL_2511532011 delHead_2011(NodeDLL_2511532011 head_2011) {
		if ( head_2011 == null ) {
			return null;
		}
		
		NodeDLL_2511532011 temp_2011 = head_2011;
		head_2011 = head_2011.next_2011;
		
		if ( head_2011 != null ) {
			head_2011.prev_2011 = null;
		}
		
		return head_2011;
	}
	
	public static NodeDLL_2511532011 delLast_2011(NodeDLL_2511532011 head_2011) {
		if ( head_2011 == null ) {
			return null;
		}
		if ( head_2011.next_2011 == null ) {
			return null;
		}
		
		NodeDLL_2511532011 curr_2011 = head_2011;
		while ( curr_2011.next_2011 != null) {
			curr_2011 = curr_2011.next_2011;
		}
		
		if (curr_2011.prev_2011 != null ) {
			curr_2011.prev_2011.next_2011 = null;
		}
		
		return head_2011;
	}
	
	public static NodeDLL_2511532011 delPos_2011(NodeDLL_2511532011 head_2011, int pos_2011) {
		if ( head_2011 == null ) {
			return head_2011;
		}
		NodeDLL_2511532011 curr_2011 = head_2011;
		
		for ( int i = 1; curr_2011 != null && i < pos_2011; i++) {
			curr_2011 = curr_2011.next_2011;
		}
		
		if ( curr_2011 == null ) {
			return head_2011;
		}
		
		if ( curr_2011.prev_2011 != null) {
			curr_2011.prev_2011.next_2011 = curr_2011.next_2011;
		}
		
		if ( curr_2011.next_2011 != null) {
			curr_2011.next_2011.prev_2011 = curr_2011.prev_2011;
		}
		
		if ( head_2011 == curr_2011) {
			head_2011 = curr_2011.next_2011;
		}
		
		return head_2011;
	}
	
	public static void printList_2011(NodeDLL_2511532011 head_2011) {
		NodeDLL_2511532011 curr_2011 = head_2011;
		while (curr_2011 != null) {
			System.out.print(curr_2011.data_2011 + " <-> ");
			curr_2011 = curr_2011.next_2011;
		}
		System.out.println();
	}
	
	public static void main ( String [] args) {
		NodeDLL_2511532011 head_2011 = new NodeDLL_2511532011(1);
		head_2011.next_2011 = new NodeDLL_2511532011(2);
		head_2011.next_2011.prev_2011 = head_2011;
		head_2011.next_2011.next_2011 = new NodeDLL_2511532011(3);
		head_2011.next_2011.next_2011.prev_2011 = head_2011.next_2011;
		head_2011.next_2011.next_2011.next_2011 = new NodeDLL_2511532011(4);
		head_2011.next_2011.next_2011.next_2011.prev_2011 = head_2011.next_2011.next_2011;
		head_2011.next_2011.next_2011.next_2011.next_2011 = new NodeDLL_2511532011(5);
		head_2011.next_2011.next_2011.next_2011.next_2011.prev_2011 = head_2011.next_2011.next_2011.next_2011;
		
		System.out.print("DLL Awal: ");
		printList_2011(head_2011);
		
		System.out.print("Setelah head Dihapus: ");
		head_2011 = delHead_2011(head_2011);
		printList_2011(head_2011);
		
		System.out.print("Setelah node terakhir Dihapus: ");
		head_2011 = delLast_2011(head_2011);
		printList_2011(head_2011);
		
		System.out.print("Menghapus node ke 2: ");
		head_2011 = delPos_2011(head_2011, 2);
		printList_2011(head_2011);
	}
}
