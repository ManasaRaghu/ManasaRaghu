import java.util.Scanner;
import java.util.regex.Pattern;

public class CodelandUsernameValidation {
	  public static boolean codelUsernameValidation(String str) {
		  int count = 0;
		  int count1 = 0;
		  
		  for (int i = 0; i < str.length(); i++) {
		      if (str.charAt(i) == 'x') {
		          count++;
		      }
		      if(str.charAt(i) == 'o') {
		    	  count1++;
		      }
		  }   
		  
		  
		  // regular expression[a-zA-Z][a-zA-Z0-9_]{2,23}[^_]
//		  !Pattern.matches("[a-zA-Z]", String.valueOf(str.charAt(0)))
		  
//		    String beginningCondition = "([a-z|A-Z])";
//		    String middleCondition = "([a-z|A-Z|0-9[_]]{2,23})";
//		    String endingCondition = "([a-z|A-Z|0-9])";
//		    
//		    String regularExpression = beginningCondition + middleCondition + endingCondition;
//
//		    Pattern patternVerification = Pattern.compile(regularExpression);
//		    if(!Character.isLetter(str.charAt(0)) || str.charAt(str.length()-1) == '_' ) {
//		    	return "false";
//		    }else if(!Pattern.matches("\\w{3,24}", str)) {
//		    	return "false";
//		    }
		  
			return count1 == count;
		  }

	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    System.out.print(codelUsernameValidation(s.nextLine())); 
	}

}
