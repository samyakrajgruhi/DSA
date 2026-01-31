import java.sql.SQLOutput;

class Pow{
    public static double power(double x, long n){
        if(n==0) return 1.0;
        if(n==1) return x;
        if(n%2==0){
            return power(x*x,n/2);
        }

        return x*power(x,n-1);
    }
    public static double myPow(double x, int n) {
        long N = n;
        System.out.println(n+""+N);
        if(n<0){
            return 1.0/(power(x,-N));
        }

        return power(x,N);
    }

    public static void main(String[] args){
        double number = 4;
        int n = 3;

        System.out.println(myPow(number,n));
    }
}

// x = 4, n = 3
// 4,3 return 64