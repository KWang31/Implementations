import java.io.*; import java.util.*;
public class PrintingCycle{
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
    static long INF=(long) 1<<60;
    
    public static void main(String[] args){
            FastReader br=new FastReader();
        
            int N=br.nextInt(); int M=br.nextInt(); 
            if(N==0)return;
            int[][] edges=new int[M][3];//0: src node. 1: dest node. 2: cost
            
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < 3; j++) {
                    edges[i][j]=br.nextInt()-(1-(j+1)/3);
                }
                
            }
            long[] d=new long[N]; 
            int[] p=new int[N];//Parent
            Arrays.fill(p,-1);
            int x=0; 
            
            for (int i = 0; i < N; i++) {
                x=-1; 
                for (int j = 0; j < M; j++) {
                        
                        if(d[edges[j][1]]>d[edges[j][0]]+edges[j][2]){
                            d[edges[j][1]]=d[edges[j][0]]+edges[j][2]; 
                            p[edges[j][1]]=edges[j][0]; x=edges[j][1];
                            
                        }
                        
                }
                
                if(x==-1){
                    System.out.println("NO");return;
                }
            }
            boolean[] vis=new boolean[N];
            ArrayList<Integer> cyc=new ArrayList<>();
            int xx=x;
            
            while(!vis[x]){
                cyc.add(x); vis[x]=true; x=p[x];
            }
            cyc.add(x);
            
            vis=new boolean[N];
            System.out.println("YES");
            for (int i = cyc.size()-1; i >=0; i--) {
                if(!vis[cyc.get(i)]){
                    System.out.print((cyc.get(i)+1)+" ");
                    vis[cyc.get(i)]=true;
                }else{
                    System.out.print((cyc.get(i)+1)+" "); return;
                }
                
            }
    }
    
}
//Debugging:
//Are you sure your algorithm is correct?
//Bounds: long
//Special cases: n=0,1?
//Make sure you remove your debugging code before you submit!
