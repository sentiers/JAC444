// Workshop 1
// Stack.java
//
// Name: Hyunji Cho
// Seneca Student ID: 128065182
// Seneca email: hcho51@myseneca.ca
// Date of completion: 2020/5/30

package workshop1;

public class Stack {

	private char[] stack;
	private int maxIndex;
	private int topIndex;

	public Stack(int size) {
		stack = new char[size];
		maxIndex = size - 1;
		topIndex = -1;
	}

	// push one element if stack is not full
	public void push(char elem) {
		if(topIndex < maxIndex)
		stack[++topIndex] = elem;
	}

	// pop one element
	public char pop() {
		return stack[topIndex--];
	}

}