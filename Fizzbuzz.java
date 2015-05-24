public class Fizzbuzz {

	public static void main(String[] args) {

		String brojStr = args[0];
		int broj = Integer.parseInt(brojStr);

		if (broj % 3 == 0 && broj % 5 == 0) {
			System.out.println("FizzBuzz");
		} else if (broj % 3 == 0) {
			System.out.println("Fizz");
		} else if (broj % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(broj);
		}

	}

}
