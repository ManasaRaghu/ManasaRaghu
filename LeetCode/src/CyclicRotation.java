
public class CyclicRotation {

	public static void main(String[] args) {
		int[] numbers = new int[] {1,2,3,4};
		int numOfRotation = 2;
		int[] rotatedNumbers = new int[numbers.length];
		System.out.println(numbers);
		for(int k = 1 ; k <= numOfRotation ; k++) {
			for(int i = 0 ; i < numbers.length ; i++) {
				if((i+1) == numbers.length ) {
					rotatedNumbers[0] = numbers[i];
					continue;
				}
				rotatedNumbers[i+1] = numbers[i]; 
			}
			numbers = rotatedNumbers;
			rotatedNumbers = new int[numbers.length];
		}
		System.out.println(numbers.toString());

	}

}
