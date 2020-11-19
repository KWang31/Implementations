//Note: when we copy arrays, avoid = at all costs: use a void instead, see nautilus (BOI19)
public static long[] shift(long[] a, int c){
        int len=a.length; long[] ans=a.clone();
        
        int q=c/64; int r=c%64; 
        if(c%64>0){
            long x=(long) 1<<(64-r);
            for (int i = 0; i < len-q-1; i++) {
                long b=a[i]&(x-1);
                ans[i+q]|=((long) b<<r);
                long d=a[i]>>>(64-r);//3>'s, 2>'s don't work
                ans[i+q+1]|=d;
            }
            if(len-q>0){
                long b=a[len-q-1]&(x-1);
                ans[len-1]|=((long)b<<r);
            }
        }else{
            for (int i = 0; i < len-q; i++) {
                ans[i+q]|=a[i];
            }
        }
        return ans;
    }
