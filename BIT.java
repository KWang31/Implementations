
import java.io.*;
import java.util.*;

public class BIT {
    static int N;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[N+1]; tree=new int[N+1];
        for (int i = 1; i <=N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            update(i,arr[i]);
        }
        int Q=Integer.parseInt(br.readLine());
        int a,b=0;
        for (int i = 0; i < Q; i++) {
            st=new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken())==1){
                a=Integer.parseInt(st.nextToken());
                b=Integer.parseInt(st.nextToken());
                System.out.println(sum(b)-sum(a));
            }else{
                a=Integer.parseInt(st.nextToken());
                b=Integer.parseInt(st.nextToken());
                update(a,b);
            }
        }
        
    }
    //tree[i]=sum(i-2^{\nu_2(i)}+1,i)
    public static int sum(int i){//This is a consequence of unique expression in base 2
        int ans=0;
        while(i>0){
            ans+=tree[i];
            i-=(i&-i);
        }
        return ans;
    }
    public static void update(int i, int k){//Increment arr[i] by k
        while(i<=N){
            tree[i]+=k;
            i+=(i&-i);// Note (k&-k) is the largest power of 2 dividing k
            //These intervals all contain i
        }
    }
}
