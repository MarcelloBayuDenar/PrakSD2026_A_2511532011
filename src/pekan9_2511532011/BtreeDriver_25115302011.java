package pekan9_2511532011;

public class BtreeDriver_25115302011 {

	public static void main(String[] args) {
		
		Btree_2511532011 tree_2011 = new Btree_2511532011();
		System.out.print("Jumlah Simpul awal pohon: ");
		System.out.println(tree_2011.countNodes_2011());
		
		Node_2511532011 root_2011 = new Node_2511532011(1);
		
		tree_2011.setRoot_2011(root_2011);
		System.out.println("Jumlah simpul jika hanya ada root");
		System.out.println(tree_2011.countNodes_2011());
		Node_2511532011 node2_2011 = new Node_2511532011(2);
		Node_2511532011 node3_2011 = new Node_2511532011(3);
		Node_2511532011 node4_2011 = new Node_2511532011(4);
		Node_2511532011 node5_2011 = new Node_2511532011(5);
		Node_2511532011 node6_2011 = new Node_2511532011(6);
		Node_2511532011 node7_2011 = new Node_2511532011(7);
		Node_2511532011 node8_2011 = new Node_2511532011(8);
		Node_2511532011 node9_2011 = new Node_2511532011(9);
		root_2011.setLeft_2011(node2_2011);
		node2_2011.setLeft_2011(node4_2011);
		node2_2011.setRight_2011(node5_2011);
		node4_2011.setRight_2011(node8_2011);
		root_2011.setRight_2011(node3_2011);
		node3_2011.setLeft_2011(node6_2011);
		node3_2011.setRight_2011(node7_2011);
		node6_2011.setLeft_2011(node9_2011);
		
		tree_2011.setCurrent_2011(tree_2011.getRoot_2011());
		System.out.println("menampilkan simpul terakhir: ");
		System.out.println(tree_2011.getCurrent_2011().getData_2011());
		System.out.println("Jumlah simpul; setelah simpul 7 ditambahkan");
		System.out.println(tree_2011.countNodes_2011());
		System.out.println("InOrder: ");
		tree_2011.printInorder_2011();
		System.out.println("\nPreorder: ");
		tree_2011.printPreorder_2011();
		System.out.println("\nPostorder: ");
		tree_2011.printPostorder_2011();
		System.out.println("\nMenampilkan simpul dalam bentuk pohon");
		tree_2011.print_2011();
	}

}
