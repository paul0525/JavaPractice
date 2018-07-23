package practice.lang;

public class TestClassOfMethod {

	
	public static void main(String[] args) {
		
		class Person implements Comparable<Person>{
			
			public Person(String userName, int age) {
				super();
				this.userName = userName;
				this.age = age;
			}

			private String userName;
			private int age;
			
			@Override
			public int compareTo(Person o) {
				
				String str = args[0].toString();
				return 0;
			}
			
		}/*class in the  method*/
	
	}
}
