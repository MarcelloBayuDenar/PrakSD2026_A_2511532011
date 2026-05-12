package pekan6_2511532011;

public class InsertDLL_2511532011 {
	static NodeDLL_2511532011 insertBegin_2011(NodeDLL_2511532011 head_2011, int data_2011) {
		NodeDLL_2511532011 new_node_2011 = new NodeDLL_2511532011(data_2011);
		new_node_2011.next_2011 = head_2011;
		
		if (head_2011 != null) {
			head_2011.prev_2011 = new_node_2011;
		}
		return new_node_2011;
	}
	
	public static NodeDLL_2511532011 insertEnd_2011(NodeDLL_2511532011 head_2011, int newData_2011) {
		NodeDLL_2511532011 newNode_2011 = new NodeDLL_2511532011(newData_2011);
		
		if ( head_2011 == null ) {
			head_2011 = newNode_2011;
		}
		
		else {
			NodeDLL_2511532011 curr_2011 = head_2011;
			while (curr_2011.next_2011 != null) {
				curr_2011 = curr_2011.next_2011;
			}
			curr_2011.next_2011 = newNode_2011;
			newNode_2011.prev_2011 = curr_2011;
		}
		
		return head_2011;
	}
	
	public static NodeDLL_2511532011 insertAtPosition_2011(NodeDLL_2511532011 head_2011, int pos_2011, int new_data_2011) {
		NodeDLL_2511532011 new_node_2011 = new NodeDLL_2511532011(new_data_2011);
		if (pos_2011 == 1 ) {
			new_node_2011.next_2011 = head_2011;
			if (head_2011 != null) {
				head_2011.prev_2011 = new_node_2011;
			}
			head_2011 = new_node_2011;
			return head_2011;
		}
		NodeDLL_2511532011 curr_2011 = head_2011;
		
		for ( int i = 1; i < pos_2011 - 1 && curr_2011 != null; i++) {
			curr_2011 = curr_2011.next_2011;
		}
		
		if (curr_2011 == null ) {
			System.out.println("Posisi Tidak Ada");
			return head_2011;
		}
		new_node_2011.prev_2011 = curr_2011;
		new_node_2011.next_2011 = curr_2011.next_2011;
		curr_2011.next_2011 = new_node_2011;
		
		if ( new_node_2011.next_2011 != null) {
			new_node_2011.next_2011.prev_2011 = new_node_2011;
		}
		return head_2011;
	}
	
	public static void printList_2011(NodeDLL_2511532011 head_2011) {
		NodeDLL_2511532011 curr_2011 = head_2011;
		while ( curr_2011 != null) {
			System.out.print(curr_2011.data_2011 + " <-> ");
			curr_2011 = curr_2011.next_2011;
		}
		System.out.println();
	}
	
	public static void main (String args[]) {
		NodeDLL_2511532011 head_2011 = new NodeDLL_2511532011(2);
		head_2011.next_2011 = new NodeDLL_2511532011(3);
		head_2011.next_2011.prev_2011 = head_2011;
		head_2011.next_2011.next_2011 = new NodeDLL_2511532011(5);
		head_2011.next_2011.next_2011.prev_2011 = head_2011.next_2011;
		
		System.out.print("DLL Awal: ");
		printList_2011(head_2011);
		head_2011 = insertBegin_2011(head_2011, 1);
		System.out.print("Simpul 1 ditambah di awal: ");
		
		printList_2011(head_2011);
		
		System.out.print("Simpul 6 ditambah di akhir: ");
		int data_2011 = 6;
		head_2011 = insertEnd_2011(head_2011, data_2011);
		printList_2011(head_2011);
		
		System.out.print("tambah node 4 di posisi 4: ");
		int data2_2011 = 4;
		int pos_2011 = 4;
		head_2011 = insertAtPosition_2011(head_2011, pos_2011, data2_2011);
		printList_2011(head_2011);
	}
}
