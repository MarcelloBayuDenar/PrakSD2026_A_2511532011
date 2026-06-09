package pekan9_2511532011;

public class Btree_2511532011 {
	private Node_2511532011 root_2011;
	private Node_2511532011 currentNode_2011;
	
	public Btree_2511532011() {
		root_2011 = null;
	}
	
	public boolean search_2011(int data_2011) {
		return search_2011(root_2011, data_2011);
	}
	
	private boolean search_2011(Node_2511532011 node_2011, int data_2011) {
		if (node_2011.getData_2011() == data_2011)
			return true;
		if (node_2011.getLeft_2011() != null)
			if (search_2011(node_2011.getLeft_2011(), data_2011))
				return true;
		if (node_2011.getRight_2011() != null)
			if (search_2011(node_2011.getRight_2011(), data_2011))
				return true;
		return false;
	}
	
	public void printInorder_2011() {
		root_2011.printInorder_2011(root_2011);
	}
	
	public void printPreorder_2011() {
		root_2011.printPreorder_2011(root_2011);
	}
	public void printPostorder_2011() {
		root_2011.printPostorder_2011(root_2011);
	}
	
	public Node_2511532011 getRoot_2011() {
		return root_2011;
	}
	
	public boolean isEmpty_2011() {
		return root_2011 == null;
	}
	
	public int countNodes_2011() {
		return countNodes_2011(root_2011);
	}
	
	private int countNodes_2011(Node_2511532011 node_2011) {
		int count_2011 = 1;
		if ( node_2011 == null) {
			return 0;
		} else {
			count_2011 += countNodes_2011(node_2011.getLeft_2011());
			count_2011 += countNodes_2011(node_2011.getRight_2011());
			return count_2011;
		}
	}
	
	public void print_2011() {
		root_2011.print_2011();
	}
	
	public Node_2511532011 getCurrent_2011() {
		return currentNode_2011;
	}
	
	public void setCurrent_2011(Node_2511532011 node_2011) {
		this.currentNode_2011 = node_2011;
	}
	
	public void setRoot_2011(Node_2511532011 root_2011) {
		this.root_2011 = root_2011;
	}
}
