package pekan5_2511532011;

public class PencarianSLL_2511532011 {
	static boolean searchKey_2011(NodeSLL_2511532011 head_2011, int key_2011) {
		NodeSLL_2511532011 curr_2011 = head_2011;
		while (curr_2011 != null) {
			if (curr_2011.data_2011 == key_2011)
				return true;
			curr_2011 = curr_2011.next_2011;
		}
		return false;
	}
	
	public static void traversal_2011(NodeSLL_2511532011 head_2011) {
		// mulai dari head
		NodeSLL_2511532011 curr_2011 = head_2011;
		while (curr_2011 != null) {
			System.out.print(" " + curr_2011.data_2011);
			curr_2011 = curr_2011.next_2011;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		NodeSLL_2511532011 head_2011 = new NodeSLL_2511532011(14);
		head_2011.next_2011 = new NodeSLL_2511532011(21);
		head_2011.next_2011.next_2011 = new NodeSLL_2511532011(13);
		head_2011.next_2011.next_2011.next_2011 = new NodeSLL_2511532011(30);
		head_2011.next_2011.next_2011.next_2011.next_2011 = new NodeSLL_2511532011(10);
		System.out.print("Penelusuran SLL : ");
		traversal_2011(head_2011);
		// data yang akan dicari
		int key_2011 = 30;
		System.out.print("cari data " +key_2011+ " = ");
		if (searchKey_2011(head_2011, key_2011))
			System.out.println("ketemu");
		else 
			System.out.println("tidak ada");
	} 

}
