import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> answer = new ArrayList<>();
    int[] nums = {1, 2, 3};

    public List<List<Integer>> subsets(int[] nums){
        answer = new ArrayList<>();
        this.nums = nums;
        List<Integer> curr = new ArrayList<>();
        backtrack(0,curr);

        return answer;
    }

    void backtrack(int i, List<Integer> curr){
        if(i == nums.length){
            return;
        }


        curr.add(nums[i]);
        backtrack(i+1,curr);
        curr.removeLast();
        backtrack(i+1,curr);
    }

}

class SubsetsSolution{
    static void main(String[] args){
        Subsets sol = new Subsets();
        List<List<Integer>> answer = sol.subsets(new int[]{1, 2, 3});

        System.out.println(answer);
    }
}
