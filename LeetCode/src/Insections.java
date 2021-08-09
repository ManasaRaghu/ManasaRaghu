import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
 * Each element in the result must be unique and you may return the result in any order.
 * 
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * 
 * Explanation: [4,9] is also accepted.
 */
public class Insections {

	public static int[] intersection(int[] nums1, int[] nums2) {
		int[] intersection = new int[(nums1.length > nums2.length ? nums1.length : nums2.length )];
		
		/*Solution 1
		 * 
		 */
//Set<Integer> nums1Set = new HashSet<>(Arrays.asList(Arrays.stream( nums1 ).boxed().toArray( Integer[]::new )));
//Set<Integer> nums2Set = new HashSet<>(Arrays.asList(Arrays.stream( nums2 ).boxed().toArray( Integer[]::new )));
//nums1Set.retainAll(nums2Set);
//
//return nums1Set.stream().mapToInt(Integer::intValue).toArray();

// not faster
//		return Arrays.stream(nums1).distinct()
//		.filter(x -> 
//		Arrays.stream(nums2).distinct()
//		.anyMatch(y -> y==x)).toArray();
		
//				List<Integer> intersection = new ArrayList<>();	
		
	/*
	 * More time complexity	
	 */
//
//for(int num1:nums1) {
//	for(int num2 :nums2) {
//		if(num1 == num2) {
//			if(!intersection.contains(Integer.valueOf(num1)) )
//				intersection.add(Integer.valueOf(num1));
//		}
//	}
//}
//intersection.stream().mapToInt(i -> i).toArray();
//
//return intersection.stream().mapToInt(Integer::intValue).toArray();
		
        return intersection;	

    }
	

	public static void main(String[] args) {
		int[] nums1 = new int[] {1,2,2,1};
		int[] nums2 = new int[] {2,2,1};
		
		Arrays.stream(intersection(nums1,nums2)).forEach(System.out::println);
	}

}
