package pekan3_2511532011;

public class StackArray_2511532011 {
	static final int MAX_2011 = 1000;
	int top_2011;
	int a_2011[] = new int [MAX_2011];
	
	boolean isEmpty_2011() {return (top_2011 < 0);}
	
	StackArray_2511532011() {top_2011 = -1 ;}
	
	boolean push_2011(int x) {
		if ( top_2011 >= (MAX_2011 - 1)) {
			System.out.println("Stack Overflow");		
			return false;
		}
		else {
			a_2011[++top_2011] = x;
			System.out.println(x + "dimasukkan ke dalam stack");		
			return true;
		}
	}
	
	int pop_2011() {
		if ( top_2011 < 0) {
			System.out.println("Stack Overflow");		
			return 0;
		}
		else {
			int x_2011 = a_2011[top_2011--];
			return x_2011;
		}
	}
	
	int peek_2011() {
		if (top_2011 < 0) {
			System.out.println("Stack underflow");		
			return 0;
		} 
		else {
			int x_2011 = a_2011[top_2011];
			return x_2011;
		}
	}
	
	void print_2011() {
		for ( int i = top_2011; i > -1; i--) {
			System.out.print (" "+ a_2011[i]);
		}
	}
}
