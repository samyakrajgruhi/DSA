import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subesetII {
    public static List<List<Integer>> subsetWithDup(int[] nums){
        List<List<Integer>> finalSubset = new ArrayList<>();
        finalSubset.add(new ArrayList<>());
        Arrays.sort(nums);
        int size = 1;
        for(int i=0;i<nums.length;i++){
            int start = 0;
            if(i>0 && nums[i] == nums[i-1]){
                start = size;
            }
            size = finalSubset.size();
            for(int j=start;j<size;j++){

                List<Integer> dummy = new ArrayList<>(finalSubset.get(j));
                dummy.add(nums[i]);
                finalSubset.add(new ArrayList<>(dummy));
            }
        }

        return finalSubset;
    }
    public static void main(String[] args){
        int[] nums = {1,2,2,2};
        System.out.println(subsetWithDup(nums));
    }
}
