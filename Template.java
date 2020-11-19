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
    static int MOD=998244353;
    static int[] rk, p;
    public static void main(String[] args){
        FastReader br=new FastReader();
        int N=br.nextInt(); int M=br.nextInt();
        
        //StringBuilder sb=new StringBuilder();
        //System.out.println(sb.toString());
    }
    /*
    Some functions:
     public static void dfs(ArrayList<Integer>[] arl, int cur){//We can use DP here too
       
        for (int i : arl[cur]) {
            
            if(!vis[i]){
               
                vis[i]=true;
                dfs(arl,i);
            }
            
        }
        
    }
    public static int find(int x, int[] p){
        if(p[x]==x)return x;
        int ans=find(p[x],p); p[x]=ans; return ans;
    }
    public static long pow(int x, int p){
      if(p==0)return 1; if(p==1)return x;
      long ans=pow(x,p/2);
      return ((ans*ans)%M*pow(x,p%2))%M;
    }
    public static void merge(int a, int b) {
    	if(rk[a]<rk[b]) {
    		p[a]=b;
    	}else if(rk[a]==rk[b]) {
    		p[a]=b; rk[b]++;
    	}else {
    		p[b]=a;
    	}
    }
    */
}
//Debugging:
//Are you sure your algorithm is correct?
//Bounds: long
//Special cases: n=0,1?
//Make sure you remove your debugging code before you submit!
