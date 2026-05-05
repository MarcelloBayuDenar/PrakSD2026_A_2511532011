package pekan5_2511532011;

public class TambahSLL_2511532011 {
	
	public static NodeSLL_2511532011 insertAtFront_2011(NodeSLL_2511532011 head_2011, int value_2011) {
		NodeSLL_2511532011 new_node_2011 = new NodeSLL_2511532011(value_2011);
		new_node_2011.next_2011 = head_2011;
		return new_node_2011;
	}
	// fungsi menambahkan node di akhir SLL
		public static NodeSLL_2511532011 insertAtEnd_2011(NodeSLL_2511532011 head_2011, int value_2011) {
			// buat sebuah node dengan sebuah nilai
			NodeSLL_2511532011 newNode_2011 = new NodeSLL_2511532011(value_2011);
			// jika list kosong maka node jadi head
			if (head_2011 == null) {
				return newNode_2011;
			}
		// simpan head ke variabel sementara
			NodeSLL_2511532011 last_2011 = head_2011;
			// telusuri ke node akhir
			while (last_2011.next_2011 != null) {
				last_2011 = last_2011.next_2011;
			}
			// ubah pointer 
			last_2011.next_2011 = newNode_2011;
			return head_2011;
		}
		
		static NodeSLL_2511532011 GetNode_2011(int data_2011) {
			return new NodeSLL_2511532011(data_2011);
		}
		
		static NodeSLL_2511532011 insertPos_2011(NodeSLL_2511532011 headNode_2011, int position_2011, int value_2011) {
			NodeSLL_2511532011 head_2011 = headNode_2011;
			if (position_2011 < 1) {
				System.out.print("Invalid position");
			}
			if (position_2011 == 1) {
				NodeSLL_2511532011 new_node_2011 = new NodeSLL_2511532011(value_2011);
				new_node_2011.next_2011 = head_2011;
				return new_node_2011;
			} else {
				while (position_2011-- != 0) {
					if (position_2011 == 1) {
						NodeSLL_2511532011 newNode_2011 = GetNode_2011(value_2011);
						newNode_2011.next_2011 = headNode_2011.next_2011;
						headNode_2011.next_2011 = newNode_2011;
						break;
					}
					headNode_2011 = headNode_2011.next_2011;
				}
			if (position_2011 != 1) 
			System.out.print("Posisi di luar jangkauan"); 
			}
			return head_2011;
			}
			
		public static void printList_2011(NodeSLL_2511532011 head_2011) {
			NodeSLL_2511532011 curr_2011 = head_2011;
				while (curr_2011.next_2011 != null) {
					System.out.print(curr_2011.data_2011 + "-->");
					curr_2011 = curr_2011.next_2011;
			}
			if (curr_2011.next_2011 == null) {
				System.out.print(curr_2011.data_2011);
			}
			System.out.println();
		}
		
		public static void main (String[] args) {
			// buat linked list 2->3->5->6
			NodeSLL_2511532011 head_2011 = new NodeSLL_2511532011(2);
			head_2011.next_2011 = new NodeSLL_2511532011(3);
			head_2011.next_2011.next_2011 = new NodeSLL_2511532011(5);
			head_2011.next_2011.next_2011.next_2011 = new NodeSLL_2511532011(6);
			
			// cetak list asli
			System.out.print("Senarai berantai awal:");
			printList_2011(head_2011);
			
			// tambahkan node baru di depan
			System.out.print("tambah 1 simpul di depan: ");
			int data_2011 = 1;
			head_2011 = insertAtFront_2011(head_2011, data_2011);
			
			// cetak update list
			printList_2011(head_2011);
			
			// tambahkan node baru di belakang 
			System.out.print("tambah 1 simpul di belakang: ");
			int data2_2011 = 7;
			head_2011 = insertAtEnd_2011(head_2011, data2_2011);
			
			// cetak update list 
			printList_2011(head_2011);
			System.out.print("tambah 1 simpul ke data 4: ");
			int data3_2011 = 4;
			int pos_2011 = 4;
			head_2011 = insertPos_2011(head_2011, pos_2011, data3_2011);
			
			// cetak update list
			printList_2011(head_2011);
			
		}
				
}
