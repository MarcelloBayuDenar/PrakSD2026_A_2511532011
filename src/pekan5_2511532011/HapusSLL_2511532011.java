package pekan5_2511532011;

public class HapusSLL_2511532011 {
	// fungsi untuk menghapus head
	public static NodeSLL_2511532011 deleteHead_2011(NodeSLL_2511532011 head_2011) {
		// jika SLL kosong
		if (head_2011 == null)
			return null;
		// pindahkan head ke node berikutnya
		head_2011 = head_2011.next_2011;
		// return head baru
		return head_2011;
	}
	// fungsi menghapus node terakhir SLL
	public static NodeSLL_2511532011 removeLastNode_2011(NodeSLL_2511532011 head_2011) {
		// jika list kosong, return null
		if (head_2011 == null) {
			return null;
		}
		// jika list satu node, hapus node dan return null
		if (head_2011.next_2011 == null) {
			return null;
		}
		// temukan node terakhir ke dua
		NodeSLL_2511532011 secondLast_2011 = head_2011;
		while (secondLast_2011.next_2011.next_2011 != null) {
			secondLast_2011 = secondLast_2011.next_2011;
		}
		// hapus node terakhir
		secondLast_2011.next_2011 = null;
		return head_2011;
	}
	// fungsi menghapus node di posisi tertentu
	public static NodeSLL_2511532011 deleteNode_2011(NodeSLL_2511532011 head_2011, int position_2011) {
		NodeSLL_2511532011 temp_2011 = head_2011;
		NodeSLL_2511532011 prev_2011 = null;
		// jika linked list null
		if (temp_2011 == null)
			return head_2011;
		// kasus 1: head dihapus
		if (position_2011 == 1) {
			head_2011 = temp_2011.next_2011;
			return head_2011;
		}
		// kasus 2: menghapus node di tengah
		// telusuri ke node yang di hapus
	for (int i_2011 = 1; temp_2011 != null && i_2011 < position_2011; i_2011++) {
		prev_2011 = temp_2011;
		temp_2011 = temp_2011.next_2011;
	}
	// jika ditemukan, hapus node
	if (temp_2011 != null) {
		prev_2011.next_2011 = temp_2011.next_2011;
	} else {
		System.out.println("Data tidak ada");
	}
		return head_2011;
	}
	// fungsi mencetak SLL
	public static void printList_2011(NodeSLL_2511532011 head_2011) {
		NodeSLL_2511532011 curr_2011 = head_2011;
		while (curr_2011.next_2011 != null) {
			System.out.print(curr_2011.data_2011+"-->");
			curr_2011 = curr_2011.next_2011;
		}
		if (curr_2011.next_2011 == null) {
			System.out.print(curr_2011.data_2011);
		}
		System.out.println();
	
	}
	// kelas main
	public static void main(String[] args) {
		// buat SLL 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
		NodeSLL_2511532011 head_2011 = new NodeSLL_2511532011(1);
		head_2011.next_2011 = new NodeSLL_2511532011(2);
		head_2011.next_2011.next_2011 = new NodeSLL_2511532011(3);
		head_2011.next_2011.next_2011.next_2011 = new NodeSLL_2511532011(4);
		head_2011.next_2011.next_2011.next_2011.next_2011 = new NodeSLL_2511532011(5);
		head_2011.next_2011.next_2011.next_2011.next_2011.next_2011 = new NodeSLL_2511532011(6);
		// cetak list awal 
		System.out.println("list awal: ");
		printList_2011(head_2011);
		
		//hapus head
		head_2011 = deleteHead_2011(head_2011);
		System.out.println("List setelah head dihapus: ");
		printList_2011(head_2011);
		
		//hapus node terakhir
		head_2011 = removeLastNode_2011(head_2011);
		System.out.println("List setelah simpul terakhir di hapus: ");
		printList_2011(head_2011);
		
		// deleting node at position 2
		int position_2011 = 2;
		head_2011 = deleteNode_2011(head_2011, position_2011);
		
		// print list after deletion
		System.out.println("List setelah posisi 2 dihapus: ");
		printList_2011(head_2011);
	}
}
