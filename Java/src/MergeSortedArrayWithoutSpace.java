import java.util.Arrays;
import java.util.List;

public class MergeSortedArrayWithoutSpace {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = nums1.length - 1;
        while(k>=0){
            System.out.println(i+" "+j+" "+k);
            if( j>=0 && (i < 0 || nums2[j] > nums1[i]) ){
                nums1[k] = nums2[j];
                k--;j--;
            } else if (j < 0 || nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                k--;i--;
            }else{
                nums1[k] = nums2[j];
                k--;j--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        merge(nums1,m,nums2,n);
    }
}
