public class StringRepeaterTest{
	public static void main(String[] args) {
		StringRepeater s = new StringRepeater();
		System.out.println("Should be HelloHelloHello");
		System.out.println(s.repeatString("Hello",3));
		System.out.println("Should be the empty string");
		System.out.println(s.repeatString("Hello",0));
		System.out.println("Should be the empty string");
		System.out.println(s.repeatString("",3));
	}
}
