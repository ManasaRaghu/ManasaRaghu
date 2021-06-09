import java.util.Arrays;
import java.util.Scanner;

public class SearchIn2D {
	public static boolean searchMatrix(int[][] matrix, int target) {
		for(int i = 0; i< matrix.length ;i++) {
			int[] search = matrix[i];
			if(Arrays.binarySearch(search, target) >= 0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] twoDArray =  {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
		};
		
		boolean present = searchMatrix(twoDArray, 13);
		System.out.println(present);
		
	}

}
