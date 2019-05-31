package practice.regex;

public class TestRegluar {

	public static void main(String[] args) {
	
		System.out.println("11.1234".matches("^\\d{1,}\\.{0,1}\\d{0,6}"));
		System.out.println("11.1".matches("^\\d{1,}\\.{0,1}\\d{0,6}"));
		System.out.println("11.1234567".matches("^\\d{1,}\\.{0,1}\\d{0,6}"));
		System.out.println("0.0".matches("^\\d{1,}\\.{0,1}\\d{0,6}"));
		System.out.println("0".matches("^\\d{1,}\\.{0,1}\\d{0,6}"));
		System.out.println("0.".matches("^\\d{1,}\\.{0,1}\\d{0,6}"));
		
		System.out.println(Double.valueOf("0."));
	}

}
