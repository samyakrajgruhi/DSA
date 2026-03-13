import java.util.Scanner;

public class CodeChefContestStarters229 {
    public static boolean operation1(int[] numbers){
        while(numbers[0] >= 0 && numbers[1] >=0 ){
            numbers[0] -= 1;
            numbers[1] -= 2;
        }
        if(numbers[1]<0 || numbers[0]>0){
            return false;
        }

        return true;
    }

    public static boolean operation2(int[] numbers){
        while(numbers[1] >= 0 && numbers[2] >= 0){
            numbers[1] -= 1;
            numbers[2] -= 3;
        }
        if(numbers[1] < 0 || numbers[2] > 0){
            return false;
        }

        return true;
    }

    public static void check(int[] numbers){
        boolean op1 = operation1(numbers);
        boolean op2 = operation2(numbers);

        if(op1 && op2){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[][] numbers = new int[num][3];

        for(int i=0;i<num;i++){
            for(int j=0;j<3;j++){
                numbers[i][j] = sc.nextInt();
            }
        }


        for(int i=0;i<num;i++){
            check(numbers[i]);
        }

    }
}
