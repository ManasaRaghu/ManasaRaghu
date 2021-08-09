import java.util.HashSet;
import java.util.Set;

public class InternalNodes {
    public static int count(int[] tree) {
        int[] count = new int[tree.length];
        Set<Integer> counts = new HashSet<>();		
        int internalNode = 0;
        
        for(int i=0;i < tree.length;i++){
        	counts.add(count[i]);
        }
        for(int k=0;k < count.length ; k++){
            if(count[k] >= 1){
                internalNode +=1;
            }
        }
        return internalNode;
    }

    public static void main(String[] args) {
        System.out.println(InternalNodes.count(new int[] { 1, 3, 1, -1, 3 }));
    }
}