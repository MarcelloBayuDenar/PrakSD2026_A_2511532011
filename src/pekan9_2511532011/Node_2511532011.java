package pekan9_2511532011;

public class Node_2511532011 {
	int data_2011;
	Node_2511532011 left_2011;
	Node_2511532011 right_2011;
	
	public Node_2511532011(int data_2011) {
		this.data_2011 = data_2011;
		left_2011 = null;
		right_2011 = null;
	}
	
	public void setLeft_2011(Node_2511532011 node_2011) {
		if ( left_2011 == null ) {
			left_2011 = node_2011;
		}
	}
	
	public void setRight_2011(Node_2511532011 node_2011) {
		if (right_2011 == null ) {
			right_2011 = node_2011;
		}
	}
	
	public Node_2511532011 getLeft_2011() {
		return left_2011;
	}
	
	public Node_2511532011 getRight_2011() {
		return right_2011;
	}
	
	public int getData_2011() {
		return data_2011;
	}
	
	public void setData_2011(int data_2011) {
		this.data_2011 = data_2011;
	}
	
	void printPreorder_2011(Node_2511532011 node_2011) {
		if(node_2011 == null ) {
			return;
		}
		System.out.print(node_2011.data_2011 + " ");
		printPreorder_2011(node_2011.left_2011);
		printPreorder_2011(node_2011.right_2011);
	}
	
	void printPostorder_2011(Node_2511532011 node_2011) {
		if(node_2011 == null ) {
			return;
		}
		printPostorder_2011(node_2011.left_2011);
		printPostorder_2011(node_2011.right_2011);
		System.out.print(node_2011.data_2011 + " ");
	}
	
	void printInorder_2011(Node_2511532011 node_2011) {
		if(node_2011 == null ) {
			return;
		}
		printInorder_2011(node_2011.left_2011);
		System.out.print(node_2011.data_2011 + " ");
		printInorder_2011(node_2011.right_2011);
	}
	
	public String print_2011() {
		return this.print_2011("", true, "");
	}
	
	
	public String print_2011(String prefix_2011, boolean isTail_2011, String sb_2011) {
		if (right_2011 != null ) {
			right_2011.print_2011(prefix_2011 + (isTail_2011 ? "| ": " "), false, sb_2011);
		}
		System.out.println( prefix_2011 + (isTail_2011 ? "\\-- ": "/-- ") + data_2011);
		if (left_2011 != null) {
			left_2011.print_2011(prefix_2011 + (isTail_2011 ? "  ": "| "), true, sb_2011);
		}
		return sb_2011;
	}
}
