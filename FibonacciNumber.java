
class Solution {
    public int fib(int n) {
        int n0=0;
        int n1=1;
        int n3=0;
        for(int i=2;i<=n;i++){
            n3=n1+n0;
            n0=n1;
            n1=n3;
        }
        if(n==1||n==2){
            return n1;
        }else{
            return n3;
        }

        
    }
}
