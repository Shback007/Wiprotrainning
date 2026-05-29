package day6;

public class ExceptionHandling {
	public static void main(String[] args) {
		try {
//			int result = 10/0;
			int arr[] = new int[3];
			arr[5]=10;
//			System.out.println(result);
		}catch(ArithmeticException e) {
			System.out.println("cannot " +e.getLocalizedMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
}
