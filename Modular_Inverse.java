public static long inv(long a, long b){//Computes modular inverse of a mod b
        //Assume b>a and gcd(a,b)=1, 
        if(a==1)return 1;
        long q=b/a;
        long r=b-q*a;
        long y=-inv(r,a);
        return ((b*y+1)/a)+b;
        
}
