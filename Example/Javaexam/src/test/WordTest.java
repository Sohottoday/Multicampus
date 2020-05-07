package test;

public class WordTest {
	public static void main(String[] args) {
		WordCount a = new WordCount();
		System.out.println("결과 1  : "+a.counter("java jdbc sql html5 css javascript", true));
		System.out.println("결과 2  : "+a.counter("java jdbc sql html5 css javascript", false));
	}
}
class WordCount {	
	String text;
	boolean word;
	
	public int counter(String text, boolean word) {
		int result;
		if(word==true) {
			result = text.split(" ").length;
		} else {
			result =text.toCharArray().length;
		}
		return result;
	}
}
