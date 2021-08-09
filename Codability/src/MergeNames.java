import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class MergeNames {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {
        List<String> mergededOrderedNames = new ArrayList<>();	
        for(int i = 0; i < names1.length ; i++){
                mergededOrderedNames.add(names1[i]);
        }
        
        
        for(int j = 0 ; j < names2.length;j++){
            if(!mergededOrderedNames.contains(names2[j])){
                mergededOrderedNames.add(names2[j]);
            }
        }
        
        Collections.sort(mergededOrderedNames);
//        int[][] grid = IntStream
//			    .range(0, row)                                               // iterate 0..3
//			    .mapToObj(i -> IntStream.range(0, col)                       // for each iteratoe 0..1
//			                            .map(j -> scan.nextInt())   // calculate the value
//			                            .toArray())                        // compose the inner array
//			    .toArray(int[][]::new);
        return (String[]) mergededOrderedNames.toArray();
        
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}	