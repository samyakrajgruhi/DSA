import java.util.*;

public class FirstElementWithUniqueFreq {
    public static int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer> elementMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(elementMap.containsKey(nums[i])){
                elementMap.put(nums[i],elementMap.get(nums[i])+1);
            }else{
                elementMap.put(nums[i],1);
            }
        }

        for(int element: nums){
            int freq = elementMap.get(element);
            if(Collections.frequency(elementMap.values(),freq) == 1){
                return element;

            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {10,10,10,10,20,20,30,30,30,30,30,30};
        System.out.println(firstUniqueFreq(nums));
    }
}
