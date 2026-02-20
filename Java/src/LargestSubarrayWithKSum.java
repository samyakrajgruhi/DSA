import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/*
The logic here is that if in an array, say [9,-3,3,-1,6,5] if start adding
element into a variable,say sum, and if we see that sum again the future for greater values
of i then the elements between the previous sum index and current sum index equals to zero
in the given array sum = 9 for i=0 and again sum = 9 for i=2 therefore the sum of the subarray
from i+1(0+1=1)(initial) and i(2)(current) is zero because we got the same element again then the
numbers inbetween cancel out.
 */
public class LargestSubarrayWithKSum {
    public static int largestSubarrayWithKSum(int[] nums){
        int maxLen = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();

        for(int i=0;i< nums.length;i++){
            sum += nums[i];
            if(sum == 0){
                maxLen = i+1;
            }else if(sumIndexMap.containsKey(sum)){
                maxLen = Math.max(maxLen, i - sumIndexMap.get(sum));
            }else{
                sumIndexMap.put(sum,i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args){
        int[] nums = {9, -3, 3, -1, 6, -5};

        System.out.println(largestSubarrayWithKSum(nums));
    }
}
