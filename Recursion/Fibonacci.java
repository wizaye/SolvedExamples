package Recursion;

public class Fibonacci {
    public static int fibonacci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static int fibonacciNew(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int a=0;
        int b=1;
        for(int i=2;i<=n;i++){
            int temp=a+b;
            a=b;
            b=temp;
        }
        return b;
    }


    public static void main(String[] args) {

        System.out.println(fibonacciNew(1000000007));
    }
    
}
