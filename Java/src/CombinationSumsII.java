import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumsII {
    List<List<Integer>> answer = new ArrayList<>();
    int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        Arrays.sort(candidates);
        answer = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(0,curr,target);
        return answer;
    }

    void backtrack(int i,List<Integer> curr, int target){
        if(target == 0){
            answer.add(new ArrayList<>(curr));
            return;
        }

        if(i == candidates.length || candidates[i] > target) return;
        curr.add(candidates[i]);
        backtrack(i+1,curr,target-candidates[i]);
        curr.removeLast();

        while(i+1 < candidates.length && candidates[i+1] == candidates[i]) i++;

        backtrack(i+1,curr,target);
    }
}

class CombinationSumIISol{
    static void main(String[] args){
        CombinationSumsII sol = new CombinationSumsII();
        List<List<Integer>> answer = sol.combinationSum2(new int[]{10,1,2,7,6,1,5},8);

        System.out.println(answer);
    }
}