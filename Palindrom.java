public class Palindrom {
	public static void main(String[] args) {
		
		//This program prints is number n palindrome

		int n = 12321;
		int copy = n;

		int reverse = 0;

		while (n > 0) {
			int digit = n % 10;
			reverse = reverse * 10;
			reverse = reverse + digit;
			n = n / 10;
		}

		if (reverse == copy) {
			System.out.println("Is palindrome");
		} else {
			System.out.println("Not palindrome");
		}
	}

}
