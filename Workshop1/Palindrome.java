// Workshop 1
// Palindrome.java
//
// Name: Hyunji Cho
// Seneca Student ID: 128065182
// Seneca email: hcho51@myseneca.ca
// Date of completion: 2020/5/30

package workshop1;

public class Palindrome {

	public static void main(String[] args) {
		
		// get string from argument
		String input = args[0];
		
		// make sure string has only lower case
		String caseLoweredInput = input.toLowerCase();
		
		// display
		System.out.println("\n---------- Palindrome Test ----------");
		System.out.println("                        -- Hyunji Cho\n");
		System.out.println("Input: " + input);
		
		// check and result
		if (checkPalindrome(caseLoweredInput)) {
			System.out.println("Result: Palindrome");
		} else {
			System.out.println("Result: Not Palindrome");
		}
		
	}

	private static boolean checkPalindrome(String input) {
		
		boolean result = true;
		
		// create new Stack object
		Stack stack = new Stack(input.length());

		// push all elements into stack
		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
		}

		// input has original order
		// stack.pop() order is reverse order
		// so comparing these two orders can check palindrome
		for (int i = 0; i < input.length(); i++) {
			if (stack.pop() != input.charAt(i))
				result = false;
		}

		return result;
	}

}