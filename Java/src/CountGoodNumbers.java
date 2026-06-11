public class CountGoodNumbers {
    static final int MOD = 1_000_000_007;

    public static int countGoodNumbers(long n){
        double result = ((Math.pow(5,n/2)) * (Math.pow(4,(n+1)/2))) % MOD;
        return (int) result;
    }
    public static void main(String[] args){
        int len = 50;
        System.out.println(countGoodNumbers(len));

    }

}
