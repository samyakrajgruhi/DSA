import java.util.*;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums){
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int answer = 0;
        Arrays.sort(nums);
        int current = 1;
        for(int i =0;i<nums.length-1;i++) {
            if(nums[i+1] == nums[i]){
                answer = Math.max(answer, current);
                continue;
            }
            if (nums[i + 1] == (nums[i] + 1)) {
                current++;
            } else {
                current = 1;
            }

            answer = Math.max(answer, current);
        }

        return answer;
    }

    public static void main(String[] args){
        int[] nums = {0,0};
        System.out.print(longestConsecutive(nums));
    }
}
