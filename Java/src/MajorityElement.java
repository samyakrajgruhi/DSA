import java.util.*;


class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int majorityCount = nums.length/2;
        int result = nums.length>0? nums[0] : 0;
        for(int num: nums){
            if(counts.containsKey(num)){
                counts.put(num,counts.get(num)+1);
            }else{
                counts.put(num,0);
            }
            if(counts.get(num) > majorityCount){
                result = num;
            }
        }

        return result;

    }

    public static List<Integer> majorityElement3(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int majorityCount = nums.length/3;
        List<Integer> result = new ArrayList<>();

        for(int num: nums){
            if(counts.containsKey(num)){
                counts.put(num,counts.get(num)+1);
            }else{
                counts.put(num,0);
            }
        }

        for(Map.Entry<Integer, Integer> entry: counts.entrySet()){
            if(entry.getValue() >= majorityCount){
                result.add(entry.getKey());
            }
        }

        return result;

    }

    public static void main(String[] args){
        int[] nums = {1,2};
        System.out.println(majorityElement3(nums));
    }
}