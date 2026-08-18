import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> answer = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> findCombinationSum(int[] nums,int target){
        Arrays.sort(nums);
        this.nums = nums;


        answer = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(0,curr,target);
        return answer;
    }

    void backtrack(int i,List<Integer> curr,int target){
        if(i == nums.length){
            if(target == 0){
                answer.add(new ArrayList<>(curr));
            }
            return;
        }

        if(nums[i] <= target){
            curr.add(nums[i]);

            backtrack(i,curr,target-nums[i]);
            curr.removeLast();
        }


        backtrack(i+1,curr,target);

    }
}

class CombinationSumSol{
    static void main(String[] args){
        CombinationSum sol = new CombinationSum();
        List<List<Integer>> answer = sol.findCombinationSum(new int[]{2,3,6,7},7);

        System.out.println(answer);
    }
}
