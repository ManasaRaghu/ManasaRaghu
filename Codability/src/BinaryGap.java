import java.util.ArrayList;
import java.util.List;

public class BinaryGap {

	public static void main(String[] args) {
		int i = 10;
		
		char[] binaryNumber = Integer.toBinaryString(i).toCharArray();
		
		int count = 0;
		List<Integer> countOfZeros = new ArrayList<>();
		
		for(char binaryDigit : binaryNumber) {
			if(binaryDigit == '0') {
				count++;
			}else {
				//countOfZeros.add( )
			}
		}
	}

}
