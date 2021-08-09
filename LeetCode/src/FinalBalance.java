import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FinalBalance {
	@SuppressWarnings("deprecation")
	public static int solution(int[] A, String[] D) {
		
		int intailSum = Arrays.stream(A).sum();
		int moreThreeTRansactions = 0;
		Set<String> distinct = new HashSet<>(Arrays.asList(D));
		Map<Integer,Integer> countMap = new HashMap<>();	
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-M-dd");
		
		for(String date : D) {
			try {
				Date oneDate = dateFormatter.parse(date);
				if(countMap.containsKey(oneDate.getMonth())) {
					countMap.replace(oneDate.getMonth(), countMap.get(oneDate.getMonth())+1);
				}else {
					countMap.put(oneDate.getMonth(), 1);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		
		for(Entry<Integer, Integer> entry : countMap.entrySet()) {
			if(entry.getValue() >= 3 ) {
				moreThreeTRansactions +=1;
			}
			
		}
		return (intailSum - (5 * (12- moreThreeTRansactions)));
	}

	public static void main(String[] args) {
		int[] A = new int[] {100,100,100};
		String[] D = new String[] {"2020-12-31","2020-12-22","2020-12-20"};
		int result = solution(A,D);
		System.out.println(result);

	}

}
