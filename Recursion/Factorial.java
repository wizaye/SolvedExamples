package Recursion;

public class Factorial {

    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }


    public static void main(String[] args) {
        int n=10;
        // System.out.println(factorial(n));
        long a=1;
        for(int i=1;i<=n;i++){
            long temp=a*i;
            a=temp;
        }
        System.out.println(a);
        
    }
    
}
