package pekan3_2511532011;
import java.util.Stack;
import java.util.Scanner;

public class StackPostfix_2511532011 {
	public static int postfixEvaluate_2011(String expression) {
		Stack<Integer> s_2011 = new Stack<Integer>();
		Scanner input_2011 = new Scanner(expression);
		
		while ( input_2011.hasNext()) {
			
			if (input_2011.hasNextInt()) {
				s_2011.push(input_2011.nextInt());
			}
			else {
				String operator_2011 = input_2011.next();
				int operand2_2011 = s_2011.pop();
				int operand1_2011 = s_2011.pop();
				
				if (operator_2011.equals("+")) {
					s_2011.push(operand1_2011 + operand2_2011);
				} else if (operator_2011.equals("-")) {
					s_2011.push(operand1_2011 - operand2_2011);
				} else if (operator_2011.equals("*")) {
					s_2011.push(operand1_2011 * operand2_2011);
				} else if (operator_2011.equals("/")) {
					s_2011.push(operand1_2011 / operand2_2011);
				}
			}
		}
		
		input_2011.close();
		return s_2011.pop();
	}
	
	public static void main(String [] args) {
		System.out.println("Hasil postfix= " + postfixEvaluate_2011("5 2 4 * + 7 -"));
	}
}
