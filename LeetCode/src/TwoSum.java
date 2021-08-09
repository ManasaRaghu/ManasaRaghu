import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {

		/*
		 * If array is sorted
		 */
		for(int i = 0 ; i < nums.length ; i++) {
			int index = Arrays.binarySearch(nums, target - nums[i]);
			if(index == i) {
				return new int[] {i+1, index+2};
			}else if(index >= 0){
				return new int[] {i+1, index+1};
			}
		}
// 		solution 2
		
//		int start = 0;
//		int end = nums.length -1;
//		while(start != end) {
//			int sum = nums[start] + nums[end];
//			if(sum > target) {
//				end -=1;
//			}else if(sum < target) {
//				start +=1;
//			}else {
//				return new int[] {start+1,end+1};
//			}
//		}
		/*
		 * Normal Solution where array is not sorted
		 */
//		Map<Integer,Integer> diffMap = new HashMap<>();
//		
//		for(int i = 0 ; i < nums.length ; i++) {
//			Integer difference = target - nums[i];
//			
//			if(diffMap.get(difference) != null) {
//				return new int[] {
//						diffMap.get(difference), i
//				};
//				
//			}
//			diffMap.put(nums[i], i);
//		}
//		
		
		return null;
    }

	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4,4,9,56,90};
		int[] result =twoSum(nums, 8);
		System.out.println(result[0] + "\t"+result[1]);
	}

}
