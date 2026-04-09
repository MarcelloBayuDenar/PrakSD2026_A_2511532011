package pekan3_2511532011;

public class StackArrayDriver_2511532011 {
	public static void main (String []args) {
		StackArray_2511532011 s_2011 = new StackArray_2511532011();
		
		s_2011.push_2011(10);
		s_2011.push_2011(20);
		s_2011.push_2011(30);
		System.out.println(s_2011.pop_2011() + "dikeluarkan dari stack ");
		System.out.println("Elemen teratas adalah " + s_2011.peek_2011());
		System.out.print("Element pada stack");
		s_2011.print_2011();
	}
}
