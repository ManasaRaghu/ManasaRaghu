import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomSortString {
	
	public static String customSortString(String order, String s) {
		Map<String, Integer> charCount = new HashMap<>();
		String customSortString = "";
//		  int[] counts = new int[26]; 
//	        for (char c : s.toCharArray()) {
//	            counts[c - 'a']++;
//	        }
	        
//        for(String c : order.split("")) {
//	    		customSortString += new String(new char[counts[c.charAt(0) - 'a']]).replace("\0", c);
//	    		counts[c.charAt(0) - 'a'] = 0;
//	    }
//	    
//        for (int i=0; i<counts.length; i++) {
//            	customSortString+=new String(new char[counts[i]]).replace("\0", Character.toString(i + 'a'));
//        }
		
		/*
		 * different solution
		 */
		for(String charr: s.split("")){
	        charCount.put(charr,charCount.getOrDefault(charr,0)+1);
	    }
	    for(String ch : order.split("")) {
	    	if(charCount.get(ch) != null) {
	    		customSortString += new String(new char[charCount.get(ch)]).replace("\0", ch);
	    	}
	    }
	    Set<String> orderSet = new HashSet<>(Arrays.asList(order.split("")));
	    Set<String> sSet = new HashSet<>(Arrays.asList(s.split("")));
	    for(String ch: sSet) {
	    	if(!orderSet.contains(ch)) {
	    		customSortString += new String(new char[charCount.get(ch)]).replace("\0", ch);
	    	}
	    }
	    
	    /*
	     * first solution
	     * 
	     */
		String[] sArray = s.split("");
        Arrays.sort(sArray);
		boolean[] visited = new boolean[sArray.length];
		for(int i= 0; i < order.split("").length;i++) {
			for(int j = 0 ; j < sArray.length;j++) {
				if(sArray[j].contains( order.split("")[i])){
					customSortString += sArray[j];
					visited[j] = true;
				}
			}
		}
		for(int i = 0 ; i< visited.length;i++) {
			if(visited[i] == false) {
				customSortString += sArray[i];
			}
		}
	    
		/*
		 * best soultion
		 */
		int[] counts = new int[26]; // int[] is faster than HashMap
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        
        // add all letters in order according to the proper order
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            int repeats = counts[c-'a'];
            for (int i=0; i<repeats; i++) {
                sb.append(c);
            }
            counts[c-'a'] = 0;
        }
        
        // add remaining letters (not in order)
        for (int i=0; i<counts.length; i++) {
            for (int j=0; j<counts[i]; j++) {
                sb.append((char)(i + 'a'));
            }
        }
        
//        return sb.toString();
		return customSortString;
    }

	public static void main(String[] args) {
		String order = "hucw";
		String s = "utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh";
		String customSortArray = customSortString(order, s);
		System.out.println(customSortArray);
	}

}
