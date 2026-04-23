public class FindPivotInteger {
    public static int pivotInteger(int n) {
        int left =1;
        int leftSum =1;
        int right = n;
        int rightSum = n;

        while(left < right){
            System.out.printf("left=%d leftSum=%d right=%d rightSum=%d%n", left, leftSum, right, rightSum);
            if(leftSum < rightSum){
                left++;
                leftSum += left;
            }else if(leftSum > rightSum){
                right--;
                rightSum += right;
            }else{
                left++;
                right--;

                if(left > right){
                    break;
                }

                leftSum += left;
                rightSum += right;
            }
        }

        if(left == right && rightSum == leftSum ){
            return left;
        }

        return -1;

    }

    public static void main(String[] args){
        int n = 49;
        System.out.println(pivotInteger(n));
    }
}
