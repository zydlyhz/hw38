package core;

public class TDG {
	
	int length = 0, result = 0;
	static int max = 100;
	public static void main(String[] args ) {
for(int i=2; i <= max; i++) {
			
			System.out.println("TC-01." + (String.format("%02d", i - 1)) + " (" + i + 
					(PrimeNumberChecker.validate(i) ? " is prime number)," : " is not prime number)," + 
					i + ",") + PrimeNumberChecker.validate(i));
		}
	}

}
