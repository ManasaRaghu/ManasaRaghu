/*
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). 
You must also not convert the inputs to integers directly.
Example 1:
Input: num1 = "11", num2 = "123"
Output: "134"

Example 2:
Input: num1 = "456", num2 = "77"
Output: "533"
 */
import java.util.Scanner;

public class AddStrings {
	
	
	public static String addStrings(String num1, String num2) {
		
//		same logic but implementation different
//		while (num1Index >= 0 || num2Index >= 0) {
//            int x = num1Index >= 0 ? num1.charAt(num1Index) - '0' : 0;
//            int y = num2Index >= 0 ? num2.charAt(num2Index) - '0' : 0;
//            
//            int val = (x + y + carry) % 10;
//            carry = (x + y + carry) / 10;
//            ans.append(val);
//            num1Index--;
//            num2Index--;
//        }
		int i = num1.length()-1;
		int j = num2.length() -1;
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		int carry = 0;
		while(i >= 0 && j >=0) {
			sum = carry + Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(j));
			sb.append(String.valueOf(sum % 10));
			carry = sum / 10;
			i--; j--;
		}
		
		while(i >= 0) {
			sum = carry + Character.getNumericValue(num1.charAt(i));
			sb.append(String.valueOf(sum % 10));
			carry = sum / 10;
			i--;
		}
		while(j >= 0) {
			sum = carry + Character.getNumericValue(num2.charAt(j));
			sb.append(String.valueOf(sum % 10));
			carry = sum / 10;
			j--;
		}
		if(carry > 0 && i == -1 && j == -1) {
			sb.append(carry);
		}
		
		
		
		return sb.reverse().toString();
        
    }

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String sumOfString = addStrings(s.nextLine(),s.nextLine());
		System.out.println(sumOfString);
		
	}

}
