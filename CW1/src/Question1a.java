public class Question1a {

	public static void main(String[] args) {
		StringRepeater s = new StringRepeater();

		Question1a tester = new Question1a();
		tester.measureStringRepeaterTime("hello", 1, s);
		tester.measureStringRepeaterTime("hello", 100, s);
		tester.measureStringRepeaterTime("hello", 1000, s);
		tester.measureStringRepeaterTime("hello", 10000, s);
	}

	private long getTime() { return System.nanoTime(); }

	private void endTimeAndPrint(long startTime, int n) {
		System.out.println("T(" + n + "): " + ((getTime()-startTime)/1e9) + " seconds");
	}

	private void measureStringRepeaterTime(String string, int n, StringRepeater s) {
		s.repeatString("hi", 5); // Ensuring JVM is ready to run the method

		long startTime = getTime();
		s.repeatString(string, n);
		endTimeAndPrint(startTime, n);
	}
}
