import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void merge(int[] nums,int low, int mid,int high){
        int left = low;
        int right = mid+1;
        int[] temp = new int[high-low+1];
        int i =0;
        while(left <= mid && right <= high){
            if(nums[left] < nums[right]){
                temp[i] = nums[left];
                i++;
                left++;
            }else{
                temp[i] = nums[right];
                right++;
                i++;
            }
        }

        while(left <= mid){
            temp[i] = nums[left];
            left++;
            i++;
        }
        while(right <= high){
            temp[i] = nums[right];
            right++;
            i++;
        }

        System.arraycopy(temp, 0, nums, 0 + low, temp.length);
    }
    public static void mergeSort(int[] nums,int low, int high){
        if(low >= high){
            return;
        }
        int mid = (low+high)/2;

        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        mergeSort(nums,0,nums.length-1);
        List<List<Integer>> answer = new ArrayList<>();
        for(int i =0; i<nums.length-3;i++){
            if(i >0 && nums[i] == nums[i-1]) continue;
            for(int j= i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = nums.length-1;
                while(left < right){
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        answer.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left <nums.length-1 && nums[left+1] == nums[left]) left++;
                        while(right>0 && nums[right-1] == nums[right]) right --;
                        left++;
                        right--;
                    } else if (sum > target) {
                        while(right>0 && nums[right-1] == nums[right]) right --;
                        right--;
                    } else{
                        while(left <nums.length-1 && nums[left+1] == nums[left] ) left++;
                        left++;
                    }
                }
            }
        }

        return answer;

    }

    static void main(String[] args){
        int[] nums = {2,2,2,2,2};
        System.out.println(fourSum(nums,8));
    }
}
