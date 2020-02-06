public class SkipListTest {
	public static void main(String[] args) {
		SkipList skipl = new SkipList();
		skipl.createTestList();
		System.out.println(skipl.inList("Anne"));
		System.out.println(skipl.inList("Ernie"));
		System.out.println(skipl.inList("Don"));
		System.out.println(skipl.inList("fake news"));
		skipl.insert("fake news");
		System.out.println(skipl.inList("fake news"));

		skipl.insert("abcd");
		skipl.insert("fghi");
		skipl.insert("Aaa");
		skipl.insert("zzz");
		skipl.insert("Bzz");

		skipl.print();
	}
}
