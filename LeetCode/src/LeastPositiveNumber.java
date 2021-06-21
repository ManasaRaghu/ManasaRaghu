import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class LeastPositiveNumber {

	final static Scanner scan = new Scanner(System.in); 
	public static int positiveIntegerNotInSet(int[] A) {
		int max = Arrays.stream(A).max().getAsInt();
		if(max < 0) {
			return 1;
		}
		
		Set<Integer> positiveSet = new HashSet<>();
		for(int i : A) {
			if(i > 0) {
				positiveSet.add(i);
			}
		}
		
		for(int i = 1 ; i <= max ; i++) {
			if(!positiveSet.contains(i)) {
				return i;
			}
		}
		return max+1;
	}
	public static void main(String[] args) {
		int N = scan.nextInt();
		int[] A = IntStream.range(0, N).map(i -> scan.nextInt()).toArray();
		int leastPosNum = positiveIntegerNotInSet(A);
		System.out.println(leastPosNum);
	}

}
