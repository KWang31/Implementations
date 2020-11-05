import java.io.*; import java.util.*;
public static class A{
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
        int ans=find(p[x],x); p[x]=ans; return ans;
    }
    public static long pow(int x, int p){
      if(p==0)return 1; if(p==1)return x;
      long ans=pow(x,p/2);
      return ((ans*ans)%M*pow(x,p%2))%M;
    }
    */
}
//Debugging:
//Are you sure your algorithm is correct?
//Bounds: long
//Special cases: n=0,1?
//Make sure you remove your debugging code before you submit!
