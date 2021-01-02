import java.io.*; import java.util.*;
public class A{
  static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        
    } 
    public static class Pair implements Comparable<Pair>{
        int vtx; int val;
        public Pair(int a, int b){
            this.vtx=a; this.val=b;
        }
        public int compareTo(Pair other){
            if(this.val<other.val)return -1;
            if(this.val>other.val)return 1;
            if(this.vtx<other.vtx)return -1;
            return 1;
        }
    }
    static int MOD=998244353;
    static int[] rk, p,siz;
    public static void main(String[] args){
        FastReader br=new FastReader();
        int N=br.nextInt(); int M=br.nextInt();
        
        //StringBuilder sb=new StringBuilder();
        //System.out.println(sb.toString());
    }
    
    public static int find(int x, int[] p){
        if(p[x]==x)return x;
        int ans=find(p[x],p); p[x]=ans; return ans;
    }
    
    public static void merge(int a, int b) {
        if(rk[a]<rk[b]) {
            p[a]=b; siz[b]+=siz[a];
        }else if(rk[a]==rk[b]) {
            p[a]=b; rk[b]++;siz[b]+=siz[a];
        }else {
            p[b]=a; siz[a]+=siz[b];
        }
    }
    public static long pow(int b, int e){
        if(e==0)return 1; if(e==1)return b;
        long x=pow(b,e/2); x*=x; x%=MOD; x*=pow(b,e%2); return x%MOD;
    }
  public static void dfs(ArrayList<Integer>[] arl, int cur){
       
        for (int i : arl[cur]) {
            
            
            
        }
        
    }
}
//Debugging:
//Are you sure your algorithm is correct?
//Bounds: long
//Special cases: n=0,1?
//Make sure you remove your debugging code before you submit!
