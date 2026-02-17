import java.util.ArrayList;

public class CountReversePairs {
    public static int countPairs(int[] nums,int low,int mid, int high){
        int count = 0;
        int right = mid+1;

        for(int i = low; i<=mid;i++){
            while(right <= high && (long) nums[i] > 2L *nums[right]) right++;
            count += right - (mid+1);
        }
        return count;
    }

    public static void merge(int[] nums,int low, int mid, int high){
        int left = low;
        int right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(left <= mid && right <= high){
            if(nums[left] < nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                right++;
            }
        }

        while(left<=mid){
            temp.add(nums[left]);
            left++;
        }
        while(right<=high){
            temp.add(nums[right]);
            right++;
        }

        for(int i =low; i<=high;i++){
            nums[i] = temp.get(i-low);
        }
    }
    public static int mergeSort(int[] nums,int low,int high){
        int count = 0;
        if(low>=high){
            return count;
        }
        int mid = (low+high)/2;
        count += mergeSort(nums,low,mid);
        count += mergeSort(nums,mid+1,high);
        count += countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return count;
    }
    public static int reversePairs(int[] nums){
        return mergeSort(nums,0,nums.length-1);
    }
    public static void main(String[] args){
        int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        int answer = reversePairs(nums);
        System.out.println("Total number of reverse pairs ="+answer);

    }
}
