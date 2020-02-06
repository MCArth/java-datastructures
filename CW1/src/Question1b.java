public class Question1b {

	public static void main(String[] args) {
		StringRepeater s = new StringRepeater();

		Question1b tester = new Question1b();

		tester.measureStringRepeaterTimeOnce("hello", 1, s);
		tester.measureStringRepeaterTimeOnce("hello", 100, s);
		tester.measureStringRepeaterTimeOnce("hello", 1000, s);
		tester.measureStringRepeaterTimeOnce("hello", 10000, s);

		tester.measureStringRepeaterTime("hello", 1, 1000000, s);
		tester.measureStringRepeaterTime("hello", 100, 100000, s);
		tester.measureStringRepeaterTime("hello", 1000, 10000, s);
		tester.measureStringRepeaterTime("hello", 10000,1000, s);
//		tester.measureStringRepeaterTime("hello", 20000, s);
//		tester.measureStringRepeaterTime("hello", 40000, s);
	}
	private long getTime() { return System.nanoTime(); }

	private void endTimeAndPrint(long startTime, int n, int numRepeats) {
		double time = (getTime()-startTime)/(1e9*numRepeats);
		System.out.println("T(" + n + "): " + time + " seconds");
	}

	private void measureStringRepeaterTime(String string, int n, int numRepeats, StringRepeater s) {
		s.repeatString("hi", 5); // Ensuring JVM is ready to run the method

		long startTime = getTime();
		for(int i=0; i<numRepeats; i++) {
			s.repeatString(string, n);
		}
		endTimeAndPrint(startTime, n, numRepeats);
	}

	private void measureStringRepeaterTimeOnce(String string, int n, StringRepeater s) {
		s.repeatString("hi", 5); // Ensuring JVM is ready to run the method

		long startTime = getTime();
		s.repeatString(string, n);

		endTimeAndPrintOnce(startTime, n);
	}

	private void endTimeAndPrintOnce(long startTime, int n) {
		System.out.println("T(" + n + "): " + ((getTime()-startTime)/1e9) + " seconds");
	}
}
