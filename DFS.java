import java.io.*; import java.util.*;
public class DFS {

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
    static int[] dp1,dp2;
    static boolean[] vis;
    public static void main(String[] args) {
        FastReader br=new FastReader();
        int N=br.nextInt(); int M=br.nextInt();
        ArrayList<Integer> out[]=new ArrayList[N]; for (int i = 0; i < N; i++) {out[i]=new ArrayList<>();}
        ArrayList<Integer> ing[]=new ArrayList[N]; for (int i = 0; i < N; i++) {ing[i]=new ArrayList<>();}
        int[] in=new int[N];int a,b;
        for (int i = 0; i < M; i++) {
            a=br.nextInt()-1; b=br.nextInt()-1;
            out[a].add(b); in[b]++; ing[b].add(a);
        }
        
        Queue<Integer> qu=new LinkedList<>();
        boolean[] ans=new boolean[N]; int cnt=0;
        for (int i = 0; i < N; i++) {if(in[i]==0){qu.add(i); ans[i]=true; cnt++;}}
        int done=0; 
        while(done<N && !qu.isEmpty()){
            done++;
            a=qu.poll();
            for (int i: out[a]) {
                in[i]--;
                if(in[i]==0){
                    qu.add(i);
                }
            }
        }
        if(done<N){
            System.out.println(-1); return;
        }
        StringBuilder sb=new StringBuilder();
        //The key observation is any x_i that is not comparable to 
        //DFS on indegree graph and outdegree graph separately.
        
        dp1=new int[N]; Arrays.fill(dp1,MOD); vis=new boolean[N];
        int cur=0;
        while(cur<N){
            while(cur<N && vis[cur]){cur++;}
            //BFS!
            if(cur<N){
                vis[cur]=true;
                dfs(out,cur,dp1);
            }
        }
        cur=0; vis=new boolean[N]; dp2=new int[N]; Arrays.fill(dp2,MOD);
        while(cur<N){
            while(cur<N && vis[cur]){cur++;}
            //BFS!
            if(cur<N){
                vis[cur]=true;
                dfs(ing,cur,dp2);
            }
        }
        
        cnt=0;
        for (int i = 0; i < N; i++) {
            if(dp1[i]>=i && dp2[i]>=i){
                sb.append('A'); cnt++; 
            }else{
                sb.append('E');
            }
        }
        System.out.println(cnt);
        System.out.println(sb.toString());
    }
    public static void dfs(ArrayList<Integer>[] arl, int cur, int[] dp){
       
        for (int i : arl[cur]) {
            
            if(!vis[i]){
                dp[i]=Math.min(cur,Math.min(dp[cur],dp[i])); dp[cur]=Math.min(i,Math.min(dp[i],dp[cur]));
                vis[i]=true;
                dfs(arl,i,dp);
            }
            
        }
        
    }
}
//Is my algorithm correct? Any counter-cases?
//Bounds: Overflow, 
//Special cases: n=1, ...
