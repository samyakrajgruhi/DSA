import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public static ArrayList<Integer> greaterElementGFG(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        stack.push(arr[n-1]);
        ans[n-1] = -1;
        for(int i=n-2; i>= 0; i-- ){
            while(!stack.isEmpty() && arr[i]>stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){

                ans[i] = -1;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);

        }
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<n;i++){
            answer.add(ans[i]);
        }
        return answer;
    }

    public static int[] nextGreaterElementI(int[] nums1, int[] nums2){
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[nums2.length-1]);
        map.put(nums2[nums2.length-1],-1);
        for(int i=nums2.length-2;i>=0;i--){
            while(!stack.isEmpty() && nums2[i] >= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(nums2[i],-1);
            }else{
                map.put(nums2[i],stack.peek());
            }
            stack.push(nums2[i]);
        }

        for(int i=0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
    public static void main(String[] args){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElementI(nums1,nums2)));
    }
}
