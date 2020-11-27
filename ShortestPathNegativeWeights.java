import java.io.*; import java.util.*;
public class SPNW{
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
    static int INF=998244353;
    
    public static void main(String[] args){
        FastReader br=new FastReader();
        while(true){
            int N=br.nextInt(); int M=br.nextInt(); int Q=br.nextInt(); int S=br.nextInt();
            if(N==0)return;
            int[][] edges=new int[M][3];//0: src node. 1: dest node. 2: cost
            ArrayList<Integer> adj[]=new ArrayList[N];
            for (int i = 0; i < N; i++) {adj[i]=new ArrayList<>();}
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < 3; j++) {
                    edges[i][j]=br.nextInt();
                }
                adj[edges[i][0]].add(edges[i][1]);
            }
            int[] d=new int[N]; Arrays.fill(d,INF); d[S]=0;
            int[] p=new int[N];//Parent
            Arrays.fill(p,-1);
            int x=0;
            for (int i = 0; i < N; i++) {
                x=-1;
                for (int j = 0; j < M; j++) {
                    if(d[edges[j][0]]<INF){//Graph is directed
                        if(d[edges[j][1]]>d[edges[j][0]]+edges[j][2]){
                            d[edges[j][1]]=d[edges[j][0]]+edges[j][2]; 
                            p[edges[j][1]]=edges[j][0]; x=edges[j][1];
                        }
                    }
                
                }
                
            }
            for(int j=0;j<M;j++){
                if(d[edges[j][0]]<INF){//Graph is directed
                        if(d[edges[j][1]]>d[edges[j][0]]+edges[j][2]){
                            d[edges[j][1]]=-INF; d[edges[j][0]]=-INF;
                            p[edges[j][1]]=edges[j][0]; x=edges[j][1];
                        }
                    }
            }
            Queue<Integer> qu=new LinkedList<>();
            for (int i = 0; i < N; i++) {
                if(d[i]==-INF){
                    qu.add(i);
                }
            }
            while(!qu.isEmpty()){
                int k=qu.poll();
                for (int i : adj[k]) {
                    if(d[i]>-INF){
                        d[i]=-INF; qu.add(i);
                    }
                }
            }
            for (int i = 0; i < Q; i++) {
                int u=br.nextInt();
                if(d[u]==-INF){
                    System.out.println("-Infinity");
                }else if(d[u]==INF){
                    System.out.println("Impossible");
                }else{
                    System.out.println(d[u]);
                }
            }
            System.out.println("");
        }
    }
    
}
//Debugging:
//Are you sure your algorithm is correct?
//Bounds: long
//Special cases: n=0,1?
//Make sure you remove your debugging code before you submit!
