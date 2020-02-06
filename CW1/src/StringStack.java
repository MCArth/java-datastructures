/** A stack abstract data type that contains Strings. */
public class StringStack {
	/**
	 * Contains elements in the stack
	 */
	private String[] stack;
	/**
	 * Pointer to the top element in the stack
	 */
	private int pointer;

	/**
	 * Maximum capacity of the stack
	 */
	private int capacity;

	/**
	 * Constructor for creating a new StringStack with a certain capacity.
	 * @param capacity the maximum number of strings the stack can hold
	 */
	public StringStack(int capacity) {
		pointer = -1;
		stack = new String[capacity];
		this.capacity = capacity;
	}

	/**
	 * Puts the given String on top of the stack (if there is enough space).
	 * @param s the String to add to the top of the stack
	 * @return false if there was not enough space in the stack to add the string;
	 *         otherwise true
	 */
	public boolean push(String s) {
		if(pointer+1 < capacity) {
			stack[++pointer] = s;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Removes the String on top of the stack from the stack and returns it.
	 * @return the String on top of the stack, or null if the stack is empty.
	 */
	public String pop() {
		if (pointer > -1) {
			return stack[pointer--];
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the number of Strings in the stack.
	 * @return the number of Strings in the stack
	 */
	public int count() {
		return pointer+1;
	}
}
