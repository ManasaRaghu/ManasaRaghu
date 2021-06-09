import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ZigZagConversion {
	
	public static void createZigZagString(Map<Integer, String> zigZag, int rowCount, String ch) {
		
		if(zigZag.isEmpty() ||  zigZag.get(rowCount) == null ) {
			zigZag.put(rowCount, ch);
		}else {
			String addtionalString = zigZag.get(rowCount).concat(ch) ;
			zigZag.replace(rowCount, addtionalString);
		}
	}
	public static String convert(String s, int numRows) {
		Map<Integer, String> zigZag = new HashMap<>();
		String convert = "";
		Boolean reverse = false;
		int rowCount = 0;
		if(numRows == 1) {
			return s;
		}
		for(int i = 0 ; i < s.length() ; i++ ) {
			String ch = String.valueOf(s.charAt(i));
			if(reverse) {
				--rowCount;
				createZigZagString(zigZag, rowCount, ch);
				if(rowCount == 1) {
					reverse = false;
				}
				
			}else {
				++rowCount;
				createZigZagString(zigZag, rowCount, ch);
				if(rowCount == numRows ) {
					reverse = true;
				}
				
			}
		}
		
		for(int j = 1; j <= numRows ; j++) {
			if(zigZag.get(j)!= null)
			convert += zigZag.get(j);
		}
		return convert;

        
    }

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String toConvert = scan.nextLine();
		int rows = scan.nextInt();
		
		String s = convert(toConvert, rows);
		System.out.println(s);
		
	}

}
