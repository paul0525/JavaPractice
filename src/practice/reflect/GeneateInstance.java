package practice.reflect;

public class GeneateInstance {

	private static enum Gender{
		 BOY, GIRL;
	}
	
	//注意这是一个静态的内部类
	public static class Student implements Cloneable{
		
//		private  final int id;
		private  int id;
		private String name;
		private Gender gender;
		
		@Override
		protected Object clone() {
			// TODO Auto-generated method stub
			try {
				return super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		//通过序列化和反序列化
		
		Student stu1 = new Student();
		
		Student stu2 = (Student)stu1.clone();
		
		try {
			Student stu3 = Student.class.newInstance();
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Student stu4 = (Student) Class.forName("practice.reflect.GeneateInstance$Student").newInstance();
			stu4.name="paul";
			System.out.println(stu4.name);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
